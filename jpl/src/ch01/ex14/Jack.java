package ch01.ex14;

/**
 *
 * @author mary-mogreen
 *
 */

public class Jack {
	private String message = "";

	/**
	 * 音源をアウトプットする
	 * @param songs
	 */
	public void output(String songs) {
		System.out.println(songs);
	}

	/**
	 * インプットする
	 * @param message
	 */
	public void input(String message) {
		this.message = message;
		System.out.println("input... " + message);
	}

	/**
	 * インプットされた文字列を取得する
	 * @return {String}
	 */
	public String getMessage() {
		return this.message;
	}
}
