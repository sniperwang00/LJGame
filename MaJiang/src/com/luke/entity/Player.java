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
	public Integer checkCardAfterPicked(Card pickedCard) {
		int result = 2;
		return result;
	}
	
	/**
	 * check other player's card
	 */
	public Integer checkCardAfterDroped(Card dropedCard) {
		int result = 0;
		if(true){
			result = 4;
		}
		if("peng"){
			result = 3;
		}
		if("chi"){
			result = 2;
		}
		return result;
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
	
	/**
	 * 杠
	 * @param card
	 */
	public void gangCards(Card card){
		
	}
	/**
	 * 碰
	 * @param card
	 */
	public void pengCard(Card dropedCard) {
		
	}
	/**
	 * 吃
	 * @param card
	 */
	public void chiCard(Card dropedCard) {
		// TODO Auto-generated method stub
		
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
