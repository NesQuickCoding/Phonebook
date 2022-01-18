package information;

public class Line {
	
	private int num;
	private String name;
	private String phone;
	private String email;
	
	public Line(int num, String name, long phone, String email)
	{
		this.num = num;
		this.name = name;
		this.phone = convertNumber(phone);
		this.email = email;
	}
	
	// Getters
	public int getNum()
	{
		return this.num;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	private String convertNumber(long num)
	{
		String number = Long.toString(num);
		
		// Reference https://howtodoinjava.com/java/string/format-phone-number/
		String updatedNumber = number.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
		
		return updatedNumber;
	}
	
	

}
