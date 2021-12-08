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
	
	private Map<Name, PersonalInfo> phonebookMap; 
	private Scanner sc; 

	public ConsoleApp()
	{
		this.phonebookMap = new HashMap<Name, PersonalInfo>();
		this.sc = new Scanner(System.in);
	}
	
	public void banner()
	{
		System.out.println("------------------------------------------------------");
	}
	
	public void titleBanner(String sampleTitle)
	{
		banner();
		System.out.println(String.format("\t\t%s",sampleTitle));
		banner();
	}
	
	
	public void start()
	{
		titleBanner("Welcome to Phonebook");
		
		// activate menu
		menu();

		// activate command  
		
		command();
	} // end of start method 
	
	public void menu()
	{
		titleBanner("Main Menu");
		System.out.println("Available Operations:");
		System.out.println("1 - Add a New Person");
		System.out.println("2 - Search for Personal Information");
		System.out.println("3 - Update Personal info");
		System.out.println("4 - Delete Person from Phonebook");
		System.out.println("5 - Display Listing");
		System.out.println("0 - Quit");
		banner();
		
		command();

	} // end of menu method 
		
	public void command() 
	{
		
		System.out.print("Enter your command: ");
		
		String userCommand = sc.nextLine();
		
		int userCommandInt = Integer.parseInt(userCommand);
			
			switch(userCommandInt)
			{
			case 1:
				System.out.println("Add a new Person");
				addNewPerson(); 
				commandMenu();
				break;
				
			case 2: 
				System.out.println("Search for Personal Information");
				personalInfoMenu();
				break; 
				
				
			case 3:
				System.out.println("Update Person Info");
				updatePerson();
				commandMenu();
				break;
				
			case 4:
				System.out.println("Delete Person from Phonebook");
				deletePerson();
				commandMenu();
				break;

				
			case 5:
				System.out.println("Display listing");
				displayListing();
				commandMenu();
				break; 
						
			case 0:
				System.out.println("Quit");
				quitting();
				break; 

			} // end of switch statement 
			
	} // end of command Method 
	
	
	// ** commandMenu is basically the return to Menu
	// Need to rename this 
	private void commandMenu()
	{
		titleBanner("Command Menu");
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
		} // end of switch statement 
		
	} // end of Command Menu
	
	// Need to fix this in order to optimized command Menu
	private void commandMenu(String comm)
	{
		System.out.println(String.format("Enter 1 to go back to %s Menu", comm));
		System.out.println("Enter 2 to go back to Main Menu");
		System.out.println("Enter 0 to exit Program");
		
		System.out.print("Command: ");
		String inputComm = sc.nextLine();
		if(inputComm.equals("1"))
		{
			personalInfoMenu();
		} else if(inputComm.equals("2"))
		{
			menu();
		} else if(inputComm.equals("0"))
		{
			quitting();
		} else {
			System.out.println("Wrong input");
			commandMenu(comm);
		}
	} // end of commanedMenu(String comm) method 
	
	
	// Option 1: Add New Person
	private void addNewPerson()
	{
	
		titleBanner("Adding New Person");
		
		Name newName = addValidName();
		
		PhoneNumber newNumber = addPhoneNumber(newName);
		
		EmailAddress newEmail = addEmailAddress(newName);
		
		// now we add this to our HashMap
		phonebookMap.put(newName, new PersonalInfo(newNumber, newEmail));
		
		banner();
	} // end of addNumber method 
	
	
	// Option 1 > Add New Person > Add Name
	// This method will be used plenty of times 
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
	
	
	// Option 1 > Add New Person > Add Phone Number
	private PhoneNumber addPhoneNumber(Name name)
	{
		titleBanner("Adding Phone Number");
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

		
		banner();
		
		return newPhone;
		
	}

	// Option 1 > Add New Person > Add Email Address
	private EmailAddress addEmailAddress(Name name)
	{
		titleBanner("Adding Email Address");
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

		banner();
		return newEmail;
	} // end of addEmailAddress method
	

	// Option 2: Personal Information 
	public void personalInfoMenu()
	{
		banner();
		System.out.println("\t\tPersonal Info Menu");
		banner();
		System.out.println("1 - Search for a Personal Info by Name");
		System.out.println("2 - Search for Personal Info by Phone Number");
		System.out.println("3 - Search for Personal Info by Email Address");
		System.out.println("4 - Back To Main Menu");
		System.out.println("0 - Exit Program");
		banner();
		
		piCommand();
	} // end of personalInfoMenu method 
	
	
	public void piCommand() 
	{
		
		System.out.print("Enter your command: ");
		
		String userCommand = sc.nextLine();
		
		int userCommandInt = Integer.parseInt(userCommand);
			
			switch(userCommandInt)
			{
			case 1:
				System.out.println("Searching for Personal Info by Name");
				searchByName();
				commandMenu("Personal Info");
				break;
				
			case 2: 
				System.out.println("Searching for Personal Info by Phone Number");
				searchByNumber();
				commandMenu("Personal Info");
				break; 
				
			case 3:
				System.out.println("Search for Personal Info by Email Address");
				searchByEmail();
				commandMenu("Personal Info");
				break; 
				
			case 4: 
				System.out.println("Back to Main Menu");
				menu();
				break;
				
			case 0:
				System.out.println("Exiting Program");
				quitting();
				break; 

			} // end of switch statement 
			
	} // end of piCommand Method 
	
	
	// Option 2: Search for Personal Info > Search By Name 
		private void searchByName()
		{
			titleBanner("Searching By Name");
			Name name = addValidName();
			boolean found = false;
			

					for(Name n : this.phonebookMap.keySet())
					{
						if(n.equals(name))
						{
							System.out.println("Name Found");
							displayInfo(n);
							found = true;
						} 
					}
					
					if(found == false)
					{
						System.out.println("Name cannot be found");
						System.out.println("Please try again");
						searchByName();
					}
					
					banner();
			
		} // end of searchByName method
		
	
	// Option 2 : Search For Personal Info > Search By Number 
	private void searchByNumber()
	{
		titleBanner("Searching By Number");
		System.out.print("Please enter the persons number: ");
		String userInput = sc.nextLine();
		
		// Check if the value entered by a user has the length of 10 digits
		while(userInput.length() != 10)
		{
			System.out.println("Wrong input");
			System.out.println("Please enter the 10 digit phone number");
			userInput = sc.nextLine();
		}
		
		
		long number = Long.parseLong(userInput);
		
		boolean found = false; 

		for(Name n : this.phonebookMap.keySet())
		{
			if(this.phonebookMap.get(n).getPhoneNumber() == number)
			{
			
				System.out.println("Number Found");
				displayInfo(n);
				found = true; 
			}
			
		} // end of for loop
		
		 if(found == false)
		 {
				System.out.println("Sorry, Number not found");
				System.out.println("Please try again");
				searchByNumber();
		 }

		 banner();
		
	}
	
	// Option 2: Search For Personal Info > Search By Email
	private void searchByEmail()
	{
		titleBanner("Searching by Email");
		System.out.print("Please enter the persons Email Address: ");
		String email = sc.nextLine();
		boolean found = false; 

		for(Name n : this.phonebookMap.keySet())
		{
			if(this.phonebookMap.get(n).getEmailAddress().equals(email))
			{
			
				System.out.println("Email Found");
				displayInfo(n);
				found = true; 
			} 
		} // end of for loop
		
		 if(found == false)
		 {
				System.out.println("Sorry, Email not found");
				System.out.println("Please try again");
				searchByEmail();
		 }

		 banner();
	} // end of searchByEmail method 
	


	// Option 3 : Update Personal Information 
	
	// Ask the user which person information they would like to update
			private void updatePI(Name name)
			{
				banner();
				System.out.println("Updating Person Information for: " + name);
				banner();
				
				System.out.println("Enter 1 to update Name");
				System.out.println("Enter 2 to update Phone Number");
				System.out.println("Enter 3 to update Email Address");
				System.out.println("Enter 0 to go back to Main Menu");
				
				System.out.print("Command: ");
				String comm = sc.nextLine();
				
				switch(comm)
				{
				case "1":
					updateName(name);
				case "2":
					updatePhoneNumber(name);
					break;
				case "3":
					updateEmailAddress(name);
					break;
				case "0":
					commandMenu();
					break;
					
				default: 
					System.out.println("Wrong input, please try again");
					updatePI(name);
				}
				
				banner();
			} // end of updatePI
	
			
	private void nameCommand(Name name)
	{
		System.out.print("Enter your command: ");
		
		String userCommand = sc.nextLine();
		
		int userCommandInt = Integer.parseInt(userCommand);
			
			switch(userCommandInt)
			{
			case 1:
				System.out.println("Changing First Name");
				changeFirstName(name);
				updateNameMenu(name);
				break;
				
			case 2: 
				System.out.println("Changing Last Name");
				changeLastName(name);
				updateNameMenu(name);
				break; 
				
			case 3:
				System.out.println("Changing Full Name");
				changeFullName(name);
				updateNameMenu(name);
				break; 
				
			case 4: 
				System.out.println("Back to Main Menu");
				menu();
				break;
				
			case 0:
				System.out.println("Exiting Program");
				quitting();
				break; 
			}

	} // end of name NameCommand Menu
	
	
	// This method update the Persons Name (Object)
	private void updatePerson()
	{
		
		Name newName = addValidName();
		boolean found = false; 
		
		
			for(Name n: this.phonebookMap.keySet())
			{
				if(n.equals(newName))
				{
					System.out.println("Person Found");
					found = true;
					updatePI(n);
					
				} 
				
			} // end of for loop 
			
			if(found == false)
			{
				System.out.println("Person not found, please try again");
				updatePerson();
			}

	} // end of updatePerson method 	
	

	private void updateName(Name name)
	{
		
		updateNameMenu(name);
	}

	private void updateNameMenu(Name name)
	{

			titleBanner("Update Name Menu");
			System.out.println(name);
			banner();
			System.out.println("1 - Change First Name");
			System.out.println("2 - Change Last Name");
			System.out.println("3 - Change Full Name");
			System.out.println("4 - Back To Main Menu");
			System.out.println("0 - Exit Program");
			banner();
			
			nameCommand(name);
	} // end of personalInfoMenu method 
	
	private void changeFirstName(Name name)
	{
		String input_name = enterName("First");
		
		for(Name n : this.phonebookMap.keySet())
		{
			if(n.equals(name))
			{
				n.setFirstName(input_name);
			}
			
		} // end of for loop 
	} // end of changingFirstName method 
		
	private void changeLastName(Name name)
	{
		String input_name = enterName("Last");
		
		for(Name n : this.phonebookMap.keySet())
		{
			if(n.equals(name))
			{
				n.setLastName(input_name);
			}
			
		} // end of for loop 
	} // end of changingLastName method 
	
	private void changeFullName(Name name)
	{
		changeFirstName(name);
		changeLastName(name);
	} // end of changeFullName method 
	
	
	// This method can be used for First Name or Last Name depending on what the user enters as an input 
	private String enterName(String pos)
	{
		System.out.print(String.format("Please enter the %s name: ", pos));
		String name = sc.nextLine();
		
		Name newName = new Name();
		
		while(!newName.validName(name))
		{
			System.out.println(String.format("Entered %s name is not valid, please try again", pos));
			System.out.print(String.format("Please enter the %s name: ", pos));
			name = sc.nextLine();
		}
		
		return name;
	} // end of enterName method 
	
	
	private void updateEmailAddress(Name name)
	{
		EmailAddress newEmail = addEmailAddress(name);
		
		this.phonebookMap.get(name).setEmailAddress(newEmail);;
	} // end of updateEmailAddress method 
	
	private void updatePhoneNumber(Name name)
	{
		PhoneNumber newNumber = addPhoneNumber(name);
		// now we add this to our HashMap
		this.phonebookMap.get(name).setPhoneNumber(newNumber);
	}
	

	private String convertNumber(long num)
	{
		String number = Long.toString(num);
		
		// Reference https://howtodoinjava.com/java/string/format-phone-number/
		String updatedNumber = number.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
		
		return updatedNumber;
	}
	

	// Option 4: Delete Person from Phone Book 
	private void deletePerson()
	{
		titleBanner("Deleting Person from Phonebook");
		Name newName = addValidName();
		
		for(Name n : this.phonebookMap.keySet())
		{
			if(n.equals(newName))
			{
			
				this.phonebookMap.remove(n);
				System.out.println("Person Deleted");
				break;
			}
			
		} // end of for loop
		
		
		banner();
		
	} // end of deletePerson
	
	
	// Option 5: Display Listing
	private void displayListing()
	{
		titleBanner("Display Phonebook Information");
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
		banner();
	
	} // end of displayListing method 
	
	// Display Person's name, number, email
	private void displayInfo(Name name)
	{

		banner();
		displayName(name);
		displayNumber(name);
		displayEmail(name);
		banner();

	} // end of displayInfo method 
	
	public void displayName(Name name)
	{
		System.out.println("Name: " + name);
	} // end of displayName method 
	
	public void displayNumber(Name name)
	{
		System.out.println("Phone Number: " + convertNumber(this.phonebookMap.get(name).getPhoneNumber()));
	} // end of displayNumber method 
	
	public void displayEmail(Name name)
	{
		System.out.println("Email Address: " + this.phonebookMap.get(name).getEmailAddress());
	} // end of displayEmail method 
	
	
//	// Future Add On
//	// this method scans a CSV
//	// places those information in the proper objects to add to our HashMap
//	private void scanCSV() throws Exception
//	{
//		System.out.println("------------------------------------------------------");
//		System.out.println("Scanning CSV");
//		System.out.println("------------------------------------------------------");
//		System.out.print("Please enter the csv name: ");
//		String csv_input = sc.nextLine();
//		
//		// Add our try catch or throw exception if csv file does not exist
//		
//	}
	
	
	// Option 6 : Quit
	private void quitting()
	{
		titleBanner("Goodbye");
		System.exit(0);
	}

}