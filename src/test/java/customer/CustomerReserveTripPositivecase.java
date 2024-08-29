package customer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CustomerReserveTripPositivecase {
	private AndroidDriver<MobileElement> driver;
	@BeforeClass
	public void DeviceSetup() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "OnePlus 7T");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("appPackage", "com.moniic.customer.pp");
		capabilities.setCapability("appActivity", "com.moniic.customer.MainActivity");
		capabilities.setCapability("deviceID", "a36a1285");

		driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("CUSTOMER APP LAUNCHED SUCCESSFULLY");

	}
	@Test
	public void testSkipBtn() throws InterruptedException {
		WebElement skipbtn=driver.findElement(By.className("android.widget.Button"));
		skipbtn.click();
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods= {"testSkipBtn"})
	public void testDropdownBtn1() throws InterruptedException {
		WebElement cDropDownBtn= driver.findElement(By.xpath("//android.widget.TextView[@bounds=\"[251,495][296,540]\"]"));
		cDropDownBtn.click();
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods= {"testDropdownBtn1"})
	public void testSearchCountry() throws InterruptedException {
		WebElement searchBtn = driver.findElement(By.className("android.widget.EditText"));
		searchBtn.sendKeys("india");
		WebElement indiaBtn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\r\n" ));
		indiaBtn.click();
		WebElement numWidget= driver.findElement(By.className("android.widget.EditText"));
		numWidget.sendKeys("9443527443");
		Thread.sleep(3000);
		WebElement cnBtn1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button"));
		cnBtn1.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}
	@Test(dependsOnMethods= {"testSearchCountry"})
	public void testOnOTP() throws InterruptedException, IOException {
		WebElement otpNumBox1=driver.findElement(By.xpath("//android.view.ViewGroup[@bounds=\"[68,521][193,646]\"]"));
		otpNumBox1.click();
		Thread.sleep(600);
		String adbCommand = "adb shell input text 2";
		executeADBCommand(adbCommand);
		String adbCommand1 = "adb shell input text 3";
		executeADBCommand(adbCommand1);
		String adbCommand2 = "adb shell input text 4";
		executeADBCommand(adbCommand2);
		String adbCommand3 = "adb shell input text 8";
		executeADBCommand(adbCommand3);
		String adbCommand4 = "adb shell input text 7";
		executeADBCommand(adbCommand4);
		String adbCommand5= "adb shell input text 6";
		executeADBCommand(adbCommand5);
		Thread.sleep(3000);
	}
	private void executeADBCommand(String adbCommand) throws InterruptedException, IOException {
		Process process = Runtime.getRuntime().exec(adbCommand);
		process.waitFor();
		
	}
	@Test(dependsOnMethods= {"testOnOTP"})
	public void testOnReserveRide() throws InterruptedException {
		WebElement devicemapWidget = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
		devicemapWidget.click();
		Thread.sleep(3000);

		WebElement locBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds=\"[927,1154][970,1197]\"]"));
		locBtn.click();
		Thread.sleep(6000);
		WebElement reserveBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Reserve']"));
		reserveBtn.click();
		Thread.sleep(6000);
	}
	@Test(dependsOnMethods= {"testOnReserveRide"})
	public void testOnScheduleRideTime() throws InterruptedException {
		new TouchAction<>(driver)
		.press(PointOption.point(492, 1822))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(489, 1716))
		.release()
		.perform();
		Thread.sleep(1000);
		new TouchAction<>(driver)
		.press(PointOption.point(492, 1822))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(489, 1716))
		.release()
		.perform();
		Thread.sleep(1000);
		new TouchAction<>(driver)
		.press(PointOption.point(595, 1825))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(602, 1726))
		.release()
		.perform();
		Thread.sleep(1000);
		new TouchAction<>(driver)
		.press(PointOption.point(697, 1822))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(701, 1709))
		.release()
		.perform();
		Thread.sleep(1000);

		WebElement proceedBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='PROCEED']"));
		proceedBtn.click();
		Thread.sleep(6000);
	}
	@Test(dependsOnMethods= {"testOnScheduleRideTime"})
	public void testSearchandLoc()throws InterruptedException {

		WebElement destiBox = driver.findElement(By.xpath("//android.widget.TextView[@bounds=\"[223,2069][966,2133]\"]"));
		destiBox.click();
		Thread.sleep(3000);
		WebElement searchdrplLoc1 = driver.findElement(By.xpath("//android.widget.EditText[@bounds=\"[183,338][856,457]\"]"));
		searchdrplLoc1.sendKeys("AI twar centre");
		WebElement drplLoc=driver.findElement(By.xpath("//android.view.ViewGroup[@bounds=\"[0,663][1080,897]\"]"));
		drplLoc.click();
		Thread.sleep(3000);
		WebElement conpkp=driver.findElement(By.xpath("//android.widget.TextView[@text='CONFIRM']"));
		conpkp.click();
		Thread.sleep(3000);
		WebElement conpkpPoint=driver.findElement(By.xpath("//android.widget.TextView[@bounds='[424,2147][655,2208]']"));
		conpkpPoint.click();
		Thread.sleep(3000);

	}
	@Test(dependsOnMethods= {"testSearchandLoc"})
	public void testOnAPUNote() throws InterruptedException {
		WebElement apuNotes = driver.findElement(By.xpath("//android.widget.Button[@bounds=\"[69,1410][1011,1548]\"]"));
		apuNotes.click();
		Thread.sleep(3000);

		WebElement flNum = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your flight number']"));
		flNum.sendKeys("Boeing 747");
		Thread.sleep(1000);

		WebElement traName = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter the traveler name']"));
		traName.sendKeys("Mohammed sajil");
		Thread.sleep(1000);

		WebElement othrNotes = driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Eg: I need a child seat, I need help with my bags...')]"));
		othrNotes.sendKeys("I need a Pet Box ");
		Thread.sleep(1000);


		WebElement chfcnBtn = driver.findElement(By.xpath("//android.widget.Button[@index='1' and @clickable='true' and @enabled='true']"));
		chfcnBtn.click();
		Thread.sleep(3000);
		WebElement proceedBtn = driver.findElement(By.xpath("//android.widget.Button[@class='android.widget.Button' and @clickable='true' and @enabled='true' and @index='2']"));
		proceedBtn.click();
		Thread.sleep(6000);
	}
	@Test(dependsOnMethods= {"testOnAPUNote"})
	public void testOnCarchoose() throws InterruptedException {
		WebElement carChoose = driver.findElement(By.xpath("//android.widget.TextView[@text='First Class']"));
		carChoose.click();
		Thread.sleep(3000);
		
		WebElement bookclassBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[87,2157][993,2208]']"));
		bookclassBtn.click();
		Thread.sleep(3000);
	
		
	}
	@Test (dependsOnMethods= {"testOnCarchoose"})
	public void testOnPaymentMode() throws InterruptedException {
		WebElement cCashWdt = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[83,1798][166,1881]']"));
		cCashWdt.click();
		Thread.sleep(1000);

		WebElement cnfrmCashBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='CONFIRM']"));
		cnfrmCashBtn.click();
		Thread.sleep(3000);

		
	}
	@Test(dependsOnMethods= {"testOnPaymentMode"})
	public void testOnconfirmClass() {
		WebElement bookclassBtn2 = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[87,2157][993,2208]']"));
		bookclassBtn2.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test(dependsOnMethods= {"testOnconfirmClass"})
	public void testOnFinalCon() throws InterruptedException {
		WebElement okBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		okBtn.click();
		Thread.sleep(3000);
	}
	@AfterClass 
	public void tearDown() {
	
			driver.quit();
		
	}
}
