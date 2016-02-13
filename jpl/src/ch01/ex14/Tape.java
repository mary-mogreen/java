package ch01.ex14;

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
	 */
	public void setSongs(String songs) {
		this.songs = songs;
	}
}
