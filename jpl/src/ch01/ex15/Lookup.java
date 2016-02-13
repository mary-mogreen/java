/**
 *
 */
package ch01.ex15;

/**
 * @author mery-mogreen
 *
 */
public interface Lookup {

	/**
	 * nameと関連付けられた値を返す
	 * そのような値がなければnullを返す
	 */
	Object find(String name);
}
