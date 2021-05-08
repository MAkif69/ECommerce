package ECommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ECommerce.dataAccess.abstracts.UserDao;
import ECommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao{

    
	List<User>  addedUserList = new ArrayList<User>();
	
			
	@Override
	public void add(User user) {
		System.out.println("Hibernate veritabanýna eklendi : " +user.getPassword()+ " " 
	                       +user.getFirstName()+ " " +user.getLastName());
			
		addedUserList.add(user);
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate veritabanýndan silindi : " +user.getFirstName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate veritabanýnda güncellendi : " +user.getFirstName());
		
	}

	@Override
	public User get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return addedUserList ;
	}



	@Override
	public String getAllEmail(String mail) {
		
		String mailControl = null;
		
		for (User user : addedUserList) {
			if (user.geteMail().equals(mail)) {
				mailControl = mail;
				break;
			}
		}
		
		return mailControl;
	}

}
