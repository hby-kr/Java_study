package com.tj703.employees.swing;

import com.tj703.employees.dao.DepartmentsDao;
import com.tj703.employees.dao.DepartmentsDaoImp;
import com.tj703.employees.dto.DepartmentsDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


// 테이블을 만드는 코드
public class DeptTable extends JFrame {

    // Jtable을 하기 위한 기본 필드 세팅중 / 필드 선언
    private JTable table; // JTable
    private JScrollPane scrollPane; // 스크롤을 추가할 JScrollPane
    private JPanel panel; // JPanel (컨테이너)

    private String[] columns;
    private String[][] data;

    private JButton addBtn;
    private JButton refreshBtn;
    private JPanel btnP; // 버튼을 넣을 공간

    public DeptTable() {
        super("부서테이블"); // JFrame 타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300); // 크기 설정

        refreshTable(); // 저 아래 따로 만듬. 반복해서 쓸라고.


        // 버튼(이 들어간 패널) 추가
        addBtn = new JButton("부서등록");
        refreshBtn = new JButton("새로고침");
        btnP = new JPanel();

        // 버튼 패널에 넣기 전에 onclick 메서드 설정하기
        refreshBtn.addActionListener((e)->{
            // 람다식 문법. 새로고침 메서드(함수)를 매개변수로 넣는 방법.
            refreshTable();  // 얘를 꼭 보고 올 것.
        });

        // 버튼 패널에 넣기 전에 onclick 메서드 설정하기
        addBtn.addActionListener((e)->{
           new DeptCrudDialog();
        });

        btnP.add(refreshBtn);
        btnP.add(addBtn);
        this.add(btnP, BorderLayout.SOUTH); // Jframe이 this임

        setVisible(true); // JFrame을 화면에 표시
    }


    // 새로고침 만들면 테이블이 refresh 되는 것을 재호출하려고, 일단 따로 분리해서 작업함
    public void refreshTable() {

        // Jtable 관련
        columns = new String[]{"부서번호", "부서이름"};
        // 변수를 선언하면서 함께(12번 줄에서) 배열을 바로 선언하는 것이 아니면, 그 다음은 new 연산자를 써야한다

        // DepartmentsDao 객체를 사용하여 데이터베이스에서 부서 정보를 조회하고, 해당 데이터를 data 배열에 채우는 과정
        DepartmentsDao dao = null;
        try {
            dao = new DepartmentsDaoImp(); // DepartmentsDao 객체를 생성
            List<DepartmentsDto> deptList = dao.findAll();
            // 자바에서 List에 다른 List<String>(==DepartmentsDto)를 요소로 넣은 구조. list 안에 다시 list 가능
            // deptList는 DB에서 조회한 부서 정보를 담고 있는 리스트
            // dao.findAll()을 호출하여 부서 정보를 반환받고, 반환된 부서 리스트를 data 배열에 저장
            int rowSize = deptList.size(); // 부서 리스트의 크기 (행의 개수)
            data = new String[rowSize][columns.length];  // String[][] data
            // 행(row)의 개수는 deptList의 크기, 열(column)의 개수는 columns의 길이

            // 부서 정보를 data 배열에 채우는 부분
            for (int i = 0; i < data.length; i++) { // data 배열의 각 행에 부서 정보를 넣음
                String arr[] = data[i]; // data 배열의 한 행을 가져옴
                DepartmentsDto dept = deptList.get(i); // deptList에서 해당 인덱스의 부서 정보를 가져옴
                arr[0] = dept.getDeptNo(); // 부서 번호를 첫 번째 열에 넣음
                arr[1] = dept.getDeptName(); // 부서 이름을 두 번째 열에 넣음
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 에러 출력
        } finally {
            if (dao != null) dao.close(); // dao 객체를 닫음
        }

        // data 배열에 저장된 내용을 출력 (디버깅용)
        for (String arr[] : data) { // data 배열의 각 행을 출력
            for (String str : arr) { // 각 행의 각 열을 출력
                System.out.print(str + ","); // 열 값을 출력
            }
            System.out.println(); // 한 행을 출력한 후 줄바꿈
        }

        if (panel != null) this.remove(panel); // 다시 추가하려면 기존 패널을 삭제해야, 다음패널을 추가할 수 있다.
        // JTable 생성 및 설정
        table = new JTable(data, columns); // JTable을 생성하며, data 배열과 columns 배열을 이용하여 테이블 구성

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Object target = e.getSource(); // == js의 target // source가 뭔지 모르니까 Object로 타입설정
                // JTable table = (JTable) target; // 랩핑 형변환 = 캐스팅 형변환

                int row = table.getSelectedRow();// 누를 열을 숫자로 반환
                String deptNo = table.getValueAt(row, 0).toString();
                String deptName = table.getValueAt(row, 1).toString();
                // System.out.println(deptNo+","+deptName); / 잘되나 확인

                // new DeptCrudDialog();  // 얘는 등록 Dialog
                new DeptCrudDialog(deptNo, deptName); // 수정 Dialog

            }
        });


        scrollPane = new JScrollPane(table); // JTable을 스크롤 가능한 JScrollPane에 넣음
        panel = new JPanel(); // JPanel을 생성
        panel.add(scrollPane); // JScrollPane을 JPanel에 추가
        this.add(panel); // JFrame에 JPanel을 추가

        // 재랜더링, 다시 그래픽으로 출력함
        this.revalidate();
        this.repaint();
    }


    // 경고창 뜨는 도구, 그리고 거기에 새로 입력할 수 있게 할 거임.
    class DeptCrudDialog extends JDialog {
        private JTextField txtDeptNo; // ==input
        private JTextField txtDeptName;
        private JLabel lbDeptNo;
        private JLabel lbDeptName;
        private JButton btnAdd;
        private JPanel panel;

        private JButton updateBtn;
        private JButton deleteBtn;
        private JPanel btnP;

        // 생성하기
        public DeptCrudDialog() {
            super(DeptTable.this, "부서등록 Dialog");
            // Dialog는 부모가 필요함
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(600, 100, 250, 150);

            lbDeptNo = new JLabel("부서번호");
            lbDeptName = new JLabel("부서이름");
            txtDeptNo = new JTextField();
            txtDeptName = new JTextField();
            btnAdd = new JButton("부서등록");
            // 버튼 메서드 재정의
            btnAdd.addActionListener((e)->{
                // 람다식으로 쓰면 JS처럼 this 바인딩이 안된다.
               try {
                   DepartmentsDao dao = new DepartmentsDaoImp();
                   DepartmentsDto dept = new DepartmentsDto();
                   dept.setDeptNo(txtDeptNo.getText());
                   dept.setDeptName(txtDeptName.getText());
                   int create = dao.create(dept);
                   if (create >0) { // 성공하면 1 뜬다.
                       System.out.println("등록성공");
                       DeptTable.this.refreshTable();
                       DeptCrudDialog.this.setVisible(false); // 이 때 this는 Dialog
                       DeptCrudDialog.this.dispose();
                   }
               }
               catch (Exception ex) {
                   ex.printStackTrace();
               }
            });

            panel = new JPanel();
            // 그리드 만들고..
            panel.setLayout(new GridLayout(2, 2));
            // 순서대로 넣기
            panel.add(lbDeptNo);
            panel.add(txtDeptNo);
            panel.add(lbDeptName);
            panel.add(txtDeptName);

            this.add(panel); // this가 dialog
            this.add(btnAdd, BorderLayout.SOUTH);

            setVisible(true);

        }

        // 수정하고 삭제하기
        // 생성자 오버로딩 / 이름은 같으나, 매개변수가 다른 것 / 다형성
        public DeptCrudDialog(String deptNo, String deptName) {
            super(DeptTable.this, "부서등록 Dialog");
            // Dialog는 부모가 필요함
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(600, 100, 250, 150);

            lbDeptNo = new JLabel("부서번호");
            lbDeptName = new JLabel("부서이름");

            txtDeptNo = new JTextField();
            txtDeptNo.setText(deptNo);
            txtDeptName = new JTextField();
            txtDeptName.setText(deptName);

            deleteBtn = new JButton("부서삭제");
            updateBtn = new JButton("부서수정");

            // 버튼의 메서드 재정의
            deleteBtn.addActionListener((e)->{
                try {
                    DepartmentsDao dao = new DepartmentsDaoImp();
                    int delete = dao.delete(deptNo);
                    if (delete > 0) {
                        DeptCrudDialog.this.setVisible(false);
                        DeptTable.this.refreshTable();
                        DeptCrudDialog.this.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            // 버튼의 메서드 재정의]
            updateBtn.addActionListener((e)->{
                try {
                    DepartmentsDto dto = new DepartmentsDto();
                    dto.setDeptNo(deptNo);
                    dto.setDeptName(txtDeptName.getText());

                    DepartmentsDao dao = new DepartmentsDaoImp();
                    int update = dao.update(dto);
                    if (update > 0) {
                        DeptCrudDialog.this.setVisible(false);
                        DeptTable.this.refreshTable();
                        DeptCrudDialog.this.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            });


            btnP = new JPanel();
            btnP.add(updateBtn);
            btnP.add(deleteBtn);

            panel = new JPanel();
            // 그리드 만들고..
            panel.setLayout(new GridLayout(2, 2));
            // 순서대로 넣기
            panel.add(lbDeptNo);
            panel.add(txtDeptNo);
            panel.add(lbDeptName);
            panel.add(txtDeptName);

            this.add(panel); // this가 dialog
            this.add(btnP, BorderLayout.SOUTH);

            setVisible(true);

        }
    }


    public static void main(String[] args) { // 테스트 하기위한 메인. TDD, Test Driven Development
        new DeptTable();

    }
}
