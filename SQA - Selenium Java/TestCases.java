package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestCases {
	static String email = "Your email";
	static String password = "Your password";
	
	static WebDriver driver = new ChromeDriver();
	static Actions actions = new Actions(driver);
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	static ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir"));
	static ExtentReports extent = new ExtentReports();
	static ExtentTest test = extent.createTest("AsanaTest", "Testing Asana Functionalities");
	
	public static void main(String[] args) {
		extent.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver.get("https://app.asana.com/0/1205793686627722/board");
		
		// login user
		userLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// create new project
		createProject();
		
		// create task
		createTask();
		
		// edit task
		editTask();
		
		// delete task
		deleteTask();
		
		// generate report
		extent.flush();
	}
	
	 // test case for user login
	static void userLogin() {
		try {
			// enter email
			WebElement emailInput = driver.findElement(By.name("e"));
			emailInput.sendKeys(email + Keys.ENTER);
			Assert.assertTrue(emailInput.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// enter password
			WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("p")));
			passwordInput.sendKeys(password + Keys.ENTER);
			Assert.assertTrue(passwordInput.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
	}
	
	//test case for creating a new project
	static void createProject() {
		try {
			// open new project tab
			driver.findElement(By.xpath("//h2[text()= 'Projects']")).click();
			WebElement newProjectMenu = driver.findElement(By.xpath("//div[@aria-label='New project or portfolio']"));
			newProjectMenu.click();
			Assert.assertTrue(newProjectMenu.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
				
		try {
			// click new project 
			WebElement newProjectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'New project']")));
			Assert.assertTrue(newProjectButton.isDisplayed());
			newProjectButton.click();
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// select blank project
			WebElement blacnkProject = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Blank project']")));
			Assert.assertTrue(blacnkProject.isDisplayed());
			blacnkProject.click();
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// project details 
			WebElement projectName = driver.findElement(By.id("new_project_dialog_content_name_input"));
			projectName.sendKeys("Moblie Application");
			Assert.assertTrue(projectName.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// select board
			WebElement boardButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'Board']")));
			boardButton.click();
			Assert.assertTrue(boardButton.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// create project
			WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Create project']")));
			Assert.assertTrue(createButton.isDisplayed());
			createButton.click();
			
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
	}
	
	static void createTask() {
		try {
			// add task
			WebElement addTaskButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Add task']")));
			addTaskButton.click();
			Assert.assertTrue(addTaskButton.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			WebElement taskName = driver.switchTo().activeElement();
			Assert.assertTrue(taskName.isDisplayed());
			taskName.sendKeys("Create login screen" + Keys.ENTER);
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
	}
	
	static void editTask() {
		try {
			// open task
			WebElement clickTask = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'Create login screen']")));
			clickTask.click(); 
			Assert.assertTrue(clickTask.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// add subtask
			WebElement clickSubtask = wait.until(ExpectedConditions.elementToBeClickable(By.className("ButtonTrain-item")));
			clickSubtask.click();
			Assert.assertTrue(clickSubtask.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// enter subtask
			WebElement addSubtask = driver.switchTo().activeElement();
			addSubtask.sendKeys("Make login UI");
			Assert.assertTrue(addSubtask.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// move tasks
			WebElement sectionMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'To do']")));
			sectionMenu.click();
			Assert.assertTrue(sectionMenu.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// select section
			WebElement selectSection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'In progress']")));
			Assert.assertTrue(selectSection.isDisplayed());
			selectSection.click();
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// add description 
			WebElement addDescription = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Description']")));
			addDescription.sendKeys("Create the front end of login screen" );
			Assert.assertTrue(addDescription.isEnabled());
		
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		actions.sendKeys(Keys.ESCAPE).build().perform();
		actions.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	static void deleteTask() {
		try {
			// delete task
			WebElement rightClick = driver.findElement(By.xpath("//span[text()= 'Create login screen']"));
			actions.contextClick(rightClick).build().perform();
			Assert.assertTrue(rightClick.isEnabled());
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
		
		try {
			// click delete
			WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'Delete task']")));
			Assert.assertTrue(deleteButton.isDisplayed());
			deleteButton.click();
			
			test.log(Status.PASS, "Test Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Test Failed: " + e.getMessage());
		}
	}
}