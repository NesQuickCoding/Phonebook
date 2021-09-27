package information;

public class PhoneNumber {
	private int number; 
	
	public PhoneNumber()
	{
	}
	
	public PhoneNumber(int number)
	{
		this.number = number; 
	}
	
	public void setNumber(int number)
	{
		this.number = number; 
	}
	
	public int getNumber()
	{
		return this.number; 
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
