package tj703.advanced;
/*
ㅡㅡㅡㅡㅡ   변수와 데이터의 정적/동적이라는 개념
정적(Static): 프로그램 실행 전에 결정되고, 실행 중에 변경되지 않는 데이터를 말합니다.
    예를 들어, 정적 변수(클래스 변수)나 클래스 정보 등이 이에 해당합니다.
동적(Dynamic): 프로그램 실행 중에 생성되거나 변경되는 데이터를 의미합니다.
    예를 들어, 객체나 배열과 같이 실행 중에 메모리가 할당되는 부분이 동적입니다.

1. 정적 데이터 (Static Data)
   JVM의 저장 위치: Method Area (또는 Metaspace)
   설명: 정적 데이터는 클래스 정보나 정적 변수(static 변수) 등 프로그램 실행 중에 변경되지 않거나, 클래스가 로드될 때 이미 결정되는 데이터입니다. 이 데이터는 JVM이 클래스나 메서드를 로드할 때 메모리에 할당되며, 프로그램이 종료될 때까지 유지됩니다.
   예시:
      정적 변수: static int count;
      클래스의 메타데이터: 클래스의 이름, 메서드 정보, 상수 풀 등.

2. 동적 데이터 (Dynamic Data)
   JVM의 저장 위치: Heap (동적 할당)
   설명: 동적 데이터는 객체나 배열처럼 실행 중에 동적으로 할당되는 데이터입니다. 객체는 new 키워드로 생성될 때 Heap 영역에 할당되며, 이 메모리는 가비지 컬렉터에 의해 관리됩니다.
   예시:
      객체: Person p = new Person();
      배열: int[] arr = new int[10];

정적 데이터는 Method Area 또는 Metaspace에 저장됩니다.
동적 데이터는 Heap에 저장됩니다.


ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  java의 JVM 구조 익히기
   JVM은 Java 프로그램을 실행하는 가상 컴퓨터라고 생각하면 됩니다.
   Java 프로그램은 먼저 소스 코드로 작성되고, 이것은 바이트코드라는 형태로 바뀌어 JVM에서 실행됩니다.
   JVM은 이 바이트코드를 이해하고 실행하는 역할을 합니다.

JVM의 전체 흐름:
   1. 소스 코드(.java)를 작성합니다.
   2. 이 코드를 컴파일하면 바이트코드(.class)로 바뀝니다.
   3. JVM은 이 바이트코드를 클래스 로더를 통해 메모리에 로드합니다.
   4. 로드된 바이트코드는 메소드 영역에 저장된 클래스 정보와 함께 실행됩니다.
   5. 프로그램이 실행되는 동안 객체는 힙에 저장되고, 함수와 변수는 스택에 의해 관리됩니다.
   6. 실행이 끝나면, 더 이상 사용하지 않는 객체는 가비지 컬렉션을 통해 자동으로 정리됩니다.

JVM은 크게 구분하면
   0. 클래스 로더 (Class Loader)
      클래스 로더는 Java 파일을 JVM에 불러오는 역할을 합니다.
      Java 프로그램이 실행될 때, 필요한 클래스 파일들을 찾아서 메모리에 로드합니다.

이 이하로 jvm은 5개로 구분한다.
 (크게 둘로 나누면 메소드과 힙으로만,
  셋으로 나누면 여기에 메소드, 힙, 스택)

   1. 메소드 영역 (Method Area); 정적 데이터들이 저장되는 곳
      메소드 영역은 Java 클래스의 설명서처럼 동작하는 곳입니다.
      여기에는 Java 클래스의 정보나 정적 변수들이 저장됩니다. 예를 들어, static 변수가 이곳에 저장됩니다.
      저장된 데이터가 삭제되지 않고 계속 유지됨 (그래서 static,정적이라고 부름)

   2. 힙 (Heap); 동적 데이터가 저장되는 곳
      힙은 객체를 저장하는 곳입니다.
      Java에서 new 키워드를 사용해 객체를 만들면, 그 객체는 이 힙 영역에 저장됩니다.
      힙은 가비지 컬렉션이라고 하는 자동 청소 기능을 통해, 더 이상 사용되지 않는 객체를 정리합니다.

   3. 스택 (Stack)
      스택은 함수나 메서드의 작업 공간입니다.
      함수가 호출되면, 그 함수의 지역 변수나 매개변수 등이 스택에 저장됩니다.
      스택은 함수 실행이 끝나면 자동으로 그 공간을 비웁니다.

   4. PC 레지스터 (Program Counter Register)
      각 스레드(작업의 흐름)마다 하나씩 있는 작은 기억장치입니다.
      현재 실행하고 있는 명령어의 위치를 기억합니다.

   5. 네이티브 메소드 스택 (Native Method Stack)
      이 영역은 Java가 아닌 다른 언어(예: C나 C++)로 작성된 프로그램을 실행할 때 사용됩니다.
      Java는 기본적으로 Java 코드만 실행하지만, 다른 언어의 코드를 호출할 때 이 부분이 필요합니다.



ㅡㅡㅡㅡㅡㅡㅡㅡ java의 주요 메모리 영역 좀 더 구체적으로 알기

   * Java의 주요 메모리 영역
      Method Area: 클래스 정보, 정적 변수, 상수 풀 등을 저장.
         저장된 데이터가 삭제되지 않고 계속 유지됨 (그래서 static,정적이라고 부름)
      Heap: 동적 메모리 할당(객체, 배열 등) 및 가비지 컬렉션.
      Stack: 메소드 호출과 지역 변수 저장
      ㅡㅡㅡ
      PC Register: 현재 실행 중인 명령어의 주소를 추적.(스레드가 실행중인 jvm 명령어 위치 추적)
      Native Method Stack: 네이티브 코드(java보다 low-level인 c,c++ 메서드)가 저장되고 실행 시 사용되는 메모리.
      +
      Metaspace: Java 8 이후 Method Area를 대체하며 클래스 메타데이터 저장.
      Direct Memory: JVM 힙 외부에 할당된 메모리, 주로 NIO와 관련된 버퍼에 사용.


   * class load:
    main 함수를 실행할 때, 포함하고 있는 class를 jvm이 읽고 저장하는 과정,
    이때 static필드와 메서드를 method area에 저장한다.

  * method area;
      저장된 데이터가 삭제되지 않고 계속 유지됨 (그래서 static,정적이라고 부름)
      변수나 메소드에 static이라 명시하면 데이터가 클래스로드시 생섣되어 어디서든 참조가능.
      main 함수를 실행하면 클래스 main 영역 내의 (실행에 필요한) 여러 메서드들을 미리 저장하는 곳.
      클래스에 대한 메타데이터를 저장하는 공간입니다. JVM이 클래스를 로드하고 메서드를 호출할 때 필요한 정보를 저장

   * heap area ;
    new A() 인스턴스 객체가 생성되고 저장되는 곳, 동적 메모리 할당이 이루어지는 부분.
    클래스의 인스턴스(객체)와 배열들이 모두 이 영역에 할당.
    이 영역은 프로그램이 실행되는 동안에 동적으로 크기가 조정될 수 있습니다.

    GC(가비지 컬렉터): 쓰레기 수집기. 사용하지 않는 인스턴스 객체를 수집.
         Heap 영역에 할당된 메모리는 더 이상 참조되지 않으면 가비지 컬렉터에 의해 자동으로 회수됩니다. 이를 통해 메모리 관리가 자동으로 이루어집니다.
         heap 영역에서 동작하며, 자동으로 메모리를 정리하기 때문에 개발의 난이도가 하락하고 생산성을 올린다. (반대로 c potiner:
            그래서 java이후에 등장한 대부분의 언어가 heap메모리영역을 가진다.

   * heap 과 method area의 차이점
      Heap 영역은 객체와 배열과 같은 "동적" 할당된 데이터를 저장하는 공간인 반면,
      Method Area는 클래스 정보와 관련된 메타데이터, 즉 "정적" 데이터나 클래스와 메서드에 대한 정보를 저장합니다.
      Heap은 가비지 컬렉터가 관리하지만,
      Method Area는 클래스가 로드될 때 사용되며 JVM이 종료될 때까지 유지됩니다.

   ㅡㅡㅡ
   * stack area:
      thread(일의 단위)를 생성하기 위해 스택자료구조(바구니에 쌓아놓은 구조 cf.리스트구조)에 자료를 스케쥴링하고 연산을 하기위해 자료를 주고 받는 곳.
      Stack 영역은 메소드 호출과 지역 변수를 관리하는 메모리 영역입니다.

 */


// https://goldenrabbit.co.kr/2021/11/03/%EC%9E%90%EB%B0%94-%EC%BD%94%EB%93%9C%EC%99%80-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%8A%A4%ED%83%9C%ED%8B%B1-%EB%B3%80%EC%88%98-%EB%93%B1%EC%9D%80-%EB%A9%94%EB%AA%A8%EB%A6%AC%EC%9D%98-%EC%96%B4%EB%94%94/
// https://co-no.tistory.com/entry/Java-Java%EC%9D%98-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EC%98%81%EC%97%ADRuntime-Data-Area%EA%B3%BC-OOM-%EC%A2%85%EB%A5%98



public class L10Static {

// static은 static필드 또는 클래스변수(정적 변수)라고 한다.
// static으로 선언된 변수나 메서드는 객체(instance)와는 독립적으로 클래스 수준에서 공유됩니다.
// 이는 객체를 생성하지 않고도 클래스 이름을 통해 직접 접근할 수 있게 만듭니다.
// 자주 쓰고, 공유하고, 삭제하면 안되는 데이터나 메서드들을 static으로 설정.

   public static void main(String[] args) {


   }
}
