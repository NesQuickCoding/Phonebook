package information;

public class Address {
	private String address; 
	private String street; 
	private String city; 
	private String state; 
	private int zipcode; 
	
	
	public Address()
	{
	}
	
	public void setAddress()
	{
		this.address = this.street + "\n" + this.city + ", " + this.state + ", " + this.zipcode; 
	}
	
	
	public void setStreetAddress(String street)
	{
		this.street = street; 
	}
	
	public void setCity(String city)
	{
		this.city = city; 
	}
	
	public void setState(String state)
	{
		this.state = state; 
	}
	
	public void setZipCode(int zipcode)
	{
		this.zipcode = zipcode; 
	}

	
	public String getAddress()
	{
		return this.address;
	}
	
	public String getStreetAddress()
	{
		return this.street;
	}
	
	public String getCity()
	{
		return this.city; 
	}
	
	public String getState()
	{
		return this.state; 
	}
	
	public int getZipCode() {
		return this.zipcode; 
	}
	
	public String toString()
	{
		String header = "********Address**********"; 
		String footer = "*************************";
		
		return header + "\n" + this.getAddress() + "\n" + footer;
	}
}
