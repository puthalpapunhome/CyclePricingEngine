package com.cycleAPI.JsonUtility;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.JsonObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cycleAPI.model.ChainAssembly;
import com.cycleAPI.model.Frame;
import com.cycleAPI.model.HandleBarWithBrakes;
import com.cycleAPI.model.Seating;
import com.cycleAPI.model.Wheels;
import com.cycleAPI.model.WholeCycle;

public class JSONUtility {

	public double getComponentValue(JSONObject jsonObject, String component,
			String param, String dateGivenNewFormat) {
		// TODO Auto-generated method stub
		try {
			// System.out.println("jsonObject "+jsonObject);
			JSONObject cycleDataByList = (JSONObject) jsonObject
					.get(dateGivenNewFormat);
			// System.out.println(cycleDataByList);
			JSONObject cycleDataByList1 = (JSONObject) cycleDataByList
					.get(component);

			// System.out.println("chain_stay"+cycleDataByList1);
			String chainstay = (String) cycleDataByList1.get(param).toString();

			// System.out.println("chainstay d "+chainstay);
			return Double.parseDouble(chainstay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public String getGivendateInRequestJson(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		try {
			// System.out.println("jsonObject "+jsonObject);

			String givenDate = (String) jsonObject.get("Pricingdate")
					.toString();

			// System.out.println("chainstay d "+givenDate);
			return givenDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public WholeCycle getChoosenWholeCycle(String dateGivenNewFormat,
			JSONObject jsonObject,
			ArrayList<LinkedHashMap<String, String>> getWholeCyclegiven) {
		try {
			WholeCycle wholeCycle = new WholeCycle();
			ChainAssembly chain = new ChainAssembly();
			Frame frame = new Frame();
			HandleBarWithBrakes handle = new HandleBarWithBrakes();
			Seating seat = new Seating();
			Wheels wheel = new Wheels();
			// System.out.println(" dateGivenNewFormat %% "+dateGivenNewFormat);
			frame.setTop_tube(new JSONUtility().getComponentValue(jsonObject,
					"frame", "top_tube", dateGivenNewFormat));
			frame.setDown_tube(new JSONUtility().getComponentValue(jsonObject,
					"frame", "down_tube", dateGivenNewFormat));
			frame.setSeat_tube(new JSONUtility().getComponentValue(jsonObject,
					"frame", "seat_tube", dateGivenNewFormat));
			frame.setSeat_stay(new JSONUtility().getComponentValue(jsonObject,
					"frame", "seat_stay", dateGivenNewFormat));
			frame.setChain_stay(new JSONUtility().getComponentValue(jsonObject,
					"frame", "chain_stay", dateGivenNewFormat));

			wheel.setSpokes(new JSONUtility().getComponentValue(jsonObject,
					"wheels", "spokes", dateGivenNewFormat));
			wheel.setRim(new JSONUtility().getComponentValue(jsonObject,
					"wheels", "rim", dateGivenNewFormat));
			wheel.setTube(new JSONUtility().getComponentValue(jsonObject,
					"wheels", "tube", dateGivenNewFormat));
			wheel.setTyre(new JSONUtility().getComponentValue(jsonObject,
					"wheels", "tyre", dateGivenNewFormat));

			handle.setHandlebar_grip(new JSONUtility().getComponentValue(
					jsonObject, "handle_bar_with_brakes", "handlebar_grip",
					dateGivenNewFormat));
			handle.setHead_tube(new JSONUtility().getComponentValue(jsonObject,
					"handle_bar_with_brakes", "head_tube", dateGivenNewFormat));
			handle.setShock_absorber(new JSONUtility().getComponentValue(
					jsonObject, "handle_bar_with_brakes", "shock_absorber",
					dateGivenNewFormat));
			handle.setFront_brakes(new JSONUtility().getComponentValue(
					jsonObject, "handle_bar_with_brakes", "front_brakes",
					dateGivenNewFormat));
			handle.setFork(new JSONUtility().getComponentValue(jsonObject,
					"handle_bar_with_brakes", "fork", dateGivenNewFormat));

			for (LinkedHashMap<String, String> lhm1 : getWholeCyclegiven) {
				// LinkedHashMap<String,String> lhm1=null;
				// lhm1=getWholeCyclegiven.get(i);

				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("handle_bar_with_brakes")) {
						if (!lhm1.containsKey("handlebar_grip")) {
							// System.out.println("1111111111111111111");
							handle.setHandlebar_grip(0);
						} else {
							handle.setHandlebar_grip(new JSONUtility()
									.getComponentValue(jsonObject,
											"handle_bar_with_brakes",
											"handlebar_grip",
											dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("handle_bar_with_brakes")) {
						if (!lhm1.containsKey("head_tube")) {
							// System.out.println("1111111111111111111");
							handle.setHead_tube(0);
						} else {
							handle.setHead_tube(new JSONUtility()
									.getComponentValue(jsonObject,
											"handle_bar_with_brakes",
											"head_tube", dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("handle_bar_with_brakes")) {
						if (!lhm1.containsKey("shock_absorber")) {
							// System.out.println("1111111111111111111");
							handle.setShock_absorber(0);
						} else {
							handle.setShock_absorber(new JSONUtility()
									.getComponentValue(jsonObject,
											"handle_bar_with_brakes",
											"shock_absorber",
											dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("handle_bar_with_brakes")) {
						if (!lhm1.containsKey("front_brakes")) {
							// System.out.println("1111111111111111111");
							handle.setFront_brakes(0);
						} else {
							handle.setFront_brakes(new JSONUtility()
									.getComponentValue(jsonObject,
											"handle_bar_with_brakes",
											"front_brakes", dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("handle_bar_with_brakes")) {
						if (!lhm1.containsKey("fork")) {
							// System.out.println("1111111111111111111");
							handle.setFork(0);
						} else {
							handle.setFork(new JSONUtility().getComponentValue(
									jsonObject, "handle_bar_with_brakes",
									"fork", dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
			}

			seat.setSaddle(new JSONUtility().getComponentValue(jsonObject,
					"seating", "saddle", dateGivenNewFormat));
			seat.setSeat_post(new JSONUtility().getComponentValue(jsonObject,
					"seating", "seat_post", dateGivenNewFormat));

			for (LinkedHashMap<String, String> lhm1 : getWholeCyclegiven) {

				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("seating")) {
						if (!lhm1.containsKey("saddle")) {
							// System.out.println("1111111111111111111");
							seat.setSaddle(0);
						} else {
							seat.setSaddle(new JSONUtility().getComponentValue(
									jsonObject, "seating", "saddle",
									dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("seating")) {
						if (!lhm1.containsKey("seat_post")) {
							// System.out.println("1111111111111111111");
							seat.setSeat_post(0);
						} else {
							seat.setSeat_post(new JSONUtility()
									.getComponentValue(jsonObject, "seating",
											"seat_post", dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
			}

			chain.setChain(new JSONUtility().getComponentValue(jsonObject,
					"chain_assembly", "chain", dateGivenNewFormat));
			chain.setChain_ring(new JSONUtility().getComponentValue(jsonObject,
					"chain_assembly", "chain_ring", dateGivenNewFormat));

			for (LinkedHashMap<String, String> lhm1 : getWholeCyclegiven) {

				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("chain_assembly")) {
						if (!lhm1.containsKey("chain")) {
							// System.out.println("1111111111111111111");
							chain.setChain(0);
						} else {
							chain.setChain(new JSONUtility().getComponentValue(
									jsonObject, "chain_assembly", "chain",
									dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
				for (Entry<String, String> set : lhm1.entrySet()) {
					if (set.getValue().equals("chain_assembly")) {
						if (!lhm1.containsKey("chain_ring")) {
							// System.out.println("1111111111111111111");
							chain.setChain_ring(0);
						} else {
							chain.setChain_ring(new JSONUtility()
									.getComponentValue(jsonObject,
											"chain_assembly", "chain_ring",
											dateGivenNewFormat));
						}
						// System.out.println(set.getKey() + " = " +
						// set.getValue());
					}
				}
			}

			wholeCycle.setChainAssembly(chain);
			wholeCycle.setFrame(frame);
			wholeCycle.setHandleBarWithBrakes(handle);
			wholeCycle.setSeating(seat);
			wholeCycle.setWheels(wheel);

			return wholeCycle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<LinkedHashMap<String, String>> getGivenWholeCycle(
			JSONObject jsonObject) {

		StringBuilder sb = new StringBuilder();
		JSONArray frame = (JSONArray) jsonObject.get("frame");
		JSONArray handle_bar_with_brakes = (JSONArray) jsonObject
				.get("handle_bar_with_brakes");
		JSONArray seating = (JSONArray) jsonObject.get("seating");
		JSONArray wheels = (JSONArray) jsonObject.get("wheels");
		JSONArray chain_assembly = (JSONArray) jsonObject.get("chain_assembly");

		ArrayList<LinkedHashMap<String, String>> al = new ArrayList<LinkedHashMap<String, String>>();
		al.add(addIntoHashMap(frame, "frame"));
		al.add(addIntoHashMap(handle_bar_with_brakes, "handle_bar_with_brakes"));
		al.add(addIntoHashMap(seating, "seating"));
		al.add(addIntoHashMap(wheels, "wheels"));
		al.add(addIntoHashMap(chain_assembly, "chain_assembly"));
		return al;

	}

	public LinkedHashMap<String, String> addIntoHashMap(JSONArray obj,
			String type) {
		List<String> result = new ArrayList<String>();
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		for (Object jObject : obj) {
			String jsonString = jObject.toString();
			if (type.equals("frame")) {
				lhm.put(jsonString, "frame");
			}
			if (type.equals("handle_bar_with_brakes")) {
				lhm.put(jsonString, "handle_bar_with_brakes");
			}
			if (type.equals("seating")) {
				lhm.put(jsonString, "seating");
			}
			if (type.equals("wheels")) {
				lhm.put(jsonString, "wheels");
			}
			if (type.equals("chain_assembly")) {
				lhm.put(jsonString, "chain_assembly");
			}

		}
		/*
		 * for(String s:result){
		 * 
		 * sb.append(s+"\n"); }
		 */
		return lhm;
	}

}
