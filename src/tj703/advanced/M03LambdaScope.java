package tj703.advanced;

public class M03LambdaScope {

    public static void main(String[] args) {

        int n = 0;
        Runnable r = () -> {
            // n++;  // 할 수 없다고 뜸. 변형은 안됨.
            System.out.println(n); // 참조는 할 수 있는데.
        };

        // r.run() 기준으로 변수 n는 부모영역scope에 존재하는 것처럼 보이지만,
        // 실제로는 변수 n 은 M03LambdaScope.main에 있고,
        // 실제로 run이 구현된 곳은 M03LambdaScope의 내부 클래스 M03LambdaScope$1 (1 클래스)에 있는 M03LambdaScope$1.run이므로.
        // 완전히 다른 영역에 자리하고 있는 것이다.

        // 그래서 n을 접근할 수 없는 것.
        // 그런데 참조는 할 수 있게 컴파일러가 도와준다.
        // run() n을 참조하면, M03LambdaScope.n이라고 하는 필드 n을 => final static int n = 0;으로 (컴파일러가) 바꿔서 생성한다.
        // 정확하게는 n이 M03LambdaScope의 전역 상수로 바뀌게 됨. final static int n = 0으로 바뀜. 이제 수정 못함.
        // 따라서 참조는 가능하지만, 수정은 불가하다.
        // 1. 참조는 무리해서 해줄 수 있게하는데, 수정은 무리다.. from 자바
        // (왜 static을 final로 선언하는가)
        // 2. static 필트는 (클래스 변수로서) 바뀌지 않는 것이 안전하기 때문.
        // => 클래스 변수가 GC가 자동으로 삭제하지 않고 어디서든 참조가능하기 때문.
        // 누구나 다 내용을 바꾸고 삭제할 수 있기 때문에 보통은 상수로 정의하고
        // 만약 바꿔야 한다면 싱글톤패턴으로 구현하는 것이 더 좋다.  ????

        int i = 10;
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
            }
        }; // 람다식 익명클래스 모두 지역변수를 final인 클래스 변수로 변경 후 참조
        // final static int i = 10;
        // 따라서 i를 이제 수정할 수 없다.
        // i = 20;  불가.

    }
}
