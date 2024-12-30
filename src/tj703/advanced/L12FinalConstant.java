package tj703.advanced;

// 상수 설정
class ConstTest {
   int a; // 카멜 표기법
   final int B = 0; // 필드는 상수의 초기값을 같이 지정해야 한다. 밑에 final String s와 비교.
   // 그리고 바뀌지 않는 것은 변수라도 대문자로 쓰자. 따라서 b가 아니라 B로 씀. 대문자 스네이크 표기법을 사용.
   final String SAY_HELLO = "안녕";
}

public class L12FinalConstant {

   public static void main(String[] args) {
      // [JS] const a = 10;
      // const obj = {} 라고 자주 설정하는 이유는, js가 동적타입 언어라서,
      // 변수의 객체를 후에 다르게 설정할 수 있기 때문에 상수로 처음대입한 것을 바꾸지 않기 위해 사용.

      // 자바는 정적언어, 강타입언어라서 변수를 설정해 놓으면 그 타입을 변경할 수 없다.
      // String str = "잘가";
      // str =20;  (불가능)
      // 반대로 자바에서, (동적언어처럼) Object 타입을 명시해놓으면, 뭐든 넣을 수 있다.
      // Object obj = new Object();
      // obj = "안녕"  (가능)

      final int a = 10;
      // 처음 대입한 값을 다른 것으로 바꿀 수 없는 것을 상수라 한다.

      final ConstTest ct = new ConstTest(); // ct라는 변수에 ConstTest의 객체가 다른 것으로 바뀌지 않는다는 말
      ct.a = 10; // 따라서 ConstTest의 인스턴스인 ct의 변수에 값(내부의 필드를)을 설정하는 것은 가능한 일.

      final String s; // 지역변수는 상수를 비어놓을 수 있다. cf. 위에 final int b
      s = "안녕"; // 그리고 최초 설정한 값을 상수의 값으로 가지게 된다.
      // s = "잘가"; // 따라서 바꿀 수 없지.
   }
}


/*
자바는 강타입 언어라서, 무분별하게 많이 사용할 일이 별로 없다.
그럼 언제 쓰게 되는가? (자바에서의 상수의 목적)

ㅡㅡㅡㅡㅡ  자바에서의 상수 final 사용 규칙.
1. 한 번만 초기화 (초기화 후 변경 불가)
final로 선언된 변수는 한 번만 초기화할 수 있습니다. 초기화가 완료되면 해당 변수의 값을 변경할 수 없습니다.
   *** 이때 초기화 시점이 조금 다를 수 있음
   초기화 시점:
   인스턴스 변수: 생성자에서 초기화 가능
   정적 변수: 클래스 내에서 한 번만 초기화 가능
   지역 변수: 선언 시 또는 메서드 내에서 초기화 가능

2. 상수 선언 (상수 변수에 사용)
   final은 상수를 선언할 때 주로 사용됩니다.
   상수는 일반적으로 static final로 선언되며, 값이 변경되지 않도록 보장합니다.
   일반적으로 상수 이름은 모두 대문자로 작성하고, 여러 단어일 경우 언더스코어(_)로 구분합니다.
ex. public static final int MAX_SIZE = 100;
   public static final 이렇게 세가지 설정을 해야 한다는 것.

3.클래스에서의 사용
   final 클래스: final로 선언된 클래스는 상속할 수 없습니다.
   다른 클래스가 해당 클래스를 상속하지 못하도록 제한합니다.
ex.
      public final class Utility {
       // 이 클래스는 상속할 수 없음
   }

4. 메서드에서의 사용
   final 메서드: final로 선언된 메서드는 오버라이드할 수 없습니다.
   서브클래스에서 해당 메서드를 변경하지 못하도록 합니다.
ex.
   public class BaseClass {
    public final void printMessage() {
        System.out.println("This is a message.");
    }
}

5. 변수의 불변성 보장 (불변 객체 만들기)
final을 사용하면 변수의 참조 변경을 방지할 수 있습니다.
예를 들어, final로 선언된 객체 변수는 그 객체의 참조값을 변경할 수 없습니다.
그러나 객체의 상태(멤버 변수)는 변경할 수 있습니다.
      ex. ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      public class Person {
          final String name;  // 'name' 참조값은 변경 불가

          public Person(String name) {
              this.name = name;  // 생성자에서 값 초기화
          }

          public void changeName(String newName) {
              // name = newName; // 오류 발생: 'final' 변수는 변경할 수 없음
          }
      }
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      위 예시에서 name은 final로 선언되었습니다.
      즉, Person 객체가 생성될 때 name에 값을 한 번만 할당할 수 있고, 이후 name의 값을 다시 변경할 수 없습니다.
      하지만, 중요한 점은 final이 객체의 참조를 변경할 수 없게 만드는 것뿐입니다.
      즉, name 변수 자체를 다른 값으로 바꿀 수 없지만, 만약 name이 참조하는 객체가 변경 가능 객체라면, 그 객체의 상태는 변경할 수 있습니다.
      (아래와 같이 String[], 스트링의 배열들일 경우, 배열타입 자체를 바꿀 수는 없지만,
      배열 안의 데이터 값을 추가, 수정할 수는 있다.
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      public class Person {
          final String[] names;  // 'names' 참조값은 변경 불가

          public Person(String[] names) {
              this.names = names;
          }

          public void changeFirstName(String newName) {
              names[0] = newName;  // 참조가 final이므로 names 배열을 다른 배열로 변경할 수 없지만,
                                    // 배열 안의 값은 변경 가능합니다.
          }
      }
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


6. 지역 변수에서의 사용
지역 변수가 final로 선언되면, 해당 변수는 메서드 내에서 재할당할 수 없습니다.
즉, 값을 한 번만 할당할 수 있습니다.

7. 익명 클래스에서 사용
Java에서 익명 클래스(Anonymous Class) 또는 람다 표현식을 사용할 때, 외부 변수를 클래스 내부로 가져올 수 있습니다.
익명 클래스나 람다 표현식에서 외부 변수는 반드시 final이어야 합니다.
이유는 익명 클래스가 생성된 후에 그 변수가 변경되지 않도록 보장하기 위해서입니다.
이는 익명 클래스가 해당 변수를 캡처하기 때문입니다. 초기화된 후 값을 변경할 수 없도록 해야 합니다.
      ex. ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      public void exampleMethod() {
          final String message = "Hello";  // 반드시 final이어야 함

          // 익명 클래스 사용
          Runnable r = new Runnable() {
              @Override
              public void run() {
                  System.out.println(message);  // 외부 변수 'message'를 사용할 수 있음
              }
          };
          new Thread(r).start();
      }
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      여기서 message 변수는 final로 선언되어야만 익명 클래스에서 사용할 수 있습니다.
      왜냐하면, 익명 클래스가 message를 "캡처"할 때, 그 값을 변하지 않도록 보장하기 위해서입니다.
      즉, 익명 클래스나 람다 표현식에서는 외부에서 선언된 변수의 값이 변할 수 없기 때문에 final로 선언해야만 그 값을 사용할 수 있게 됩니다.
      final로 선언하지 않으면 컴파일 오류가 발생합니다.
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 만약 final이 없으면:
      public void exampleMethod() {
          String message = "Hello";

          // 익명 클래스 사용
          Runnable r = new Runnable() {
              @Override
              public void run() {
                  message = "Goodbye";  // 오류 발생: 외부 변수는 final이어야만 사용 가능
              }
          };
          new Thread(r).start();
      }
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      public void exampleMethod() {
          String message = "Hello";

          // 익명 클래스 사용
          Runnable r = new Runnable() {
              @Override
              public void run() {
                  message = "Goodbye";  // 오류 발생: 외부 변수는 final이어야만 사용 가능
              }
          };
          new Thread(r).start();
      }
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      위 코드에서는 message가 final이 아니기 때문에, 익명 클래스 내부에서 값을 변경하려고 할 때 오류가 발생합니다.
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


8. final과 static의 조합
static final 변수는 클래스 수준에서 하나의 값을 공유하는 상수를 정의할 때 사용됩니다. 이 경우, 해당 값은 클래스 로딩 시점에 한 번만 초기화되고, 그 이후에는 변경할 수 없습니다.
ex.
public class Constants {
    public static final double PI = 3.14159;
}

9. 메서드 파라미터에서 사용
메서드의 파라미터를 final로 선언하면, 그 파라미터 변수는 메서드 내에서 재할당할 수 없습니다. 이는 파라미터가 의도치 않게 변경되지 않도록 하기 위한 방법입니다.
ex.
public void printMessage(final String message) {
    // message = "Hello"; // 오류 발생: final 변수는 재할당 불가
    System.out.println(message);
}





 */