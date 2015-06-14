import javax.swing.*;   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LinkingExample {
 
    public static JFrame frame1 = new JFrame("Java Frame1");
    public static JFrame frame2 = new JFrame("Java Frame2");
 
    //Form1
    private static void createAndShowGUI1()  
    {
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JButton button = new JButton("HI! IM JFRAME1 - CLICK ME TO OPEN FRAME 2");
        
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {	
                frame1.setVisible(false);
                System.out.println("Opening JFrame 2");
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                	
                    public void run() {
                        createAndShowGUI2();
 
                    }
                });
            }
 
        });      
 
        frame1.getContentPane().add(button);
        frame1.pack();
        frame1.setVisible(true);
    }
 
 
    //Form2
    private static void createAndShowGUI2()  {
 
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JButton button = new JButton("HI! IM JFRAME2 - CLICK ME TO OPEN FRAME 1");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame2.setVisible(false);
                System.out.println("Opening JFrame 1");
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        createAndShowGUI1();
 
                    }
                });
            }
 
        });      
 
        frame2.getContentPane().add(button);
        frame2.pack();
        frame2.setVisible(true);
    }
 
 
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI1();
            }
        });
    }
}
