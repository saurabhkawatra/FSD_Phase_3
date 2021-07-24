package sportyshoes.CRUD;

import java.util.List;

import sportyshoes.MODELS.User;

public interface UserCRUD {
	
	public User getUser(int user_id);
	
	public String addUser(User user);
	
	public String removeUser(User user);
	
	public String updateUser(int oldUserid,User newUser);
	
	public List<User> getallUserslist();

}
