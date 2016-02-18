package ch01.ex14;

/**
 *
 * @author mary-mogreen
 *
 */

public class Tape {
	private String songs;

	Tape() {
		songs = "";
	}

	Tape(String songs) {
		this.songs = songs;
	}

	/**
	 * 曲を読み込む
	 */
	public String getSongs() {
		return songs;
	}

	/**
	 * 曲を書き込む
	 * @param songs
	 */
	public void setSongs(String songs) {
		this.songs = songs;
	}
}
