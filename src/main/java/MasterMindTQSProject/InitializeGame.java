package MasterMindTQSProject;

import MasterMindTQSProject.Controller.MasterMind;
import MasterMindTQSProject.Model.MyScanner;
import MasterMindTQSProject.Model.ScannerInterface;

public class InitializeGame {

	public static void main(String[] args) {
		//ScannerInterface sc = new MockMyScanner();
		ScannerInterface sc = new MyScanner();
		MasterMind masterMind = new MasterMind(sc);
		int keepPlaying = 1;
		while(keepPlaying==1) {
			masterMind.initGame();
			masterMind.startGame();
			keepPlaying = masterMind.askPlayAgain(); 
		}
	}
}
