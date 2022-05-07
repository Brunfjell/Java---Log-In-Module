import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class LogInPage implements ActionListener, ItemListener {

    int pX, pY;

    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    ImageIcon exitIcon = new ImageIcon("resources/exit.png");
    JButton exit = new JButton(exitIcon);

    ImageIcon minIcon = new ImageIcon("resources/minimize.png");
    JButton minimize = new JButton(minIcon);

    Image logo = Toolkit.getDefaultToolkit().getImage("resources/viking.png");

    ImageIcon padLogo = new ImageIcon("resources/norse.gif");
    JLabel padalogo = new JLabel(padLogo);
    JLabel title = new JLabel("Brunfjell", SwingConstants.CENTER);

    JLabel subttl1 = new JLabel("Lorem ipsum dolor sit amet", SwingConstants.CENTER);
    JLabel subttl2 = new JLabel("mel ei minim moderatius!", SwingConstants.CENTER);

    JLabel companyName = new JLabel("Brunfjell's Java Project", SwingConstants.CENTER);
    JLabel creatorsName = new JLabel("Created by Brunfjell", SwingConstants.CENTER);
    JLabel year = new JLabel("© 2022", SwingConstants.CENTER);

    ImageIcon userIcon = new ImageIcon("resources/userbig.png");
    JLabel user = new JLabel(userIcon);

    JLabel lgnttl = new JLabel("LOG IN");

    JLabel id = new JLabel("ID: ");
    JTextField idInput = new JTextField();
    JTextField regId = new JTextField();

    JLabel password = new JLabel("Password: ");
    JPasswordField passInput = new JPasswordField(11);
    JPasswordField regPass = new JPasswordField(11);

    ImageIcon visonIcon = new ImageIcon("resources/vison.png");
    ImageIcon visoffIcon = new ImageIcon("resources/visoff.png");
    JToggleButton hideshow = new JToggleButton(visoffIcon);

    JButton login = new JButton("Log In");

    JLabel noacc = new JLabel("No account yet?");
    JButton register = new JButton("Register Now");

    JLabel success = new JLabel("Log in successful");
    JLabel fail = new JLabel("Account not found");

    ImageIcon loadIcon = new ImageIcon("resources/loading.gif");
    JLabel load = new JLabel(loadIcon);

    JLabel rgstrttl = new JLabel("REGISTRATION");

    JLabel crtidLbl = new JLabel("Create ID:");

    JLabel crtpswLbl = new JLabel("Create Password:");

    JLabel fillall = new JLabel("Fill all fields");
    JLabel noPut = new JLabel("Already Registered");
    JLabel regSuccessful = new JLabel("Registration Successful");

    JButton submit = new JButton("Submit");
    JButton cancelReg = new JButton("Cancel Registration");

    Object[] userRowsW = new Object[2];

    HashMap<String, String> logininfo = new HashMap<String, String>();

    LogInPage(HashMap<String, String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

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

        frame.add(panel1);
        panel1.setBounds(245, 30, 355, 470);
        panel1.setBackground(new ColorUIResource(235, 245, 255));
        panel1.setLayout(null);
        panel1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
            }

            public void mouseDragged(MouseEvent me) {
            }
        });

        frame.add(panel2);
        panel2.setBounds(0, 0, 245, 500);
        panel2.setBackground(new ColorUIResource(106, 131, 175));
        panel2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.DARK_GRAY));
        panel2.setLayout(null);

        panel2.add(padalogo);
        padalogo.setBounds(0, 75, 245, 130);

        panel2.add(title);
        title.setBounds(0, 210, 245, 45);
        title.setForeground(new ColorUIResource(255, 255, 255));
        title.setFont(new FontUIResource("ARIAL", Font.BOLD, 40));

        panel2.add(subttl1);
        subttl1.setBounds(0, 260, 245, 30);
        subttl1.setForeground(new ColorUIResource(255, 255, 255));
        subttl1.setFont(new FontUIResource("ARIAL", Font.BOLD, 16));

        panel2.add(subttl2);
        subttl2.setBounds(0, 285, 245, 30);
        subttl2.setForeground(new ColorUIResource(255, 255, 255));
        subttl2.setFont(new FontUIResource("ARIAL", Font.BOLD, 16));

        panel2.add(companyName);
        companyName.setBounds(0, 335, 245, 30);
        companyName.setForeground(new ColorUIResource(255, 255, 255));
        companyName.setFont(new FontUIResource("ARIAL", Font.BOLD, 12));

        panel2.add(creatorsName);
        creatorsName.setBounds(0, 355, 245, 30);
        creatorsName.setForeground(new ColorUIResource(255, 255, 255));
        creatorsName.setFont(new FontUIResource("ARIAL", Font.BOLD, 12));

        panel2.add(year);
        year.setBounds(0, 375, 245, 30);
        year.setForeground(new ColorUIResource(255, 255, 255));
        year.setFont(new FontUIResource("ARIAL", Font.BOLD, 12));

        panel1.add(user);
        user.setBounds(145, 40, 70, 70);

        panel1.add(lgnttl);
        lgnttl.setBounds(130, 120, 200, 30);
        lgnttl.setFont(new FontUIResource("ARIAL", Font.BOLD, 30));
        lgnttl.setForeground(new ColorUIResource(106, 131, 175));

        panel1.add(rgstrttl);
        rgstrttl.setBounds(65, 120, 250, 30);
        rgstrttl.setFont(new FontUIResource("ARIAL", Font.BOLD, 30));
        rgstrttl.setForeground(new ColorUIResource(106, 131, 175));
        rgstrttl.setVisible(false);

        panel1.add(id);
        id.setBounds(60, 160, 50, 30);
        id.setFont(new FontUIResource("ARIAL", Font.BOLD, 25));
        id.setForeground(new ColorUIResource(106, 131, 175));

        panel1.add(crtidLbl);
        crtidLbl.setBounds(60, 160, 200, 30);
        crtidLbl.setFont(new FontUIResource("ARIAL", Font.BOLD, 25));
        crtidLbl.setForeground(new ColorUIResource(106, 131, 175));
        crtidLbl.setVisible(false);

        panel1.add(idInput);
        idInput.setBounds(60, 190, 240, 28);
        idInput.setFont(new FontUIResource("Arial", Font.BOLD, 25));
        idInput.setForeground(Color.DARK_GRAY);
        idInput.setCaretColor(new ColorUIResource(106, 131, 175));
        idInput.setOpaque(false);
        idInput.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new ColorUIResource(106, 131, 175)));

        panel1.add(regId);
        regId.setVisible(false);
        regId.setBounds(60, 190, 240, 28);
        regId.setFont(new FontUIResource("Arial", Font.BOLD, 25));
        regId.setForeground(Color.DARK_GRAY);
        regId.setCaretColor(new ColorUIResource(106, 131, 175));
        regId.setOpaque(false);
        regId.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new ColorUIResource(106, 131, 175)));

        panel1.add(password);
        password.setBounds(60, 250, 200, 30);
        password.setFont(new FontUIResource("ARIAL", Font.BOLD, 25));
        password.setForeground(new ColorUIResource(106, 131, 175));

        panel1.add(crtpswLbl);
        crtpswLbl.setBounds(60, 250, 280, 30);
        crtpswLbl.setFont(new FontUIResource("ARIAL", Font.BOLD, 25));
        crtpswLbl.setForeground(new ColorUIResource(106, 131, 175));
        crtpswLbl.setVisible(false);

        panel1.add(passInput);
        passInput.setBounds(60, 280, 215, 28);
        passInput.setFont(new FontUIResource("Arial", Font.BOLD, 25));
        passInput.setForeground(Color.DARK_GRAY);
        passInput.setCaretColor(new ColorUIResource(106, 131, 175));
        passInput.setOpaque(false);
        passInput.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c == KeyEvent.VK_SPACE))) {
                    e.consume();
                }
            }
        });
        passInput.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new ColorUIResource(106, 131, 175)));

        panel1.add(regPass);
        regPass.setVisible(false);
        regPass.setBounds(60, 280, 215, 28);
        regPass.setFont(new FontUIResource("Arial", Font.BOLD, 25));
        regPass.setForeground(Color.DARK_GRAY);
        regPass.setCaretColor(new ColorUIResource(106, 131, 175));
        regPass.setOpaque(false);
        regPass.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c == KeyEvent.VK_SPACE))) {
                    e.consume();
                }
            }
        });
        regPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new ColorUIResource(106, 131, 175)));

        panel1.add(hideshow);
        hideshow.setBounds(275, 280, 25, 25);
        hideshow.setOpaque(false);
        hideshow.setContentAreaFilled(false);
        hideshow.setFocusable(false);
        hideshow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        hideshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hideshow.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                hideshow.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        hideshow.addItemListener(this);

        panel1.add(login);
        login.setBounds(190, 340, 110, 40);
        login.setForeground(Color.WHITE);
        login.setFont(new FontUIResource("ARIAL", Font.BOLD, 25));
        login.setBackground(new java.awt.Color(106, 131, 175));
        login.setFocusable(false);
        login.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setCursor(new Cursor(Cursor.HAND_CURSOR));
                login.setBackground((new java.awt.Color(126, 151, 195)));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                login.setBackground(new java.awt.Color(106, 131, 175));
            }
        });
        login.addActionListener(this);

        panel1.add(submit);
        submit.setBounds(125, 340, 110, 40);
        submit.setForeground(Color.WHITE);
        submit.setFont(new FontUIResource("ARIAL", Font.BOLD, 25));
        submit.setBackground(new java.awt.Color(106, 131, 175));
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
                submit.setBackground((new java.awt.Color(126, 151, 195)));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                submit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                submit.setBackground(new java.awt.Color(106, 131, 175));
            }
        });
        submit.setVisible(false);
        submit.addActionListener(this);

        panel1.add(cancelReg);
        cancelReg.setBounds(105, 375, 150, 40);
        cancelReg.setForeground(new java.awt.Color(106, 131, 175));
        cancelReg.setFont(new FontUIResource("ARIAL", Font.BOLD, 14));
        cancelReg.setOpaque(false);
        cancelReg.setContentAreaFilled(false);
        cancelReg.setFocusable(false);
        cancelReg.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cancelReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelReg.setCursor(new Cursor(Cursor.HAND_CURSOR));
                cancelReg.setForeground((new java.awt.Color(126, 151, 195)));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelReg.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                cancelReg.setForeground(new java.awt.Color(106, 131, 175));
            }
        });
        cancelReg.setVisible(false);
        cancelReg.addActionListener(this);

        panel1.add(noacc);
        noacc.setBounds(60, 330, 110, 40);
        noacc.setForeground(Color.DARK_GRAY);
        noacc.setFont(new FontUIResource("Arial", Font.BOLD, 12));

        panel1.add(register);
        register.setBounds(58, 350, 80, 40);
        register.setForeground(new ColorUIResource(106, 131, 175));
        register.setFont(new FontUIResource("Arial", Font.BOLD, 12));
        register.setFocusable(false);
        register.setContentAreaFilled(false);
        register.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                register.setCursor(new Cursor(Cursor.HAND_CURSOR));
                register.setForeground(new ColorUIResource(126, 151, 195));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                register.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                register.setForeground(new ColorUIResource(106, 131, 175));
            }
        });
        register.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String regUser = regId.getText();
        String regPassword = String.valueOf(regPass.getPassword());
        String iD = idInput.getText();
        String pass = String.valueOf(passInput.getPassword());

        if (e.getSource() == exit) {
            frame.dispose();
        }
        if (e.getSource() == minimize) {
            frame.setState(Frame.ICONIFIED);
        }

        try {
            if (e.getSource() == login) {
                if (!(logininfo.containsKey(iD))) {
                    panel1.add(fail);
                    success.setVisible(false);
                    fail.setVisible(true);
                    fail.setBounds(90, 405, 200, 40);
                    fail.setForeground(new ColorUIResource(225, 116, 106));
                    fail.setFont(new FontUIResource("Arial", Font.BOLD, 20));

                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {

                        int counter = 10;

                        @Override
                        public void run() {
                            if (counter > 0) {
                                fail.setForeground(Color.DARK_GRAY);
                                counter--;
                            } else {
                                timer.cancel();
                            }
                        }
                    };
                    timer.schedule(task, 500);
                }

                if (logininfo.containsKey(iD)) {
                    if (logininfo.get(iD).equals(pass)) {
                        fail.setVisible(false);
                        panel1.add(success);
                        panel1.add(load);
                        success.setVisible(true);
                        success.setBounds(98, 410, 200, 40);
                        success.setForeground(Color.DARK_GRAY);
                        success.setFont(new FontUIResource("Arial", Font.BOLD, 20));
                        load.setBounds(160, 385, 40, 40);

                        Timer timer = new Timer();
                        TimerTask task = new TimerTask() {

                            int counter = 10;

                            @Override
                            public void run() {
                                if (counter > 0) {
                                    SecondPage secondPage = new SecondPage();
                                    frame.dispose();
                                    counter--;
                                } else {
                                    timer.cancel();
                                }
                            }
                        };
                        timer.schedule(task, 2000);
                    } else {
                        panel1.add(fail);
                        success.setVisible(false);
                        fail.setVisible(true);
                        fail.setBounds(90, 405, 200, 40);
                        fail.setForeground(new ColorUIResource(225, 116, 106));
                        fail.setFont(new FontUIResource("Arial", Font.BOLD, 20));

                        Timer timer = new Timer();
                        TimerTask task = new TimerTask() {

                            int counter = 10;

                            @Override
                            public void run() {
                                if (counter > 0) {
                                    fail.setForeground(Color.DARK_GRAY);
                                    counter--;
                                } else {
                                    timer.cancel();
                                }
                            }
                        };
                        timer.schedule(task, 500);
                    }

                }

            }

        } catch (Exception exception) {

        }

        if (e.getSource() == cancelReg) {
            lgnttl.setVisible(true);
            id.setVisible(true);
            password.setVisible(true);
            login.setVisible(true);
            noacc.setVisible(true);
            register.setVisible(true);
            passInput.setVisible(true);
            idInput.setVisible(true);

            fillall.setVisible(false);
            rgstrttl.setVisible(false);
            crtidLbl.setVisible(false);
            crtpswLbl.setVisible(false);
            submit.setVisible(false);
            cancelReg.setVisible(false);
            regId.setVisible(false);
            regId.setText("");
            regPass.setVisible(false);
            regPass.setText("");
            regSuccessful.setVisible(false);
        }

        if (e.getSource() == register) {
            lgnttl.setVisible(false);
            id.setVisible(false);
            password.setVisible(false);
            login.setVisible(false);
            noacc.setVisible(false);
            register.setVisible(false);
            passInput.setVisible(false);
            passInput.setText("");
            idInput.setVisible(false);
            idInput.setText("");
            fail.setVisible(false);

            rgstrttl.setVisible(true);
            crtidLbl.setVisible(true);
            crtpswLbl.setVisible(true);
            submit.setVisible(true);
            cancelReg.setVisible(true);
            regId.setVisible(true);
            regPass.setVisible(true);

        }
        try {
            if (e.getSource() == submit) {
                if (!(regId.getText().isEmpty()) && !(regPass.getText().isEmpty())) {
                    if (logininfo.containsKey(regUser)) {
                        panel1.add(noPut);
                        noPut.setVisible(true);
                        noPut.setBounds(85, 405, 200, 40);
                        noPut.setForeground(new ColorUIResource(225, 116, 106));
                        noPut.setFont(new FontUIResource("Arial", Font.BOLD, 20));
                        fillall.setVisible(false);

                        Timer timer = new Timer();
                        TimerTask task = new TimerTask() {

                            int counter = 10;

                            @Override
                            public void run() {
                                if (counter > 0) {
                                    noPut.setForeground(Color.DARK_GRAY);
                                    counter--;
                                } else {
                                    timer.cancel();
                                }
                            }
                        };
                        timer.schedule(task, 500);
                    }

                    if (!(logininfo.containsKey(regUser))) {
                        logininfo.put(regUser, regPassword);
                        noPut.setVisible(false);
                        fillall.setVisible(false);
                        panel1.add(regSuccessful);
                        regSuccessful.setVisible(true);
                        regSuccessful.setBounds(70, 405, 280, 40);
                        regSuccessful.setForeground(new ColorUIResource(96, 215, 106));
                        regSuccessful.setFont(new FontUIResource("Arial", Font.BOLD, 20));

                        Timer timer = new Timer();
                        TimerTask task = new TimerTask() {

                            int counter = 10;

                            @Override
                            public void run() {
                                if (counter > 0) {
                                    lgnttl.setVisible(true);
                                    id.setVisible(true);
                                    password.setVisible(true);
                                    login.setVisible(true);
                                    noacc.setVisible(true);
                                    register.setVisible(true);
                                    passInput.setVisible(true);
                                    idInput.setVisible(true);

                                    rgstrttl.setVisible(false);
                                    crtidLbl.setVisible(false);
                                    crtpswLbl.setVisible(false);
                                    submit.setVisible(false);
                                    cancelReg.setVisible(false);
                                    regId.setVisible(false);
                                    regId.setText("");
                                    regPass.setVisible(false);
                                    regPass.setText("");
                                    regSuccessful.setVisible(false);
                                    counter--;
                                } else {
                                    timer.cancel();
                                }
                            }
                        };
                        timer.schedule(task, 500);

                    }

                } else {
                    panel1.add(fillall);
                    noPut.setVisible(false);
                    fillall.setVisible(true);
                    fillall.setBounds(125, 405, 200, 40);
                    fillall.setForeground(new ColorUIResource(225, 116, 106));
                    fillall.setFont(new FontUIResource("Arial", Font.BOLD, 20));

                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {

                        int counter = 10;

                        @Override
                        public void run() {
                            if (counter > 0) {
                                fillall.setForeground(Color.DARK_GRAY);
                                counter--;
                            } else {
                                timer.cancel();
                            }
                        }
                    };
                    timer.schedule(task, 500);
                }

            }

        } catch (Exception err) {
            panel1.add(noPut);
            noPut.setVisible(true);
            noPut.setBounds(90, 405, 200, 40);
            noPut.setForeground(new ColorUIResource(225, 116, 106));
            noPut.setFont(new FontUIResource("Arial", Font.BOLD, 20));

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {

                int counter = 10;

                @Override
                public void run() {
                    if (counter > 0) {
                        noPut.setForeground(Color.DARK_GRAY);
                        counter--;
                    } else {
                        timer.cancel();
                    }
                }
            };
            timer.schedule(task, 500);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (hideshow.isSelected()) {
            passInput.setEchoChar((char) 0);
            regPass.setEchoChar((char) 0);
            hideshow.setIcon(visonIcon);

        } else {
            passInput.setEchoChar('\u25cf');
            regPass.setEchoChar('\u25cf');
            hideshow.setIcon(visoffIcon);
        }

    }

}
