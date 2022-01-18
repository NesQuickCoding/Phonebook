package information;

import java.util.*;

/**
 * Phonebook 
 * Purpose of this project is to demonstrate the use of HashMap in collecting, modifying, and deleting information. 
 * This project will be using interface in which our classes will implement. We have created a UI to demonstrate the use 
 * of our Phonebook program. 
 * 
 * Created: June 2, 2021
 * 
 * @author Neslie
 *
 */
public class Main {
	
	public static void main(String[] args)
	{

		 //ConsoleApp newSession = new ConsoleApp();
		 //newSession.start();
		
		
		ConsoleApp newSession = new ConsoleApp();
		newSession.start();

		/**
		// Testing Excel : Success
		List<String[]> sampleList = new ArrayList<String[]>();
		Map<String, PersonalInfo> map = new HashMap<>();
		
		String name = "Cody SpaghettiO";
		long num = 1234567890;
		PhoneNumber numero = new PhoneNumber(num);
		
		String em = "CodySpaghetti@Awesome.com";
		EmailAddress email = new EmailAddress(em);
		
		PersonalInfo newPerson = new PersonalInfo(numero,email);
		map.put(name, newPerson);
		
		Excel_Utility.createExcel(map);
		
		*/
		//System.out.println(map);
		
		/**
		String sampleValue = map.get(name).toString();
		//System.out.println(sampleValue);
		
		// This prints the Array out in String form
		System.out.println(Arrays.toString(CSV_Utility.splitValueToArray(sampleValue)));
		
		List<String[]> sampleAList = CSV_Utility.convertToList(map);
		*/
		// Still need to fix this
		//System.out.println(Arrays.toString(Arrays.toString(sampleAList)));
		//System.out.println(newList);
		
	
	}

}
