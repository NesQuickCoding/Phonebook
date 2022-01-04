package information;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress{
	private String email;
	
	public EmailAddress() {}
	public EmailAddress(String email)
	{
		this.email = email;
	}
	
	public void setEmailAddress(String email)
	{
		this.email = email;
	}
	
	public String getEmailAddress()
	{
		return this.email;
	}
	
	public boolean validEmail(String emailAddress)
	{
		
		Pattern validEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher matcher = validEmail.matcher(emailAddress);
		
		boolean isValid = matcher.find();
		return isValid;
	}
	
	public String toString()
	{
		return this.email;
	}
	
}
