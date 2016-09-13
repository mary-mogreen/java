/**
 * 
 */
package ch24.ex01;

import java.util.ListResourceBundle;

/**
 * @author mary-mogreen
 *
 */
public class GlobalRes_en extends ListResourceBundle {
	public Object[][] getContents() {
		return contents;
	}
	
	private static final Object[][] contents = {
		{ GlobalRes.HELLO, "Hello" },
		{ GlobalRes.GOODBYE, "Goddbye" },
	};
}
