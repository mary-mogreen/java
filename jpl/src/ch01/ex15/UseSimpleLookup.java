/**
 *
 */
package ch01.ex15;

/**
 * @author mery-mogreen
 *
 */
public class UseSimpleLookup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleLookup lookup = new SimpleLookup();

		lookup.add("name1", 100);
		lookup.add("name2", "2eman");

		System.out.println(lookup.find("name2"));
		System.out.println(lookup.find("name1"));
		System.out.println(lookup.find("name3"));

		lookup.remove("name1");

		System.out.println(lookup.find("name1"));

	}

}
