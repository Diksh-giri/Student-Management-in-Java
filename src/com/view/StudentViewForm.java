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

public class StudentViewForm extends JFrame {

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
	private int sid = 0;
	private JButton back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentViewForm frame = new StudentViewForm();
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
	public StudentViewForm() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 473);
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
		contentPane.add(getBack());
		
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
			fnametxt.setEnabled(false);
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
			lnametxt.setEnabled(false);
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
			malebtn.setEnabled(false);
			buttonGroup_1.add(malebtn);
			malebtn.setFont(new Font("Dialog", Font.BOLD, 12));
			malebtn.setBounds(67, 99, 66, 23);
		}
		return malebtn;
	}
	private JRadioButton getRdbtnNewRadioButton_1_1() {
		if (femalebtn == null) {
			femalebtn = new JRadioButton("Female");
			femalebtn.setEnabled(false);
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
			dobtxt.setEnabled(false);
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
			collegetxt.setEnabled(false);
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
			statecmb.setEnabled(false);
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
			citytxt.setEnabled(false);
			citytxt.setColumns(10);
			citytxt.setBounds(81, 265, 117, 29);
		}
		return citytxt;
	}
	private JTextField getCountrytxt() {
		if (countrytxt == null) {
			countrytxt = new JTextField();
			countrytxt.setEnabled(false);
			countrytxt.setColumns(10);
			countrytxt.setBounds(81, 305, 117, 29);
		}
		return countrytxt;
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
			rollnotxt.setEnabled(false);
			rollnotxt.setColumns(10);
			rollnotxt.setBounds(279, 19, 117, 29);
		}
		return rollnotxt;
	}
	private JTextField getEmailtxt() {
		if (emailtxt == null) {
			emailtxt = new JTextField();
			emailtxt.setEnabled(false);
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
			facultytxt.setEnabled(false);
			facultytxt.setColumns(10);
			facultytxt.setBounds(279, 101, 117, 29);
		}
		return facultytxt;
	}
	private JTextField getAgetxt() {
		if (agetxt == null) {
			agetxt = new JTextField();
			agetxt.setEnabled(false);
			agetxt.setColumns(10);
			agetxt.setBounds(279, 144, 117, 29);
		}
		return agetxt;
	}
	private JTextField getPhonetxt() {
		if (phonetxt == null) {
			phonetxt = new JTextField();
			phonetxt.setEnabled(false);
			phonetxt.setColumns(10);
			phonetxt.setBounds(279, 189, 117, 29);
		}
		return phonetxt;
	}
	private JButton getBack() {
		if (back == null) {
			back = new JButton("Back");
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new SignupForm().setVisible(true);
					dispose();
				}
			});
			back.setBounds(279, 340, 149, 58);
		}
		return back;
		
		
	}
	
	public void setDataViewForm(int id) {
		
		StudentService ss = new StudentServiceImpl();
		Student std = ss.getStudentId(id);
		
		fnametxt.setText(std.getFname());
		lnametxt.setText(std.getLname());
		statecmb.setSelectedItem(std.getState());
		if(std.getGender().equals("Male")) {
			malebtn.setSelected(true);
		}else {
			femalebtn.setSelected(false);

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
		
	}
}
