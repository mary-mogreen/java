/**
 * 
 */
package ch17.ex04;

/**
 * @author mary-mogreen
 *
 */
interface Resource {
	void use(Object key, Object... args);
	void release();
}
