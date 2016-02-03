package com.luke.utils;

public class GameUtil {

	public static Integer[] checkResults(Integer[] results) {
		int maxResult = 0;
		int maxPlayer = 1;
		for(int i=0; i<4; i++){
			if(results[i] > maxResult){
				maxResult = results[i];
				maxPlayer = i+1;
			}
		}
		return new Integer[]{maxPlayer, maxResult};
	}

}
