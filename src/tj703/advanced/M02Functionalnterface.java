package tj703.advanced;

import java.util.function.*;

public class M02Functionalnterface {

    public static void main(String[] args) {
        /*  자바 8에서 추가된 문법
        // 자바가 미리 선언해 놓은 함수형 프로그래밍을 지원하는 주요 인터페이스
        // 스트림api (콜랙션 객체들_배열,리스트,map 등의 반복을 위해 나온 자료형) -> forEach, map(), reduce(),

        // 총 9개임 (심지어 묶음임)
        //        Function<T, R>
        //        BiFunction<T, U, R>

        //        UnaryOperator<T>
        //        BinaryOperator<T>

        //        Predicate<T>
        //        BiPredicate<T, U>

        //        Consumer<T>
        //        BiConsumer<T, U>

        //        Supplier<T>
        
        // Function, BiFunction, UnaryOperator, BinaryOperator은 입력 → 출력을 하는 함수입니다.
        // Predicate, BiPredicate는 조건 검사를 합니다. T F
        // Consumer, BiConsumer는 값을 처리하거나 출력합니다.
        // Supplier는 값을 생성해서 제공합니다.

        // Runnable도 함수형 인터페이스이긴 하지만, 함수형 프로그래밍에서 주로 다루는 방식과는 조금 다릅니다.
        // Runnable은 반환 값이 없는 인터페이스로, 매개변수도 없고 단순히 작업을 실행하는 역할을 합니다.
        // 즉, run() 메서드를 오버라이드하여 실행할 작업을 정의하는 방식입니다.
        // 하지만 함수형 프로그래밍에서는 입력값을 받아 처리하고 결과를 반환하는 함수를 주로 다룹니다.
        // 예를 들어, Function, Predicate와 같은 인터페이스는 입력값을 받아 처리하고 출력값을 반환하는 데 초점이 맞춰져 있습니다.
        

        >> 자바의 함수형 인터페이스의 분류 기준

        1. 입력과 출력의 타입이 같은가 다른가?
            + 입력이 1개냐? 2개냐?

            1) 입력 1개, 출력 1개:
                Function<T, R>: 입력 T를 받아 출력 R을 반환.
                UnaryOperator<T>: 입력과 출력이 같은 타입 T를 반환. (Function<T, T>의 특수화)
                Predicate<T>: 입력 T를 받아 boolean을 반환 (조건 검사).
                Consumer<T>: 입력 T를 받아 아무것도 반환하지 않음 (사이드 이펙트).
                Supplier<T>: 입력 없이 출력 T를 반환.

            2) 입력 2개, 출력 1개
            + 입력이 2개라면, 그 둘의 타입이 같냐?
                BiFunction<T, U, R>: 두 개의 입력 T와 U를 받아 출력 R을 반환.  (두 입력값의 타입이 달라도 됨)
                BinaryOperator<T>: 두 개의 입력 T를 받아 같은 타입 T를 반환. (BiFunction<T, T, T>의 특수화)
                BiPredicate<T, U>: 두 개의 입력 T와 U를 받아 boolean을 반환.
                BiConsumer<T, U>: 두 개의 입력 T와 U를 받아 아무것도 반환하지 않음 (사이드 이펙트).

        2. 반환값이 있냐 없냐?
            1) 값 있음. 반환 값이 있는 함수형 인터페이스 (Return Values)
                Function<T, R>: 하나의 인자를 받아 다른 타입의 값을 반환.
                UnaryOperator<T>: 입력과 출력이 동일한 타입의 값을 반환.
                BiFunction<T, U, R>: 두 개의 인자를 받아 하나의 값을 반환.
                BinaryOperator<T>: 두 개의 입력을 받아 같은 타입의 값을 반환.

            2) 값이 없음. 반환 값이 없는 함수형 인터페이스 (No Return Value)
                Predicate<T>: 입력을 받아 boolean 값을 반환 (조건 검사).
                Consumer<T>: 입력을 받아 아무 것도 반환하지 않음 (사이드 이펙트).
                Supplier<T>: 입력 없이 값을 반환 (공급자).
                BiPredicate<T, U>: 두 개의 인자를 받아 boolean 값을 반환.
                BiConsumer<T, U>: 두 개의 인자를 받아 아무 것도 반환하지 않음
         */


        // 1. Runnable
        //         주로 스레드를 실행할 때 사용됩니다.
        //         run() 메서드를 하나만 정의한 인터페이스로, 스레드에서 실행할 작업을 구현하는 데 사용됩니다.
        //         예: new Thread(new Runnable() { public void run() { /* 작업 */ } }).start();
        Runnable run = new Runnable() {
            public void run() { // 매개변수와 return도 없는 메서드
            };
        };
        run = () -> {};

        // ㅡㅡㅡㅡㅡㅡㅡ
        // Runnable 인터페이스 사용: 입력 없이 실행할 작업 정의
        Runnable task = () -> System.out.println("작업이 실행되었습니다!");

        // Thread에 Runnable을 전달하여 실행
        Thread thread = new Thread(task);
        thread.start();


        // 2. Function<T, R>:
        //        하나의 인자 T를 받아서 다른 타입 R을 반환하는 함수형 인터페이스입니다.
        //        apply(T t) 메서드를 통해 입력값을 처리하고 결과를 반환합니다.
        //        예: Function<Integer, String> intToStr = (n) -> "Number: " + n;

        Function<Integer, String> func = new Function<>() { // 얘는 매개변수와 return 둘다 있음.
            @Override
            public String apply(Integer i) { // 제네릭인 랩퍼클래스만 됨. 기본데이터를 타입으로 받을 수 없음.
                return i*i+"";
            }
        };
        System.out.println(func.apply(5));
        func = (a) -> {return a +";";};
        System.out.println(func.apply(10));

        Function<Integer, Integer> pow = a -> a*a + 5;  // 하나의 코드가 있으면 축약 가능.
        // Function는 매개변수의 타입과 반환값이 다를 때 보통사용

        // ㅡㅡㅡㅡㅡㅡㅡ
        // Function 인터페이스 사용: 정수를 받아서 그 제곱을 반환
        Function<Integer, Integer> square = (n) -> n * n;

        System.out.println(square.apply(5)); // 출력: 25


        // 2-1 BiFunction<T, U, R>
        //        두 개의 인자 T와 U를 받아서 R 타입의 값을 반환하는 함수형 인터페이스입니다.
        //        예: BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        // BiFunction 인터페이스 사용: 두 숫자의 합을 반환
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(3, 4)); // 출력: 7

        // 3. UnaryOperator<T>
        //        하나의 인자 T를 받아서 같은 타입 T를 반환하는 함수형 인터페이스입니다.
        //        Function<T, T>와 동일하지만, 입력과 출력이 같은 타입일 때 사용됩니다.
        //        예: UnaryOperator<Integer> square = (n) -> n * n;

        // UnaryOperator 인터페이스 사용: 입력값을 두 배로 반환
        UnaryOperator<Integer> doubleIt = (n) -> n * 2;

        System.out.println(doubleIt.apply(4)); // 출력: 8

        // 3-1. BinaryOperator<T>:
        //        두 개의 같은 타입 T를 받아서 같은 타입 T를 반환하는 함수형 인터페이스입니다.
        //        apply(T t1, T t2) 메서드를 통해 두 값을 결합하거나 계산하는 용도로 사용됩니다.
        //        예: BinaryOperator<Integer> add = (a, b) -> a + b;

        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(54,56));

        // BinaryOperator 인터페이스 사용: 두 숫자의 합을 반환
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(3, 4)); // 출력: 7


        // 4. Consumer<T>
        //        하나의 인자 T를 받아서 아무것도 반환하지 않는 함수형 인터페이스입니다.
        //        주로 데이터를 처리하거나 사이드 이펙트를 발생시킬 때 사용됩니다.
        //        예: Consumer<String> print = (s) -> System.out.println(s);

        // Consumer 인터페이스 사용: 값을 받아서 출력하는 작업
        Consumer<String> printMessage = (message) -> System.out.println(message);

        printMessage.accept("안녕하세요!"); // 출력: 안녕하세요!

        // 4-1. BiConsumer<T, U>
        //        두 개의 인자 T와 U를 받아서 아무것도 반환하지 않는 함수형 인터페이스입니다.
        //        예: BiConsumer<String, Integer> print = (name, age) -> System.out.println(name + " is " + age + " years old.");

        // BiConsumer 인터페이스 사용: 두 값을 더해서 출력
        BiConsumer<Integer, Integer> addAndPrint = (a, b) -> System.out.println(a + b);

        addAndPrint.accept(3, 4); // 출력: 7

        // 5. Supplier<T>
        //        인자 없이 T 타입의 값을 반환하는 함수형 인터페이스입니다.
        //        주로 값을 공급하는 역할을 합니다.
        //        예: Supplier<Double> randomValue = () -> Math.random();

        // Supplier 인터페이스 사용: 값을 공급하는 함수
        Supplier<Double> randomValue = () -> Math.random();

        System.out.println(randomValue.get()); // 출력: 난수 값

        // 6. Predicate<T>
        //        하나의 인자 T를 받아서 boolean 값을 반환하는 함수형 인터페이스입니다.
        //        조건을 검사하는 데 사용됩니다.
        //        예: Predicate<Integer> isEven = (n) -> n % 2 == 0;

        // Predicate 인터페이스 사용: 숫자가 짝수인지 확인
        Predicate<Integer> isEven = (n) -> n % 2 == 0;

        System.out.println(isEven.test(4)); // 출력: true
        System.out.println(isEven.test(5)); // 출력: false

        // 6-1. BiPredicate<T, U>
        //        두 개의 인자 T와 U를 받아서 boolean 값을 반환하는 함수형 인터페이스입니다.
        //        예: BiPredicate<Integer, Integer> isEqual = (a, b) -> a.equals(b);

        // BiPredicate 인터페이스 사용: 두 숫자가 같은지 확인
        BiPredicate<Integer, Integer> isEqual = (a, b) -> a.equals(b);

        System.out.println(isEqual.test(3, 3)); // 출력: true
        System.out.println(isEqual.test(3, 4)); // 출력: false

    }
}
