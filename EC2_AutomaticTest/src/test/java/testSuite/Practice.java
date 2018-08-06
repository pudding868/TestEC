package testSuite;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageObject.EC2.CompleteRegistration;
import pageObject.EC2.PaymentInfo;
import pageObject.EC2.Purchase;
import pageObject.EC2.TopPage;
import pageObject.commonProcess.ChromeOperation;

/**テストケースのクラス
 * @author veriuser
 *
 */
public class Practice {
	//宣言
	private static WebDriver driver;

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
	}

	//全テストケース終了後、Chromeを終了
	@AfterClass
	public static void endTest() {
		//インスタンス化
		ChromeOperation optn = new ChromeOperation(driver);
		optn.quitChrome();
	}

	//演習問題１
	@Test
	public void practice01() {
		//インスタンス化
		TopPage top = new TopPage(driver);

		//スクロール位置の取得
		int scrollBefore = top.getScrollPosition();

		//「会員登録」ボタンのクリック
		top.clickKaiinTouroku();

		//クリック後のスクロールの確認
		assertThat("case01-01:ページがスクロールされること", top.getScrollPosition(), is(not(scrollBefore)));

		//ユーザ名を入力
		top.sendUserName("TestTaro");

		//パスワードを入力
		top.sendPasswordNew("password");

		//パスワード（確認用）を入力
		top.sendpasswordConfirm("password");

		//「登録」ボタンのクリックとインスタンス取得
		CompleteRegistration compReg = top.clickTouroku();

		//表示の確認
		assertThat("case01-02:「ご利用ありがとうございました。」が表示されること", compReg.getArigatou(), is("ご利用ありがとうございました。"));
	}

	//演習問題２
	@Test
	public void practice02() {
		//インスタンス化
		TopPage top = new TopPage(driver);

		//「会員登録」ボタンのクリック
		top.clickKaiinTouroku();

		//ユーザ名を入力
		top.sendUserName("TestHanako");

		//パスワードを入力
		top.sendPasswordNew("123456");

		//パスワード（確認用）を入力
		top.sendpasswordConfirm("123456");

		//「登録」ボタンのクリックとインスタンス取得
		CompleteRegistration compReg = top.clickTouroku();

		//表示の確認
		assertThat("「case02-01:ご利用ありがとうございました。」が表示されること", compReg.getArigatou(), is("ご利用ありがとうございました。"));

		//「トップページへ」ボタンのクリック
		top = compReg.clickToTopPage();

		//ページの遷移の確認
		assertThat("case02-02:トップページが表示されること", top.getTxtKaiintouroku(), is("会員登録"));

		//ここから手順No.3

		//「会員登録」ボタンのクリック
		top.clickKaiinTouroku();

		//ユーザ名を入力
		top.sendUserName("TestJiro");

		//パスワードを入力
		top.sendPasswordNew("passwor01");

		//パスワード（確認用）を入力
		top.sendpasswordConfirm("password01");

		//「登録」ボタンのクリックとインスタンス取得
		compReg = top.clickTouroku();

		//べりサーブのロゴのクリック
		top = compReg.clickRogo();

		//ページの遷移の確認
		assertThat("case02-03:トップページが表示されること", top.getTxtKaiintouroku(), is("会員登録"));
	}

	//演習問題03
	@Test
	public void practice03() {
		//インスタンス化
		TopPage top = new TopPage(driver);

		//猫の画像の下の「商品を見る」ボタンのクリックとインスタンス取得
		Purchase purchase = top.clickBtnLookProductCat();

		//猫ちゃんの素敵なまなざしの「＋」ボタンのクリック
		purchase.clickBtnPlusCat(1);

		//猫ちゃんの素敵なまなざしのカウントの確認
		assertThat("case03-01:猫ちゃんのすてきなまなざしのカウントに1が表示されること", purchase.getTxtCountCat(), is("1"));

		//猫ちゃんの素敵なまなざしの「カゴに入れる」ボタンのクリック
		purchase.clickBtnInsertBasketCat();

		//「個数合計」の確認
		assertThat("case03-01:「個数合計」に「1個」が表示されること", purchase.getTxtKosuGoukei(), is("1"));

		//「金額合計」の確認
		assertThat("case03-02:「金額合計」に「2222円」が表示されること", purchase.getTxtKingakuGoukei(), is("2222"));

		//鳥だけにエサ取り名人の「＋」ボタンのクリック
		purchase.clickBtnPlusBird(10);

		//鳥だけにエサ取り名人のカウントの確認
		assertThat("case03-03:鳥だけにエサ取り名人のカウントに10が表示されること", purchase.getTxtCountBird(), is("10"));

		//鳥だけにエサ取り名人の「カゴに入れる」ボタンのクリック
		purchase.clickBtnInsertBasketBird();

		//「個数合計」の確認
		assertThat("case03-04:「個数合計」に「11個」が表示されること", purchase.getTxtKosuGoukei(), is("11"));

		//「金額合計」の確認
		assertThat("case03-05:「金額合計」に「130722円」が表示されること", purchase.getTxtKingakuGoukei(), is("130722"));

		//Theゴリラくんの「＋」ボタンのクリック
		purchase.clickBtnPlusGorira(5);

		//Theゴリラくんのカウントの確認
		assertThat("case03-06:Theゴリラくんのカウントに5が表示されること", purchase.getTxtCountGorira(), is("5"));

		//Theゴリラくんの「カゴに入れる」ボタンのクリック
		purchase.clickBtnInsertBasketGorira();

		//「個数合計」の確認
		assertThat("case03-07:「個数合計」に「16個」が表示されること", purchase.getTxtKosuGoukei(), is("16"));

		//「金額合計」の確認
		assertThat("case03-08:「金額合計」に「133517円」が表示されること", purchase.getTxtKingakuGoukei(), is("133517"));

		//鳥だけにエサ取り名人の「-」ボタンのクリック
		purchase.clickBtnMinusBird(3);

		//鳥だけにエサ取り名人のカウントの確認
		assertThat("case03-09:鳥だけにエサ取り名人のカウントに7が表示されること", purchase.getTxtCountBird(), is("7"));

		//鳥だけにエサ取り名人の「カゴに入れる」ボタンのクリック
		purchase.clickBtnInsertBasketBird();

		//「個数合計」の確認
		assertThat("case03-10:「個数合計」に「13個」が表示されること", purchase.getTxtKosuGoukei(), is("13"));

		//「金額合計」の確認
		assertThat("case03-11:「金額合計」に「94967円」が表示されること", purchase.getTxtKingakuGoukei(), is("94967"));

		//猫ちゃんの素敵なまなざしの「-」ボタンのクリック
		purchase.clickBtnMinusCat(1);

		//猫ちゃんの素敵なまなざしのカウントの確認
		assertThat("case03-12:猫ちゃんのすてきなまなざしのカウントに0が表示されること", purchase.getTxtCountCat(), is("0"));

		//猫ちゃんの素敵なまなざしの「カゴに入れる」ボタンのクリック
		purchase.clickBtnInsertBasketCat();

		//「個数合計」の確認
		assertThat("case03-13:「個数合計」に「12個」が表示されること", purchase.getTxtKosuGoukei(), is("12"));

		//「金額合計」の確認
		assertThat("case03-14:「金額合計」に「92745円」が表示されること", purchase.getTxtKingakuGoukei(), is("92745"));

		//Theゴリラくんの「-」ボタンのクリック
		purchase.clickBtnMinusGorira(2);

		//Theゴリラくんのカウントの確認
		assertThat("case03-15:Theゴリラくんのカウントに3が表示されること", purchase.getTxtCountGorira(), is("3"));

		//Theゴリラくんの「カゴに入れる」ボタンのクリック
		purchase.clickBtnInsertBasketGorira();

		//「個数合計」の確認
		assertThat("case03-16:「個数合計」に「10個」が表示されること", purchase.getTxtKosuGoukei(), is("10"));

		//「金額合計」の確認
		assertThat("case03-17:「金額合計」に「91627円」が表示されること", purchase.getTxtKingakuGoukei(), is("91627"));

		//「購入する」ボタンのクリック
		PaymentInfo pay = purchase.clickBtnKounyu();

		//画面の遷移の確認
		assertThat("case03-18:配送先/お支払い情報のご入力画面」が表示されること", pay.getTxtTitle(), is("配送先/お支払い情報のご入力"));
	}

	//演習問題04
	@Test
	public void practice04() {
		//インスタンス化
		//TopPage top = new TopPage(driver);

	}
}
