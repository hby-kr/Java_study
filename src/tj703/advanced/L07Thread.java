package tj703.advanced;

public class L07Thread {

   public static void main(String[] args) {
      // 스레드; 일을 하는 단위.
      // 모든 프로그래밍 언어는 main thread 1개를 제공한다.

      // thread 독점하기
/*
      boolean game = true;
      while (game){}
      System.out.println("얘는 실행되지 않을 것");
 */


      // thread 새일꾼 생성하기
      boolean game2 = true;
      Thread gameThread = new Thread(() -> {
         while (game2) {
         }
      });
      System.out.println("얘는 실행될 것");

   }
}

// 람다식 말고 Runable의 run을 구현해서 콜백함수로 정의할 수 있음.
