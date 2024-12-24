package tj703.study;

interface RemoteControl {
   // interface는 간단한 설계도로 구현 ({body})이 불가능
   // interface는 외부에서 사용가능한 기능만 코딩가등
   // -> 접근 지정자를 public이라고 쓸 필요가 없음. 무조건 public이니까.

   // 아래의 메서드들은 추상메서드다
   void powerBtn(); // public 접근지정자를 명시할 필요 없음

   // 방향키
   int arrowBtn(String arrow);

   // 엉성한 틀을 만드는 것. 이것을 타입으로 설정하고 변수를 할당하여 코딩할 수 있다.
   // = 다형성을 활용하여 구현체에 의존하지 않고, 인터페이스에서 정의한 메서드들만을 사용하는 코드로 작성할 수 있기 때문
}

class SmartRemoteCon implements RemoteControl {
   // implement v. 실행하다.
   // imimplements 해당 class가 interface를 구현하겠다고 명시하는 것.

   // interface와 달리, class는 완성된 타입으로서, 미완성된 함수가 존재할 수 없기 때문에 꼭 바디가 있어야 한다.
   /**
    * 전원버튼
    */
   @Override // 각 클래스에 따라서 오버라이드를 할 수 있다.
   public void powerBtn() {
      System.out.println("전원이 켜짐");
   }

   /**
    * <p>방향키</p>
    *
    * @param arrow "up", "down", "left", "right"
    * @return int 각 전기적 신호
    */
   @Override
   public int arrowBtn(String arrow) {
      int arrowBtn = 0;
      switch (arrow) {
         case "up":
            System.out.println("위로 이동!");
            arrowBtn =1;
            break;
         case "down":
            System.out.println("아래로 이동!");
            arrowBtn =2;
            break;
         case "left":
            System.out.println("왼쪽로 이동!");
            arrowBtn =3;
            break;
         case "right":
            System.out.println("오른쪽로 이동!");
            arrowBtn =4;
            break;
      }
      return arrowBtn;
   }
}

public class L25Interface {
   public static void main(String[] args) { // class의 실제 사용자 main
      // 무언가가 현실물질세계에 동작하는 부분은 여기! main에서 이루어진다.
      RemoteControl remotecon = new SmartRemoteCon();
      // 인터페이스를 타입으로 명시할 수 있음 / 엉성한 틀로 일단 타입을 설정해 놓는 것
      // 리모컨 종류가 바뀌어도 똑같은 방식으로 기능을 쓸 수 있게 해주기 때문
      // = 다형성을 활용하여 구현체(구체적인 클래스, ex 스마트리모콘 클래스)에 의존하지 않고, 인터페이스에서 정의한 메서드들만을 사용하는 코드로 작성할 수 있기 때문

      remotecon.powerBtn();
      remotecon.arrowBtn("up");
      String s = new String();


   }
}
