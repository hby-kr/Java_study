package tj703.study;

import java.util.Scanner;
import java.util.ArrayList;
// 특정 패키지를 프로그램에 포함시키는 명령어

import java.util.*;
// *는 와일드카드(wildcard)로, 해당 패키지 내 모든 클래스를 포함시키겠다는 뜻
// 와일드카드?
/*
1. 패키지에서의 와일드카드 (*)
  *는 import 문에서 사용되며, 특정 패키지 내의 모든 클래스를 포함시키겠다는 의미입니다.
   예를 들어, import java.util.*;는 java.util 패키지 내의 모든 클래스를 가져옵니다.
2. 제네릭에서의 와일드카드 (?)
제네릭에서 사용되는 와일드카드는 ?로 나타냅니다.
이는 제네릭 타입이 어떤 타입이든 가능하다는 의미로, 주로 메서드나 클래스의 타입을 유연하게 처리할 수 있도록 해줍니다.

제네릭에서의 와일드카드는 3가지 주요 용도
1)  ? - 제한 없는 와일드카드
   타입 매개변수에 어떤 타입도 올 수 있음을 의미
         public void printList(List<?> list) {
             for (Object obj : list) {
                 System.out.println(obj);
             }
         }
   위의 예에서는 List<?>가 어떤 타입의 리스트도 받을 수 있다는 의미

2) ? extends T - 상한 경계 와일드카드 (Upper-bounded Wildcard)
   이 와일드카드는 T 타입을 상속하는 클래스 타입을 받을 수 있도록 제한합니다.
   예를 들어, ? extends Number는 Number 타입이나 그 하위 타입을 받을 수 있음을 의미
         public void printNumbers(List<? extends Number> list) {
             for (Number num : list) {
                 System.out.println(num);
             }
         }
   이 메서드는 Number 타입이나 그 하위 타입인 Integer, Double 등의 리스트를 받을 수 있습니다.

3) ? super T - 하한 경계 와일드카드 (Lower-bounded Wildcard)
   이 와일드카드는 T 타입 또는 그 상위 타입을 받을 수 있도록 제한합니다.
   예를 들어, ? super Integer는 Integer 타입이나 그 상위 타입인 Number나 Object를 받을 수 있음을 의미
         public void addNumbers(List<? super Integer> list) {
          list.add(10);  // Integer를 추가할 수 있음
      }
      이 메서드는 Integer 타입 또는 그 상위 타입인 Number, Object를 요소로 갖는 리스트를 받을 수 있습니다.


>>  패키지(Package)?  제네릭 (Generics)?
패키지는 논리적인 디렉토리_폴더개념이라고 이해하고,
제네릭은 "타입을 나중에 지정할 수 있는 도구"라고 이해하면 쉽다.

패키지는 클래스를 논리적으로 묶어서 관리하는 방식
제네릭은 코드의 유연성을 높이고, 다양한 타입을 처리할 수 있게 해주는 기능

패키지는 관련된 클래스를 묶는 "그룹" 같은 역할을 하며, 코드를 구조적으로 관리하는 데 사용
제네릭은 다양한 타입의 데이터를 다룰 수 있는 유연한 코드를 작성하는 데 사용


1. 패키지 (Package)
패키지는 관련된 클래스나 인터페이스들을 모아 놓은 디렉토리(폴더) 같은 개념
   java.util: 날짜나 컬렉션 클래스와 관련된 여러 클래스를 포함하는 패키지입니다.
   java.io: 파일 입출력과 관련된 클래스들을 포함하는 패키지입니다.
   java.lang: 기본적인 Java 클래스들이 들어 있는 패키지로, 자동으로 포함됩니다.

import java.util.Scanner;
// 위 명령으로 import 문으로 패키지 내의 클래스를 사용할 수 있게 한다.
 Scanner 클래스는 java.util 패키지에 포함된 클래스입니다.
 import java.util.Scanner;를 사용해 Scanner 클래스를 코드에서 사용할 수 있게 했습니다.


2. 제네릭 (Generics)
클래스를 설정할 때 타입을 매번 선행하여 지정하게 되는데,
타입을 매개변수로 만들어서, 타입을 변경할 수 있으면서도, 기능을 하는 코드의 틀을 만들어 놓은 것.

제네릭은 타입을 매개변수로 받는 기능으로, 다양한 타입의 객체를 처리할 수 있는 유연한 코드를 작성하는 데 사용.
주로 클래스, 인터페이스, 메서드에서 사용. 제네릭을 사용하면 코드의 재사용성과 안전성이 향상.
타입을 미리 지정하지 않고 나중에 구체적인 타입을 전달해서 사용할 수 있기 때문에,
다양한 타입을 처리할 수 있는 유연한 코드를 작성할 수 있슴.

   public class Box<T> {
       private T value;  // T는 타입 매개변수, 나중에 지정

       public T getValue() {
           return value;
       }

       public void setValue(T value) {
           this.value = value;
       }
   }
위 코드는 **Box<T>**라는 제네릭 클래스로, T는 타입 매개변수입니다.
T는 나중에 이 클래스를 사용할 때 어떤 타입으로든 지정할 수 있습니다.


>>> java에 축약법이 있을까?
1. 람다 표현식 (Lambda Expressions)
람다 표현식은 함수형 프로그래밍을 지원하는 기능으로, 코드를 더 간결하게 작성할 수 있습니다.
주로 콜백 함수나 인터페이스를 다룰 때 유용하게 사용됩니다.

2. 메소드 참조 (Method References)
메소드 참조는 람다 표현식을 더 간결하게 작성할 수 있는 방법입니다.
이미 존재하는 메서드를 참조하여 사용할 수 있습니다.

3. 스트림 API (Stream API)
4. var 키워드 (Java 10 이상)
5. 삼항 연산자 (Ternary Operator)
삼항 연산자는 if-else 문을 간단히 축약할 수 있는 방법입니다.



 */


public class L14PersonalStudy {
   public static void main(String[] args) {

   }
}
