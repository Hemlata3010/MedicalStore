package medical;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class InvalidException extends Exception
{
}

class Login1 extends JFrame implements ActionListener
{
	JFrame jf;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,lb;
	JTextField t1,t2;
	JPasswordField p1;
	Font f;
	int cnt=0,cnt1=0;

	Login1()
	{
        jf=new JFrame();
        f = new Font("Times New Roman",Font.PLAIN,20);
		jf.setLayout(null);

        l5 = new JLabel("login");
        l5.setFont(new Font("Algerian",Font.PLAIN,30));
        
        l5.setBounds(350,100,300,40);
		jf.add(l5);

		l3 = new JLabel();
		l3.setBounds(200,220,50,25);
		jf.add(l3);

		l1 = new JLabel("User Name : ");
		l1.setFont(f);
		
		l1.setBounds(250,220,200,25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(380,220,200,25);
		t1.setToolTipText("Enter Username");
		jf.add(t1);

        l4 = new JLabel();
		l4.setBounds(200,300,50,25);
		jf.add(l4);

		l2 = new JLabel("Password  : ");
		l2.setFont(f);
		
		l2.setBounds(250,300,200,25);
		jf.add(l2);

		p1 = new JPasswordField(20);
		p1.setBounds(380,300,200,25);
		p1.setToolTipText("Enter Password");
		jf.add(p1);

		b1 = new JButton("Login");
		b1.setBounds(270,400,100,35);
		jf.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("Clear");
		b2.setBounds(390,400,100,35);
		jf.add(b2);
		b2.addActionListener(this);

		b3 = new JButton("Exit");
		b3.setBounds(510,400,100,35);
		jf.add(b3);
		b3.addActionListener(this);
		
		lb = new JLabel();
		lb.setBounds(0,0,950,800);
		jf.add(lb);
		
		jf.setTitle("Login");
		jf.setLocation(20,20);
	    jf.setSize(900,600);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.white);
		
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				String s=t1.getText();
				String s1=new String(p1.getPassword());
				if((s.compareTo("megha")==0)&&(s1.compareTo("abc")==0))
				{
					JOptionPane.showMessageDialog(null," Welcome to medical store management ...!!!  ","WELCOME",JOptionPane.INFORMATION_MESSAGE);
			   	    jf.setVisible(false);
                       new MainMenu();
				}
				else
				{
					throw new InvalidException();
				}
			}
			catch(Exception e1)
			{
			    cnt++;
			    JOptionPane.showMessageDialog(null," Sorry !!! You are not valid user ...!!!","WARNING",JOptionPane.ERROR_MESSAGE);
			    t1.setText("");
			    p1.setText("");
			    if(cnt==3)
			    {
			         JOptionPane.showMessageDialog(null,"Sorry !!! Your 3 attempts are over ...!!!","WARNING",JOptionPane.ERROR_MESSAGE);
			         System.exit(0);
			    }
            }

		}

		else if(ae.getSource()==b2)
		{
			t1.setText("");
			p1.setText("");

		}

		else if(ae.getSource()==b3)
		{
		    System.exit(0);
		}
	}

	public static void main(String args[])
	{
		new Login1();

	}

}



