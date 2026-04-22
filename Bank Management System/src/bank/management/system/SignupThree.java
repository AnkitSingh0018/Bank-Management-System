package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{
    JButton next;
    JRadioButton r1,r2,r3,r4;
    JButton submit,cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    
    public SignupThree( String formno) {
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Ralway", Font.BOLD,22));
        accountDetails.setBounds(280,40,400,40);
        add(accountDetails);
        
        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Ralway", Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Ralway", Font.BOLD,12));
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Ralway", Font.BOLD,12));
        r2.setBounds(300,180,250,20);
        r2.setBackground(Color.white);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Ralway", Font.BOLD,12));
        r3.setBounds(100,240,150,20);
        r3.setBackground(Color.white);
        add(r3);
        
        r4 = new JRadioButton("Reccuring Account");
        r4.setFont(new Font("Ralway", Font.BOLD,12));
        r4.setBounds(300,240,150,20);
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Ralway", Font.BOLD,20));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4412");
        number.setFont(new Font("Ralway", Font.BOLD,20));
        number.setBounds(300,300,300,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Ralway", Font.BOLD,13));
        carddetail.setBounds(100,320,200,30);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN Number :");
        pin.setFont(new Font("Ralway", Font.BOLD,20));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Ralway", Font.BOLD,20));
        pinnumber.setBounds(300,370,300,30);
        add(pinnumber);
        
        JLabel pindetail = new JLabel("Your 4 Digit PIN Number");
        pindetail.setFont(new Font("Ralway", Font.BOLD,13));
        pindetail.setBounds(100,390,200,30);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Ralway", Font.BOLD,20));
        services.setBounds(100,430,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,13));
        c1.setBounds(100,470,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,13));
        c2.setBounds(350,470,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,13));
        c3.setBounds(100,520,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,13));
        c4.setBounds(350,520,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,13));
        c5.setBounds(100,570,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,13));
        c6.setBounds(350,570,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,11));
        c7.setBounds(100,630,520,30);
        add(c7);
        
        submit = new JButton("submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        submit.setBounds(250,690,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        cancel.setBounds(420,690,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
       
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType =  "Saving Account";
            }else if(r2.isSelected()){
                accountType =  "Fixed Deposit Account";
                
            }else if(r3.isSelected()){
                accountType =  "Current Account";
                        
            }else if(r4.isSelected()){
                accountType =  "Reccuring Deposit Account";
                
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if (c1.isSelected()){
                facility = facility + "ATM CARD";
            }else if (c2.isSelected()){
                facility = facility + "Internet Banking";
            }else if (c3.isSelected()){
                facility = facility + "Mobile Banking";
            }else if (c4.isSelected()){
                facility = facility + "EMAIL & SMS Alerts";
            }else if (c5.isSelected()){
                facility = facility + "Cheque Book";
            }else if (c6.isSelected()){
                facility = facility + "E-Statement";
            }
        
            try {
                if (accountType.equals("")) {
                JOptionPane.showMessageDialog(null,"Account Type is Required"); 
            }else{
                conn c = new conn();
                String query1 = "insert into signupThree values('"+formno+"', '"+accountType+"','"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Card Number: " + cardnumber + "\n PIN: " + pinnumber);
                
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args []){
       new SignupThree("");
    }
}
