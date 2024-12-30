package tj703.advanced;

import javax.swing.*;
import java.awt.event.WindowListener;

public class L14advancedStudy {

   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.setBounds(500,500,300,300);
      frame.setVisible(true);


      //frame.addWindowListener((e)->{}); // eventlistener 같은 것.
      // 그 이벤트가 발생했을 때, 콜백함수를 재정의할 수 있음
      // 그런데 오류. 왜 람다식은 콜백함수가 하나일 때만 가능하나, addWindowListener가 콜백함수가 여러개이므로.

   }
}
