package tj703.study;

// interface는 설계도, 엉성한 틀, 추상적인 대분류, 명세서 /  추상 메서드만 가능
// abstract class는 뼈대 정도 / 메서드와 추상메서드를 모두 작성가능(both)
// class는 디자인된 건물 / 메서드만 가능

// 인터페이스는 주로 "무엇을 해야 하는지"를 정의하고,
// 추상 클래스는 그 무엇들을 "어떻게 해야 하는지"를 부분적으로 정의한다고 생각할 수 있습니다.

// 인터페이스와 추상클래스를 사용하면, 공통된 코드를 재사용 및 구현하기에 용이 (추상화와 객체지향 문법)

/*
>> 핸드폰 앱에서 여러 리모콘을 조작할 때,
 인터페이스는 리모콘의 공통된 기능을 정의하고, 추상 클래스는 리모콘의 공통된 상태나 기본 동작을 정의하는 데 사용됩니다.

- 인터페이스는 리모콘에서 공통적으로 구현해야 할 기능을 정의합니다. 다양한 리모콘이 같은 방식으로 기능을 구현할 수 있도록 강제하고, 각 리모콘은 이 인터페이스를 자유롭게 구현할 수 있습니다.

- 추상 클래스는 공통적인 상태와 기본적인 동작을 관리합니다. 예를 들어, 리모콘에서 관리해야 할 볼륨과 채널을 상태로 관리하고, 일부 기본 기능을 구현하며, 나머지 기능을 자식 클래스에서 구체적으로 구현할 수 있도록 합니다.
 */


import java.util.Scanner;

abstract class AbstractRemotecon implements RemoteControl {
   // 자동생성으로 메서드 구현하기!

   /**
    * 전원버튼
    */
   @Override
   public void powerBtn() {
      System.out.println("전원 들어옴");
   }

   /**
    */
   @Override
   public int arrowBtn(String arrow) {
      System.out.println("방향키 눌림");
      return 0;
   }

   // 공통된 것을 먼저 구현하고, 추상클래스를 상속받는 클래스들마다 세부적인 차이들을 구현하라고 강제할 수 있음.
   abstract void smartBtn();

}

class SamsungRemotecon extends AbstractRemotecon {
   public void smartBtn() {
      System.out.println("삼성 tv");
   }
}

class LgRemotecon extends AbstractRemotecon {
   public void smartBtn() {
      System.out.println("엘지 tv");
   }
}

class AppleRemotecon extends AbstractRemotecon {
   public void smartBtn() {
      System.out.println("애플 tv");
   }
}


public class L26AbstractClass {
   public static void main(String[] args) {

      //RemoteControl remotecon2 = new RemoteControl() {         };
      // 추상클래스와 인터페이스는 둘다 추상메서드를 포함하는 설계도이기 때문에 객체가 될 수 없다.
      // 추상메서드가 없는 class만 객체가 될 수 있다.

//      AbstractRemotecon remotecon = new AbstractRemotecon() {               };
      // 위가 오류나지 않는 이유는, 익명 클래스(anonymous class) 를 사용하는 형태로, 추상 클래스의 객체를 직접 만들지 않고 익명 클래스를 통해 인스턴스를 생성하는 방법입니다.
      // 이 방식은 추상 클래스를 직접 인스턴스화하지 않고, 그 추상 클래스를 상속한 익명 클래스를 정의하여 객체를 생성하는 방법입니다. 이 방식에서는 추상 클래스의 추상 메서드를 구현해야 하므로 오류가 발생하지 않습니다.

//      ㅡㅡㅡㅡㅡㅡㅡㅡ

      // 여기 main 어플의 공간은, (예를 들어) 삼성, 엘지, 애플 리모콘을 핸드폰으로 조작하는 어플이라고 할 때,

      SamsungRemotecon samsungRemotecon = new SamsungRemotecon();
      LgRemotecon lgRemotecon = new LgRemotecon();
      AppleRemotecon appleRemotecon = new AppleRemotecon();
      // 변수가 3가지기 때문에 3가지 방식으로 리모콘을 조작하는 기능을 작성해야한다.
      samsungRemotecon.powerBtn();
      lgRemotecon.powerBtn();
      appleRemotecon.powerBtn();



// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      // Abstract Class를 사용하여 타입의 다형성을 써서 코드의 생산성을 높이는 경우
      AbstractRemotecon remotecon1 = null; // 변수 설정

      //String input = "samsumg";
      String input = new Scanner(System.in).nextLine();

      if (input.equals("samsumg")) {
         remotecon1 = new SamsungRemotecon();
      } else if (input.equals("lg")) {
         remotecon1 = new SamsungRemotecon();
      }
      else if (input.equals("apple")) {
         remotecon1 = new SamsungRemotecon();
      }
      else{
         System.out.println("잘못된 입력입니다");
         return; // main 함수 종료
      }

      // remonte1 변수는 3개의 객체중 하나를 참조.
      remotecon1.powerBtn();
      remotecon1.arrowBtn("up");
      remotecon1.smartBtn();

      // 1. 타입의 다형성을 이용해 생산성을 높이는 방법  => L26
      // 2. 타입을 다형성을 매개변수로 이용해 코드를 높이는 방법  => L27


   }
}
