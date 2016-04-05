/**
 *
 */
package ch10.ex03;

import ch06.ex01.DaysOfTheWeek;
/**
 * @author mary-mogreen
 *
 */
public class WorkingDays {

//	public static boolean isWorkingDay(DaysOfTheWeek day) {
//		if (day.equals(DaysOfTheWeek.SUNDAY) || day.equals(DaysOfTheWeek.SATURDAY))
//			return false;
//		else
//			return true;
//	}

	/**
	 * 少しだけこちら。DaysOfTheWeekを記述する回数が少ない。
	 * @param day
	 * @return
	 */
	public static boolean isWorkingDay(DaysOfTheWeek day) {
		switch (day) {
			case SUNDAY: case SATURDAY:
				return false;
			default:
				return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//boolean isWorking = WorkingDays.isWorkingDay(DaysOfTheWeek.SUNDAY);
		boolean isWorking = WorkingDays.isWorkingDay(DaysOfTheWeek.FRIDAY);
		System.out.println(isWorking);

	}

}
