package tj703.advanced;
// 자바는 강타입 언어라서, 무분별하게 많이 사용할 일이 별로 없다.
// 그럼 언제 쓰게 되는가? (자바에서의 상수의 목적)

import javax.swing.*;
import java.awt.*;

interface ConstInterface {
   int a= 10; // 인터페이스는 객체가 될 수 없기 때문에, 필드도 정의할 수 없다.
   public final static int b = 20; // 즉 상수만 설정할 수 있다.
   // a앞에도 public final static가 생략된 것
   // 자동으로 static 필드르 정의하는데, 보통 static 필드로 공유되는 자원은 상수기 때문이다.

   // 추상메서드만 작성가능
   void add(); // == public abstract void add();
}


public class L13Final2 {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.add(new JButton("버튼"), BorderLayout.SOUTH);
      // BorderLayout.SOUTH :  얘가 상수의 진정한 사용 목적.

//상수값의 불변성 보장: final을 사용하여 변수에 값을 한 번만 할당하도록 강제할 수 있습니다.
// 상수를 정의할 때 final을 사용해야 값이 변경되지 않도록 보장할 수 있습니다.
      public static final double PI = 3.14159;


   }
}


/* 패키지 주소를 적어서, 특정 변수 값을 가져오기
패키지 주소라는 표현은 보통 특정 클래스나 객체가 포함된 패키지를 지칭하는데, 이 패키지에서 정의된 특정 변수나 필드를 가져오는 방식에 대해 이야기할 수 있습니다.

자바에서 패키지에 포함된 변수를 가져오는 방법은 여러 가지가 있으며, 크게 두 가지로 나눠볼 수 있습니다:
1. 클래스 내의 정적(static) 변수 가져오기
정적 변수는 클래스가 메모리에 로드될 때 초기화되며, 객체를 생성하지 않고 클래스 이름으로 직접 접근할 수 있습니다.

2. 클래스 내의 인스턴스 변수 가져오기
인스턴스 변수는 객체를 생성해야만 접근할 수 있는 변수입니다.
이 경우 new 키워드를 사용해 객체를 생성한 후, 인스턴스 변수에 접근할 수 있습니다.

3. 다른 패키지에서 특정 변수 값을 가져오기 (패키지 주소 사용)
패키지 주소를 사용해서 변수를 가져오는 것은 기본적으로 해당 변수가 public 접근 제한자를 가지고 있어야 하며,
이를 통해 다른 패키지에서 클래스를 import하고 변수를 사용할 수 있습니다.
import를 사용해 클래스를 불러오고, 클래스의 변수나 메서드를 호출하는 방식입니다.
 */