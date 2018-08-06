package testSuite;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageObject.EC2.CompleteRegistration;
import pageObject.EC2.Confirm;
import pageObject.EC2.PaymentInfo;
import pageObject.EC2.Purchase;
import pageObject.EC2.TopPage;
import pageObject.commonProcess.ChromeOperation;

/**テストケースのクラス
 * @author veriuser
 *
 */
public class Practice2 {
	//宣言
	private static WebDriver driver;
	private static TopPage top;
	private static Purchase purchase;
	private static PaymentInfo pay;
	private static Confirm conf;

	//テスト実行前にブラウザを起動、ウィンドウ最大化
	@BeforeClass
	public static void setUpOnce() {
		//インスタンス化
		ChromeOperation optn = new ChromeOperation(driver);
		driver = optn.setChrome();
		optn.maximazeWindow();
	}

	//各テストケース実行前に毎回、トップページへ移動
	@Before
	public void setUpEvery() {
		//インスタンス化
		ChromeOperation optn = new ChromeOperation(driver);
		//トップページへ移動
		optn.setURL("http://ec2-13-250-152-191.ap-southeast-1.compute.amazonaws.com/index.php");
		//インスタンス化
		top = new TopPage(driver);
	}

	//全テストケース終了後、Chromeを終了
	@AfterClass
	public static void endTest() {
		//インスタンス化
		ChromeOperation optn = new ChromeOperation(driver);
		optn.quitChrome();
	}

	//演習問題01
	@Test
	public void practice01() {
		//スクロール位置の取得
		int scrollBefore = top.getScrollPosition();

		//「会員登録」ボタンをクリック
		top.clickKaiinTouroku();

		//クリック後のスクロールの確認
		assertThat("case01-01:ページがスクロールされること", top.getScrollPosition(), is(not(scrollBefore)));

		//ユーザ名を入力
		top.sendUserName("TestTaro");

		//パスワードを入力
		top.sendPasswordNew("password");

		//パスワード（確認用）を入力
		top.sendpasswordConfirm("password");

		//「登録」ボタンをクリックとインスタンス取得
		CompleteRegistration compReg = top.clickTouroku();

		//表示の確認
		assertThat("case01-02:「ご利用ありがとうございました。」が表示されること", compReg.getArigatou(), is("ご利用ありがとうございました。"));
	}

	//演習問題02
	@Test
	public void practice02() {
		//「会員登録」ボタンをクリック
		top.clickKaiinTouroku();

		//ユーザ名を入力
		top.sendUserName("TestHanako");

		//パスワードを入力
		top.sendPasswordNew("123456");

		//パスワード（確認用）を入力
		top.sendpasswordConfirm("123456");

		//「登録」ボタンをクリックとインスタンス取得
		CompleteRegistration compReg = top.clickTouroku();

		//表示の確認
		assertThat("「case02-01:ご利用ありがとうございました。」が表示されること", compReg.getArigatou(), is("ご利用ありがとうございました。"));

		//「トップページへ」ボタンをクリック
		top = compReg.clickToTopPage();

		//ページの遷移の確認
		assertThat("case02-02:トップページが表示されること", top.getTxtKaiintouroku(), is("会員登録"));

		//ここから手順No.3

		//「会員登録」ボタンをクリック
		top.clickKaiinTouroku();

		//ユーザ名を入力
		top.sendUserName("TestJiro");

		//パスワードを入力
		top.sendPasswordNew("passwor01");

		//パスワード（確認用）を入力
		top.sendpasswordConfirm("password01");

		//「登録」ボタンをクリックとインスタンス取得
		compReg = top.clickTouroku();

		//べりサーブのロゴをクリック
		top = compReg.clickRogo();

		//ページの遷移の確認
		assertThat("case02-03:トップページが表示されること", top.getTxtKaiintouroku(), is("会員登録"));
	}

	//演習問題03
	@Test
	public void practice03() {
		//猫の画像の下の「商品を見る」ボタンをクリックとインスタンス取得
		Purchase purchase = top.clickBtnLookProductCat();

		//猫ちゃんの素敵なまなざしの「＋」ボタンをクリック
		purchase.clickBtnPlusCat(1);

		//猫ちゃんの素敵なまなざしのカウントの確認
		assertThat("case03-01:猫ちゃんのすてきなまなざしのカウントに1が表示されること", purchase.getTxtCountCat(), is("1"));

		//猫ちゃんの素敵なまなざしの「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketCat();

		//「個数合計」の確認
		assertThat("case03-01:「個数合計」に「1個」が表示されること", purchase.getTxtKosuGoukei(), is("1"));

		//「金額合計」の確認
		assertThat("case03-02:「金額合計」に「2222円」が表示されること", purchase.getTxtKingakuGoukei(), is("2222"));

		//鳥だけにエサ取り名人の「＋」ボタンをクリック
		purchase.clickBtnPlusBird(10);

		//鳥だけにエサ取り名人のカウントの確認
		assertThat("case03-03:鳥だけにエサ取り名人のカウントに10が表示されること", purchase.getTxtCountBird(), is("10"));

		//鳥だけにエサ取り名人の「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketBird();

		//「個数合計」の確認
		assertThat("case03-04:「個数合計」に「11個」が表示されること", purchase.getTxtKosuGoukei(), is("11"));

		//「金額合計」の確認
		assertThat("case03-05:「金額合計」に「130722円」が表示されること", purchase.getTxtKingakuGoukei(), is("130722"));

		//Theゴリラくんの「＋」ボタンをクリック
		purchase.clickBtnPlusGorira(5);

		//Theゴリラくんのカウントの確認
		assertThat("case03-06:Theゴリラくんのカウントに5が表示されること", purchase.getTxtCountGorira(), is("5"));

		//Theゴリラくんの「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketGorira();

		//「個数合計」の確認
		assertThat("case03-07:「個数合計」に「16個」が表示されること", purchase.getTxtKosuGoukei(), is("16"));

		//「金額合計」の確認
		assertThat("case03-08:「金額合計」に「133517円」が表示されること", purchase.getTxtKingakuGoukei(), is("133517"));

		//鳥だけにエサ取り名人の「-」ボタンをクリック
		purchase.clickBtnMinusBird(3);

		//鳥だけにエサ取り名人のカウントの確認
		assertThat("case03-09:鳥だけにエサ取り名人のカウントに7が表示されること", purchase.getTxtCountBird(), is("7"));

		//鳥だけにエサ取り名人の「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketBird();

		//「個数合計」の確認
		assertThat("case03-10:「個数合計」に「13個」が表示されること", purchase.getTxtKosuGoukei(), is("13"));

		//「金額合計」の確認
		assertThat("case03-11:「金額合計」に「94967円」が表示されること", purchase.getTxtKingakuGoukei(), is("94967"));

		//猫ちゃんの素敵なまなざしの「-」ボタンをクリック
		purchase.clickBtnMinusCat(1);

		//猫ちゃんの素敵なまなざしのカウントの確認
		assertThat("case03-12:猫ちゃんのすてきなまなざしのカウントに0が表示されること", purchase.getTxtCountCat(), is("0"));

		//猫ちゃんの素敵なまなざしの「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketCat();

		//「個数合計」の確認
		assertThat("case03-13:「個数合計」に「12個」が表示されること", purchase.getTxtKosuGoukei(), is("12"));

		//「金額合計」の確認
		assertThat("case03-14:「金額合計」に「92745円」が表示されること", purchase.getTxtKingakuGoukei(), is("92745"));

		//Theゴリラくんの「-」ボタンをクリック
		purchase.clickBtnMinusGorira(2);

		//Theゴリラくんのカウントの確認
		assertThat("case03-15:Theゴリラくんのカウントに3が表示されること", purchase.getTxtCountGorira(), is("3"));

		//Theゴリラくんの「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketGorira();

		//「個数合計」の確認
		assertThat("case03-16:「個数合計」に「10個」が表示されること", purchase.getTxtKosuGoukei(), is("10"));

		//「金額合計」の確認
		assertThat("case03-17:「金額合計」に「91627円」が表示されること", purchase.getTxtKingakuGoukei(), is("91627"));

		//「購入する」ボタンをクリック
		PaymentInfo pay = purchase.clickBtnKounyu();

		//画面の遷移の確認
		assertThat("case03-18:配送先/お支払い情報のご入力画面」が表示されること", pay.getTxtTitle(), is("配送先/お支払い情報のご入力"));
	}

	//演習問題04
	@Test
	public void practice04() {
		//猫の写真のしたの「商品を見る」ボタンをクリックとインスタンス取得
		purchase = top.clickBtnLookProductCat();

		//鳥だけにエサ取り名人の「＋」ボタンをクリック
		purchase.clickBtnPlusBird(4);

		//鳥だけにエサ取り名人の「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketBird();

		//個数合計の確認
		assertThat("case04-01:「個数合計」に「4個」が表示されること", purchase.getTxtKosuGoukei(), is("4"));

		//金額合計の確認
		assertThat("case04-02:「金額合計」に「51400円」が表示されること", purchase.getTxtKingakuGoukei(), is("51400"));

		//猫ちゃんの素敵なまなざしの「＋」ボタンをクリック
		purchase.clickBtnPlusCat(10);

		//猫ちゃんの素敵なまなざしの「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketCat();

		//個数合計の確認
		assertThat("case04-03:「個数合計」に「14個」が表示されること", purchase.getTxtKosuGoukei(), is("14"));

		//金額合計の確認
		assertThat("case04-04:「金額合計」に「73620円」が表示されること", purchase.getTxtKingakuGoukei(), is("73620"));

		//Theゴリラくんの「＋」ボタンをクリック
		purchase.clickBtnPlusGorira(8);

		//猫ちゃんの素敵なまなざしの「カゴに入れる」ボタンをクリック
		purchase.clickBtnInsertBasketGorira();

		//個数合計の確認
		assertThat("case04-05:「個数合計」に「22個」が表示されること", purchase.getTxtKosuGoukei(), is("22"));

		//金額合計の確認
		assertThat("case04-06:「金額合計」に「78092円」が表示されること", purchase.getTxtKingakuGoukei(), is("78092"));

		//「購入する」ボタンをクリックとインスタンスの取得
		pay = purchase.clickBtnKounyu();

		//画面の遷移の確認
		assertThat("case04-07:「配送先/お支払い情報のご入力」画面が表示されること", pay.getTxtTitle(), is("配送先/お支払い情報のご入力"));

		//郵便番号の入力
		pay.sendPostalCode("1008111");

		//Webサイトの都道府県の自動入力完了を１秒待つ
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//都道府県の自動選択の確認
		assertThat("case04-08:都道府県に「東京都」が表示されること", pay.getSelectedPdwnPref2(), is("東京都"));

		//市区町村/番地の確認
		assertThat("市区町村/番地「千代田区千代田」が表示されること", pay.getTxtTown(), is("千代田区千代田"));

		//市区町村/番地の追加入力
		pay.sendTownName("1-1");

		//マンション名の入力
		pay.sendbuildingName("ヴィレッジ千代田316");

		//お名前（漢字）の姓の入力
		pay.sendNameKanjiFamily("検証");

		//お名前（漢字）の名の入力
		pay.sendNameKanjiGiven("太郎");

		//お名前（よみがな）の姓の入力
		pay.sendNameKanaFamily("けんしょう");

		//お名前（よみがな）の名の入力
		pay.sendNameKanaGiven("たろう");

		//性別を選択
		pay.selectSex("男");

		//電話番号の入力
		pay.sendTelNumber("03 0248 4510");

		//メールアドレスの入力
		pay.sendEmailAddress("taro.kensho99064@wowssinm.gb");

		//ご確認の確認
		assertThat("case04-09:ご確認に「taro.kensho99064@wowssinm.gb」が表示されること", pay.getTxtEmailConfirm(),
				is("taro.kensho99064@wowssinm.gb"));

		//お届け日時の日付の入力
		pay.sendDeliveryDate(2);

		//お届け日時の時間の入力
		pay.selectPdwnDeliveryTime("1");

		//ギフトのリボンを選択
		pay.selectCbxRibon(true);

		//ギフトのレターを選択
		pay.selectCbxLetter(true);

		//会員様連絡の確認
		assertThat("case04-10:「会員様連絡」が読み取り専用（非活性）であること", pay.getStateTbxKaiinRenraku(), is("true"));

		//確認へボタンをクリックする
		conf = pay.clickBtnToConfirm();

		//表示されるテキストの確認
		assertThat("case04-11:「ご利用ありがとうございました。」が表示されること", conf.getTxtThankYou(), is("ご利用ありがとうございました。"));

		//トップページへボタンをクリック
		top = conf.clickBtnToTopPage();

		//ページの遷移を確認
		assertThat("case04-12:トップ画面が表示されること", top.getTxtKaiintouroku(), is("会員登録"));
	}

	//演習問題05
	@Test
	public void practice05() {
		//猫の写真下の商品をみるをクリックする
		purchase = top.clickBtnLookProductCat();

		//鳥だけにエサ取り名人の「＋」ボタンをクリック
		purchase.clickBtnPlusBird(3);

		//鳥だけにエサ取り名人のカゴに入れるボタンをクリック
		purchase.clickBtnInsertBasketBird();

		//個数合計の確認
		assertThat("case05-01:個数合計に3個が表示されること", purchase.getTxtKosuGoukei(), is("3"));

		//金額合計の確認
		assertThat("case05-02:金額合計に38550円が表示されること", purchase.getTxtKingakuGoukei(), is("38550"));

		//購入するボタンをクリック
		pay = purchase.clickBtnKounyu();

		//画面の表示の確認
		assertThat("case05-03:配送先/お支払い情報のご入力画面が表示されること", pay.getTxtTitle(), is("配送先/お支払い情報のご入力"));

		//郵便番号を入力
		pay.sendPostalCode("1234567");

		//都道府県の選択
		pay.selectPdwnPrefecture("神奈川県");

		//市区町村/番地を入力
		pay.sendTownName("足柄上部開成町宮代4-16-18");

		//マンション名を入力
		pay.sendbuildingName("宮台ハイツ419");

		//お名前（漢字）の姓を入力
		pay.sendNameKanjiFamily("検証");

		//お名前（漢字）の名を入力
		pay.sendNameKanjiGiven("花子");

		//お名前（よみがな）の姓を入力
		pay.sendNameKanaFamily("けんしょう");

		//お名前（よみがな）の名を入力
		pay.sendNameKanaGiven("はなこ");

		//性別の選択
		pay.selectSex("女");

		//電話番号を入力
		pay.sendTelNumber("046 415 6658");

		//メールアドレスを入力
		pay.sendEmailAddress("hanko.kensho@qzxcb.pc.fdu");

		//ご確認の確認
		assertThat("case05-04:ご確認に「hanko.kensho@qzxcb.pc.fdu」が表示されること", pay.getTxtEmailConfirm(),
				is("hanko.kensho@qzxcb.pc.fdu"));

		//お届け日時の日付を入力
		pay.sendDeliveryDate(29);

		//お届け日時の時間指定を入力
		pay.selectPdwnDeliveryTime("0");

		//ギフトののしを選択する
		pay.selectCbxNosi(true);

		//伝達事項を入力
		pay.sendTbxDentatu("1行目の特記事項\n2行目の特記事項\n3行目の特記事項");

		//会員様連絡の状態の確認
		assertThat("case05-05:会員様連絡が読み取り専用（非活性）であること", pay.getStateTbxKaiinRenraku(), is("true"));

		//確認へボタンをクリック
		conf = pay.clickBtnToConfirm();

		//テキスト表示の確認
		assertThat("case05-06:「ご利用ありがとうございました。」が表示されること", conf.getTxtThankYou(), is("ご利用ありがとうございました。"));

		//トップページへをクリック
		top = conf.clickBtnToTopPage();

		//ページ遷移の確認
		assertThat("case05-06:トップ画面が表示されること", top.getTxtKaiintouroku(), is("会員登録"));
	}
}
