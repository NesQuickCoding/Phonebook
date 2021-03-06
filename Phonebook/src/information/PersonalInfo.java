package information;

public class PersonalInfo implements Information{
	
	private PhoneNumber number; 
	private EmailAddress email;
	
	public PersonalInfo()
	{
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

	public void setEmailAddress(EmailAddress email)
	{
		this.email = email;
	}
	
	
	public long getPhoneNumber()
	{
		
		return this.number.getNumber();
	}
	
	
	public String getEmailAddress()
	{

		return this.email.getEmailAddress();

	}
	
	
	public String toString()
	{
		return String.valueOf(this.number) + "," + String.valueOf(this.email);
	}

	@Override
	public void setEmailAddress(String email) {
		// TODO Auto-generated method stub
		
	}
	
	
}
