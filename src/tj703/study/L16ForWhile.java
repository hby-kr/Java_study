package tj703.study;

public class L16ForWhile {

   public static void main(String[] args) {
      // 어떤 분기를 반복 실행할 때 사용하는 while, for 반복문
         // "분기"라는 용어는 보통 프로그래밍에서 조건에 따라 다른 경로로 실행되는 흐름을 의미
         // 분기는 조건문이나 반복문에서 특정 조건에 따라 다른 경로로 실행되거나 반복을 중지하는 흐름을 의미

      // 어떤 분기를 조건을 주어 반복실행할 때, 선언문-조건문-증감문을 통해 반복실행을 통제한다.
      // while문
      int n = 0;     // 선언문
      while (n<3){   // 조건문
         System.out.println(n +"번째 안녕");
         n++;         // 증감문 중 증가문
      }

      // for문
      for (int i = 0; i < 3; i++) { // 선언문-조건문-증감문
         System.out.println(i +"번째 잘가");
      }

      // for문 거꾸로 반복하게 하기 / iterator는 불가함.
      String[] strArr = {};
      for (int l = strArr.length; l >=0 ; l--) {
         System.out.println(l + "번째");

      }





   }
}
