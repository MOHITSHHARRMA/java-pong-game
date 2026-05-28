import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements ActionListener, KeyListener
{

    int py = 200;
    int cy = 200;

    int bx = 390;
    int by = 240;

    int xs = 3;
    int ys = 3;

    Timer t;

    PongGame()
    {
        t = new Timer(10,this);
        t.start();

        addKeyListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor(Color.black);
        g.fillRect(0,0,800,500);

        g.setColor(Color.white);

        g.fillRect(20,py,10,100);

        g.fillRect(760,cy,10,100);

        g.fillOval(bx,by,20,20);

        g.drawLine(400,0,400,500);
    }

    public void actionPerformed(ActionEvent e)
    {

        bx = bx + xs;
        by = by + ys;

        if(by <= 0 || by >= 470)
        {
            ys = ys * -1;
        }

        if(bx <= 30 && by >= py && by <= py + 100)
        {
            xs = xs * -1;
        }

        if(bx >= 740 && by >= cy && by <= cy + 100)
        {
            xs = xs * -1;
        }

        if(by > cy)
        {
            cy = cy + 2;
        }
        else
        {
            cy = cy - 2;
        }

        if(bx < 0 || bx > 800)
        {
            bx = 390;
            by = 240;
        }

        repaint();
    }

    public void keyPressed(KeyEvent e)
    {

        if(e.getKeyCode() == 38)
        {
            py = py - 20;
        }

        if(e.getKeyCode() == 40)
        {
            py = py + 20;
        }

    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    public static void main(String[] args)
    {

        JFrame f = new JFrame();

        PongGame p = new PongGame();

        f.add(p);

        f.setSize(800,500);

        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}