package information;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Utility class to help us with CSV
public final class CSV_Utility {

	// to prevent instantiation
	private CSV_Utility()
	{	
	}
	
	public static List<String[]> convertToList(Map<String, PersonalInfo> sampleMap)
	{
		List<String[]> sampleList = new ArrayList<String[]>();
	
		for(Map.Entry<String, PersonalInfo> map : sampleMap.entrySet())
		{
			// Split it to 3
			
			String name = (String)map.getKey();
			
			// Personal Info Value needs to be split
			String info = map.getValue().toString();
			
			String[] splitInfo = splitValueToArray(info);
			
			String[] stringArrayComp = fuse(name, splitInfo);
			
			sampleList.add(stringArrayComp);
		}
		
		
	return sampleList;
	}
	

	
	public static String[] splitValueToArray(String sampleString)
	{
		String[] ans = sampleString.split(",");
		return ans;
	}
	
	
	// Merges the key and values assuming we were able to split the value into two b elements
	// Returns a String Array that contains a,b0,b1
	public static String[] fuse(String a, String[] b)
	{
		String[] sampleArray = new String[3];
		
		sampleArray[0] = a;
		sampleArray[1] = b[0];
		sampleArray[2] = b[1];
		
		return sampleArray;
	}
	

	
	
}
