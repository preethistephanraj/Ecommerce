package com.niit.dao;

import java.util.List;
import com.niit.model.User;

public interface UserDao {
	public boolean addUser(User User);
	public boolean deleteUser(User User);
	public boolean updateUser(User User);
	public User viewUserByEmail(String emailId);
	public User viewUserByUsername(String username);
	public List<User> listUser();
}