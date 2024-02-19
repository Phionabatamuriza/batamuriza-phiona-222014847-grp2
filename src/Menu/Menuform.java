package Menu;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import All.Forms.CustomerForm;
import All.Forms.DepartmentForm;
import All.Forms.EmployeeForm;
import All.Forms.ProductForm;
import All.Forms.SupplierForm;


public class Menuform extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Customermenu;
    private JMenu departmentmenu;
    private JMenu Employeemenu;
    private JMenu Productmenu;
    private JMenu Suppliermenu;
    private JMenu Logoutmenu;

	public Menuform() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem CustomerItem;
    private JMenuItem DepartmentItem;
    private JMenuItem EmployeeItem;
    private JMenuItem ProductItem;
    private JMenuItem SupplierItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public Menuform(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Customermenu = new JMenu("Customer");
        departmentmenu = new JMenu("department");
        Employeemenu= new JMenu("Employee");
        Productmenu = new JMenu("Product ");
        Suppliermenu = new JMenu("Supplier");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Customermenu);
        CustomerItem = new JMenuItem("CustomerForm");
        CustomerItem.addActionListener(this);
        
        menuBar.add(departmentmenu);
        DepartmentItem = new JMenuItem("departmentForm");
        DepartmentItem.addActionListener(this);
        
        menuBar.add(Employeemenu);
        EmployeeItem = new JMenuItem("EmployeeForm");
        EmployeeItem.addActionListener(this);
        
        menuBar.add(Productmenu);
        ProductItem = new JMenuItem("product");
        ProductItem.addActionListener(this);
        
        menuBar.add(Suppliermenu);
        SupplierItem = new JMenuItem("SupplierForm");
        SupplierItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Customermenu.add(CustomerItem);
        departmentmenu.add(DepartmentItem);
        Employeemenu.add(EmployeeItem);
        Productmenu.add(ProductItem);
        Suppliermenu.add(SupplierItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CustomerItem) {
            new CustomerForm();
        
        } else if (e.getSource() == DepartmentItem) {
            new DepartmentForm();
        
        } else if (e.getSource() == EmployeeItem) {
            new EmployeeForm();
       
        } else if (e.getSource() == ProductItem) {
           new ProductForm();
        
        } else if (e.getSource() == SupplierItem) {
           new SupplierForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menuform ("TO COMPANY MANAGEMENT SYSTEM"));
    }
}






