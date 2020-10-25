package MasterMindTQSProject;

import java.util.Scanner;

public class Game {

	private int tries;
	private int codeTry[];
	public SecretWord secretWord;
	
	Game(){
		tries = 10;
	}
	
	private void askTries() {
		System.out.print("Insert the number of tries: ");
		Scanner sc = new Scanner(System.in);
		this.tries = sc.nextInt();
	}
	
	public void selectMode() {
		int mode = 0;
		 do{
			System.out.println("Choose an option ");
			System.out.println("[1] Default mode");
			System.out.println("[2] Customized mode");
			System.out.print("Option selected: ");
			Scanner sc = new Scanner(System.in);
			mode = sc.nextInt();
			switch(mode) {
			case 1: 
				this.secretWord = new SecretWord();
				break;
			case 2:
				int length;
				int minValue;
				System.out.print("Insert the length of the secret word: ");
				length = sc.nextInt();
				System.out.print("Insert the minimum value of the secret word: ");
				minValue = sc.nextInt();
				this.secretWord = new SecretWord(length,minValue);
				askTries();
				break;
			default:
				System.out.print("This is not a correct option");
				break;
				
			}
		}while(mode != 1 && mode != 2);
		
	}
	
	public void proxyAskTries() {
		askTries();
	}

	public int getTries() {
		return tries;
	}
	
	public void askCode() {
		boolean converted = false;
		Scanner sc = new Scanner(System.in);
		int []numbersList = new int[this.secretWord.getWord_length()];
		
		while(!converted) {
			System.out.println("Insert your answer code; example [1 2 3 4 5]");
			String strNumbers = sc.nextLine();
			String []StrNumbersArray = strNumbers.split(" ");

			if(StrNumbersArray.length == this.secretWord.getWord_length()) {
				for(int i=0; i<this.secretWord.getWord_length(); i++) {
					numbersList[i] = Integer.parseInt(StrNumbersArray[i]);
				}
				
				this.codeTry=numbersList;
				
				if(this.itIsInRange())
					converted = true;
			}
		}
	}
	
	public boolean itIsInRange() {
		boolean inRange = true;
		int i = 0;
		int min = this.secretWord.getMin_number();
		int max = (this.secretWord.getWord_length()-1)+min;
		while(inRange && i < this.secretWord.getWord_length()) {
			if (this.codeTry[i] < min || this.codeTry[i] > max) {
				inRange = false;
			}
			else {
				i++;
			}
		}
		
		return inRange;
	}
	
	public int[] getCodeTry() {
		return codeTry;
	}
	
}