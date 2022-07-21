import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

public class TimeLabel {
    private JLabel label;
    private Timer timer;
    private DateFormat format;
    public TimeLabel(){
        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.CENTER);
        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, 50);
        label.setForeground(Color.GREEN);
        label.setFont(font);
        format = DateFormat.getTimeInstance();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(format.format(new Date()));
                color();
            }
        });
        JFrame frame = new JFrame("Current time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setResizable(false);
        frame.add(label);
        timer.start();
        frame.setVisible(true);
    }
    public void color(){
        int m = Integer.parseInt(label.getText().substring(6,8));
        if(m < 20){
            label.setForeground(Color.GREEN);
        }else if (m < 40){
            label.setForeground(Color.CYAN);
        }else {
            label.setForeground(Color.ORANGE);
        }
    }
}

