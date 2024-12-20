package tj703.study;
// L19와 같은 설명

public class L20InheritanceConstructor {
   class A {
      int a;
      A (int a) {
         this.a =a;
      }
   }

   class B extends A{
      int b;

      B(int b) {
         super(b);
      }
   }

   class C extends B {
      // C가 B를 상속 받았기 때문에 부모의 생성자 규칙을 따라야한다.라고 설명하면 틀린 것은 아니나 불완전한 설명.

      // public C (){super();}  <- 이것이 생성자가 만들어진다.
      // 자동으로 만들어지는 default 생성자

      // 그런데 부모 클래스에서 생성자를 개발자가 원하는 규칙으로 생성자를 바꾸면,
      // 자식입장에서 기존의 생성자로는 부모객체를 만들지 못하기 때문에 오류가 나는 것
      C(int c) {
         super(c);
      }
      // 따라서 (위와 같이) 자식 안에서 자식의 인스턴스 객체가 생성될 때, 반드시 선행되는 부모의 인스턴스 객체를 만들기 위한 수정된 생성자를 재정의 해줘야 오류가 해결된다.

   }
}
