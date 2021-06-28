package EducationDayCamp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;  
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Assignment3.Register;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	//private static javax.swing.JTable tableParticipant;
    private JTable tableParticipant;
    private JTextField textFieldName;
    private JTextField textFieldContactNo;
    private JTextField textFieldDuration;
    private JTextField textFieldAllowance;
    private JTextField textFieldBonus;
    private JTextField textFieldSalary;
    private JComboBox comboBoxGender;
    private JComboBox comboBoxEvent;
	DefaultTableModel model;
	private JTextField FITNESS;
	private JTextField SURVIVALIST;
	private JTextField LEADERSHIP;
	private JTextField INCOME;
	private JTextField fitnessTrainer;
	private JTextField fitnessAllowance;
	private JTextField fitnessBonus;
	private JTextField survivalistBonus;
	private JTextField survivalistAllowance;
	private JTextField survivalistTrainer;
	private JTextField leadershipBonus;
	private JTextField LeadershipAllowance;
	private JTextField leadershipTrainer;
	private JTextField EXPENSES;
	private JTextField PROFIT;
	private JTable tableTrainer;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\Assignment3\\uum logo.png"));
		setTitle("EDC UUM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1013, 749);
		tabbedPane.setBackground(new Color(0, 139, 139));
		contentPane.add(tabbedPane);
		
		//PARTICIPANT
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		tabbedPane.addTab("Participant", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 73, 900, 500);
		panel.add(scrollPane);
		
		tableParticipant = new JTable();
		tableParticipant.setFont(new Font("Tahoma", Font.BOLD, 10));
		
			tableParticipant.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
				},
				new String[] {
					"First Name", "Last Name", "Gender", "Contact No", "Event"
				}
			));
		scrollPane.setViewportView(tableParticipant);
		
		JButton btnDeleteParticipant = new JButton("DELETE");
		btnDeleteParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)tableParticipant.getModel();
				if(tableParticipant.getSelectedRow()==-1) {
					if(tableParticipant.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"No data to delete");
					}else {
						JOptionPane.showMessageDialog(null,"Select a row to delete");
					}
				}else {
					model.removeRow(tableParticipant.getSelectedRow());
				}
			}
		});
		btnDeleteParticipant.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteParticipant.setBackground(UIManager.getColor("activeCaption"));
		btnDeleteParticipant.setBounds(433, 24, 85, 21);
		panel.add(btnDeleteParticipant);
		
		JButton btnUpdateParticipant = new JButton("UPDATE");
		btnUpdateParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)tableParticipant.getModel();
				int i = tableParticipant.getSelectedRow();
			    if(i>=0) //if single row is selected than update
			    {
			    	JOptionPane.showMessageDialog(null, "Update Successfully");
			    }
			    else 
			    {
			    	JOptionPane.showMessageDialog(null, "Please Select a Row First!");
			    }
			}
		});
		btnUpdateParticipant.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateParticipant.setBackground(UIManager.getColor("activeCaption"));
		btnUpdateParticipant.setBounds(528, 24, 85, 21);
		panel.add(btnUpdateParticipant);
		
		JButton btnImport = new JButton("IMPORT TABLE");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filePath = "E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\Assignment3\\Participant.txt";
		        File file = new File(filePath);
		        
		        try {
		        	
		           FileReader fr = new FileReader(file);
		           BufferedReader br = new BufferedReader(fr);
		            
		            DefaultTableModel model = (DefaultTableModel)tableParticipant.getModel();
		            Object[] lines = br.lines().toArray();
		            
		            for(int i = 0; i < lines.length; i++){
		                String[] row = lines[i].toString().split(" ");
		                model.addRow(row);
		            }
		            
		        } catch (Exception ex) {
		            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        

			}
		});
		btnImport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnImport.setBackground(UIManager.getColor("activeCaption"));
		btnImport.setBounds(298, 24, 125, 21);
		panel.add(btnImport);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(128, 0, 0), 4));
		panel_8.setBackground(new Color(175, 238, 238));
		panel_8.setBounds(27, 53, 947, 541);
		panel.add(panel_8);
		
		
		
		
		
		
		
		//TRAINER
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		tabbedPane.addTab("Trainer", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(139, 0, 0), 5));
		panel_3.setBackground(new Color(220, 20, 60));
		panel_3.setBounds(419, 45, 579, 528);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 559, 456);
		panel_3.add(scrollPane_1);
		
		tableTrainer = new JTable();
		tableTrainer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableTrainer.getSelectedRow();
				if (i<=0) {
					textFieldName.setText(model.getValueAt(i, 0).toString());
					comboBoxGender.setSelectedItem(model.getValueAt(i, 1).toString());
					textFieldContactNo.setText(model.getValueAt(i, 2).toString());
					comboBoxEvent.setSelectedItem(model.getValueAt(i, 3).toString());
					textFieldDuration.setText(model.getValueAt(i, 4).toString());
					textFieldAllowance.setText(model.getValueAt(i, 5).toString());
					textFieldBonus.setText(model.getValueAt(i, 6).toString());
					textFieldSalary.setText(model.getValueAt(i, 7).toString());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a row first !");
				}
				
			}
		});
		model=new DefaultTableModel();
		Object [] column = {"Name","Gender","Contact No","Event","Duration","Allowance","Bonus","Salary"};
		final Object [] row = new Object[8];
		model.setColumnIdentifiers(column);
		tableTrainer.setModel(model);
		scrollPane_1.setViewportView(tableTrainer);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(220, 20, 60));
		panel_4.setBorder(new LineBorder(new Color(128, 0, 0), 4));
		panel_4.setBounds(10, 45, 329, 208);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 34, 45, 13);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 71, 45, 13);
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact No");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(10, 108, 69, 13);
		panel_4.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Event ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(10, 150, 45, 13);
		panel_4.add(lblNewLabel_1_3);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldName.setBounds(93, 31, 156, 19);
		panel_4.add(textFieldName);
		textFieldName.setColumns(10);
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Select A Gender", "Female", "Male"}));
		comboBoxGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxGender.setBounds(93, 67, 156, 21);
		panel_4.add(comboBoxGender);
		
		textFieldContactNo = new JTextField();
		textFieldContactNo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldContactNo.setColumns(10);
		textFieldContactNo.setBounds(93, 105, 156, 19);
		panel_4.add(textFieldContactNo);
		
		JComboBox comboBoxEvent = new JComboBox();
		comboBoxEvent.setModel(new DefaultComboBoxModel(new String[] {"Select An Event", "Fitness Camp", "Survivalist Camp", "Leadership Camp"}));
		comboBoxEvent.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxEvent.setBounds(93, 146, 156, 21);
		panel_4.add(comboBoxEvent);
		
		JButton btnAddRecord = new JButton("ADD RECORD");
		btnAddRecord.setBounds(39, 482, 118, 21);
		panel_3.add(btnAddRecord);
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldName.getText().equals("")||comboBoxGender.getSelectedItem().equals("Select A Gender")||textFieldContactNo.getText().equals("")||comboBoxEvent.getSelectedItem().equals("Select An Event")||textFieldDuration.getText().equals("")||textFieldAllowance.getText().equals("")||textFieldBonus.getText().equals("")||textFieldSalary.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}
				else {
					row[0]=textFieldName.getText();
					row[1]=comboBoxGender.getSelectedItem();
					row[2]=textFieldContactNo.getText();
					row[3]=comboBoxEvent.getSelectedItem();
					row[4]=textFieldDuration.getText();
					row[5]=textFieldAllowance.getText();
					row[6]=textFieldBonus.getText();
					row[7]=textFieldSalary.getText();
					model.addRow(row);
					JOptionPane.showMessageDialog(null, "Record Added !");
				}
				
			}
		});
		btnAddRecord.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddRecord.setBackground(UIManager.getColor("activeCaption"));
		
		JButton btnDeleteTrainer = new JButton("DELETE ");
		btnDeleteTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i= tableTrainer.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted Successfully !");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First !");
				}
			}
		});
		btnDeleteTrainer.setBounds(420, 482, 101, 21);
		panel_3.add(btnDeleteTrainer);
		btnDeleteTrainer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteTrainer.setBackground(UIManager.getColor("activeCaption"));
		
		JButton btnUpdateTrainer = new JButton("UPDATE ");
		btnUpdateTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=tableTrainer.getSelectedRow();
				if (i>=0) {
					model.setValueAt(textFieldName.getText(), i, 0);
					model.setValueAt(comboBoxGender.getSelectedItem(), i, 1);
					model.setValueAt(textFieldContactNo.getText(), i, 2);
					model.setValueAt(comboBoxEvent.getSelectedItem(), i, 3);
					model.setValueAt(textFieldDuration.getText(), i, 4);
					model.setValueAt(textFieldAllowance.getText(), i, 5);
					model.setValueAt(textFieldBonus.getText(), i, 6);
					model.setValueAt(textFieldSalary.getText(), i, 7);
					JOptionPane.showMessageDialog(null, "Updated Successfully !");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First !");
				}
				
				
			}
		});
		btnUpdateTrainer.setBounds(299, 482, 101, 21);
		panel_3.add(btnUpdateTrainer);
		btnUpdateTrainer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateTrainer.setBackground(UIManager.getColor("activeCaption"));
		
		JButton btnExportTrainer = new JButton("EXPORT");
		btnExportTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					File file = new File("E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\Assignment3\\Trainer.txt");
					if(!file.exists()) {
						file.createNewFile();
						}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
					for (int i=0; i<tableTrainer.getRowCount(); i++) {
						for (int j=0; j<tableTrainer.getColumnCount(); j++) {
							bw.write(tableTrainer.getModel().getValueAt(i, j) + "  ");
							}
						bw.write("\n________\n");
						}
						bw.close();
						fw.close();
						JOptionPane.showMessageDialog(null, "Data Exported");
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		btnExportTrainer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportTrainer.setBackground(UIManager.getColor("activeCaption"));
		btnExportTrainer.setBounds(180, 482, 101, 21);
		panel_3.add(btnExportTrainer);
		
		
		
		
		JLabel lblNewLabel = new JLabel("TRAINER DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 162, 36);
		panel_1.add(lblNewLabel);
		
		JLabel lblSalaryDetails = new JLabel("SALARY DETAILS");
		lblSalaryDetails.setBounds(10, 308, 156, 13);
		panel_1.add(lblSalaryDetails);
		lblSalaryDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBounds(13, 331, 329, 199);
		panel_1.add(panel_4_1);
		panel_4_1.setBorder(new LineBorder(new Color(128, 0, 0), 4));
		panel_4_1.setBackground(new Color(220, 20, 60));
		panel_4_1.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Duration (Days)");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(10, 24, 89, 13);
		panel_4_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Allowance (per day) (RM)");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(10, 63, 145, 13);
		panel_4_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Bonus  (RM)");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_6.setBounds(10, 101, 89, 13);
		panel_4_1.add(lblNewLabel_1_6);
		
		textFieldDuration = new JTextField();
		textFieldDuration.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldDuration.setColumns(10);
		textFieldDuration.setBounds(163, 20, 156, 19);
		panel_4_1.add(textFieldDuration);
		
		textFieldAllowance = new JTextField();
		textFieldAllowance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldAllowance.setColumns(10);
		textFieldAllowance.setBounds(163, 59, 156, 19);
		panel_4_1.add(textFieldAllowance);
		
		textFieldBonus = new JTextField();
		textFieldBonus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldBonus.setColumns(10);
		textFieldBonus.setBounds(163, 97, 156, 19);
		panel_4_1.add(textFieldBonus);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Salary (RM)");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_6_1.setBounds(10, 174, 89, 13);
		panel_4_1.add(lblNewLabel_1_6_1);
		
		textFieldSalary = new JTextField();
		textFieldSalary.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldSalary.setColumns(10);
		textFieldSalary.setBounds(163, 170, 156, 19);
		panel_4_1.add(textFieldSalary);
		
		
		JButton btncalcSalary = new JButton("CALCULATE");
		btncalcSalary.setBounds(95, 139, 107, 21);
		panel_4_1.add(btncalcSalary);
		btncalcSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int duration;
				double allowance,bonus,salary;
				
				try {
					duration = Integer.parseInt(textFieldDuration.getText());
					allowance = Double.parseDouble(textFieldAllowance.getText());
					bonus = Double.parseDouble(textFieldBonus.getText());
					
					salary = (duration * allowance) + bonus;
					textFieldSalary.setText(Double.toString(salary));
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter valid number !");
				}
			}
		});
		btncalcSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		btncalcSalary.setBackground(UIManager.getColor("activeCaption"));
		
		
		
		JButton btnResetSalary = new JButton("RESET");
		btnResetSalary.setBounds(232, 540, 107, 21);
		panel_1.add(btnResetSalary);
		btnResetSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				comboBoxGender.setSelectedItem("Select A Gender");
				textFieldContactNo.setText("");
				comboBoxEvent.setSelectedItem("Select An Event");
				textFieldDuration.setText("");
				textFieldAllowance.setText("");
				textFieldBonus.setText("");
				textFieldSalary.setText("");
			}
		});
		btnResetSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnResetSalary.setBackground(UIManager.getColor("activeCaption"));
		
		
		
		//Finance
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 102, 51));
		tabbedPane.addTab("Finance", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(128, 0, 0), 4));
		panel_5.setBackground(new Color(255, 102, 102));
		panel_5.setBounds(324, 43, 265, 238);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("No.OF.Participant");
		lblNewLabel_4.setBounds(10, 56, 119, 13);
		panel_5.add(lblNewLabel_4);
		
		FITNESS = new JTextField();
		FITNESS.setBounds(119, 53, 96, 19);
		panel_5.add(FITNESS);
		FITNESS.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("SURVIVALIST CAMP");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_1.setBounds(60, 79, 127, 36);
		panel_5.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("No.OF.Participant");
		lblNewLabel_4_1.setBounds(10, 126, 119, 13);
		panel_5.add(lblNewLabel_4_1);
		
		SURVIVALIST = new JTextField();
		SURVIVALIST.setColumns(10);
		SURVIVALIST.setBounds(119, 123, 96, 19);
		panel_5.add(SURVIVALIST);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("LEADERSHIP CAMP");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_1_1.setBounds(60, 149, 127, 36);
		panel_5.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("No.OF.Participant");
		lblNewLabel_4_1_1.setBounds(10, 195, 119, 13);
		panel_5.add(lblNewLabel_4_1_1);
		
		LEADERSHIP = new JTextField();
		LEADERSHIP.setColumns(10);
		LEADERSHIP.setBounds(119, 192, 96, 19);
		panel_5.add(LEADERSHIP);
		
		JLabel lblNewLabel_3 = new JLabel("FITNESS CAMP");
		lblNewLabel_3.setBounds(60, 10, 93, 36);
		panel_5.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new LineBorder(new Color(128, 0, 0), 4));
		panel_5_1.setBackground(new Color(255, 102, 102));
		panel_5_1.setBounds(10, 43, 280, 371);
		panel_2.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("FITNESS CAMP");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2.setBounds(78, 0, 93, 36);
		panel_5_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("No.OF.Trainers");
		lblNewLabel_4_2.setBounds(28, 46, 119, 13);
		panel_5_1.add(lblNewLabel_4_2);
		
		fitnessTrainer = new JTextField();
		fitnessTrainer.setColumns(10);
		fitnessTrainer.setBounds(137, 43, 96, 19);
		panel_5_1.add(fitnessTrainer);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Allowance (per day)");
		lblNewLabel_4_2_1.setBounds(28, 72, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_1);
		
		fitnessAllowance = new JTextField();
		fitnessAllowance.setColumns(10);
		fitnessAllowance.setBounds(137, 69, 96, 19);
		panel_5_1.add(fitnessAllowance);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Bonus");
		lblNewLabel_4_2_1_1.setBounds(28, 98, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_1_1);
		
		fitnessBonus = new JTextField();
		fitnessBonus.setColumns(10);
		fitnessBonus.setBounds(137, 95, 96, 19);
		panel_5_1.add(fitnessBonus);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("SURVIVALIST CAMP");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2_1.setBounds(78, 122, 119, 36);
		panel_5_1.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("No.OF.Trainers");
		lblNewLabel_4_2_2.setBounds(28, 168, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("Allowance (per day)");
		lblNewLabel_4_2_1_2.setBounds(28, 194, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_1_2);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("Bonus");
		lblNewLabel_4_2_1_1_1.setBounds(28, 220, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_1_1_1);
		
		survivalistBonus = new JTextField();
		survivalistBonus.setColumns(10);
		survivalistBonus.setBounds(137, 217, 96, 19);
		panel_5_1.add(survivalistBonus);
		
		survivalistAllowance = new JTextField();
		survivalistAllowance.setColumns(10);
		survivalistAllowance.setBounds(137, 191, 96, 19);
		panel_5_1.add(survivalistAllowance);
		
		survivalistTrainer = new JTextField();
		survivalistTrainer.setColumns(10);
		survivalistTrainer.setBounds(137, 165, 96, 19);
		panel_5_1.add(survivalistTrainer);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("LEADERSHIP CAMP");
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2_2.setBounds(78, 243, 119, 36);
		panel_5_1.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("No.OF.Trainers");
		lblNewLabel_4_2_3.setBounds(28, 289, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_3);
		
		JLabel lblNewLabel_4_2_1_3 = new JLabel("Allowance (per day)");
		lblNewLabel_4_2_1_3.setBounds(28, 315, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_1_3);
		
		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("Bonus");
		lblNewLabel_4_2_1_1_2.setBounds(28, 341, 119, 13);
		panel_5_1.add(lblNewLabel_4_2_1_1_2);
		
		leadershipBonus = new JTextField();
		leadershipBonus.setColumns(10);
		leadershipBonus.setBounds(137, 338, 96, 19);
		panel_5_1.add(leadershipBonus);
		
		LeadershipAllowance = new JTextField();
		LeadershipAllowance.setColumns(10);
		LeadershipAllowance.setBounds(137, 312, 96, 19);
		panel_5_1.add(LeadershipAllowance);
		
		leadershipTrainer = new JTextField();
		leadershipTrainer.setColumns(10);
		leadershipTrainer.setBounds(137, 286, 96, 19);
		panel_5_1.add(leadershipTrainer);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(128, 0, 0), 4));
		panel_6.setBackground(new Color(255, 102, 102));
		panel_6.setBounds(599, 69, 384, 99);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("TOTAL INCOME(RM)");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_1_1.setBounds(10, 13, 119, 13);
		panel_6.add(lblNewLabel_4_1_1_1);
		
		INCOME = new JTextField();
		INCOME.setColumns(10);
		INCOME.setBounds(145, 10, 96, 19);
		panel_6.add(INCOME);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("TOTAL EXPENSES(RM)");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_1_1_1.setBounds(10, 41, 119, 13);
		panel_6.add(lblNewLabel_4_1_1_1_1);
		
		EXPENSES = new JTextField();
		EXPENSES.setColumns(10);
		EXPENSES.setBounds(145, 38, 96, 19);
		panel_6.add(EXPENSES);
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("NET PROFIT(RM)");
		lblNewLabel_4_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_1_1_2.setBounds(10, 70, 119, 13);
		panel_6.add(lblNewLabel_4_1_1_1_2);
		
		PROFIT = new JTextField();
		PROFIT.setColumns(10);
		PROFIT.setBounds(145, 67, 96, 19);
		panel_6.add(PROFIT);
		
		JButton btncalcIncome = new JButton("CALCULATE");
		btncalcIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int durFit = 3;
				final double feeFit = 450;
				int noPartFit;
				final int durSur = 3;
				final double feeSur = 300;
				int noParSur;
				final int durLea = 3 ;
				final double feeLea = 350;
				int noParLea;
				double income;
				try {
					noPartFit = Integer.parseInt(FITNESS.getText());
					noParSur = Integer.parseInt(SURVIVALIST.getText());
					noParLea = Integer.parseInt(LEADERSHIP.getText());
					
					income = (durFit * feeFit* noPartFit) + (durSur * feeSur * noParSur) + (durLea * feeLea * noParLea);
					INCOME.setText(Double.toString(income));
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter valid number !");
				}
			}
		});
			
		btncalcIncome.setFont(new Font("Tahoma", Font.BOLD, 10));
		btncalcIncome.setBounds(263, 9, 111, 21);
		panel_6.add(btncalcIncome);
		
		JButton btncalcExpenses = new JButton("CALCULATE");
		btncalcExpenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int durFit = 3;
			    double allownFit;
				int noTraiFit;
				double bonusFit;
				
				final int durSur = 3;
				double allownSur;
				int noTraiSur;
				double bonusSur;
				
				final int durLea = 3 ;
				double allownLea;
				int noTraiLea;
				double bonusLea;
				
				double expenses;
				try {
					allownFit = Double.parseDouble(fitnessAllowance.getText());
					noTraiFit = Integer.parseInt(fitnessTrainer.getText());
					bonusFit = Double.parseDouble(fitnessBonus.getText());
					
					allownSur = Double.parseDouble(survivalistAllowance.getText());
					noTraiSur = Integer.parseInt(survivalistTrainer.getText());
					bonusSur = Double.parseDouble(survivalistBonus.getText());
					
					allownLea = Double.parseDouble(LeadershipAllowance.getText());
					noTraiLea = Integer.parseInt(leadershipTrainer.getText());
					bonusLea = Double.parseDouble(leadershipBonus.getText());
					
					expenses = (((allownFit * durFit)+ bonusFit)*noTraiFit) + (((allownSur * durSur)+ bonusSur)*noTraiSur) + (((allownLea * durLea)+ bonusLea )*noTraiLea);
					EXPENSES.setText(Double.toString(expenses));
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter valid number !");
				}
			}
		});
		btncalcExpenses.setFont(new Font("Tahoma", Font.BOLD, 10));
		btncalcExpenses.setBounds(263, 37, 111, 21);
		panel_6.add(btncalcExpenses);
		
		JButton btncalcProfit = new JButton("CALCULATE");
		btncalcProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double expenses;
				double income;
				double profit;
				
				try {
					expenses = Double.parseDouble(EXPENSES.getText());
					income = Double.parseDouble(INCOME.getText());
					
					profit = income - expenses;
					PROFIT.setText(Double.toString(profit));
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter valid number !");
				}
				
			}
		});
		btncalcProfit.setFont(new Font("Tahoma", Font.BOLD, 10));
		btncalcProfit.setBounds(263, 66, 111, 21);
		panel_6.add(btncalcProfit);
		
		JLabel lblNewLabel_2 = new JLabel("INCOME");
		lblNewLabel_2.setForeground(new Color(250, 235, 215));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(324, 10, 119, 23);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("EXPENSES");
		lblNewLabel_2_1.setForeground(new Color(250, 235, 215));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 10, 119, 23);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("PROFIT");
		lblNewLabel_2_1_1.setForeground(new Color(250, 235, 215));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(617, 10, 119, 23);
		panel_2.add(lblNewLabel_2_1_1);
		
		JButton btnResetFinance = new JButton("RESET");
		btnResetFinance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 FITNESS.setText(" ");
			 SURVIVALIST.setText(" ");
			 LEADERSHIP.setText(" ");
		     INCOME.setText(" ");
			 fitnessTrainer.setText(" ");
			 fitnessAllowance.setText(" ");
		     fitnessBonus.setText(" ");
		     survivalistBonus.setText(" ");
		     survivalistAllowance.setText(" ");
			 survivalistTrainer.setText(" ");
			 leadershipBonus.setText(" ");
			 LeadershipAllowance.setText(" ");
			 leadershipTrainer.setText(" ");
			 EXPENSES.setText(" ");
			 PROFIT.setText(" ");
				
			}
		});
		btnResetFinance.setBackground(UIManager.getColor("activeCaption"));
		btnResetFinance.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnResetFinance.setBounds(872, 196, 111, 21);
		panel_2.add(btnResetFinance);
		
		JButton btnLogout = new JButton("LOG OUT");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogout.setBackground(UIManager.getColor("activeCaption"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnLogout, "Are you sure want to log out?", "Confirmation", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					//Home page //calling another frame/window
					Home frame = new Home();
					frame.setModalExclusionType(null);
		            frame.setVisible(true);
		            dispose(); //AdminHome frame will disappear
				}
				
			}
		});
		btnLogout.setBounds(833, 0, 85, 21);
		contentPane.add(btnLogout);
	}
}
