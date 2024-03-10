package TicTacToe;

//draw causes infinite loop

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
	
	JButton t [] = new JButton [10];
	int pressed [] = new int [10];
	int a, min = 0, max = 8;
	int randomNum;
	JFrame end;
	JLabel wins;
	JButton again, exit;
	JPanel buttons, w;
	
	public TicTacToe () {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("TicTacToe");
		setLayout(new GridLayout (3, 3));
		
		for(a = 1; a<10; a++) {
				t[a] = new JButton ();
				t[a].setFont(new Font("Verdana", Font.BOLD, 50));
				t[a].addActionListener(this);
				add (t[a]);
		}
		
		setSize(500, 500);
		setVisible(true);
		
		
		end = new JFrame();
		buttons = new JPanel();
		w = new JPanel();
		buttons.setLayout(new FlowLayout());
		w.setLayout(new FlowLayout());
		end.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		again = new JButton("Play Again");
		again.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		wins = new JLabel ();
		
		buttons.add(again);
		buttons.add(exit);
		w.add(wins);
		end.add(buttons, "Center");
		end.add(w, "North");
		end.setSize(300,100);
	}

	public void actionPerformed(ActionEvent e) {
		for(a = 1; a<10; a++) {
				if (e.getSource() == t[a]) {
					t[a].setText("X");
					t[a].setEnabled(false);
					t[a].setBackground(Color.BLUE);
					pressed [a] = a;
					while (true) {
					randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);					
					if (pressed [randomNum] != randomNum) {
						pressed [randomNum] = randomNum;
						t[randomNum].setText("O");
						t[randomNum].setEnabled(false);
						t[randomNum].setBackground(Color.RED);
						break;	
					}
				}
			
			}
		}
			winner(1, 2, 3, "X", "Player wins!");
			winner(4, 5, 6, "X", "Player wins!");
			winner(7, 8, 9, "X", "Player wins!");
			
			winner(1, 4, 7, "X", "Player wins!");
			winner(2, 5, 8, "X", "Player wins!");
			winner(3, 6, 9, "X", "Player wins!");
			
			winner(1, 5, 9, "X", "Player wins!");
			winner(3, 5, 7, "X", "Player wins!");
			
			
			winner(1, 2, 3, "O", "CPU wins!");
			winner(4, 5, 6, "O", "CPU wins!");
			winner(7, 8, 9, "O", "CPU wins!");
			
			winner(1, 4, 7, "O", "CPU wins!");
			winner(2, 5, 8, "O", "CPU wins!");
			winner(3, 6, 9, "O", "CPU wins!");
			
			winner(1, 5, 9, "O", "CPU wins!");
			winner(3, 5, 7, "O", "CPU wins!");
			
		if (e.getSource() == exit) {
			System.exit(0);
		}
		
		else if (e.getSource() == again) {
			dispose();
			end.dispose();
			new TicTacToe();
		}
	}
	public void winner (int x, int y, int z, String sym, String who) {
		if (t[x].getText() == sym && t[y].getText() == sym && t[z].getText() == sym) {
		t[x].setBackground(Color.GREEN);
		t[y].setBackground(Color.GREEN);
		t[z].setBackground(Color.GREEN);
		wins.setText(who);
		end.setVisible(true);
		}
	}
}
