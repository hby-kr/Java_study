package tj703.study;

public class L17TwodimensionalArray {

   public static void main(String[] args) {
      // 2차원 배열에 대해 알아보자.
      // 간단히 말하면 "배열 안에 배열"이 있는 구조
      int[] arr = {12, 13, 14};  // 그냥 배열
      int[][] twoArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 2차원 배열
      String[] strArr = {"123", "456", "789"}; // 이 또한 2차원 배열 / 문자열이 배열 객체니까.

      String str = "안녕하세요"; // 기본형데이터 아님, char의 배열 객체임. {'안', '녕', '하','세', '요'}
      System.out.println(str.charAt(1));
      System.out.println(str.charAt(3));

      char[] cArr = str.toCharArray();
      System.out.println(cArr);
      for (char c : cArr) {
         System.out.println(c + ",");
      }

      System.out.println("\n {\"123\", \"456\", \"789\"} ");
      for (String s : strArr) {
         char[] cs = s.toCharArray();
         for (char c : cs) {
            System.out.println(c + ",");
         }
         System.out.println();
      }

// 문제풀기
      // twoArr의 모든 데이터를 더해서 출력하라
      System.out.println("\n {1, 2, 3}, {4, 5, 6}, {7, 8, 9}");
      int sum = 0;
      for (int[] intArr : twoArr) {
         for (int intnum : intArr) {
            sum += intnum;
         }
      }
      System.out.println("sum: " + sum);

      // strArr의 모든 데이터를 더해서 출력하라
      System.out.println("\n strArr = {\"123\", \"456\", \"789\"} ");
      sum = 0;

      for (String Arr : strArr) {
         char[] chaArr = Arr.toCharArray();
         for (char c : chaArr) {
            int num = Character.getNumericValue(c);
            sum += num;
         }
      }
      System.out.println("sum: " + sum);
   }
}
/*
// 2차원 배열의 선언법
//    int[][] array = new int[3][4];

// 2차원 배열에 값 넣기
   array[0][0] = 1;  // 첫 번째 행, 첫 번째 열에 값 1 넣기
   array[0][1] = 2;  // 첫 번째 행, 두 번째 열에 값 2 넣기
   array[1][0] = 3;  // 두 번째 행, 첫 번째 열에 값 3 넣기
   array[2][3] = 10; // 세 번째 행, 네 번째 열에 값 10 넣기
배열은 new 키워드를 사용하여 생성하고, 인덱스를 통해 값을 접근합니다.

중첩된 for문을 사용하여 2차원 배열을 순회하면서 값을 출력할 수 있습니다.

 */

