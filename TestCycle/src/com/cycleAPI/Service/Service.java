package com.cycleAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jdk.management.resource.internal.TotalResourceContext;

import com.cycleAPI.model.WholeCycle;

public class Service {

	public double getCalculationOfCycle(WholeCycle whole) {
		try{
			System.out.println(whole.getFrame().getToalFrame());
			double cycleTotal=whole.getFrame().getToalFrame()+
					whole.getHandleBarWithBrakes().getTotalHandle()+
					whole.getSeating().getToalSeat()+
					whole.getWheels().getTotalWheels()+
					whole.getChainAssembly().getTotalChain();
			
			return cycleTotal;
		}catch(Exception e){e.printStackTrace();}
		return 0;
	}

	public String gerPricingReport(double tolatPrice, WholeCycle whole,String dateGivenNewFormat) {
		// TODO Auto-generated method stub
		try{
			StringBuilder sb=new StringBuilder();
			sb.append("====================\n");
			sb.append("pricing of date :"+dateGivenNewFormat+"\n");
			sb.append("comonents are below with prices\n");
			sb.append("--------------------\n");
			sb.append(whole.getFrame().getDisplay());
			
			sb.append(whole.getHandleBarWithBrakes().getDisplay());
			sb.append(whole.getSeating().getDisplay());
			sb.append(whole.getWheels().getDisplay());
			sb.append(whole.getChainAssembly().getDisplay());
			sb.append("--------------------\n");
			sb.append("Total Pricing of cycle: "+tolatPrice+"\n");
			return sb.toString();
		}catch(Exception e){e.printStackTrace();}
		return null;
	}
	public String readAndDisplayGivenJsonComponents(JSONObject jsonObject) {
		try{
			
			StringBuilder sb=new StringBuilder();
			JSONArray frame=(JSONArray)jsonObject.get("frame");
			JSONArray handle_bar_with_brakes=(JSONArray)jsonObject.get("handle_bar_with_brakes");
			JSONArray seating=(JSONArray)jsonObject.get("seating");
			JSONArray wheels=(JSONArray)jsonObject.get("wheels");
			JSONArray chain_assembly=(JSONArray)jsonObject.get("chain_assembly");
		//	System.out.println(jarr.toString());
			
            //System.out.println(frame.toString());
			sb.append("----frame-----\n");
			sb.append(getEachComponentData(frame));
			sb.append("----handle_bar_with_brakes-----\n");
			sb.append(getEachComponentData(handle_bar_with_brakes));
			sb.append("----seating-----\n");
			sb.append(getEachComponentData(seating));
			sb.append("----wheels-----\n");
			sb.append(getEachComponentData(wheels));
			sb.append("----chain_assembly-----\n");
			sb.append(getEachComponentData(chain_assembly));
			     return sb.toString();
		}catch(Exception e){e.printStackTrace();}
		return null;
		
	}
	
	public String getEachComponentData(JSONArray obj){
		//Iterator<String> iterator = obj.iterator();
		StringBuilder sb=new StringBuilder();
		
		List<String> result=new ArrayList<String>();
		  for (  Object jObject : obj) {
		    String jsonString=jObject.toString();
		    result.add(jsonString);
		  }
        for(String s:result){
        	
             sb.append(s+"\n");
        }
		return sb.toString();
	}

}
