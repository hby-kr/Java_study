package tj703.study;

// 동적 디스패치와 정적 디스패치
// 동적 바인딩과 정적 바인딩에 대한 설명

// 메서드는 오버라이딩을 위해, 동적 디스패치 규칙이 적용되나,
// 필드는 정적 바인딩 된다. 오버라이딩이라고 말하지도 않음. 그냥 재정의

public class L22OverrideFeild {

   class A {
      int a = 10;

      @Override
      public String toString() {
         return "저는 A 입니다. 오호호..";
      }
   }

   class B extends A {
      int a = 20;
   }

   class C extends B {
      int a = 100;

      @Override
      public String toString() {//해당 객체에 대한 설명
         return "나는 클래스 C 이다 우하하~";
      }
   }

   //main은 L22OverideFeild에 존재하지 않는 별개의 영역(static)
   public static void main(String[] args) {
      L22OverrideFeild o = new L22OverrideFeild();
      A a = o.new C();
      System.out.println(a.a); // 10  => 정적디스패치
      System.out.println(a); //==a.toString() / 즉 메서드이므로 동적 디스패치 //Object.toString()
      //com.tj703.study.L22OverideFeild$C@4a574795 :
      //C toString 재정의(Override) 했기때문에 동적 디스패치로 재정의된 것을 호출

      //문제! a가 참조하는 객체를 C타입의 변수가 참조하고 그 변수의 필드 a를 호출  /hint. Casting
      C c = (C) a;
      System.out.println(c.a);
      // 부모 클래스 타입의 변수를 자식 클래스 타입으로 바꾸는 것(강제 형변환 Casting)은 위험하다.
      // 위험하다고 말하는 이유는, 부모 타입 변수로 자식 클래스 객체를 참조할 때,
      // 자식 클래스에서 추가된 특성이나 메서드를 사용할 수 없기 때문이에요.
      Object objC = c;
      // 자식 클래스 객체를 부모 타입 변수로 참조하는 것은 자연스럽고 안전해요. 상속.

   }
   /*
1. 기본형 타입에서의 형변환:
   - 자동 형변환 (데이터의 크기가)(큰 타입 → 작은 타입)
   - 명시적 형변환 (작은 타입 → 큰 타입, 데이터 손실 가능)

2. 객체 타입에서의 형변환:
   - Upcasting: 자식 객체를 부모 타입으로 변환, 자동 형변환. 상속관계이므로 자연스러운 상황.
   - Downcasting: 부모 객체를 자식 타입으로 변환, 명시적 형변환 필요 (잘못된 형변환 시 ClassCastException).
    */
}