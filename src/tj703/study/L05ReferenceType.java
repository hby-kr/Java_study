package tj703.study;

/*
   >>> Java의 참조형 데이터 타입
   모든 클래스, 배열, 인터페이스, 열거형 등은
   참조형 데이터 타입에 해당하며, 이를 통해 객체를 생성하고 조작할 수 있습니다.
   참조형 데이터의 값은 참조 값으로 메모리 상의 위치를 가리킵니다

   1. 클래스 (Classes)
   클래스는 인스턴스 객체 지향 프로그래밍의 핵심 구성 요소로, 객체를 생성하기 위한 템플릿 역할을 합니다. 객체는 클래스의 인스턴스로 생성됩니다.
   == js의 생성자 함수
   클래스의 인스턴스 객체를 생성할 때는 new 키워드를 사용하여 메모리에서 객체를 할당하고 참조합니다.

   2. 배열 (Arrays)
   배열은 같은 타입의 데이터를 여러 개 저장할 수 있는 데이터 구조입니다
   예: int[], String[], Person[] 등

   3. 인터페이스 (Interfaces)
   **인터페이스는 클래스들의 공통적인 동작(기능)을 정의할 수 있는 상위 개념**
   = ** 비슷한 클래스의 같은 기능을 부여할 때, 한번만 써서 적용하는 방식
   = 인터페이스는 여러 클래스에서 공유해야 하는 기능의 "계약"**을 정의하는 것
   = 여러 클래스가 공통적으로 갖추어야 할 메서드들을 선언만 해두고, 실제 구현은 각 클래스가 담당

   인터페이스 자체는 객체를 생성할 수 없지만, 이를 구현한 클래스에서 객체를 생성하고 참조할 수 있습니다.

   4. 열거형 (Enums)
   열거형은 상수 값들의 집합을 정의하는 특수한 종류의 클래스입니다.
   열거형도 객체이므로 참조형 데이터 타입에 포함됩니다.
   배열 vs 열거형
   cf. 배열은 같은 타입의 데이터를 순차적으로 저장하는 데이터 구조
   열거형은 정해진 값들의 집합을 나타내는 특수한 데이터 타입입니다.
   열거형은 상수 값들을 정의하며, 그 값들은 변경되지 않습니다.
 */

import java.util.Date;

public class L05ReferenceType { // 자바는 문서를 가장 먼저 무조건 "public" class로 만드는데, 클래스명과 파일명이 같아야 한다.

   public static void main(String[] args) {
      // 참조형 데이터 (==자료형 데이터, 객체)
      Object o = new Object();  //  자료형을 생성하는 방법
      // new 연산자; 자료형 데이터(객체)를 생성하는 연산자
      // Object() : Object 타입(type, class)의 생성자
      // new 연산자로 생성자를 호출 -> 객체 생성
      // Object o : o 변수가 참조하는 타입이 Object객체다. (타입을 먼저 얘기해주는 것)

      // 객체는 꼭 필드가 존재한다 : 참조형=자료형의 뜻은 필드가 존재하는 데이터라는 말.
      // . 쩜은 필드 접근자

      System.out.println(o.toString());  // 타입+주소 / java.lang.Object@b4c966a
      // java.lang.Object@b4c966a ; @b4c966a 메모리 주소에 저장된 Object 자료형 데이터
      // Object.toSTring() ; 해당데이터를 설명하기 위해 존재

      Object o2 = new Object();
      System.out.println(o.equals(o2));
      // Object.equals() ; 자료형 간의 비교를 위해 존재 (재정의하지 않으면 무조건 false)
      // 이렇게 하지 않으면, 자료형데이터는 나자신을 비교하지 않는 이상 무조건 false다. (문자열만 제외하고)


      // 문자열 (자바에서 대표적인 자료형 데이터)
      String str = new String("안녕");
      str = "안녕"; // 자바에서 문자열은 리터럴 표기법을 지원한다. (*데이터가 리터럴하지는 않음)

      System.out.println(str.toString());  // toString() 생략가능
      System.out.println(str);
      // 원래는 java.lang.Object@b4c966a 주소가 떠야 하는데, 문자열로 재정의 했음. toString이.

      System.out.println(str.equals("안녕")); // 비교하기
      // Object를 포함하는 String에서 equals()를 재정의해서 비교연산 가능
      // Object를 부모, 재정의한 것을 자식이라 부름 (상속)
      System.out.println(str.equals("잘가")); // 비교하기


      str = "hello";
      System.out.println(str.toUpperCase()); // 원본을 바꾸진 않고, 변환된 것이 새로 생성
      System.out.println(str.charAt(2)); // 문자열은 배열이기 때문에, index를 참조할 수 있다.
      System.out.println(str.length());
      // java에서 자료형 데이터인데 리터럴표기법을 지원하는 것. 객체,배열 / {key:value}, [1,2,3]


      // 순서(index)와 길이(length)가 존재하는 자료 : 배열
      int[] arr = {1, 2, 3};
      String[] strarr = {"자바", "웹앱", "마스터"};
      System.out.println(strarr[0]);
      System.out.println(strarr[1]);
      System.out.println(strarr[2]);
      System.out.println(strarr.length);

      Schedule s = new Schedule("스캐줄 인스턴스 객체");
      System.out.println(s.name);
      System.out.println(s.date);

      System.out.println(~9);
   }
}

// class(=type)도 자료형데이터
class Schedule {
   // 클래스의 전체영역.전역. = 가장 바깥 중괄호.

   // 새로운 객체만들기
   Date date = new Date();

   // 변수(파라미터)를 전역에서 설정하고 들어간다는 것이 java의 특징. cf. js
   String name = "객체의 이름";

   // 생성자 함수
   public Schedule(String name) { // 이것이 js의 constructor와 같음. 생성자임. (다만 constructor라는 이름을 안쓰는 것이 java의 특징)
      this.name = name; // 필드를 초기화 (재정의)
   }

}

class Escafe {

// 이스케이프 시퀀스 (escape sequence)
//    따옴표(")나 역슬래시(\)와 같은 특수 문자는 문자열 안에서 그대로 사용하기 어렵기 때문에,
//    이를 표시하기 위해 이스케이프 시퀀스를 사용
//
//    주요 이스케이프 시퀀스:
//     \": 큰따옴표(")를 문자열 내에 포함시키기 위해 사용됩니다.
//     \\: 백슬래시(\)를 문자열 내에 포함시키기 위해 사용됩니다.
//     \n: 줄 바꿈(newline)을 나타내며, 텍스트에서 새 줄을 시작하게 합니다.
//     \t: 탭(tab)을 나타내며, 수평으로 들여쓰기를 만듭니다.
//     \r: 캐리지 리턴(carriage return)을 나타내며, 커서를 줄의 맨 앞으로 이동시킵니다.
//     \b: 백스페이스(backspace)를 나타냅니다. 텍스트에서 한 문자를 지우는 효과를 가집니다.
//     \f: 폼 피드를 나타내며, 주로 화면에서 새 페이지로 넘어가는 효과를 줄 수 있습니다.
//     \ u: 유니코드 문자를 표현할 때 사용하며, \ u 뒤에 4자리 16진수를 적습니다.


   public void escape() {

   // 1. \" : 큰따옴표를 출력
      System.out.println("He said, \"Hello, World!\"");

      // 출력: He said, "Hello, World!"


      // 2. \n : 줄 바꿈 (Newline)
      System.out.println("Hello\nWorld");

      // 출력:
      // Hello
      // World


      // 3. \t : 탭 (Tab)
      System.out.println("Hello\tWorld");

      // 출력: Hello   World  (탭 간격이 들어감)


      // 4. \\ : 백슬래시 출력
      System.out.println("This is a backslash: \\");

      // 출력: This is a backslash: \


      // 5. \r : 캐리지 리턴 (줄 맨 앞으로 커서 이동)
      System.out.println("Hello\rWorld");

      // 출력: World (Hello가 덮어쓰기 됨)


      // 6. \b : 백스페이스 (한 문자를 지움)
      System.out.println("Hello\bWorld");

      // 출력: HellWorld (o가 삭제됨)


      // 7. \f : 폼 피드 (새 페이지로 이동, 콘솔에서는 보통 아무 효과 없음)
      System.out.println("Hello\fWorld");

      // 출력: (콘솔에서는 페이지 변경을 보지 못할 수 있음, 일부 출력장치에서만 동작)


      // 8. \ u : 유니코드 문자
      System.out.println("Unicode: \u0048\u0065\u006C\u006C\u006F");

      // 출력: Unicode: Hello (유니코드 값으로 'H', 'e', 'l', 'l', 'o'가 나타남)
   }

   ;
};




















