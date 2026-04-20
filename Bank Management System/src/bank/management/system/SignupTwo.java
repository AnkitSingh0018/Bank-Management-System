package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener{
    JTextField  panTextField, aadharTextField; 
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, catogary, income, education, occupation;
    String formno;
    
    public SignupTwo(String formno) {
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Personal Details");
        additionalDetails.setFont(new Font("Ralway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,40);
        add(additionalDetails);
        
        JLabel religi = new JLabel("Religion:");
        religi.setFont(new Font("Ralway", Font.BOLD,20));
        religi.setBounds(100,140,100,30);
        add(religi);
        
        String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel varcatogar = new JLabel("Category:");
        varcatogar.setFont(new Font("Ralway", Font.BOLD,20));
        varcatogar.setBounds(100,190,200,30);
        add(varcatogar);
        
        String varcatogary[] = {"General","OBC","SC","ST","Other"};
        catogary = new JComboBox(varcatogary);
        catogary.setBounds(300,190,400,30);
        catogary.setBackground(Color.white);
        add(catogary);
        
        JLabel incom = new JLabel("Income:");
        incom.setFont(new Font("Ralway", Font.BOLD,20));
        incom.setBounds(100,240,200,30);
        add(incom);
        
        String varincome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox(varincome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel Educational = new JLabel("Educational");
        Educational.setFont(new Font("Ralway", Font.BOLD,20));
        Educational.setBounds(100,290,200,30);
        add(Educational);
        
        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Ralway", Font.BOLD,20));
        Qualification.setBounds(100,310,200,30);
        add(Qualification);
        
        String vareducation[] = {"10th Pass","12th Pass","Graduate","Post Graduate","Others"};
        education = new JComboBox(vareducation);
        education.setBounds(300,310,400,30);
        education.setBackground(Color.white);
        add(education);
       
        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Ralway", Font.BOLD,20));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        
        String varoccupation[] = {"Salaried","Self Employed","Business","Student","Retired","Others"};
        occupation = new JComboBox(varoccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel PAN = new JLabel("PAN Number.:");
        PAN.setFont(new Font("Ralway", Font.BOLD,20));
        PAN.setBounds(100,440,200,30);
        add(PAN);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Ralway", Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel Senior = new JLabel("Senior Citizen:");
        Senior.setFont(new Font("Ralway", Font.BOLD,20));
        Senior.setBounds(100,540,200,30);
        add(Senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup Seniorgroup = new ButtonGroup();
        Seniorgroup.add(syes);
        Seniorgroup.add(sno);
        
        JLabel exi_acc = new JLabel("Exisiting Account:");
        exi_acc.setFont(new Font("Ralway", Font.BOLD,20));
        exi_acc.setBounds(100,590,200,30);
        add(exi_acc);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(400,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String religions = (String) religion.getSelectedItem();
        String catogarys = (String) catogary.getSelectedItem();
        String incomes = (String) income.getSelectedItem();
        String educations = (String) education.getSelectedItem();
        String occupations = (String) occupation.getSelectedItem();
        
         String Senior = null;
        if (syes.isSelected()){
            Senior = "Yes";
        }else if (sno.isSelected()){
            Senior = "No";
        }
        String exi_acc = null;
        if (syes.isSelected()){
            exi_acc = "Yes";
        }else if (sno.isSelected()){
            exi_acc = "No";
        }
        
       
        
        String pans = panTextField.getText();
        String aadhars = aadharTextField.getText();
        
        
        try{
                conn c = new conn();
                String query = "insert into signupTwo values('"+formno+"', '"+religions+"','"+catogarys+"', '"+incomes+"', '"+educations+"', '"+occupations+"', '"+pans+"', '"+aadhars+"', '"+Senior+"', '"+exi_acc+"')";
                c.s.executeUpdate(query);
                
                //signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args []){
       new SignupTwo("");
    }
}
