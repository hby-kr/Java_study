package tj703.study;

// bean; 캡슐화된 콩들
// Java에서 사용되는 특별한 형태의 클래스이며, Java Bean은 특정 규칙을 따른다.

public class L24Bean {

   class Member {
      // bean 객체의 구조

      // 속성 (Properties) 영역
      private String id;
      private String name;
      private int age;
      // id, name, age가 캡슐화된 콩이다.


      //  getter와 setter 메소드의 영역
      // 각 속성에 접근하기 위해 getter와 setter 메소드를 제공합니다.
      // getter는 속성 값을 가져오는 메소드이고, setter는 속성 값을 설정하는 메소드입니다.

      // idd의 getter와 setter
      // 캡슐화된 id의 값을 대입하는 set 함수
      public void setId(String id) {
         if (id.length() > 5) {
            this.id = id;
         }
      }

      // 캡슐화된 id의 값을 반환하는 get 함수
      public String getId() {
         if (id != null && id.length() > 5) {
            return this.id;
         } else {
            return "아이디 없음";
         }
      }

      // name의 getter와 setter
      public void setName(String name) {
         this.name = name;
      }

      public String getName() {
         return this.name;
      }

      // 설계의 규약 Design Guideline 이 받아들여진 것 => 자동완성 가능.
      // 생성 기능을 활용해서 아래를 만듬
      public int getAge() {
         return age;
      }

      public void setAge(int age) {
         this.age = age;
      }

   }

/*
* Bean(getter setter) 객체를 작성하는 이유!
 1. 데이터를 안전하게 보관(private)하기 위해서 캡슐화
    데이터(속성)가 private로 선언되고, getter와 setter 메소드를 통해 접근하므로 데이터의 캡슐화가 가능합니다.
 2. 코드 작성을 유연하게 할 수 있다.(유효성 검사 추가가 용이)
 3. 코드 중복을 막고 유지보수가 용이해진다.(Member bean 을 하나 만드록 재사용)
 4. 생산성 증가 (설계의 규약에 따라 작성하기 때문에 개발툴에서 자동완성 제공,lombok )
   - 편리한 관리: Java Bean은 주로 Java의 다양한 프레임워크에서 활용됩니다. 예를 들어, Spring 프레임워크에서는 Bean을 객체로 등록하여 의존성 주입(Dependency Injection) 등을 수행합니다.
   - 직렬화 가능 (Serializable)
   - 재사용성: Java Bean은 객체 지향 설계 원칙에 맞게 작성되어, 다른 클래스나 프로그램에서 재사용이 용이합니다.
   Java Bean은 Serializable 인터페이스를 구현할 수 있습니다.
   이는 객체를 파일이나 네트워크를 통해 전송할 수 있게 합니다.
 */

   public static void main(String[] args) {
      Member mem = new L24Bean().new Member();
      mem.setId("dddddd");
      mem.setName("nanana");
      mem.setAge(99);
   }
}
