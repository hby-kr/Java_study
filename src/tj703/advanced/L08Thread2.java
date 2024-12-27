package tj703.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

// 스레드를 생성하는 방법 2가지
// 1. Thread 클래스를 상속받아 스레드 생성
// 2. Runnable 인터페이스를 구현하여 스레드 생성
// 3. 람다식을 사용하여 스레드 생성

class DigitClock extends JFrame {
   JLabel screen;
   JButton startBtn;
   JButton stopBtn;
   boolean isClock;


   public DigitClock(String name) {
      super(name); // == new JFrame(name)
      // 나(인스턴스 객체)를 생성할 때는 나의 부모 인스턴스객체를 자동으로 먼저 생성한다.
      this.setBounds(500, 500, 300, 300);
      this.addWindowListener(new Windowhandler());

      startBtn = new JButton("start");
      stopBtn = new JButton("stop");
      screen = new JLabel("디지털시계");
      screen.setHorizontalAlignment(SwingConstants.CENTER);
      this.add(startBtn, BorderLayout.WEST);
      this.add(stopBtn, BorderLayout.EAST);
      this.add(screen); // BorderLayout정의 안하면 센터

      startBtn.addActionListener((e) -> {

         new Thread(() -> {
            isClock = true;
            while (isClock) {
               screen.setText(new Date().toString());

               try {
                  Thread.sleep(1000);
               } catch (InterruptedException ex) {
               }
               // js의 window.setInterval((0=<{1000})
            }
         }).start();
      });

      stopBtn.addActionListener((e) -> {
         // 멈추는 방법 1. while의 값을 false를 준다.
         // 2. Thread의 이름을 설정하고 그것을 멈춘다.(없어진 기능)
         isClock = false;
      });

      this.setVisible(true);
   }


   // addWindowListener에 바로 코드를 넣을 수 있지만, 코드가 기니까 클래스 따로 만들자.
   class Windowhandler extends WindowAdapter {
      // Adapter라고 쓰여있는 것은 주로 추상클래스. 그래서 인터페이스를 도와준다.
      @Override
      public void windowClosing(WindowEvent e) {
         System.exit(0); // 강제종료라서 그다지 좋지 않음.
         DigitClock.super.dispose(); // 중첩클래스에서 부모클래스 참조법()
         // dispose는 창을 닫는 함수
      }

      @Override // = Frame.dispose(), 프레임이 화면이 꺼졌을 때.
      public void windowClosed(WindowEvent e) {
         try {
            Thread.sleep(2000);
         } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
         }
         System.exit(0);
      } // 프레임을 껐는데, 2초뒤에 시스템 상으로 종료가 안되면, 강제 종료하겠다.는 코드
      // 이거 없으면 10초 이상 있다가 꺼짐.

   }

}


public class L08Thread2 {

   public static void main(String[] args) {

      new DigitClock("디지털 시계");

      // Thread 생성 방법 1 : 재사용이 곤란한 코드(콜백함수를 생성과 동시에 실행)
      new Thread(() -> {
         while (true) {
            System.out.println("스레드 동작중");

            try {
               Thread.sleep(1000); // 스레드 잠깐 자기
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
         }
      }).start();
      System.out.println("main 스레드가 동작하고 있다.");
   }
}
