package tj703.study;

public class L00Curriculum {
}

/*
// gpt한테 물은거임
Java를 배우는 데 있어 이미 JavaScript(Js)에 대한 이해가 있다는 점은 매우 큰 장점입니다.


### 1. 기본 문법과 자료형
   JavaScript에서 변수 선언, 자료형, 연산자  등을 다뤘다면,
   Java에서도 비슷한 내용이지만 문법과 구성이 다릅니다.

#### 1주차: Java 기본 문법

   - Java 설치 및 개발 환경 설정 / JDK 설치 및 IDE 설정 (IntelliJ IDEA, Eclipse 등)
   - Hello World 프로그램 / 첫 번째 Java 프로그램 작성 및 실행

   - 변수 선언과 자료형
   - 기본 자료형 (int, float, double, boolean, char, long 등)
   - 참조형 (배열, 객체 등)
   - 연산자 / 산술 연산자, 비교 연산자, 논리 연산자
   - 조건문 / if, else, else if, switch
   - 반복문 /  for, while, do-while


### 2. 객체 지향 프로그래밍 (OOP) 개념
   Java는 객체 지향 프로그래밍을 핵심으로 하고 있습니다.
   JavaScript에서도 객체를 다뤘기 때문에 OOP의 개념을 Java 문법에 맞게 이해할 수 있습니다.

#### 2주차: 클래스와 객체
   - 클래스와 객체의 개념
   - 클래스 정의, 객체 생성
   - 인스턴스 변수와 클래스 변수
   - 생성자(Constructor)
   - this 키워드
   - 메서드
   - 메서드 정의와 호출
   - 반환 타입, 파라미터, 오버로딩
   - 접근 제어자
   - public, private, protected, default
   - getter/setter 메서드 사용



### 3. 상속과 다형성
   JavaScript에서도 프로토타입 상속을 다뤘다면, Java에서는 전통적인 클래스 상속 방식을 사용합니다. 또한 다형성의 개념을 이해하는 것이 중요합니다.

#### 3주차: 상속과 다형성
   - 상속
      - extends 키워드를 사용한 상속
      - 부모 클래스의 메서드와 변수 상속
      - 메서드 오버라이딩
   - 다형성
      - 메서드 오버로딩과 오버라이딩 차이점
      - instanceof 연산자
   - super 키워드
      - 부모 클래스의 메서드나 생성자 호출
   - 추상 클래스와 인터페이스
      - abstract 클래스
      - interface 정의 및 구현
      - 다중 상속



### 4. 컬렉션과 제네릭
   Java에서는 다양한 컬렉션 클래스들이 제공됩니다. JavaScript에서 객체나 배열을 다뤘다면, Java에서는 컬렉션을 잘 활용하는 것이 중요합니다.

#### 4주차: 컬렉션과 제네릭
   - 컬렉션 프레임워크
      - List, Set, Map 인터페이스
      - ArrayList, HashSet, HashMap 클래스
   - 제네릭(Generic)
      - 제네릭 클래스와 메서드
      - 타입 파라미터의 사용
      - 제네릭을 활용한 안전한 데이터 처리



### 5. 예외 처리와 파일 입출력
   Java는 강력한 예외 처리 시스템을 제공하므로 예외 처리와 파일 입출력에 대해 충분히 이해할 필요가 있습니다.

#### 5주차: 예외 처리 및 파일 입출력
   - 예외 처리
      - try-catch-finally 문
      - 예외 클래스 (Exception, RuntimeException 등)
      - 사용자 정의 예외
   - 파일 입출력
      - 파일 읽기/쓰기 (File, FileReader, FileWriter, BufferedReader, BufferedWriter)
      - 직렬화 (Serialization)



### 6. 멀티스레딩과 동시성
   멀티스레딩은 Java의 중요한 특징 중 하나로, 병렬 처리 및 동시성 문제를 해결하는 데 필수적입니다.

#### 6주차: 멀티스레딩과 동시성
   - 스레드 생성과 실행
      - Thread 클래스, Runnable 인터페이스
      - 스레드 실행 및 종료
   - 스레드 동기화
      - synchronized 키워드
      - 동기화 문제 해결
   - ExecutorService 사용
      - 스레드 풀 관리
      - Future 객체를 통한 결과 처리




### 7. Java 8 기능 (Lambda, Stream, Optional 등)
   Java 8부터 도입된 함수형 프로그래밍 지원은 Java에서 매우 중요합니다. 이 부분은 JavaScript의 함수형 프로그래밍 개념과도 유사합니다.

#### 7주차: Java 8+ 기능
   - 람다 표현식(Lambda Expression)
      - 함수형 인터페이스와 람다
      - 람다를 사용한 메서드 인수 전달
   - Stream API
      - Stream 생성과 처리
      - filter, map, reduce, collect 메서드 사용
   - Optional 클래스
      - null 처리와 Optional의 사용법
      - Optional로 null 처리 개선




### 8. 테스트와 디버깅
   실제 프로젝트를 진행할 때 테스트와 디버깅은 매우 중요합니다. Java에서는 다양한 테스트 프레임워크를 사용할 수 있습니다.

#### 8주차: 테스트와 디버깅
   - JUnit 사용
      - JUnit을 통한 단위 테스트 작성
      - assertion 사용법
   - 디버깅 기법
      - IDE의 디버깅 도구 활용 (브레이크포인트, 스텝 실행 등)




### 9. 자주 쓰는 라이브러리와 프레임워크
   Java는 다양한 오픈 소스 라이브러리와 프레임워크가 존재합니다. 주요 라이브러리와 프레임워크를 익히는 것은 Java 개발자로서 매우 중요한 과정입니다.

#### 9주차: 주요 라이브러리와 프레임워크
   - JDBC (Java Database Connectivity)
      - 데이터베이스와 연결
      - SQL 쿼리 실행 및 결과 처리
   - Spring Framework
      - Spring의 기본 개념 (IoC, DI)
      - Spring Boot로 RESTful API 개발




### 10. 최적화와 성능 관리
   ava의 성능 최적화는 실제로 중요한 부분입니다. 메모리 관리, Garbage Collection, JVM 튜닝 등을 배우는 것이 필요합니다.

#### 10주차: 성능 최적화
   - JVM과 Garbage Collection
      - JVM 구조와 동작 원리
      - Garbage Collection 이해 및 최적화
   - 메모리 관리
      - 힙, 스택, 메모리 누수 방지
      - 성능 분석 도구 사용

 */