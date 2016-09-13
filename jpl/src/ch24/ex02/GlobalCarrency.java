/**
 * 
 */
package ch24.ex02;

import java.util.ArrayList;
import java.util.Currency;
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
public class GlobalCarrency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale[] locales = {
				Locale.CANADA,
				Locale.CHINA,
				Locale.ITALY,
				Locale.US,
				Locale.JAPAN,
				Locale.KOREA
				};
		for (Locale l: locales) {
			Locale.setDefault(l);
			showCurrencyTable(locales);
		}

	}
	
	
	private static void showCurrencyTable(Locale... locales) {
		for (Locale l: locales) {
			String lang = l.getDisplayLanguage();
			String country = l.getDisplayCountry();
			int ratio = (lang.getBytes().length + country.getBytes().length) / (lang.length() + country.length());
			String locale;
			if (ratio == 1) 
				locale = lang + "(" + country + ")";
			else
				locale = lang + "（" + country + "）";
			System.out.printf("%-30s\t%s%n", 
					locale, Currency.getInstance(l).getSymbol(l));
		}
		System.out.printf("%n%n");
	}

}
