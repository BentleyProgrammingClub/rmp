import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class GetProfessors {

	public static ArrayList<String> getNames(String department, int classNum) throws IOException {
		
		String dpmt = "GB";
		
		//check the department and direct to the correct website
				if(department.equals("GB")){
					dpmt = "GB";
				} else if(department.equals("AC")){
					dpmt = "AC";
				} else if(department.equals("LIT")||department.equals("MC")||department.equals("COM")||department.equals("EXP")||department.equals("CIN")||department.equals("EMS")){
					dpmt = "EN";		
				} else if(department.equals("FI")||department.equals("AF")){
					dpmt = "FI";
				} else if(department.equals("FS")||department.equals("TS")){
					dpmt = "FS";
				} else if(department.equals("GLS")){
					dpmt = "GLS";
				} else if(department.equals("HI")){
					dpmt = "HI";
				} else if(department.equals("IDCC")){
					dpmt = "IDCC";
				} else if(department.equals("IPM")){
					dpmt = "IPM";
				} else if(department.equals("LA")){
					dpmt = "LTF";
				} else if(department.equals("MG")){
					dpmt = "MG";
				} else if(department.equals("MK")){
					dpmt = "MK";
				} else if(department.equals("MA")){
					dpmt = "MA";
				} else if(department.equals("MLCH")||department.equals("MLJA")||department.equals("MLIT")||department.equals("MLSP")||department.equals("MLFR")){
					dpmt = "ML";
				} else if(department.equals("NASE")|| department.equals("NASC")|| department.equals("PS")){
					dpmt = "NAS";
				} else if(department.equals("AC")){
					dpmt = "PI";
				} else if(department.equals("PH")){
					dpmt = "PSL";
				} else if(department.equals("SL")){
					dpmt = "SL";
				} else if(department.equals("SO")){
					dpmt = "SO";
				} else if(department.equals("EC")){
					dpmt = "EC";
				}
				
				String url = "https://my.bentley.edu/web/guest/course-listings/-/courses/201609/UC/D/"+dpmt+"?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
				
				//connect to the website 
				Document doc = Jsoup.connect(url).get();
				ArrayList<String> teachers = new ArrayList<>();
				
				//get the table elements on the site
				Elements tables = doc.select("table");
				
				//iterate over each table and find the one that matches the class code entered
				for (int i = 0; i < tables.size(); i++){
					
					Element table = tables.get(i);
					Elements rows = table.select("tr");
					String[] tbl = table.text().split("\u00A0");
					
					//when the class code is found, get the teacher and store in array
					if(tbl[0].equals(classNum)){
					
						for (int j = 2, n = rows.size(); j < n; j++){
							Element row = rows.get(j);			
							Elements cols = row.select("td");
							teachers.add(cols.get(9).text());
						}
					}
				}
				
			return teachers;
		
	}

}
