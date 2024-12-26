package tj703.advanced;
//l03은 l02 더 쉽게 복습. 그래서 따로 안 적음.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

/*
class CallbackBtn {
   class Event {
   }

   public void click() {
      this.onclick(new Event());
   }

   public void onclick(Event e) {
   }

   public void addEventListener(String event, Function callbackfunc) {
   }
// js의 button요소의 타입을 흉내내봤음.
}
*/


public class L04CallbackFunction {
   static JFrame frame=null;
   static JButton btn=null;
   static JLabel label=null;
   // static class라고 쓰는 것은 정적 중첩 클래스다.
   static class BtnHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         label.setText(label.getText()+"클릭");
      }
   }
   // main 완전히 다른영역 => 클래스의 필드를 사용하려면 인스턴스화(객체생성)
   // but static을 사용하면 해결됨
   // static: 필드와 상관없이 미리 메모리에 저장해놓는 것. 인스턴스객체를 만들지 않고, 접근할 수 있음.
   // static class : 정적 중첩 클래스다. 외부의 클래스와 별개로 인스턴스화 가능.


   public static void main(String[] args) {
      // 콜백함수 : 정의해놓으면 바로 실행하지 않고, 호출될 때만 실행하는 메서드
      // == 콜백 함수는 다른 함수나 메서드의 인자로 전달되어, 나중에 호출되는 함수 또는 메서드를 의미.
      // (사실, Java에서는 "함수"라는 용어보다는 "메서드"라는 용어를 사용하므로, 콜백도 메서드를 사용한 방식으로 구현됩니다.)

      // [js = 함수형 언어]
      // btn.onclick= function(e){};  / 이벤트를 콜백함수로 재정의.
      // 함수 필드를 다른함수로 교체가능(함수형 언어의 특징)
      // js btn.addEventListener("click",function(e){})
      // 함수의 매개변수로 함수를 작성가능 (함수형 언어의 특징 => 함수가 타입이기 때문)


      // cf. 객체지향언어 자바는 메서드 필드의 교차가 불가능하고 매개변수로 함수를 작성하는 것도 불가능 하다.

      // btn.onclick = function(){}; 자바에서 객체의 필드에 메서드(함수)로 재정의하는 것은 불가능함. (인스턴스 객체의 변수 값을 재정의 하는 것은 가능한데)

      /*

// 1. JFrame 생성 및 설정
      JFrame frame=new JFrame("콜백함수의 이해");
      //frame.setSize(300,300);
      frame.setBounds(500,1500,300,300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 2. JButton 생성 및 추가
      JButton btn=new JButton("버튼입니다.");
      //<html><p id="container"><button></></></>
      //container.append(btn);
      frame.add(btn, BorderLayout.SOUTH); //add(Component c)
      //상수(바뀌지 않는 수)의 개념 : 저장된 정보를 호출하기 위해 사용됨
// 3. JLabel 생성 및 추가
      JLabel label=new JLabel("나는 라벨입니다.");
      frame.add(label);
// 4. 버튼 클릭 시 이벤트 처리 (ActionListener 사용)
      btn.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            String txt=label.getText();
            txt+="\n클릭";
            label.setText(txt);
         }
      }); //Action==click
      //인스턴스 == 객체
// 5. 프레임 표시
      frame.setVisible(true);

   //이 코드는 JFrame을 사용하여 GUI를 만들고, 버튼을 클릭할 때마다 라벨에 "클릭"이라는 텍스트가 추가되도록 이벤트를 처리하는 예제입니다. 이 코드는 다음과 같은 흐름으로 동작합니다:
      //JFrame에 버튼과 라벨을 배치합니다.
      //버튼에 클릭 이벤트를 설정하여, 클릭 시 라벨의 텍스트가 변경되도록 합니다.
      //라벨의 텍스트는 클릭할 때마다 추가되는 형식으로 갱신됩니다.

       */


      // 방법2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡ 위에서 inner클래스로 작업하고 내려와서 작성한거임.
/*
      L04CallbackFunction o=new L04CallbackFunction();
      o.frame=new JFrame("콜백함수의 이해");
      o.frame.setBounds(500,1500,300,300);
      o.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      o.btn=new JButton("버튼입니다.");
      o.btn.addActionListener(o.new BtnHandler());
      o.frame.add(o.btn, BorderLayout.SOUTH);
      o.label=new JLabel("나는 라벨입니다.");
      o.frame.add(o.label);
      o.frame.setVisible(true);
 */

      // 방법3  ㅡㅡㅡㅡㅡㅡㅡㅡㅡ + static 써서 코드하기.
      frame=new JFrame("콜백함수의 이해");
      frame.setBounds(500,500,300,300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      btn=new JButton("버튼입니다.");
      btn.addActionListener(new BtnHandler());
      //btn.addActionListener(new L04CallbackFunction.new BtnHandler()); 와 같은 것.
      frame.add(btn, BorderLayout.SOUTH);
      label=new JLabel("나는 라벨입니다.");
      frame.add(label);
      frame.setVisible(true);


   }


}
