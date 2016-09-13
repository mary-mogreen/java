/**
 * 
 */
package ch24.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author mary-mogreen
 *
 */
public class GlobalHello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.JAPANESE);
		String pac = "ch24.ex01.";
		// en
		String en = pac + "GlobalRes_en";
		sayHello(en);
		sayGoodbye(en);
		
		// ja 
		String ja = pac + "GlobalRes_ja";
		sayHello(ja);
		sayGoodbye(ja);
		
		// eo_KI_left
		String eo_KI_left = pac + "GlobalRes_eo_KI_left";
		sayHello(eo_KI_left);
		sayGoodbye(eo_KI_left);
		
		// GlobalRes
		String res = pac + "GlobalRes";
		sayHello(res);
		sayGoodbye(res);
		
		

	}
	
	private static void sayHello(String baseName) {
		ResourceBundle res = ResourceBundle.getBundle(baseName);
		System.out.printf("%s: %s%n", baseName, res.getString(GlobalRes.HELLO));
	}
	
	private static void sayGoodbye(String baseName) {
		ResourceBundle res = ResourceBundle.getBundle(baseName);
		System.out.printf("%s: %s%n", baseName, res.getString(GlobalRes.GOODBYE));
	}

}
