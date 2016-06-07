/**
 * 
 */
package ch16.ex02;

import java.lang.reflect.*;

/**
 * @author mary-mogreen
 *
 */
public class TypeDesc {
	static class TestClass {
		class NestedClass1 {
			
		}
		class NestedClass2 {
			class NestedNestedClass {
				
			}
		}
	}
	
	public static void main(String[] args) {
		TypeDesc desc = new TypeDesc();
		for (String name: args) {
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass, 0, basic);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
			}
		}
	}
	
	// デフォルトで標準出力に表示する
	private java.io.PrintStream out = System.out;
	
	// 型名にラベル付けするprintType()で使用される
	private static String[]
			basic	= {	"class",	"interface",
						"enum", 	"annotation"},
			supercl = {	"extends",	"implements"},
			iFace	= {	null,	 	"extends"};
	
	private void printType(Type type, int depth, String[] labels) {
		if (type == null || type == Object.class) // 再帰呼び出し禁止：スーパータイプが存在しない または typeのクラスがObjectと一致するなら終わり
			return;
		
		// TypeをClassオブジェクトに変換する
		Class<?> cls = null;
		if (type instanceof Class<?>)
			cls = (Class<?>) type;
		else if (type instanceof ParameterizedType)
			cls = (Class<?>)((ParameterizedType)type).getRawType();
		else
			throw new Error("Unexpected non-class type");
		
		// この型を表示
		for (int i = 0; i < depth; i++)
			out.print(" ");
		int kind = cls.isAnnotation() ? 3 : // Annotationなら3
			cls.isEnum() ? 2 :				// Enumなら2
			cls.isInterface() ? 1 : 0;		// Interfaceなら1, それ以外は0
		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());
		
		// あれば，ジェネリック型パラメータを表示
		TypeVariable<?>[] params = cls.getTypeParameters();
		if (params.length > 0) {
            out.print('<');
            for (TypeVariable<?> param : params) {
                out.print(param.getName());
                out.print(", ");
            }
            out.println("\b\b>");
        } else
			out.println();
		
		// ネストした型があればどの型にネストしているかを表示
		Class<?> nestedClass = cls.getDeclaringClass();
		if (nestedClass != null) {
			out.println("nested in " + nestedClass.getCanonicalName());
		}
		
		// このクラスが実装しているすべてのインタフェースを表示
		Type[] interfaces = cls.getGenericInterfaces();
		for (Type iface: interfaces) {
			printType(iface, depth + 1,
					cls.isInterface() ? iFace : supercl);
		}
		
		// スーパークラスに対して再帰
		printType(cls.getGenericSuperclass(),
				depth + 1, supercl);
	}
}
