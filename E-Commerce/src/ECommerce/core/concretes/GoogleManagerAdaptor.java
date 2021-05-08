package ECommerce.core.concretes;

import ECommerce.core.abstracts.GeneralLoggingService;
import ECommerce.google.GoogleManager;

public class GoogleManagerAdaptor implements GeneralLoggingService {

	@Override
	public void LoggingToSystem(String message) {
		GoogleManager googleLogin = new GoogleManager();
		googleLogin.loginWithGoogle(message);
	
}
}