package tj703.homework;

public class AccessModifierTest {
      public String str= "퍼블릭한 str";
      String str2= "기본 str";  // 얘는 default니까 같은 패키지 안에서만 사용가능
      protected String str3= "보호받는 str";
      private String str4="개인적인 str"; // 얘는 private이니까 여기 클래스 내부에서만 사용가능

}
