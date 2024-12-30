package tj703.advanced;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class L09StreamAPI {
   // stream API는 반복문 작성을 편하게하고, 반복함수를 재사용하기 위한 내부 반복문.
   // 스트림은 데이터의 흐름을 나타냅니다. 컬렉션, 배열 등 다양한 데이터 소스로부터 데이터를 가져와서 연산을 처리하는 추상적인 개념

   public static void main(String[] args) {
      List<Integer> nums = new ArrayList();
      nums.add(11);
      nums.add(12);
      nums.add(13);
      nums.add(14);
      nums.add(15); // {11,12,13,14,15}

      // index조회하기
      System.out.println("for문");
      for (int i = 0; i < nums.size(); i++) {
         System.out.println(nums.get(i) + ",");
      }

      // 얘는 느림. 그래서 iterator 사용 ; iterator 외부반복문
      System.out.println("for iterator 외부반복문");
      for (int num : nums) {
         System.out.println(num + ",");
      }

      // iterator 내부반복문
      System.out.println("for iterator 내부반복문");
      nums.forEach(new Consumer<Integer>() {
         @Override
         public void accept(Integer integer) {
            System.out.println(integer + ",");
         }
      });
      // 람다식 표현
//      callBack = (num)->{
//            System.out.println(num+",");
//      };
//      nums.forEach(callBack);

      int[] numArr = {44, 55, 66, 77};
      // [] Array는 가볍기 때문에 iterator 메서드가 없음. 불만이 생김.
      // 속도도 빠르고, 모든 배열타입은 쓸 수 있는 자료형 도구 만듬 => Stream.


      Stream numstreams = nums.stream(); // 이때 num은 배열인데 stream자료형 데이터로 바뀜 / Stream은 자료형 전용 스트림
      IntStream numArrstreams = Arrays.stream(numArr);  //  IntStream처럼 stream 앞에 이름 있으면 기본형 전용 스트림.\

      // stream은 foreach 있음.
      // numstreams.forEach((n) -> {      });
      // numArrstreams.forEach((n) -> {      });
      // stream은 1회용 자료. 그래서 위에서 한 번 쓰면 밑에서 또 쓸 수 없음. 그래서 주석처리함.

      // js의 filter, map, reduce 등 있듯이
      // stream에도 여러 메서드들이 있음
      /*
      중간 연산(Intermediate Operations):
         스트림에서 데이터를 변형하거나 필터링하는 연산. 예를 들어, filter(), map() 등이 있습니다.
      최종 연산(Terminal Operations):
         스트림을 종료시키고 결과를 생성하는 연산. 예를 들어, collect(), forEach(), reduce() 등이 있습니다.
       */

      /*
      OptionalDouble avg = numArrstreams.average();
      avg.ifPresent((n)->{
         System.out.println("평균값은" + n);
      });
       */
//
//      numArrstreams2
//            .map((n)->{return n/10};)
//            .forEach((n)->{
//         System.out.println("sdsf");
//      });

      // stream은 체이닝이 가능함.




   }

}
