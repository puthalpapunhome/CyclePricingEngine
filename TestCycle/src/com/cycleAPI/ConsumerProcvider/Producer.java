package com.cycleAPI.ConsumerProcvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cycleAPI.ApiHelper.ApiHelper;
import com.cycleAPI.JsonUtility.JSONUtility;
import com.cycleAPI.Service.Service;
import com.cycleAPI.model.WholeCycle;

public class Producer implements Runnable {
	public String dateGivenNewFormat="";
	public ArrayList<LinkedHashMap<String,String>> getWholeCyclegiven=new ArrayList<LinkedHashMap<String,String>>();
	public final static String pathGiven="D:/papun/personal/ecycling/request.json";
	public static JSONParser parser = new JSONParser();
    private final BlockingQueue<Integer> queue;
    public static JSONArray request=null;
    public static JSONObject jsonObject1 =null;
    
    static {
    	Object obj = null;
		try {
			obj = parser.parse(new FileReader(pathGiven));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject jsonObjectroot = (JSONObject) obj;
		 request=(JSONArray)jsonObjectroot.get("request");
		System.out.println("request size "+request.size());
		
		//getstored data
		Object obj1 = null;
		try {
			obj1 = parser.parse(new FileReader("D:/papun/personal/ecycling/test.json"));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 jsonObject1 = (JSONObject) obj1;
    }
    
    @Override
    public void run() {

        try {
            process();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process() throws InterruptedException {

        
    	for(int i=0;i<request.size();i++){
			JSONObject  jsonObject=(JSONObject) request.get(i);
			
		String dateGiven=new JSONUtility().getGivendateInRequestJson( jsonObject);
		
		 dateGivenNewFormat=new ApiHelper().getGivenPathFormat(dateGiven);
		System.out.println("------------------Welcome TO E-Cycle Pricing Engine---------------------");
		System.out.println("");
		System.out.println("$You Have requesting for below components");
		getWholeCyclegiven=new JSONUtility().getGivenWholeCycle(jsonObject);
		System.out.println(new  Service().readAndDisplayGivenJsonComponents(jsonObject));
		System.out.println("below necessery components will be added for completion of the cycle billing basis on your given period of date");
		System.out.println("Frame: top_tube,down_tube,seat_tube,seat_stay,chain_stay \n Wheels:spokes,rim,tube,tyre");
		System.out.println("");

	
	WholeCycle getWholeCyclechoosen=new JSONUtility().getChoosenWholeCycle(dateGivenNewFormat,jsonObject1,getWholeCyclegiven);
	double tolatPrice=new Service().getCalculationOfCycle(getWholeCyclechoosen);
	
	System.out.println(new  Service().gerPricingReport(tolatPrice,getWholeCyclechoosen,dateGivenNewFormat));
	
	
	 System.out.println("[Producer] Put : " + i);
     queue.put(i);
	System.out.println("[Producer] Queue remainingCapacity : " + queue.remainingCapacity());
	 Thread.sleep(100);
		}
    	
    	
    	
       /* for (int i = 0; i < 20; i++) {
            System.out.println("[Producer] Put : " + i);
            queue.put(i);
            System.out.println("[Producer] Queue remainingCapacity : " + queue.remainingCapacity());
            Thread.sleep(100);
        }*/

    }

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
}