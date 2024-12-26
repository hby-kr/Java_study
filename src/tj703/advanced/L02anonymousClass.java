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
         // 이들은 미완성된 클래스이고 내부에 구현이 덜 된(설정값을 다 설정하지 않은 상태) 추상메서드가 있다.
         // 그 결과 오류가 나기 때문에 직접 객체가 되어 인스턴스를 생성할 수 없는 것.

         //    1) implements, extends : 추상 클래스와 인터페이스는 직접 인스턴스를 만들 수 없지만, 구체적인 클래스를 통해 객체를 생성할 수 있습니다.
         //    2) 인터페이스의 경우 람다 표현식을 사용하여 객체를 간단하게 만들 수 있습니다 (단, 함수형 인터페이스일 경우).
         //    3) 익명 클래스는 또 다른 방법으로 객체를 생성할 수 있지만, 람다 표현식이 더 간결하고 현대적인 방식입니다.

         // new AbstractClass(){};   // new Interface(){};
         // 익명의 클래스를 만들어 그것을 구현하는 클래스를 객체로 생성하겠다.는 것
         // 컴파일러가 (컴파일시점에) 자동으로 숫자로 된(01,02,03..) 익명클래스를 만듬.
         // 추상클래스와 인터페이스가 인스턴스를 만들 수 있게(직접 만드는 것처럼 보이게) 한다.
      };
      // 자주 쓰는 경우는 클래스 만들고 정의해서, 정식으로 인스턴스 객체 만들어서 사용.
      // 한번만 쓰고 말거면 익명클래스 사용. 익명클래스 만들고 그 자리에서 바로 메서드 만들어서 곧장 사용.
      // 메소드를 매개변수로 작성하기 위해 클래스를 매번 정의할 필요가 없는 장점.
      // 그러나 자주 사용할 것은 정식으로 클래스에 작성하고 재사용하는 것이 생산성을 높임.

      frame.addWindowListener(windowHandler);
      // frame.addWindowListener( (e)-> {} ); // 람다식.

   }
}
//l03은 l02 더 쉽게 복습