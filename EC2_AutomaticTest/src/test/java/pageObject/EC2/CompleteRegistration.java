package pageObject.EC2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**登録完了画面のPageObject
 * @author 土田
 *
 */
public class CompleteRegistration {
	//宣言
	private WebDriver driver;

	//WebElement定義
	//ボタン
	@FindBy(id = "registration")
	private WebElement toTopPage; //トップページへ

	@FindBy(css = "body > header > div.header00 > a > img")
	private WebElement veriserveRogo; //べりサーブのロゴ

	//テキスト
	@FindBy(css = "body > div:nth-child(3) > p")
	private WebElement arigatou; //ご利用ありがとうございました

	/**コンストラクタ
	 * ページファクトリー定義
	 * 正しいページかの確認
	 * @param driver
	 */
	public CompleteRegistration(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(this.driver, this);

		//正しいページかの確認
		String crrectTitle = "テスト実行者練習サイト（初級）";
		if (!driver.getTitle().equals(crrectTitle)) {
			throw new IllegalStateException("登録完了の画面ではありません。または見つかりません");
		}
	}

	/**「ご利用ありがとうございました」のテキストの取得
	 * @return テキスト
	 */
	public String getArigatou() {
		return arigatou.getText();
	}

	/**「トップページへ」ボタンのクリックとインスタンスの取得
	 * @return トップページのインスタンス
	 */
	public TopPage clickToTopPage() {
		toTopPage.click();
		//インスタンス化
		TopPage top = new TopPage(driver);
		return top;
	}

	/**べりサーブのロゴのクリックとインスタンスの取得
	 * @return トップページのインスタンス
	 */
	public TopPage clickRogo() {
		veriserveRogo.click();

		//インスタンス化
		TopPage top = new TopPage(driver);
		return top;
	}
}
