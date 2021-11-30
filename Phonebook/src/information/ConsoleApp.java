package information;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Resources 
 * https://howtodoinjava.com/java/string/format-phone-number/ for formating phone number
 * @author Neslie
 *
 */
	
public class ConsoleApp {
	
	private HashMap<Name, PersonalInfo> phonebookMap; 
	private Scanner sc; 

	public ConsoleApp()
	{
		this.phonebookMap = new HashMap<Name, PersonalInfo>();
		this.sc = new Scanner(System.in);
	}
	
	public void start()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("\t\tWelcome to Phonebook");
		System.out.println("------------------------------------------------------");
		
		// activate menu
		menu();

		// activate command `````
		command();

	}
	
	public void menu()
	{
		System.out.println("\t\tMain Menu:");
		
		System.out.println("------------------------------------------------------");
		System.out.println("Available operations:");
		System.out.println("1 - Add a new Person");
		System.out.println("2 - Search for a number by name");
		System.out.println("3 - Search for a name by phone number");
		System.out.println("4 - Update Person info");
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
				System.out.println("Add a new Person");
				addNewPerson(); 
				commandMenu();
				break;
				
			case 2: 
				System.out.println("Searching for Info by name");
				searchByName();
				commandMenu();
				break; 
				
			case 3:
				System.out.println("Search for a name by phone number");
				searchByNumber();
				commandMenu();
				break; 
				
			case 4:
				System.out.println("Update Person Info");
				updatePerson();
				commandMenu();
				break;
				
			case 5:
				System.out.println("Search for personal information");
				searchPersonalInfo();
				commandMenu();
				break;
			case 6:
				System.out.println("Delete personal information");
				deletePersonalInfo();
				commandMenu();
				break; 
			case 7:
				System.out.println("Filtered listing");
				displayListing();
				commandMenu();
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
	
	private void addNewPerson()
	{
	
		System.out.println("------------------------------------------------------");
		System.out.println("Adding a new Person");
		

		Name newName = addValidName();
		
		PhoneNumber newNumber = addPhoneNumber(newName);
		
		EmailAddress newEmail = addEmailAddress(newName);
		
		// now we add this to our HashMap
		phonebookMap.put(newName, new PersonalInfo(newNumber, newEmail));
		
		System.out.println("------------------------------------------------------");
	} // end of addNumber method 
	

	private void searchByName()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Searching by Name");
		Name name = addValidName();
		boolean found = false;
		

				for(Name n : this.phonebookMap.keySet())
				{
					if(n.equals(name))
					{
						System.out.println("Name Found");
						System.out.println("Name: " + n);
						System.out.println("Number: " + convertNumber(this.phonebookMap.get(n).getPhoneNumber()));
						found = true;
					} 
				}
				
				if(found == false)
				{
					System.out.println("Name cannot be found");
					System.out.println("Please try again");
					searchByName();
				}
				
		System.out.println("------------------------------------------------------");
		
	} // end of searchByName method
	
	
	private void searchByNumber()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Searching by Number");
		System.out.print("Please enter the persons number: ");
		long number = Long.parseLong(sc.nextLine());

		for(Name n : this.phonebookMap.keySet())
		{
			if(this.phonebookMap.get(n).getPhoneNumber() == number)
			{
			
				System.out.println("Number Found");
				System.out.println("Person's name: " + n);
			} else {
				System.out.println("Sorry, Number not found");
				System.out.println("Please try again");
				searchByNumber();
			}
		}
		System.out.println("------------------------------------------------------");
		
	}

	// This method adds a valid first and last name
	// it loops if the entered name is not valid 
	private Name addValidName()
	{
		System.out.print("Please enter the first name: ");
		String firstName = sc.nextLine();
		
		Name newName = new Name();
		
		while(!newName.validName(firstName))
		{
			System.out.println("First name is not valid, please try again");
			System.out.print("Please enter the First name: ");
			firstName = sc.nextLine();
		}
		
		
		System.out.print("Please enter the last name: ");
		String lastName = sc.nextLine();
		
		while(!newName.validName(lastName))
		{
			System.out.println("Last name is not valid, please try again");
			System.out.print("Please enter the Last name: ");
			lastName = sc.nextLine();
		}
		
		
		newName.setName(firstName,  lastName);
		
		return newName;
	} // end of addValidName method 
	
	// Returns a PhoneNumber object
	private PhoneNumber addPhoneNumber(Name name)
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Adding Phone Number");
		System.out.println("Please enter " + name + "'s Phone Number");
		
		String phone = sc.nextLine();
		
		if(phone.length() != 10)
		{

			System.out.println("Phone number must be 10 digits");
			System.out.println("Please try again.");
			
			addPhoneNumber(name);
		
		} 
		
		PhoneNumber newPhone = new PhoneNumber();
		long phoneLong = Long.valueOf(phone);
		newPhone.setNumber(phoneLong);

		
		System.out.println("------------------------------------------------------");
		
		return newPhone;
		
	}

	
	// Returns an EmailAddress object
	private EmailAddress addEmailAddress(Name name)
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Adding Email Address");
		System.out.println("Please enter " + name + "'s Email Address");
		
		String email = sc.nextLine();
		
		
		EmailAddress newEmail = new EmailAddress();
		


		// loop it until they enter a valid email address
		while(newEmail.validEmail(email) == false)
		{
			System.out.println("Invalid Email Address");
			System.out.println("Please try again");
			System.out.println("Please enter " + name + "'s Email Address");
			email = sc.nextLine();

		}
			newEmail.setEmailAddress(email);

		System.out.println("------------------------------------------------------");
		return newEmail;
	} // end of addEmailAddress method
	
	
	/**
	 * This method searches through our HashMap for the Person object whether it exist or not
	 * @return
	 */
	private boolean doesPersonExist(Name name)
	{
		if(this.phonebookMap.containsKey(name))
		{
			return true; 
		} 
		
		return false; 
	} // end of doesPersonExist method 
	
	// This method update the Persons Personal Information 
	private void updatePerson()
	{
		
		Name newName = addValidName();
		
		
		if(doesPersonExist(newName))
		{
			this.phonebookMap.get(newName);
		}
		
		for(Name n: this.phonebookMap.keySet())
		{
			if(doesPersonExist(n))
			{
				System.out.println("Person Found");
				updatePhoneNumber(n);
				updateEmailAddress(n);
				
			} else {
				System.out.println("Person not found, please try again");
			}
		}
		
	} // end of updatePerson method 
	
	// This method sets an email address for the Person object
	private void updateEmailAddress(Name name)
	{;
		EmailAddress newEmail = addEmailAddress(name);
		
		this.phonebookMap.get(name).setEmailAddress(newEmail);;
	} // end of updateEmailAddress method 
	
	private void updatePhoneNumber(Name name)
	{
		PhoneNumber newNumber = addPhoneNumber(name);
		// now we add this to our HashMap
		this.phonebookMap.get(name).setPhoneNumber(newNumber);
	}
	
	
	
	// Ask the user which person information they would like to update
	private void updatePI(Name name)
	{
		System.out.println("Updating Person Information for: " + name);
		
		System.out.println("Enter 1 to update Phone Number");
		System.out.println("Enter 2 to update Email Address");
		System.out.println("Enter 0 to go back to Main Menu");
		
		System.out.print("Command: ");
		String comm = sc.nextLine();
		
		switch(comm)
		{
		case "1":
			updatePhoneNumber(name);
			break;
		case "2":
			updateEmailAddress(name);
			break;
		case "0":
			commandMenu();
			break;
			
		default: 
			System.out.println("Wrong input, please try again");
			updatePI(name);
		}
		
		
	} // end of updatePI
	

	private String convertNumber(long num)
	{
		String number = Long.toString(num);
		
		// Reference https://howtodoinjava.com/java/string/format-phone-number/
		String updatedNumber = number.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
		
		return updatedNumber;
	}
	
	
	private void searchPersonalInfo()
	{
		System.out.println("------------------------------------------------------");
		Name newName = addValidName();
		
			if(doesPersonExist(newName))
			{
				getPersonalInfo(newName);
					
			} else {
				System.out.println("Person not found, please try again");
				searchPersonalInfo();
			
			
		} // end of for loop 
		System.out.println("------------------------------------------------------");

	} // end of searchPersonalInfo Method 
	
	private void getPersonalInfo(Name name)
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
			output = "Phone Number: " + this.phonebookMap.get(name).getPhoneNumber();
			System.out.println(output);
			System.out.println("------------------------------------------------------");
			getPersonalInfo(name);
			
		}
		else if(command.equals("2")) { 
			System.out.println("------------------------------------------------------");
			System.out.println("Getting Email Address"); 
			// Need to add email address
			output = "Email Address: " + this.phonebookMap.get(name).getEmailAddress();
			System.out.println(output);
			System.out.println("------------------------------------------------------");
			getPersonalInfo(name);
			
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
			getPersonalInfo(name);
		} 
		System.out.println("------------------------------------------------------");

	} // end of getPersonalInfo method 
	
	private void deletePersonalInfo()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Deleting Personal Information");
		System.out.print("Enter the name you would like to delete information: ");
		Name newName = addValidName();
		
		if(doesPersonExist(newName))
		{
			
			deleteSelectInfo(newName);

		}
		
		System.out.println("------------------------------------------------------");
		
	}
	
	private void deleteSelectInfo(Name name)
	{
		System.out.println("Which information would you like to be deleted? ");
		System.out.println("For Phone Number, Enter 1");
		System.out.println("For Email Address, Enter 2");
		
		String command = sc.nextLine();
		if(command.equals("1"))
		{
			System.out.println(String.format("Deleting %s's Phone Number", name));
			// Save the persons original email address
			String emailAddress = this.phonebookMap.get(name).getEmailAddress();
			// Add a new phone number  to the hashMap
			long phoneNumber = 0;
			PersonalInfo updatedPersonalInfo = new PersonalInfo();
			updatedPersonalInfo.setEmailAddress(emailAddress);
			updatedPersonalInfo.setPhoneNumber(new PhoneNumber(phoneNumber));
			
			this.phonebookMap.put(name, updatedPersonalInfo);
			
			System.out.println("Phone Number Deletion Completed");
			
			displayInfo(name);
		}
		
		else if(command.equals("2"))
		{
			System.out.println(String.format("Deleting %s's Email Address", name));
			
			// Save the persons original phone number
			long phoneNumber = this.phonebookMap.get(name).getPhoneNumber();
			
			PersonalInfo updatedPersonalInfo = new PersonalInfo();
			updatedPersonalInfo.setEmailAddress("No Email");
			updatedPersonalInfo.setPhoneNumber(new PhoneNumber(phoneNumber));
			this.phonebookMap.put(name, updatedPersonalInfo);
			
			System.out.println("Email Address Deletion Completed");
			displayInfo(name);
		}
		else 
		{
			System.out.println("Invalid command");
			deleteSelectInfo(name);
		}
	} // end of 
	
	
	private void displayListing()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Displaying Phonebook Information");
		
		if(this.phonebookMap.isEmpty())
		{
			System.out.println("Phonebook Empty");
		}
		else {
			for(Name name : this.phonebookMap.keySet())
			{
				displayInfo(name);
			}
		} 
		
		System.out.println("------------------------------------------------------");

		
	} // end of displayListing method 
	
	// Display Person's name
	// PhoneNumber and Email
	private void displayInfo(Name name)
	{
		System.out.println("------------------------------------------------------");
		
		displayName(name);
		displayNumber(name);
		displayEmail(name);
		 
		System.out.println("------------------------------------------------------");
	}
	
	
	public void displayName(Name name)
	{
		System.out.println("Name: " + name);
	}
	
	public void displayNumber(Name name)
	{
		System.out.println("Phone Number: " + convertNumber(this.phonebookMap.get(name).getPhoneNumber()));
	}
	
	public void displayEmail(Name name)
	{
		System.out.println("Email Address: " + this.phonebookMap.get(name).getEmailAddress());
	}
	
	
	// this method scans a CSV
	// places those information in the proper objects to add to our HashMap
	private void scanCSV() throws Exception
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Scanning CSV");
		System.out.println("------------------------------------------------------");
		System.out.print("Please enter the csv name: ");
		String csv_input = sc.nextLine();
		
		// Add our try catch or throw exception if csv file does not exist
		
	}
	
	private void commandMenu()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Enter 1 for Main Menu");
		System.out.println("Enter 0 to Quit");
		
		System.out.print("Command: ");
		String command = sc.nextLine();
		
		switch(command) {
		case "1":
			menu();
			break;
		case "0":
			quitting();
			break;
		default:
			System.out.println("Wrong input, please try again");
			commandMenu();
		}
		
	}
	
	private void quitting()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("Goodbye");
		System.out.println("------------------------------------------------------");
		System.exit(0);
	}

}