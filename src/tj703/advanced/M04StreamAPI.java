package tj703.advanced;

import java.util.*;

public class M04StreamAPI {
    // Stream 말고, StreamAPI를 기억해야함.
    // Stream이 입출력의 흐름이라고 하는 의미가 있어서, StreamAPI라고 따로 부름.

    // List든, Array든 Iterator 사용가능.
    // List는 반복이 가능한 메서드드가 좀 있음.
    // Array는 아님. Array는 엄청 가벼운 배열. // 메서드 많이 없음.

    // Stream API는 자바 8에서 도입된 강력한!! 기능으로,
    // 컬렉션 데이터(예: List, Set 등)에 대해 선언적이고, 함수형 스타일(람다식으)로 데이터를 처리할 수 있도록 도와줍니다.
    // Stream은 데이터를 필터링, 변환, 정렬하는 등의 작업을 효율적으로 할 수 있게 해줍니다.

    // stream도 "데이터 처리의 흐름"을 나타내는 하나의 추상화된 개념이다.
    // (그러니 스트림 자체는 크기 개념 없음, 데이터를 처리하는 과정에서 동적으로 처리)
    // 즉, 스트림 자체는 데이터를 담고 있지 않습니다. 실제 데이터를 저장하는 저장소는 아닙니다.

    // 기본적으로 Stream은 자료를 저장하는 구조가 아니라 자료를 처리하는 중간 단계를 담당합니다.
    // 이것으로 만들고, 마구마구 메서드를 사용하는 것.
    // 데이터를 처리하는 파이프라인을 구성하고, 데이터를 변환하고, 필터링하고, 수집하는 등의 작업을 순차적 또는 병렬적으로 수행하는 데 사용

    // Stream은 불변(immutable) 하며, 인덱스 접근도 지원하지 않습니다.
    // 데이터를 처리할 때마다 새로운 스트림을 반환합니다.
    // 스트림을 한 번 사용한 후에는 다시 사용할 수 없습니다.

    // OK. 그럼 어떻게 사용?
    // Collection은 stream() 메서드를 통해 스트림으로 변환할 수 있습니다.
    // 배열은 Arrays.stream() 메서드를 사용하여 스트림으로 변환할 수 있습니다.




    public static void main(String[] args) {
        // 반복문 검색 방법

        // > 외부반복문  :  반복문이 직접 코드로 드러난다.
        //  1. 직접 참조         :  for (int i = 0; i < ; i++) {arr[i]}
        //  2. Iterator 이용    :  for (int n : arr){}   (has next, next 메서드 사용)
        // > 내부 반복문 : 반복과정을 함수 메서드를 호출해서 작동시킨다.
        //  3. StreamAPI (자바)
        //      : Arrays.stream().foreach((n)->{})
        //      : list.stream().foreach((n)->{})

        // js는 내부반복문 메서드를 List 타입에 모두 내부에 구현해놓은 상태
        // java는 없다가, 자바8에서 도입하기 시작. -> StreamAPI

        /*    Stream API 사용 방법
            1. Stream 생성: 컬렉션에서 stream() 메서드를 사용해 Stream을 생성
            2. 중간 연산: 데이터에 변환, 필터링 등의 작업을 할 수 있는 중간 연산을 적용합니다. 중간 연산은 지연(lazy) 방식으로 실행됩니다.
            3. 최종 연산: 중간 연산 후 최종적인 작업을 수행하는 최종 연산을 합니다. 이 단계에서 실제로 스트림이 처리됩니다.
         */


        // 데이터 리스트 생성
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // Stream을 사용하여 짝수만 필터링하고 두 배로 만든 후 출력
        numbers.stream()  // Stream 생성
                .filter(n -> n % 2 == 0)  // 짝수만 남김
                .map(n -> n * 2)  // 각 값을 두 배로 변환
                .forEach(System.out::println);  // 결과 출력


        /* 설명:
        stream(): 리스트에서 스트림을 생성합니다.
        filter(): 짝수만 남기는 필터링 작업을 합니다. 조건에 맞는 요소만 처리합니다.
        map(): 스트림의 각 요소를 두 배로 변환합니다.
        forEach(): 최종 연산으로, 각 변환된 결과를 출력합니다.
         */


        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


        List list = new ArrayList();

        list.add("안녕");
        list.add(null);
        list.add('a');
        list.add(567);
        list.add(true);

        // 1.
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println();  // 그냥 줄바꿈

        // 2.
        for (Object o : list) {
            System.out.print(o + ",");
        }
        System.out.println();

        // 2-1
        list.forEach( (o) -> {
            System.out.print(o + ",");
        } );
        System.out.println();
        // java에서 list 클래스에게만, forEach 만들었엇음. 그런데 list만 되서 욕먹음.

        // 3. Stream API
        list.stream().forEach( (o) -> {
            System.out.print(o + ",");
        });


        // 여러 기본형 객체를 담는 자료형
        // 1) Colelction으로 구현한 자료형 (List, Set, Map)
        // 2) Array 자료형

        //Array: 고정 크기의 연속된 메모리, 동일 타입의 요소 저장.
        //예: int[], String[]

        //List: 순서가 있는 컬렉션, 중복 가능. 인덱스를 통해 요소에 접근.
        //예: ArrayList, LinkedList

        //Set: 순서 없음, 중복 불가. 고유한 값만 저장.
        //예: HashSet, TreeSet

        //Map: 키-값 쌍으로 저장, 키는 중복 불가(키가 Set임).
        //예: HashMap, TreeMap
        //      Hash는 빠른 검색과 순서 없음에 중점을 두며, 해시 테이블을 사용합니다.
        //      Tree는 정렬된 순서를 보장하며, 트리 구조를 사용하여 요소를 저장합니다.
        //      자동으로 오름차순이고, 정렬 기준을 따로 설정(Comparator)할 수 있음

        // 사용 예시:
        // HashSet: 중복되지 않는 요소를 저장하되 순서는 중요하지 않음.
        // HashMap: 키-값 쌍으로 데이터를 저장하고, 키는 유일해야 함.
        // TreeSet: 중복되지 않는 요소를 정렬된 순서대로 저장.
        // TreeMap: 키-값 쌍을 정렬된 순서대로 저장.

        // ㅡㅡㅡㅡㅡㅡ
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 필터링하여 출력
        list2.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 출력 결과:
        // 2
        // 4
        // 6
        // 8
        // 10


        // ㅡㅡㅡㅡㅡㅡ
        Set<String> set = new HashSet<>(Set.of("apple", "banana", "orange", "grape", "apple"));

        // 중복 제거 후 정렬하여 출력
        set.stream()
                .distinct()  // 중복 제거
                .sorted()    // 정렬
                .forEach(System.out::println);

        // 출력 결과:
        // apple
        // banana
        // grape
        // orange


        // ㅡㅡㅡㅡㅡㅡ
        Map<String, Integer> map = Map.of(
                "apple", 1,
                "banana", 2,
                "orange", 3,
                "grape", 4
        );

        // 키가 "a"로 시작하는 항목만 출력
        map.entrySet()
                .stream()
                .filter(entry -> entry.getKey().startsWith("a"))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 출력 결과:
        // apple: 1

        // entrySet으로 {key:value} 를 { 'key=value'}의 하나의 값으로 만듦. 그리고 set으로 처리하는 것.
        //        Map<String, Integer> map = Map.of(
        //                "apple", 1,
        //                "banana", 2,
        //                "orange", 3,
        //                "grape", 4
        //        );
        //이렇게 생긴 map이 아래와 같이 바뀌는 것.
        //        entrySet: [apple=1, banana=2, orange=3, grape=4]`


        // ㅡㅡㅡㅡㅡㅡ
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 배열의 모든 원소 중 홀수만 출력
        Arrays.stream(array)
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);

        // 출력 결과:
        // 1
        // 3
        // 5
        // 7
        // 9




    }
}
