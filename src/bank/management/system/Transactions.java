
package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposite,withdrawl,fastcash,minisatatement,pinchange,blanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("Plaese select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        
        deposite=new JButton("Deposit");
        deposite.setBounds(170,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
         withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
          minisatatement=new JButton("Mini Statement");
        minisatatement.setBounds(355,450,150,30);
        minisatatement.addActionListener(this);
        image.add(minisatatement);
        
         pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
          blanceenquiry=new JButton("Blance Enquiry");
        blanceenquiry.setBounds(355,485,150,30);
        blanceenquiry.addActionListener(this);
        image.add(blanceenquiry);
        
         exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== exit)
        {
            System.exit(0);
        }else if(ae.getSource()== deposite)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()== fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()== pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()== blanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()== minisatatement)
        {
           
            new MniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args) {
        new Transactions("");
   }
    
    
}
