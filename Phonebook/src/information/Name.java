package information;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Pending - Check whether we still need this

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
		return this.firstName;
	}

	
	public String getLastName()
	{
		return this.lastName;
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


	// we need to override equals method
	// in order compare name based on Strings
	public boolean equals(Name name)
	{
		// check if both first name and last name are the same
		if(name.getFirstName().equals(this.getFirstName()) && name.getLastName().equals(this.getLastName()))
		{
			return true; 
		}
		
		return false; 
	}
	
	public String toString()
	{
		String message = String.format("%s %s",this.firstName, this.lastName);
		
		return message;
	}
	
	
}
