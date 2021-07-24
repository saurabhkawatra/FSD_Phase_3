package sportyshoes.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sportyshoes.DAO.UserDAO;
import sportyshoes.MODELS.User;

@Service
public class UserSERVICE {
		
		@Autowired
		private UserDAO userDAO;
		
	
		public User getUser(int user_id) {
					
				return userDAO.getUser(user_id);
		}

		public String addUser(User user) {
			
			return userDAO.addUser(user);
			
		}

		public String removeUser(User user) {
			
			return userDAO.removeUser(user);
		}

		public String updateUser(int oldUserid, User newUser) {
			
			return userDAO.updateUser(oldUserid, newUser);
		}
		
		public User login(String username,String password) {
			
			return userDAO.login(username, password);
		}
		
		public List<User> getallUserslist() {
			
			return userDAO.getallUserslist();
		}
		
		

}
