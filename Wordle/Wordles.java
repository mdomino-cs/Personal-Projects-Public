package Wordle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Wordles implements ActionListener{

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new MyFrame();
		File file = new File("C:\\Users\\MDomino2024\\Downloads\\sgb-words.txt");
		File officalWords = new File("C:\\Users\\MDomino2024\\Downloads\\english3.txt");
		Scanner scan = new Scanner(file);
		Scanner scan2 = new Scanner(officalWords);
		String word = getWordEnglish5(file, scan);
		Scanner console = new Scanner(System.in);
		playGame(console, officalWords, scan2, word);
	}
	//gets length of word and the language
	public static int [] getLengthOfWord() {
		int [] lengthOfWord = new int[2];
		boolean [] ifDone = new boolean[1];
		JButton button5;
		JButton button6;
		JButton button7;
		JButton buttonSpanish;
		JButton buttonHard;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		
		
		button5 = new JButton("English 5");
		button5.setForeground(Color.BLACK);
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lengthOfWord[0]=5;
				ifDone[0]=true;
			}
		});
		buttonHard = new JButton("Hard Mode");
		buttonHard.setForeground(Color.BLACK);
		buttonHard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lengthOfWord[0]=5;
				lengthOfWord[1]=2;
				ifDone[0]=true;
			}
		});
		
		button6 = new JButton("English 6");
		button6.setForeground(Color.BLACK);
		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lengthOfWord[0]=6;
				ifDone[0]=true;
			}
		});

		button7 = new JButton("English 7");
		button7.setForeground(Color.BLACK);
		button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lengthOfWord[0]=7;
				ifDone[0]=true;
			}
		});

		buttonSpanish = new JButton("Spanish 5");
		buttonSpanish.setForeground(Color.BLACK);
		buttonSpanish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lengthOfWord[0]=5;
				lengthOfWord[1]=1;
				ifDone[0]=true;
			}
		});
		frame.setLayout(new GridLayout(3,2));
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(buttonSpanish);
		frame.add(buttonHard);
		frame.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ifDone[0]) {
			frame.setVisible(false);
			return lengthOfWord;
		}else {
			lengthOfWord[0]=5;
			frame.setVisible(true);
			return lengthOfWord;
		}
	}
	//picks the color of keyboard
	public Color getColor() {
		ColorChooser Color1 = new ColorChooser();
		Color pickedColor = Color1.pickAColor();
		return pickedColor;
	}
	//gets and english word
	public static String getWordEnglish5(File file, Scanner scan) {
		int spot = (int) (Math.random() * 451);
		int count = 0;
		while (scan.hasNextLine()) {
			count++;
			if (count == spot) {
				return scan.nextLine();
			} else {
				scan.nextLine();
			}
		}
		return "";
	}
	//gets spanish word
	public static String getSpnaishWord(File file,Scanner scan) {
		int spot = (int) (Math.random() * 227);
		int count = 0;
		while (scan.hasNextLine()) {
			count++;
			if (count == spot) {
				return scan.nextLine();
			} else {
				scan.nextLine();
			}
		}
		return "";
	}
	//checks if the guess is a word
	public static boolean isWord(File officalWords, String guess, String word) throws FileNotFoundException {
		Scanner scan2 = new Scanner(officalWords);
		do {
			if (scan2.nextLine().equals(guess)||guess.equals(word)) {
				return true;
			}
		}while(scan2.hasNextLine());
		return false;
	}
	//tells us if the user's word is correct and if in worng spot
	public static String [] giveHints(String guess, String word,int wordLength) {
		String[] hints = new String[wordLength];
		String[] helperGuess = new String[wordLength];
		String[] helperWord = new String[wordLength];

		for (int i = 0; i < wordLength; i++)
			helperGuess[i] = guess.substring(i, i + 1);
		for (int i = 0; i < wordLength; i++)
			helperWord[i] = word.substring(i, i + 1);

		for (int i = 0; i < wordLength; i++) {
			if (guess.substring(i, i + 1).equals(word.substring(i, i + 1))) {
				hints[i] = "g";
				helperGuess[i] = " ";
				helperWord[i] = " ";
			}
		}

		for (int i = 0; i < wordLength; i++) {
			for (int j = 0; j < wordLength; j++) {
				if (!(helperGuess[i].equals(" ")) && !(helperWord[j].equals(" "))
						&& helperWord[j].equals(guess.substring(i, i + 1))) {
					hints[i] = "y";
					helperGuess[i] = " ";
					helperWord[j] = " ";
				}
			}
		}
		return hints;
	}


	public static void playGame(Scanner console, File officalWords, Scanner scan2, String word) throws FileNotFoundException {
		String [] hint = new String[word.length()];
		String userGuess = " ";
		for (int i = 0; i < word.length(); i++) {
			do {
				userGuess = console.nextLine();
			} while (!(isWord(officalWords,userGuess, word)));
			if(userGuess.equals(word)) {
				i = word.length();
			}else if(i==word.length()-1){
			}else {
			}
		}
		
	}
}
