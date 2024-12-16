// 한줄 주석
/* 여러줄 주석
 * 여러줄 주석
 *  */

package tj703.study;  //  클래스를 관리하는 폴더 (클래스명을 중복되지 않게, 유일하게 만들어준다)
// 패키지명을 보통 도메인으로 하는데, 도메인은 세상에 하나만 지정할 수 있기 때문에, 내부에 존재하는 클래스명 역시 유일한 이름이 된다.

// 문서명과 클래스 이름이 같은 이유; 자바는 한 파일에 하나의 클래스만 있을 수 있어.
// 그래서 자바 파일의 이름은 항상 public class 이름과 같아야 해.
// 예를 들어, MyProgram.java라는 파일 안에 public class MyProgram이라는 클래스를 넣으면, 파일 이름과 클래스 이름이 같아야만 해.

// 자바 파일에는 public class가 하나만 있을 수 있습니다.
// 자바에서 public class는 하나의 파일에 한 번만 정의할 수 있다는 규칙이 있습니다.
// 하지만 파일 내에 여러 개의 클래스를 정의하는 것은 가능합니다.
// 다만, 그 중 하나만 public class가 될 수 있습니다.


public class L01HelloJava { // 클래스 : 객체 데이터의 타입.
   // public class: 자바는 문서를 무조건 class로 만드는데, public class는 문서명과 같은 class이면서, 외부 라이브러리로도 사용가능하다.

   public static void main(String[] args) {
      // 어플리케이션에 오직 1개만 존재하는 함수. 해당 어플의 실질적인 실행을 명시한다
      // public; 공유가능 / 접근 제어자로서, 해당 메서드가 다른 클래스에서도 접근 가능함을 의미합니다.
      // static; 메모리 영역 / 이 메서드가 클래스의 인스턴스를 생성하지 않고도 호출될 수 있음을 의미
      // void; 반환하는 것이 없는 함수
      // main; 메서드의 이름으로, Java 프로그램이 시작될 때 호출되는 진입점
      // (String[] args); 매개변수로 어플 설정의 초기값 / 문자열 배열로, 프로그램이 시작될 때 설정된 값을 저장한다.
      System.out.println("안녕! Java 시작");
   }
}

class User {// (public을 안붙인 것)은 외부에서 사용할 수 없는 class이면서, 해당 .java문서에 포함된 클래스이다. 하지만 class문서로 컴파일은 된다.
}
    /*  자바에서 class를 만들고 실행하는 방법
   class를 작성시, 꼭 java 문서의 이름이 public class 명과 같아야 함
      예) public class A{} ->문서이름 A.java

   class 명의 규칙 : 카멜(변수,메소드),파스칼,스네이크(대문자->상수, 소문자->파일,폴더)
      대명사->파스칼 JavaStudy : 데이터의 타입이 되기 때문

   어플전체에서 실행되는 메소드가 존재 (main)
      public static void main(String[]args){}

   javac(자바의 컴파일러)로 .java문서를 .class문서로 컴파일.
         컴파일 compile:  컴퓨터(jvm 자바엔진)가 읽기 좋게 변환
            컴파일시 오류가 발견되면 배포하지 않는다.(배포 : 실행되는 코드를 리소스로 만드는 행위)
            실행속도가 빠르다.(인터프리터 엔진보다)
         javac <파일명> => javac A.java
         java(jvm, java virtual machine)or(JRE, Java Runtime Environment)로  main이 작성된 class문서를 실행
         java A : main이 작성된 컴파일된 class 문서 A를 실행


ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   Java에는 JVM, JRE, JDK 세 가지 주요 구성 요소
   JVM은 자바 프로그램을 실행하는 가상 머신입니다.
   JRE는 자바 프로그램을 "실행"하기 위한 환경이며, JVM과 라이브러리를 포함합니다. (사용자)
   JDK는 자바 프로그램을 "개발"하고 실행하기 위한 전체 도구 세트입니다. (개발자)

   JVM (Java Virtual Machine)
      JVM은 Java 가상 머신으로, 자바 애플리케이션이 실행되는 환경을 제공합니다.
      자바 프로그램이 작성된 후, JVM은 이 프로그램을 실행할 수 있도록 합니다.

      주요 역할은 다음과 같습니다:
      바이트코드 실행: 자바 컴파일러가 생성한 바이트코드를 실행합니다.
      메모리 관리: 가비지 컬렉션을 통해 메모리를 효율적으로 관리합니다.
      플랫폼 독립성: Java 프로그램이 어떤 운영체제에서도 실행될 수 있도록 합니다.

   JRE (Java Runtime Environment)
      JRE는 Java 실행 환경으로,
      JVM과 함께 자바 애플리케이션을 실행하는 데 필요한 라이브러리와 기타 파일들을 포함합니다.
      JRE는 다음을 포함합니다: JVM, 클래스 라이브러리, 기타 지원 파일
      간단히 말해, JRE는 자바 프로그램을 실행하기 위한 환경을 제공합니다.

   JDK (Java Development Kit)
      JDK는 자바 개발 키트로, 자바 애플리케이션을 개발하고 실행하는 데 필요한 모든 도구와 라이브러리를 포함합니다. JDK는 다음을 포함합니다:
      JRE: JRE는 JVM과 라이브러리를 포함하므로, JDK 내에 JRE가 포함되어 있습니다.
      개발 도구: 자바 컴파일러, 디버거, 문서화 도구 등 자바 애플리케이션을 개발하는 데 필요한 다양한 도구들을 포함합니다.
      JDK를 사용하면 자바 프로그램을 작성, 컴파일, 디버깅, 실행할 수 있습니다.

    */

