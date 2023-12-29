package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.LaunchBrowser;

public class data extends LaunchBrowser{
	
	
	@DataProvider(name = "searchbox")
	 public Object[][] getdatavalues(){
			return new Object[][] {
				{"categories", "saree"},
				{"categories", "Kurti"},
				{"categories", "smartwatch"}
					
				};
		}
		
	
	
	@Test(dataProvider = "searchbox")
	public void parametrizedtestmethod(String category, String categoryname) throws InterruptedException {
		Thread.sleep(6000);
		WebElement searchbx = driver.findElement(By.className("sc-jrcTuL epCzEc sc-cabOPr fWOCuC search-input-elm sc-cabOPr fWOCuC search-input-elm"));
		searchbx.sendKeys(categoryname, Keys.ENTER);
	}
	

	
	@Test()
	public String readdatafromExcel() throws IOException {
		String testdata = null;
		//Step 1: Open the Excel
		FileInputStream excel = new FileInputStream("path of the file to read");
		Workbook wb = new XSSFWorkbook(excel);
		Sheet sh = wb.getSheet("testdata");
		Iterator<Row> rowit = sh.iterator();
		while(rowit.hasNext()) {
			Row rowdata = rowit.next();
			Iterator<Cell> cellit = rowdata.iterator();
			while(cellit.hasNext()) {
				Cell celldata = cellit.next();
				DataFormatter formattedcelldata = new DataFormatter();
				testdata = formattedcelldata.formatCellValue(celldata);
			}
		}
		wb.close();
		excel.close();
		return testdata;
		
	}
	
	@Test()
	public void writedata() throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sh = wb.createSheet("");
		Row row = sh.createRow(0);
		Cell cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("");
		FileOutputStream file = new FileOutputStream("");
		wb.write(file);
		wb.close();
		file.close();
		
		
	}

}
