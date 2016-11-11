import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.Time;
import java.util.Timer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Example {

		
	public static void main(String[] args) throws Exception  {
		
	  
		
		Scanner input = new Scanner (System.in);
		System.out.println("How many courses do you have?");
		int courseNum = input.nextInt();
		
		boolean [] status = new boolean[courseNum];
		Arrays.fill(status,Boolean.FALSE);
		int[] crn = new int[courseNum];
		String[] url = new String[courseNum];
		for(int i = 1; i<=courseNum;i++){
			System.out.println("Please enter the crn for course "+i);
			crn[i-1]=input.nextInt();
		}
		for(int i =0; i<crn.length;i++){
			System.out.println(crn[i]);
		}
		
	
		for(int i = 0 ; i<crn.length;i++){
			if(crn[i] >= 90003&& crn[i] <= 90038  ){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/AC?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if(crn[i] >= 90039 && crn[i] <= 90078){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/CS?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if(crn[i] >= 90079 && crn[i] <= 90134){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/EC?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if(crn[i] == 90811 || (crn[i] >= 90135 && crn[i] <= 90228)){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/EN?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if (crn[i] >= 90229 && crn[i]<= 90284){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/FI?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if (crn[i] >= 90759 && crn[i]<= 90801){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/FS?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if (crn[i] >= 90285 && crn[i]<= 90437){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/GB?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
			if (crn[i] >= 90438 && crn[i]<= 90478){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/GLS?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if (crn[i] >= 90478 && crn[i]<= 90500){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/HI?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if (crn[i] >= 90504 && crn[i]<= 90517){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/IDCC?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
			if (crn[i] >= 90518 && crn[i] <= 90519){
			url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/IPM?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
			}
		    if (crn[i]>= 90501 && crn[i] <= 90503){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/ID?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] >= 90520 && crn[i] <= 90531){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/LTF?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] >= 90590 && crn[i] <= 90617){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/MG?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] >= 90618 && crn[i] <= 90638){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/MG?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] >= 90543 && crn[i] <= 90589){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/MA?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] >= 90639 && crn[i] <= 90856 || crn[i]==90814 || crn[i]==90856){
		    	url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/ML?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] >= 90660 && crn[i] <= 90712){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/NAS?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";	
		    }
		    if (crn[i] >= 90713 && crn[i] <= 90738){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/PI?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] == 90815 || crn[i] == 90739){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/PRS?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] == 90812){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/SL?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    if (crn[i] >= 90740 && crn[i] <= 90757){
		    url[i]="https://my.bentley.edu/web/guest/course-listings/-/courses/201509/UC/D/SO?p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1";
		    }
		    
		}
		
		while(true){
	
		for(int i = 0; i<crn.length;i++){
		try{
			
			Document doc = Jsoup.connect(url[i]).get();
			Elements a =doc.getElementsByClass("coursetable-crn");
			Elements b = doc.getElementsByClass("coursetable-enroll");
		
			
		    
			String[] crnlist =a.text().split("\\s");
			String[] enroll_list = b. text().split("\\s");
			
			HashMap<String,String> map = new HashMap<String,String>();
			if(crnlist.length == enroll_list.length){
				for(int x = 0; x< crnlist.length; x++){
					map.put(crnlist[x],enroll_list[x]);
				}
			
			String[] result = new String[crn.length];
			for(int j =0 ;j<crn.length;j++){
				result[j] = Integer.toString(crn[j]);
			}
			String [] ans = new String[result.length];
			ans[i]=map.get(result[i]);
			
			System.out.println("CRN : "+result[i]+ " Availability: " +ans[i]);
		
			
			if(!(ans[i].equalsIgnoreCase("CL"))){
				status[i]=true;
				System.out.println("Course :"+ "CRN "+result[i]+" is open");
				System.out.println();
			}
			else{
				status[i]=false;
			}
		
				
		
		}}
			catch(IOException e){
			
		}
		
		}
		System.out.println();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		
		System.out.println("-----------------------------------------------------------------------------------------------------");
		Thread.sleep(60000);
		
		
	
	}
		}}