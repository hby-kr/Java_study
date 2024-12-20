package tj703.study;

public class L04PrimitiveDataType {
   public static void main(String[] args) {

      // Java의 기본형 데이터 타입은 byte, short, int, long, float, double, char, boolean
      // java는 "수"로된 데이터만 기본형으로 지정함

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
       *
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


/*
>>> java에서 기본형데이터의 랩퍼클래스
Java에서 기본형 데이터 타입은 primitive types라고 불리며,
이들 각각에는 대응하는 Wrapper 클래스가 있습니다.
기본형데이터는 소문자로 쓰고,  Wrapper 클래스는 자료형이므로 대문자로 시작.
   boolean → Boolean,
   byte → Byte,
   char → Character,
   short → Short,
   int → Integer,
   long → Long,
   float → Float,
   double → Double


랩퍼클래스의 공통적으로 제공되는 기능들:
   1. valueOf(): (원시형 → 객체)   기본형 "값"을 대응하는 래퍼 클래스의 객체로 변환합니다.
   2. parseX(): (문자열 → 기본형)  문자열을 해당 기본형 값으로 변환합니다
         (X는 해당 기본형을 의미, 예: parseInt, parseDouble, parseBoolean, parseByte, parseShort 등).
   3. toString(): (기본형 → 문자열)  객체를 문자열로 변환합니다.
   4. compareTo(): 다른 객체와 비교하여 순서를 결정합니다.
   5. XValue():  (객체 → 기본형)  객체를 해당 기본형 값으로 반환합니다
         (intValue(), doubleValue() 등).

변환,반환하는 대상은 셋. [ 기본형데이터, 객체, 문자열 ]

1. (원시형->객체) 기본 데이터 타입을 래퍼 객체로 자동 변환 (박싱, Autoboxing)
기본형 타입은 값을 저장하는데 사용되며 객체처럼 다룰 수 없습니다.
반면, 객체는 메서드와 속성을 가질 수 있기 때문에,
기본형을 객체로 변환하면 다양한 객체 관련 작업을 할 수 있습니다
예를 들어, 객체는 null을 가질 수 있으며, equals() 같은 메서드를 사용하여 비교할 수 있습니다.

기본형 값을 객체로 변환하는 것은 박싱(Boxing) 또는 **자동 박싱(Autoboxing)**이라고 합니다.
박싱(Boxing), 자동 박싱(Autoboxing): 기본형 값을 래퍼 클래스의 객체로 자동으로 변환하는 기능

객체화의 결과
메서드 사용 가능: 래퍼 클래스에서 제공하는 다양한 메서드들을 사용가능
null 가능: 기본형은 null 값을 가질 수 없지만, 객체는 null을 가질 수 있습니다.


2. (원시형 → 문자열) 기본형을 문자열로 변환
문자열은 텍스트 데이터이기 때문에 기본형을 문자열로 변환하면 해당 값을 텍스트 형식으로 다룰 수 있음
이는 사용자에게 데이터를 출력하거나 파일로 저장할 때 유용합니다.

변환 메서드: String.valueOf()나 toString() 메서드를 사용하여 기본형을 문자열로 변환

그 결과:
텍스트 형식: 기본형 값을 문자열로 변환하여 출력하거나 저장할 수 있습니다.
문자열 조작 가능: 변환된 문자열을 조작하거나 파일에 저장할 때 유용합니다


3. (객체 → 기본형) 래퍼 객체를 기본 데이터 타입으로 자동 변환
int x = obj; // Integer → int 자동 언박싱


ㅡㅡㅡㅡ
>>>  기본형, 객체, 문자열의 차이점
1) 기본형 (Primitive Type):
   저장된 값만을 다루며, 객체처럼 메서드나 속성을 가질 수 없습니다.
   예: int, double, boolean 등
2) 객체 (Wrapper Class):
   기본형을 객체로 감싼 클래스로, 기본형을 객체처럼 다룰 수 있습니다.
   예: Integer, Double, Boolean 등
   객체는 null 값을 가질 수 있으며, 메서드를 호출할 수 있습니다.
3) 문자열 (String):
   텍스트로 데이터를 다룰 때 사용됩니다.
   기본형과는 다르게 문자들을 조합하여 문자열을 표현합니다.


ㅡㅡㅡㅡ
다시 한 번 보면
   1. valueOf():  (원시형 → 객체)   기본형 "값"을 대응하는 래퍼 클래스의 객체로 변환합니다.
   3. toString(): (원시형 → 문자열)  객체를 문자열로 변환합니다.

   2. parseX():  (문자열 → 기본형)  문자열을 해당 기본형 값으로 변환합니다
   5. XValue():  (객체  → 기본형)   객체를 해당 기본형 값으로 반환합니다
         (X는 해당 기본형을 의미, 예: parseInt, parseDouble, parseBoolean, parseByte, parseShort 등).
         (intValue(), doubleValue() 등).
   4. compareTo(): 다른 객체와 비교하여 순서를 결정합니다.


1. valueOf(); (원시형->객체)

// Integer (int)
int num = 100;
Integer intObj = Integer.valueOf(num); // 기본형 int를 Integer 객체로 변환

// Double (double)
double pi = 3.14159;
Double doubleObj = Double.valueOf(pi); // 기본형 double을 Double 객체로 변환


3. toString(); (원시형 → 문자열)

// Integer (int)
Integer intObj = 100;
String intStr = intObj.toString(); // Integer 객체를 문자열로 변환 ("100")

// Double (double)
Double doubleObj = 3.14;
String doubleStr = doubleObj.toString(); // Double 객체를 문자열로 변환 ("3.14")


2. parseX();  (문자열 → 기본형)
예: parseInt, parseDouble, parseBoolean, parseByte, parseShort 등

// Integer (int)
String intStr = "123";
int parsedInt = Integer.parseInt(intStr); // 문자열 "123"을 int로 변환

// Double (double)
String doubleStr = "3.14";
double parsedDouble = Double.parseDouble(doubleStr); // 문자열 "3.14"을 double로 변환

5. XValue();  (객체  → 기본형) (intValue(), doubleValue() 등)

// Integer (int)
Integer intObj = 100;
int intValue = intObj.intValue(); // Integer 객체에서 기본형 int 값을 추출 (100)

// Double (double)
Double doubleObj = 3.14;
double doubleValue = doubleObj.doubleValue(); // Double 객체에서 기본형 double 값을 추출 (3.14)


4. compareTo() ; 다른 객체와 비교하여 순서를 결정. 두 객체를 비교하여 정수 값(-1, 0, 1)을 반환
// Integer (int)
Integer intObj1 = 100;
Integer intObj2 = 200;
int comparisonResult = intObj1.compareTo(intObj2); // 100과 200 비교 (결과: -1)

// Double (double)
Double doubleObj1 = 3.14;
Double doubleObj2 = 2.71;
int comparisonResultDouble = doubleObj1.compareTo(doubleObj2); // 3.14와 2.71 비교 (결과: 1)

cf. equals(Object obj): 두 객체가 동일한 값을 가지는지 비교합니다.
 (참조형 객체이므로 ==가 아닌 .equals() 메서드를 사용)
      Integer a = 100, b = 100;
      boolean isEqual = a.equals(b); // true



전체 예시 코드
 */
      // valueOf()
      Integer intObj = Integer.valueOf(100);
      Double doubleObj = Double.valueOf(3.14);
      System.out.println("Integer valueOf: " + intObj); // 100
      System.out.println("Double valueOf: " + doubleObj); // 3.14

      // parseX()
      int parsedInt = Integer.parseInt("123");
      double parsedDouble = Double.parseDouble("3.14");
      System.out.println("Parsed Integer: " + parsedInt); // 123
      System.out.println("Parsed Double: " + parsedDouble); // 3.14

      // toString()
      String intStr = intObj.toString();
      String doubleStr = doubleObj.toString();
      System.out.println("Integer toString: " + intStr); // "100"
      System.out.println("Double toString: " + doubleStr); // "3.14"

      // compareTo()
      int comparisonResult = intObj.compareTo(200);
      int comparisonResultDouble = doubleObj.compareTo(2.71);
      System.out.println("Integer compareTo: " + comparisonResult); // -1
      System.out.println("Double compareTo: " + comparisonResultDouble); // 1

      // XValue()
      int intValue = intObj.intValue();
      double doubleValue = doubleObj.doubleValue();
      System.out.println("Integer value: " + intValue); // 100
      System.out.println("Double value: " + doubleValue); // 3.14
   }
}

/* 자바에서 메서드를 호출하기
 클래스명.메서드()와 객체명.메서드() 형태로 두 가지 방식이 사용.  이 차이는 정적 메서드(static method)와
 인스턴스 메서드(instance method) 호출 방식에서 발생합니다.
1. 클래스명.메서드() – 정적 메서드 호출
2. 객체명.메서드() – 인스턴스 메서드 호출

1. 클래스명.메서드() – 정적 메서드 호출
정적 메서드는 인스턴스 객체를 생성하지 않고, 클래스 이름을 통해 호출할 수 있는 메서드입니다.
클래스 자체에 속하는 메서드로, 인스턴스 객체와 상관없이 클래스 차원에서 실행됩니다.

예를 들어, Boolean.valueOf("true")는 Boolean 클래스의 정적 메서드입니다.
이 메서드는 Boolean 객체를 생성하지 않고도 클래스 이름을 사용하여 호출할 수 있습니다.

2. 객체명.메서드() – 인스턴스 메서드 호출
인스턴스 메서드는 클래스의 인스턴스 객체를 생성한 후(객체가 이미 생성되어 있어야 함).
해당 객체를 통해 호출하는 메서드입니다.
인스턴스 메서드는 객체의 상태(인스턴스 변수)에 접근하거나, 객체에 관련된 동작을 수행합니다.

예를 들어, obj.doubleValue()는
Double의 인스턴스 객체(이름이 obj)인 obj에서 인스턴스 메서드를 호출하는 경우입니다.
이 메서드는 객체가 가지고 있는 실제 값을 가져오는 동작을 합니다.   */

/*  Object 객체의 내장메서드

equals(Object obj): 객체가 동일한지 비교하는 메서드입니다.
      hashCode(): 객체의 해시 코드를 반환하는 메서드입니다.
            toString(): 객체를 문자열로 변환하는 메서드입니다.
      getClass(): 객체의 런타임 클래스를 반환하는 메서드입니다.
            clone(): 객체를 복제하는 메서드입니다.
            finalize(): 객체가 가비지 컬렉션되기 전에 호출되는 메서드입니다.
      notify(): 대기 중인 스레드를 깨우는 메서드입니다.
            notifyAll(): 대기 중인 모든 스레드를 깨우는 메서드입니다.
      wait(): 현재 스레드를 대기 상태로 만드는 메서드입니다.
 */










