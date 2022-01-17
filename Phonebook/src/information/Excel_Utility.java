package information;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


// Sources 
// https://www.geeksforgeeks.org/how-to-write-data-into-excel-sheet-using-java/
// https://www.youtube.com/watch?v=ipjl49Hgsg8 


public final class Excel_Utility {

	XSSFWorkbook workbook = new XSSFWorkbook();
	// to prevent object creation
	private Excel_Utility()
	{
		
	}
}
