package ch14.ex01;

public class PrintMainThread {

	public static void main(String[] args) {
		System.out.println("This is a thread that is running main(): " + Thread.currentThread().getName());
	}

}
