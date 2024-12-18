package tj703.homework;

import com.sun.source.tree.DoWhileLoopTree;

import java.util.Scanner;

public class H01RandomNum {

   public static void main(String[] args) {

//    사전 지식

      double random = Math.random(); // java.lang 패키지는 자동으로 Inport한다 (String, Integer 등등)
      System.out.println(random);

      // 1~10까지 정수만들기
      int num = (int) (random * 10 + 1); // 소수점 위 만들고, 소수점 뒤 날려버리기.
      // 강제형번환casting (더 큰 데이터를 작은 데이터 크기로 변환시키는 것)
      // +1한 이유는 0~9까지 나오니까. 10을 만들고 싶어서.
      System.out.println(num);

      // 1~50까지 정수 만들기
      int num2 = (int) (random * 50 + 1); // 소수점 위 만들고, 소수점 뒤 날려버리기.
      System.out.println(num2);


//    랜덤하게 뽑은 수가 사용자가 입력한 수와 같을때까지 반복실행하는 코드를 작성하세요!

      double random2 = Math.random();
      int num3 = (int) (random2 * 50 + 1);
      System.out.println("랜덤한 수가 정해졌습니다.");

      Scanner scanner = new Scanner(System.in);

      int inputNum; // 변수
      do {
         // 반복할 코드
         System.out.println("1~50 중 당신이 원하는 수를 아래에 입력하세요");
         String inputNumStr = scanner.nextLine(); // 개행을 할 때까지(=enter를 입력할 때까지) 입력을 받는다.
         inputNum = Integer.parseInt(inputNumStr); // 숫자로 변환

         if (inputNum > num3 ) {
            System.out.println("hint. 입력한 수보다 정답은 작습니다");
         } else if (inputNum < num3 ) {
            System.out.println("hint. 입력한 수보다 정답은 큽니다");
         }

      } while (num3 != inputNum); // 거짓이면 멈춤. 참이면 계속 실행
      System.out.println("축하합니다! 맞추셨습니다.");
      System.out.println("축하합니다! 맞추셨습니다.");
      System.out.println("축하합니다! 맞추셨습니다.");
      System.out.println("축하합니다! 맞추셨습니다.");

   }
}
