import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class SecondPage implements ActionListener {
    int pX, pY;

    JFrame frame = new JFrame();

    ImageIcon exitIcon = new ImageIcon("resources/exit.png");
    JButton exit = new JButton(exitIcon);

    ImageIcon minIcon = new ImageIcon("resources/minimize.png");
    JButton minimize = new JButton(minIcon);

    Image logo = Toolkit.getDefaultToolkit().getImage("resources/viking.png");

    ImageIcon helloGIF = new ImageIcon("resources/hello.gif");

    JLabel hello = new JLabel(helloGIF);
    JLabel successM1 = new JLabel("You have successfully logged in", SwingConstants.CENTER);
    JLabel successM2 = new JLabel("Click the button below to try again", SwingConstants.CENTER);
    JButton back = new JButton("Return");

    SecondPage() {

        frame.setBounds(460, 200, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        frame.getContentPane().setBackground(new ColorUIResource(235, 245, 255));
        frame.setVisible(true);
        frame.setIconImage(logo);
        frame.setTitle("BRUNFJELL");
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                pX = me.getX();
                pY = me.getY();
            }

            public void mouseDragged(MouseEvent me) {
                frame.setLocation(frame.getLocation().x + me.getX() - pX,
                        frame.getLocation().y + me.getY() - pY);
            }
        });
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(frame.getLocation().x + me.getX() - pX,
                        frame.getLocation().y + me.getY() - pY);
            }
        });

        frame.add(exit);
        exit.setBounds(570, 3, 25, 25);
        exit.setFocusable(false);
        exit.setContentAreaFilled(false);
        exit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit.setContentAreaFilled(true);
                exit.setBackground(new Color(185, 200, 245));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit.setContentAreaFilled(false);
            }
        });
        exit.addActionListener(this);
        frame.add(minimize);
        minimize.setBounds(545, 3, 25, 25);
        minimize.setFocusable(false);
        minimize.setContentAreaFilled(false);
        minimize.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize.setContentAreaFilled(true);
                minimize.setBackground(new Color(185, 200, 245));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize.setContentAreaFilled(false);
            }
        });
        minimize.addActionListener(this);

        frame.add(hello);
        hello.setBounds(235, 60, 130, 130);

        frame.add(successM1);
        successM1.setBounds(0, 195, 600, 30);
        successM1.setFont(new FontUIResource("Arial", Font.BOLD, 25));
        successM1.setForeground(Color.DARK_GRAY);

        frame.add(successM2);
        successM2.setBounds(0, 235, 600, 30);
        successM2.setFont(new FontUIResource("Arial", Font.BOLD, 25));
        successM2.setForeground(Color.DARK_GRAY);

        frame.add(back);
        back.setBounds(200, 285, 200, 50);
        back.setFont(new FontUIResource("Arial", Font.BOLD, 40));
        back.setForeground(Color.WHITE);
        back.setBackground(new java.awt.Color(106, 131, 175));
        back.setFocusable(false);
        back.setBorder(BorderFactory.createMatteBorder(0, 1, 3, 1, new Color(86, 111, 155)));
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            frame.dispose();
        }
        if (e.getSource() == minimize) {
            frame.setState(Frame.ICONIFIED);
        }
        if (e.getSource() == back) {
            LogInPage logInPage = new LogInPage(LogInInfo.getInfo());
            frame.dispose();
        }
    }

}
