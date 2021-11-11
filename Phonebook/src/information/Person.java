package information;

public class Person {
	
	private String name; 
	
	public Person()
	{
	}
	
	public Person(String name)
	{
		this.name = name; 
	}
	
	public void setName(String name)
	{
		this.name = name; 
	}
	
	public String getName()
	{
		return this.name; 
	}
	
	// Need to override in order to compare person object by String name 
	// when comparing Strings we use equals method 
	public boolean equals(Person person)
	{
		if(person.getName().equals(this.getName()))
		{
			return true; 
		}
		return false; 
	}
	
	public String toString()
	{
		return String.format("Name: %s", this.name);
	}

}
