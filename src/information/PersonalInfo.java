package information;

public class PersonalInfo implements Information{
	
	private PhoneNumber number; 
	private EmailAddress email;
	
	public PersonalInfo()
	{
		this.number = new PhoneNumber();
		this.email = new EmailAddress();
	}
	
	public PersonalInfo(PhoneNumber number)
	{
		this.number = number; 
	}
	
	public PersonalInfo(EmailAddress email)
	{
		this.email = email;
	}
	
	public PersonalInfo(PhoneNumber number, EmailAddress email)
	{
		this.number = number; 
		this.email = email;
	}
	
	
	public void setPhoneNumber(PhoneNumber number)
	{
		this.number = number;
	}

	public void setEmailAddress(String email)
	{
		EmailAddress newEmail = new EmailAddress(email);
		this.email = newEmail;
	}
	
	public int getPhoneNumber()
	{
		return this.number.getNumber();
	}
	
	
	public String getEmailAddress()
	{

		if(this.email == null)
		{
			return "No Registered Email Found";
		}
	
		return this.email.getEmailAddress();

	}
	
	
	public String toString()
	{
		String header = "******Personal Info******"; 
		String footer = "*************************";
		
		return header + "\n" + this.number + "\n" + this.email + "\n" + footer; 
	}
	
	
}
