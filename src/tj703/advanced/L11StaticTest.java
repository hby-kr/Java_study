package tj703.advanced;

class StaticTest {
   public int a = 10;
   public static int b = 20; // static을 썼으므로, main이 실행되는 동시에 객체로 생성됨

   public void add() { // 얘는 그냥 메서드
      System.out.println(a + b);
   }

   public static void staticAdd() { // 얘는 static 메서드
      // System.out.println(a+b); // a가 호출되지 않을 수 있으므로 a를 불러와서 연산하는 것 자체가 static 메서드로서 불가능하다.
      System.out.println(b + b); // static 변수만을 불러오거나, 이 메서드 자체가 매개변수를 직접받도록 설계해야 한다.
   }

}

public class L11StaticTest {

   public static void main(String[] args) {
      // b는 static을 썼으므로, main이 실행되는 동시에 객체로 생성됨

      System.out.println(StaticTest.b); // 호출할 때 클래스를 작성해서 클래스 변수라고도 한다.
      // System.out.println(StaticTest.a); // non-static variable a cannot be referenced from a static context
      // a는 꼭! 인스턴스 객체를 생성하고, 그 다음 인스턴스.a로 호출해야 한다.
      System.out.println(new StaticTest().a);
      // 그렇다면 인스턴스를 만들어서 b를 호출하면?
      System.out.println(new StaticTest().b); // 'tj703.advanced. StaticTest. b'이(가) 인스턴스 참조를 통해 액세스됩니다.
      // 즉 static으로 참조하고 있으니까, 이렇게 쓰면 잘못된 호출이야.라고 알려주는 것.

      StaticTest.staticAdd(); // static 메서드를 바로 불러와서 쓸 수 있음
      new StaticTest().add(); // 인스턴스 객체 만들어서 메서드 호출


   }

}
