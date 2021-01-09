package user;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator{
	 @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
		 return new PasswordAuthentication("jinnyus.dev@gmail.com","team1234@!");
	    }

	
}
