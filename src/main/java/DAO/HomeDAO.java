package DAO;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import Bean.Province;
import Bean.Student;
import DB.DBConnection;

public class HomeDAO {
	public static List<Province> Displayprovince(){
		List<Province> list = new ArrayList<Province>();
		try {
			Connection con = DBConnection.createConection();
			String sql = "Select * from province";
			PreparedStatement ptmt = con.prepareStatement(sql);
			ResultSet rs= ptmt.executeQuery();
			while(rs.next()) {
				int idprovince = rs.getInt(1);
				String name = rs.getString(2);
				Province province = new Province(idprovince, name);
				list.add(province);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public static boolean insertStudent(Student sv) {
		int n=0;
		try {
			Connection con = DBConnection.createConection();
			String sql = "Insert into student(Name, idProvince) values(?,?)";
			PreparedStatement ptmt = con.prepareStatement(sql);
			List<Student> liststudent = new ArrayList<Student>();
			int idstudent = sv.getIdstudent();
			String name = sv.getName();
			int province = sv.getProvince().getIdProvince();
			ptmt.setString(1, name);
			ptmt.setInt(2,province);
			n=ptmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
}
