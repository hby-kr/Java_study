package tj703.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class L14AdvancedStudy {
   static final JFrame frame=new JFrame();
   public static int i=0;
   class One implements WindowListener{
      public void windowOpened(WindowEvent e) {}
      public void windowClosing(WindowEvent e) { frame.dispose();}
      public void windowClosed(WindowEvent e) { }
      public void windowIconified(WindowEvent e) {}
      public void windowDeiconified(WindowEvent e) {}
      public void windowActivated(WindowEvent e) {}
      public void windowDeactivated(WindowEvent e) { }
   }
   public static void main(String[] args) {
      JFrame f=new JFrame();
      f.setBounds(500,1500,300,300);

      f.addWindowListener(new WindowListener() {
         public void windowOpened(WindowEvent e) {}
         public void windowClosing(WindowEvent e) { //x버튼을 누를때
            //f=new JFrame(); //f는 상수다 : 익명클래스를 만들면 지역변수 f를 참조할 수 없기 때문에
            //f를 익명클랙스를 포함하는 부모클래스에 static final 로 정의해서 참조할 수 있게 만든다.
            f.dispose();
         }
         public void windowClosed(WindowEvent e) {}
         public void windowIconified(WindowEvent e) {}
         public void windowDeiconified(WindowEvent e) {}
         public void windowActivated(WindowEvent e) {}
         public void windowDeactivated(WindowEvent e) {}
      });
      int num=0;
      JButton upBnt=new JButton("+");
      JButton downBnt=new JButton("-");

      JLabel label=new JLabel(Integer.toString(num));
      downBnt.addActionListener((e)->{
         i--;
         label.setText(Integer.toString(i));
      });
      upBnt.addActionListener((e)->{
         //num++; //지역변수를 참조하면 자동으로 람다식을 생성하는 내부클래스의 부모클래스에 static final
         //로 정의되기 때문에 ++연산(기존의 데이터를 1더한 데이터로 바꾸는 연산)을 할수 없다.
         //label.setText(Integer.toString(num));
         i++;
         label.setText(Integer.toString(i));
      });
      //람다식 : 하나의 콜백함수만 전달해야하는데 클래스를 재정의하는 것이 불편해서 미리정의한 클래스를
      //함수를 매개변수로 쓰는 척하는 문법(문법적 설탕)
      JButton autoUpBtn=new JButton("auto +"); //1초마다 i를 1씩 증가
      autoUpBtn.addActionListener((e)->{
         new Thread(()->{
            while (true){
               try {Thread.sleep(1000);}catch (Exception ex){}
               label.setText(Integer.toString(++i));
               System.out.println(i);
            }
         }).start();
         //현재 동작하고 있는 것은 일꾼이 1개인데 1씩 증가하는 일꾼이 빠져나와서 일을 못하는 중
         //일꾼 버튼을 종료 frame 이 새로그려져야함
      });
      f.add(label);
      f.add(upBnt, BorderLayout.EAST);
      f.add(downBnt, BorderLayout.WEST);
      f.add(autoUpBtn,BorderLayout.NORTH);
      f.repaint();
      f.setVisible(true);


   }
}

      //frame.addWindowListener((e)->{}); // eventlistener 같은 것.
      // 그 이벤트가 발생했을 때, 콜백함수를 재정의할 수 있음
      // 그런데 오류. 왜 람다식은 콜백함수가 하나일 때만 가능하나, addWindowListener가 콜백함수가 여러개이므로.
