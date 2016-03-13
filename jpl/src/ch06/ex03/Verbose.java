/**
 *
 */
package ch06.ex03;

/**
 * @author mary-mogreen
 *
 */
public interface Verbose {
//4.2.1
//	int SILENT = 0;
//	int TERSE = 1;
//	int NORMAL = 2;
//	int VERBOSE = 3;

	enum Verbosity {
		SILENT, TERSE, NORMAL, VERBOSE
	}

//	void setVerbosity(int level);
	void setVerbosity(Verbosity level);
	int getVerbosity();
}
