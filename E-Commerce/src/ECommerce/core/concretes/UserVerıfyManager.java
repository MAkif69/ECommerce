package ECommerce.core.concretes;

import ECommerce.core.abstracts.UserVerifyService;

public class UserVer�fyManager implements UserVerifyService {

	@Override
	public void sendVerifyEmail() {
		System.out.println("Do�rulama kodu g�derildi");
		}

	@Override
	public void button() {
		System.out.println("Kullan�c� do�ruland�.Hesap ba�ar�l�...");
	}

}
