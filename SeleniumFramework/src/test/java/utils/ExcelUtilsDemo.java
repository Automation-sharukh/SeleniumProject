package utils;

public class ExcelUtilsDemo 
{
  public static void main(String[] args) 
  {
	 String ProjectPath =System.getProperty("user.dir");
	 ExcelUtils excel=new ExcelUtils(ProjectPath+"/excel/data.xlsx","Sheet1");
	 
	 excel.getRowCount();
	 excel.getCellDataString(1, 0);
	 excel.getCellDataNumber(1, 1);
  }
}
