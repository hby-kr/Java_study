package tj703.study;

import java.util.ArrayList; // 얘는 java에서 제공하는 기본 라이브러리 ( java.util )
// 다른 폴더에 있는 것을 가져오는 것.

// ** 함수선언식 vs 함수표현식
// function add (a, b){} : 함수 선언식. 호이스팅hoisting이 발생
//             (코드를 실행하기 전에 컴파일 하면서, 이름있는 메서들을 메서드영역 메모리에 미리 저장함) (js, java 둘다)
// const add = function(a,b) {} : 함수 표현식. 익명함수 = 호이스팅 발생 안함 = 실행되면서 메모리에 저장됨

// 클래스 내에 세가지, 필드, 생성자, 메서드를 설정할 수 있다.
class DataType {
   // 클래스 안에서 필드와 메서드를 정의할 수 있다.
   // == 타입에는 필드를 정의할 수 있데, 필드에는 전역변수, 메서드, 생성자가 있다.
   // 필드와 메소드는 꼭 전역(class의 첫번째 영역)에 변수로 선언해야 한다.
   int age = 38;
   String name = "최경민";

   // 메소드 = 실행(=연산)의 집합. 재사용하기 위해서
   public void add(int a, int b) {
      // add 메소드는 이 타입의 인스턴스 객체가 되었을 때 필드로 존재.
      // (강사는 필드라는 개념에서 메서드를 포함하여 이해하고 있음)
      // int a, int b ==> 매개변수parameter라 부른다. 함수 연산의 값을 제공.
      int result = a + b;
      System.out.println("a+b=" + result);
   }

   public void add(int a, int b, int c) {
      System.out.println("a+b+c=" + (a + b + c));
   }
   // java에서는 이름이 같으나 매개변수가 다른 메서드를 또 설정할 수 있다. == 오버로드overloading

   public int add(int a, int b, int c, int d) {
      // 얘는 void가 아님. int임. 이 차이가 뭔지를 알아야 함.
      int add = 0; // null를 놓을 수 없어서 0을 넣는 것.
      add = a + b + c + d;
      return add;
      // 반환값이란 함수가 실행되면 그 자리에 툭 떨어지는 것.
      // return은 하나만 내놓을 수 있음. [js,java 모두] (dart언어는 여러개 가능)
   }

   // ** 오버로드overloading란:
   // 동일한 이름을 가진 메서드를 여러 번 정의할 수 있는 기능을 의미합니다.
   // 오버로드된 메서드는 매개변수의 개수나 타입, 순서 등이 다르게 정의되어야 합니다.
   // 메서드의 이름은 같지만, 각 메서드를 구분할 수 있는 방법은 매개변수의 특성(타입, 개수, 순서) 입니다.

   // cf. 다형성(Polymorphism): 이름은 한 개인데 역할을 여러 개 (객체지향 문법 = 사람이 생각하는대로 코딩하는 것)
   // == 같은 이름의 메서드가 다양한 객체에서 다르게 동작하는 특성 == 이름을 여러개 쓰기 싫어서 사용하는 방식.

   // js는 오버로드가 안됨. 대신 같은 기능을 하고 싶으면, 매개변수의 기본값을 줄 수 있다.
   // add(a, b, c=10) {} 이렇게


//      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   // >> 생성자 만들기 (class에 꼭 1개 이상이 존재하고, 객체 생성시 필드를 재정의하기 위해 존재)
   // [ js에서는 ] constructor(){}

   public DataType(String name) {
      // 객체 생성시 필드 name을 재정의하겠다.
      this.name = name;
      // this == 객체자신
      // this.name : 객체에 선언된 필드 name
   }

   public DataType(String name, int age) {
      this.name = name;
      this.age = age;
   }
   // public DataType() { // ==default 생성자. 개발자가 정의하지 않아도 한개는 존재함.
   // 외부에서 객체를 생성하려면 꼭 public 이라고 적어줘야함.
   // 접근 제어자라고 하는 데, public, private, protected 이있다.
   //     public : 공개된 클래스, 메서드, 변수 등을 의미합니다. 다른 클래스에서 접근 가능합니다.
   //     private : 비공개된 클래스, 메서드, 변수 등을 의미합니다. 같은 클래스 내에서만 접근 가능합니다.
   //     protected : 자식 클래스에서 접근할 수 있는 멤버입니다. 같은 패키지 내에서 접근도 가능합니다.

   // ClassName (생성자이름) : 생성자의 이름은 꼭 class 이름과 같다.
   // return type(void) 반환타입이 생략 ; 생성자를 호출하면, 반환되는 객체의 타입이 생성자의 이름과 같다.
   // == 반환타입이 정의되어 있고, 생성자의 이름(constructor)을 생략한 것이라고 이해하는게 더 정확.
   // 생성자를 new 연산자와 같이 호출하면 객체를 반환.

}


//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ main 밖에서 class(필드와 메서드의 틀)를 설정한다.
// main()에서는 패키지(같은 폴더) 내부에 있는 클래스는 바로 참조가능 (L01Hellojava.java)


//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ main은 불러와서 서비스를 굴리는 코딩을 짜는 공간

public class L09ClassType {
   // main = 어플의 실행의 집합 == 어플 ( L09ClassType.main() )
   public static void main(String[] args) {
      /*  Class와 Type는 같은 말로 씀
      Class는 자료형 데이터의 타입        */

      new DataType(); // 객체를 생성한 것.
      DataType data = new DataType(); // 객체를 생성하면서 동시에 변수에 참조하는 것.
      // [js에서는] const data = new DataType();
      // js는 타입을 명시하지 않는다. -> 동적 타입언어 (객체의 타입을 엔진이 알아서 정의

      System.out.println((data.age));
      System.out.println((data.name));
      // [js에서는] {age:38, name:"최경민"} 이렇게 리터럴하게 객체를 정의할 수 있음

      // 메서드 실행하기
      data.add(100, 201);
      // [js에서는] 메서드 자체를 불러올 수 있었음. 아래와 같이
      // data.add(); // java에서는 불가능. 오류남.

      data.add(123, 456, 678);

//      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

      data = new DataType("홍길동");
      System.out.println(data.name);

      data = new DataType("둘리", "50");
      System.out.println(data.name, data.age);

   }
}

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
/*  Java 파일의 기본 구조
 * 1. 패키지 선언 (선택사항)
 *  package mypackage;  // 패키지 선언
 *  Java 파일의 맨 위에 위치
 *  package 키워드를 사용하여, 클래스가 속한 패키지를 지정할 수 있습니다
 *
 *
 * 2. 임포트 (Import) 선언 (선택사항)
 * import java.util.Scanner;  // Scanner 클래스 불러오기
 * import는 다른 클래스나 라이브러리 파일을 가져올 때 사용합니다.
 * 위치: 패키지 선언 아래에 위치
 *
 *
 * 3. 클래스 정의 (Class Definition)
 * public class MyClass {
    // 클래스 내부에 메서드, 변수 등이 위치합니다. }
 * Java에서 모든 코드는 클래스 안에 작성됩니다
 * 하나의 Java 파일에 여러 클래스를 정의할 수 있지만,
 * 파일 이름은 공개 클래스(public class)의 이름과 같아야 합니다.
 *
 *
 * 4. 필드 (멤버 변수, 클래스 변수)
 * public class MyClass {
    int age;  // 필드(변수)
    String name;
   }
 * 필드는 클래스 내에서 정의되는 변수입니다.
 * 객체의 속성을 나타내며, 클래스가 생성된 후 그 객체의 상태를 저장합니다.
 *
 *
 * 5. 생성자 (Constructor)
 * public class MyClass {
    int age;
    String name;

    // 생성자
    public MyClass(int age, String name) {
        this.age = age;
        this.name = name;
    }
   }
 * 생성자는 클래스가 객체로 생성될 때 호출되는 특수한 메서드입니다. 객체 초기화 작업을 담당합니다.
 * 위치: 클래스 내부에 정의되며, 메서드와 유사하지만 메서드 이름이 클래스 이름과 동일합니다.
 *
 *
 * 6. 메서드 (Method)
 * 메서드는 특정 작업을 수행하는 함수입니다.
 * 객체의 행동을 정의하며, 클래스 내에서 다양한 작업을 처리합니다.
 *
 *
 * 7. 메인 메서드 (Main Method)
 *  Java 프로그램이 실행되면 main 메서드가 가장 먼저 호출됩니다.
 *  이는 프로그램의 진입점(entry point)으로, public static void main(String[] args) 형식으로 작성됩니다.
 *  위치: 클래스 내부에 정의되며, 프로그램을 실행하는 핵심 메서드입니다.
 *
 *
 */