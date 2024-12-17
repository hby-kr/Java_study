package tj703.study;

public class L07NumberOperator {
   // 연산자 Operators

   public static void main(String[] args) {

/* JavaScript와 Java에서의 데이터 연산자들을 비교

* >> 공통으로 사용 가능한 연산자

1. 산술 연산자 (Arithmetic Operators)
+, -, *, /, % : 두 언어에서 모두 동일하게 사용됩니다.

* 2. 비교 연산자 (Comparison Operators)
==, !=, >, <, >=, <= : 두 언어에서 모두 동일하게 사용됩니다.
* 주의: == 연산자는 JavaScript에서는 형변환을 일으킬 수 있지만, Java에서는 강력한 타입 검사로, 형변환 없이 비교가 수행됩니다. (===와 !==는 JavaScript에서 엄격 비교 연산자입니다.)

* 3. 논리 연산자 (Logical Operators)
&& (AND), || (OR), ! (NOT) : 두 언어에서 모두 동일하게 사용됩니다.

* 4. 대입 연산자 (Assignment Operators)
=, +=, -=, *=, /=, %= 등 : 두 언어에서 모두 동일하게 사용됩니다.

* 5. 증감/감소 연산자 (Increment/Decrement)
++, -- : 두 언어에서 모두 동일하게 사용됩니다.

* 6. 비트 연산자 (Bitwise Operators)
&, |, ^, ~, <<, >>, >>> : 두 언어에서 모두 동일하게 사용됩니다.

ㅡㅡㅡㅡㅡㅡ
JavaScript에서만 사용되는 연산자
===, !==:
JavaScript에서만 사용되는 엄격 비교 연산자입니다. ===와 !==는 타입까지 고려하여 비교합니다.
Java에서는 == 만 사용되며, Java는 기본적으로 형변환을 하지 않기 때문에 ==는 타입까지 동일한 값을 비교합니다.
 */


      /*
        js : +,-,*,/,%,** (>>,<<,~)
        java : +,-,*,/,%,Math.pow() (>>,<<,~)
        **는 js에서만, java에서는 Math.pow()를 쓴다.
      */
      int i = 10 + 20;
      i = 10 - 20;
      i = 10 * 20;

      //i=2**5;
      i = (int) Math.pow(2, 5); //거듭제곱의 결과가 큰수기 때문에 double 을 반환

      System.out.println(i);
      System.out.println(10 / 3); //3.33333333333333333 (x) => 3
      // 중요!!! 정수를 정수와 연산하면 무조건 정수를 반환
      System.out.println(10 / 3.0);
      double d = 10 / 3;
      System.out.println(d);

      i = 10 % 3; //1
      i = 10 % 4;
      System.out.println(i);
      i = 2 >> 1;  //0010 => 0001
      System.out.println(i);
      i = 2 >> 2;  //0010 => 0000
      System.out.println(i);
      i = 2 << 2; //8  //31 bit
      i = 2 << 30;  //**sign bit 까지 이동
      System.out.println(i);
      i = 2 << 31;
      System.out.println(i);
      i = ~0;
      System.out.println(i); //00000000 -> 11111111
   }
}
