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

import Objecties.Department;
import Objecties.Supplier;

public class SupplierForm implements ActionListener{
	
	JFrame frame;//Supplier_Id	Product_Id	Supplier_Name	Supplier_Address	Supplier_Contact	Gender
	JLabel sid_lb=new JLabel("Supplier_Id");
	JLabel pid_lb=new JLabel("Product_Id");
	JLabel sname_lb=new JLabel("Supplier_Name");
	JLabel phne_lb=new JLabel("Supplier_Phone");
	JLabel email_lb=new JLabel("Email");
	JLabel gender_lb=new JLabel("Gender");
	
	JTextField sid_txf=new JTextField();
	JTextField pid_txf=new JTextField();
	JTextField sname_txf=new JTextField();
	JTextField phne_txf=new JTextField();
	JTextField email_txf=new JTextField();
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
	public SupplierForm(){
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
		frame.setTitle("SUPPLIER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.blue);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		sid_lb.setBounds(10,10,130,30);
		pid_lb.setBounds(10,50,130,30);
		sname_lb.setBounds(10,90,150,30);
		phne_lb.setBounds(10,130,200,30);
		email_lb.setBounds(10,170,190,30);
		gender_lb.setBounds(10, 210, 100, 30);
		
		sid_txf.setBounds(230,10,190,30);
		pid_txf.setBounds(230,50,190,30);
		sname_txf.setBounds(230,90,190,30);
		phne_txf.setBounds(230,130,190,30);
		email_txf.setBounds(230,170,190,30);
        genderBox.setBounds(230, 210, 190, 30);
		
		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		
		table.setBounds(500, 10, 600, 260);

		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		sid_lb.setFont(font);
		pid_lb.setFont(font);
		sname_lb.setFont(font);
		phne_lb.setFont(font);
		email_lb.setFont(font);
		gender_lb.setFont(font);
		
		sid_txf.setFont(font);
		pid_txf.setFont(font);
		sname_txf.setFont(font);
		phne_txf.setFont(font);
		email_txf.setFont(font);
		genderBox.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(sid_lb);
		frame.add(pid_lb);
		frame.add(sname_lb);
		frame.add(phne_lb);
		frame.add(email_lb);
		frame.add(gender_lb);
		
		frame.add(sid_txf);
		frame.add(pid_txf);
		frame.add(sname_txf);
		frame.add(phne_txf);
		frame.add(email_txf);
		frame.add(genderBox);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		frame.add(table);

		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Supplier sp=new Supplier();
		if(e.getSource()==insert_btn) {
			
			sp.setPid(pid_txf.getText());
			sp.setSname(sname_txf.getText());
			sp.setPhne(phne_txf.getText());
			sp.setEmail(email_txf.getText());
			String selectedOption = (String) genderBox.getSelectedItem();
			sp.setGender(selectedOption);
			sp.insertData();
			
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Supplier_Id");
            model.addColumn("Product_Id");
            model.addColumn("Supplier_Name");
            model.addColumn("Supplier_Phone");
            ResultSet resultSet =Supplier.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(sid_txf.getText());
			sp.setPid(pid_txf.getText());
			sp.setSname(sname_txf.getText());
			sp.setPhne(phne_txf.getText());
			sp.setEmail(email_txf.getText());
			sp.setGender((String)genderBox.getSelectedItem());
			sp.update(id);
	    }
	  else {
			int id=Integer.parseInt(sid_txf.getText());
			sp.delete(id);}

	  }
		public static void main(String[] args) {
			SupplierForm spf= new SupplierForm();
			System.out.println(spf);

	}

}

	