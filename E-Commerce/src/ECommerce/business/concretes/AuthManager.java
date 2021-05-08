package ECommerce.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ECommerce.business.abstracts.AuthService;
import ECommerce.core.abstracts.GeneralLoggingService;
import ECommerce.core.abstracts.UserVerifyService;
import ECommerce.dataAccess.abstracts.UserDao;
import ECommerce.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserDao userDao;
	private UserVerifyService userVerifyService;
	private GeneralLoggingService generalLoggingService;
	
	public AuthManager(UserDao userDao,UserVerifyService userVerifyService,GeneralLoggingService generalLoggingService) {
		super();
		this.userDao = userDao;
		this.userVerifyService = userVerifyService;
		this.generalLoggingService=generalLoggingService;
	}


	@Override
	public boolean checkIfEmailRegex(String eMail) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		
		return pattern.matcher(eMail).find();
		
	}

	@Override
	public List<User> getAll() {
		
		return this.userDao.getAll();
	}

	@Override
	public String getEmail(String mail) {
		
		return this.userDao.getAllEmail(mail);
	}

	@Override
	public void checkLogin(User user) {
		
		List<User> userList = userDao.getAll();
		
		for (User user1 : userList) {
			
		
			
			if (user1.geteMail().equals(user.geteMail()) && user1.getPassword().equals(user.getPassword())) {
				
				System.out.println("Giriþ baþarýlý");
				break;
			}else {
				System.out.println("Paralo veya mail adresiniz hatalý.");
				
			}
			
		}
		
	}

	@Override
	public void checkRegister(User user) {

		if (user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Ad ve Soyad en az iki karekter olmalýdýr. ");
			return;
		}

		if (getEmail(user.geteMail()) != null) {
			System.out.println("Email kullanýmda.");
			return;
		}else if(!checkIfEmailRegex(user.geteMail())){
			System.out.println("Email formatýna uygun deðil!!!");
			return;
		}

		if (user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karekter olmalýdýr.");
			return;
		}
		
		this.userDao.add(user);
		this.userVerifyService.sendVerifyEmail();
		this.userVerifyService.button();
	}


}
