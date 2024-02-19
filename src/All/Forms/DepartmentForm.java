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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Objecties.Department;
import Objecties.Product;

public class DepartmentForm implements ActionListener{
	JFrame frame;
	JLabel depid_lb=new JLabel("Department_Id");
	JLabel depname_lb=new JLabel("Department_Name");
	JLabel location_lb=new JLabel("Department_Location");
	
	
	JTextField depid_txf=new JTextField();
	JTextField depname_txf=new JTextField();
	JTextField location_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public DepartmentForm(){
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
		frame.setTitle("DEPARTMENT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		depid_lb.setBounds(10,10,170,30);
		depname_lb.setBounds(10,50,180,30);
		location_lb.setBounds(10,90,220,30);
		
		depid_txf.setBounds(250,10,190,30);
		depname_txf.setBounds(250,50,190,30);
		location_txf.setBounds(250,90,190,30);
		
		insert_btn.setBounds(10,190,85,30);
		read_btn.setBounds(100,190,85,30);
		update_btn.setBounds(190,190,85,30);
		delete_btn.setBounds(280,190,85,30);
		table.setBounds(500, 10, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		depid_lb.setFont(font);
		depname_lb.setFont(font);
		location_lb.setFont(font);
		
		
		depid_txf.setFont(font);
		depname_txf.setFont(font);
		location_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(depid_lb);
		frame.add(depname_lb);
		frame.add(location_lb);
		
		frame.add(depid_txf);
		frame.add(depname_txf);
		frame.add(location_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Department dp=new Department();
		if(e.getSource()==insert_btn) {
			dp.setDepname(depname_txf.getText());
			dp.setLocation(location_txf.getText());
			dp.insertData();
			
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Department_Id");
            model.addColumn("Department_Name");
            model.addColumn("Department_Location");
        	
            ResultSet resultSet =Product.viewData();
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
			int id=Integer.parseInt(depid_txf.getText());
			dp.setDepname(depname_txf.getText());
			dp.setLocation(location_txf.getText());
			
			dp.update(id);
	    }
	   else {
			int id=Integer.parseInt(depid_txf.getText());
			dp.delete(id);}

	  }
	public static void main(String[] args) {
		DepartmentForm dpf= new DepartmentForm();
		System.out.println(dpf);	
			
		}

	}


