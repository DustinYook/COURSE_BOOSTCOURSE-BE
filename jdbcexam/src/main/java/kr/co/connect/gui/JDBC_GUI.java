package kr.co.connect.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import kr.co.connect.jdbcexam.dao.RoleDao;
import kr.co.connect.jdbcexam.dto.Role;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JDBC_GUI 
{
	private JFrame frmJdbcTest;
	private JTextField txtRoleId;
	private JTextField txtDescription;
	private JPanel panel;
	private JLabel lblRoleId;
	private JLabel lblDescription;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnSelect;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;
	
	private RoleDao dao = new RoleDao();

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					JDBC_GUI window = new JDBC_GUI();
					window.frmJdbcTest.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the application */
	public JDBC_GUI() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		frmJdbcTest = new JFrame();
		frmJdbcTest.setResizable(false);
		frmJdbcTest.setTitle("JDBC Test");
		frmJdbcTest.setBounds(100, 100, 571, 405);
		frmJdbcTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frmJdbcTest.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblRoleId = new JLabel("Role ID");
		lblRoleId.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblRoleId.setBounds(45, 49, 80, 22);
		panel.add(lblRoleId);
		
		txtRoleId = new JTextField();
		txtRoleId.setBounds(170, 49, 204, 24);
		panel.add(txtRoleId);
		txtRoleId.setColumns(10);
		
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDescription.setBounds(45, 95, 116, 22);
		panel.add(lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setBounds(170, 95, 204, 22);
		panel.add(txtDescription);
		txtDescription.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 143, 428, 115);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// get the value from text field
				int roleId = Integer.valueOf(txtRoleId.getText());
				
				// execute SELECT query
				Role role = dao.getRole(roleId);
				txtDescription.setText(role.getDescription());
				
				// show the result table
				showAll();
			}
		});
		btnSelect.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnSelect.setBounds(45, 295, 105, 27);
		panel.add(btnSelect);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// get the value from text field
				int roleId = Integer.valueOf(txtRoleId.getText()); 
				String description = txtDescription.getText();
				
				// reset the text field
				txtRoleId.setText(""); 
				txtDescription.setText("");
				
				// create Role instance by using input
				Role role = new Role(roleId, description);
				
				// execute INSERT query
				dao.addRole(role);
				
				// show the result table
				showAll();
			}
		});
		btnInsert.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnInsert.setBounds(164, 295, 105, 27);
		panel.add(btnInsert);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// get the value from text field
				int roleId = Integer.valueOf(txtRoleId.getText());
				
				// reset the text field
				txtRoleId.setText(""); 
				txtDescription.setText("");
				
				// execute DELETE query
				dao.deleteRole(roleId);
				
				// show the result table
				showAll();
			}
		});
		btnDelete.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnDelete.setBounds(283, 295, 105, 27);
		panel.add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// get the value from text field
				int roleId = Integer.valueOf(txtRoleId.getText()); 
				String description = txtDescription.getText();
				
				// reset the text field
				txtRoleId.setText(""); 
				txtDescription.setText("");
				
				// create Role instance by using input
				Role role = new Role(roleId, description);
				
				// execute UPDATE query
				dao.updateRole(role);
				
				// show the result table
				showAll();
			}
		});
		btnUpdate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnUpdate.setBounds(402, 295, 105, 27);
		panel.add(btnUpdate);
	}
	
	public void showAll()
	{
		textArea.setText("");
		List<Role> list = dao.getRoles();
		for(Role role : list) 
			textArea.append(String.format("%d : %s\n", role.getRoleId(), role.getDescription()));
	}
}
