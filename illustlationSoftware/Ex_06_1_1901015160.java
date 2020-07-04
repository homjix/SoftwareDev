import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex_06_1_1901015160 extends JFrame {
    public static void main(String[] args){
        new Ex_06_1_1901015160();
    }

    public Ex_06_1_1901015160() {
        setSize(600, 450);
        setTitle("Software Development II");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyJPanel panel= new MyJPanel();
        Container c = getContentPane();
        c.add(panel);
        setVisible(true);
    }

    public class MyJPanel extends JPanel implements
            ActionListener, MouseListener, MouseMotionListener {
        JSlider sliderR, sliderG, sliderB, sliderPen;
        JLabel labelR, labelG, labelB, labelPen;
        JButton button;
        int colorR, colorG, colorB;
        int rad, x = -100, y = -100;
        boolean isButtonClicked = false;

        public MyJPanel() {
            setLayout(null);

            addMouseListener(this);
            addMouseMotionListener(this);

            labelR = new JLabel("赤");
            labelR.setBounds(40, 10, 20, 25);
            sliderR = new JSlider(0, 255, 0);
            sliderR.setBounds(60, 10, 200, 25);

            labelG = new JLabel("緑");
            labelG.setBounds(40, 35, 20, 25);
            sliderG = new JSlider(0, 255, 0);
            sliderG.setBounds(60, 35, 200, 25);

            labelB = new JLabel("青");
            labelB.setBounds(40, 60, 20, 25);
            sliderB = new JSlider(0, 255, 0);
            sliderB.setBounds(60, 60, 200, 25);

            labelPen = new JLabel("ペンの大きさ");
            labelPen.setBounds(280, 10, 100, 25);
            sliderPen = new JSlider(2, 50, 25);
            sliderPen.setBounds(360, 10, 200, 25);

            button = new JButton("消去");
            button.setBounds(410, 45, 100, 30);
            button.addActionListener(this);

            add(labelR);
            add(sliderR);
            add(labelG);
            add(sliderG);
            add(labelB);
            add(sliderB);
            add(labelPen);
            add(sliderPen);
            add(button);
        }

        public void paintComponent(Graphics g) {
            if (isButtonClicked) {
                super.paintComponent(g);
                isButtonClicked = false;
            }

            g.setColor(new Color(colorR, colorG, colorB));
            g.fillOval(x-rad/2, y-rad/2, rad, rad);
            repaint();
        }

        public void actionPerformed(ActionEvent e) {
            isButtonClicked = true;
            repaint();
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
            x = -100;
            y = -100;
            repaint();
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
            colorR = sliderR.getValue();
            colorG = sliderG.getValue();
            colorB = sliderB.getValue();
            rad = sliderPen.getValue();
            x = e.getX();
            y = e.getY();
            repaint();
        }
    }
}