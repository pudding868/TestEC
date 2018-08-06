package pageObject.EC2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**購入画面のPageObject
 * @author 土田
 *
 */
public class Purchase {
	//宣言
	private WebDriver driver;

	//WebElement定義
	//ボタン
	@FindBy(css = "body > div.boxcontainer > div:nth-child(1) > input")
	private WebElement btnInsertBasketBird; //鳥だけにエサ取り名人の「カゴに入れる」ボタン

	@FindBy(css = "body > div.boxcontainer > div:nth-child(2) > input")
	private WebElement btnInsertBasketCat; //猫ちゃんの素敵なまなざしの「カゴに入れる」ボタン

	@FindBy(css = "body > div.boxcontainer > div:nth-child(3) > input")
	private WebElement btnInsertBasketGorira; //Theゴリラくんの「カゴに入れる」ボタン

	@FindBy(css = "#sampleController > span.sampleA")
	private WebElement btnPlusBird; //鳥だけにエサ取り名人の「＋」ボタン

	@FindBy(css = "#sampleController > span.sampleB")
	private WebElement btnMinusBird; //鳥だけにエサ取り名人の「-」ボタン

	@FindBy(css = "#sampleController > span.sampleC")
	private WebElement btnPlusCat; //猫ちゃんの素敵なまなざしの「＋」ボタン

	@FindBy(css = "#sampleController > span.sampleD")
	private WebElement btnMinusCat; //猫ちゃんの素敵なまなざしの「-」ボタン

	@FindBy(css = "#sampleController > span.sampleE")
	private WebElement btnPlusGorira; //Theゴリラくんの「＋」ボタン

	@FindBy(css = "#sampleController > span.sampleF")
	private WebElement btnMinusGorira; //Theゴリラくんの「-」ボタン

	@FindBy(id = "registration")
	private WebElement btnKounyu; //「購入する」ボタンのクリック

	//テキスト
	@FindBy(css = "#sampleOutput1")
	private WebElement txtCountBird; //鳥だけにエサ取り名人のカウント

	@FindBy(css = "#sampleOutput2")
	private WebElement txtCountCat; //猫ちゃんの素敵なまなざしのカウント

	@FindBy(css = "#sampleOutput3")
	private WebElement txtCountGorira; //Theゴリラくんのカウント

	@FindBy(css = "#sampleOutput_number")
	private WebElement txtKosuGoukei; //個数合計

	@FindBy(css = "#price_total")
	private WebElement txtKingaguGoukei; //金額合計

	/**コンストラクタ
	 * ページファクトリー定義
	 * 正しいページかの確認
	 * @param driver
	 */
	public Purchase(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(this.driver, this);

		//正しいページかの確認
		if (!(driver.findElements(By.cssSelector("body > div.container.border > table > thead > tr > th"))
				.size() > 0)) {
			throw new IllegalStateException("商品購入の画面ではありません。または見つかりません");
		}
	}

	/**指定した回数、鳥だけにエサ取り名人の「＋」ボタンのクリック
	 * @param times 回数
	 */
	public void clickBtnPlusBird(int times) {
		for (int i = 0; i < times; i++) {
			btnPlusBird.click();
		}
	}

	/**指定した回数、鳥だけにエサ取り名人の「-」ボタンのクリック
	 * @param times 回数
	 */
	public void clickBtnMinusBird(int times) {
		for (int i = 0; i < times; i++) {
			btnMinusBird.click();
		}
	}

	/**指定した回数、猫ちゃんの素敵なまなざしの「＋」ボタンのクリック
	 * @param times 回数
	 */
	public void clickBtnPlusCat(int times) {
		for (int i = 0; i < times; i++) {
			btnPlusCat.click();
		}
	}

	/**指定した回数、猫ちゃんの素敵なまなざしの「-」ボタンのクリック
	 * @param times 回数
	 */
	public void clickBtnMinusCat(int times) {
		for (int i = 0; i < times; i++) {
			btnMinusCat.click();
		}
	}

	/**指定した回数、Theゴリラくんの「＋」ボタンのクリック
	 * @param times 回数
	 */
	public void clickBtnPlusGorira(int times) {
		for (int i = 0; i < times; i++) {
			btnPlusGorira.click();
		}
	}

	/**指定した回数、Theゴリラくんの「＋」ボタンのクリック
	 * @param times 回数
	 */
	public void clickBtnMinusGorira(int times) {
		for (int i = 0; i < times; i++) {
			btnMinusGorira.click();
		}
	}

	/**鳥だけにエサ取り名人の「かごに入れる」ボタンのクリック
	 *
	 */
	public void clickBtnInsertBasketBird() {
		btnInsertBasketBird.click();
	}

	/**猫ちゃんの素敵なまなざしの「かごに入れる」ボタンのクリック
	 *
	 */
	public void clickBtnInsertBasketCat() {
		btnInsertBasketCat.click();
	}

	/**Theゴリラくんの「かごに入れる」ボタンのクリック
	 *
	 */
	public void clickBtnInsertBasketGorira() {
		btnInsertBasketGorira.click();
	}

	/**「購入する」ボタンのクリックとインスタンスの取得
	 * @return 支払い情報入力画面のインスタンス
	 */
	public PaymentInfo clickBtnKounyu() {
		btnKounyu.click();
		//インスタンス化
		PaymentInfo pay = new PaymentInfo(driver);
		return pay;
	}

	/**鳥だけにエサ取り名人のカウントの値を取得
	 * @return カウント
	 */
	public String getTxtCountBird() {
		return txtCountBird.getText();
	}

	/**猫ちゃんの素敵なまなざしのカウントの値を取得
	 * @return カウント
	 */
	public String getTxtCountCat() {
		return txtCountCat.getText();
	}

	/**Theゴリラくんのカウントの値を取得
	 * @return カウント
	 */
	public String getTxtCountGorira() {
		return txtCountGorira.getText();
	}

	/**買い物カゴの中身の個数合計のテキストを取得する
	 * @return 個数合計
	 */
	public String getTxtKosuGoukei() {
		return txtKosuGoukei.getText();
	}

	/**買い物カゴの中身の金額合計のテキストを取得する
	 * @return 金額合計
	 */
	public String getTxtKingakuGoukei() {
		return txtKingaguGoukei.getText();
	}
}
