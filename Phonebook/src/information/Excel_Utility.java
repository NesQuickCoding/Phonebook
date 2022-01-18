package information;


import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;



// Sources 
// https://www.geeksforgeeks.org/how-to-write-data-into-excel-sheet-using-java/
// https://www.youtube.com/watch?v=ipjl49Hgsg8 
// https://www.youtube.com/watch?v=63IE7eHtR9s


public class Excel_Utility {

	
	// to prevent object creation
	private Excel_Utility()
	{
		
		
	} // end of ExcelUtility method
	
	public static void createExcel(Map<String, PersonalInfo> map)
	{
		try {
			Workbook workbook = new XSSFWorkbook();
			
			Sheet sh = workbook.createSheet("Sample");
					
			String[] colHeadings = {"Number", "Full Name", "Phone Number", "Email Address"};
			
			Font headerFont = workbook.createFont();
			
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short)12);
			headerFont.setColor(IndexedColors.BLACK.index);
			
			// Cell Style with font
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFont(headerFont);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
			
			// Header row 
			Row headerRow = sh.createRow(0);
			
			// Iterate over the column headings to create columns
			for(int i = 0; i < colHeadings.length; i++)
			{
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(colHeadings[i]);
				cell.setCellStyle(headerStyle);
			}
			
			// Fill our Data
			ArrayList<Line> Lines = createData(map);
			int rowNum = 1;
			for(Line line : Lines)
			{
				Row row = sh.createRow(rowNum);
				rowNum++;
				row.createCell(0).setCellValue(line.getNum());
				row.createCell(1).setCellValue(line.getName());
				row.createCell(2).setCellValue(line.getPhone());
				row.createCell(3).setCellValue(line.getEmail());
			}
			
			// Autosize the columns
			for(int i = 0; i < colHeadings.length; i++)
			{
				sh.autoSizeColumn(i);
			}

			// Write the output to file
			FileOutputStream fileOut = new FileOutputStream("C://Users//Nesli//Documents//GitHub//Phonebook/Phonebook//src//saved/Sample.xlsx");
			workbook.write(fileOut);
			
			fileOut.close();
			workbook.close();
			
			System.out.println("Complete");
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static ArrayList<Line> createData(Map<String, PersonalInfo> map) {
		// TODO Auto-generated method stub
		
		ArrayList<Line> line = new ArrayList<Line>();
		int i = 1; 
		for(Map.Entry<String, PersonalInfo> entry : map.entrySet())
		{
			line.add(new Line(i, entry.getKey(), entry.getValue().getPhoneNumber(), entry.getValue().getEmailAddress()));
			i++;
		}
		
		return line;
	}
	
	
}
