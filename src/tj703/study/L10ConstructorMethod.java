package tj703.study;

class OutType {
   // InType in = new Intype();
   InType in = this.new InType();
   // this== new Outtype()

   class InType { // 클래스 안에 클래스
      // 클래스를 너무 많이 선언하기 싫어서,
      // outType 내부에서만 사용되는 자료의 타입을 정의해서 사용한다.

      // 전역 변수 설정하기
      int a = 0;
      int b; // 기본형은 null 또는 undefined를 정의할 수 없음. 때문에 자동으로 0이 된다.
      // 기본형에서 없다라는 데이터 == 0 이므로.
      double d; // 0.0
      float f;  // false
      char c; // 없음기호
   }
}


public class L10ConstructorMethod {
   User user = new User(39, "하니");

   //  public class 안에서 내부 클래스를 설정하기. 이 파일 안에서만 쓰겠다는 것.
   class User {

      // 전역변수 설정
      int age;
      String name; // java는 필드를 먼저, 따로, 전역에서 정의해줘야 함!!

      // 생성사 설정
      public User(int age, String name) {
         this.age = age;
         this.name = name;
      }

      // 메서드 설정
      public int add(int[] nums) {
         int add = 0; // int인 변수설정과, 마지막 return으로 이 변수를 내놓는 것이 필수적.

         // for (let num of nums){ }// js에서의 Iterator반복문

         /* Iterator가 더 빠르므로 이것을 더 많이 사용하면 좋다.
         for (int num : nums) {
            add += (num);
         }
         */

         // for 반복문
         for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            add += (num);
         }
         return add;
      }

   }


   public static void main(String[] args) {

      OutType out = new OutType();
      System.out.println(out.in.a); // 아웃의 인의 필드를 쓰려고 하는 것.
      System.out.println(out.in.d);
      System.out.println(out.in.f);
      System.out.println(out.in.c);

      // 보통 innerclass를 다른 곳에서 굳이 하고 싶다면..
      OutType.InType in = new OutType().new InType(); // 사용 안함.
      out = new OutType();
      OutType.InType outin = out.new InType(); // 아주 희귀하게 사용됨


      // Q. main에서 User 객체를 만들라.
      // User는 필드로 age,name가 있고, 둘다 생성자로 초기화 해야한다.
      L10ConstructorMethod l10 = new L10ConstructorMethod();
      System.out.println(l10.user.age);
      System.out.println(l10.user.name);

      User user = l10.new User(41, "둘리");   // 해당 클래스 내부의 USer가 하나 뿐이기 때문에 L10ConstructorMethod을 생략
      L10ConstructorMethod.User user2 = l10.new User(38, "최경민"); // 권장방식


      int[] nums = {10, 20, 30, 40, 50};
      int add = l10.user.add(nums);
      System.out.println("10, 20, 30, 40, 50 각 아이탬의 합 : " + add);

   }
}
