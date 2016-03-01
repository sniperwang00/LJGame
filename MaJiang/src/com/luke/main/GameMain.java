package com.luke.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.luke.constant.GameConstant;
import com.luke.entity.Card;
import com.luke.entity.Player;
import com.luke.utils.GameUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GameMain {
	private Player[] players = new Player[GameConstant.PLAYERS_TOTAL];
	private Card[] cards = new Card[GameConstant.CARDS_TOTAL];
	private static int currentCardPointer = 0;
	private static int currentPlayerPointer = 0;
	private static int currentCardsEndPointer = 135;
	private boolean isFinished = false;
	private boolean isGang = false;
	private boolean isPeng = false;
	private boolean isChi = false;
	private static Card currentDropedCard = null;
 	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.init();
		for(int i=0; i<game.cards.length; i++){
			System.out.println(game.cards[i].getId());
		}
		
		//game start
		game.start();
		
		//game end
		game.end();
	}

	private void start() {
		Card dropedCard = currentDropedCard;
		while(!isFinished){
			//����г�����������ִ�� . isPeng == true ����isChi==true������
			if(!(!isPeng || !isChi)){
				isPeng = false;
				isChi = false;
				Card pickedCard = null;
				if(isGang){
					pickedCard = cards[currentCardsEndPointer];
					currentCardsEndPointer--;
					isGang = false;
				}else{
					pickedCard = cards[currentCardPointer];
				}
				players[currentPlayerPointer].pickCard(pickedCard);
				int result = players[currentPlayerPointer].checkCardAfterPicked(cards[currentCardPointer]);
				currentCardPointer +=1;
				switch(result){
					// ���Ժ���
					case 0: { 
						isFinished = true;
						return;
					}
					// ���Ը���
					case 1: {
						break;
					}
					// ���Գ���
					case 2: {
						dropedCard = players[currentPlayerPointer].dropCard();
						break;
					}
					default: break;
				}
			}
			checkOtherPlayers(dropedCard);
		}
	}
	
	private void end() {
		System.out.println("���" + players[currentPlayerPointer].getName() + "����");
	}

	
	//��ǰ��ҳ��ƺ� ��������������
	private void checkOtherPlayers(Card dropedCard) {
		Integer[] maxResultAndMaxPlayer;
		Integer[] results = new Integer[]{0, 0, 0, 0};
		for(int i=0; i<4; i++){
			if(i != currentPlayerPointer){
				results[i] = players[i].checkCardAfterDroped(dropedCard);
			}
		}
		maxResultAndMaxPlayer = GameUtil.checkResults(results);
		//��ǰ������
		int maxPlayer = maxResultAndMaxPlayer[0];
		//��ǰ��������
		int maxResult = maxResultAndMaxPlayer[1];
		//���������ͣ�������˳����ܣ������¼ҳ���
		if(maxResult==0){
			currentPlayerPointer++;
			isFinished = false;
		}else if(maxResult == 3){
			currentPlayerPointer = maxPlayer;
			//����
			players[currentCardPointer].gangCards(dropedCard);
			isFinished = false;
			isGang = true;
			
		}else if(maxResult == 2){
			currentPlayerPointer = maxPlayer;
			players[currentPlayerPointer].pengCard(dropedCard);
			currentDropedCard = players[currentPlayerPointer].dropCard();
			currentPlayerPointer++;
			isPeng = true;
			isFinished = false;
		}else if(maxResult == 1){
			currentPlayerPointer = maxPlayer;
			players[currentPlayerPointer].chiCard(dropedCard);
			currentDropedCard = players[currentPlayerPointer].dropCard();
			currentPlayerPointer++;
			isChi = true;
			isFinished = false;
		}else if(maxResult == 4){
			currentPlayerPointer = maxPlayer;
			isFinished = true;
		}
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
		
		// ����
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
