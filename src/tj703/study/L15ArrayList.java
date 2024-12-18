package tj703.study;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/*   java의 배열은 크게 둘로 나뉜다.
1. [] Array: 가볍고 심플하게 정의되어, 길이를 수정할 수 없고, 타입이 명확한 배열 타입. (자료형)
2. (그밖에) ArrayList, LinkedList.... :
   pop,push등으로 배열의 길이를 수정할 수 있음.
   배열의 처리를 지원하는 메서드가 다수 존재하는 배열 타입   */

public class L15ArrayList {

   public static void main(String[] args) {

      ArrayList numList = new ArrayList();
      // 리터럴하게 값을 대입할 수 없음
      numList.add(11); // add는 (js의) push와 같은 기능
      numList.add(22);
      numList.add(33);

      System.out.println(numList);  // [11, 22, 33]

      numList.add(44);
      System.out.println(numList); // [11, 22, 33, 44]

      numList.add(1, 100);
      System.out.println(numList);  // [11, 100, 22, 33, 44]

      numList.removeLast();
      System.out.println(numList);  // [11, 100, 22, 33]

      numList.remove(1);
      System.out.println(numList);  // [11, 22, 33]

      numList.remove(Integer.valueOf(22));
      System.out.println(numList);  // [11, 33]


//    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      ArrayList<Integer> objNumList = new ArrayList<>();
      objNumList.add(Integer.valueOf(11));
      objNumList.add(Integer.valueOf(22));
      objNumList.add(Integer.valueOf(33));
      System.out.println(objNumList);
      objNumList.remove(Integer.valueOf(22));
      System.out.println(objNumList);


      Integer objInt = Integer.valueOf(22);
      Integer objInt2 = Integer.valueOf(22);
      System.out.println(objInt == objInt2); // true???? 래퍼클래스는 자료형인데??
      // 기본형 랩퍼클래스는 동등비교시, (뒤로 빠지고) 기본형을 반환해서 비교한다.
      System.out.println(objInt.intValue() == objInt2.intValue()); // 이것을 자동으로 처리하는 것

      System.out.println(objInt.equals(objInt2)); // true / value만 비교하기 때문


      ArrayList<String> strList = new ArrayList();
      strList.add("자바");
      strList.add("자바스크립트");
      strList.add("파이썬");
      strList.add("스프링");
      System.out.println(strList);
      strList.remove("파이썬");
      System.out.println(strList);


//    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      // ArrayList의 내부 반복문: forEach ; forEach는 콜백함수를 반복실행하는 것.

      AtomicInteger i = new AtomicInteger(1); // 이거 아직 몰라도 됨. 자동변환한 것. / int i =0;과 같은 것

      strList.forEach((item) -> {
         System.out.println((i.getAndIncrement()) +":"+ item);
      });


      // 외부 반복문. (for문이 밖에 있으므로 외부)

      // 모든 배열 객체는 Iterable하므로, Iterator를 쓸 수 있다 = forEach를 쓸 수 있다. (java, js 공통)
      // [js]
      int n = 0;
      for (String str : strList){
         System.out.println((n++)+ ":" +str);
      }


   }
}

/*
JavaScript에는 for...of와 for...in 외에도 여러 반복문이 존재.

for...of와 for...in의 차이점
사용 대상에 있어서
for...of는 반복 가능한 객체 (배열, 문자열, 셋, 맵 등)
for...in는 객체의 속성(열거 가능한 속성) 또는 배열의 인덱스

JavaScript에는 반복문 외에도 다양한 방법으로 반복 작업을 처리할 수 있습니다.
 예를 들어:
forEach(): 배열의 각 요소에 대해 콜백 함수 실행
map(): 배열을 변환하여 새로운 배열 반환
filter(): 조건에 맞는 요소만 필터링
reduce(): 배열을 누적 계산하여 단일 값 반환
do...while 반복문
for await...of: 비동기 반복
타이머 함수(setInterval(), setTimeout()): 일정 시간 간격으로 반복 작업 수행

ㅡㅡㅡ
>> do...while 반복문
do...while 반복문은 최소 한 번은 실행되고, 조건을 마지막에 평가하는 반복문입니다. 일반적인 while 반복문은 조건이 처음부터 false일 경우 한 번도 실행되지 않을 수 있지만, do...while 반복문은 조건을 확인하기 전에 먼저 실행되기 때문에 최소한 한 번은 실행된다는 점이 특징

 */
