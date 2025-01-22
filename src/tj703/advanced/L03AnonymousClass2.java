package tj703.advanced;

interface A{
   void test();//추상메서드는 미완성된 설계도
}

public class L03AnonymousClass2 {
   //L03AnonymousClass2$Aable.class
   class Aable implements Ainter {
      @Override
      public void test() {
      }
   }
   public static void main(String[] args) {
      //인터페이스(interface), 추상클래스(abstract class) :추상메서드가 있어서 객체가 될 수 없다.
      //A a=new A();
      Ainter a=new Ainter(){
         @Override
         public void test() { //$1.class 에 정의된다. :생성과 동시에 메서드 구현

         }
      }; //컴파일러가 아래의 과정을 대신한다. 이때 Aable 의 이름은 임의 숫자가 되고
      //임의 숫자 클래스를 익명클래스라 한다. L03AnonymousClass2$1.class
      //익명클래스는 생성과 동시게 구현하는 메소가 재사용될 가능성이 없을 때 정의합니다.
      //익명클래스의 장점 : 메소드를 매개변수로 작성하기 위해 매번 클래스를 작성할 필요가 없다.=>코드 생산성 상승
      //**주의! 여러번 사용할 될 함수를 정의할 때는 클래스를 작성하고 재사용해야 코드 생산성이 올라간다.
      L03AnonymousClass2 o=new L03AnonymousClass2();
      Ainter a2=o.new Aable();

   }
}
