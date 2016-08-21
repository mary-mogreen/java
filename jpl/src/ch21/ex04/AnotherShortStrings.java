/**
 * 
 */
package ch21.ex04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author mary-mogreen
 *
 */
public class AnotherShortStrings implements ListIterator<String> {

	private ListIterator<String> strings; // 元の文字列
	private String nextShort; // 次が不明ならばnull
	private String prevShort; // 前が不明ならばnull
	private final int maxLen; // この長さ以下の文字列だけを返す
	private int index; // 現在のインデックス
	private String currentShort; // 現在の文字列
	
	public AnotherShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
		prevShort = null;
		index = 0;
		currentShort = null;
	}
	
	@Override
	public boolean hasNext() {
		if (nextShort != null) // すでに見つけている
			return true;
		while (strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen)
				return true;
		}
		nextShort = null; // 見つけられなかった
		return false;
	}

	@Override
	public String next() {
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		String n = nextShort; // nextShort を記憶する
		nextShort = null; // nextShort を消費する
		index++;
		currentShort = n;
		return n; // nextShort を返す
	}

	@Override
	public boolean hasPrevious() {
		if (prevShort != null) // すでに見つけている
			return true;
		while (strings.hasPrevious()) {
			prevShort = strings.previous();
			if (prevShort.length() <= maxLen)
				return true;
		}
		prevShort = null; // 見つけられなかった
		return false;
	}

	@Override
	public String previous() {
		if (prevShort == null && !hasPrevious())
			throw new NoSuchElementException();
		String p = prevShort; // prevShort を記憶する
		prevShort = null; // prevShort を消費する
		index--;
		currentShort = p;
		return p; // prevShort を返す
	}

	@Override
	public int nextIndex() {
		return index + 1;
	}

	@Override
	public int previousIndex() {
		return index - 1;
	}

	@Override
	public void remove() {
		if (currentShort == null)
			new IllegalStateException("previous/next isn't called.");
		strings.remove();
	}

	@Override
	public void set(String e) {
		strings.set(e);
	}

	@Override
	public void add(String e) {
		strings.add(e);
	}

}
