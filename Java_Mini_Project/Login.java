package Java_Mini_Project;

// JVM can take upto the source package but if you have made more directories we need to specify

import javax.swing.*;      // This is so because it comes under Java Extended Package
import java.awt.*;
import java.awt.event.*;   // The actions that a user can perform comes under this package - drag, click, etc

public class Login extends JFrame implements ActionListener // This should show error until abstract methods have been overridden of ActionListener Interface
{
 
    JButton rules, back;   //Global Declaration
    JTextField tfname;
    
    Login()                                          //As soon as someone runs my Frame should be visible - Default Constructor 
    {
        getContentPane().setBackground(Color.WHITE); //getContentPane() is used to pick up the whole frame and setBackground is obvious
        //Color class belongs to awt package
        setLayout(null);                     //I am interested in making my own layout through swing
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Java_Mini_Project/icons/login.jpeg")); //ImageIcon class under JFrame
        // ImageIcon i1 = new ImageIcon(getClass().getResource("login.jpeg"));


        //ClassLoader is the class to pick up images & getSystemResource is a static function
        //If you want any component above the frame you need to place it over
        JLabel image = new JLabel(i1);  //
        image.setBounds(0, 0, 600, 500);    // Only able to use it coz we have setLayout() ourselves
        add(image);                                          // Directly add(i1) nhi kr skte the
        
        JLabel heading = new JLabel("Inquisitive!");
        heading.setBounds(760, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));                       // Color can be set by creating anonymous object by RGB scheme
        add(heading);                                                               // It is a must for adding onto frame
        
        JLabel name = new JLabel("How do you want to addressed");
        name.setBounds(765, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        //Adding box where one needs to enter his name
        
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        //Adding buttons here   // Click Events also needed for that we have implemented Action Listener Interface
        
        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(new Color(30, 144, 254));      // The empty space around button
        rules.setForeground(Color.WHITE);                        // The thing which is written
        rules.addActionListener(this);                           // Need to tell we need Click Event
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);               // Visibility must be set because by default it is hidden : This line  + extends JFrame only required to create Frame        
        setSize(1200, 500);  // With this we set size of frame takes 2 parametes
        setLocation(200, 150);        // Location with respect to screen 200 from left and 150 from top
    }
    
    public void actionPerformed(ActionEvent ae)     // Method overridden
    {
        if (ae.getSource() == rules)                // Which button clicked - Is it rules?
        {
            String name = tfname.getText();         // User input name gets converted into string by the help of getText()
            setVisible(false);
            new Rules(name);                        // Created an object simply bring me to Rules page
        }
        else if (ae.getSource() == back)
        {
            System.exit(0);
            //setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        new Login();
    }
}