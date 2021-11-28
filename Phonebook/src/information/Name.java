package information;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
	
	private String firstName;
	private String lastName;
	
	public Name()
	{
		
	}
	
	public Name(String first, String last)
	{
		this.firstName = first;
		this.lastName = last; 
	}
	
	// Getters
	public String getFirstName()
	{
		return this.getFirstName();
	}

	
	public String getLastName()
	{
		return this.getLastName();
	}
	
	public String getFullName()
	{
		String name = String.format("%s %s", this.firstName, this.lastName);
		
		return name; 
	}
	
	// Setters
	
	public void setFirstName(String first)
	{
		this.firstName = first;
	}
	
	public void setLastName(String last)
	{
		this.lastName = last; 
	}
	
	public void setName(String first, String last)
	{
		this.firstName = first; 
		this.lastName = last; 
	}
	
	// validName, this will be used for first name and last name 
	public boolean validName(String name)
	{
		Pattern validNamePattern = Pattern.compile("[a-zA-Z]*");
		Matcher matcher = validNamePattern.matcher(name);
		
		return matcher.matches();
	}
	
	public boolean validFullName(String first, String last)
	{
		Pattern validPattern = Pattern.compile("[a-zA-Z]* [a-zA-Z]*");
		String name = first + " " + last;
		
		Matcher matcher = validPattern.matcher(name);
		
		return matcher.matches();
	}


	
	public String toString()
	{
		String message = String.format("%s %s",this.firstName, this.lastName);
		
		return message;
	}
	
	
}
