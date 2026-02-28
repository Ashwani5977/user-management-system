package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dto.UserDTO;
import com.util.ConnectionFactory;

public class UserDao {
	public boolean insert(UserDTO user) {
		String sql="insert into users(name,email,age) values(?,?,?)";
		Connection connection =null;
		PreparedStatement ps=null;
		try {
			connection=ConnectionFactory.getConnection();
			 ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getAge());
			int count = ps.executeUpdate();
			if(count>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(connection);
			ConnectionFactory.close(ps);
		}
		return false;
	}
	public UserDTO getById(int id) {
		String sql="select id,name,email,age from users where id=?";
		UserDTO user=null;
		try(
			Connection connection=ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
		) {
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user=new UserDTO();
				user.setId(rs.getInt("id"));
				user.setAge(rs.getInt("age"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean update(UserDTO user,int id) {
		String sql="update users set name=?,email=?,age=? where id=?";
		try (
			Connection connection=ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
		)
		{
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getAge());
			ps.setInt(4, id);
			int count=ps.executeUpdate();
			return count>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteById(int id) {
		String sql="delete from users where id=?";
		try (
			Connection connection=ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
		) {
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
