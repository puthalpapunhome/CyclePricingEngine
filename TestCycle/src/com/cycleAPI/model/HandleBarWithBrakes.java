package com.cycleAPI.model;

public class HandleBarWithBrakes {
	private double handlebar_grip = 0;
	private double head_tube = 0;
	private double shock_absorber = 0;
	private double front_brakes = 0;
	private double fork = 0;

	public double getHandlebar_grip() {
		return handlebar_grip;
	}

	public void setHandlebar_grip(double handlebar_grip) {
		this.handlebar_grip = handlebar_grip;
	}

	public double getHead_tube() {
		return head_tube;
	}

	public void setHead_tube(double head_tube) {
		this.head_tube = head_tube;
	}

	public double getShock_absorber() {
		return shock_absorber;
	}

	public void setShock_absorber(double shock_absorber) {
		this.shock_absorber = shock_absorber;
	}

	public double getFront_brakes() {
		return front_brakes;
	}

	public void setFront_brakes(double front_brakes) {
		this.front_brakes = front_brakes;
	}

	public double getFork() {
		return fork;
	}

	public void setFork(double fork) {
		this.fork = fork;
	}

	public double getTotalHandle() {
		// TODO Auto-generated method stub
		return getHandlebar_grip() + getHead_tube() + getShock_absorber()
				+ getFront_brakes() + getFork();
	}

	public String getDisplay() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("---handle_bar_with_brakes----\n");
		sb.append("handlebar_grip: " + getHandlebar_grip() + "\n");
		sb.append("head_tube: " + getHead_tube() + "\n");
		sb.append("shock_absorber: " + getShock_absorber() + "\n");
		sb.append("front_brakes: " + getFront_brakes() + "\n");
		sb.append("fork: " + getFork() + "\n");
		sb.append("total: " + getTotalHandle() + "\n");
		return sb.toString();
	}
}
