package Libraryfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class utilityclass 
{
	public static Sheet getsheet() throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\SSK\\eclipse-workspace\\Testing\\Test_Data\\CawStudio.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		return sh;
		
	}
}
