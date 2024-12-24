package tj703.study;
// 매개변수 타입을 타입의 다형성을 이용해 생산성 높이기

class SmartThings {
   // 모든 종류의 tv를 모바일로 자동조작하기 (모든 종류의 tv리모콘을 가져와야 한다.)

   //   메소드는 한개인데 매개변수가 달라서 다르게 동작하는 overload 상태 => 다형성
   // 타입이 다른 매개변수들을 넣는 동명의 메서드가 생겨있는 상태. overload
   public void remotePower(SamsungRemotecon remotecon) {
      // 모바일 접속해서~~~~ 등등 코드가 여기 쓰여졌다고 가정.
      remotecon.powerBtn();
   }

   public void remotePower(LgRemotecon remotecon) {
      // 모바일 접속해서~~~~ 등등 코드가 여기 쓰여졌다고 가정.
      remotecon.powerBtn();
   }

   public void remotePower(AppleRemotecon remotecon) {
      // 모바일 접속해서~~~~ 등등 코드가 여기 쓰여졌다고 가정.
      remotecon.powerBtn();
   }


   //   ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   public void remoteArrowBtn(AbstractRemotecon remotecon, String arrow) {
      remotecon.arrowBtn((arrow));
   }

   // 타입의 다형성을 잘못 사용한 예! : remontecon의 타입을 Object로 받기
   public void allRemotePower(Object remotecon) { // 여긴 문제없다. 다만...
      AbstractRemotecon abstractRemotecon = (AbstractRemotecon) remotecon; // 강제형변환. 여기가 문제.
   } // 이후 밑에서 메서드를 불러와 인자를 넣어서 실행할 때 오류가 날 것.
}


public class L27Polymorphism {
   // 매개변수 타입을 타입의 다형성을 이용해 생산성 높이기
   public static void main(String[] args) {

      SmartThings smartThings = new SmartThings();
      SamsungRemotecon remotecon = new SamsungRemotecon();
      smartThings.allRemotePower(remotecon); // // 매개변수로 삼성리모콘을 넣기

      String remocon = "삼성리모콘";
      smartThings.allRemotePower(remocon); // 변수의 타입이 Objectf로 설정되어 있어서 문자열도 받을 수 있음.
      // smartThings.remotePower(remocon); 변수의 타입이 한정되어 있어서 오류남.

      // 오류가 없어 보이지만, 오류남.  => ClassCastException
      // 부모타입을 참조하던 변수를 자식타입의 변수로 참조하는 것은 강제 형변환(Casting).
      // -> 매개변수를 너무 상위의 부모로 작성하면, Casting 형변환시 오류가 발생할 수 있다.
      // 매개변수의 타입으로 Object를 쓰는 것을 권장하지 않는다.

   }

}
