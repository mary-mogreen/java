/**
 *
 */
package ch04.ex01;

/**
 * @author mary-mogreen
 *
 */
public class Passenger {
	private String name;// 名前
	//private String licence;//保有する免許
	//private String role;//役割（運転手とかそれ以外とか）

	public Passenger(String name) {
		this.setName(name);
	}

	public Passenger() {
		this.name = "匿名";
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}




}
