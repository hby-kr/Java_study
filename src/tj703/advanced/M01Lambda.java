package tj703.advanced;

// interface 와 abstract class 추상클래스는 구현이 되지 않은 추상메서드를 포함하고 있기 때문에 객체가 될 수 없다.

@FunctionalInterface  // 얘는 어노테이션. 컴파일러에게 적어놓는 것
// 나는 화살표 함수가 될거다.라고 컴파일러에게 적어놓는 것.
// 람다식 규칙에서 벗어나면(메서드가 한 개가 아니면 컴파일 오류를 일으킬 거임)
interface AA {
    abstract public void add(int a, int b);
}

class Aimp implements AA {
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}

// (개발자들은 이름 짓는 것을 잘 못함) & 코드가 길어지는 싫어함.
//  => 해결방법 "익명클래스"!!!!

public class M01Lambda {

    public static void main(String[] args) {
        // A a = new A() {}; // 인터페이스는 body가 없어서 객체가 될 수 없다.
        // 인터페이스를 상속받은 클래스가 있어야 한다.

        AA a = new Aimp();
        // AA a = new Aimp();로 선언하는 것은 인터페이스를 통해 객체를 다루기 위한 다형성을 활용한 것입니다.
        // 반대로 Aimp a = new Aimp();로 선언하면 a는 Aimp 타입에만 한정되기 때문에, Aimp 외의 다른 구현체를 사용할 수 없습니다.

        a = new AA() {
            @Override
            public void add(int a, int b) {

            }
        }; // M01Lambda$1().class
        // 이는  a = new M01Lambda().new One();  / 라고 만들어지는 것과 같다.

        // 즉 익명클래스란,
        // main에서 클래스를 그냥 만들면, 자동으로 인터페이스를 상속받는 클래스를 안만들어도 됨.


        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // 익명함수 이것도 길다고 느낌.. 왜
        // js는 매개변수로 함수를 넣을 수 있고, 심지어 모양도 간편하던데(람다식)??
        // => java도 람다식 등장!!  (함수형 언어문법을 문법적설탕으로 쓰는 것)
        // 단, 조건 interface인데, 함수가 오직 하나인 것만 화살표함수로 가능!! 안그럼 컴파일 단계에서 오류 날거임.
        a = (n1, n2) -> {
        };


        // 그렇다면 자바에서 미리 만들어 놓은 함수형 인터페이스를 알아보자.


    }
}

/*
(매개변수) -> { 실행할 코드 }

// 람다식에서 매개변수가 하나일 경우, 괄호를 생략
(x) -> x * 2  // 괄호 생략 가능
x -> x * 2     // 이렇게도 가능

// 본체가 하나의 표현식일 경우, 중괄호와 return 생략 가능
(x, y) -> x + y  // return 없이 바로 결과 반환



 */