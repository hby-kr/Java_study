package tj703.study;

import java.util.Date; // 현재 패키지에 클래스가 없다면 import를 해야한다.
import java.util.Scanner; // 입력을 받아주는 class

public class L13Switch {

   public static void main(String[] args) {

      int month = 2;
      String monthStr = null;

      // 면접문제: if문과 switch의 차이점: switch가 더 빠르고 가독성이 좋다.

      switch (month) { // switch는 변수가 오직 하나다!
         case 1:
            monthStr = "Jan";
            break; // 해당 조건이 맞으면, switch의 스코프 전체를 아예 빠져나가겠다.
         case 2:
            monthStr = "Feb";
            break;
         case 3:
            monthStr = "Mar";
            break;
         case 4:
            monthStr = "Apr";
            break;
         case 5:
            monthStr = "May";
            break;
         case 6:
            monthStr = "June";
            break;
         case 7:
            monthStr = "July";
            break;
      }
      System.out.println("이번달은" + monthStr);

      // 자료형을 switch의 입력 변수로 사용
      monthStr = new String("Apr"); // case가 eqauls로도 작동하는지 보려는 것.
      // 입력한 데이터가 자료형이면, 동등비교연산(==) 대신 equals를 사용한다.(중요**)
      month = 0;

      switch (monthStr) {
         case "Jan":
            month = 1;
            break;
         case "Feb":
            month = 2;
            break;
         case "Mar":
            month = 3;
            break;
         case "Apr":
            month = 4;
            break;
         case "May":
            month = 5;
            break;
         case "June":
            month = 6;
            break;
         default:
            month = -1;
            break; // 나머지 전부는~ 기능.
      }
      System.out.println(month + "월입니다");


      // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ switch가 인기가 없는 이유
      /* 1) 크기 비교를 할 수 없음
         2) && || 을 이용해서 복잡한 비교연산을 할 수 없다. (오직 ==, equals 정도의 비교만 가능)
         3) 순서가 있는 자료라면, 배열이 대신할 수 있고,
         4) js에서는 Object의 key를 switch의 case대신 사용
      */
      // 3번의 부연 설명
      month = 3;
      String[] monthStrArr = {"잘못입력", "Jan", "Feb", "Mar", "Apr", "May"};
      String str = monthStrArr[month];
      System.out.println(str);


      Date now = new Date();
      System.out.println(now.getMonth()); // java는 1월이 0부터 시작.
      int nowMonth = now.getMonth();
      System.out.println(monthStrArr[nowMonth]);

      Scanner scanner = new Scanner(System.in);
      // Scanner는 입력을 받는 객체
      // System.in은 콘솔에서 입력을 받겠다.

      System.out.println("알고 싶은 달의 이름은(숫자입력)? : ");
      String inmonthStr = scanner.nextLine();
      // scanner.nextLine(); // 콘솔에서 입력하고 엔터를 누르면, 엔터를 누르기 전까지를 입력받는다.라는 명령.
      int inmonth = Integer.parseInt((inmonthStr));
      System.out.println(monthStrArr[inmonth - 1]);

   }
}
