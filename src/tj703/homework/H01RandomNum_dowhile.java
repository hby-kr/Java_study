package tj703.homework;

import com.sun.source.tree.DoWhileLoopTree;

import java.util.Scanner;

public class H01RandomNum_dowhile {

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
      // 추가 주문 / 5회만 시도하기, 그 이상이면 "게임실패!" / 그리고 다시 게임을 무한반복 시키기.

      double random2 = Math.random();
      int num3 = (int) (random2 * 50 + 1); // 더큰수->작은수 (강제형변환) casting
      // 왜 int로 바꾸냐. 소수점 버림을 위해. (실수가 정수로 형변환하면, 소수점이 날라간다) [버림]
      // 또는 Math.floor()를 써서 내림을 해도 됨.

      //  버림과 내림의 차이
      // 내림과 버림의 차이는 음수일 때 달라짐.  1.4->1 , -1.4
      // [내림] Math.floor()
      // 예를 들어, 3.7을 내리면 3이 되고, -3.7을 내리면 -4가 됩니다.
      // [버림] Math.trunc() (JavaScript, Python, C++)
      // 예를 들어, 3.7을 버리면 3이 되고, -3.7을 버리면 -3이 됩니다.

      System.out.println("랜덤한 수가 정해졌습니다. 안알랴쥼");
      System.out.println("랜덤 수는" + num3);

      Scanner scanner = new Scanner(System.in);

      int inputNum = 0; // 변수
      short i = 1;

      while (i <= 5) {  // 5번 시도까지

         do {
            // 반복할 코드
            System.out.println(i + "번째 시도입니다.");
            System.out.println("1~50 중 당신이 원하는 수를 아래에 입력하세요");
            String inputNumStr = scanner.nextLine(); // 개행을 할 때까지(=enter를 입력할 때까지) 입력을 받는다.

            try {
               inputNum = Integer.parseInt(inputNumStr); // 숫자로 변환
               if (inputNum > num3) {
                  System.out.println("hint. 입력한 수보다 정답은 작습니다");
               } else if (inputNum < num3) {
                  System.out.println("hint. 입력한 수보다 정답은 큽니다");
               }
            } catch (NumberFormatException e) {
               System.out.println("숫자만 입력하세요");
               continue; // 잘못된 입력이 있으면 다시 시도하도록 함
            }
         } while (num3 != inputNum); // 거짓이면 멈춤. 참이면 계속 실행


         if (inputNum == num3) {
            System.out.println("축하합니다! 맞추셨습니다.");
            break; // 정답을 맞추면 게임 종료
         }

         i++;

         if (inputNum != num3) {
            System.out.println("게임 실패! 종료!");
         }


      }
   }
}
// >>>  NumberFormatException e에 대하여.
// NumberFormatException은 예외 클래스의 이름, e는 예외 객체의 변수명.
// Integer.parseInt()나 Double.parseDouble() 메서드를 사용하여 문자열을 숫자로 변환하려고 할 때,
// 해당 문자열이 숫자 형식이 아닐 경우 NumberFormatException이 발생
// 만약, "abc"는 숫자로 변환할 수 없으므로
// Integer.parseInt()는 NumberFormatException을 발생시키고, catch 블록에서 이를 처리합니다.
