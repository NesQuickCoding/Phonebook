package information;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber{
	private long number; 
	
	public PhoneNumber()
	{
	}
	
	public PhoneNumber(long number)
	{
		this.number = number; 
	}
	
	public void setNumber(long number)
	{
		this.number = number; 
	}
	
	public long getNumber()
	{
		return this.number; 
	}
	
	
	// This method ensures us the number entered by the user is 10 digits long and it's an integer type
	public boolean validNumber(String number)
	{
		Pattern validEmail = Pattern.compile("^[0-9]{10}");
		Matcher matcher = validEmail.matcher(number);
		
		boolean isValid = matcher.find();
		return isValid;
	}
	
	// we need to override equals method
	// in order compare numbers based on their int value when we compare objects
	public boolean equals(PhoneNumber number)
	{
		if(number.getNumber() == this.getNumber())
		{
			return true; 
		}
		
		return false; 
	}
	
	public String toString()
	{
		String header = "******Phone Number******"; 
		String footer = "*************************";
		
		return header + "/n" + "Phone Number: " + this.number + "\n" + footer; 
	}
	

}
