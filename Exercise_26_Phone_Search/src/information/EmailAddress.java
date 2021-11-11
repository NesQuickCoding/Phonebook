package information;

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
	
	public String toString()
	{
		

		String header = "******Email Address******"; 
		String footer = "*************************";
			
		return header + "\n" + "Email address: " + this.email + footer; 

	}
	
}
