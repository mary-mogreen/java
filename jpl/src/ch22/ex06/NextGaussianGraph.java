/**
 * 
 */
package ch22.ex06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author mary-mogreen
 *
 */
public class NextGaussianGraph { 
	
	public static void showGraph(long count) {
		Map<String, String> map = new TreeMap<>();
		for (long l = 0L; l < count; l++) {
			double d = new Random().nextGaussian();
			String s = String.format("%.2f", d);
			if (map.containsKey(s))
				map.put(s, map.get(s) + "*");
			else
				map.put(s, "*");
		}
		
		
		for (String s: map.keySet()) {
			System.out.printf("%s: %s%n", s, map.get(s));
		}
	}
	
	public static void main(String[] args) {
		NextGaussianGraph.showGraph(100000L);
	}
	
}
