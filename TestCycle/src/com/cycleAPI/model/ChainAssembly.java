package com.cycleAPI.model;

public class ChainAssembly {
	private double chain=0;
	private double chain_ring=0;
	public double getChain() {
		return chain;
	}
	public void setChain(double chain) {
		this.chain = chain;
	}
	public double getChain_ring() {
		return chain_ring;
	}
	public void setChain_ring(double chain_ring) {
		this.chain_ring = chain_ring;
	}
	public double getTotalChain() {
		// TODO Auto-generated method stub
		return getChain()+getChain_ring();
	}
	public String getDisplay() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("---chain----\n");
		sb.append("chain: "+getChain()+"\n");
		sb.append("chain_ring: "+getChain_ring()+"\n");
		sb.append("total: "+getTotalChain()+"\n");
		
		return sb.toString();
	}
}
