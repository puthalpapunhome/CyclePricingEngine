package com.cycleAPI.jsonCreation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;










import com.cycleAPI.model.ChainAssembly;
import com.cycleAPI.model.Frame;
import com.cycleAPI.model.HandleBarWithBrakes;
import com.cycleAPI.model.Seating;
import com.cycleAPI.model.Wheels;
import com.cycleAPI.model.WholeCycle;

public class CycleJSONWriterForStoring {

	public static void main(String[] args) throws FileNotFoundException {
		JsonObjectBuilder dateSlicingBuilder = Json.createObjectBuilder();
		

/*Jan 2016 - Nov 2016
Dec 2016 - Nov 2017
Dec 2017 - Nov 2018
Dec 2018 - Nov 2019
Dec 2019 - Nov 2020
*/
		int year=2016;
		
		double annualRate=0.15;
		for(int i=1;i<=5;i++){
				if(i==1)
					dateSlicingBuilder.add("Jan "+(year+i)+" - Dec "+(year+i)+"", getWholeCycleData(annualRate*i));
				else
					dateSlicingBuilder.add("Jan "+(year+i)+" - Nov "+(year+i)+"", getWholeCycleData(annualRate*i));
				}
		//dateSlicingBuilder.add("a", "b");
JsonObject empJsonObject = dateSlicingBuilder.build();
		
		System.out.println("Employee JSON String\n"+empJsonObject);
		
		//write to file
		OutputStream os = null;
		try {
			os = new FileOutputStream("emp.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonWriter jsonWriter = Json.createWriter(os);
		/**
		 * We can get JsonWriter from JsonWriterFactory also
		JsonWriterFactory factory = Json.createWriterFactory(null);
		jsonWriter = factory.createWriter(os);
		*/
		jsonWriter.writeObject(empJsonObject);
		jsonWriter.close();
	}
	
	public static JsonObjectBuilder getWholeCycleData(double rate){


		WholeCycle wholeCycle = createCycle(rate);
		
		
		JsonObjectBuilder wholeCycleBuilder = Json.createObjectBuilder();
		JsonObjectBuilder frameBuilder =  Json.createObjectBuilder();
		JsonObjectBuilder handleBuilder = Json.createObjectBuilder();
		JsonObjectBuilder seatBuilder =   Json.createObjectBuilder();
		JsonObjectBuilder wheelsBuilder = Json.createObjectBuilder();
		JsonObjectBuilder chainBuilder = Json.createObjectBuilder();

		
		
		frameBuilder.add("top_tube", wholeCycle.getFrame().getTop_tube())
						.add("down_tube", wholeCycle.getFrame().getDown_tube())
						.add("seat_tube", wholeCycle.getFrame().getSeat_tube())
						.add("seat_stay", wholeCycle.getFrame().getSeat_stay())
						.add("chain_stay", wholeCycle.getFrame().getChain_stay());
		
		handleBuilder.add("handlebar_grip", wholeCycle.getHandleBarWithBrakes().getHandlebar_grip())
		.add("handlebar_grip", wholeCycle.getHandleBarWithBrakes().getHandlebar_grip())
		.add("head_tube", wholeCycle.getHandleBarWithBrakes().getHead_tube())
		.add("shock_absorber", wholeCycle.getHandleBarWithBrakes().getShock_absorber())
		.add("front_brakes", wholeCycle.getHandleBarWithBrakes().getFront_brakes())
		.add("fork", wholeCycle.getHandleBarWithBrakes().getFork());
		
		seatBuilder.add("saddle", wholeCycle.getSeating().getSaddle())
		.add("seat_post", wholeCycle.getSeating().getSeat_post());
		
		wheelsBuilder.add("spokes", wholeCycle.getWheels().getSpokes())
		.add("rim", wholeCycle.getWheels().getRim())
		.add("tube", wholeCycle.getWheels().getTube())
		.add("tyre",wholeCycle.getWheels().getTyre());
				
		chainBuilder.add("chain", wholeCycle.getChainAssembly().getChain())
		.add("chain_ring", wholeCycle.getChainAssembly().getChain_ring());
		
		
		wholeCycleBuilder.add("frame", frameBuilder);
		wholeCycleBuilder.add("handle_bar_with_brakes", handleBuilder);
		wholeCycleBuilder.add("seating", seatBuilder);
		wholeCycleBuilder.add("wheels", wheelsBuilder);
		wholeCycleBuilder.add("chain_assembly", chainBuilder);
		
		
		return wholeCycleBuilder;
	}
	public static WholeCycle createCycle(double rate) {
		
		 DecimalFormat f = new DecimalFormat("##.00");
			System.out.println("rate");
		   
			System.out.println(Double.parseDouble(f.format(Math.random() * (260 - 195) + 195)));
		
		ChainAssembly chainAssembly=new ChainAssembly();
		chainAssembly.setChain(Double.parseDouble(f.format(Math.random() * ((200+(rate*200)) - (((rate*150)+50) + 1)) + ((rate*150)+150))));
		chainAssembly.setChain_ring(Double.parseDouble(f.format(Math.random() * (((150+(rate*150)) - (((rate*100)+100) + 1)) + ((rate*100)+100)))));
		
		Frame frame=new Frame();
		frame.setChain_stay(Double.parseDouble(f.format(Math.random() * (((950+(rate*950)) - (((rate*900)+900) + 1)) + ((rate*900)+900)))));
		frame.setDown_tube(Double.parseDouble(f.format(Math.random() * (((850+(rate*850)) - (((rate*800)+800) + 1)) + ((rate*800)+800)))));
		frame.setSeat_stay(Double.parseDouble(f.format(Math.random() * (((970+(rate*970)) - (((rate*900)+900) + 1)) + ((rate*900)+900)))));
		frame.setSeat_tube(Double.parseDouble(f.format(Math.random() * (((850+(rate*850)) - (((rate*800)+800) + 1)) + ((rate*800)+800)))));
		frame.setTop_tube(Double.parseDouble(f.format(Math.random() * (((850+(rate*850)) - (((rate*820)+820) + 1)) + ((rate*820)+820)))));
		
		HandleBarWithBrakes handle=new HandleBarWithBrakes();
		handle.setFork(Double.parseDouble(f.format(Math.random() * (((500+(rate*500)) - (((rate*450)+450) + 1)) + ((rate*450)+450)))));
		handle.setFront_brakes(Double.parseDouble(f.format(Math.random() * (((450+(rate*450)) - (((rate*400)+400) + 1)) + ((rate*400)+400)))));
		handle.setHandlebar_grip(Double.parseDouble(f.format(Math.random() * (((500+(rate*500)) - (((rate*450)+450) + 1)) + ((rate*450)+450)))));
		handle.setHead_tube(Double.parseDouble(f.format(Math.random() * (((500+(rate*500)) - (((rate*450)+450) + 1)) + ((rate*450)+450)))));
		handle.setShock_absorber(Double.parseDouble(f.format(Math.random() * (((150+(rate*150)) - (((rate*100)+100) + 1)) + ((rate*100)+100)))));
		
		Seating seat=new Seating();
		seat.setSaddle(Double.parseDouble(f.format(Math.random() * (((500+(rate*500)) - (((rate*450)+450) + 1)) + ((rate*450)+450)))));
		seat.setSeat_post(Double.parseDouble(f.format(Math.random() * (((200+(rate*200)) - (((rate*150)+150) + 1)) + ((rate*150)+150)))));
		
		Wheels wheels=new Wheels();
		wheels.setRim(Double.parseDouble(f.format(Math.random() * (((300+(rate*300)) - (((rate*250)+250) + 1)) + ((rate*250)+250)))));
		wheels.setSpokes(Double.parseDouble(f.format(Math.random() * (((200+(rate*200)) - (((rate*150)+150) + 1)) + ((rate*150)+150)))));
		wheels.setTube(Double.parseDouble(f.format(Math.random() * (((200+(rate*200)) - (((rate*150)+150) + 1)) + ((rate*150)+150)))));
		wheels.setTyre(Double.parseDouble(f.format(Math.random() * (((300+(rate*300)) - (((rate*250)+250) + 1)) + ((rate*250)+250)))));
		
		
		
		WholeCycle wholeCycle = new WholeCycle();
		wholeCycle.setChainAssembly(chainAssembly);
		wholeCycle.setFrame(frame);
		wholeCycle.setHandleBarWithBrakes(handle);
		wholeCycle.setSeating(seat);
		wholeCycle.setWheels(wheels);
		

		return wholeCycle;
	}

}