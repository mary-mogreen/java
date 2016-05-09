/**
 *
 */
package ch11.ex03;

import ch11.ex02.AttrAsGeneric;

/**
 * @author mary-mogreen
 *
 * ジェネリックによってAttrにどんな型でも入れられるよりは安全になる。
 * インタフェースへの影響としては、型引数を書かないと注意される。
 * 別ファイルとして定義するとジェネリックでない場合と変わらない？
 */
public interface Attributed {
	void add(AttrAsGeneric<?> attr);
	AttrAsGeneric<?> find(String attrName);
	AttrAsGeneric<?> remove(String attrName);
	java.util.Iterator<AttrAsGeneric<?>> attrs();
}
