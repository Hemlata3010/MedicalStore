package medical;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class UpdateMedicine extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ln,lb;
    JButton b0,b1,b2,b3;
    JComboBox msname,tabtype;
    String s,sid1,tabt;
	Font f;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	UpdateMedicine()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.PLAIN,20);
		jf.setLayout(null);

	    ln=new JLabel("Update Medicine");
	    ln.setFont(new Font("Algerian",Font.PLAIN,25));
	  //  ln.setForeground(new java.awt.Color(204,0,255));
	    ln.setBounds(300,30,300,40);
	    jf.add(ln);
		
		l1 = new JLabel("Medicine Batch no*:");
		l1.setFont(f);
        l1.setBounds(50,100,200,25);
     //   l1.setForeground(new java.awt.Color(204,204,204));
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(250,100,100,25);t1.setToolTipText("Enter medicine batch no");
		jf.add(t1);

		l2 = new JLabel("Medicine name*:");
		l2.setFont(f);
        l2.setBounds(50,140,200,25);
   //     l2.setForeground(new java.awt.Color(204,204,204));
		jf.add(l2);

    	t2 = new JTextField(20);
		t2.setBounds(250,140,200,25);t2.setToolTipText("Enter medicine name");
		jf.add(t2);

		l10 = new JLabel("Medicine company:");
		l10.setFont(f);
        l10.setBounds(50,180,200,25);
       // l3.setForeground(new java.awt.Color(204,204,204));
		jf.add(l10);

     	t10= new JTextField(20);
		t10.setBounds(250,180,200,25);t10.setToolTipText("Enter medicine company");
		jf.add(t10);

		l3= new JLabel("Medicine quantity:");
		l3.setFont(f);
        l3.setBounds(50,220,200,25);
       // l4.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l3);

        t3= new JTextField(20);
		t3.setBounds(250,220,100,25);t3.setToolTipText("Enter medicine quantity");
		jf.add(t3);

		l5= new JLabel("Med expiry date:");
		l5.setFont(f);
        l5.setBounds(50,260,250,25);
   //    l5.setForeground(new java.awt.Color(204,204,204));
		jf.add(l5);

	    t5= new JTextField(20);
		t5.setBounds(250,260,100,25);t5.setToolTipText("Enter medicine expiry date");
		jf.add(t5);

	    l4= new JLabel("Med purchase date:");
		l4.setFont(f);
        l4.setBounds(50,300,260,25);
       // l6.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l4);

        t4= new JTextField(20);
		t4.setBounds(250,300,100,25);t4.setToolTipText("Enter medicine expiry date");
		jf.add(t4);

		l6 = new JLabel("Medicine type:");
		l6.setFont(f);
        l6.setBounds(470,100,200,25);
     //   l7.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l6);

        t6= new JTextField(20);
		t6.setBounds(720,100,100,25);t6.setToolTipText("Enter medicine type");
		jf.add(t6);

    	tabtype=new JComboBox();
        tabtype.addItem("--type--");
		tabtype.addItem("Tablet");
		tabtype.addItem("Capsule");
		tabtype.addItem("Syrup");
		tabtype.addItem("Insulin");
		tabtype.addItem("Cream");
		tabtype.addItem("Balm");
		tabtype.addItem("Drop");
		tabtype.addItem("Granul");
		tabtype.addItem("Oil");
		tabtype.addItem("Powder");
		tabtype.setBounds(600,100,100,25);tabtype.setToolTipText("Select medicine type");
		jf.add(tabtype);
		tabtype.addActionListener(new ActionListener()
	     {
		   public void actionPerformed(ActionEvent ae)
		   {
		    tabt =(String)tabtype.getSelectedItem();
		    t6.setText(tabt);
		   }
          });



		l7= new JLabel("Medicine purchase price:");
		l7.setFont(f);
        l7.setBounds(470,140,220,25);
     //   l8.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l7);

        t7 = new JTextField(20);
		t7.setBounds(720,140,100,25);t7.setToolTipText("Enter medicine purchase price");
		jf.add(t7);

		l12 = new JLabel("Medicine sale price:");
		l12.setFont(f);
        l12.setBounds(470,180,200,25);
    //    l9.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l12);

        t12 = new JTextField(20);
		t12.setBounds(720,180,100,25);t12.setToolTipText("Enter medicine sale price");
		jf.add(t12);

		l11 = new JLabel("Medicine rack no:");
		l11.setFont(f);
        l11.setBounds(470,220,200,25);
     //   l10.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l11);

        t11 = new JTextField(20);
		t11.setBounds(720,220,100,25);t11.setToolTipText("Enter medicine rack no");
		jf.add(t11);

		l9 = new JLabel("Supplier name:");
		l9.setFont(f);
	    l9.setBounds(470,260,180,25);
	  //  l11.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l9);

    	t9 = new JTextField(20);
		t9.setBounds(720,260,100,25);
		jf.add(t9);

    	l8 = new JLabel("Supplier id:");
		l8.setFont(f);
        l8.setBounds(470,300,180,25);
      //  l12.setForeground(new java.awt.Color(204,204,204));
    	jf.add(l8);

    	t8 = new JTextField(20);
	    t8.setBounds(720,300,100,25);
	    jf.add(t8);


        msname=new JComboBox();
        msname.setBounds(600,260,110,25);msname.setToolTipText("select medicine supplier name");
        jf.add(msname);
        msname.addActionListener(new ActionListener()
	     {
		   public void actionPerformed(ActionEvent ae)
		   {
		    s =(String)msname.getSelectedItem();
		    t9.setText(s);
		   }
          });

        try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
			System.out.println("Connected to database.");
			 ps=con.prepareStatement("select sid,sname from supplier");
		    rs=ps.executeQuery();
    		while(rs.next())
    		{
    	     sid1=rs.getString(1);
    		 String sname1=rs.getString(2);
    		 msname.addItem(sname1);
    		}

    	con.close();
       }
       catch(SQLException se)
       {
       System.out.println(se);
       }
      catch(Exception e)
       {
       System.out.println(e);
       }

        b0 = new JButton("Open",new ImageIcon("images//open.png"));
        b0.setBounds(150,330,110,35);b0.setToolTipText("click to open medicine details");
		jf.add(b0);b0.addActionListener(this);

		b1 = new JButton("Update",new ImageIcon("images//update.png"));
		b1.setBounds(300,330,110,35);b1.setToolTipText("click to update medicine details");
	    jf.add(b1); b1.addActionListener(this);

        b2= new JButton("Clear",new ImageIcon("images//clear.png"));
		b2.setBounds(450,330,110,35);b2.setToolTipText("click to clear all textfields");
		jf.add(b2); b2.addActionListener(this);

    	b3 = new JButton("All",new ImageIcon("images//all.png"));
		b3.setBounds(600,330,110,35);b3.setToolTipText("click to view all medicine details");
		jf.add(b3); b3.addActionListener(this);

	    scrlPane.setBounds(0,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("M_BNO");
        model.addColumn("M_NAME");
        model.addColumn("M_COMPANY");
        model.addColumn("M_QUANTITY");
        model.addColumn("M_EXPDATE");
        model.addColumn("M_PURDATE");
        model.addColumn("M_TYPE");
        model.addColumn("M_SALEPRICE");
        model.addColumn("M_PURPRICE");
        model.addColumn("M_RACKNO");
        model.addColumn("M_SID");
        model.addColumn("M_SNAME");

        lb = new JLabel(new ImageIcon("pics//pic22.jpg"));
		lb.setBounds(0,0,900,700);
		jf.add(lb);
		
	     jf.setTitle("Update Medicine ");
	     jf.setSize(900,700);
		 jf.setLocation(20,20);
		 jf.setResizable(false);
		 jf.getContentPane().setBackground(Color.cyan);
	     jf.setVisible(true);
 }

 public void actionPerformed(ActionEvent ae)
  {
  	if(ae.getSource()==b0)
	  {
	  	 	 if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Please enter medicine batchno or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {

	      try
	       {//fetch
	      int foundrec = 0;
	    Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");
			ps=con.prepareStatement("Select sid from supplier where sname='"+s+"'");
    		  rs=ps.executeQuery();
    		  while(rs.next())
    		  {
    		  	String sid1=rs.getString(1);
	    	   t8.setText(sid1);
    	      }

		  ps=con.prepareStatement("select * from medicine where m_name='"+t2.getText()+"' or m_bno='"+t1.getText()+"' ");
		  rs=ps.executeQuery();
		  while(rs.next())
	      {
		    t1.setText(rs.getString(1));
	        t2.setText(rs.getString(2));
	        t10.setText(rs.getString(10));
	        t3.setText(rs.getString(3));
		    t5.setText(rs.getString(5));
		    t4.setText(rs.getString(4));
	        t6.setText(rs.getString(6));
	        t7.setText(rs.getString(7));
	        t12.setText(rs.getString(12));
		    t11.setText(rs.getString(11));
		    t8.setText(rs.getString(8));
		    t9.setText(rs.getString(9));
		     foundrec = 1;
	       }
	       if (foundrec == 0)
                {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialogs",JOptionPane.WARNING_MESSAGE);
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
  }
  else if(ae.getSource()==b1)
	   {
	   try
	    {
	    	if(((t1.getText()).equals(""))||((t2.getText()).equals(""))||((t10.getText()).equals(""))||((t3.getText()).equals(""))||((t5.getText()).equals(""))||((t4.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals(""))||((t12.getText()).equals(""))||((t11.getText()).equals(""))||((t8.getText()).equals(""))||((t9.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
			System.out.println("Connected to database.");
			stmt=con.createStatement();
        String str1="UPDATE medicine SET m_bno='"+t1.getText()+"',m_name='"+t2.getText()+"',m_company='"+t10.getText()+"',m_quantity='"+t3.getText()+"',m_expdate='"+t5.getText()+"',m_purdate='"+t4.getText()+"',m_type='"+t6.getText()+"',m_purprice='"+t7.getText()+"',m_saleprice='"+t12.getText()+"',m_rackno='"+t11.getText()+"',m_sid='"+t8.getText()+"',m_sname='"+t9.getText()+"' where m_bno='"+t1.getText()+"'or m_name='"+t2.getText()+"'";
    	stmt.executeUpdate(str1);
    	JOptionPane.showMessageDialog(null, "Record is updated");
    	t1.setText("");
	    t2.setText("");
		t10.setText("");
	    t3.setText("");
    	t5.setText("");
    	t4.setText("");
	    t6.setText("");
		t7.setText("");
	    t12.setText("");
    	t11.setText("");
    	t8.setText("");
    	t9.setText("");
    	con.close();
       }
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
  else if(ae.getSource()==b2)
      {    t1.setText("");
           t2.setText("");
           t10.setText("");
           t3.setText("");
           t5.setText("");
           t4.setText("");
	       t6.setText("");
		   t7.setText("");
           t12.setText("");
           t11.setText("");
           t8.setText("");
           t9.setText("");
      }
 else if(ae.getSource()==b3)
    {//list
  	int r = 0;
     try
     {
         Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * from medicine order by m_bno asc" );
          while(rs.next())
            {
model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(10),rs.getString(3),rs.getString(5),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(12),rs.getString(11),rs.getString(8),rs.getString(9) });
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
 }
 public static void main(String args[])
 {
  new UpdateMedicine();
 }
}

