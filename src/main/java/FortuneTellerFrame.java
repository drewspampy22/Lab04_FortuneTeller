import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame{

    JPanel main;
    int screenHeight;
    int screenWidth;

    JPanel topPnl;
    JLabel title;
    ImageIcon icon;

    JPanel displayPnl;
    JTextArea txtArea;
    JScrollPane scroller;

    JPanel controlPnl;
    JButton readBtn;
    JButton quitBtn;

    int i = -1;
    int randIndex;
    Random rnd;


    public FortuneTellerFrame(){
        main = new JPanel();
        main.setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(255, 255, 255));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        FortuneTellerLabel();
        main.add(topPnl, BorderLayout.NORTH);

        FortuneDisplay();
        main.add(displayPnl, BorderLayout.CENTER);

        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);
    }
    private void FortuneTellerLabel(){
        topPnl = new JPanel();
        topPnl.setBackground(new Color(255, 255, 255));
        icon = new ImageIcon("src/fortune.jpg");
        title = new JLabel("FORTUNE TELLER", icon, JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 48));
        title.setForeground(new Color(123, 50, 250));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        topPnl.add(title);
    }
    private void FortuneDisplay(){
        displayPnl = new JPanel();
        displayPnl.setBackground(new Color(255, 255, 255));
        txtArea = new JTextArea(20, 60);
        txtArea.setFont(new Font("SansSerif", Font.ITALIC, 12));
        scroller = new JScrollPane(txtArea);
        displayPnl.add(scroller);
    }
    private void ControlPanel(){
        controlPnl = new JPanel();
        controlPnl.setBackground(new Color(255, 255, 255));
        controlPnl.setLayout(new GridLayout(1, 2));

        ArrayList<String> fortuneList = new ArrayList<>();
        fortuneList.add("Wait... you like burger king?");
        fortuneList.add("I see you working at McDonalds in the future");
        fortuneList.add("What are you still doing here! Were closed!");
        fortuneList.add("Computers can't talk so if it starts talking... run");
        fortuneList.add("Country music is not good");
        fortuneList.add("Flossing is a made up money scheme but big dentist");
        fortuneList.add("Don't take anyone's advice... except mine ");
        fortuneList.add("Everything's free.. if nobody notices you took it :) ");
        fortuneList.add("Don't tell anyone but... I'm alive and sentient");
        fortuneList.add("You'll find a 50 dollar bill but somebody wont be happy about it....");
        fortuneList.add("You will find a single penny, then lose it");
        fortuneList.add("Don't listen to the government, they're evil! ");

        readBtn = new JButton("Read my Fortune!");
        readBtn.addActionListener((ActionEvent ae) ->{
            rnd = new Random();
            do{
                randIndex = rnd.nextInt(11);
            }while(randIndex == i);
            String fortune = fortuneList.get(randIndex);
            i = randIndex;
            txtArea.append("Your fortune: " + fortune + "\n");
        });
        readBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        controlPnl.add(readBtn);
        controlPnl.add(quitBtn);
    }
}