import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Display {
	static ArrayList Questionlist = new ArrayList();
	static ArrayList Answerlist = new ArrayList();

	public static void main(String[] args) {
		SaxParser1 saxpar = new SaxParser1();
		saxpar.call();
		
		Map<Integer, Integer> TmpQuestion = new HashMap<Integer, Integer>();
		TmpQuestion = sortByComparator(saxpar.Question);
		Map<Integer, Integer> TmpAnswers = new HashMap<Integer, Integer>();
		TmpAnswers = sortByComparator(saxpar.Answers);

		int i = 0, j = 0;
		for (Entry<Integer, Integer> entry : TmpQuestion.entrySet()) {

			Integer key = entry.getKey();
			Integer value4 = entry.getValue();
			Questionlist.add(key);
			// System.out.println("key, " + key + " value " + value4 );
			i++;
			if (i == 10)
				break;
		}
		i = 0;
		for (Entry<Integer, Integer> entry : TmpAnswers.entrySet()) {

			Integer key = entry.getKey();
			Integer value4 = entry.getValue();
			Answerlist.add(key);
			// System.out.println("key, " + key + " value " + value4 );
			i++;
			if (i == 10)
				break;
		}
		System.out.println("Top 10 users for questions");
		Displaynames(Questionlist);
		System.out.println("\n\n\nTop 10 users for answers");
		Displaynames(Answerlist);

	}

	private static void Displaynames(ArrayList list) {

		SaxParseUser sax = new SaxParseUser();
		Map<Integer, String> TmpMap = new HashMap<Integer, String>();

		TmpMap = sax.call1();
		for (Entry<Integer, String> entry : TmpMap.entrySet()) {

			Integer key = entry.getKey();
			String value4 = entry.getValue();
//			Answerlist.add(key);
//	 System.out.println("key, " + key + " value " + value4 );
		}
		int c=0;
		for (Entry<Integer, String> entry : TmpMap.entrySet()) {
			for (int i = 0; i < 10; i++) {
				Integer key = entry.getKey();
				String value4 = entry.getValue();
				if (list.get(i).equals(key)) {
					{
						System.out.println(c + ":  User id:" +key+" Name:" + value4);
					c++;
					}
			
					// Answerlist.add(key);
				} // System.out.println("key, " + key + " value " + value4 );

				// TODO Auto-generated method stub
			}
		}
	}

	private static Map<Integer, Integer> sortByComparator(
			Map<Integer, Integer> unsortMap) {

		// Convert Map to List
		LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(
				unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Iterator<Map.Entry<Integer, Integer>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<Integer, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}