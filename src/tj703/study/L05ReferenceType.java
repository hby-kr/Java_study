package tj703.study;

import java.util.Date;

public class L05ReferenceType { // 자바는 문서를 가장먼저 무조건 class로 만드는데, 클래스명과 파일명이 같아야 한다.

   public static void main(String[] args) {
      // 참조형 데이터 (==자료형 데이터, 객체)
      Object o = new Object();  //  자료형을 생성하는 방법
      // new 연산자; 자료형 데이터(객체)를 생성하는 연산자
      // Object() : Object 타입(type, class)의 생성자
      // new 연산자로 생성자를 호출 -> 객체 생성
      // Object o : o 변수가 참조하는 타입이 Object객체다.

      // 객체는 꼭 필드가 존재한다 : 참조형=자료형의 뜻은 필드가 존재하는 데이터라는 말.
      // . 쩜은 필드 접근자

      System.out.println(o.toString());  // 타입+주소 / java.lang.Object@b4c966a
      // java.lang.Object@b4c966a ; @b4c966a 메모리 주소에 저장된 Object 자료형 데이터
      // Object.toSTring() ; 해당데이터를 설명하기 위해 존재

      Object o2 = new Object();
      System.out.println(o.equals(o2));
      // Object.equals() ; 자료형 간의 비교를 위해 존재 (재정의하지 않으면 주조건 false)

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
      // js에서 자료형 데이터인데 리터럴표기법을 지원하는 것. 객체,배열 / {key:value}, [1,2,3]

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


class Schedule {
   // 클래스의 전체영역.전역. = 가장 바깥 중괄호.
   Date date = new Date();
   String name = "객체의 이름";
   // 변수를 전역에서 설정하고 들어간다는 것이 java의 특징. cf. js

   public Schedule(String name) { // 이것이 js의 constructor와 같음. 생성자임.
      this.name = name; // 필드를 초기화 (재정의)
   }
}