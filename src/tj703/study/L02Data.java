// 1. 패키지 선언 (선택 사항)
package tj703.study;

// 2. 임포트 선언 (선택 사항)
import java.util.ArrayList;
import java.util.Arrays;

// 3. public 클래스 정의
public class L02Data {

    // 여기 영역에 여러 내부 클래스를 정의할 수 있음.

    // main 메서드 (프로그램 진입점)
    public static void main(String[] args) { // 실상에서는 main은 한번만, 어플리케이션에서 main은 한번만.

        System.out.println(14);      // 정수 (js에는 없는 데이터 종류)
        System.out.println(14.0);    // 실수

        System.out.println("문자열"); // 문자열 (java에서는 자료형임)
        System.out.println("s");     // 문자char (js에는 없는 데이터 종류)

        System.out.println("true");  // boolean
//      System.out.println("null");  // null: 비어있음. 출력 못함

        System.out.println(new ArrayList()); // 배열자료형
        int[] arr = {1, 2, 3}; // 리터럴하게 표기한 배열자료형 (출력 안됨)
        System.out.println(arr);  // [I @b4c966a 객체가 저장된 주소
        System.out.println(Arrays.toString(arr));  // java.util.Arrays; 리터럴하게 표기한 배열의 지원 클래스

        Mem m = new Mem();
        System.out.println(m); // js와 같은 객체명세서가 없다. 따라서 그냥 데이터의 주소만 뜸 // tj703.study.Mem@4e50df2e
        System.out.println("멤버의 나이는 " + m.age);
        System.out.println("멤버의 나이는 " + m.name);
    }
}

// 이미 앞서 L01에서 클래스 User를 만들었으므로, 동일한 패키지 안에서 동명의 클래스를 만들 수 없다.
class Mem {
    int age = 38; // 변수 앞에 변수의 타입을 먼저 적어야 한다.
    String name = "최경민";
    }
