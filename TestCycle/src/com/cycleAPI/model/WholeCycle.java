package com.cycleAPI.model;

public class WholeCycle {

	private ChainAssembly ChainAssembly;
	private Frame Frame;
	private HandleBarWithBrakes handleBarWithBrakes;
	private Seating seating;
	private Wheels wheels;
	private WholeCycle wholecycle;

	public ChainAssembly getChainAssembly() {
		return ChainAssembly;
	}

	public void setChainAssembly(ChainAssembly chainAssembly) {
		ChainAssembly = chainAssembly;
	}

	public Frame getFrame() {
		return Frame;
	}

	public void setFrame(Frame frame) {
		Frame = frame;
	}

	public HandleBarWithBrakes getHandleBarWithBrakes() {
		return handleBarWithBrakes;
	}

	public void setHandleBarWithBrakes(HandleBarWithBrakes handleBarWithBrakes) {
		this.handleBarWithBrakes = handleBarWithBrakes;
	}

	public Seating getSeating() {
		return seating;
	}

	public void setSeating(Seating seating) {
		this.seating = seating;
	}

	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}

	public WholeCycle getWholecycle() {
		return wholecycle;
	}

	public void setWholecycle(WholeCycle wholecycle) {
		this.wholecycle = wholecycle;
	}

}
