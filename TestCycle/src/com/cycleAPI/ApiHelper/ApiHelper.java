package com.cycleAPI.ApiHelper;

public class ApiHelper {
	
	public String year="";
	public String month="";
	public String[] calMonth={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	
	public String getGivenPathFormat(String dateGiven) {
		// TODO Auto-generated method stub
		try{
			if(dateGiven!=null || dateGiven.equals("")){
				try{
				year=dateGiven.split("-")[2];
				month=dateGiven.split("-")[0];
				}catch(Exception e){
					e.printStackTrace();

					System.out.println("entered date format is wrong or null,Please re-execute the program and insert data again");
				}
			}else{
				System.out.println("entered date format is wrong or null,Please re-execute the program and insert data again");
			}
			String dateGivenNewFormat="";
			try{
				
				for(int i=0;i <= calMonth.length;i++){
					if((Integer.parseInt(month)-1)==i){
						dateGivenNewFormat=calMonth[i];
					}
				}
				if(!dateGivenNewFormat.equals("Dec"))
					dateGivenNewFormat="Jan "+year+" - Dec "+year;
				else
					dateGivenNewFormat="Jan "+(String.valueOf(Integer.parseInt(year)+1))+" - Dec "+(String.valueOf(Integer.parseInt(year)+1));
				
				return dateGivenNewFormat;
				
			}catch(Exception e){e.printStackTrace();}
		}catch(Exception e){e.printStackTrace();}
		return null;
	}

}
