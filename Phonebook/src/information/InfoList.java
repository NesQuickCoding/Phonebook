package information;

import java.util.List;
import java.util.ArrayList;

// This will help us create a csv
public class InfoList {
	
	private List<String[]> infoList; 
	
	public InfoList()
	{
		this.infoList = new ArrayList<>();
	}
	
	
	public void addToList(String[] sampleArray)
	{
		this.infoList.add(sampleArray);
	}

	public List<String[]> getInfoList()
	{
		return this.infoList;
	}
	
	public int getInfoListSize()
	{
		return this.infoList.size();
	}
	
	

}
