import javax.swing.*;
import java.text.*;
import java.util.*;
import java.awt.*;

public class Digitalclock implements Runnable {
    JFrame f;
    Thread t = null;
    int hours = 0, minutes = 0, seconds = 0;
    String timeString = "";
    String datestr="";
    JButton b;
    JButton Date;
    
    Digitalclock() {
        f = new JFrame();
        f.setTitle("Digital clock");
        f.getContentPane().setBackground(Color.cyan);
        t = new Thread(this);
        t.start();
        b = new JButton();
        b.setBounds(100, 100, 100, 50);
        Date=new JButton();
        Date.setBounds(100, 160 ,100, 50);
        f.add(Date);
        f.add(b);
        f.setSize(300, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                hours = cal.get(Calendar.HOUR_OF_DAY);
                if (hours > 12) hours -= 12;
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format(date);

                printTime();

                t.sleep(1000); // interval given in milliseconds
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, 0);  // number of days to add
                datestr = sdf.format(c.getTime());
                printDate();
            }
        } catch (Exception e) {
        }
    }

    public void printTime() {
        b.setText(timeString);
    }
    
    public void printDate()
    {
        Date.setText(datestr);
    }

    public static void main(String[] args) {
        new Digitalclock();


    }
}
