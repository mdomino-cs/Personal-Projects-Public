package Wordle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class MyFrame extends JFrame implements ActionListener, KeyListener {
	ImageIcon icon;
	JButton buttonA;
	JButton buttonB;
	JButton buttonEnter;
	JButton buttonZ;
	JButton buttonC;
	JButton buttonX;
	JButton buttonV;
	JButton buttonN;
	JButton buttonM;
	JButton buttonS;
	JButton buttonD;
	JButton buttonF;
	JButton buttonG;
	JButton buttonH;
	JButton buttonJ;
	JButton buttonK;
	JButton buttonL;
	JButton buttonQ;
	JButton buttonW;
	JButton buttonE;
	JButton buttonR;
	JButton buttonT;
	JButton buttonY;
	JButton buttonU;
	JButton buttonI;
	JButton buttonO;
	JButton buttonP;
	JButton buttonBackSpace;
	public Graphics g;
	public Graphics g2;
	public Graphics g3;
	boolean didSomething;
	JLabel label1 = new JLabel("Test");
	String temp;
	boolean ifStarted = false;

	int width = 550;
	int height = 600;
	String[][] board = new String[6][5];
	boolean gameStop =true;
	public static void main(String[] args) throws FileNotFoundException {
	}

	Wordles color = new Wordles();
	Color custom = color.getColor();
	int [] wordLength = Wordles.getLengthOfWord();
	String word = "";
	int i = 0;
	int j = 1;
	String word1 = "";
     //this makes our myFrame
	MyFrame() {
		// bottom row
				buttonEnter = new JButton("Enter");
				buttonEnter.setForeground(custom);
				buttonEnter.setBounds(30, height - 85, 70, 45);
				buttonEnter.addActionListener(this);

				buttonZ = new JButton("z");
				buttonZ.setForeground(custom);
				buttonZ.setBounds(105, height - 85, 45, 45);
				buttonZ.addActionListener(this);

				buttonX = new JButton("x");
				buttonX.setForeground(custom);
				buttonX.setBounds(155, height - 85, 45, 45);
				buttonX.addActionListener(this);

				buttonC = new JButton("c");
				buttonC.setForeground(custom);
				buttonC.setBounds(205, height - 85, 45, 45);
				buttonC.addActionListener(this);

				buttonV = new JButton("v");
				buttonV.setForeground(custom);
				buttonV.setBounds(255, height - 85, 45, 45);
				buttonV.addActionListener(this);

				buttonB = new JButton("b");
				buttonB.setForeground(custom);
				buttonB.setBounds(305, height - 85, 45, 45);
				buttonB.addActionListener(this);

				buttonN = new JButton("n");
				buttonN.setForeground(custom);
				buttonN.setBounds(355, height - 85, 45, 45);
				buttonN.addActionListener(this);

				buttonM = new JButton("m");
				buttonM.setForeground(custom);
				buttonM.setBounds(405, height - 85, 45, 45);
				buttonM.addActionListener(this);

				buttonBackSpace = new JButton("Back");
				buttonBackSpace.setForeground(custom);
				buttonBackSpace.setBounds(455, height - 85, 70, 45);
				buttonBackSpace.addActionListener(this);

				// middle row
				buttonA = new JButton("a");
				buttonA.setForeground(custom);
				buttonA.setBounds(50, height - 130, 45, 45);
				buttonA.addActionListener(this);

				buttonS = new JButton("s");
				buttonS.setForeground(custom);
				buttonS.setBounds(100, height - 130, 45, 45);
				buttonS.addActionListener(this);

				buttonD = new JButton("d");
				buttonD.setForeground(custom);
				buttonD.setBounds(150, height - 130, 45, 45);
				buttonD.addActionListener(this);

				buttonF = new JButton("f");
				buttonF.setForeground(custom);
				buttonF.setBounds(200, height - 130, 45, 45);
				buttonF.addActionListener(this);

				buttonG = new JButton("g");
				buttonG.setForeground(custom);
				buttonG.setBounds(250, height - 130, 45, 45);
				buttonG.addActionListener(this);

				buttonH = new JButton("h");
				buttonH.setForeground(custom);
				buttonH.setBounds(300, height - 130, 45, 45);
				buttonH.addActionListener(this);

				buttonJ = new JButton("j");
				buttonJ.setForeground(custom);
				buttonJ.setBounds(350, height - 130, 45, 45);
				buttonJ.addActionListener(this);

				buttonK = new JButton("k");
				buttonK.setForeground(custom);
				buttonK.setBounds(400, height - 130, 45, 45);
				buttonK.addActionListener(this);

				buttonL = new JButton("l");
				buttonL.setForeground(custom);
				buttonL.setBounds(450, height - 130, 45, 45);
				buttonL.addActionListener(this);

				// top row
				buttonQ = new JButton("q");
				buttonQ.setForeground(custom);
				buttonQ.setBounds(30, height - 175, 45, 45);
				buttonQ.addActionListener(this);

				buttonW = new JButton("w");
				buttonW.setForeground(custom);
				buttonW.setBounds(80, height - 175, 45, 45);
				buttonW.addActionListener(this);

				buttonE = new JButton("e");
				buttonE.setForeground(custom);
				buttonE.setBounds(130, height - 175, 45, 45);
				buttonE.addActionListener(this);

				buttonR = new JButton("r");
				buttonR.setForeground(custom);
				buttonR.setBounds(180, height - 175, 45, 45);
				buttonR.addActionListener(this);

				buttonT = new JButton("t");
				buttonT.setForeground(custom);
				buttonT.setBounds(230, height - 175, 45, 45);
				buttonT.addActionListener(this);

				buttonY = new JButton("y");
				buttonY.setForeground(custom);
				buttonY.setBounds(280, height - 175, 45, 45);
				buttonY.addActionListener(this);

				buttonU = new JButton("u");
				buttonU.setForeground(custom);
				buttonU.setBounds(330, height - 175, 45, 45);
				buttonU.addActionListener(this);

				buttonI = new JButton("i");
				buttonI.setForeground(custom);
				buttonI.setBounds(380, height - 175, 45, 45);
				buttonI.addActionListener(this);

				buttonO = new JButton("o");
				buttonO.setForeground(custom);
				buttonO.setBounds(430, height - 175, 45, 45);
				buttonO.addActionListener(this);

				buttonP = new JButton("p");
				buttonP.setForeground(custom);
				buttonP.setBounds(480, height - 175, 45, 45);
				buttonP.addActionListener(this);

				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setLayout(null);
				this.setSize(width, height);
				this.addKeyListener(this);
				this.setFocusable(true);

				

				// bottom row
				this.add(buttonZ);
				this.add(buttonX);
				this.add(buttonC);
				this.add(buttonV);
				this.add(buttonB);
				this.add(buttonN);
				this.add(buttonM);
				this.add(buttonBackSpace);
				this.add(buttonEnter);

				// middle row
				this.add(buttonA);
				this.add(buttonS);
				this.add(buttonD);
				this.add(buttonF);
				this.add(buttonG);
				this.add(buttonH);
				this.add(buttonJ);
				this.add(buttonK);
				this.add(buttonL);

				// top row
				this.add(buttonQ);
				this.add(buttonW);
				this.add(buttonE);
				this.add(buttonR);
				this.add(buttonT);
				this.add(buttonY);
				this.add(buttonU);
				this.add(buttonI);
				this.add(buttonO);
				this.add(buttonP);

				this.setVisible(true);
	}
	//makes the buttons and draws the rectangles
	public void paint(Graphics g) {
		if (wordLength[0] == 5) {
			for (int j = 1; j <= 6; j++) {
				for (int i = 1; i <= wordLength[0]; i++) {
					g.drawRect((50 * i) + 100, 50 * j + 50, 50, 50);
					// g.setFont(new Font("Impact", Font.PLAIN, 20));
					// g.drawString("A", (50 * i) + 120, 50 * j + 80);
				}
			}
		}
		if (wordLength[0] == 6) {
			for (int j = 1; j <= 6; j++) {
				for (int i = 1; i <= wordLength[0]; i++) {
					g.drawRect((50 * i) + 75, 50 * j + 50, 50, 50);
					// g.setFont(new Font("Impact", Font.PLAIN, 20));
					// g.drawString("A", (50 * i) + 95, 50 * j + 80);
				}
			}
		}
		if (wordLength[0] == 7) {
			for (int j = 1; j <= 6; j++) {
				for (int i = 1; i <= wordLength[0]; i++) {
					g.drawRect((50 * i) + 50, 50 * j + 50, 50, 50);
					// g.setFont(new Font("Impact", Font.PLAIN, 20));
					// g.drawString("A", (50 * i) + 70, 50 * j + 80);
				}
			}

		}
		buttonQ.repaint();
		buttonW.repaint();
		buttonE.repaint();
		buttonR.repaint();
		buttonT.repaint();
		buttonY.repaint();
		buttonU.repaint();
		buttonI.repaint();
		buttonO.repaint();
		buttonP.repaint();
		buttonA.repaint();
		buttonS.repaint();
		buttonD.repaint();
		buttonF.repaint();
		buttonG.repaint();
		buttonH.repaint();
		buttonJ.repaint();
		buttonK.repaint();
		buttonL.repaint();
		buttonZ.repaint();
		buttonX.repaint();
		buttonC.repaint();
		buttonV.repaint();
		buttonB.repaint();
		buttonN.repaint();
		buttonM.repaint();
		buttonEnter.repaint();
		buttonBackSpace.repaint();


	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	//this is for the keyboard
	public void keyPressed(KeyEvent e) {
		if(wordLength[1]==2) {
			ifStarted=true;
			if(ifStarted&&j==1&&i==0) {
				new java.util.Timer().schedule(
						new java.util.TimerTask() {
							@Override
							public void run() {								
									setVisible(false);
									JFrame loser = new JFrame();
									JLabel label = new JLabel("You lose!");
									loser.setSize(200, 200);
									loser.add(label);
									loser.setVisible(true);
							}
						},90000
						);
			}

		}
		g= getGraphics();
		g2 = getGraphics();
		temp ="";
		int letter = e.getKeyCode();
		if(letter == KeyEvent.VK_A && i<wordLength[0]) {
			word = word+"a";
			didSomething=true;
			i++;
			
		}
		if(letter == KeyEvent.VK_B && i<wordLength[0]) {
			word = word+"b";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_C && i<wordLength[0]) {
			word = word+"c";
			didSomething=true;
			i++;
	
		}
		if(letter == KeyEvent.VK_D&& i<wordLength[0]) {
			word = word+"d";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_E&& i<wordLength[0]) {
			word = word+"e";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_F&& i<wordLength[0]) {
			word = word+"f";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_G&& i<wordLength[0]) {
			word = word+"g";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_H&& i<wordLength[0]) {
			word = word+"h";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_I&& i<wordLength[0]) {
			word = word+"i";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_J&& i<wordLength[0]) {
			word = word+"j";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_K&& i<wordLength[0]) {
			word = word+"k";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_L&& i<wordLength[0]) {
			word = word+"l";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_M&& i<wordLength[0]) {
			word = word+"m";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_N&& i<wordLength[0]) {
			word = word+"n";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_O&& i<wordLength[0]) {
			word = word+"o";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_P&& i<wordLength[0]) {
			word = word+"p";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_Q&& i<wordLength[0]) {
			word = word+"r";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_R&& i<wordLength[0]) {
			word = word+"r";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_S&& i<wordLength[0]) {
			word = word+"s";
			didSomething=true;
			i++;
			
		}
		if(letter == KeyEvent.VK_T&& i<wordLength[0]) {
			word = word+"t";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_U&& i<wordLength[0]) {
			word = word+"u";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_V&& i<wordLength[0]) {
			word = word+"v";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_W&& i<wordLength[0]) {
			word = word+"w";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_X&& i<wordLength[0]) {
			word = word +"x";
			didSomething=true;
			i++;
			
		}
		if(letter == KeyEvent.VK_Y&& i<wordLength[0]) {
			word = word+"y";
			didSomething=true;
			i++;
			
		}
		if(letter == KeyEvent.VK_Z&& i<wordLength[0]) {
			word = word+"z";
			didSomething=true;
			i++;
		
		}
		if(letter == KeyEvent.VK_BACK_SPACE && i>0) {
	
			i--;
			word = word.substring(0, i);
			didSomething = true;
			g2.setColor(Color.WHITE);
			if (wordLength[0] == 5)
				g2.fillRect(50 * i + 160, 50 * j + 60, 30, 30);
			if (wordLength[0] == 6)
				g2.fillRect(50 * i + 135, 50 * j + 60, 30, 30);
			if (wordLength[0] == 7)
				g2.fillRect(50 * i + 110, 50 * j + 60, 30, 30);
		}
		if (letter == KeyEvent.VK_ENTER && i < wordLength[0]) {
			
			JFrame WordNotLong = new JFrame();
			JLabel label = new JLabel("Word Not Long Enough!");
			WordNotLong.setSize(100, 100);
			WordNotLong.setVisible(true);
			WordNotLong.add(label);
		}
		if(letter == KeyEvent.VK_ENTER&& i==wordLength[0]) {
		
			gameStop=true;
			try {
				File officalWords;
				if(wordLength[1]==1) {
					officalWords = getFileSpan();
				}else {
				officalWords = getOfficalWords();
				}
				if (j == 1) {
					if(wordLength[0]==5) {
						word1 = getWord5();
						word1=word1.toLowerCase();
					
					}
					if(wordLength[0]==6) {
						word1=getWord6();
						word1=word1.toLowerCase();
					
					}
					if(wordLength[0]==7) {
						word1=getWord7();
						word1=word1.toLowerCase();
						
					}
					if(wordLength[1]==1) {
						word1 = getWordSpanish();
						word1=word1.toLowerCase();
					
					}
				}
				if(wordLength[1]==1) {
					officalWords = getFileSpan();
				}
				if (Wordles.isWord(officalWords, word, word1)) {
					String[] hints = Wordles.giveHints(word, word1,wordLength[0]);
					int w = 0;
					for (int q = 1; q < hints.length + 1; q++) {
						if (hints[q - 1] == null) {
							gameStop=false;
							g2.setColor(Color.GRAY);
							if(wordLength[0]==5)
								w=100;
							if(wordLength[0]==6)
								w=75;
							if(wordLength[0]==7)
								w=50;
							
							g2.fillRect((50 * q) + w, 50 * j + 50, 50, 50);
							temp = word.substring(q - 1, q);
							g.setColor(Color.BLACK);
							if(wordLength[0]==5)
								w=120;
							if(wordLength[0]==6)
								w=95;
							if(wordLength[0]==7)
								w=70;
							g.setFont(new Font("calibri", Font.BOLD, 20));
							g.drawString(temp, (50 * q) + w, 50 * j + 80);
							if (temp.equals("a") && !(buttonA.getBackground().equals(Color.GREEN))
									&& !(buttonA.getBackground().equals(Color.YELLOW))) {
								buttonA.setBackground(Color.GRAY);
							}
							if (temp.equals("b") && !(buttonB.getBackground().equals(Color.GREEN))
									&& !(buttonB.getBackground().equals(Color.YELLOW))) {
								buttonB.setBackground(Color.GRAY);
							}
							if (temp.equals("c") && !(buttonC.getBackground().equals(Color.GREEN))
									&& !(buttonC.getBackground().equals(Color.YELLOW))) {
								buttonC.setBackground(Color.GRAY);
							}
							if (temp.equals("d") && !(buttonD.getBackground().equals(Color.GREEN))
									&& !(buttonD.getBackground().equals(Color.YELLOW))) {
								buttonD.setBackground(Color.GRAY);
							}
							if (temp.equals("e") && !(buttonE.getBackground().equals(Color.GREEN))
									&& !(buttonE.getBackground().equals(Color.YELLOW))) {
								buttonE.setBackground(Color.GRAY);
							}
							if (temp.equals("f") && !(buttonF.getBackground().equals(Color.GREEN))
									&& !(buttonF.getBackground().equals(Color.YELLOW))) {
								buttonF.setBackground(Color.GRAY);
							}
							if (temp.equals("g") && !(buttonG.getBackground().equals(Color.GREEN))
									&& !(buttonG.getBackground().equals(Color.YELLOW))) {
								buttonG.setBackground(Color.GRAY);
							}
							if (temp.equals("h") && !(buttonH.getBackground().equals(Color.GREEN))
									&& !(buttonH.getBackground().equals(Color.YELLOW))) {
								buttonH.setBackground(Color.GRAY);
							}
							if (temp.equals("i") && !(buttonI.getBackground().equals(Color.GREEN))
									&& !(buttonI.getBackground().equals(Color.YELLOW))) {
								buttonI.setBackground(Color.GRAY);
							}
							if (temp.equals("j") && !(buttonJ.getBackground().equals(Color.GREEN))
									&& !(buttonJ.getBackground().equals(Color.YELLOW))) {
								buttonJ.setBackground(Color.GRAY);
							}
							if (temp.equals("k") && !(buttonK.getBackground().equals(Color.GREEN))
									&& !(buttonK.getBackground().equals(Color.YELLOW))) {
								buttonK.setBackground(Color.GRAY);
							}
							if (temp.equals("l") && !(buttonL.getBackground().equals(Color.GREEN))
									&& !(buttonL.getBackground().equals(Color.YELLOW))) {
								buttonL.setBackground(Color.GRAY);
							}
							if (temp.equals("m") && !(buttonM.getBackground().equals(Color.GREEN))
									&& !(buttonM.getBackground().equals(Color.YELLOW))) {
								buttonM.setBackground(Color.GRAY);
							}
							if (temp.equals("n") && !(buttonN.getBackground().equals(Color.GREEN))
									&& !(buttonN.getBackground().equals(Color.YELLOW))) {
								buttonN.setBackground(Color.GRAY);
							}
							if (temp.equals("o") && !(buttonO.getBackground().equals(Color.GREEN))
									&& !(buttonO.getBackground().equals(Color.YELLOW))) {
								buttonO.setBackground(Color.GRAY);
							}
							if (temp.equals("p") && !(buttonP.getBackground().equals(Color.GREEN))
									&& !(buttonP.getBackground().equals(Color.YELLOW))) {
								buttonP.setBackground(Color.GRAY);
							}
							if (temp.equals("q") && !(buttonQ.getBackground().equals(Color.GREEN))
									&& !(buttonQ.getBackground().equals(Color.YELLOW))) {
								buttonQ.setBackground(Color.GRAY);
							}
							if (temp.equals("r") && !(buttonR.getBackground().equals(Color.GREEN))
									&& !(buttonR.getBackground().equals(Color.YELLOW))) {
								buttonR.setBackground(Color.GRAY);
							}
							if (temp.equals("s") && !(buttonS.getBackground().equals(Color.GREEN))
									&& !(buttonS.getBackground().equals(Color.YELLOW))) {
								buttonS.setBackground(Color.GRAY);
							}
							if (temp.equals("t") && !(buttonT.getBackground().equals(Color.GREEN))
									&& !(buttonT.getBackground().equals(Color.YELLOW))) {
								buttonT.setBackground(Color.GRAY);
							}
							if (temp.equals("u") && !(buttonU.getBackground().equals(Color.GREEN))
									&& !(buttonU.getBackground().equals(Color.YELLOW))) {
								buttonU.setBackground(Color.GRAY);
							}
							if (temp.equals("v") && !(buttonV.getBackground().equals(Color.GREEN))
									&& !(buttonV.getBackground().equals(Color.YELLOW))) {
								buttonV.setBackground(Color.GRAY);
							}
							if (temp.equals("w") && !(buttonW.getBackground().equals(Color.GREEN))
									&& !(buttonW.getBackground().equals(Color.YELLOW))) {
								buttonW.setBackground(Color.GRAY);
							}
							if (temp.equals("x") && !(buttonX.getBackground().equals(Color.GREEN))
									&& !(buttonX.getBackground().equals(Color.YELLOW))) {
								buttonX.setBackground(Color.GRAY);
							}
							if (temp.equals("y") && !(buttonY.getBackground().equals(Color.GREEN))
									&& !(buttonY.getBackground().equals(Color.YELLOW))) {
								buttonY.setBackground(Color.GRAY);
							}
							if (temp.equals("z") && !(buttonZ.getBackground().equals(Color.GREEN))
									&& !(buttonZ.getBackground().equals(Color.YELLOW))) {
								buttonZ.setBackground(Color.GRAY);
							}
						}
						if (hints[q - 1] == "y") {
							gameStop=false;
							g2.setColor(Color.YELLOW);
							if(wordLength[0]==5)
								w=100;
							if(wordLength[0]==6)
								w=75;
							if(wordLength[0]==7)
								w=50;
							
							g2.fillRect((50 * q) + w, 50 * j + 50, 50, 50);
							temp = word.substring(q - 1, q);
							g.setColor(Color.BLACK);
							if(wordLength[0]==5)
								w=120;
							if(wordLength[0]==6)
								w=95;
							if(wordLength[0]==7)
								w=70;
							g.setFont(new Font("calibri", Font.BOLD, 20));
							g.drawString(temp, (50 * q) + w, 50 * j + 80);
							if (temp.equals("a") && !(buttonA.getBackground().equals(Color.GREEN))
									&& !(buttonA.getBackground().equals(Color.YELLOW))) {
								buttonA.setBackground(Color.YELLOW);
							}
							if (temp.equals("b") && !(buttonB.getBackground().equals(Color.GREEN))
									&& !(buttonB.getBackground().equals(Color.YELLOW))) {
								buttonB.setBackground(Color.YELLOW);
							}
							if (temp.equals("c") && !(buttonC.getBackground().equals(Color.GREEN))
									&& !(buttonC.getBackground().equals(Color.YELLOW))) {
								buttonC.setBackground(Color.YELLOW);
							}
							if (temp.equals("d") && !(buttonD.getBackground().equals(Color.GREEN))
									&& !(buttonD.getBackground().equals(Color.YELLOW))) {
								buttonD.setBackground(Color.YELLOW);
							}
							if (temp.equals("e") && !(buttonE.getBackground().equals(Color.GREEN))
									&& !(buttonE.getBackground().equals(Color.YELLOW))) {
								buttonE.setBackground(Color.YELLOW);
							}
							if (temp.equals("f") && !(buttonF.getBackground().equals(Color.GREEN))
									&& !(buttonF.getBackground().equals(Color.YELLOW))) {
								buttonF.setBackground(Color.YELLOW);
							}
							if (temp.equals("g") && !(buttonG.getBackground().equals(Color.GREEN))
									&& !(buttonG.getBackground().equals(Color.YELLOW))) {
								buttonG.setBackground(Color.YELLOW);
							}
							if (temp.equals("h") && !(buttonH.getBackground().equals(Color.GREEN))
									&& !(buttonH.getBackground().equals(Color.YELLOW))) {
								buttonH.setBackground(Color.YELLOW);
							}
							if (temp.equals("i") && !(buttonI.getBackground().equals(Color.GREEN))
									&& !(buttonI.getBackground().equals(Color.YELLOW))) {
								buttonI.setBackground(Color.YELLOW);
							}
							if (temp.equals("j") && !(buttonJ.getBackground().equals(Color.GREEN))
									&& !(buttonJ.getBackground().equals(Color.YELLOW))) {
								buttonJ.setBackground(Color.YELLOW);
							}
							if (temp.equals("k") && !(buttonK.getBackground().equals(Color.GREEN))
									&& !(buttonK.getBackground().equals(Color.YELLOW))) {
								buttonK.setBackground(Color.YELLOW);
							}
							if (temp.equals("l") && !(buttonL.getBackground().equals(Color.GREEN))
									&& !(buttonL.getBackground().equals(Color.YELLOW))) {
								buttonL.setBackground(Color.YELLOW);
							}
							if (temp.equals("m") && !(buttonM.getBackground().equals(Color.GREEN))
									&& !(buttonM.getBackground().equals(Color.YELLOW))) {
								buttonM.setBackground(Color.YELLOW);
							}
							if (temp.equals("n") && !(buttonN.getBackground().equals(Color.GREEN))
									&& !(buttonN.getBackground().equals(Color.YELLOW))) {
								buttonN.setBackground(Color.YELLOW);
							}
							if (temp.equals("o") && !(buttonO.getBackground().equals(Color.GREEN))
									&& !(buttonO.getBackground().equals(Color.YELLOW))) {
								buttonO.setBackground(Color.YELLOW);
							}
							if (temp.equals("p") && !(buttonP.getBackground().equals(Color.GREEN))
									&& !(buttonP.getBackground().equals(Color.YELLOW))) {
								buttonP.setBackground(Color.YELLOW);
							}
							if (temp.equals("q") && !(buttonQ.getBackground().equals(Color.GREEN))
									&& !(buttonQ.getBackground().equals(Color.YELLOW))) {
								buttonQ.setBackground(Color.YELLOW);
							}
							if (temp.equals("r") && !(buttonR.getBackground().equals(Color.GREEN))
									&& !(buttonR.getBackground().equals(Color.YELLOW))) {
								buttonR.setBackground(Color.YELLOW);
							}
							if (temp.equals("s") && !(buttonS.getBackground().equals(Color.GREEN))
									&& !(buttonS.getBackground().equals(Color.YELLOW))) {
								buttonS.setBackground(Color.YELLOW);
							}
							if (temp.equals("t") && !(buttonT.getBackground().equals(Color.GREEN))
									&& !(buttonT.getBackground().equals(Color.YELLOW))) {
								buttonT.setBackground(Color.YELLOW);
							}
							if (temp.equals("u") && !(buttonU.getBackground().equals(Color.GREEN))
									&& !(buttonU.getBackground().equals(Color.YELLOW))) {
								buttonU.setBackground(Color.YELLOW);
							}
							if (temp.equals("v") && !(buttonV.getBackground().equals(Color.GREEN))
									&& !(buttonV.getBackground().equals(Color.YELLOW))) {
								buttonV.setBackground(Color.YELLOW);
							}
							if (temp.equals("w") && !(buttonW.getBackground().equals(Color.GREEN))
									&& !(buttonW.getBackground().equals(Color.YELLOW))) {
								buttonW.setBackground(Color.YELLOW);
							}
							if (temp.equals("x") && !(buttonX.getBackground().equals(Color.GREEN))
									&& !(buttonX.getBackground().equals(Color.YELLOW))) {
								buttonX.setBackground(Color.YELLOW);
							}
							if (temp.equals("y") && !(buttonY.getBackground().equals(Color.GREEN))
									&& !(buttonY.getBackground().equals(Color.YELLOW))) {
								buttonY.setBackground(Color.YELLOW);
							}
							if (temp.equals("z") && !(buttonZ.getBackground().equals(Color.GREEN))
									&& !(buttonZ.getBackground().equals(Color.YELLOW))) {
								buttonZ.setBackground(Color.YELLOW);
							}
						}
						if (hints[q - 1] == "g") {
							g2.setColor(Color.GREEN);
							if(wordLength[0]==5)
								w=100;
							if(wordLength[0]==6)
								w=75;
							if(wordLength[0]==7)
								w=50;
							
							g2.fillRect((50 * q) + w, 50 * j + 50, 50, 50);
							temp = word.substring(q - 1, q);
							g.setColor(Color.BLACK);
							if(wordLength[0]==5)
								w=120;
							if(wordLength[0]==6)
								w=95;
							if(wordLength[0]==7)
								w=70;
							g.setFont(new Font("calibri", Font.BOLD, 20));
							g.drawString(temp, (50 * q) + w, 50 * j + 80);
							if (temp.equals("a")) {
								buttonA.setBackground(Color.GREEN);
							}
							if (temp.equals("b")) {
								buttonB.setBackground(Color.GREEN);
							}
							if (temp.equals("c")) {
								buttonC.setBackground(Color.GREEN);
							}
							if (temp.equals("d")) {
								buttonD.setBackground(Color.GREEN);
							}
							if (temp.equals("e")) {
								buttonE.setBackground(Color.GREEN);
							}
							if (temp.equals("f")) {
								buttonF.setBackground(Color.GREEN);
							}
							if (temp.equals("g")) {
								buttonG.setBackground(Color.GREEN);
							}
							if (temp.equals("h")) {
								buttonH.setBackground(Color.GREEN);
							}
							if (temp.equals("i")) {
								buttonI.setBackground(Color.GREEN);
							}
							if (temp.equals("j")) {
								buttonJ.setBackground(Color.GREEN);
							}
							if (temp.equals("k")) {
								buttonK.setBackground(Color.GREEN);
							}
							if (temp.equals("l")) {
								buttonL.setBackground(Color.GREEN);
							}
							if (temp.equals("m")) {
								buttonM.setBackground(Color.GREEN);
							}
							if (temp.equals("n")) {
								buttonN.setBackground(Color.GREEN);
							}
							if (temp.equals("o")) {
								buttonO.setBackground(Color.GREEN);
							}
							if (temp.equals("p")) {
								buttonP.setBackground(Color.GREEN);
							}
							if (temp.equals("q")) {
								buttonQ.setBackground(Color.GREEN);
							}
							if (temp.equals("r")) {
								buttonR.setBackground(Color.GREEN);
							}
							if (temp.equals("s")) {
								buttonS.setBackground(Color.GREEN);
							}
							if (temp.equals("t")) {
								buttonT.setBackground(Color.GREEN);
							}
							if (temp.equals("u")) {
								buttonU.setBackground(Color.GREEN);
							}
							if (temp.equals("v")) {
								buttonV.setBackground(Color.GREEN);
							}
							if (temp.equals("w")) {
								buttonW.setBackground(Color.GREEN);
							}
							if (temp.equals("x")) {
								buttonX.setBackground(Color.GREEN);
							}
							if (temp.equals("y")) {
								buttonY.setBackground(Color.GREEN);
							}
							if (temp.equals("z")) {
								buttonZ.setBackground(Color.GREEN);
							}
						}
					}
					if(j==6) {
						this.setVisible(false);
						JFrame loser = new JFrame();
						JLabel label = new JLabel("You lose! The word was "+word1);
						loser.setSize(200, 200);
						loser.add(label);
						loser.setVisible(true);
					}
					if(gameStop) {
						this.setVisible(false);
						JFrame winner = new JFrame();
						
						icon = new ImageIcon("C:\\Users\\MDomino2024\\Downloads\\VictoryRoyaleImage.png");
						JLabel label1 = new JLabel();
						label1.setIcon(icon);
						winner.setBounds(0,0,1000,600);
						winner.setVisible(true);
						winner.add(label1);
						
						File file = new File("C:\\Users\\MDomino2024\\Downloads\\VictorySound.wav");
						AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
						Clip clip = AudioSystem.getClip();
						clip.open(audioStream);
						clip.start();
					}
					j++;
					word = "";
					i = 0;
				} else {
					JFrame WordInorrect = new JFrame();
					JLabel label = new JLabel("Word is not in Word List!");
					WordInorrect.setSize(100, 100);
					WordInorrect.setVisible(true);
					WordInorrect.add(label);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (didSomething && i != 0) {
			temp = word.substring(i - 1, i); // error on enter
			g.setFont(new Font("calibri", Font.BOLD, 20));
			if (wordLength[0] == 5)
				g.drawString(temp, (50 * i) + 120, 50 * j + 80);
			if (wordLength[0] == 6)
				g.drawString(temp, (50 * i) + 95, 50 * j + 80);
			if (wordLength[0] == 7)
				g.drawString(temp, (50 * i) + 70, 50 * j + 80);
			System.out.println(temp);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	//This is the buttons and making sure they change color and if you win
	//a new jframe pops up 
	public void actionPerformed(ActionEvent e) {
		this.requestFocusInWindow();
		if(wordLength[1]==2) {
			ifStarted=true;
			if(ifStarted&&j==1&&i==0) {
				new java.util.Timer().schedule(
						new java.util.TimerTask() {
							@Override
							public void run() {									
									setVisible(false);
									JFrame loser = new JFrame();
									JLabel label = new JLabel("You lose!");
									loser.setSize(200, 200);
									loser.add(label);
									loser.setVisible(true);
								
							}
						},90000
						);
			}

		}
		didSomething = false;
		g = getGraphics();
		g2 = getGraphics();
		temp = "";
		if (e.getSource() == buttonBackSpace && i > 0) {
			
			i--;
				word = word.substring(0, i);
			didSomething = true;
			g2.setColor(Color.WHITE);
			if (wordLength[0] == 5)
				g2.fillRect(50 * i + 160, 50 * j + 60, 30, 30);
			if (wordLength[0] == 6)
				g2.fillRect(50 * i + 135, 50 * j + 60, 30, 30);
			if (wordLength[0] == 7)
				g2.fillRect(50 * i + 110, 50 * j + 60, 30, 30);
		}
		if ((e.getSource() == buttonA) && i < wordLength[0]) {
			word = word + "a";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonB && i < wordLength[0]) {
			word = word + "b";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonC && i < wordLength[0]) {
			word = word + "c";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonD && i < wordLength[0]) {
			word = word + "d";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonE && i < wordLength[0]) {
			word = word + "e";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonF && i < wordLength[0]) {
			word = word + "f";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonG && i < wordLength[0]) {
			word = word + "g";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonH && i < wordLength[0]) {
			word = word + "h";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonI && i < wordLength[0]) {
			word = word + "i";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonJ && i < wordLength[0]) {
			word = word + "j";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonK && i < wordLength[0]) {
			word = word + "k";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonL && i < wordLength[0]) {
			word = word + "l";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonM && i < wordLength[0]) {
			word = word + "m";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonN && i < wordLength[0]) {
			word = word + "n";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonO && i < wordLength[0]) {
			word = word + "o";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonP && i < wordLength[0]) {
			word = word + "p";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonQ && i < wordLength[0]) {
			word = word + "q";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonR && i < wordLength[0]) {
			word = word + "r";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonS && i < wordLength[0]) {
			word = word + "s";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonT && i < wordLength[0]) {
			word = word + "t";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonU && i < wordLength[0]) {
			word = word + "u";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonV && i < wordLength[0]) {
			word = word + "v";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonW && i < wordLength[0]) {
			word = word + "w";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonX && i < wordLength[0]) {
			word = word + "x";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonY && i < wordLength[0]) {
			word = word + "y";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonZ && i < wordLength[0]) {
			word = word + "z";
			i++;
			didSomething = true;
		
		}
		if (e.getSource() == buttonEnter && i < wordLength[0]) {
			JFrame WordNotLong = new JFrame();
			JLabel label = new JLabel("Word Not Long Enough!");
			WordNotLong.setSize(100, 100);
			WordNotLong.setVisible(true);
			WordNotLong.add(label);
		
		}
		if (e.getSource() == buttonEnter && i == wordLength[0]) {
		
			gameStop=true;
			try {
				File officalWords;
				if(wordLength[1]==1) {
					officalWords = getFileSpan();
				}else {
					officalWords = getOfficalWords();
				}
				if (j == 1) {
					if(wordLength[0]==5) {
						word1 = getWord5();
					
					}
					if(wordLength[0]==6) {
						word1=getWord6();
						word1=word1.toLowerCase();
				
					}
					if(wordLength[0]==7) {
						word1=getWord7();
						word1=word1.toLowerCase();
				
					}
					if(wordLength[1]==1) {
						word1 = getWordSpanish();
						word1=word1.toLowerCase();
					
					}
				}
				if(wordLength[1]==1) {
					officalWords = getFileSpan();
				}
				if (Wordles.isWord(officalWords, word, word1)) {
					String[] hints = Wordles.giveHints(word, word1,wordLength[0]);
					int w = 0;
					for (int q = 1; q < hints.length + 1; q++) {
						
						if (hints[q - 1] == null) {
							gameStop=false;
							g2.setColor(Color.GRAY);
							if(wordLength[0]==5)
								w=100;
							if(wordLength[0]==6)
								w=75;
							if(wordLength[0]==7)
								w=50;
							
							g2.fillRect((50 * q) + w, 50 * j + 50, 50, 50);
							temp = word.substring(q - 1, q);
							g.setColor(Color.BLACK);
							if(wordLength[0]==5)
								w=120;
							if(wordLength[0]==6)
								w=95;
							if(wordLength[0]==7)
								w=70;
							g.setFont(new Font("calibri", Font.BOLD, 20));
							g.drawString(temp, (50 * q) + w, 50 * j + 80);
							if (temp.equals("a") && !(buttonA.getBackground().equals(Color.GREEN))
									&& !(buttonA.getBackground().equals(Color.YELLOW))) {
								buttonA.setBackground(Color.GRAY);
							}
							if (temp.equals("b") && !(buttonB.getBackground().equals(Color.GREEN))
									&& !(buttonB.getBackground().equals(Color.YELLOW))) {
								buttonB.setBackground(Color.GRAY);
							}
							if (temp.equals("c") && !(buttonC.getBackground().equals(Color.GREEN))
									&& !(buttonC.getBackground().equals(Color.YELLOW))) {
								buttonC.setBackground(Color.GRAY);
							}
							if (temp.equals("d") && !(buttonD.getBackground().equals(Color.GREEN))
									&& !(buttonD.getBackground().equals(Color.YELLOW))) {
								buttonD.setBackground(Color.GRAY);
							}
							if (temp.equals("e") && !(buttonE.getBackground().equals(Color.GREEN))
									&& !(buttonE.getBackground().equals(Color.YELLOW))) {
								buttonE.setBackground(Color.GRAY);
							}
							if (temp.equals("f") && !(buttonF.getBackground().equals(Color.GREEN))
									&& !(buttonF.getBackground().equals(Color.YELLOW))) {
								buttonF.setBackground(Color.GRAY);
							}
							if (temp.equals("g") && !(buttonG.getBackground().equals(Color.GREEN))
									&& !(buttonG.getBackground().equals(Color.YELLOW))) {
								buttonG.setBackground(Color.GRAY);
							}
							if (temp.equals("h") && !(buttonH.getBackground().equals(Color.GREEN))
									&& !(buttonH.getBackground().equals(Color.YELLOW))) {
								buttonH.setBackground(Color.GRAY);
							}
							if (temp.equals("i") && !(buttonI.getBackground().equals(Color.GREEN))
									&& !(buttonI.getBackground().equals(Color.YELLOW))) {
								buttonI.setBackground(Color.GRAY);
							}
							if (temp.equals("j") && !(buttonJ.getBackground().equals(Color.GREEN))
									&& !(buttonJ.getBackground().equals(Color.YELLOW))) {
								buttonJ.setBackground(Color.GRAY);
							}
							if (temp.equals("k") && !(buttonK.getBackground().equals(Color.GREEN))
									&& !(buttonK.getBackground().equals(Color.YELLOW))) {
								buttonK.setBackground(Color.GRAY);
							}
							if (temp.equals("l") && !(buttonL.getBackground().equals(Color.GREEN))
									&& !(buttonL.getBackground().equals(Color.YELLOW))) {
								buttonL.setBackground(Color.GRAY);
							}
							if (temp.equals("m") && !(buttonM.getBackground().equals(Color.GREEN))
									&& !(buttonM.getBackground().equals(Color.YELLOW))) {
								buttonM.setBackground(Color.GRAY);
							}
							if (temp.equals("n") && !(buttonN.getBackground().equals(Color.GREEN))
									&& !(buttonN.getBackground().equals(Color.YELLOW))) {
								buttonN.setBackground(Color.GRAY);
							}
							if (temp.equals("o") && !(buttonO.getBackground().equals(Color.GREEN))
									&& !(buttonO.getBackground().equals(Color.YELLOW))) {
								buttonO.setBackground(Color.GRAY);
							}
							if (temp.equals("p") && !(buttonP.getBackground().equals(Color.GREEN))
									&& !(buttonP.getBackground().equals(Color.YELLOW))) {
								buttonP.setBackground(Color.GRAY);
							}
							if (temp.equals("q") && !(buttonQ.getBackground().equals(Color.GREEN))
									&& !(buttonQ.getBackground().equals(Color.YELLOW))) {
								buttonQ.setBackground(Color.GRAY);
							}
							if (temp.equals("r") && !(buttonR.getBackground().equals(Color.GREEN))
									&& !(buttonR.getBackground().equals(Color.YELLOW))) {
								buttonR.setBackground(Color.GRAY);
							}
							if (temp.equals("s") && !(buttonS.getBackground().equals(Color.GREEN))
									&& !(buttonS.getBackground().equals(Color.YELLOW))) {
								buttonS.setBackground(Color.GRAY);
							}
							if (temp.equals("t") && !(buttonT.getBackground().equals(Color.GREEN))
									&& !(buttonT.getBackground().equals(Color.YELLOW))) {
								buttonT.setBackground(Color.GRAY);
							}
							if (temp.equals("u") && !(buttonU.getBackground().equals(Color.GREEN))
									&& !(buttonU.getBackground().equals(Color.YELLOW))) {
								buttonU.setBackground(Color.GRAY);
							}
							if (temp.equals("v") && !(buttonV.getBackground().equals(Color.GREEN))
									&& !(buttonV.getBackground().equals(Color.YELLOW))) {
								buttonV.setBackground(Color.GRAY);
							}
							if (temp.equals("w") && !(buttonW.getBackground().equals(Color.GREEN))
									&& !(buttonW.getBackground().equals(Color.YELLOW))) {
								buttonW.setBackground(Color.GRAY);
							}
							if (temp.equals("x") && !(buttonX.getBackground().equals(Color.GREEN))
									&& !(buttonX.getBackground().equals(Color.YELLOW))) {
								buttonX.setBackground(Color.GRAY);
							}
							if (temp.equals("y") && !(buttonY.getBackground().equals(Color.GREEN))
									&& !(buttonY.getBackground().equals(Color.YELLOW))) {
								buttonY.setBackground(Color.GRAY);
							}
							if (temp.equals("z") && !(buttonZ.getBackground().equals(Color.GREEN))
									&& !(buttonZ.getBackground().equals(Color.YELLOW))) {
								buttonZ.setBackground(Color.GRAY);
							}
						}
						if (hints[q - 1] == "y") {
							gameStop=false;
							g2.setColor(Color.YELLOW);
							if(wordLength[0]==5)
								w=100;
							if(wordLength[0]==6)
								w=75;
							if(wordLength[0]==7)
								w=50;
							
							g2.fillRect((50 * q) + w, 50 * j + 50, 50, 50);
							temp = word.substring(q - 1, q);
							g.setColor(Color.BLACK);
							if(wordLength[0]==5)
								w=120;
							if(wordLength[0]==6)
								w=95;
							if(wordLength[0]==7)
								w=70;
							g.setFont(new Font("calibri", Font.BOLD, 20));
							g.drawString(temp, (50 * q) + w, 50 * j + 80);
							if (temp.equals("a") && !(buttonA.getBackground().equals(Color.GREEN))
									&& !(buttonA.getBackground().equals(Color.YELLOW))) {
								buttonA.setBackground(Color.YELLOW);
							}
							if (temp.equals("b") && !(buttonB.getBackground().equals(Color.GREEN))
									&& !(buttonB.getBackground().equals(Color.YELLOW))) {
								buttonB.setBackground(Color.YELLOW);
							}
							if (temp.equals("c") && !(buttonC.getBackground().equals(Color.GREEN))
									&& !(buttonC.getBackground().equals(Color.YELLOW))) {
								buttonC.setBackground(Color.YELLOW);
							}
							if (temp.equals("d") && !(buttonD.getBackground().equals(Color.GREEN))
									&& !(buttonD.getBackground().equals(Color.YELLOW))) {
								buttonD.setBackground(Color.YELLOW);
							}
							if (temp.equals("e") && !(buttonE.getBackground().equals(Color.GREEN))
									&& !(buttonE.getBackground().equals(Color.YELLOW))) {
								buttonE.setBackground(Color.YELLOW);
							}
							if (temp.equals("f") && !(buttonF.getBackground().equals(Color.GREEN))
									&& !(buttonF.getBackground().equals(Color.YELLOW))) {
								buttonF.setBackground(Color.YELLOW);
							}
							if (temp.equals("g") && !(buttonG.getBackground().equals(Color.GREEN))
									&& !(buttonG.getBackground().equals(Color.YELLOW))) {
								buttonG.setBackground(Color.YELLOW);
							}
							if (temp.equals("h") && !(buttonH.getBackground().equals(Color.GREEN))
									&& !(buttonH.getBackground().equals(Color.YELLOW))) {
								buttonH.setBackground(Color.YELLOW);
							}
							if (temp.equals("i") && !(buttonI.getBackground().equals(Color.GREEN))
									&& !(buttonI.getBackground().equals(Color.YELLOW))) {
								buttonI.setBackground(Color.YELLOW);
							}
							if (temp.equals("j") && !(buttonJ.getBackground().equals(Color.GREEN))
									&& !(buttonJ.getBackground().equals(Color.YELLOW))) {
								buttonJ.setBackground(Color.YELLOW);
							}
							if (temp.equals("k") && !(buttonK.getBackground().equals(Color.GREEN))
									&& !(buttonK.getBackground().equals(Color.YELLOW))) {
								buttonK.setBackground(Color.YELLOW);
							}
							if (temp.equals("l") && !(buttonL.getBackground().equals(Color.GREEN))
									&& !(buttonL.getBackground().equals(Color.YELLOW))) {
								buttonL.setBackground(Color.YELLOW);
							}
							if (temp.equals("m") && !(buttonM.getBackground().equals(Color.GREEN))
									&& !(buttonM.getBackground().equals(Color.YELLOW))) {
								buttonM.setBackground(Color.YELLOW);
							}
							if (temp.equals("n") && !(buttonN.getBackground().equals(Color.GREEN))
									&& !(buttonN.getBackground().equals(Color.YELLOW))) {
								buttonN.setBackground(Color.YELLOW);
							}
							if (temp.equals("o") && !(buttonO.getBackground().equals(Color.GREEN))
									&& !(buttonO.getBackground().equals(Color.YELLOW))) {
								buttonO.setBackground(Color.YELLOW);
							}
							if (temp.equals("p") && !(buttonP.getBackground().equals(Color.GREEN))
									&& !(buttonP.getBackground().equals(Color.YELLOW))) {
								buttonP.setBackground(Color.YELLOW);
							}
							if (temp.equals("q") && !(buttonQ.getBackground().equals(Color.GREEN))
									&& !(buttonQ.getBackground().equals(Color.YELLOW))) {
								buttonQ.setBackground(Color.YELLOW);
							}
							if (temp.equals("r") && !(buttonR.getBackground().equals(Color.GREEN))
									&& !(buttonR.getBackground().equals(Color.YELLOW))) {
								buttonR.setBackground(Color.YELLOW);
							}
							if (temp.equals("s") && !(buttonS.getBackground().equals(Color.GREEN))
									&& !(buttonS.getBackground().equals(Color.YELLOW))) {
								buttonS.setBackground(Color.YELLOW);
							}
							if (temp.equals("t") && !(buttonT.getBackground().equals(Color.GREEN))
									&& !(buttonT.getBackground().equals(Color.YELLOW))) {
								buttonT.setBackground(Color.YELLOW);
							}
							if (temp.equals("u") && !(buttonU.getBackground().equals(Color.GREEN))
									&& !(buttonU.getBackground().equals(Color.YELLOW))) {
								buttonU.setBackground(Color.YELLOW);
							}
							if (temp.equals("v") && !(buttonV.getBackground().equals(Color.GREEN))
									&& !(buttonV.getBackground().equals(Color.YELLOW))) {
								buttonV.setBackground(Color.YELLOW);
							}
							if (temp.equals("w") && !(buttonW.getBackground().equals(Color.GREEN))
									&& !(buttonW.getBackground().equals(Color.YELLOW))) {
								buttonW.setBackground(Color.YELLOW);
							}
							if (temp.equals("x") && !(buttonX.getBackground().equals(Color.GREEN))
									&& !(buttonX.getBackground().equals(Color.YELLOW))) {
								buttonX.setBackground(Color.YELLOW);
							}
							if (temp.equals("y") && !(buttonY.getBackground().equals(Color.GREEN))
									&& !(buttonY.getBackground().equals(Color.YELLOW))) {
								buttonY.setBackground(Color.YELLOW);
							}
							if (temp.equals("z") && !(buttonZ.getBackground().equals(Color.GREEN))
									&& !(buttonZ.getBackground().equals(Color.YELLOW))) {
								buttonZ.setBackground(Color.YELLOW);
							}
						}
						if (hints[q - 1] == "g") {
							g2.setColor(Color.GREEN);
							if(wordLength[0]==5)
								w=100;
							if(wordLength[0]==6)
								w=75;
							if(wordLength[0]==7)
								w=50;
							
							g2.fillRect((50 * q) + w, 50 * j + 50, 50, 50);
							temp = word.substring(q - 1, q);
							g.setColor(Color.BLACK);
							if(wordLength[0]==5)
								w=120;
							if(wordLength[0]==6)
								w=95;
							if(wordLength[0]==7)
								w=70;
							g.setFont(new Font("calibri", Font.BOLD, 20));
							g.drawString(temp, (50 * q) + w, 50 * j + 80);
							if (temp.equals("a")) {
								buttonA.setBackground(Color.GREEN);
							}
							if (temp.equals("b")) {
								buttonB.setBackground(Color.GREEN);
							}
							if (temp.equals("c")) {
								buttonC.setBackground(Color.GREEN);
							}
							if (temp.equals("d")) {
								buttonD.setBackground(Color.GREEN);
							}
							if (temp.equals("e")) {
								buttonE.setBackground(Color.GREEN);
							}
							if (temp.equals("f")) {
								buttonF.setBackground(Color.GREEN);
							}
							if (temp.equals("g")) {
								buttonG.setBackground(Color.GREEN);
							}
							if (temp.equals("h")) {
								buttonH.setBackground(Color.GREEN);
							}
							if (temp.equals("i")) {
								buttonI.setBackground(Color.GREEN);
							}
							if (temp.equals("j")) {
								buttonJ.setBackground(Color.GREEN);
							}
							if (temp.equals("k")) {
								buttonK.setBackground(Color.GREEN);
							}
							if (temp.equals("l")) {
								buttonL.setBackground(Color.GREEN);
							}
							if (temp.equals("m")) {
								buttonM.setBackground(Color.GREEN);
							}
							if (temp.equals("n")) {
								buttonN.setBackground(Color.GREEN);
							}
							if (temp.equals("o")) {
								buttonO.setBackground(Color.GREEN);
							}
							if (temp.equals("p")) {
								buttonP.setBackground(Color.GREEN);
							}
							if (temp.equals("q")) {
								buttonQ.setBackground(Color.GREEN);
							}
							if (temp.equals("r")) {
								buttonR.setBackground(Color.GREEN);
							}
							if (temp.equals("s")) {
								buttonS.setBackground(Color.GREEN);
							}
							if (temp.equals("t")) {
								buttonT.setBackground(Color.GREEN);
							}
							if (temp.equals("u")) {
								buttonU.setBackground(Color.GREEN);
							}
							if (temp.equals("v")) {
								buttonV.setBackground(Color.GREEN);
							}
							if (temp.equals("w")) {
								buttonW.setBackground(Color.GREEN);
							}
							if (temp.equals("x")) {
								buttonX.setBackground(Color.GREEN);
							}
							if (temp.equals("y")) {
								buttonY.setBackground(Color.GREEN);
							}
							if (temp.equals("z")) {
								buttonZ.setBackground(Color.GREEN);
							}
						}
					}
					if(j==6) {
						this.setVisible(false);
						JFrame loser = new JFrame();
						JLabel label = new JLabel("You lose! The word was "+word1);
						loser.setSize(200, 200);
						loser.add(label);
						loser.setVisible(true);
					}
					if(gameStop) {
						this.setVisible(false);
						JFrame winner = new JFrame("Winner");
						
						icon = new ImageIcon("C:\\Users\\MDomino2024\\Downloads\\VictoryRoyaleImage.png");
						JLabel label1 = new JLabel();
						label1.setIcon(icon);
						winner.setBounds(0,0,1000,600);
						winner.setVisible(true);
						winner.add(label1);
						File file = new File("C:\\Users\\MDomino2024\\Downloads\\VictorySound.wav");
						AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
						Clip clip1 = AudioSystem.getClip();
						clip1.start();
						clip1.open(audioStream);
						clip1.start();
					}
					
					j++;
					word = "";
					i = 0;
				} else {
					JFrame WordInorrect = new JFrame();
					JLabel label = new JLabel("Word is not in Word List!");
					WordInorrect.setSize(100, 100);
					WordInorrect.setVisible(true);
					WordInorrect.add(label);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (didSomething && i != 0) {
			temp = word.substring(i - 1, i); // error on enter
			g.setFont(new Font("calibri", Font.BOLD, 20));
			if (wordLength[0] == 5)
				g.drawString(temp, (50 * i) + 120, 50 * j + 80);
			if (wordLength[0] == 6)
				g.drawString(temp, (50 * i) + 95, 50 * j + 80);
			if (wordLength[0] == 7)
				g.drawString(temp, (50 * i) + 70, 50 * j + 80);
		}
		System.out.println(temp);
	}
	//these all just get the files and make scanners for the words
	public static File getFile5() throws FileNotFoundException {
		File file = new File("C:\\Users\\MDomino2024\\Downloads\\sgb-words.txt");
		return file;
	}
	public static File getFile6() throws FileNotFoundException{
		File file = new File("C:\\Users\\MDomino2024\\Downloads\\English6.txt");
		return file;
	}
	public static File getFile7() throws FileNotFoundException{
		File file = new File("C:\\Users\\MDomino2024\\Downloads\\English7.txt");
		return file;
	}
	public static File getFileSpan() throws FileNotFoundException{
		File file = new File("C:\\Users\\MDomino2024\\Downloads\\espoff.txt");
		return file;
	}
	public static File getOfficalWords() throws FileNotFoundException {
		File officalWords = new File("C:\\Users\\MDomino2024\\Downloads\\english3.txt");
		return officalWords;
	}
	public static Scanner getScan5() throws FileNotFoundException {
		Scanner scan = new Scanner(getFile5());
		return scan;
	}
	public static Scanner getScan6() throws FileNotFoundException {
		Scanner scan = new Scanner(getFile6());
		return scan;
	}
	public static Scanner getScan7() throws FileNotFoundException {
		Scanner scan = new Scanner(getFile7());
		return scan;
	}
	public static Scanner getScanSpan() throws FileNotFoundException {
		Scanner scan = new Scanner(getFileSpan());
		return scan;
	}
	public static String getWord5() throws FileNotFoundException {
		String word1 = Wordles.getWordEnglish5(getFile5(), getScan5());
		return word1;

	}
	public static String getWord6() throws FileNotFoundException {
		String word1 = Wordles.getWordEnglish5(getFile6(), getScan6());
		return word1;
	}
	public static String getWord7() throws FileNotFoundException {
		String word1 = Wordles.getWordEnglish5(getFile7(), getScan7());
		return word1;
	}
	public static String getWordSpanish() throws FileNotFoundException{
		File file = new File("C:\\Users\\MDomino2024\\Downloads\\Spanish5Letter.txt");
		Scanner scan = new Scanner(file);
		String word1 = Wordles.getSpnaishWord(file,scan);
		return word1;
	}
	public boolean getDoSomething() {
		return didSomething;
	}
}
