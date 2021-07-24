package sportyshoes.DAO;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sportyshoes.CRUD.UserCRUD;
import sportyshoes.MODELS.User;

@Repository
public class UserDAO implements UserCRUD {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	
	public User getUser(int user_id) {
		
		hibernateTemplate.clear();
		User u=hibernateTemplate.get(User.class, user_id);
		return u;
	}
	
	@Transactional
	public String addUser(User user) {
		
		hibernateTemplate.clear();
		Integer id=(Integer)hibernateTemplate.save("User", user);
		String msg="";
		
		if(id==null)
		{
			msg="transaction-failed";
			return msg;
		}
		else
		{
			msg="User Added with user_id= "+id+" "+user;
			return msg;
		}
		
	}
	
	@Transactional
	public String removeUser(User user) {
		
			hibernateTemplate.clear();
		try {
			hibernateTemplate.delete("User", user);
			return "Delete Operation Successful, details "+user+" Removed";
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "transaction-failed";
		}
	}
	
	@Transactional
	public String updateUser(int oldUserid, User newUser) {
		
		hibernateTemplate.clear();
		User oldu = hibernateTemplate.get(User.class, oldUserid);
		hibernateTemplate.clear();
		try {
			hibernateTemplate.update("User", newUser);
			return "Update Successful Old : "+oldu+" to New :"+newUser;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "transaction-failed";
		}
	}
	
	public User login(String username,String password) {
		
		hibernateTemplate.clear();
		Session s=hibernateTemplate.getSessionFactory().openSession();
		try {
			User u=s.createNativeQuery("select * from user where username='"+username+"'",User.class).getSingleResult();
			s.close();
			if(u.getPassword().equals(password))
				return u;
			else
				return null;
		}catch(Exception e)
		{
			s.close();
			return null;
		}
	}
	
	public List<User> getallUserslist() {
		
		hibernateTemplate.clear();
		return hibernateTemplate.loadAll(User.class);
	}
	

}
