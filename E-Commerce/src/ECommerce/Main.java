package ECommerce;

import java.util.Scanner;

import ECommerce.business.abstracts.AuthService;
import ECommerce.business.concretes.AuthManager;
import ECommerce.core.concretes.GoogleManagerAdaptor;
import ECommerce.core.concretes.UserVer�fyManager;
import ECommerce.dataAccess.concretes.HibernateUserDao;
import ECommerce.entities.concretes.User;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
				
		User user = new User();
		user.setId(1);
		user.setFirstName("AK�F");
		user.setLastName("HSLK");
		user.setPassword("111112");
		user.seteMail("abc@gmail.com");

	AuthManager authManager = new AuthManager(new HibernateUserDao(),new UserVer�fyManager(),new GoogleManagerAdaptor());
	
	int key = 0;
	boolean durum = true;
	while (durum){
		
		System.out.println("Google ile giri� i�in {1} ");
		System.out.println("Register olmak i�in {2} ");
		System.out.println("Login yap�n�z {3} ");
        System.out.println("L�tfen i�lem se�iniz: ");
      
        key = scan.nextInt();
        if (key == 1) {
        	 System.out.println("Google ile giri� yap�ld�. ");
        	 durum = false;
		}else if(key == 2) {
			authManager.checkRegister(user);
			System.out.println("Register olundu. ");
			
		}else if (key == 3) {
			authManager.checkLogin(user);
			System.out.println("Login olundu. ");
			durum = false;
		}
     
        }
	 


	}

}
