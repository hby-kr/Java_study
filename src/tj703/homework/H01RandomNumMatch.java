package tj703.homework;

import java.util.Scanner;

public class H01RandomNumMatch {
   public static void main(String[] args) {

      boolean game = true;
      gameLoop:
      while (game) {

         System.out.println("--------------------------------");
         System.out.println("랜덤한게 생성한 (1~50)수를 맞추세요! ");
         System.out.println("exit를 입력하면 게임이 종료됩니다 ");
         double random = Math.random();
         int num = (int) (random * 50) + 1;
         System.out.println(num);
         int count = 0;
         Scanner scanner = new Scanner(System.in);

         while (true) {
            String inputNumStr = scanner.nextLine();

            ///game을 무한히 반복시키세요! 2
            // catch부분이 수정됨.

            try {
               int inputNum = Integer.parseInt(inputNumStr);
               //다음 코드부터는 inputNum은 무조건 존재함
               ++count;
               //1+(--count) : 1을 먼저더하고 count를 1빼라
               //1+(count--) : count를 1빼고 1을 더하라

               System.out.println(count + " 시도 / 총 5회중");

               if (inputNum == num) {
                  System.out.println(count + " 시도 :정답!");
                  break;
                  // break를 쓰면, 여기서 반복문이 멈추므로 아래의 코드가 실행되지 않는다.
                  // 때문에 if else로 쓸 필요가 없는 것.
               }
               if (count == 5) {
                  System.out.println("졌습니다.");
                  break;
               }
               if (num < inputNum) {
                  System.out.println("down");
               } else {
                  System.out.println("up");
               }

            } catch (NumberFormatException e) {
               if (inputNumStr.equals("exit")) {
                  System.out.println("어플이 종료됩니다.");

                  // game = false; //전체 while 를 break 할 수 없어서 game=false 로 종료
                  // break; //내부 while break;

                  break gameLoop;
               }
               System.out.println("숫자만 입력하세요.");
            }
         }
      }
   }
}

