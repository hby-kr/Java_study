package tj703.study;

public class L04PrimitiveDataType {
   public static void main(String[] args) {
      //java는 수로된 데이터만 기본형으로 지정함
      //수: 정수(실수가 아닌,소수점이 없는)
      byte b = 127; //1byte
      short s = 12345; //2byte
      int i = 1234567890; //4byte
      long l = 123456789012L;//8bte.
      //실수 : 소수점이 있는 (지수부 가수부로 데이터 저장)
      float f = 13.1234F; //4byte
      Double d = 13.123456789; //8byte

      boolean result = true;//1 //1bit 데이터지만 크키가 1byte(주소의 가장작은단위 byte)
      result = false;//0 //참조하는 데이터가 변활 수 있음 =>변수
      char c = 'a'; //문자표의 번호(정수)

      // 면접에서 이거 외우라고. 물어봄.

      /*기본형 데이터란(원시 데이터)
       * 1.데이터 자체가 리터럴한 것 (메모리상에 저장된 데이터가 한번에 파악가능한)
       *   =>컴퓨터의 메모리는 0,1로된 비트정보를 저장하고 그것을 수로 표현가능
       *   =>모든 기본형은 수로된 데이터 뿐
       *   =>char가 기본형인 이유: char는 문자표(encoding utf-8,euc-kr)의 번호인 수를 참조
       *   =>boolean 이 기본형인 이유 : 0,1로만 된 데이터기 때문
       *   =>**js 문자열을 기본형으로 지정할 수 있는 이유 : 배열이지만 수로된 배열로 데이터를 한번에 파악가능한 리터럴 데이터기 때문
       * // 면접에서 나올 수 있음. 면접에서 질문을 끌어오게 해야한다.
       *   =>'abc' => @fd8 저장 => [97,98,99] => 979899 => 011000010110001001100011 => 한번에 파악가능
       *   => 자바는 한번에 파악가능해도 배열이기 때문에 원시데이터로 보기 힘들다고 판단.
       * 2.이미 저장된 데이터가 있다면 새로 만들지 않고 만들어져 있는 데이터를 참조 (데이터의 재사용,성질)
       *   => 보통 프로그래밍 언어가 기본형을 재사용하게 설계한다.
       * 3.데이터를 참조하는 변수는 소문자로 타입을 명시 (Int x, int o)
       * 4.데이터를 리터럴(눈에 보이는 그대로)하게 표기
       * 5.기본형 데이터는 그 데이터를 보조하는 자료형 데이터 타입인 랩퍼클래스가 존재합니다.
       * */
      Integer objI = 13; //13 자료형
      Byte objB = 13;
      Short objS = 13;
      Long objL = 13L;

      Float objF = 13.0F;
      Double objD = 13.0;

      Boolean objResult = true;
      Character objC = 'A';
      //parse(parsing) : 강제로 형변환 (오류가 발생할 수 있음)
      //thread : 실행단위 (Exception in thread "main" : main 을 실행하는 도중에 오류가 발생)
      System.out.println(Integer.parseInt("55") + 1); //56이면 "55"가 정수 55로 변환
      System.out.println(Double.parseDouble("55.55") * 2);
      try {
         System.out.println(Integer.parseInt("오십오")); //실행시 오류(심각한 오류 : jvm이 종료)
         //js => Number("오십오") => NaN
         //isNaN("오십오") => true
         //NaN(수가 아닌데 수로 형변환을 한 상태): 웹상에서 문자열을 수로 형변환하는 일이 굉장히 많아서 오류를 발생시키지 않고 상태를 만들었다.
         //html 에 출력된 정보는 모두 문자열이기 때문(<div data-num='55'>13</div>)

         //JSON.parse(`{ 13 : '안녕' }`) : 오류
      } catch (Exception e) {
         //e.printStackTrace(); //오류 로그를 콘솔에 출력
         System.out.println(e);
      }
      System.out.println("어플종료"); //실행된다면 발생한 오류를 예외처리 하여서 jvm이 종료되지 않음


   }
}

/*
>>> Java의 기본 데이터 타입

   Java는 **강타입 언어(strongly typed language)**로,
   변수에 저장되는 데이터 타입을 명시해야 하며, 데이터 타입에 대한 규칙이 엄격합니다.

   Java의 기본 데이터 타입은 크게
   **원시타입(Primitive types)**과
   **참조 타입(Reference types)**으로 나눌 수 있습니다.

   > 원시 타입 (Primitive types)

   byte - 8비트 정수 / 예: byte c = 127;
   short - 16비트 정수 / 예: short d = 1000;
   int - 32비트 정수 / 예: int a = 10;
   long - 64비트 정수 / 예: long b = 100L; (접미사 L 필수)
   (다양한 정수 종류가 있는 이유는, 메모리 관리와 성능 최적화, 데이터 범위에 대한 명확한 의도 표현 등을 위해서임)

   float - 32비트 부동소수점 (단정도 실수) / 예: float e = 10.5f; (접미사 f 필수)
   double - 64비트 부동소수점 (배정도 실수) / 예: double f = 3.14;
   <!-- Number (js에서는 모든 정수와 실수를 Number 타입으로 처리) -->

   char - 16비트 유니코드 문자 / 예: char g = 'A';
   <!-- js에서는 문자와 문자열을 모둑 String 타입으로 처리) -->
   <!-- 문자열이 js에서는 기본형, java에서는 자료형 -->

   boolean - true 또는 false 값을 갖는 논리형 / 예: boolean h = true;
 */