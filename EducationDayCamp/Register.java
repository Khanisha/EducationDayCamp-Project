package EducationDayCamp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class Register extends JFrame {
	private JTextField textFieldfirstN;
	private JTextField textFieldlastN;
	private JTextField textFieldContactno;
	private JComboBox comboBoxEvent;
	private JComboBox comboBoxGender;
    DefaultTableModel model;
	private JTable tableRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		getContentPane().setBackground(new Color(128, 0, 0));
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 128, 128));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 255)));
		panel.setBounds(248, 22, 593, 51);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblParticipantRegistration = new JLabel("PARTICIPANT REGISTRATION");
		lblParticipantRegistration.setBounds(31, 0, 528, 55);
		panel.add(lblParticipantRegistration);
		lblParticipantRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipantRegistration.setForeground(Color.BLACK);
		lblParticipantRegistration.setFont(new Font("Serif", Font.BOLD, 33));
		lblParticipantRegistration.setBackground(Color.WHITE);
			
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 255)));
		panel_1.setBackground(new Color(240, 128, 128));
		panel_1.setBounds(31, 95, 449, 272);
		getContentPane().add(panel_1);
		
		JComboBox comboBoxEvent = new JComboBox();
		comboBoxEvent.setBounds(144, 39, 155, 22);
		panel_1.add(comboBoxEvent);
		comboBoxEvent.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		comboBoxEvent.setModel(new DefaultComboBoxModel(new String[] {"Choose an event", "Fitness Camp", "Survivalist Camp", "Leadership Camp"}));
		comboBoxEvent.setMaximumRowCount(5);
				
		JLabel lblfirstN = new JLabel("First Name");
		lblfirstN.setBounds(31, 71, 155, 21);
		panel_1.add(lblfirstN);
		lblfirstN.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		
		textFieldfirstN = new JTextField();
		textFieldfirstN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldfirstN.setBounds(140, 75, 280, 20);
		panel_1.add(textFieldfirstN);
		textFieldfirstN.setColumns(10);
		
		JLabel lbllastN = new JLabel("Last Name");
		lbllastN.setBounds(31, 120, 76, 14);
		panel_1.add(lbllastN);
		lbllastN.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		
		textFieldlastN = new JTextField();
		textFieldlastN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldlastN.setBounds(140, 118, 280, 20);
		panel_1.add(textFieldlastN);
		textFieldlastN.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(31, 164, 76, 14);
		panel_1.add(lblGender);
		lblGender.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
				
		JLabel lblContactno = new JLabel("Contact No");
		lblContactno.setBounds(31, 204, 76, 14);
		panel_1.add(lblContactno);
		lblContactno.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		
		textFieldContactno = new JTextField();
		textFieldContactno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldContactno.setBounds(140, 205, 280, 20);
		panel_1.add(textFieldContactno);
		textFieldContactno.setColumns(10);
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Select A Gender", "Female", "Male"}));
		comboBoxGender.setBounds(144, 164, 276, 21);
		panel_1.add(comboBoxGender);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 0));
		panel_2.setBorder(new LineBorder(Color.BLUE, 4));
		panel_2.setBounds(549, 95, 460, 279);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 440, 259);
		panel_2.add(scrollPane);
		
		tableRegister = new JTable();
		
		tableRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableRegister.getSelectedRow();
				if (i>=0) {
					textFieldfirstN.setText(model.getValueAt(i,0).toString());
					textFieldlastN.setText(model.getValueAt(i,1).toString());
					comboBoxGender.setSelectedItem(model.getValueAt(i,2).toString());
					textFieldContactno.setText(model.getValueAt(i,3).toString());
					comboBoxEvent.setSelectedItem(model.getValueAt(i,4).toString());
				}
					 else 
					    {
					    	JOptionPane.showMessageDialog(null, "Please Select a Row First!");
					    }
				}
			}
		);
		tableRegister.setFont(new Font("Tahoma", Font.BOLD, 10));
		tableRegister.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Gender", "Contact No", "Event"
			}
		));
		scrollPane.setViewportView(tableRegister);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldfirstN.setText("");
				textFieldlastN.setText("");
				textFieldContactno.setText("");
				comboBoxGender.setSelectedItem("Select A Gender");
				comboBoxEvent.setSelectedItem("Choose an event");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(102, 394, 128, 23);
		getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filePath = "E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\Assignment3\\Participant.txt";
				File file = new File (filePath);
				
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i = 0; i < tableRegister.getRowCount(); i++) {//rows
						for(int j = 0; j < tableRegister.getColumnCount(); j++) {//columns
							bw.write(tableRegister.getValueAt(i, j).toString()+" ");
						}
						bw.newLine();
					}
					bw.close();
					fw.close();
				}catch (Exception ex) {
					Logger.getLogger(Register.class.getName()).log(Level.SEVERE,null,ex);
				}
				
				
				//Home page //calling another frame/window
				Home frame = new Home();
				frame.setModalExclusionType(null);
	            frame.setVisible(true);
	            dispose(); //login frame will disappear
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(779, 394, 128, 23);
		getContentPane().add(btnBack);
		
		JButton butRegister = new JButton("REGISTER");
		butRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(comboBoxEvent.getSelectedItem()=="Choose an event"|| comboBoxGender.getSelectedItem()=="Select A Gender" || textFieldfirstN.getText().equals("") || textFieldlastN.getText().equals("")||textFieldContactno.getText().equals("") ) {
						JOptionPane.showMessageDialog(null,"Please Fill in all the information");
					}else {
				DefaultTableModel model = (DefaultTableModel) tableRegister.getModel();
				model.addRow(new Object[]{
						textFieldfirstN.getText(),
						textFieldlastN.getText(),
						comboBoxGender.getSelectedItem(),
						textFieldContactno.getText(),
						comboBoxEvent.getSelectedItem(),
				});
						
						
						
				
				
				//textFieldfirstN.setText("");
				//textFieldlastN.setText("");
				//comboBoxGender.setSelectedItem("Select A Gender" );
				//textFieldContactno.setText("");
				//comboBoxEvent.setSelectedItem("Choose an event");
				JOptionPane.showMessageDialog(null, "Registered Successfully !");
					}
				
				
          }catch(Exception e1){
					
				}
				}}
		
		);
		butRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		butRegister.setBounds(238, 394, 128, 23);
		getContentPane().add(butRegister);
		
		JButton butEdit = new JButton("EDIT");
		butEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)tableRegister.getModel();
				int i = tableRegister.getSelectedRow();
			    if(i>=0) //if single row is selected than update
			    {
			    	model.setValueAt(textFieldfirstN.getText(),i,0);
			    	model.setValueAt(textFieldlastN.getText(),i,1);
			    	model.setValueAt(comboBoxGender.getSelectedItem(),i,2);
			    	model.setValueAt(textFieldContactno.getText(),i,3);
			    	model.setValueAt(comboBoxEvent.getSelectedItem(),i,4);
			 
					JOptionPane.showMessageDialog(null, "Update Successfully");
			    }
			    else 
			    {
			    	JOptionPane.showMessageDialog(null, "Please Select a Row First!");
			    }
			}
		});
		butEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		butEdit.setBounds(641, 394, 128, 23);
		getContentPane().add(butEdit);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\EducationDayCamp\\lblBackground(Home).jpg"));
		lblBackground.setBounds(0, 0, 1019, 526);
		getContentPane().add(lblBackground);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\DEGREE\\SEM 3\\Programming 2\\Assignment\\src\\Assignment3\\uum logo.png"));
		setTitle("EDC UUM");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 531);
		
		
	}
}