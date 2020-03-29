package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface{
	final String signUpUser = "insert into user2 values (?,?)";
	final String loginUser = "select * from user2 where email = ? and password = ?";
	@Override
	public int signUp(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		PreparedStatement ps = conn.prepareStatement(signUpUser);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		int execution = ps.executeUpdate(); //executeUpdate returns interger values like 1
		return execution;
	}

	@Override
	public boolean loginUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		PreparedStatement ps = conn.prepareStatement(loginUser);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		
		
		return rs.next(); // rs.next() returns boolean value
	}
	
}