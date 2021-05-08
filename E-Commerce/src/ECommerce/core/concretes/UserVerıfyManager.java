package ECommerce.core.concretes;

import ECommerce.core.abstracts.UserVerifyService;

public class UserVerýfyManager implements UserVerifyService {

	@Override
	public void sendVerifyEmail() {
		System.out.println("Doðrulama kodu göderildi");
		}

	@Override
	public void button() {
		System.out.println("Kullanýcý doðrulandý.Hesap baþarýlý...");
	}

}
