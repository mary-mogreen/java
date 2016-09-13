/**
 * 
 */
package ch24.ex01;

import java.util.ListResourceBundle;



/**
 * @author mary-mogreen
 *
 */
public class GlobalRes_en_AU extends ListResourceBundle {
	public Object[][] getContents() {
		return contents;
	}
	
	private static final Object[][] contents = {
		{GlobalRes.HELLO, "G'day" },
	};
}
