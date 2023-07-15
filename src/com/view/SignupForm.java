package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.db.DB;
import com.model.Student;
import com.service.StudentService;
import com.service.StudentServiceImpl;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

public class SignupForm extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel;
	private JTextField fnametxt;
	private JLabel lblLastname;
	private JTextField lnametxt;
	private JLabel lblGender;
	private JRadioButton malebtn;
	private JRadioButton femalebtn;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblDob;
	private JTextField dobtxt;
	private JLabel lblCollege;
	private JTextField collegetxt;
	private JLabel lblState;
	private JComboBox statecmb;
	private JLabel lblCity;
	private JLabel lblCountry;
	private JTextField citytxt;
	private JTextField countrytxt;
	private JButton add;
	private JLabel lblRollno;
	private JTextField rollnotxt;
	private JTextField emailtxt;
	private JLabel lblEmail;
	private JLabel lblFaculty;
	private JLabel lblAge;
	private JLabel lblPhone;
	private JTextField facultytxt;
	private JTextField agetxt;
	private JTextField phonetxt;
	private JSeparator separator;
	private JButton update;
	private JLabel lblSearch;
	private JTextField searchtxt;
	private JButton delete;
	private JButton edit;
	private JButton view;
	private JButton print;
	private JButton exit;
	private JScrollPane scrollPane;
	private JTable table;
	private int sid = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupForm frame = new SignupForm();
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
	public SignupForm() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField_4());
		contentPane.add(getLblLastname());
		contentPane.add(getTextField_1_1());
		contentPane.add(getLblGender());
		contentPane.add(getMalebtn());
		contentPane.add(getRdbtnNewRadioButton_1_1());
		contentPane.add(getLblDob());
		contentPane.add(getTextField_2_1());
		contentPane.add(getLblCollege());
		contentPane.add(getTextField_3_1());
		contentPane.add(getLblState());
		contentPane.add(getComboBox_1());
		contentPane.add(getLblCity());
		contentPane.add(getLblCountry());
		contentPane.add(getTextField_4_1());
		contentPane.add(getCountrytxt());
		contentPane.add(getAdd());
		contentPane.add(getLblRollno());
		contentPane.add(getRollnotxt());
		contentPane.add(getEmailtxt());
		contentPane.add(getLblEmail());
		contentPane.add(getLblFaculty());
		contentPane.add(getLblAge());
		contentPane.add(getLblPhone());
		contentPane.add(getFacultytxt());
		contentPane.add(getAgetxt());
		contentPane.add(getPhonetxt());
		contentPane.add(getSeparator());
		contentPane.add(getUpdate());
		contentPane.add(getLblSearch());
		contentPane.add(getSearchtxt());
		contentPane.add(getDelete());
		contentPane.add(getEdit());
		contentPane.add(getView());
		contentPane.add(getPrint());
		contentPane.add(getExit());
		contentPane.add(getScrollPane());
		displayData();
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("FirstName");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 23, 78, 19);
		}
		return lblNewLabel;
	}
	private JTextField getTextField_4() {
		if (fnametxt == null) {
			fnametxt = new JTextField();
			fnametxt.setBounds(81, 19, 117, 29);
			fnametxt.setColumns(10);
		}
		return fnametxt;
	}
	private JLabel getLblLastname() {
		if (lblLastname == null) {
			lblLastname = new JLabel("LastName");
			lblLastname.setFont(new Font("Dialog", Font.BOLD, 12));
			lblLastname.setBounds(10, 59, 78, 19);
		}
		return lblLastname;
	}
	private JTextField getTextField_1_1() {
		if (lnametxt == null) {
			lnametxt = new JTextField();
			lnametxt.setColumns(10);
			lnametxt.setBounds(81, 53, 117, 29);
		}
		return lnametxt;
	}
	private JLabel getLblGender() {
		if (lblGender == null) {
			lblGender = new JLabel("Gender");
			lblGender.setFont(new Font("Dialog", Font.BOLD, 12));
			lblGender.setBounds(10, 101, 51, 19);
		}
		return lblGender;
	}
	private JRadioButton getMalebtn() {
		if (malebtn == null) {
			malebtn = new JRadioButton("Male");
			buttonGroup_1.add(malebtn);
			malebtn.setFont(new Font("Dialog", Font.BOLD, 12));
			malebtn.setBounds(67, 99, 66, 23);
		}
		return malebtn;
	}
	private JRadioButton getRdbtnNewRadioButton_1_1() {
		if (femalebtn == null) {
			femalebtn = new JRadioButton("Female");
			buttonGroup_1.add(femalebtn);
			femalebtn.setFont(new Font("Dialog", Font.BOLD, 12));
			femalebtn.setBounds(135, 99, 66, 23);
		}
		return femalebtn;
	}
	private JLabel getLblDob() {
		if (lblDob == null) {
			lblDob = new JLabel("DOB");
			lblDob.setFont(new Font("Dialog", Font.BOLD, 12));
			lblDob.setBounds(10, 144, 51, 19);
		}
		return lblDob;
	}
	private JTextField getTextField_2_1() {
		if (dobtxt == null) {
			dobtxt = new JTextField();
			dobtxt.setColumns(10);
			dobtxt.setBounds(81, 140, 117, 29);
		}
		return dobtxt;
	}
	private JLabel getLblCollege() {
		if (lblCollege == null) {
			lblCollege = new JLabel("College");
			lblCollege.setFont(new Font("Dialog", Font.BOLD, 12));
			lblCollege.setBounds(10, 189, 51, 19);
		}
		return lblCollege;
	}
	private JTextField getTextField_3_1() {
		if (collegetxt == null) {
			collegetxt = new JTextField();
			collegetxt.setColumns(10);
			collegetxt.setBounds(81, 185, 117, 29);
		}
		return collegetxt;
	}
	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel("State");
			lblState.setFont(new Font("Dialog", Font.BOLD, 12));
			lblState.setBounds(10, 229, 51, 19);
		}
		return lblState;
	}
	private JComboBox getComboBox_1() {
		if (statecmb == null) {
			statecmb = new JComboBox();
			statecmb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Province No 1:Koshi Pradesh", "Province No 2: Madhesh Pradesh. ", "Province No 3: Bagmati Pradesh. ", "Province No 4: Gandaki Pradesh. ", "Province No 5: Lumbini Pradesh. ", "Province No 6: Karnali Pradesh. ", "Province No 7: Sudur Pashchim Pradesh."}));
			statecmb.setBounds(81, 225, 117, 29);
		}
		return statecmb;
	}
	private JLabel getLblCity() {
		if (lblCity == null) {
			lblCity = new JLabel("City");
			lblCity.setFont(new Font("Dialog", Font.BOLD, 12));
			lblCity.setBounds(10, 269, 51, 19);
		}
		return lblCity;
	}
	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel("Country");
			lblCountry.setFont(new Font("Dialog", Font.BOLD, 12));
			lblCountry.setBounds(10, 309, 51, 19);
		}
		return lblCountry;
	}
	private JTextField getTextField_4_1() {
		if (citytxt == null) {
			citytxt = new JTextField();
			citytxt.setColumns(10);
			citytxt.setBounds(81, 265, 117, 29);
		}
		return citytxt;
	}
	private JTextField getCountrytxt() {
		if (countrytxt == null) {
			countrytxt = new JTextField();
			countrytxt.setColumns(10);
			countrytxt.setBounds(81, 305, 117, 29);
		}
		return countrytxt;
	}
	private JButton getAdd() {
		if (add == null) {
			add = new JButton("ADD");
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Student s = new Student();
					s.setFname(fnametxt.getText());
					s.setLname(lnametxt.getText());
					s.setAge(Integer.parseInt(agetxt.getText()));
					s.setCity(citytxt.getText());
					s.setCollege(collegetxt.getText());
					s.setCountry(countrytxt.getText());
					s.setDob(dobtxt.getText());
					s.setEmail(emailtxt.getText());
					s.setFaculty(facultytxt.getText());
					
					
					if(malebtn.isSelected()) {
						s.setGender("Male"); 
					}else {
						s.setGender("Female");;
					}
					s.setPhone(phonetxt.getText());
					s.setRollno(Integer.parseInt(rollnotxt.getText()));
					s.setState(statecmb.getSelectedItem().toString());
					
				StudentService ss = new StudentServiceImpl();
				boolean res = ss.addStudent(s);
				
				if(res) {
					JOptionPane.showMessageDialog(null, "Added Success");
					displayData();
				}else {
					JOptionPane.showMessageDialog(null, "Addes Failure");
				}
					
					
				fnametxt.setText("");
				lnametxt.setText("");
				statecmb.setSelectedIndex(0);
				buttonGroup.clearSelection();
				agetxt.setText("");
				citytxt.setText("");
				collegetxt.setText("");
				dobtxt.setText("");
				emailtxt.setText("");
				facultytxt.setText("");
				countrytxt.setText("");
				rollnotxt.setText("");
				phonetxt.setText("");
				
				
					add.setEnabled(true);
					update.setEnabled(false);
					
				}
			});
			add.setFont(new Font("Dialog", Font.BOLD, 15));
			add.setBounds(10, 373, 117, 50);
		}
		return add;
		
		
	}
	
	private void displayData() {
		
		StudentService ss = new StudentServiceImpl();
		List<Student> slist = ss.getAllStudents(); 
		
		DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Student s : slist) {

			tmodel.addRow(new Object[] {s.getId(),s.getFname(),s.getLname(),s.getCollege(),s.getAge(),s.getPhone()});
		}
	}
	
	private JLabel getLblRollno() {
		if (lblRollno == null) {
			lblRollno = new JLabel("RollNo");
			lblRollno.setFont(new Font("Dialog", Font.BOLD, 12));
			lblRollno.setBounds(225, 23, 78, 19);
		}
		return lblRollno;
	}
	private JTextField getRollnotxt() {
		if (rollnotxt == null) {
			rollnotxt = new JTextField();
			rollnotxt.setColumns(10);
			rollnotxt.setBounds(279, 19, 117, 29);
		}
		return rollnotxt;
	}
	private JTextField getEmailtxt() {
		if (emailtxt == null) {
			emailtxt = new JTextField();
			emailtxt.setColumns(10);
			emailtxt.setBounds(279, 59, 117, 29);
		}
		return emailtxt;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Dialog", Font.BOLD, 12));
			lblEmail.setBounds(225, 59, 78, 19);
		}
		return lblEmail;
	}
	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setFont(new Font("Dialog", Font.BOLD, 12));
			lblFaculty.setBounds(225, 101, 78, 19);
		}
		return lblFaculty;
	}
	private JLabel getLblAge() {
		if (lblAge == null) {
			lblAge = new JLabel("Age");
			lblAge.setFont(new Font("Dialog", Font.BOLD, 12));
			lblAge.setBounds(225, 144, 78, 19);
		}
		return lblAge;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Dialog", Font.BOLD, 12));
			lblPhone.setBounds(225, 189, 78, 19);
		}
		return lblPhone;
	}
	private JTextField getFacultytxt() {
		if (facultytxt == null) {
			facultytxt = new JTextField();
			facultytxt.setColumns(10);
			facultytxt.setBounds(279, 101, 117, 29);
		}
		return facultytxt;
	}
	private JTextField getAgetxt() {
		if (agetxt == null) {
			agetxt = new JTextField();
			agetxt.setColumns(10);
			agetxt.setBounds(279, 144, 117, 29);
		}
		return agetxt;
	}
	private JTextField getPhonetxt() {
		if (phonetxt == null) {
			phonetxt = new JTextField();
			phonetxt.setColumns(10);
			phonetxt.setBounds(279, 189, 117, 29);
		}
		return phonetxt;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBackground(new Color(192, 192, 192));
			separator.setBounds(406, 0, 16, 434);
		}
		return separator;
	}
	private JButton getUpdate() {
		if (update == null) {
			update = new JButton("UPDATE");
			update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
					Student s = new Student();
					
					s.setId(sid);
					s.setFname(fnametxt.getText());
					s.setLname(lnametxt.getText());
					s.setAge(Integer.parseInt(agetxt.getText()));
					s.setCity(citytxt.getText());
					s.setCollege(collegetxt.getText());
					s.setCountry(countrytxt.getText());
					s.setDob(dobtxt.getText());
					s.setEmail(emailtxt.getText());
					s.setFaculty(facultytxt.getText());
					
					
					if(malebtn.isSelected()) {
						s.setGender("Male"); 
					}else {
						s.setGender("Female");;
					}
					s.setPhone(phonetxt.getText());
					s.setRollno(Integer.parseInt(rollnotxt.getText()));
					s.setState(statecmb.getSelectedItem().toString());
					
					
				StudentService ss = new StudentServiceImpl();
				boolean res = ss.updateStudent(s);
				
				if(res) {
					JOptionPane.showMessageDialog(null, "Update Success");
					displayData();
				}else {
					JOptionPane.showMessageDialog(null, "Update Failure");
				}
					
					
				fnametxt.setText("");
				lnametxt.setText("");
				statecmb.setSelectedIndex(0);
				buttonGroup.clearSelection();
				agetxt.setText("");
				citytxt.setText("");
				collegetxt.setText("");
				dobtxt.setText("");
				emailtxt.setText("");
				facultytxt.setText("");
				countrytxt.setText("");
				rollnotxt.setText("");
				phonetxt.setText("");
				
				add.setEnabled(true);
				update.setEnabled(false);
					
				}
			});
			update.setEnabled(false);
			update.setFont(new Font("Dialog", Font.BOLD, 15));
			update.setBounds(260, 373, 117, 50);
		}
		return update;
	}
	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("Search");
			lblSearch.setFont(new Font("Dialog", Font.BOLD, 12));
			lblSearch.setBounds(658, 29, 78, 19);
		}
		return lblSearch;
	}
	private JTextField getSearchtxt() {
		if (searchtxt == null) {
			searchtxt = new JTextField();
			searchtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					String sdata = searchtxt.getText().trim();
					StudentService ss = new StudentServiceImpl();
					List<Student> slist = ss.searchStudent(sdata);
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					tmodel.setRowCount(0);
					
					for(Student s : slist) {

						tmodel.addRow(new Object[] {s.getId(),s.getFname(),s.getLname(),s.getCollege(),s.getAge(),s.getPhone()});
					}
					
				}
			});
			searchtxt.setColumns(10);
			searchtxt.setBounds(721, 23, 117, 29);
		}
		return searchtxt;
	}
	private JButton getDelete() {
		if (delete == null) {
			delete = new JButton("Delete");
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any Row");
						return;
					}
					int srow = table.getSelectedRow();
					int sid = (int) table.getModel().getValueAt(srow, 0);
					
					StudentService ss = new StudentServiceImpl();
					if(ss.deleteStudent(sid)) {
						JOptionPane.showMessageDialog(null, "Deleted Success");
						displayData();
					}else {
						JOptionPane.showMessageDialog(null, "Deleted Failure");
					}
					
				}
			});
			delete.setBounds(408, 394, 89, 29);
		}
		return delete;
	}
	private JButton getEdit() {
		if (edit == null) {
			edit = new JButton("Edit");
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any Row");
						return;
					}
					int srow = table.getSelectedRow();
					sid = (int) table.getModel().getValueAt(srow, 0);
									
					StudentService ss = new StudentServiceImpl();
					Student std =	ss.getStudentId(sid);
					fnametxt.setText(std.getFname());
					lnametxt.setText(std.getLname());
					statecmb.setSelectedItem(std.getState());
					if(std.getGender().equals("Male")) {
						malebtn.setSelected(true);
					}else {
						femalebtn.setSelected(true);
	
					}
					
					agetxt.setText(Integer.toString(std.getAge()));
					citytxt.setText(std.getCity());
					collegetxt.setText(std.getCollege());
					dobtxt.setText(std.getDob());
					emailtxt.setText(std.getEmail());
					facultytxt.setText(std.getFaculty());
					countrytxt.setText(std.getCountry());
					rollnotxt.setText(Integer.toString(std.getRollno()));
					phonetxt.setText(std.getPhone());
					
					add.setEnabled(false);
					update.setEnabled(true);
					

				}
			});
			edit.setBounds(500, 394, 89, 29);
		}
		return edit;
	}
	private JButton getView() {
		if (view == null) {
			view = new JButton("View");
			view.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any Row");
						return;
					}
					int srow = table.getSelectedRow();
					int sid = (int) table.getModel().getValueAt(srow, 0);
					
					
					StudentViewForm view  = new StudentViewForm();
					view.setDataViewForm(sid);
					view.setVisible(true);
					dispose();
					

					//displayData();
				}
			});
			view.setBounds(592, 394, 89, 29);
		}
		return view;
	}
	private JButton getPrint() {
		if (print == null) {
			print = new JButton("Print");
			print.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						table.print();
					} catch (PrinterException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			print.setBounds(684, 394, 89, 29);
		}
		return print;
	}
	private JButton getExit() {
		if (exit == null) {
			exit = new JButton("Exit");
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
				
			});
			exit.setBounds(776, 394, 89, 29);
		}
		return exit;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(422, 67, 448, 282);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "FName", "LName", "College", "Age", "Phone"
				}
			));
			table.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return table;
	}
}
