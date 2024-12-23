package tj703.study; /*



 접근 지정자(Access Modifiers) 설명
클래스, 메서드, 변수 등의 접근 범위를 정의하는 데 사용.
접근 지정자는 자바에서 클래스나 객체의 캡슐화(encapsulation)를 구현하는 데 중요한 역할을 하며,
코드의 유연성을 높이고 안전하게 보호할 수 있습니다.

접근 지정자의 우선순위 (넓은 순서대로)
public > protected > default(패키지-프라이빗) > private

public: 누구나 모두. 어떤 클래스에서든 접근 가능
protected: 같은 패키지 내 + 자식 클래스에서 접근 가능
   같은 패키지 내에서뿐만 아니라 상속받은 클래스에서도 접근할 수 있기 때문.
default (패키지-프라이빗): 같은 패키지 내에서"만" 접근
private: 클래스 내부에서만.


**public**은 가장 개방적인 접근을 허용하므로, 다른 모든 접근 지정자보다 우선 순위가 높습니다.
**protected**는 같은 패키지 내에서 접근 가능하며, 상속 관계에 있는 클래스에서 접근할 수 있기 때문에 default보다 넓은 범위입니다.
default는 같은 패키지 내에서만 접근할 수 있어, protected보다는 좁은 범위입니다.
**private**는 해당 클래스 내에서만 접근할 수 있어 가장 제한적인 접근을 제공합니다.
*/


// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ[js와 비교하기]
// JavaScript의 클래스 속성이나 메서드는 기본적으로 public입니다.

// private (JavaScript에서 # 기호 사용)
// ES2022(ES13)부터 JavaScript는 private 필드와 private 메서드를 지원하기 시작했습니다.
// 클래스 내에서 # 기호를 사용하면 해당 필드나 메서드는 클래스 내부에서만 접근 가능하게 됩니다.
/*
class MyClass {
  #privateVar;  // private 속성

  constructor() {
    this.#privateVar = 42;
  }

  #privateMethod() {  // private 메서드
    console.log("This is a private method.");
  }

  publicMethod() {
    console.log(this.#privateVar);  // private 속성에 접근
    this.#privateMethod();  // private 메서드 호출
  }
}
위 예제에서, #privateVar와 #privateMethod()는 외부에서 직접 접근할 수 없습니다.
*/

// protected
// 약속된 관례로 **_ (언더스코어)**를 사용하여 **"protected"**와 비슷한 역할을 하는 경우가 많습니다.
// 이는 실제로 접근 제어를 강제로 적용하는 것이 아니라, 코드 사용자에게 해당 속성이나 메서드가 "외부에서 접근해서는 안 되는" 것임을 알려주는 일종의 표기법입니다. 단순히 개발자들 간의 컨벤션입니다.

import tj703.homework.AccessModifierTest; // 외부 클래스 불러오기

class AccessA {
   private int b = 20;
   int a = 10; // default
   protected int d = 40;
   public int c = 30;
}

class AccessB extends AccessModifierTest { // 외부 클래스의 불러오기
   public String publicStr = super.str;
   // public String defaultStr=super.str2;  //  얘는 default니까 같은 패키지 안에서만 사용가능
   public String protectdStr = super.str3;
   // public String privateStr=super.str4;  // 얘는 private이니까 여기 클래스 내부에서만 사용가능
}

public class L23AccessModifier {
   public static void main(String[] args) {
      AccessModifierTest test=new AccessModifierTest();
      System.out.println(test.str); //public
//      System.out.println(test.str2); //default  //  같은 패키지가 아니므로 안됨
//      System.out.println(test.str3);//protected //  상속받은거 아니라서 안됨
//      System.out.println(test.str4);//private   //  priviate이니까 해당 클래스에서만 사용가능

   }
}
