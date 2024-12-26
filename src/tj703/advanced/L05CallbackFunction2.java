package tj703.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClickGameFrame extends JFrame { // 나 자신이 프레임이 되겠다.
   //   JFrame frame = null; 객체를 클래스의  필드로 선언하는 방식

   JButton northBtn;
   JButton southBtn;
   // JButton btn = null; 이렇게 안써도 알아서 null붙음
   JLabel label;


   // class 1 implements ActionListener{} 라고하는 익명클래스가 만들어짐
   public ClickGameFrame() {
      super("클릭게임 프레임"); // 얘는 this는 왜 안되냐, 자신에게 메서드가 없으므로.
      northBtn = new JButton("위쪽 클릭 필요");
      southBtn = new JButton("라벨 초기화 버튼 ");
      label = new JLabel("라벨영역");

      northBtn.addActionListener(new ActionListener() { // new 1() 만들어진 것.
         @Override
         public void actionPerformed(ActionEvent e) {
            String text = label.getText();
            text += "클릭했음";
            label.setText(text);
         }
      });

//      southBtn.addActionListener(new ResetBtnHandler());
      // 자바에서 콜백함수를 정의해서 매개변수를 쓰려면 코드도 길고 복잡하다. => 익명함수 쓰면 되잖아?
      // 그대로 길어. (jvm -> 문법을 달리하는 "코틀린" 언어를 만듬)
      // 자바도 (코드가 심플한)함수형 언어처럼, 매개변수를 함수로 보낼 수 있어!! => 람다식
      // 아래처럼...
      southBtn.addActionListener(
            (e) -> {
               label.setText("");
            }
      );

      this.add(northBtn, BorderLayout.NORTH);
      this.add(southBtn, BorderLayout.SOUTH);
      this.add(label, BorderLayout.CENTER);
      this.setSize(400, 400); // 얘는 왜 super도 되고, this가 되냐. 없으면 부모꺼에서 찾으니까.
      this.setLocation(500, 500);

      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   class ResetBtnHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         label.setText("초기화");
      }
   }
}

public class L05CallbackFunction2 {
   public static void main(String[] args) {
      new ClickGameFrame(); // 여기서 객체를 만들자마자, 화면에 바로 뜨게 만들어보자.
   }
}
