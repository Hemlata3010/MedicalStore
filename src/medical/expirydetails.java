package medical;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class expirydetails extends JFrame implements ActionListener
 {
    JFrame jf;
    JButton submit,clear;
    JLabel l1,ln;
    JTextField t1;
    Font f;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
 	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    Date date1;
    GregorianCalendar calendar;
    String strDate;

  public expirydetails()
  {
   jf=new JFrame();
   f = new Font("Times New Roman",Font.PLAIN,20);
   jf.setLayout(null);

  	ln = new JLabel("expiry medicine  Report");
    ln.setFont(new Font("Algerian",Font.PLAIN,25));
    ln.setForeground(new java.awt.Color(204,51,0));
    ln.setBounds(300,70,350,30);
    jf.add(ln);

    l1 = new JLabel("Enter expiry date:");
    l1.setFont(f);
    l1.setBounds(110,130,250,25);
    jf.add(l1);

    t1=new JTextField(10);
    t1.setBounds(370,130,100,25);
    t1.setToolTipText("Enter expiry date");
    jf.add(t1);
    date1= new Date();
 	calendar=new GregorianCalendar();
    calendar.setTime(date1);
    strDate =calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR);
    t1.setText(strDate);

    submit = new JButton("Submit");
    submit.setBounds(170,190,110,35); 
    submit.setToolTipText("click to open daily purchase report");
    jf.add(submit);
    submit.addActionListener(this);

    clear = new JButton("Clear");
    clear.setBounds(360,190,110,35);
    clear.setToolTipText("click to clear textfield");
    jf.add(clear);clear.addActionListener(this);

    scrlPane.setBounds(0,260,900,600);
    jf.add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));

   	model.addColumn("S_ID");
   	model.addColumn("S_NAME");
  	model.addColumn("M_BNO");
  	model.addColumn("M_NAME");
  	model.addColumn("M_EXPDATE");
  	model.addColumn("M_QTY");
  	model.addColumn("M_PURPRICE");
  	model.addColumn("M_SALEPRICE");

    jf.setTitle(" expiry medicine");
    jf.setSize(900,700);
	jf.setLocation(20,20);
	jf.setResizable(false);
    jf.getContentPane().setBackground(new java.awt.Color(255,204,102));
    jf.setVisible(true);
  }

  	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==submit)
	 {//list
  	int r = 0;
     try
     {
     		if(((t1.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Please enter expiry details !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {
	         int foundrec = 0;
     	Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT m_sid,m_sname,m_bno,m_name,m_expdate,m_quantity,m_purprice,m_saleprice from medicine where m_purdate='"+t1.getText()+"' ");
          while(rs.next())
            {
            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
              foundrec = 1;
            }
              if (foundrec == 0)
                {
                    JOptionPane.showMessageDialog(null,"Not any medicine expired on given date","Dialog",JOptionPane.WARNING_MESSAGE);
                }
	        }
             con.close();
       }
      catch(SQLException se)
       {
       	  System.out.println(se);
          JOptionPane.showMessageDialog(null,"SQL Error:"+se);
       }
       catch(Exception e)
       {
       	   System.out.println(e);
           JOptionPane.showMessageDialog(null,"Error:"+e);
       }
	}

	 else if(ae.getSource()==clear)
	 {
	 	t1.setText("");
	 }
    }

  public static void main(String args[])
    {
    	new expirydetails();
    }
}



