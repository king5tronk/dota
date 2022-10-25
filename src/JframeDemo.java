import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;


//TODO fixa så dotaautojoin termineras vid avstängning och inte vid "Q"
public class JframeDemo extends JFrame implements ActionListener {
    JLabel label = new JLabel("Starta program");
    JLabel labelGif = new JLabel();
    JLabel labelGif2 = new JLabel();
    JLabel labelStop = new JLabel("Stoppa program");
    JButton buttonStart = new JButton("Starta");
    JButton buttonStop = new JButton("Stoppa");
    ImageIcon ii = new ImageIcon("src/ezgif.com-gif-maker.gif");



    public JframeDemo() throws MalformedURLException{

        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        this.add(p);
        p.setLayout(new FlowLayout());
        p.add(labelGif);
        labelGif.setIcon(ii);
        p.add(label);
        label.setForeground(Color.WHITE);
        p.add(buttonStart);
        p.add(labelStop);
        labelStop.setForeground(Color.WHITE);
        p.add(buttonStop);
        buttonStart.setPreferredSize(new Dimension(100, 70));
        buttonStop.setPreferredSize(new Dimension(100, 70));
        buttonStart.addActionListener(this);
        buttonStop.addActionListener(this);
        setSize(600, 510);
        setLocation(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("src/clipart1279919.png").getImage(),
                new Point(0,0),"custom cursor"));


    }

    public static void main(String[] args) throws MalformedURLException{
        JframeDemo s = new JframeDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == buttonStart) {
                Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());      //STARTA    DOTAAUTOJOIN
            } else if (e.getSource() == buttonStop) {
                Desktop.getDesktop().browse(new URL("http://www.youtube.com").toURI());     //TERMINATE AUTOJOINPROGRAM

            }
        } catch (URISyntaxException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}