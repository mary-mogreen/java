package ch24.ex03;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DateFormatSample {
	public static void main(String[] args) throws ParseException {
		showDateFormats("2016/09/16 22:12:03");
		System.out.println();
		showDateFormats("16/16/9 11:11:11");
		System.out.println();
		showDateFormats("16/16/9 11:11:11", false);
	}

	private static void showDateFormats(String date) throws ParseException {
		showDateFormats(date, true);
	}
	
	private static void showDateFormats(String date, boolean isLenient) throws ParseException {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.JAPAN);
		df.setLenient(isLenient);
		Date d = df.parse(date);
		int[] styles = {DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT};
		for (int i = 0; i < styles.length; i++) {
			for (int j = 0; j < styles.length; j++)
				print(styles[i], styles[j], d);
		}
	}

	private static void print(int dateStyle, int timeStyle, Date date) {
		System.out.println(DateFormat.getDateTimeInstance(dateStyle, timeStyle).format(date));
	}
	
}
