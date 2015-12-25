package com.luke.entity;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class Player {
	private int score;
	private Card[] cardsInHand;
	private String name;
	private int cardsInHandCount = 13;
	
	public Player(String name, int score){
		this.setScore(score);
		this.setName(name);
	}
	
	/**
	 * check current player's card
	 * @return Integer
	 * 0 for 和牌
	 * 1 for 可以开杠
	 * 2 for 出牌
	 */
	public Integer checkCard() {
		int result = 2;
		return result;
	}
	
	/**
	 * check other player's card
	 */
	public void checkCard(Card dropedCard) {
		
	}
	
	/**
	 * pick a card
	 * @return Card
	 */
	public void pickCard(Card card){
		cardsInHand[cardsInHandCount + 1] = card;
	}
	
	/**
	 * drop a card
	 * @return
	 */
	public Card dropCard() {
		// 添加玩家输入，选择舍牌
		int i = 0;
		return cardsInHand[i];
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Card[] getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(Card[] cardsInHand) {
		this.cardsInHand = cardsInHand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCardsInHandCount() {
		return cardsInHandCount;
	}

	public void setCardsInHandCount(int cardsInHandCount) {
		this.cardsInHandCount = cardsInHandCount;
	}






	
	
}
