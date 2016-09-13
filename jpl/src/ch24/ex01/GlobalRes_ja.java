/**
 * 
 */
package ch24.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * @author mary-mogreen
 *
 */
public class GlobalRes_ja extends ResourceBundle{
	private static final String HELLO = "hello";
	private static final String GOODBYE = "goodbye";
	
	@Override
	protected Object handleGetObject(String key) {
		if (HELLO.equals(key))
			return "こんにちは";
		else if (GOODBYE.equals(key))
			return "さようなら";
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return new Vector<String>(Arrays.asList(HELLO, GOODBYE)).elements();
	}

}
