package com.service;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.db.DB;
import com.model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public boolean addStudent(Student s) {
		
		
		String sql ="INSERT INTO SwingDb.student (fname,lname ,gender,email,phone,dob,college,faculty,rollno,age,country,city,state) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setString(1, s.getFname());
			pstm.setString(2, s.getLname());
			pstm.setString(3, s.getGender());
			pstm.setString(4, s.getEmail());
			pstm.setString(5, s.getPhone());
			pstm.setString(6, s.getDob());
			pstm.setString(7, s.getCollege());
			pstm.setString(8, s.getFaculty());
			pstm.setInt(9, s.getRollno());
			pstm.setInt(10, s.getAge());
			pstm.setString(11, s.getCountry());
			pstm.setString(12, s.getCity());
			pstm.setString(13, s.getState());
			
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		
		String sql = "Delete from SwingDb.student where id = '"+ id +"'";
		try {
			Statement st = DB.getConnection().createStatement();
			st.execute(sql);
			return true;
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		
String sql ="Update SwingDb.student set fname =?,lname =? ,gender =?,email =?,phone =? ,dob =? ,college =?,faculty =?,rollno =?,age =?,country =?,city =?,state =? where id=?";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setString(1, s.getFname());
			pstm.setString(2, s.getLname());
			pstm.setString(3, s.getGender());
			pstm.setString(4, s.getEmail());
			pstm.setString(5, s.getPhone());
			pstm.setString(6, s.getDob());
			pstm.setString(7, s.getCollege());
			pstm.setString(8, s.getFaculty());
			pstm.setInt(9, s.getRollno());
			pstm.setInt(10, s.getAge());
			pstm.setString(11, s.getCountry());
			pstm.setString(12, s.getCity());
			pstm.setString(13, s.getState());
			pstm.setInt(14, s.getId());
			
			
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public Student getStudentId(int id) {
		 
String sql ="Select * from SwingDb.student where id = '"+id+"'";
		Student s = new Student();
try {
	Statement stm = DB.getConnection().prepareStatement(sql);
	ResultSet rs = stm.executeQuery(sql);
	if(rs.next()) {
	s.setId(rs.getInt("id"));
	s.setFname(rs.getString("fname"));
	s.setLname(rs.getString("lname"));
	s.setCollege(rs.getString("college"));
	s.setAge(rs.getInt("age"));
	s.setPhone(rs.getString("phone"));
	s.setCountry(rs.getString("country"));
	s.setCity(rs.getString("city"));
	s.setState(rs.getString("state"));
	s.setGender(rs.getString("gender"));
	s.setFaculty(rs.getString("faculty"));
	s.setRollno(rs.getInt("rollno"));
	s.setDob(rs.getString("dob"));
	s.setEmail(rs.getString("email"));
	
	return s;
	}else {
		JOptionPane.showMessageDialog(null, "No Data Found");
	}
	
	
} catch (SQLException e) {
	e.printStackTrace();
}
		
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		
		List<Student> stu = new ArrayList<>();
		
		String sql = "Select * from SwingDb.student";
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs =st.executeQuery(sql);
			
			while (rs.next()) {
				Student s  = new Student ();
				
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setCollege(rs.getString("college"));
				s.setAge(rs.getInt("age"));
				s.setPhone(rs.getString("phone"));
				
				stu.add(s);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return stu;
	}

	@Override
	public List<Student> searchStudent(String data) {
		
List<Student> stu = new ArrayList<>();
		
		String sql = "Select * from SwingDb.student where id = '%"+data+"%'  OR fname like '%" + data+"%' OR lname like '%" + data+"%' OR college like '%" + data+"%' OR age = '%"+ data+"%' OR phone like '%" + data+"%'  ";
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs =st.executeQuery(sql);
			
			while (rs.next()) {
				Student s  = new Student ();
				
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setCollege(rs.getString("college"));
				s.setAge(rs.getInt("age"));
				s.setPhone(rs.getString("phone"));
				
				stu.add(s);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return stu;
		
	}

}
