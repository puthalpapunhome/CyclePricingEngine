package com.cycleAPI.model;

public class Frame {
	private double top_tube=0;
    private double down_tube=0;
    private double seat_tube=0;
    private double seat_stay=0;
    private double chain_stay=0;
	public double getTop_tube() {
		return top_tube;
	}
	public void setTop_tube(double top_tube) {
		this.top_tube = top_tube;
	}
	public double getDown_tube() {
		return down_tube;
	}
	public void setDown_tube(double down_tube) {
		this.down_tube = down_tube;
	}
	public double getSeat_tube() {
		return seat_tube;
	}
	public void setSeat_tube(double seat_tube) {
		this.seat_tube = seat_tube;
	}
	public double getSeat_stay() {
		return seat_stay;
	}
	public void setSeat_stay(double seat_stay) {
		this.seat_stay = seat_stay;
	}
	public double getChain_stay() {
		return chain_stay;
	}
	public void setChain_stay(double chain_stay) {
		this.chain_stay = chain_stay;
	}
	public double getToalFrame() {
		
		return getTop_tube()+getDown_tube()+getSeat_tube()+getSeat_stay()+getChain_stay();
	}
	public String getDisplay() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("---comonent of frames----\n");
		sb.append("top_tube: "+getTop_tube()+"\n");
		sb.append("down_tube: "+getDown_tube()+"\n");
		sb.append("seat_tube: "+getSeat_tube()+"\n");
		sb.append("seat_stay: "+getSeat_stay()+"\n");
		sb.append("chain_stay: "+getChain_stay()+"\n");
		sb.append("total: "+getToalFrame()+"\n");
		return sb.toString();
	}
}
