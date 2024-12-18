package tj703.study;

// 10번 강의 다시 복습
public class L11InnerClass {
    User user=new User("경민","develckm",38);
    User user2=this.new User("경민","develckm",38);
    //this==new L11InnerClass() : 내부에서 객체의 필드를 접근할 때 사용한다.
    class User{
        String name;
        String id;
        int age;
        //==전역변수(필드로 정의됨)
        //public User(){} //default(기본) 생성자
        User(String name,String id, int age){
            this.name=name;
            this.id=id;
            this.age=age;
            //this==new User() : 객체 자신
        }
    }

    public static void main(String[]args){
        L11InnerClass innerClass=new L11InnerClass();
        System.out.println(innerClass.user.id);
        System.out.println(innerClass.user.name);
        System.out.println(innerClass.user.age);
        //일반적이지도 않고 권장하지도 않는다.
        User inUser=innerClass.new User("둘리","호이호이",41);
        User inUser2=new L11InnerClass().new User("고길동","그만그만",51);
        //this ??
    }
}
