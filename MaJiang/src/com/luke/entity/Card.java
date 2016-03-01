package com.luke.entity;


public class Card {
	private int id;
	
	/**
	 * example: Ò»Íò  = value(1) + type(M)
	 * example: ¶«  = value(0) + type(D)
	 */
	private String type;
	private int value;
	
	public Card(int id){
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
