/**
 * 
 */
package ch16.ex04;

import java.lang.annotation.Annotation;

import ch16.ex02.TypeDesc;

/**
 * @author mary-mogreen
 *
 */
public class AnnotationViewer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationViewer viewer = new AnnotationViewer();
		Class<?> cls;
		try {
			cls = Class.forName(args[0]);
			Annotation[] annotations = cls.getAnnotations();
			System.out.println(cls.getName());
			viewer.printAnnotation(annotations);
			System.out.println("----------------------------");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

	private void printAnnotation(Annotation[] annotations) {
		for (Annotation a: annotations) {
			System.out.println("  " + a);
		}
	}
}

interface Test1 {
	public void foo();
}


@Deprecated
class Test2 implements Test1 {
	@Override
	public void foo() {
		//foo;
	}
	@Deprecated
	public void boo() {
		//boo;
	}
}