package ch21.ex01;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class SortLineTest {
	
	String[] expected = {
			"Lorem ipsum dolor sit amet, ex elit atqui mea, eius verear salutatus eam no. Ne qui sale munere prompta, ferri phaedrum abhorreant vim ut, nulla libris vis ex. Cu qui partem consequat, nam tota ocurreret ut. Libris menandri eum eu. Id duo voluptua explicari. Commodo vidisse nec cu.",
			"Ne elit oratio accusata mea, has wisi lorem tamquam ad. Ei duo probatus tincidunt, populo hendrerit usu no, nec corpora oporteat gubergren ea. Mea veritus forensibus intellegam ea, vero placerat delicata eu nam, te fugit legimus expetenda vix. Et eripuit offendit principes pri, cu vis consul latine. Ius laudem utamur no, cu mundi electram nec.",
			"Scripta imperdiet definitionem per ei, oporteat necessitatibus id sit. Et erat autem latine eam, no assum erant his. Ut erant doctus dolorum sea, ei his error epicuri. Tritani elaboraret et est. Vis ludus timeam volumus ea, ludus laudem at nam.",
			"Usu purto impedit tibique at, sit mediocrem salutandi cu. Duo eu causae temporibus, pri id latine adipiscing, est sonet delenit ex. Eos postulant repudiare id. Ea simul aperiri sea. Prompta facilisi postulant et quo. In quo clita commune, nec hinc sale eu. No pri liber appareat eleifend, stet veritus omnesque ex mel.",
			"Vim laudem noluisse ne. Mei laudem labore senserit te, ut elitr tincidunt qui. Ex accumsan perfecto est. Nec quas omittam legendos id, cum cu nostrud splendide liberavisse."
	};

	@Test
	public void test() {
		String path = "/Users/katouyuuya/git/java_training2015/jpl/src/ch21/ex01/testfile.txt";
		List<String> sortedList = SortLine.sort(new File(path));
		for (int i = 0; i < sortedList.size(); i++)
			assertTrue(expected[i].equals(sortedList.get(i)));
	}

}
