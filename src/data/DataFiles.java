package data;

import utilities.Xls_Reader;

public class DataFiles {
	
	//Login Test Data
	Xls_Reader d = new Xls_Reader("C:\\testing\\NikulTest.xlsx");
	
	//Read this data from excel file
	
	public String emailWithSpecialChar = d.getCellData("Data1", "UserName", 4);
	public String wrongEmail = d.getCellData("Data1", "UserName", 3);
	public String wrongPassword = d.getCellData("Data1", "Password", 2);
	public String specialCharEmailError = d.getCellData("Data1", "Email Error", 5);
	public String emptyEmailError = d.getCellData("Data1", "Email Error", 4);
	public String emptyPasswordError = d.getCellData("Data1", "Password Error", 3);
	public String globalError = d.getCellData("Data1", "Global Error", 2);

	//HomeTest
	
	
	
	
	//FooterTest
	
	
	
	
	
	//AddToCartTest
	
	
	
	
	//UserProfile
	
	
	
	

}
