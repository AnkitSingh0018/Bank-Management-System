
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton hundred, fivehundred, thousand, twothousand, fivethousand, tenthousand, BACK;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 , 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD, 16));
        image.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(160,395,150,25);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(350,395,150,25);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(160,432,150,25);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(350,432,150,25);
        twothousand.addActionListener(this);
        image.add(twothousand);
        
        
        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(160,468,150,25);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(350,468,150,25);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        BACK = new JButton("BACK");
        BACK.setBounds(160,503,150,25);
        BACK.addActionListener(this);
        image.add(BACK);
        
        setSize(900 , 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == BACK){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //500
            conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != BACK && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
