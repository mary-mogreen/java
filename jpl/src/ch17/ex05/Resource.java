/**
 * 
 */
package ch17.ex05;

/**
 * @author mary-mogreen
 *
 */
interface Resource {
	void use(Object key, Object... args);
	void release();
}
