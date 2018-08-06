package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**日付の計算を行うクラス
 * @author 土田
 *
 */
public class DateArithmetic {
	//宣言
	private Calendar calendar;

	/**コンストラクタ
	 * Calenderクラスのインスタンス化
	 */
	public DateArithmetic() {
		calendar = Calendar.getInstance();
	}

	/**今日の日付に、任意の日にちを足し、その結果を取得
	 * @param plusDay 足す日数
	 * @return 結果の日付
	 */
	public Date plusDate(int plusDay) {
		calendar.add(Calendar.DAY_OF_MONTH, plusDay);
		return calendar.getTime();
	}

	/**Date型の日付の日にちのみを取得
	 * @param date 日付
	 * @return 日にち（0埋め）
	 */
	public String simplifyDate(Date date) {
		SimpleDateFormat simple = new SimpleDateFormat("dd");
		return simple.format(calendar.getTime());
	}

}
