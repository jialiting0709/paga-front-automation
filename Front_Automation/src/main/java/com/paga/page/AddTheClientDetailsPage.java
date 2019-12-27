package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTheClientDetailsPage extends BasePage{

	public AddTheClientDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位HQ header搜索框
	@FindBy(xpath="//form/p[1]/mat-form-field[1]/div/div[1]/div[3]/input")
	private WebElement HQ_header;
	
	//定位HQ code搜索框第一项
	@FindBy(xpath="//mat-pseudo-checkbox")
	private WebElement HQ_header_mat_option;
	
	//定位HQ Code下拉按钮
	@FindBy(xpath="//form/p[1]/mat-form-field[2]/div/div[1]/div[3]/mat-select/div/div[2]")
	private WebElement HQ_code;
	
	//定位HQ code搜索框第一项
	@FindBy(xpath="//mat-option")
	private WebElement HQ_code_mat_option;

	
	//定位Guideline Set下拉按钮
	@FindBy(xpath="//form/p[3]/mat-form-field/div/div/div[3]/mat-select/div/div[2]")
	private WebElement Guideline_Set;
	
	//定位Guideline Set第一项
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/mat-option")
	private WebElement Guideline_Set_mat_option;
	
	//定位Guideline Code下拉按钮
	@FindBy(xpath="//form/p[3]/mat-form-field[2]/div/div/div[3]/mat-select/div/div[2]")
	private WebElement Guideline_Code;
	
	//定位Guideline Set第一项
	@FindBy(xpath="//body/div[2]/div[2]/div/div/div/mat-option/span")
	private WebElement Guideline_Code_mat_option;
	
	//定位number Of Guidelines输入框
	@FindBy(xpath="//*[@ng-reflect-name='numberOfGuidelines']")
	private WebElement number_Of_Guidelines;
	
	//定位effectiveDate输入框
	@FindBy(xpath="//*[@ng-reflect-name='effectiveDate']")
	private WebElement effective_Date;
	
	//定位HQ Header第一项
	@FindBy(xpath="//body/div[2]/div/div/div/mat-option")
	private WebElement MDT;
	
	//点选MDT
	public void clisk_MDT(){
		this.click(MDT);
	}
	
	//输入effectiveDate
	public void send_effective_Date(String s){
		this.sendkeys(effective_Date, s);
	}
	
	
	//输入number Of Guidelines
	public void send_number_Of_Guidelines(String s){
		this.sendkeys(number_Of_Guidelines, s);
	}
	
	//点击Guideline Set下拉列表第一项
	public void click_Guideline_Code_mat_option(){
		this.click(Guideline_Code_mat_option);
	}
	
	//点击Guideline Set下拉列表
	public void click_Guideline_Code(){
		this.click(Guideline_Code);
	}

	//点击Guideline Set下拉列表第一项
	public void click_Guideline_Set_mat_option(){
		this.click(Guideline_Set_mat_option);
	}
	
	//点击Guideline Set下拉列表
	public void click_Guideline_Set(){
		this.click(Guideline_Set);
	}
		

	//点击HQ code搜索框第一项
	public void click_mat_option_code(){
		this.click(HQ_header_mat_option);
	}
	
	//点击HQ Code搜索框
	public void click_HQ_code(){
		this.click(HQ_code);
	}
	
	//点击HQ header搜索框
	public void click_HQ_header(){
		this.click(HQ_header);
	}
	//点击HQ header输入M
	public void input_HQ_header(String s){
		this.sendkeys(HQ_header, s);
	}
	

}
