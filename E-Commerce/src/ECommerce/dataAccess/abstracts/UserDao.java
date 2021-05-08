package ECommerce.dataAccess.abstracts;

import java.util.List;

import ECommerce.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	
	
	User get(int Id);
	
	List<User> getAll();
	String getAllEmail(String mail);
}
