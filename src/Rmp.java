import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Rmp {

	/**
	 * figuring out how to get info from rmp
	 * @throws IOException 
	 *  
	 */
	public static void main(String[] args) throws IOException {
		
		String url = "http://www.ratemyprofessors.com/ShowRatings.jsp?tid=1077521";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements rtng = doc.select("div.rating-breakdown").select("div.left-breakdown").select("div.breakdown-wrapper").select("div.breakdown-header").select("div.breakdown-container").select("div.grade");		
		
		System.out.println(rtng);
		
		
	}

}
