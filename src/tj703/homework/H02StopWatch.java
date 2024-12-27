package tj703.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;


class StopWatch extends JFrame {
   // start 버튼을 누르면 0,1,2,3,4 올라가기
   // stop은 아무때나 멈춤
   // reset 다시 10초로 초기화

   JLabel screen;
   JButton startBtn;
   JButton stopBtn;
   JButton resetBtn;

   int seconds = 0;
   int milliseconds = 0;
   boolean isRunning = false;

   public StopWatch(String name) {
      super(name); // == new JFrame(name)
      this.setBounds(500, 500, 400, 400);
      this.addWindowListener(new Windowhandler());


      startBtn = new JButton("start");
      stopBtn = new JButton("stop");
      resetBtn = new JButton("reset");
      screen = new JLabel("Time: 0.00");
      screen.setHorizontalAlignment(SwingConstants.CENTER);
      this.add(startBtn, BorderLayout.WEST);
      this.add(stopBtn, BorderLayout.EAST);
      this.add(resetBtn, BorderLayout.SOUTH);
      this.add(screen); // BorderLayout정의 안하면 센터


      startBtn.addActionListener((e) -> {

         new Thread(() -> {
            isRunning = true;
            while (isRunning) {

               screen.setText(new Date().toString());

               try {
                  Thread.sleep(10);  // 10ms마다 업데이트
                  milliseconds++;
                  if (milliseconds >= 100) {
                     milliseconds = 0;
                     seconds++;
                  }
               } catch (InterruptedException ex) {
                  ex.printStackTrace();
               }

            }
         }).start();
      });


      stopBtn.addActionListener((e) -> {
         isRunning = false;  // 초시계 멈추기
      });


      resetBtn.addActionListener((e) -> {
         isRunning = false;  // 초시계 멈추기
         seconds = 0;  // 초 초기화
         milliseconds = 0;  // 밀리초 초기화
         screen.setText("Time: 0.00");
      });


      this.setVisible(true);
   }


   class Windowhandler extends WindowAdapter {
      // Adapter라고 쓰여있는 것은 주로 추상클래스. 그래서 인터페이스를 도와준다.
      @Override
      public void windowClosing(WindowEvent e) {
         System.exit(0); // 강제종료라서 그다지 좋지 않음.
         StopWatch.super.dispose(); // 중첩클래스에서 부모클래스 참조법()
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
      // 이거 없으면 10초 이상 있다가 꺼짐. 그래서 설정.
   }

}


public class H02StopWatch {
   public static void main(String[] args) {
      new StopWatch("초시계");
   }
}
