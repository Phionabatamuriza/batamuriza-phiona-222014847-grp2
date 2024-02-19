package All.Forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Objecties.Customer;

public class CustomerForm implements ActionListener{
	JFrame frame;
	JLabel cid_lb=new JLabel("Customer_Id");
	JLabel fname_lb=new JLabel("First_Name");
	JLabel lname_lb=new JLabel("Last_Name");
	JLabel email_lb=new JLabel("Email");
	JLabel phn_lb=new JLabel("Phone_Number");
	JLabel gender_lb=new JLabel("Gender");
	
	JTextField cid_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phn_txf=new JTextField();
	JTextField gender_txf=new JTextField();
	
	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CustomerForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		cid_lb.setBounds(10,10,130,30);
		fname_lb.setBounds(10,50,130,30);
		lname_lb.setBounds(10,90,150,30);
		email_lb.setBounds(10,130,200,30);
		phn_lb.setBounds(10,170,150,30);
		gender_lb.setBounds(10, 210, 100, 30);
		
		cid_txf.setBounds(230,10,190,30);
		fname_txf.setBounds(230,50,190,30);
		lname_txf.setBounds(230,90,190,30);
		email_txf.setBounds(230,130,190,30);
		phn_txf.setBounds(230,170,190,30);
        genderBox.setBounds(230, 210, 190, 30);
		
		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		table.setBounds(500, 10, 750, 240);

		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		cid_lb.setFont(font);
		fname_lb.setFont(font);
		lname_lb.setFont(font);
		email_lb.setFont(font);
		phn_lb.setFont(font);
		gender_lb.setFont(font);
		
		cid_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		email_txf.setFont(font);
		phn_txf.setFont(font);
		genderBox.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(cid_lb);
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(email_lb);
		frame.add(phn_lb);
		frame.add(gender_lb);
		
		frame.add(cid_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(email_txf);
		frame.add(phn_txf);
		frame.add(genderBox);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	Customer cst=new Customer();
	if(e.getSource()==insert_btn) {
		
		cst.setFname(fname_txf.getText());
		cst.setLname(lname_txf.getText());
		cst.setEmail(email_txf.getText());
		cst.setPhn(phn_txf.getText());
		String selectedOption = (String) genderBox.getSelectedItem();
		cst.setGender(selectedOption);
		cst.insertData();
		
	}
	
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("Customer_Id");
        model.addColumn("First_Name");
        model.addColumn("Last_Name");
        model.addColumn("Email");
        model.addColumn("Phone_Number");
        model.addColumn("Gender");
       
        ResultSet resultSet =Customer.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4),
                            resultSet.getString(5), resultSet.getString(6)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(cid_txf.getText());
		cst.setFname(fname_txf.getText());
		cst.setLname(lname_txf.getText());
		cst.setEmail(email_txf.getText());
		cst.setPhn(phn_txf.getText());
		cst.setGender((String)genderBox.getSelectedItem());
		cst.update(id);
    }
  else {
		int id=Integer.parseInt(cid_txf.getText());
		cst.delete(id);}

  }
	public static void main(String[] args) {
		CustomerForm csf= new CustomerForm();
		System.out.println(csf);


		
	}

}
