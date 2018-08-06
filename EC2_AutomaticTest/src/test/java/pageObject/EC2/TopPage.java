package pageObject.EC2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**テスト実行者練習サイトのトップページのPageObject
 * @author 土田
 *
 */
public class TopPage {
	//宣言
	private WebDriver driver;

	//WebElement定義
	//ボタン
	@FindBy(css = "body > header > div.header-part > a.square_btn1")
	private WebElement btnKaiintouroku; //会員登録

	@FindBy(id = "registration")
	private WebElement btnTouroku; //登録

	@FindBy(css = "body > div.swiper-container2.swiper-container-horizontal > div.swiper-wrapper > div.swiper-slide.swiper-slide-next > a > div")
	private WebElement btnLookProductUnderCat; //商品を見る（猫の画像の下）

	//テキストボックス
	@FindBy(id = "account_username")
	private WebElement tbxUserName; //ユーザ名

	@FindBy(id = "account_password")
	private WebElement tbxPasswordNew; //パスワード

	@FindBy(id = "account_password_confirm")
	private WebElement tbxPasswordConfirm; //パスワード（確認用）

	//テキスト
	@FindBy(css = "#kaiin > h2")
	private WebElement txtKaiintouroku; //会員登録

	/**コンストラクタ
	 * ページファクトリー定義
	 * 正しいページかの確認
	 * @param driver
	 */
	public TopPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(this.driver, this);

		//正しいページかの確認
		String crrectTitle = "テスト実行者練習サイト（初級）";
		if (!driver.getTitle().equals(crrectTitle)) {
			throw new IllegalStateException("トップページの画面ではありません。または見つかりません");
		}
	}

	/**「会員登録」ボタンのクリック
	 *
	 */
	public void clickKaiinTouroku() {
		btnKaiintouroku.click();
	}

	/**「会員登録」ボタンのクリックとインスタンスの取得
	 * @return 登録完了画面のインスタンス
	 */
	public CompleteRegistration clickTouroku() {
		btnTouroku.click();

		//インスタンス化
		CompleteRegistration compReg = new CompleteRegistration(driver);
		return compReg;
	}

	/**猫の画像の下の「商品を見る」ボタンのクリックとインスタンスの取得
	 * @return
	 */
	public Purchase clickBtnLookProductCat() {
		btnLookProductUnderCat.click();
		//インスタンス化
		Purchase purchase = new Purchase(driver);
		return purchase;
	}

	/**ウィンドウのスクロール位置の取得
	 * @return スクロール位置
	 */
	public int getScrollPosition() {
		int scroll = Integer.parseInt(String
				.valueOf(((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollTop")));
		return scroll;
	}

	/**「ユーザ名」の入力
	 * @param name
	 */
	public void sendUserName(String name) {
		tbxUserName.sendKeys(name);
	}

	/**パスワードの入力
	 * @param password パスワード
	 */
	public void sendPasswordNew(String password) {
		tbxPasswordNew.sendKeys(password);
	}

	/**パスワード（確認用）の入力
	 * @param password
	 */
	public void sendpasswordConfirm(String password) {
		tbxPasswordConfirm.sendKeys(password);
	}

	/**「会員登録」のテキストの取得
	 * @return テキスト
	 */
	public String getTxtKaiintouroku() {
		return txtKaiintouroku.getText();
	}
}
