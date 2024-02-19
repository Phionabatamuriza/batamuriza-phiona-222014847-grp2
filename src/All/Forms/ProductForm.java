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

import Objecties.Product;

public class ProductForm implements ActionListener{
	JFrame frame;
	JLabel pid_lb=new JLabel("Product_Id");
	JLabel pname_lb=new JLabel("Product_Name");
	JLabel pprice_lb=new JLabel("Product_Price");
	
	JTextField pid_txf=new JTextField();
	JTextField pname_txf=new JTextField();
	JTextField pprice_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public ProductForm(){
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
		frame.setTitle("PRODUCT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		pid_lb.setBounds(10,10,130,30);
		pname_lb.setBounds(10,50,150,30);
		pprice_lb.setBounds(10,90,200,30);
	
		pid_txf.setBounds(230,10,190,30);
		pname_txf.setBounds(230,50,190,30);
		pprice_txf.setBounds(230,90,190,30);
		
		insert_btn.setBounds(10,170,85,30);
		read_btn.setBounds(100,170,85,30);
		update_btn.setBounds(190,170,85,30);
		delete_btn.setBounds(280,170,85,30);
		
		table.setBounds(500, 10, 600, 240);

		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		pid_lb.setFont(font);
		pname_lb.setFont(font);
		pprice_lb.setFont(font);
		
		pid_txf.setFont(font);
		pname_txf.setFont(font);
		pprice_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(pid_lb);
		frame.add(pname_lb);
		frame.add(pprice_lb);
		
		frame.add(pid_txf);
		frame.add(pname_txf);
		frame.add(pprice_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent ();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Product pr=new Product();
		if(e.getSource()==insert_btn) {
			pr.setPname(pname_txf.getText());
			pr.setPprice(pprice_txf.getText());
			pr.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Product_Id");
            model.addColumn("Product_Name");
            model.addColumn("Product_Price");
           
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
			int id=Integer.parseInt(pid_txf.getText());
			pr.setPname(pname_txf.getText());
			pr.setPprice(pprice_txf.getText());
			pr.update(id);
	    }
	  else {
			int id=Integer.parseInt(pid_txf.getText());
			pr.delete(id);}

	  }
	
	public static void main(String[] args) {
		ProductForm ProductForm= new ProductForm();
		System.out.println(ProductForm);

	}

}
