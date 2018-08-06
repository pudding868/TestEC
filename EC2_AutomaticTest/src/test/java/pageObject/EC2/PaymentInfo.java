package pageObject.EC2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.DateArithmetic;

/**支払い情報入力画面のPageObject
 * @author 土田
 *
 */
public class PaymentInfo {
	//宣言
	private WebDriver driver;

	//WebElement定義
	//テキストボックス
	@FindBy(id = "zip")
	private WebElement tbxPostalCode; //郵便番号

	@FindBy(id = "town")
	private WebElement tbxTown; //市区町村/番地

	@FindBy(id = "building")
	private WebElement tbxBuilding; //マンション名

	@FindBy(id = "name_kanji_family")
	private WebElement tbxNameKanjiFamily; //お名前（漢字）の姓

	@FindBy(id = "name_kanji_given")
	private WebElement tbxNameKanjiGiven; //お名前（漢字）の名

	@FindBy(id = "name_kana_family")
	private WebElement tbxNameKanaFamily; //お名前（よみがな）の姓

	@FindBy(id = "name_kana_given")
	private WebElement tbxNameKanaGiven; //お名前（よみがな）の名

	@FindBy(id = "tel")
	private WebElement tbxTelNumber; //電話番号

	@FindBy(id = "email")
	private WebElement tbxEmailAddress; //メールアドレス

	@FindBy(id = "datepicker")
	private WebElement tbxDeliveryDate; //お届け日時の日付

	@FindBy(id = "other")
	private WebElement tbxDentatu; //伝達事項

	@FindBy(id = "contact")
	private WebElement tbxKaiinRenraku; //会員様連絡

	//ボタン
	@FindBy(id = "confirm_dg")
	private WebElement btnToConfirm; //確認へ

	//ラジオボタン
	@FindBy(css = "body > div.container > form > div:nth-child(9) > div")
	private WebElement rbtnSex; //性別

	//チェックボックス
	@FindBy(css = "body > div.container > form > div:nth-child(15) > div > input:nth-child(2)")
	private WebElement cbxRibon; //リボン

	@FindBy(css = "body > div.container > form > div:nth-child(15) > div > input:nth-child(4)")
	private WebElement cbxNosi; //のし

	@FindBy(css = "body > div.container > form > div:nth-child(15) > div > input:nth-child(6)")
	private WebElement cbxLetter; //レター

	//プルダウン
	@FindBy(id = "pref")
	private WebElement pdwnPrefecture; //都道府県

	@FindBy(id = "timepicker")
	private WebElement pdwnDeliveryTime; //お届け日時の時間指定

	//テキスト
	@FindBy(css = "body > div.container > div > h2")
	private WebElement txtTitle; //タイトルのテキスト

	@FindBy(id = "email_confirm")
	private WebElement txtEmailConfirm; //メールアドレスのご確認

	/**コンストラクタ
	 * ページファクトリー定義
	 * 正しいページかの確認
	 * @param driver
	 */
	public PaymentInfo(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(this.driver, this);

		//正しいページかの確認
		if (!(driver.findElements(By.cssSelector("body > div.container > div > h2")).size() > 0)) {
			throw new IllegalStateException("支払い情報入力画面ではありません、または見つかりません");
		}
	}

	/**郵便番号の入力
	 * @param posCode 郵便番号
	 */
	public void sendPostalCode(String posCode) {
		tbxPostalCode.sendKeys(posCode);
	}

	/**市区町村/番地の入力
	 * @param townName 市区町村/番地
	 */
	public void sendTownName(String townName) {
		tbxTown.sendKeys(townName);
	}

	/**マンション名の入力
	 * @param buildingName マンション名
	 */
	public void sendbuildingName(String buildingName) {
		tbxBuilding.sendKeys(buildingName);
	}

	/**お名前（漢字）の姓の入力
	 * @param nameKanziFamily 姓名（漢字）
	 */
	public void sendNameKanjiFamily(String nameKanziFamily) {
		tbxNameKanjiFamily.sendKeys(nameKanziFamily);
	}

	/**お名前（漢字）の名の入力
	 * @param nameKanziFamily 名（漢字）
	 */
	public void sendNameKanjiGiven(String nameKanziGiven) {
		tbxNameKanjiGiven.sendKeys(nameKanziGiven);
	}

	/**お名前（ひらがな）の姓の入力
	 * @param nameKanziFamily 姓名（ひらがな）
	 */
	public void sendNameKanaFamily(String nameKanaFamily) {
		tbxNameKanaFamily.sendKeys(nameKanaFamily);
	}

	/**お名前（ひらがな）の名の入力
	 * @param nameKanziFamily 名（ひらがな）
	 */
	public void sendNameKanaGiven(String nameKanaGiven) {
		tbxNameKanaGiven.sendKeys(nameKanaGiven);
	}

	/**電話番号の入力
	 * @param telNumber 電話番号
	 */
	public void sendTelNumber(String telNumber) {
		tbxTelNumber.sendKeys(telNumber);
	}

	/**メールアドレスの入力
	 * @param emailAddress メールアドレス
	 */
	public void sendEmailAddress(String emailAddress) {
		tbxEmailAddress.sendKeys(emailAddress);
	}

	/**実行日から任意の日数を足した後の日にちを、お届け日時の日付に入力
	 * @param day 足す日数
	 */
	public void sendDeliveryDate(int day) {
		//インスタンス化
		DateArithmetic date = new DateArithmetic();
		//日にちのみの値を取得
		String inputDate = date.simplifyDate(date.plusDate(day));
		//入力されている値のクリア
		//		tbxDeliveryDate.clear(); XXX バックスペース入力で解決しそう
		//入力
		tbxDeliveryDate.sendKeys(inputDate);
	}

	/**伝達事項に入力
	 * @param value 入力したい文章
	 */
	public void sendTbxDentatu(String value) {
		tbxDentatu.sendKeys(value);
	}

	/**確認へボタンのクリックとインスタンスの取得
	 * @return インスタンス
	 */
	public Confirm clickBtnToConfirm() {
		btnToConfirm.click();
		//インスタンス化と
		Confirm conf = new Confirm(driver);
		return conf;
	}

	/**性別のラジオボタンの選択
	 * @param sex 性別（男 or 女）
	 */
	public void selectSex(String sex) {
		if (!(sex.equals("男") || sex.equals("女"))) {
			throw new IllegalArgumentException("selectSexメソッドには引数に「男」または「女」を使ってください");
		}
		if (sex.equals("男")) {
			rbtnSex.findElements(By.tagName("input")).get(0).click();
		}
		if (sex.equals("女")) {
			rbtnSex.findElements(By.tagName("input")).get(1).click();
		}
	}

	/**ギフトのリボンを選択状態または未選択状態にする
	 * @param check 選択状態 true:選択状態 fales:未選択状態
	 */
	public void selectCbxRibon(boolean check) {
		if (check) { //チェック入れたいとき
			if (!cbxRibon.isSelected()) { //チェック入ってなかったら
				cbxRibon.click(); //クリック
			}
		} else { //チェックを外したいとき
			if (cbxRibon.isSelected()) {//チェックが入っていたら
				cbxRibon.click(); //クリック
			}
		}
	}

	/**ギフトののしを選択状態または未選択状態にする
	 * @param check 選択状態 true:選択状態 fales:未選択状態
	 */
	public void selectCbxNosi(boolean check) {
		if (check) { //チェック入れたいとき
			if (!cbxNosi.isSelected()) { //チェック入ってなかったら
				cbxNosi.click(); //クリック
			}
		} else { //チェックを外したいとき
			if (cbxNosi.isSelected()) { //チェック入っていたら
				cbxNosi.click(); //クリック
			}
		}
	}

	/**ギフトのレターを選択状態または未選択状態にする
	 * @param check 選択状態 true:選択状態 fales:未選択状態
	 */
	public void selectCbxLetter(boolean check) {
		if (check) { //チェック入れたいとき
			if (!cbxLetter.isSelected()) { //チェック入ってなかったら
				cbxLetter.click(); //クリック
			}
		} else { //チェックを外したいとき
			if (cbxLetter.isSelected()) { //チェック入っていたら
				cbxLetter.click(); //クリック
			}
		}
	}

	/**お届け日時の時間指定で任意の時間を選択
	 * @param value 時間指定に対応する値
	 * 0:時間指定無し, 1:09-12時, 2:12-14時, 3:14-16時, 4:16-18時, 5:18-20時, 6:20-21時
	 */
	public void selectPdwnDeliveryTime(String value) {
		Select timeList = new Select(pdwnDeliveryTime);
		//		Select timeList = new Select(driver.findElement(By.id("timepicker")));
		timeList.selectByValue(value);
	}

	/**都道府県プルダウンの任意の都道府県を選択
	 * @param pref 都道府県名
	 */
	public void selectPdwnPrefecture(String pref) {
		Select prefList = new Select(pdwnPrefecture);
		prefList.selectByVisibleText(pref);
	}

	/**ページ上部のタイトルのテキストの取得
	 * @return タイトル
	 */
	public String getTxtTitle() {
		return txtTitle.getText();
	}

	public String getTxtEmailConfirm() {
		return txtEmailConfirm.getText();
	}

	/**「都道府県」プルダウンの選択された都道府県名を取得
	 * @return 都道府県名
	 */
	public String getSelectedPdwnPref() {
		Select select = new Select(pdwnPrefecture);
		return select.getAllSelectedOptions().get(0).getText();
	}

	/**「都道府県」プルダウンの選択された都道府県名を取得
	 * @return 都道府県名
	 */
	public String getSelectedPdwnPref2() {
		//タグ「option」でリスト化
		List<WebElement> options = pdwnPrefecture.findElements(By.tagName("option"));
		Iterator<WebElement> itrtr = options.iterator();

		WebElement op = null;
		Integer i = null;

		for (i = 1; i < options.size(); i++) {
			;
			//リストの次の要素へ
			op = itrtr.next();

			//もし要素が選択されていれば、breakし、その際のinnerTextを返す
			if (op.isSelected()) {
				break;
			}
		}
		return op.getText();
	}

	/**市区町村/番地のテキストボックスの値を取得
	 * @return 市区町村/番地
	 */
	public String getTxtTown() {
		return tbxTown.getAttribute("value");
	}

	/**会員様連絡が活性か非活性かを取得
	 * @return 活性(true) または 非活性(false)
	 */
	public String getStateTbxKaiinRenraku() {
		return tbxKaiinRenraku.getAttribute("readonly");
	}
}
