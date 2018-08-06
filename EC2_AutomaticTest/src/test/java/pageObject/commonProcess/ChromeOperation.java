package pageObject.commonProcess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**Chromeの操作のクラス
 * @author 土田
 *
 */
public class ChromeOperation {
	//宣言
	private WebDriver driver;

	/**コンストラクタ
	 * @param driver WebDriver
	 */
	public ChromeOperation(WebDriver driver) {
		this.driver = driver;
	}

	/**インフォバー非表示でのChromeの起動
	 * @return WebDriver
	 */
	public WebDriver setChrome() {
		//インスタンス化
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", "C:\\pleiades\\workspace\\webdriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 return driver;
	}

	/**ウィンドウサイズの最大化
	 *
	 */
	public void maximazeWindow() {
		driver.manage().window().maximize();
	}

	/**指定したURLへ移動
	 * @param url URL
	 */
	public void setURL(String url) {
		driver.get(url);
	}

	/**Chromeの終了
	 *
	 */
	public void quitChrome() {
		driver.quit();
	}
}
