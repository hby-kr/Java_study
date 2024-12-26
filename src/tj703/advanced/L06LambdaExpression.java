package tj703.advanced;

import java.awt.event.ActionListener;
import java.util.function.Function;

/*
람다식이란?
// 함수를 타입(객체)처럼 사용하는 척하는 문법적 설탕 (함수형언어에 비해 java의 코드가 길다는 비난에 대한 대안)
// Runnable fun () => {} ;
// Runnable이라는 타입

람다식은 **익명 함수(Anonymous Function)**로, 이름 없는 메서드를 간단히 표현하는 방법입니다.
주로 인터페이스의 메서드를 구현하는데 사용되며, 함수형 인터페이스(functional interface)에서 사용할 수 있습니다.

함수형 인터페이스
함수형 인터페이스란, 하나의 추상 메서드만 가진 인터페이스를 의미합니다. 람다식은 반드시 함수형 인터페이스를 구현해야 하며, 이를 통해 메서드를 간단히 구현할 수 있습니다.

 */
public class L06LambdaExpression {

   public static void main(String[] args) {

      // Runnable fun = ()=> {};
      // Function<Integer, Integer> fun2 (a) -> {return a*10};
      //<Integer, Integer>  제네릭이라는 것. 앞은 매개변수의 타입, 뒤는 return의 타입
      // fun2 =(a)-> a*10;  // body{}를 생략하면, 자동으로 return. 즉 {return ... }이 생략되는 것
   }

/*  ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
  Runnable task = new Runnable() {
    @Override
    public void run() {
        System.out.println("Task is running...");
    }
};
ㅡㅡㅡㅡㅡㅡ위아래는 같은 코드
   fun = ()->{
      System.out.println("안녕 람다식");
   }

 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */


   // 함수를 객체로 만드는 것이 아니라, 위의 코드를 자동완성하는 것 뿐. 문법적 설탕.
   // 람다식은 익명함수로 만들어진 객체임...
   ActionListener fun3 =(e )-> {};



   // 람다식에서 잘쓰려면, 람다식의 타입종류, 인터페이스를 좀 외워야 함.
   // 스트림할 때..
   // Java의 Stream API와 함께 람다식을 사용하면, 데이터를 처리하는 코드가 훨씬 간결해집니다.

   /*
   람다식을 도입한 이유
   함수형 프로그래밍을 지원하기 위해: Java 8은 람다식을 통해 함수형 프로그래밍 패러다임을 채택하여, 코드의 간결성과 재사용성을 향상시켰습니다.
   익명 클래스의 복잡성 해소: 람다식을 사용하면 익명 클래스를 사용할 필요가 없어져 코드가 간결해지고, 가독성이 높아집니다.
   병렬 처리와 멀티코어 환경 최적화: 람다식은 Stream API와 함께 병렬 처리를 손쉽게 할 수 있게 해줍니다.
   기존 코드와의 호환성 유지: 객체지향 프로그래밍을 기반으로 하면서 함수형 프로그래밍을 도입하여, 두 패러다임을 잘 결합할 수 있습니다.
    */
}
