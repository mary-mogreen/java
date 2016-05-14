/**
 *
 */
package ch11.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import ch11.ex02.AttrAsGeneric;

/**
 * @author mary-mogreen
 *
 */
public class AttributedImplTest {

	/**
	 * {@link ch11.ex03.AttributedImpl#add(ch11.ex02.AttrAsGeneric)} のためのテスト・メソッド。
	 */
	@Test
	public void testAdd() {
		AttributedImpl attributedImplString = new AttributedImpl();
		AttrAsGeneric<String> attrString1 = new AttrAsGeneric<String>("name1", "value1");
		assertThat(attributedImplString.find("name1"), is((AttrAsGeneric<String>)null));
		attributedImplString.add(attrString1);
		assertThat(attributedImplString.find("name1"), is(attrString1));
	}

	/**
	 * {@link ch11.ex03.AttributedImpl#find(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testFind() {
		AttributedImpl attributedImplString = new AttributedImpl();
		AttrAsGeneric<String> attrString1 = new AttrAsGeneric<String>("name1", "value1");
		assertThat(attributedImplString.find("name1"), is((AttrAsGeneric<String>)null));
		attributedImplString.add(attrString1);
		assertThat(attributedImplString.find("name1"), is(attrString1));
	}

	/**
	 * {@link ch11.ex03.AttributedImpl#remove(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testRemove() {
		AttributedImpl attributedImplString = new AttributedImpl();
		AttrAsGeneric<String> attrString1 = new AttrAsGeneric<String>("name1", "value1");
		assertThat(attributedImplString.find("name1"), is((AttrAsGeneric<String>)null));
		attributedImplString.add(attrString1);
		assertThat(attributedImplString.find("name1"), is(attrString1));
		assertThat(attributedImplString.remove("name2"), is((AttrAsGeneric<String>)null));
		assertThat(attributedImplString.remove("name1"), is(attrString1));
		assertThat(attributedImplString.find("name1"), is((AttrAsGeneric<String>)null));
	}

	/**
	 * {@link ch11.ex03.AttributedImpl#attrs()} のためのテスト・メソッド。
	 */
	@Test
	public void testAttrs() {
		AttributedImpl impl = new AttributedImpl();
		AttrAsGeneric<String> attrString1 = new AttrAsGeneric<String>("name1", "value1");
		AttrAsGeneric<String> attrString2 = new AttrAsGeneric<String>("name2", "value2");
		AttrAsGeneric<String> attrString3 = new AttrAsGeneric<String>("name3", "value3");

		impl.add(attrString1);
		impl.add(attrString2);
		impl.add(attrString3);

		int i = 0;
		int j = 0;
		Iterator<AttrAsGeneric<String>> itr = impl.attrs();
		while (itr.hasNext()) {
			switch(itr.next().getName()) {
			case "name1":
				i += 1;
				break;
			case "name2":
				i += 10;
				break;
			case "name3":
				i += 100;
				break;
			default:
				i += 1000;
			}
		}
		assertThat(i, is(111));
	}
}
