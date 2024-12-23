package tj703.study;

/* 여러 언어의 상속 개념이 다르다.
java는 객체 지향 언어 => 클래스 기반 상속
js는 동적 언어, 프로토타입 언어 = 프로토타입 기반 상속

1. 클래스 기반 상속 (class-based inheritance)
      클래스 간의 관계를 통해서 상속의 상하관계를 정의하고, 생성되는 객체들은 이 클래스들의 인스턴스가 되어 상속을 받는 방식.
      Java에서 **상속(inheritance)**은 기본적으로 클래스 간의 관계를 나타냅니다.
      즉, 클래스 A가 클래스 B를 상속받는다고 할 때, A는 B의 특성(필드, 메서드)을 물려받고, 이를 바탕으로 확장하거나 수정할 수 있습니다.
      따라서, 인스턴스 객체를 기준으로 상속 관계를 논할 수는 없습니다.
      클래스는 객체의 설계도이고, 클래스 인스턴스 객체는 이 설계도를 기반으로 부모 클래스에서 자식 클래스 객체로 속성과 메서드를 물려받습니다.

2. 프로토타입 기반 상속 (prototype-based inheritance)
      프로토타입 기반 상속은 프로토타입을 통해 상속 관계를 설명. 객체가 다른 객체를 상속받는 방식입니다.
      JavaScript에서는 모든 객체가 기본적으로 prototype를 가진다는 특성을 가지고 있고, 이 prototype을 통해 메서드나 속성을 공유합니다.
      이는 객체 간의 상속을 의미하며, 클래스라는 개념이 없더라도 객체 간에 상속 관계를 만들 수 있습니다.
      JavaScript에서 모든 객체는 자신의 prototype 객체를 가지고 있으며, 객체가 메서드나 속성을 찾을 때, 먼저 자신의 속성을 확인한 후, (없으면) prototype 객체를 확인하게 됩니다. 즉, 객체가 다른 객체를 상속하는 형태입니다.

?? js에서도 class문법을 사용하잖아? 이건 뭘까.
    JavaScript의 class는 문법적 설탕(syntactic sugar).
    즉, 클래스는 실제로 프로토타입 기반 상속을 사용하기 위한 더 간단하고 읽기 쉬운 문법을 제공하는 방법일 뿐.
?? 그럼 js에서 함수는?
   JavaScript에서 함수는 중요한 객체로 취급되며, 함수는 기본적으로 객체이기도 합니다.

 */
public class L18Inheritance {
   public static void main(String[] args) {

// 상속이란, 객체가 다른 객체를 포함하도록 정의하는 방식.
// 모든 객체는 Object 객체를 포함하고 있다
// (== 자식의 인스턴스 객체가 생성될의 경우, 부모의 인스턴스 객체도 생성된다.)
// Object는 객체의 기본 형태를 설정해놓는 것.
/*  this와 super
   new String()을 만들면 동시에 this 와 super 필드가 만들어진다.
   그때 this는 나 자신을 가리키고 있고,
   super는 그 상위 객체인 new Object를 가리키고 있다.
   자식의 인스턴스 객체가 생성될의 경우, 부모의 인스턴스 객체도 생성된다.
     */


/*  JS 에서는...
 Object의 프로토타입(미완성 객체)를 만들어 놓고, 다른 객체를 만들때마다 __proto__로 참조.  __proto__는 자바의 super와 같다.
 (__proto__는 메서드가 아니라 프로퍼티입니다. 이 프로퍼티는 JavaScript에서 객체의 프로토타입을 참조하는 속성으로, 객체의 프로토타입 체인을 탐색하는 데 사용)
 ex)
 function User (){}를 선언하면, User.prototype이 만들어질 때 __proto__를 이용해  Object.prototype을 참조하면서 객체를 생성한다.
 const user = new User(); 인스턴스 객체를 만들면, User.prototype이 __proto__로 Object.prototype(상위 객체)을 참조하면서 객체를 생성한다.

 (js는 프로토타입이 객체이기 때문에, 객체가 조상이 될 수 있다)
 ?? new User()의 부모는 User.prototype인가? true
 ?? new User()의 부모는 function User인가? false
 ?? new User()의 조상은 function Object인가? Object.prototype인가? false
 js에서 function은 선언해놓은 문자열일 뿐이고,
 그것을 기준으로 만든 prototype이 해당 객체의 부모나 조상이 된다.

 const user - new User();
 user.__proto__ = 상속받고 싶은 프로토타입이나 객체 (Mem.prototype)
 class User extends Mem{} : (js가 java의 문법을 따라한다. 문법적 설탕)

new Meber() => Memeber 와 Parent 객체가 동시에 생성된다.
function A(){this.a="안녕"} function B(){this.__proto__=A.prototype;}
function A(){this.a="안녕"} function B(){this.__proto__=new A()}
new B().a  =>"안녕"

 */



/* java에서는
자바는 프로토타입이라는 미완성 객체를 만들어 놓지 않고, 정의된 타입(class)를 보고 객체를 생성한다.

Member mem = new Member(); 라고 할 때,
?? new Member()인 mem의 부모는 class Member인가? false
=> 자바에서는 객체의 나 자신의 class가 객체의 타입인 것 뿐이지 부모가 될 수 없다.
=> Member 클래스는 mem 객체의 타입을 정의. mem 객체의 설계도 역할을 합니다. 즉, Member는 mem 객체가 어떤 속성(필드)과 기능(메서드)을 가질지를 정의합니다.

?? new Member() 조상은 class Object인가? true
 mem은 Member 클래스의 인스턴스이지만,
 Member 클래스는 Object를 상속받고 있기 때문에 mem 객체의 부모 클래스는 Object입니다.

ㅡㅡㅡ
Java에서 객체의 부모를 논할 때, 부모가 되는 것은 클래스의 상속 관계입니다. 즉, 객체의 부모라는 개념은 해당 객체가 어떤 클래스에서 생성되었는지, 그리고 그 클래스가 어떤 클래스에서 상속되었는지와 관련이 있습니다.

클래스 상속 관계:
Member 클래스는 Object 클래스를 상속받습니다.
Member 클래스의 인스턴스인 mem은 Member 클래스에서 정의된 속성과 메서드를 가지며, 또한 Object 클래스에서 상속받은 기본 메서드들도 사용할 수 있습니다.

ㅡㅡㅡ
요약: mem 객체의 부모는 Object 클래스입니다. 즉, mem 객체는 Member 클래스의 인스턴스이지만, Member 클래스는 Object 클래스를 상속받기 때문에 mem 객체의 부모는 Object 클래스가 됩니다.
Member 클래스는 설계도일 뿐, 객체는 아니다. Member 클래스는 클래스입니다. 클래스를 객체화할 수 있는 설계도 역할을 합니다.

객체 vs. 클래스:
클래스는 객체를 만들기 위한 설계도이고, 객체는 그 설계도를 바탕으로 실제로 메모리 상에 존재하는 실체입니다.

ㅡㅡㅡ

1. 클래스 기반 상속 (class-based inheritance)
클래스 간의 관계를 통해 상속을 정의하고 객체들이 이 클래스들의 인스턴스가 되어 상속을 받는 방식.
클래스 기반 상속에서는 클래스가 객체의 설계도이고, 클래스 인스턴스는 이 설계도를 기반으로 속성과 메서드를 물려받습니다.
클래스 간의 상속은 상속 계층을 따라 일어나며, 메서드는 상속을 통해 부모 클래스에서 자식 클래스 객체로 전달됩니다.

2. 프로토타입 기반 상속 (prototype-based inheritance)
JavaScript에서 프로토타입을 통해 상속 관계를 설명.
프로토타입 기반 상속은 객체가 다른 객체를 상속받는 방식입니다.
JavaScript에서는 모든 객체가 기본적으로 prototype이라는 특성을 가지고 있고, 이 prototype을 통해 메서드나 속성을 공유합니다.
이는 객체 간의 상속을 의미하며, 클래스라는 개념이 없더라도 객체 간에 상속 관계를 만들 수 있습니다.
JavaScript에서 객체는 prototype 객체를 가지고 있으며, 객체가 메서드나 속성을 찾을 때, 먼저 자신의 속성을 확인한 후, prototype 객체를 확인하게 됩니다. 즉, 객체가 다른 객체를 상속하는 형태입니다.


ㅡㅡㅡ

java에서는 객체를 조상취급 하지 않는다. 타입(class)만 조상취급 한다.
(js는 프로토타입이 객체이기 때문에, 객체가 조상이 될 수 있다)

Parent p = new Member(); // new Member()를 만들 때, new parent()를 같이 만든다.
Object p = new Member(); // new Member()를 만들 때, new Object()를 같이 만든다.
?? Parent p2 = new Parent(); 이면 p2가 p의 부모인가? false

new Member().super=new Parent()
new Parent().super=new Object()
       */

      Member mem = new Member();
      Parent p = new Member();

      Object o = new Member();
      //new Member() 를 만들때 new Parent()와 new Object()가 만들어져서
      //new Member().super=new Parent().super=new Object()

      Parent p2 = new Parent();
      //p2(new Parent())가 p에 부모인가요?
      //p.super=p2; p.__proto__=p2,p2.prototype

      System.out.println(mem.age);
      System.out.println(mem.name);

      System.out.println(p.age); //Parent p=new Member();
      //System.out.println(p.name);
      //기본형 큰타입을 작은타입으로 변경 =>강제(o) Casting
      //Parent->Member (강제 : 부모타입이 자식보다 더 적게 정의되어 있기때문)

      System.out.println(((Member) p).name);
      //User s2=(User)p;
      Member upMem = (Member) p;
      //User u=(User)p;
      //java의 저버전에서는 p의 자식이 Member 인지 User 인지 몰라서 실행시 오류
      //현재버전에서는 p의 자식이 누구인지 확인하고 자식이 아니면 캐스팅을 못하게
      //컴파일 시 오류를 발생

   }
}

class Parent extends Object {
   int age = 38;
}

class Member extends Parent {
   String name = "경민";

   public Member() {
      //this.__proto__=Parent.prototype; (함수 내부에서 상속)
      //super=Parent;(X)
      //super=new Parent();(X)
   }
}
// new Member() => Member와 Parent 객체가 동시에 생성된다.


// + 부모가 생성자를 가지고 있다면, 자식은 그 생성자의 규칙을 꼭 따라야한다는 java의 원칙이 있다.
