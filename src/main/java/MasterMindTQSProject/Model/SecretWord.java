package MasterMindTQSProject.Model;

import java.util.Random;

public class SecretWord{
	
	private int word_length;
	private int min_number;
	private int secretWord[];
	RandomInterface r;
	
	
	public void setRandomInterface(RandomInterface r) {
		this.r = r;
	}
	
	public SecretWord(RandomInterface random) {
		word_length = 5;
		min_number = 1;
		secretWord = new int[word_length];
		this.r = random;
	}
	
	public SecretWord(int length, int min, RandomInterface random) {
		word_length = length;
		min_number = min;
		secretWord = new int[word_length];
		this.r = random;
	}

	public int getWord_length() {
		return word_length;
	}

	public void setWord_length(int word_length) {
		this.word_length = word_length;
	}

	public int getMin_number() {
		return min_number;
	}

	public void setMin_number(int min_number) {
		this.min_number = min_number;
	}

	public int[] getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(int[] secretWord) {
		this.secretWord = secretWord;
	}
	
	
	public void generateSecretWord(int length, int minValue) {
		int low, high;
		low = minValue;
		high = (length-1) + minValue;
		for (int i = 0; i < length; i++) {
			this.secretWord[i] = r.nextInt(high,low);
		}
	}
	
	//This function generate a code without duplicated numbers
	/*public void generateSecretWord(int length, int minValue) {
		Random r = new Random();
		int counter = 0;
		int value;
		
		int numbers[] = new int[length];
		
		for(int i = minValue; i<(minValue+length); i++) {
			System.out.println("Estoy en el primer bucle");
			numbers[counter] = i;
			counter++;
		}
		
		for(int i = 0; i<length; i++) {
			System.out.println("He entrado en el bucle aleatorio");
			value = r.nextInt(length -1);
			while(numbers[value] == -1) {
				System.out.println(value);
				value = r.nextInt(length);
			}
			this.secretWord[i] = numbers[value];
			numbers[value] = -1;
		}
		
		for(int i = 0; i< length; i++) {
			System.out.println(this.secretWord[i]);
		}
	}*/
	
	/*
	private boolean hasDuplicated(int[] secret) {
		int i, j;
		boolean duplicated = false;
		for(i = 0; i<5; i++) {
			for(j= 0; j<5; j++) {
				if((i != j) && (secret[i]==secret[j])) {
					System.out.println("Duplicated values!");
					duplicated = true;
				}
			}
		}
		
		return duplicated;
	}*/
	
	/*public boolean itIsInRange() {
		boolean inRange = true;
		int i = 0;
		int min = this.min_number;
		int max = (this.word_length-1)+min;
		while(inRange && i < this.word_length) {
			if (this.secretWord[i] < min || this.secretWord[i] > max) {
				inRange = false;
			}
			else {
				i++;
			}
		}
		
		return inRange;
	}*/
	
	/*
	public boolean proxyHasDuplicated(int[] secretWord) 
	{
		return hasDuplicated(secretWord);
	}*/
}
