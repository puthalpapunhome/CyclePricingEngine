package com.cycleAPI.model;

public class Wheels {
	private double spokes = 0;
	private double rim = 0;
	private double tube = 0;
	private double tyre = 0;

	public double getSpokes() {
		return spokes;
	}

	public void setSpokes(double spokes) {
		this.spokes = spokes;
	}

	public double getRim() {
		return rim;
	}

	public void setRim(double rim) {
		this.rim = rim;
	}

	public double getTube() {
		return tube;
	}

	public void setTube(double tube) {
		this.tube = tube;
	}

	public double getTyre() {
		return tyre;
	}

	public void setTyre(double tyre) {
		this.tyre = tyre;
	}

	public double getTotalWheels() {
		// TODO Auto-generated method stub
		return getRim() + getSpokes() + getTyre() + getTube();
	}

	public String getDisplay() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("---wheels----\n");
		sb.append("spokes: " + getSpokes() + "\n");
		sb.append("rim: " + getRim() + "\n");
		sb.append("tube: " + getTube() + "\n");
		sb.append("tyre: " + getTyre() + "\n");
		sb.append("total: " + getTotalWheels() + "\n");
		return sb.toString();
	}
}
