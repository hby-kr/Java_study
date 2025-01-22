package tj703.advanced;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

public class L02AnonymousClass {
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

//l03은 l02 더 쉽게 복습

/*
java로 코딩을 할 때 익명함수를 써야하는 경우는???

1. . 짧은 함수 정의가 필요할 때
익명 함수는 작은, 즉시 사용할 함수를 정의할 때 유용합니다. 예를 들어, 한 번만 사용할 간단한 함수가 필요할 때

2. 콜백이나 이벤트 처리 시
Java에서 이벤트 리스너나 콜백을 정의할 때 익명 클래스를 많이 사용합니다. 예를 들어, GUI 프로그램에서 버튼 클릭이나 사용자 이벤트를 처리할 때

3. Functional Interface와 함께 사용할 때 (Java 8 이상의 경우)
Java 8부터는 람다 표현식(lambda expression)을 사용하여 익명 함수의 형태로 코드를 작성할 수 있습니다. Runnable, Comparator, Predicate 등과 같은 함수형 인터페이스를 사용할 때

4. 특정 기능을 가진 객체가 일회성으로 필요한 경우
특정 기능을 가진 객체를 한 번만 사용하고, 그 객체를 재사용하지 않을 경우
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.forEach(name -> System.out.println(name));
위의 예시에서 forEach 메서드에 전달된 name -> System.out.println(name)은 간단한 익명 함수입니다.

5. 추상 클래스나 인터페이스 구현 시
인터페이스나 추상 클래스를 구현하는 클래스가 한 번만 사용되거나 매우 간단할 때,


ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

람다식을 사용하면 Functional Interface를 구현할 때 익명 클래스를 사용하는 대신
간단한 문법으로 함수형 프로그래밍 스타일을 적용할 수 있습니다.
 == 매개변수로 함수(메서드) 넣을 수 있음.

(매개변수1, 매개변수2, ...) -> { 실행할 코드 }







 */
}