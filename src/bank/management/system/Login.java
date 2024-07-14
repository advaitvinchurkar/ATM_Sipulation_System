
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// to add  action we implement ActionListener
public class Login  extends JFrame implements ActionListener{
    
    JButton login, signup,clear;
    JTextField cardTextFrField;
    JPasswordField pinTextFrField;
    Login()
    {
       //1 we can add imageicon in jlable but we cannot add image in jlable
        // 2 to write any thing in jfream we use jlable
        
        // to set fraem title
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        // to import image we use imageicon class and its object along with the location of image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg" ));
       // to change size of image create image class object
       Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       // convert image into imageicon
       ImageIcon i3=new ImageIcon(i2);

// to place image on fream we add in jlable
        JLabel label=new JLabel(i3);
         //to chage lable location in frean we use setbount function
         label.setBounds(70, 10, 100, 100);
         // coustome layout
         
     
        //to place component i=on fream
        add(label);
        // add contain 
        JLabel text=new JLabel("Welcome to ATM");
        // to change font
        text.setFont(new Font("Osward", Font.BOLD, 38));
        
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        
        JLabel cardno=new JLabel("Card NO.");
        cardno.setFont(new Font("Raieway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardTextFrField= new JTextField();
        cardTextFrField.setBounds(300, 150, 230,30);
        cardTextFrField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextFrField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raieway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextFrField= new JPasswordField();
        pinTextFrField.setBounds(300, 220, 230,30);
        pinTextFrField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextFrField);
        
        // to create button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        // to change colore fream
         getContentPane().setBackground(Color.WHITE);
// to majke frame setseize fun is use
        setSize(800, 500);
        // to see fraem  visible frem
        setVisible(true);
        // to open in center
        setLocation(350, 200);
           
    }
    // after click i=on button action is performed
    public  void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== clear)
        {
            // to clear text firld settext and empty
            cardTextFrField.setText("");
            pinTextFrField.setText("");
        }else if (ae.getSource()== login)
        {
            Conn conn=new Conn();
            String cardnumber=cardTextFrField.getText();
            String pinnumber=pinTextFrField.getText();
            String query = "select * from login where cardnumber='"+cardnumber+"' and pin = '"+pinnumber+"'";
            try {
               ResultSet rs= conn.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }else
               {
                   JOptionPane.showMessageDialog(null, "Incorrect cardnumber or pin");
               }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()== signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
        
    }
    public static void main(String[] args) {
        
        new Login();
          
    }
     
}
