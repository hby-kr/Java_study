package tj703.study;

public class L19Inheritance {
   class A {
      int a = 10;
      // 여기 안에 필드가 200개 정도 있다고 치자.

      public int add(int a, int b) {
         return a + b;
      }

      A(int a) {
         this.a = a;
      }
      // 부모가 매개변수가 있는 생성자만들어서 강제하고 있는 중
      // => 자식인 B가 부모인 A의 생성자를 호출하면 오류가 해결됨
   }

   class B extends A {
      // B에서 A와 거의 유사한데 조금 다른게 구현하고 싶다......면 => 상속
      // B의 부모로 A를 지정하면, A가 정의하는 모든 필드를 B가 사용할 수 있다.
      // =>  B extends A
      int b = 20;

      B(int b) {
         // 부모가 생성자를 강제하면, 자식에서 부모의 생성자를 호출하기 전까지는 아무것도 할 수 없다.
         // 이때 super()로 부모의 생성자를 호출할 때는 자식필드(this)는 호출할 수 없다.
         super(b);
         // 이런 일이 왜 벌어지냐. 자식을 만들 때, 꼭 부모가 먼저 만들어지기 때문.
      }
   }

   class C extends B {
      // 자동으로 만들어지는 default 생성자
      // public C (){super();}  <- 이것이 생성자가 만들어진다.
      // 그런데 부모 클래스에서 생성자를 개발자가 원하는 규칙으로 생성자를 바꾸면,
      // 자식입장에서 기존의 생성자로는 부모객체를 만들지 못하기 때문에 오류가 나는 것
      C (int c) {
         super(c);
      // 따라서 (위와 같이) 자식 안에서 자식의 인스턴스 객체가 생성될 때, 반드시 선행되는 부모의 인스턴스 객체를 만들기 위한 수정된 생성자를 재정의 해줘야 오류가 해결된다.
      }
   }


   public static void main(String[] args) {
      L19Inheritance o = new L19Inheritance(); // inner class 불러오기
      // 보통은 이렇게 안하고 수업이라 하는 것.
      B b = o.new B(2);
      System.out.println(b.a);
      System.out.println(b.b);

      // class A에 메서드 추가했음
      System.out.println(b.add(13, 65));
   }

}
