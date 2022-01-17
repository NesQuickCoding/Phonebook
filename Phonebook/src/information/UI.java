package information;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI {
	
	
	private Map<String, PersonalInfo> phonebookMap; 
	private Scanner sc; 

	
	public UI()
	{
		this.phonebookMap = new HashMap<String, PersonalInfo>();
		this.sc = new Scanner(System.in);
	}


	/***********************************************************************/	
	// Start
	/***********************************************************************/	
	
	public void start()
	{
		titleBanner("Welcome to Phonebook");
		
		// activate menu
		menu();

		// activate command  
		command();
	} // end of start method 
	
	
	
	/***********************************************************************/	
	// Main Menu
	/***********************************************************************/	
	public void menu()
	{
		titleBanner("Main Menu");
		System.out.println("Available Operations:");
		System.out.println("1 - Add a New Person");
		System.out.println("2 - Search for Personal Information");
		System.out.println("3 - Update Personal info");
		System.out.println("4 - Delete Person from Phonebook");
		System.out.println("5 - Display Listing");
		System.out.println("6 - Export as CSV");
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
						
			case 6:
				System.out.println("Exporting as CSV");
				
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
	
	
	
	/***********************************************************************/	
	// Option 1 : Add a New Person
	/***********************************************************************/	
		private void addNewPerson()
		{
		
			titleBanner("Adding New Person");
			
			String name = addValidName();
			
			PhoneNumber newNumber = addPhoneNumber(name);
			
			EmailAddress newEmail = addEmailAddress(name);
			
			// now we add this to our HashMap
			phonebookMap.put(name, new PersonalInfo(newNumber, newEmail));
			
			banner();
		} // end of addNumber method 
		
		
		// Option 1 > Add New Person > Add Name
		// This method will be used plenty of times 
		private String addValidName()
		{
			System.out.print("Please enter the first name: ");
			String firstName = nameValidity(sc.nextLine());
			
			System.out.print("Please enter the last name: ");
			String lastName = nameValidity(sc.nextLine());
			
			
			String fullname = firstName + " " + lastName;
			
			return fullname;	
		} // end of addValidName method 
		
		
		// Option 1 > Add New Person > Add Phone Number
		private PhoneNumber addPhoneNumber(String name)
		{
			titleBanner("Adding Phone Number");
			System.out.println("Please enter " + name + "'s Phone Number");
			
			String phone = sc.nextLine();
			PhoneNumber newPhone = phoneNumberValidity(name, phone);		
			banner();
			
			return newPhone;
		} // end of addPhoneNumber method 
		
		

		
		
		// Option 1 > Add New Person > Add Email Address
		private EmailAddress addEmailAddress(String name)
		{
			titleBanner("Adding Email Address");
			System.out.println("Please enter " + name + "'s Email Address");
			
			String email = sc.nextLine();
			EmailAddress newEmail = emailValidity(name, email);
			
			banner();
			return newEmail;
		} // end of addEmailAddress method
		
		
	/***********************************************************************/	
	// Option 2 : Search for Personal Information 
	/***********************************************************************/	
		
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
				String name = addValidName();
				boolean found = false;
				

						for(String n : this.phonebookMap.keySet())
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

			for(String n : this.phonebookMap.keySet())
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
			
		} // end of searchByPhoneNumber method
		
		// Option 2: Search For Personal Info > Search By Email
		private void searchByEmail()
		{
			titleBanner("Searching by Email");
			System.out.print("Please enter the persons Email Address: ");
			String email = sc.nextLine();
			boolean found = false; 

			for(String n : this.phonebookMap.keySet())
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
		

	/***********************************************************************/	
	// Option 3 : Update Personal Info
	/***********************************************************************/
	
	// Better Approach
	private void updatePI(String name)
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
			updateNameMenu(name);
			break;
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
	} // end of updatePI method 
	
	
	private void updateNameMenu(String name)
	{
		banner();
		System.out.println("Choose Part of the name to update for: " + name);
		banner();
		
		System.out.println("Enter 1 to update First Name");
		System.out.println("Enter 2 to update Last Name");
		System.out.println("Enter 3 to update Full Name");
		System.out.println("Enter 0 to go back to Main Menu");
		
		System.out.print("Command: ");
		String comm = sc.nextLine();
	
		switch(comm)
		{
		case "1":
			updateFirstName(name);
			break;
		case "2":
			updateLastName(name);
			break;
		case "3":
			updateFullName(name);
			break;
		case "0":
			commandMenu();
			break;
			
		default: 
			System.out.println("Wrong input, please try again");
			updatePI(name);
		}
		
	}
	
	
	private void updateFirstName(String name)
	{
		PersonalInfo temp = this.phonebookMap.get(name);
	
		// separate the lastName
		String lastName = name.split(" ")[1];
	
		String newName = updateValidName(name, "first");
		
		newName = newName + " " + lastName;
		
		// remove the old from our map
		this.phonebookMap.remove(name);
		
		// add the new from our map 
		this.phonebookMap.put(newName, temp);
		
		displayUpdatedName(name, newName);
	}
	
	private void updateLastName(String name)
	{
		PersonalInfo temp = this.phonebookMap.get(name);
		
		// separate the first name
		String firstName = name.split(" ")[0];
		
		String newName = updateValidName(name, "last");
		
		newName = firstName + " " + newName;
		
		this.phonebookMap.remove(name);
		
		this.phonebookMap.put(newName, temp);
		
		displayUpdatedName(name, newName);
	}
	
	private void updateFullName(String name)
	{
		PersonalInfo temp = this.phonebookMap.get(name);
		
		String firstName = updateValidName(name, "first");
		String lastName = updateValidName(name, "last");
		
		String newName = firstName + " " + lastName;
		
		this.phonebookMap.remove(name);
		
		this.phonebookMap.put(newName, temp);
		
		displayUpdatedName(name, newName);
	}
		
	
	private String updateValidName(String name, String type)
	{
		String message = String.format("Please enter %s's new %s name: ", name, type);
		System.out.print(message);
		String newName = nameValidity(sc.nextLine());

		return newName;	
	} // end of addValidName method 
	
	private void displayUpdatedName(String oldName, String newName)
	{
		String message = String.format("Name Updated: From %s to %s",oldName, newName);
		System.out.println(message);
	}
	
	
	private void updatePerson()
	{
		
		String newName = addValidName();
		boolean found = false; 
		
		
			for(String n: this.phonebookMap.keySet())
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
	

	private void updatePhoneNumber(String name)
	{
		PhoneNumber newNumber = addPhoneNumber(name);
		// now we add this to our HashMap
		this.phonebookMap.get(name).setPhoneNumber(newNumber);
		String message = String.format("%'s phone number has been updated.", name);
		System.out.println(message);
	} // end of updatePhoneNumber method 
	
	
	private void updateEmailAddress(String name)
	{
		EmailAddress newEmail = addEmailAddress(name);
		
		this.phonebookMap.get(name).setEmailAddress(newEmail);;

		String message = String.format("%s's email address has been updated.", name);
		System.out.println(message);
	} // end of updateEmailAddress method 
	

		
	/***********************************************************************/	
	// Option 4 : Delete Person from Phonebook
	/***********************************************************************/	
	
		// Option 4: Delete Person from Phone Book 
		private void deletePerson()
		{
			titleBanner("Deleting Person from Phonebook");
			
			String name = validNameFromMap();
			this.phonebookMap.remove(name);
		
			String message = String.format("%s has been deleted from Phonebook", name);
			System.out.println(message);
			banner();
			
		} // end of deletePerson
		
		
	/***********************************************************************/	
	// Option 5 : Display Listing
	/***********************************************************************/		
		
	private void displayListing()
	{
		titleBanner("Display Phonebook Information");
		String message = String.format("Phonebook size: %s", this.phonebookMap.size());
		System.out.println(message);

		if(this.phonebookMap.isEmpty())
		{
			System.out.println("Phonebook Empty");
		}
		else {
			List<String> names = sortKeys(this.phonebookMap);
			
			for(String name : names)
			{
				displayInfo(name);
			}
		} 
		banner();
	
		
	} // end of displayListing method 
		
	/***********************************************************************/	
	// Option 6 : Export as CSV
	/***********************************************************************/		

	/***********************************************************************/	
	// Option 0 : Quit
	/***********************************************************************/	
	
	private void quitting()
	{
		titleBanner("Goodbye");
		System.exit(0);
	}

	
	/***********************************************************************/	
	// Display Info
	/***********************************************************************/	
	
	private void displayInfo(String name)
	{

		banner();
		displayName(name);
		displayNumber(name);
		displayEmail(name);

	} // end of displayInfo method 
	
	public void displayName(String name)
	{
		System.out.println("Name: " + name);
	} // end of displayName method 
	
	public void displayNumber(String name)
	{
		System.out.println("Phone Number: " + convertNumber(this.phonebookMap.get(name).getPhoneNumber()));
	} // end of displayNumber method 
	
	public void displayEmail(String name)
	{
		System.out.println("Email Address: " + this.phonebookMap.get(name).getEmailAddress());
	} // end of displayEmail method 

	
	
	
	/***********************************************************************/	
	// Conversion
	/***********************************************************************/	
	
	private String convertNumber(long num)
	{
		String number = Long.toString(num);
		
		// Reference https://howtodoinjava.com/java/string/format-phone-number/
		String updatedNumber = number.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
		
		return updatedNumber;
	} // end of convertNumber method 
	
	
	
	/***********************************************************************/	
	// Input
	/***********************************************************************/	
	
	private String inputNumber(String name)
	{
		String message = String.format("Please enter %s's phone number", name);
		System.out.println(message);
		String input = sc.nextLine();
		
		return input;
	}
	
	/***********************************************************************/	
	// Validity
	/***********************************************************************/	
	
	// To ensure the name entered is valid
		// This can be use for both first name and last name
		private String nameValidity(String name)
		{
			while(!isValidName(name))
			{
				System.out.println("Sorry entered name is invalid, please try again");
				name = sc.nextLine();
			}
			
			return name;
		}
		
		// Checks whether a name is valid based on regex pattern
		// returns a boolean
		private boolean isValidName(String name)
		{
			Pattern validNamePattern = Pattern.compile("[a-zA-Z]*");
			Matcher matcher = validNamePattern.matcher(name);
			
			return matcher.matches();
		} // end of isValidName method 
		
		
		// checks whether the entered name is in our dictionary 
		private String validNameFromMap()
		{
			String newName = addValidName();
			
			while(!this.phonebookMap.containsKey(newName))
			{
				System.out.println("Name cannot be found in our Phonebook");
				System.out.println("Please try again");
				newName = addValidName();
			}
			
			return newName;
		} // end of validNameFromMap method 

		
		// To ensure us that the email entered is correct 
				private EmailAddress emailValidity(String name, String email)
				{
					EmailAddress newEmail = new EmailAddress(email);
					
							// loop it until they enter a valid email address
							while(!newEmail.validEmail(email))
							{
								System.out.println("Invalid Email Address");
								System.out.println("Please try again");
								System.out.println("Please enter " + name + "'s Email Address");
								email = sc.nextLine();

							}
								newEmail.setEmailAddress(email);
								
					return newEmail;
				} // end of emailValidity method
				
				// To ensure the phoneNumber method is correct
				private PhoneNumber phoneNumberValidity(String name, String phone)
				{
					
					while(phone.length() < 10)
					{
						System.out.println("Invalid Phone Number length please try again");
						phone = inputNumber(name);
						
					}
				
					PhoneNumber newPhone = new PhoneNumber();
					
					while(!newPhone.validNumber(phone))
					{
						System.out.println("Invalid Phone Number");
						System.out.println("Please try again");
						phone = inputNumber(name);
					}
					
					newPhone.setNumber(Long.parseLong(phone));
					
					return newPhone;

				} // end of phoneNumberValidity method 
				
					
		/***********************************************************************/	
		// For Display Purpose
		/***********************************************************************/
		
		
		public void tBanner()
		{
			System.out.println("======================================================");
		}
						
		public void banner()
		{
			System.out.println("------------------------------------------------------");
		}
		
		public void titleBanner(String sampleTitle)
		{
			tBanner();
			System.out.println(String.format("\t\t%s",sampleTitle));
			tBanner();
		}
		
		/***********************************************************************/	
		// Sorting
		/***********************************************************************/	
		private List<String> sortKeys(Map<String, PersonalInfo> map2)
		{
			// Reference
			//https://stackoverflow.com/questions/922528/how-to-sort-map-values-by-key-in-java
			List<String> sortedKeys = new ArrayList<String>(map2.keySet());
			Collections.sort(sortedKeys);
			
			return sortedKeys;
		} // end of sortMap method 
		
		/***********************************************************************/	
		// Unused Methods
		/***********************************************************************/				
		private boolean isValidCommand(String comm, int num)
		{
			// convert the String into a int 
			int userCommandInt = Integer.parseInt(comm);
			
			if(userCommandInt >= 0 && userCommandInt <= num)
			{
				return true;
			}
			
			return false; 
		} // end of isValidCommand method 
				
		/***********************************************************************/	
		// To Do
		/***********************************************************************/
		// Still need to export as CSV 
		// Safety
		// Numbers cannot match with pre existing 
		// Email cannot match with pre existing
		// Display Listing, have it display options: only names, only numbers, only emails
	
} // end
