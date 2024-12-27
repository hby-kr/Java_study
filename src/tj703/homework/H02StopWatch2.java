package tj703.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StopWatch2 extends JFrame {
   private JButton startBtn;
   private JButton stopBtn;
   private JButton resetBtn;
   private JLabel screen;
   private JPanel p;
   private boolean isRun = false;
   private long sec = 0;
   //밀리세컨즈 하려고 할 때, double로 타입을 하는 데, double은 연산오류가 발생
   // 0.1을 0.0999999999999999999로 나올 때가 있음.
   private long milliSec = 0;

   public StopWatch2() {
      super("stopwatch");
      this.setBounds(500, 500, 400, 400);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      screen = new JLabel("스톱워치");
      screen.setHorizontalAlignment(SwingConstants.CENTER);
      startBtn = new JButton("start");
      stopBtn = new JButton("stop");
      resetBtn = new JButton("reset");
      p = new JPanel();
      this.add(screen);
      startBtn.addActionListener(new startBtnHandler());
      startBtn.addActionListener((e) -> {
         isRun = false;
      });
      resetBtn.addActionListener((e) -> {
         stopBtn.doClick(); // action강제
         screen.setText((milliSec=0) + "");
      });
      p.add(startBtn);
      p.add(stopBtn);
      p.add(resetBtn);
      this.add(p, BorderLayout.SOUTH);

      this.setVisible(true);
   }

   class startBtnHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {

         new Thread(() -> {
            isRun = true;
            while (isRun) {
               screen.setText(String.format("%.3f", (milliSec++)*0.001)); // 안에는 text만 들어가니까. 변환.
               try {
                  Thread.sleep(1);
               } catch (InterruptedException ex) {
                  throw new RuntimeException(ex);
               }
            }
         }).start();
      }
   }
}


public class H02StopWatch2 {
   public static void main(String[] args) {
      new StopWatch2();
   }
}
