package pageObject.EC2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**確認画面のPageObject
 * @author 土田
 *
 */
public class Confirm {
	//宣言
	private WebDriver driver;

	//WebElement定義
	//ボタン
	@FindBy(id = "registration")
	private WebElement btnToTopPage; //トップページへ
	
	//テキスト
	@FindBy(css = "body > div:nth-child(3) > p")
	private WebElement txtThankYou; //ご利用ありがとうございました

	/**コンストラクタ
	 * ページファクトリー定義
	 * @param driver
	 */
	public Confirm(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(this.driver, this);
	}

	/**トップページへボタンのクリックとインスタンスの取得
	 * @return インスタンス
	 */
	public TopPage clickBtnToTopPage() {
		btnToTopPage.click();
		
		//インスタンス化
		TopPage top = new TopPage(driver);
		return top;
	}
	
	/**ご利用ありがとうございましたのテキストの取得
	 * @return テキスト
	 */
	public String getTxtThankYou() {
		return txtThankYou.getText();
	}
}
