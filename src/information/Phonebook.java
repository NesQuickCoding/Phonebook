package information;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class Phonebook {
	
	private Map<Person, PhoneNumber> userPhonebookMap; 
	
	public Phonebook()
	{
		this.userPhonebookMap = new HashMap<Person, PhoneNumber>();
	}
	
	public Phonebook(String name, int number)
	{
		
		this.userPhonebookMap = new HashMap<Person, PhoneNumber>();
		
		Person newPerson = new Person();
		newPerson.setName(name);
		
		PhoneNumber newNumber = new PhoneNumber();
		newNumber.setNumber(number);
		
		this.userPhonebookMap.put(newPerson, newNumber);
		
	}
	
	public void setName(String name)
	{
		Person newPerson = new Person();
		newPerson.setName(name);
		
		this.userPhonebookMap.put(newPerson, new PhoneNumber());
		
	}
	
	public void setNumber(Person person, int number)
	{
		PhoneNumber newNumber = new PhoneNumber();
		newNumber.setNumber(number);
		
		this.userPhonebookMap.put(person, newNumber);
		
	}
	


}
