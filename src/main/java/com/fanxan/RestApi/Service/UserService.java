package com.fanxan.RestApi.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.fanxan.RestApi.Model.AppUser;

public class UserService {

	private Connection con = null;
	public UserService() throws SQLException {
		String dbName = "bootcamp";
		String username = "postgres";
		String password = "fannan098123";
		String host = "Localhost";
		int port = 5432;
		
		StringBuffer sb = new StringBuffer("jdbc:postgresql://")
				.append(host).append(":")
				.append(port).append("/").append(dbName);
		con = DriverManager.getConnection(sb.toString(),username, password);
	}

	public int insertNewUser(AppUser appUser) throws SQLException {

		Statement stat = con.createStatement();
		StringBuilder sb = new StringBuilder("insert into app_user(email,password)values (")
				.append("'").append(appUser.getEmail()).append("',")
				.append("'").append(appUser.getPassword()).append("')");
		return stat.executeUpdate(sb.toString());
		
	}
	
}
