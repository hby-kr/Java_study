package tj703.advanced;

import javax.swing.*;

class enumNumetest {
    public static final int OPEN = 3;
}

public class M08Enum {

    public static void main(String[] args) {
        System.out.println(Math.PI);

        public static final int CLOSE = 3;
        // 정보로서의 상수의 단점: 그 상수의 값이 보통 문자열이거나 수이기 때문에
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(enumNumetest.OPEN);
        // 이 때의 매개변수의 타입이 아무 데이터나 입력가능

        // enum을 쓰라!!!
        // 내부의 정의된 모든 필드를 상수처럼 사용가능, 모든 필드가 고유값을 갖는다.
        enum State {OPEN, CLOSE, PAUSE}
        ;
        public static void defaultClose ( int state){ // 여기 int가 아니라.
            if (state == 1) {
            }
        }
        public static void defaultClose1 (State state){ // 여기 int가 아니라 타입을 STATE로 한정할 수 있음.

        }

        // 수업 내용 다 이해 못함. 결론은

        // 매개변수를 타입형 보다 더 한정적으로 정할 수 있음.
        // (enum값이 문자라면) sout으로 enum값을 문자로도 볼 수 있음.
        // 필드를 설정할 수 있음. (enum값에 다시 이름을 지어줄 수 있음)


// 1. enum의 특징
//  - 상수값의 집합: enum은 고정된 값들의 집합을 나타냅니다. 이 값들은 변경되지 않습니다.
//  - 타입 안전성: 일반적인 int나 String 상수보다 안전하게 값을 다룰 수 있습니다. 예를 들어, 잘못된 값이 들어가는 것을 컴파일 시점에 막을 수 있습니다.
//  - 객체지향적: enum은 단순한 상수값 나열이 아니라, 클래스처럼 메서드를 가질 수도 있습니다.

// <기본모양>
        public enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

// <enum 값 사용하기>
        public class EnumExample {
            public static void main(String[] args) {
                Day today = Day.MONDAY;  // Day enum의 MONDAY 값 할당

                switch (today) {
                    case MONDAY:
                        System.out.println("오늘은 월요일!");
                        break;
                    case TUESDAY:
                        System.out.println("오늘은 화요일!");
                        break;
                    // 나머지 요일도 같은 방식으로 처리
                    default:
                        System.out.println("요일을 알 수 없습니다.");
                }
            }
        }

// enum에 메서드 추가하기
        public enum Day {
            MONDAY("9:00 AM"),
            TUESDAY("9:00 AM"),
            WEDNESDAY("9:00 AM"),
            THURSDAY("9:00 AM"),
            FRIDAY("9:00 AM"),
            SATURDAY("10:00 AM"),
            SUNDAY("휴무");

            private String startTime;  // 각 요일의 시작 시간을 저장

            // 생성자
            Day(String startTime) {
                this.startTime = startTime;
            }

            // 메서드
            public String getStartTime() {
                return startTime;
            }
        }

        public class EnumExample {
            public static void main(String[] args) {
                for (Day day : Day.values()) {
                    System.out.println(day + "의 시작 시간: " + day.getStartTime());
                }
            }
        }

//  enum의 추가적인 활용
//     enum을 switch 문과 함께 사용하거나, values() 메서드를 활용하여 enum의 모든 값을 순회하는 등의 작업이 가능합니다.
//     enum은 단순한 값뿐만 아니라, 상태나 동작도 포함할 수 있어 객체지향적인 방식으로 확장할 수 있습니다.
    }
}