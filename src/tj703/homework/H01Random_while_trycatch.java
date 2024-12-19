package tj703.homework;

import java.util.Scanner;

public class H01Random_while_trycatch {
    public static void main(String[] args) {
        System.out.println("랜덤한게 생성한 (1~50)수를 맞추세요! ");
        //맞출때 까지 반복 실행
        double random=Math.random(); //java.lang 패키지는 자동으로 Import (String,Integer..)
        System.out.println(random);
        int num=(int)(random*50)+1; //더큰수->작은수 (강제형변환) casting
        System.out.println("뽑힌 랜덤 num:"+num);

        boolean game = true;

        while(game){
            Scanner scanner=new Scanner(System.in);
            System.out.print("1~50 까지 수 중 입력 :");
            String inputNumStr=scanner.nextLine();
            try {
                int inputNum=Integer.parseInt(inputNumStr);
                if(inputNum==num){
                    System.out.println("정답입니다. 게임을 종료합니다.");
                    // break; 얘를 써도 됨
                    game = false;
                } else if (inputNum>num) {
                    System.out.println("더 큰 수를 입력했습니다. down!");
                }else {
                    System.out.println("더 작은 수를 입력했습니다. up!");
                }
            } catch (NumberFormatException e) {
                System.out.println(" 수 만 입력하세요!");
        // Integer.parseInt()나 Double.parseDouble() 메서드를 사용하여 문자열을 숫자로 변환하려고 할 때,
        // 해당 문자열이 숫자 형식이 아닐 경우 NumberFormatException이 발생
        // 만약, "abc"는 숫자로 변환할 수 없으므로
        // Integer.parseInt()는 NumberFormatException을 발생시키고, catch 블록에서 이를 처리합니다.

            }
        }
    }
}

// 5회만에 맞추기.
// 게임을 무한히 반복시켜라.