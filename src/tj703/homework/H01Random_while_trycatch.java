package tj703.homework;

import java.util.Scanner;

public class H01Random_while_trycatch {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      boolean playAgain = true;

      while (playAgain) {

         System.out.println("랜덤한게 생성한 (1~50)수를 맞추세요! ");
         //맞출때 까지 반복 실행
         double random = Math.random(); //java.lang 패키지는 자동으로 Import (String,Integer..)
         System.out.println(random);
         int num = (int) (random * 50) + 1; //더큰수->작은수 (강제형변환) casting
         System.out.println("뽑힌 랜덤 num:" + num);

         boolean game = true;
         short i = 1;

         while (i <= 5) {

            while (game) {

               System.out.print("1~50 까지 수 중 입력하세요 (" + i + "번째 시도)");
               String inputNumStr = scanner.nextLine();

               try {
                  int inputNum = Integer.parseInt(inputNumStr);

                  if (inputNum == num) {
                     System.out.println("정답입니다. 게임을 종료합니다.");
                     game = false;
                     // break; 얘를 써도 됨
                     //    break: 반복문이나 반복문을 그 자리에서 곧장 완전히 종료합니다.
                     //    continue: 반복문의 현재 반복을 건너뛰고, 다음 반복으로 넘어갑니다.

                  } else if (inputNum > num) {
                     System.out.println("더 큰 수를 입력했습니다. down!");
                  } else {
                     System.out.println("더 작은 수를 입력했습니다. up!");
                  }

                  i++;
               } catch (NumberFormatException e) {
                  System.out.println(" 수 만 입력하세요!");
                  // Integer.parseInt()나 Double.parseDouble() 메서드를 사용하여 문자열을 숫자로 변환하려고 할 때,
                  // 해당 문자열이 숫자 형식이 아닐 경우 NumberFormatException이 발생
                  // 만약, "abc"는 숫자로 변환할 수 없으므로
                  // Integer.parseInt()는 NumberFormatException을 발생시키고, catch 블록에서 이를 처리합니다.

               }

               if (i > 5) {
                  System.out.println("5번의 시도 후 게임이 종료됩니다.");
                  game = false; // 게임 종료
                  break;
               }
            }
         }

         // 게임이 종료된 후 다시 플레이할지 여부를 묻기
         System.out.print("다시 게임을 시작하시겠습니까? (y/n): ");
         String playAgainResponse = scanner.nextLine();

         // 'y' 또는 'Y'를 입력하면 게임을 다시 시작
         if (!playAgainResponse.equalsIgnoreCase("y")) {
            playAgain = false; // 게임을 종료
            System.out.println("게임을 종료합니다. 감사합니다!");
         }
      }
   }
}

// 5회만에 맞추기.
// 게임을 무한히 반복시켜라.

/* 라벨링 label

자바에서 라벨은 주로 break나 continue 문과 함께 사용되어, 중첩된 반복문에서 특정 반복문을 종료하거나 건너뛰는 데 사용


*/
