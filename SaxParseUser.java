import java.util.HashMap;
import java.util.Map.Entry;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParseUser {
	public static HashMap<Integer, String> Usermap = new HashMap<Integer, String>();

	public static HashMap<Integer, String> call1() {

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
					
				String value = attributes.getValue("Id");
					String value1 = attributes.getValue("DisplayName");
					int n=0;
					if (value != null && value1 != null) {
						n=Integer.parseInt(value);
						if (Usermap.get(n) == null) {
								Usermap.put(n, value1);
						//System.out.println(n+"v"+value1);	
						} 
					}
						}
						// System.out.println(n+","+m);


					/*
					 * if(m==1&&hmap.containsKey(n)) { System.out.println( n);
					 * System.out.println( m); m=m+1; hmap.put(n,m); } else {
					 * hmap.put(n, 1); }
					 * 
					 * }
					 */
					// System.out.println( n);
					// }

				

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

			saxParser.parse("users.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Usermap;

	}

}