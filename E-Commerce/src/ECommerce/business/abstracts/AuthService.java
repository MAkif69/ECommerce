package ECommerce.business.abstracts;

import java.util.List;

import ECommerce.entities.concretes.User;

public interface AuthService {
	boolean checkIfEmailRegex(String eMail);
	void checkLogin(User user);
	void checkRegister(User user);
	
	List<User>  getAll();
	String getEmail(String mail);
	
}
