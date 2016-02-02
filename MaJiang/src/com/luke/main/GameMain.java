package com.luke.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.luke.constant.GameConstant;
import com.luke.entity.Card;
import com.luke.entity.Player;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GameMain {
	private Player[] players = new Player[GameConstant.PLAYERS_TOTAL];
	private Card[] cards = new Card[GameConstant.CARDS_TOTAL];
	private int currentCardPointer = 0;
	private int currentPlayerPointer = 0;
	private int currentCardsEndPointer = 135;
 	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.init();
		for(int i=0; i<game.cards.length; i++){
			System.out.println(game.cards[i].getId());
		}
		
		//game start
		game.start();
		
		
	}

	private void start() {
		boolean isFinished = false;
		Card dropedCard = null;
		while(!isFinished){
			players[currentPlayerPointer].pickCard(cards[currentCardPointer]);
			currentCardPointer +=1;
			int result = players[currentPlayerPointer].checkCard();
			switch(result){
				// 可以和牌
				case 0: { 
					isFinished = true;
					return;
				}
				// 可以杠牌
				case 1: {
					break;
				}
				// 可以出牌
				case 2: {
					dropedCard = players[currentPlayerPointer].dropCard();
					break;
				}
				default: break;
			}
			
			isFinished = checkOtherPlayers(currentPlayerPointer, dropedCard);
		}
	}
	
	//当前玩家出牌后， 检查其他玩家手牌
	private boolean checkOtherPlayers(int currentPlayerPointer, Card dropedCard) {
		boolean result = false;
		for(int i=0; i<4; i++){
			if(i != currentPlayerPointer){
				players[i].checkCard(dropedCard);
			}
		}
		return result;
	}

	private void init() {
		//init players
		players[0] = new Player("player1", 25000);
		players[1] = new Player("player2", 25000);
		players[2] = new Player("player3", 25000);
		players[3] = new Player("player4", 25000);
		//init cards
		ArrayList<Card> list = new ArrayList<Card>();
		for(int i=0; i<cards.length; i++){
			Card card = new Card(i);
			list.add(card);
		}
		Collections.shuffle(list);// shuffle the cards
		list.toArray(cards);
		
		// 配牌
		for (int i = 0; i < 13; i++) {
			players[0].getCardsInHand()[i] = cards[i];
			players[1].getCardsInHand()[i] = cards[i + 12 + 1];
			players[2].getCardsInHand()[i] = cards[i + 12 * 2 + 1];
			players[3].getCardsInHand()[i] = cards[i + 12 * 3 + 1];
		}
		
		currentCardPointer = 13*4;
	}

	public int getCurrentCardPointer() {
		return currentCardPointer;
	}

	public void setCurrentCardPointer(int currentCardPointer) {
		this.currentCardPointer = currentCardPointer;
	}
}
