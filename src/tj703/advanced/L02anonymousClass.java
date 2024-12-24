package tj703.advanced;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.net.InterfaceAddress;

public class L02anonymousClass {
   public static void main(String[] args) {

      Frame frame = new Frame("익명클래스");

      WindowListener windowHandler = new WindowAdapter() {
         // WindowListener는 interface야.
         // AbstractClass(추상 클래스)와 Interface(인터페이스)는 직접 인스턴스를 생성할 수 없습니다.
         //    1) implements, extends : 추상 클래스와 인터페이스는 직접 인스턴스를 만들 수 없지만, 구체적인 클래스를 통해 객체를 생성할 수 있습니다.
         //    2) 인터페이스의 경우 람다 표현식을 사용하여 객체를 간단하게 만들 수 있습니다 (단, 함수형 인터페이스일 경우).
         //    3) 익명 클래스는 또 다른 방법으로 객체를 생성할 수 있지만, 람다 표현식이 더 간결하고 현대적인 방식입니다.

         // new AbstractClass(){};   // new Interface(){};
         // 익명의 클래스를 만들어 그것을 구현하는 클래스를 객체로 생성하겠다.는 것
      };

      frame.addWindowListener(windowHandler);
      // frame.addWindowListener( (e)-> {} ); // 람다식.

   }ㅍ
}
