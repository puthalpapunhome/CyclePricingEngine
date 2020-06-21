package com.cycleAPI.model;

public class Seating {
	 private double saddle=0;
     private double seat_post=0;
	public double getSaddle() {
		return saddle;
	}
	public void setSaddle(double saddle) {
		this.saddle = saddle;
	}
	public double getSeat_post() {
		return seat_post;
	}
	public void setSeat_post(double seat_post) {
		this.seat_post = seat_post;
	}
	public double getToalSeat() {
		// TODO Auto-generated method stub
		return getSeat_post()+getSaddle();
	}
	public String getDisplay() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("---seating----\n");
		sb.append("saddle: "+getSaddle()+"\n");
		sb.append("seat_post: "+getSeat_post()+"\n");
		sb.append("total: "+getToalSeat()+"\n");
		
		return sb.toString();
	}
}
