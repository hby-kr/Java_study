package tj703.advanced;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class L01Awt {
/*
Java의 AWT (Abstract Window Toolkit)는 그래픽 사용자 인터페이스(GUI)를 개발할 때 사용하는 라이브러리입니다.
AWT는 다양한 UI 컴포넌트, 레이아웃 관리, 그리고 이벤트 처리를 위한 클래스들을 제공합니다.
현재는 Swing이나 JavaFX와 같은 더 현대적인 GUI 라이브러리들이 선호되는 경우가 많습니다.
하지만 AWT는 여전히 Java GUI 개발의 기초적인 개념을 이해하는 데 유용합니다.

[탄생배경]
java가 처음 만들어질 때 window os가 신상인 시절..
ms회사에서 창을 생성하는 객체명세서를 줬는데, 너무 어렵고 구현하기 어려웠음
GUI 잡스가 처음 만들고 서비스하려던 중(개발자에게 gui 개선을 요구)=> 마이크로소프트로 대거 이직
window 를 빠르게 만들어서 서비스해버림 => 객체가 조잡하고 구현하기 힘들어짐
Apple Window 가 창을 구현하기 위해 사용하는 언어와 객체가 완전히 달라서 => 낮은 생산성
java -> awt frame 사용하면 window, mac 도 창을 만들 수 있게 제공 => 대박!

 */

   class WindowHandler extends WindowAdapter {
      @Override
      public void windowClosing(WindowEvent e) {
         // x버튼을 누를 때 콜백함수
         System.exit(0); // JVM을 실행하는 콘솔을 종료해라.
      }
   }

   public static void main(String[] args) {
      L01Awt o = new L01Awt();
      Frame frame = new Frame("자바의 GUI AWT");
      frame.addWindowListener(o.new WindowHandler());
      //    ==  btn.addEventlistiner("click", function(e){})
      // 그런데 java는 (객체지향언어라서) 함수를 매개변수로 쓸 수 없어서(==객체만 매개변수로 쓸 수 있어서)
      // 23번재 줄처처럼 클래스 만들고, extends하고, 클래스의 인스턴스 객체를 매개변수로 넣은 것.

      // java문법에서 '함수'란 개념적으로는 없고, 함수라고 불리는 것이 보통 클래스 안에 속한 "메서드"에 해당한다.
      // "함수"처럼 특정 작업을 수행하는 코드 블록을 "메서드"라고 부릅니다.

      frame.setSize(200, 300); // px
      frame.setLocationRelativeTo(null); // 모니터를 기준으로 중간에 위치
      frame.setVisible(true); // 윈도우가 모니터의 출력이 되는가.

   }
}


/*
AWT의 주요 개념을 쉽게 설명하자면:
1. 구성요소 = 컴포넌트 (Component)
   AWT에서는 버튼, 레이블, 텍스트 필드, 체크박스 등 다양한 컴포넌트를 제공합니다. 이들은 사용자와 상호작용할 수 있는 GUI 요소입니다.
   예를 들어, Button, Label, TextField 같은 클래스를 사용하여 화면에 요소를 추가할 수 있습니다.

2. 컨테이너 (Container)
   AWT 컴포넌트를 담을 수 있는 "컨테이너"가 필요합니다. 컨테이너는 다른 컴포넌트를 포함할 수 있는 공간 역할을 합니다.
   예를 들어, Frame, Panel, Window 등이 컨테이너입니다. Frame은 일반적으로 하나의 응용 프로그램 창을 나타냅니다.

3. 레이아웃 관리자 (Layout Manager)
   GUI 컴포넌트들을 화면에 어떻게 배치할지 결정하는 방법을 제공합니다. 레이아웃 관리자는 여러 컴포넌트를 적절한 위치에 배치하는 데 도움을 줍니다.
   예를 들어, FlowLayout, GridLayout, BorderLayout 같은 레이아웃 관리자들이 있습니다.

4. 이벤트 처리 (Event Handling)
   사용자가 버튼을 클릭하거나 텍스트를 입력하는 등의 행동을 했을 때 발생하는 이벤트를 처리하는 방법입니다.
   AWT는 이벤트 리스너를 사용하여 이벤트를 감지하고 이에 대응하는 코드를 작성할 수 있게 합니다.

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

1. 윈도우 관련 클래스
Frame
      setTitle(String title) : 프레임의 제목을 설정합니다.
      setSize(int width, int height) : 프레임의 크기를 설정합니다.
      setVisible(boolean b) : 프레임을 보이게 하거나 숨깁니다.
      addWindowListener(WindowListener l) : 윈도우 이벤트 리스너를 추가합니다.
Window
      setSize(int width, int height) : 윈도우 크기를 설정합니다.
      setLocation(int x, int y) : 윈도우의 위치를 설정합니다.
Dialog
      setTitle(String title) : 대화 상자의 제목을 설정합니다.
      setVisible(boolean b) : 대화 상자를 보이게 하거나 숨깁니다.


2. 컴포넌트 관련 클래스

Button
      setLabel(String label) : 버튼의 레이블을 설정합니다.
      addActionListener(ActionListener l) : 버튼에 클릭 이벤트를 리스닝합니다.

Label
      setText(String text) : 레이블의 텍스트를 설정합니다.

TextField
      setText(String text) : 텍스트 필드의 텍스트를 설정합니다.
      getText() : 텍스트 필드에 입력된 텍스트를 가져옵니다.
      addTextListener(TextListener l) : 텍스트 변경 이벤트를 리스닝합니다.

TextArea
      setText(String text) : 텍스트 영역에 텍스트를 설정합니다.
      getText() : 텍스트 영역의 텍스트를 가져옵니다.
      append(String str) : 텍스트 영역에 텍스트를 추가합니다.

CheckBox
      setState(boolean b) : 체크박스의 상태를 설정합니다.
      getState() : 체크박스의 상태를 가져옵니다.

Choice
      add(String item) : 항목을 추가합니다.
      getSelectedItem() : 선택된 항목을 가져옵니다.


3. 레이아웃 관련 클래스

FlowLayout
      setAlignment(int alignment) : 항목의 정렬을 설정합니다.
      setHgap(int hgap) : 항목 간의 수평 간격을 설정합니다.
      setVgap(int vgap) : 항목 간의 수직 간격을 설정합니다.

GridLayout
      setRows(int rows) : 그리드의 행 수를 설정합니다.
      setColumns(int columns) : 그리드의 열 수를 설정합니다.

BorderLayout
      add(Component comp, String position) : 컴포넌트를 특정 위치에 추가합니다.

CardLayout
      next(Container parent) : 다음 카드를 표시합니다.
      previous(Container parent) : 이전 카드를 표시합니다.


4. 이벤트 관련 메서드

ActionListener
      actionPerformed(ActionEvent e) : 버튼 클릭과 같은 액션 이벤트가 발생했을 때 호출되는 메서드입니다.

WindowListener
      windowOpened(WindowEvent e) : 윈도우가 열렸을 때 호출됩니다.
      windowClosing(WindowEvent e) : 윈도우가 닫히려고 할 때 호출됩니다.
      windowClosed(WindowEvent e) : 윈도우가 닫혔을 때 호출됩니다.
      windowActivated(WindowEvent e) : 윈도우가 활성화되었을 때 호출됩니다.
      windowDeactivated(WindowEvent e) : 윈도우가 비활성화되었을 때 호출됩니다.

TextListener
      textValueChanged(TextEvent e) : 텍스트 필드나 텍스트 영역에서 텍스트 값이 변경될 때 호출됩니다.

ItemListener
      itemStateChanged(ItemEvent e) : 체크박스나 라디오 버튼의 상태가 변경될 때 호출됩니다.


5. 그래픽 관련 클래스

Graphics
      drawLine(int x1, int y1, int x2, int y2) : 선을 그립니다.
      drawRect(int x, int y, int width, int height) : 직사각형을 그립니다.
      drawOval(int x, int y, int width, int height) : 타원을 그립니다.
      setColor(Color c) : 그리기 색상을 설정합니다.
Color
      Color(int r, int g, int b) : RGB 값으로 색을 생성합니다.
      Color.RED, Color.GREEN, Color.BLUE : 기본 색상 상수들.


6. 윈도우와 컴포넌트 추가 관련 메서드
   add(Component comp) : 컨테이너에 컴포넌트를 추가합니다.
   remove(Component comp) : 컨테이너에서 컴포넌트를 제거합니다.


*/