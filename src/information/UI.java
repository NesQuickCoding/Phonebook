package information;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

	
public class UI {
	
	private HashMap<Person, PersonalInfo> phonebookMap; 
	private Scanner sc; 

	public UI()
	{
		this.phonebookMap = new HashMap<Person, PersonalInfo>();
		this.sc = new Scanner(System.in);
	}
	
	public void start()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Welcome to the Phonebook");
		System.out.println("------------------------------------------------------");
		
		// activate menu
		menu();

		// activate command `````
		command();

	}
	
	public void menu()
	{
		System.out.println("Main Menu:");
		
		System.out.println("------------------------------------------------------");
		System.out.println("Available operations:");
		System.out.println("1 - Add a number");
		System.out.println("2 - Search for a number");
		System.out.println("3 - Search for a person by phone number");
		System.out.println("4 - Add an Email address");
		System.out.println("5 - Search for personal information");
		System.out.println("6 - Delete personal information");
		System.out.println("7 - Display Listing");
		System.out.println("0 - Quit");
		System.out.println("------------------------------------------------------");
		
		command();

	

	}
	
	public void command() 
	{
		
		System.out.print("What's your command: ");
		
		Scanner comm = new Scanner(System.in);
		String userCommand = comm.nextLine();
		
		int userCommandInt = Integer.parseInt(userCommand);
			
			switch(userCommandInt)
			{
			case 1:
				System.out.println("Adding a number");
				addNumber(); 
				menu();
				break;
			case 2: 
				System.out.println("Searching for a number");
				searchByName();
				menu();
				break; 
			case 3:
				System.out.println("Search for a person by phone number");
				searchByNumber();
				menu();
				break; 
			case 4:
				System.out.println("Add an Email address");
				addEmailAddress();
				menu();
				break;
			case 5:
				System.out.println("Search for personal information");
				searchPersonalInfo();
				menu();
				break;
			case 6:
				System.out.println("Delete personal information");
				deletePersonalInfo();
				menu();
				break; 
			case 7:
				System.out.println("Filtered listing");
				displayListing();
				menu();
				break; 
			case 0:
				System.out.println("Quit");
				quitting();
				break; 

			} // end of switch statement 
			
			// if the command is not 0
			// loop the command 
			if(userCommandInt != 0)
			{
				command();
			} 
			
	}
	
	private void addNumber()
	{
	
		System.out.println("------------------------------------------------------");
		System.out.println("Adding a Number");
		
		System.out.print("Please enter person name: ");
		String name = sc.nextLine();
		
		Person newPerson = new Person();
		newPerson.setName(name);
		
		System.out.print("Please enter this persons number: ");
		long number = Long.parseLong(sc.nextLine());
		
		PhoneNumber newNumber = new PhoneNumber();
		newNumber.setNumber(number);
		
		// now we add this to our HashMap
		phonebookMap.put(newPerson, new PersonalInfo(newNumber));
	
		System.out.println("------------------------------------------------------");
	} // end of addNumber method 
	

	private void searchByName()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Searching by Name");
		System.out.print("Please enter the person's name: ");
		String name = sc.nextLine();
		
		for(Person person: this.phonebookMap.keySet())
		{
			if(person.equals(new Person(name)))
			{
				System.out.println("Person found");
				System.out.println("Number: " + this.phonebookMap.get(person).getPhoneNumber());
			} else {
				System.out.println("Sorry, Person not found");
			}
		}
		
		System.out.println("------------------------------------------------------");
		
	}
	
	
	private void searchByNumber()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Searching by Number");
		System.out.print("Please enter the persons number: ");
		long number = Long.parseLong(sc.nextLine());

		for(Person person : this.phonebookMap.keySet())
		{
			if(this.phonebookMap.get(person).getPhoneNumber() == number)
			{
			
				System.out.println("Number Found");
				System.out.println("Person's name: " + person.getName());
			} else {
				System.out.println("Sorry, Number not found");
			}
		}
		System.out.println("------------------------------------------------------");
		
	}


	
	private void addEmailAddress()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Adding Email Address");
		
		System.out.print("Please enter the person's name: ");
		String name = sc.nextLine();
		
		
		for(Person person : this.phonebookMap.keySet())
		{
			if(person.getName().equals(name))
			{
				System.out.println("Person Found");
				System.out.print("Please enter " + person.getName() + "'s Email Address: ");
				String email = sc.nextLine();
				this.phonebookMap.get(person).setEmailAddress(email);
				System.out.println("Email added");
			}
		} // end of for loop 
	
		System.out.println("------------------------------------------------------");

	} // end of addEmailAddress method
	

		
	
	
	private void searchPersonalInfo()
	{
		System.out.println("------------------------------------------------------");
		System.out.print("Enter the name are you looking for: ");
		
		String name = sc.nextLine();
		for(Person person : this.phonebookMap.keySet())
		{
			if(person.equals(new Person(name)))
			{
				System.out.println("Person Found");
				System.out.println("Name: " + person.getName());
				getPersonalInfo(person);
					
			} else {
				System.out.println("Person not found, please try again");
				searchPersonalInfo();
			}
			
		} // end of for loop 
		System.out.println("------------------------------------------------------");

	} // end of searchPersonalInfo Method 
	
	private void getPersonalInfo(Person person)
	{
		System.out.println("------------------------------------------------------");
		
		System.out.println("What Personal Info are you looking for?");
		System.out.println("Enter 1 for Phone Number");
		System.out.println("Enter 2 for Email Address");
		System.out.println("Enter 0 for Back to Main Menu");
		System.out.print("Command: ");
		
		
		String command = sc.nextLine();
		String output = "";
		
		if(command.equals("1")) { 
			System.out.println("------------------------------------------------------");
			System.out.println("Getting Phone Number"); 
			// Need to add number
			output = "Phone Number: " + this.phonebookMap.get(person).getPhoneNumber();
			System.out.println(output);
			System.out.println("------------------------------------------------------");
			getPersonalInfo(person);
			
		}
		else if(command.equals("2")) { 
			System.out.println("------------------------------------------------------");
			System.out.println("Getting Email Address"); 
			// Need to add email address
			output = "Email Address: " + this.phonebookMap.get(person).getEmailAddress();
			System.out.println(output);
			System.out.println("------------------------------------------------------");
			getPersonalInfo(person);
			
		}
		else if(command.equals("0"))
		{
			System.out.println("Thank You. Going back to main Menu.");
			{
				menu();
			}
		}
		else { 
			System.out.println("Invalid Command"); 
			System.out.println("Please try again.");
			getPersonalInfo(person);
		} 
		System.out.println("------------------------------------------------------");

	} // end of getPersonalInfo method 
	
	private void deletePersonalInfo()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Deleting Personal Information");
		System.out.print("Enter the name you would like to delete information: ");
		String name = sc.nextLine();
		
		for(Person person : this.phonebookMap.keySet())
		{
			if(person.equals(new Person(name)))
			{
				System.out.println("Person Found");
				deleteSelectInfo(person);

			}
		}
		
		System.out.println("------------------------------------------------------");
		
	}
	
	private void deleteSelectInfo(Person person)
	{
		System.out.println("Which information would you like to be deleted? ");
		System.out.println("For Phone Number, Enter 1");
		System.out.println("For Email Address, Enter 2");
		
		String command = sc.nextLine();
		if(command.equals("1"))
		{
			System.out.println(String.format("Deleting %s's Phone Number", person.getName()));
			// Save the persons original email address
			String emailAddress = this.phonebookMap.get(person).getEmailAddress();
			// Add a new phone number  to the hashMap
			long phoneNumber = 0;
			PersonalInfo updatedPersonalInfo = new PersonalInfo();
			updatedPersonalInfo.setEmailAddress(emailAddress);
			updatedPersonalInfo.setPhoneNumber(new PhoneNumber(phoneNumber));
			this.phonebookMap.put(person, updatedPersonalInfo);
			
			System.out.println("Phone Number Deletion Completed");
			
			displayInfo(person);
		}
		
		else if(command.equals("2"))
		{
			System.out.println(String.format("Deleting %s's Email Address", person.getName()));
			
			// Save the persons original phone number
			long phoneNumber = this.phonebookMap.get(person).getPhoneNumber();
			
			PersonalInfo updatedPersonalInfo = new PersonalInfo();
			updatedPersonalInfo.setEmailAddress("No Email");
			updatedPersonalInfo.setPhoneNumber(new PhoneNumber(phoneNumber));
			this.phonebookMap.put(person, updatedPersonalInfo);
			
			System.out.println("Email Address Deletion Completed");
			displayInfo(person);
		}
		else 
		{
			System.out.println("Invalid command");
			deleteSelectInfo(person);
		}
	} // end of 
	
	
	private void displayListing()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Filtered Listing");
		
		if(this.phonebookMap.isEmpty())
		{
			System.out.println("Phonebook Empty");
		}
		else {
			for(Person per : this.phonebookMap.keySet())
			{
				displayInfo(per);
			}
		} 
		
		System.out.println("------------------------------------------------------");

		
	}
	
	// Display Person's name
	// PhoneNumber and Email
	private void displayInfo(Person person)
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Displaying Information");
		System.out.println(person);
		System.out.println("Phone Number: " + this.phonebookMap.get(person).getPhoneNumber());
		

		System.out.println("Email Address: " + this.phonebookMap.get(person).getEmailAddress());

		 
		System.out.println("------------------------------------------------------");
	}
	
	private void quitting()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Goodbye");
		System.out.println("------------------------------------------------------");
		System.exit(0);
	}

}