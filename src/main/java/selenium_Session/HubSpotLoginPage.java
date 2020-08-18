package selenium_Session;

public class HubSpotLoginPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebdriverFactory wf = new WebdriverFactory();
		String browser = "chrome";
		String url = "https://app.hubspot.com/login";
		
		wf.launchBrowser(browser);
		wf.launchUrl(url);
		
		Thread.sleep(3000);
		
		String title = wf.gettitle();
		System.out.println("Page Title is: " +title);
		
		if(title.equals("Checking browser"))
			System.out.println("Correct Title");
		
		else
			System.out.println("Incorrect Title");
		
		wf.getPageCurrentUrl(url);
		System.out.println(url);
		
		wf.closeBrowser();
		
	}
	 
	

}
