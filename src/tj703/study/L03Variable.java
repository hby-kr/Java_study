package tj703.study;

public class L03Variable {

   public static void main(String[] args) {
      // 소문자로 작성하는 모든 타입은 기본형
      // java는 숫자로된 데이터만 기본형으로 명시

      int i = 13;  // int i == 변수 i는 Integer만 참조하겠다.
      // 13이라는 데이터를 만들고 -> int타입의 i라는 변수를 만들고 -> 13을 i가 참조.

      Integer iObj = 13; // == new Integer(13)
      System.out.println(13 * 13); // 변수가 등록되지 않은 데이터는 선언할 때마다 새롭게 만든다.
      System.out.println(i * i);
      System.out.println(iObj * i);
      /*       system;  콘솔과 관련된 자료형 데이터
               . 점 ; 필드접근자. 객체의 소속된 자료를 참조하는데 사용
               out; 시스템의 필드로 출력과 관련된 데이터
               print; out(PrintSteam)의 함수(작동하는 코드뭉치)로 콘솔에 문자열을 출력, 실행한다.
               println;
       */


      boolean t = true;
      //   System.out.println(t+t); // 오류남. / 오직 숫자인 타입만 java에서는 수학적 연산 가능
      //   자바는 컴파일시 오류가 발견되면, 실행되지 않기 위해 .class문서로 컴파일하지 않는다.(컴파일이 오류를 예방)

      char c = 'r';  // 문자 데이터
      System.out.println(c + c); // 228 / 계산됨. char는 인코팅 번호이기 때문에 가능

      float f = 13.3f; // 4byte (-2,147,483,648 ~ 2,147,483,647)
      double d = 13.3; // 8byte (-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807)
      System.out.println(d * d);

      /*데이터의 종류
       * 기본형(정수, 실수) (소문자로 전부 표기)
       * 자료형(필드를 가짐) (대문자로 시작 표기)

       * cf.
       * js 기본형 데이터: Number, String, Boolean, Undefined, Null, Symbol, BigInt
       * js에서 문자열String을 기본형으로 지정할 수 있었던 이유; 배열이지만 수로 변환가능한 배열이었기 때문.
       *    ex) abc --메모리에 저장--> 979899
       */
   }
}
