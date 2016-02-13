package ch01.ex14;

public class Jack {
	private String message = "";
	/**
	 * 音源をアウトプットする
	 */
	public void output(String songs) {
		System.out.println(songs);
	}

	/**
	 * インプットする
	 */
	public void input(String message) {
		this.message = message;
		System.out.println("input... " + message);
	}

	/**
	 * インプットされた文字列を取得する
	 */
	public String getMessage() {
		return this.message;
	}
}
