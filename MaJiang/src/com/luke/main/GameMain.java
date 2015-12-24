package com.luke.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.luke.constatint.GameConstatint;
import com.luke.entity.Card;
import com.luke.entity.Player;

public class GameMain {
	private Player[] players = new Player[GameConstatint.PLAYERS_TOTAL];
	private Card[] cards = new Card[GameConstatint.CARDS_TOTAL];
 	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.init();
		for(int i=0; i<game.cards.length; i++){
			System.out.println(game.cards[i].getId());
		}
		
		//game start
		//ÅäÅÆ
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
	}
}
