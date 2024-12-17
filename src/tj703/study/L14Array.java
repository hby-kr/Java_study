package tj703.study;

import java.util.Arrays;

public class L14Array {

   public static void main(String[] args) {
      // Array;  순서(index)가 있고, 길이가 있는 자료
      // index란 1) 배열의 순서  2) db에서는 목차

      int[] arr = {}; // 배열 선언하는 법

      int[] nums = {1, 2, 3}; // 리터럴 선언법; 리터럴 선언법은 꼭 변수를 선언하면서 바로 값 대입
      System.out.println(nums);
      int[] nums2 = {1, 2, 3,}; // 3 뒤에 콤마가 있고 없고 차이. 콤마가 있으면 알아서 지운다.
      System.out.println(nums2[0]);
      System.out.println(nums2[1]);
      System.out.println(nums2[2]);
      // System.out.println(nums2[3]); // 오류. 값이 없으니까. [js에서는 undifined가 뜸]

      int[] numArr = new int[4];  // 길이만 선언 / -> {0,0,0,0}  / 0이 비어있다는 뜻이니까.
      // 얘는 리터럴 선언법이 아님. 배열 객체를 생성.
      // 최초의 길이에서 변하지 않는다. (push, pop과 같이 배열의 길이를 변화시킬 수 없음)
      System.out.println(numArr[0]);
      System.out.println(numArr[1]);
      System.out.println(numArr[2]);
      System.out.println(numArr[3]);
      // js는 Array가 존재하지 않고, java의 ArrayList와 유사한 객체가 만들어진다. 길이변화가 가능함.


      // Java Array toString()이 재정의 되어있지 않아서 타입+메모리 주소가 출력된다.
      System.out.println(numArr); // [I@2f4d3709

      String[] strArr = {"안녕", "하세요"};
      System.out.println(strArr); // [Ljava.lang.String;@4e50df2e

      Integer[] objIntArr = {1, 2, 3, 4}; // Integer : int의 랩퍼타입
      System.out.println(objIntArr); // [Ljava.lang.Integer;@1d81eb93
      // [  =  Array다.
      // [I =  기본형을 참조하는 Array다.
      // [L =  자료형을 참조하는 Array다.
      // java.lang.Integer  = 타입 설명
      // @23342423  = 메모리 주소

      boolean[] boolArr = {true, true, true, true, false};
      System.out.println(boolArr); // [Z@7291c18f
      // [Z =  boolean 자료형을 참조하는 Array다.

      char[] charArr = {'안', '녕', '함', '?'}; //  "안녕함?"을 선언하면 {'안', '녕', '함', '?'}이 생성된다
      System.out.println(charArr); // 문자열인척 출력된다.
      char[] charArr2 = {'응', '?'};


      // 배열은 더하기 연산이 안된다.
      // System.out.println(boolArr + boolArr);

      // char는 기본형이니까 더하기 연산이 되나?
      System.out.println(charArr + "오옹오?"); // [C@34a245ab오옹오?
      // 더하기는 자체는 되나, 주소가 뜸. 제대로 작동 안함.
      // System.out.println(charArr + charArr2); / 오류남


      // Arrays : []배열을 지원하는 클래스 (기본형의 랩퍼클래스와 유사한 역할)
      System.out.println(Arrays.toString(numArr));
      System.out.println(Arrays.toString(boolArr));
      System.out.println(Arrays.toString(charArr));

      // System.out.println(nums==objIntArr); 기본형과 자료형은 비교조차 할 수 없음
      // 자료형끼리도 완전히 같은 것(본인)이 아닌 이상 무조건 false
      int[] nums3 = {1, 2, 3, 4};

      // System.out.println(nums.equals(nums2));
      System.out.println(Arrays.equals(nums, nums2));
      // System.out.println(Arrays.equals(nums, objIntArr));


      // for 반복문
      //  (선언문;      조건문;          증감식)
      for (int i = 0; i < nums.length; i++) {
         // 선언문(초기문);  최조 한번 만 동작
         // 조건문 : 조건이 true이면 해당 블럭을 반복 실행, false면 블럭을 실행하지 않고 종료
         // 증감문 : 초기에 선언한 값에 증감을 주어 조건을 변화시킨다. (;을 사용하지 않는 이유는 i의 값이 계속 변하기 때문)
         System.out.println( nums[i]);
      }
      System.out.println("증가 반복문 실행했음");

      for (int i = nums.length-1; i >=0 ; i--) {
         System.out.println( nums[i]);
      }
      System.out.println("감소 반복문 실행했음");


   }
}
