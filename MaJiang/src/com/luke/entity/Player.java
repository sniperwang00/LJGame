package com.luke.entity;

public class Player {
	private int score;
	private Card[] cardsInHand;
	private String name;
	public Player(String name, int score){
		this.score = score;
		this.name = name;
	}
}
