package tj703.advanced;

public class M05StreamAPIMethod {
}

/*
Stream의 여러 메서드 (중간/최종 연산)

- stream의 메서드을 통해 작업을 하면 stream을 반환한다?  / true.
    (함수형 언어에서 기존 데이터를 수정하지 않고 새로운 데이터를 반환하는 방식)

스트림의 불변성 (Immutability)
Stream은 한 번 처리한 후, 그 자체를 변경할 수 없고 각 메서드를 호출할 때마다 새로운 Stream을 반환합니다.
즉, 스트림을 수정하는 것이 아니라, 새로운 스트림을 생성하고 반환하는 방식으로 작업이 이루어집니다.
왜냐. 스트림의 불변성은 상태를 변경하지 않으므로, 스트림을 여러 곳에서 안전하게 사용할 수 있게 합니다.

- 중간 연산 / 최종 연산
중간연산은 작업을 하면 stream을 반환한다. 그 새로운 stream를 가지고 또 작업할 수 있음.
최종연산은 받은 stream을 가지고 작업을 하고 여러 가지 결과를 다양한 타입으로 반환할 수 있습니다.
 예를 들어, 스트림을 리스트나 집합(Set), 단일 값 또는 숫자 등의 형태로 반환할 수 있습니다.
    collect()는 스트림의 결과를 컬렉션 타입으로 수집할 때 사용됩니다.
    collect(Collectors.toList())는 결과를 List로 수집합니다. 결과적으로 스트림이 리스트로 변환됩니다.
    reduce(0, Integer::sum)은 **스트림의 요소들을 합쳐서 단일 값(합계)**을 반환합니다. (숫자 자료형으로 변환)
    등등


Stream API에서 연산자는 크게
 중간 연산 (Intermediate Operations)과
 최종 연산 (Terminal Operations)으로 구분
    즉, 스트림 생성 (Stream Creation) -> 중간 연산 (Intermediate Operations) -> 최종 연산 (Terminal Operations) 과정을 거친다.

* Stream API로 메서드 체이닝을 작성하면 마치 쿼리(sql) 처럼 요소를 처리할 수 있고
* 작성한 메서드를 주석처리하거나 자유롭게 이동하기 용이하며
* 콜백함수를 재사용할 수 있다(내부반복문 장점).


1. 스트림 생성 (Stream Creation)
스트림을 생성하는 방법에는 여러 가지가 있습니다.
주로 Stream.of(), 컬렉션의 stream() 메서드 등을 사용합니다.
        Stream.of() - 주어진 요소들로 스트림을 생성합니다. [직적입력]
            Stream<String> stream = Stream.of("apple", "banana", "cherry");
        Collection.stream() - 컬렉션에서 스트림을 생성합니다.
        Arrays.stream() - 배열에서 스트림을 생성합니다.

        Stream.generate() - 특정 조건에 따라 요소를 생성하는 무한 스트림을 생성합니다.
        Stream.iterate() - 반복적인 패턴을 따라 요소를 생성하는 스트림을 생성합니다.


2. 중간 연산 (Intermediate Operations)
중간 연산은 스트림을 변환하거나 처리하는 작업을 의미.
중간 연산은 여러 번 연결하여 사용할 수 있음
기존의 steam 자료를 변환한 새로운 steam 자료로 반환 때문에 출력이나 결과(최종연산자)를 확인 할 수 없다.
* 중간에 처리된 값을 그 순간 확인할 수 있음.
    = 최종 연산(collect, forEach 등)이 실행되기 전까지는 실제로 스트림의 요소가 처리되지 않음
* method chaining이 가능 (계속 써도 됨)
* 중간연산자는 lazy 연산, 즉 메소드체이닝 된 상태를 전체로 보고 한번에 작업하기 때문에, 성능에 크게 문제가 없다...(지만 있음)

        map(): 스트림의 각 요소를 변환합니다.
        filter(): 조건에 맞는 요소만 필터링합니다.
        flatMap(): 각 요소를 다른 스트림으로 변환하고 그 스트림을 합칩니다.
        distinct(): 중복된 요소를 제거합니다.
        sorted(): 스트림의 요소를 정렬합니다.
        limit(): 스트림에서 지정된 수만큼의 요소를 반환합니다.
        skip(): 스트림의 앞에서 지정된 수만큼의 요소를 건너뜁니다.

        peek() : stream을 아무런 가공없이 그대로 반환. 특정 작업을 수행하는 데 사용. 콜백함수 debug 목적


Stream API에서 최종 연산자 (terminal operations)
- 스트림을 소비하여 최종 결과를 생성하거나 스트림을 종료시키는 연산을 의미
- 최종 연산을 수행하면 스트림이 소비되고 더 이상 사용할 수 없음.

        forEach(): 스트림의 각 요소에 대해 주어진 동작을 수행합니다.
        reduce(): 스트림의 모든 요소를 결합하여 하나의 결과를 반환합니다.
        collect(): 스트림의 요소를 Collector를 이용해 집합체로 축소합니다. (List, set, map 등등으로 변환)
                Collectors.toList(), Collectors.toSet(), Collectors.toMap()과 같은 메서드를 통해 컬렉션 타입 List, Set, Map, LinkedList 로 변환할 수 있다.
                ㄴ 심지어 문자열String으로 만들 수 있다. : Collectors.joining()
                ㄴ 특정 조건으로 데이터를 그룹화할 수도 있다. 마치sql처럼 :  Collectors.groupingBy()
                ㄴ 숫자 데이터를 요약 통계(count, sum, min, max, average) 값으로 바로 만들어줌.    : (Collectors.summarizingInt(), Collectors.summarizingDouble())
                ㄴ 요약통계 이상으로, 원하는 누적 작업(곱하든, 나누든, 복합연산을 하든)을 할 수도 있다.    :  Collectors.reducing()
        allMatch(): 스트림의 모든 요소가 주어진 조건을 만족하는지 확인합니다.
        anyMatch(): 스트림의 요소 중 하나라도 주어진 조건을 만족하는지 확인합니다.
        noneMatch(): 스트림의 모든 요소가 주어진 조건을 만족하지 않는지 확인합니다.
        findFirst(): 스트림에서 첫 번째 요소를 반환합니다.
        findAny(): 스트림에서 임의의 요소를 반환합니다.
        count(): 스트림의 요소 개수를 반환합니다.
        max() / min(): 스트림에서 최대값 또는 최소값을 반환합니다.
        toArray(): 스트림의 요소들을 배열로 변환합니다.
*/

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
/*

각 중간, 최종 연산자가 람다식으로 사용하게 되는 인터페이스


>>> 중간 연산자

map()
사용하는 인터페이스: Function<T, R>
설명: map()은 각 요소를 변환할 때 사용되며,
T 타입의 값을 R 타입으로 변환하는 함수형 인터페이스 Function<T, R>을 사용합니다.
///  list.stream().map(String::toUpperCase);

filter()
사용하는 인터페이스: Predicate<T>
설명: filter()는 조건에 맞는 요소만 걸러내는 메서드로,
조건을 검사하는 함수형 인터페이스 Predicate<T>를 사용합니다.
list.stream().filter(name -> name.length() > 3);

flatMap()
사용하는 인터페이스: Function<T, Stream<R>>
설명: flatMap()은 각 요소를 하나 이상의 다른 스트림으로 변환하고 그 스트림을 평평하게(flatten) 만들어 합칩니다.
// list.stream().flatMap(name -> Arrays.stream(name.split("")));

distinct()
사용하는 인터페이스: 없음
설명: distinct()는 스트림에서 중복된 요소를 제거합니다.
별도의 함수형 인터페이스를 사용하지 않으며, equals() 메서드를 기준으로 중복을 제거합니다.
/// list.stream().distinct();

sorted()
사용하는 인터페이스: Comparator<T>
설명: sorted()는 스트림의 요소를 정렬하는데 사용되며,
비교기준을 제공하는 Comparator<T> 인터페이스를 사용합니다.
/// list.stream().sorted();
/// list.stream().sorted(Comparator.reverseOrder());

peek()
사용하는 인터페이스: Consumer<T>
설명: peek()은 각 요소에 대해 부수적인 작업을 수행하며,
이때 사용하는 인터페이스는 Consumer<T>입니다. Consumer는 결과를 반환하지 않고 요소에 대해 어떤 작업을 수행할 때 사용됩니다.
/// list.stream().peek(name -> System.out.println(name));

limit()
사용하는 인터페이스: 없음
설명: limit()은 스트림의 크기를 제한합니다. 별도의 함수형 인터페이스를 사용하지 않습니다.
/// list.stream().limit(3);

skip()
사용하는 인터페이스: 없음
설명: skip()은 스트림의 처음 몇 요소를 건너뛰고 나머지 요소들만 처리합니다. 별도의 함수형 인터페이스를 사용하지 않습니다.
/// list.stream().skip(2);



>>> 최종 연산자

forEach()
사용하는 인터페이스: Consumer<T>
설명: forEach()는 각 요소에 대해 특정 작업을 실행할 때 사용되며,
Consumer<T> 인터페이스를 사용합니다. 결과를 반환하지 않고 요소마다 작업을 수행합니다.
///  list.stream().forEach(System.out::println);

reduce()
사용하는 인터페이스: BinaryOperator<T> (또는 BiFunction<T, T, T>)
설명: reduce()는 스트림의 모든 요소를 하나의 결과로 결합하는 연산을 수행하며,
두 개의 요소를 합치는 BinaryOperator<T> 또는 BiFunction<T, T, T>를 사용합니다.
///  list.stream().reduce((a, b) -> a + b);

collect()
사용하는 인터페이스: Collector<T, A, R>
설명: collect()는 스트림의 결과를 컬렉션으로 수집하거나 다른 형태로 변환할 때 사용되며,
Collector<T, A, R> 인터페이스를 사용합니다.
///  list.stream().collect(Collectors.toList());


allMatch()
사용하는 인터페이스: Predicate<T>
설명: allMatch()는 스트림의 모든 요소가 조건을 만족하는지 확인하는 연산으로,
Predicate<T> 인터페이스를 사용합니다.
///  list.stream().allMatch(name -> name.length() > 3);

anyMatch()
사용하는 인터페이스: Predicate<T>
설명: anyMatch()는 스트림의 요소 중 하나라도 조건을 만족하는지 확인하는 연산으로,
 Predicate<T> 인터페이스를 사용합니다.
/// list.stream().anyMatch(name -> name.startsWith("A"));

noneMatch()
사용하는 인터페이스: Predicate<T>
설명: noneMatch()는 스트림의 모든 요소가 조건을 만족하지 않는지 확인하는 연산으로,
Predicate<T> 인터페이스를 사용합니다.
///  list.stream().noneMatch(name -> name.length() < 3);

findFirst()
사용하는 인터페이스: 없음
설명: findFirst()는 스트림에서 첫 번째 요소를 반환하며, 별도의 함수형 인터페이스를 사용하지 않습니다.
///  Optional<String> first = list.stream().findFirst();

findAny()
사용하는 인터페이스: 없음
설명: findAny()는 스트림에서 임의의 요소를 반환하며, 별도의 함수형 인터페이스를 사용하지 않습니다.
///  Optional<String> any = list.stream().findAny();

count()
사용하는 인터페이스: 없음
설명: count()는 스트림의 요소 개수를 반환하며, 별도의 함수형 인터페이스를 사용하지 않습니다.
///  long count = list.stream().count();

max() / min()
사용하는 인터페이스: Comparator<T>
설명: max()와 min()은 스트림의 최대값/최솟값을 찾는 메서드로,
Comparator<T> 인터페이스를 사용합니다.
///  Optional<String> max = list.stream().max(Comparator.naturalOrder());

toArray()
사용하는 인터페이스: 없음
설명: toArray()는 스트림의 요소를 배열로 변환하며, 별도의 함수형 인터페이스를 사용하지 않습니다.
/// String[] array = list.stream().toArray(String[]::new);


요약
중간 연산자: Function<T, R>, Predicate<T>, BinaryOperator<T>, Consumer<T>, Comparator<T>, Collector<T, A, R> 등 다양한 함수형 인터페이스를 사용합니다.
최종 연산자: Consumer<T>, Predicate<T>, Comparator<T>, BinaryOperator<T>, Collector<T, A, R> 등을 사용하여 결과를 반환하거나 스트림을 소비합니다.


 */
/*
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

메서드 참조 (method reference)라는 문법
    세미콜론 두 개(::)를 써서 메서드를 호출하는 방법이며, 람다식의 짧은 형태다.
    메서드 참조(Method Reference)는 람다식을 좀 더 간결하게 표현할 수 있는 방법.

클래스명::메서드명

ex)
String::toUpperCase는 String 클래스의 toUpperCase() 메서드를 참조하는 메서드 참조

List<String> names = Arrays.asList("alice", "bob", "charlie");

// 람다식
names.stream()
     .map(name -> name.toUpperCase())  // 람다식
     .forEach(System.out::println);

// 메서드 참조
names.stream()
     .map(String::toUpperCase)  // 메서드 참조
     .forEach(System.out::println);


이런 방식으로 쓸 수 있는 메서드의 조건이 있음
    1. 람다식과 호환되는 메서드: 메서드 참조는 람다식의 형식과 일치하는 경우에만 사용 가능
    2. 인수와 반환 타입이 일치하는 메서드: 매개변수 타입이 람다식의 입력 타입과 일치해야 합니다.

    예를 들어, 람다식 x -> x.toUpperCase()와 동일한 메서드를 참조하려면 String::toUpperCase와 같이 작성할 수 있습니다.
    이때 toUpperCase()는 매개변수가 없고 반환값이 String인 메서드입니다.

메서드 참조는 주로 1) 정적 메서드, 2) 인스턴스 메서드, 3) 특정 객체의 인스턴스 메서드를 참조할 때 사용됩니다.
1) 클래스 이름::메서드 이름: 정적 메서드 참조

2) 인스턴스 이름::메서드 이름: 특정 인스턴스의 메서드 참조

3) 클래스 이름::new: 생성자 참조

 */