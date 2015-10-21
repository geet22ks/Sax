import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser1 {
	public static HashMap<Integer, Integer> Question = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> Answers = new HashMap<Integer, Integer>();

	public static void call() {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean id = false;
				boolean Pti = false;
				Integer n = 0, m = 0, z = 0;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					// System.out.println("Start Element :" + qName);
					// for (int i=0; i<length; i++) {
					String value = attributes.getValue("OwnerUserId");
					String value1 = attributes.getValue("PostTypeId");
					if (value != null && value1 != null) {
						n = Integer.parseInt(value);
						m = Integer.parseInt(value1);
						if (m == 1) {
							if (Question.get(n) != null) {
								//System.out.println("coming here");
								Question.put(n, Question.get(n) + 1);
							} else {
								Question.put(n, 1);
							}
						}
						else 				if (m == 2) {
							if (Answers.get(n) != null) {
								//System.out.println("coming here");
								Answers.put(n, Answers.get(n) + 1);
							} else {
								Answers.put(n, 1);
							}
						}
		
						// System.out.println(n+","+m);

					}
					/*
					 * if(m==1&&hmap.containsKey(n)) { System.out.println( n);
					 * System.out.println( m); m=m+1; hmap.put(n,m); } else {
					 * hmap.put(n, 1); }
					 * 
					 * }
					 */
					// System.out.println( n);
					// }

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					// System.out.println("End Element :" + qName);

				}
				/*
				 * public void characters(char ch[], int start, int length)
				 * throws SAXException {
				 * 
				 * if (id) { System.out.println("Id : " + new String(ch, start,
				 * length)); id = false; }
				 * 
				 * if (Pti) { System.out.println("Post type id : " + new
				 * String(ch, start, length)); Pti = false; }
				 * 
				 * 
				 * 
				 * }
				 */
			};

			saxParser.parse("posts.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}