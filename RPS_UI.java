package rps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class RPS_UI extends JFrame {

	private JPanel contentPane;
	public Selected selection = new Selected();
	private JLabel resultBox = new JLabel("");
	private JLabel lblPlayerScore = new JLabel("0");
	private JLabel lblOpponentScore = new JLabel("0");
	JLabel lblOppSelection = new JLabel("");
	private int playerScore = 0, opponentScore = 0;
	private String resultText = "";


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPS_UI frame = new RPS_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RPS_UI() {
		setResizable(false);
		setTitle("Rock, Paper, Scissors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
/*
 * 		Create button for player to choose Rock. Call selection.rock() from
 * 		Selected.java and set resultText with selection.turn()
 */
		JButton btnRock = new JButton("Rock");
		btnRock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selection.rock();
				resultText = selection.turn();
				resultBox.setText(resultText);
				lblOppSelection.setText(selection.getOppSelection());
				if(resultText.contains("Congrat")) {
					playerScore++;
					lblPlayerScore.setText(String.valueOf(playerScore));
				}
				else if(resultText.contains("Better")) {
					opponentScore++;
					lblOpponentScore.setText(String.valueOf(opponentScore));
				}
			}
		});
		btnRock.setBounds(50, 101, 89, 23);
		contentPane.add(btnRock);
/*
 * 		Create Paper button and call Selected methods		
 */
		JButton btnPaper = new JButton("Paper");
		btnPaper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selection.paper();
				resultText = selection.turn();
				resultBox.setText(resultText);
				lblOppSelection.setText(selection.getOppSelection());
				if(resultText.contains("Congrat")) {
					playerScore++;
					lblPlayerScore.setText(String.valueOf(playerScore));
				}
				else if(resultText.contains("Better")) {
					opponentScore++;
					lblOpponentScore.setText(String.valueOf(opponentScore));
				}
			}
		});
		btnPaper.setBounds(173, 101, 89, 23);
		contentPane.add(btnPaper);
/*
 * 		Create Scissors button and call Selected methods
 */
		JButton btnScissors = new JButton("Scissors");
		btnScissors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selection.scissors();
				resultText = selection.turn();
				resultBox.setText(resultText);
				lblOppSelection.setText(selection.getOppSelection());
				if(resultText.contains("Congrat")) {
					playerScore++;
					lblPlayerScore.setText(String.valueOf(playerScore));
				}
				else if(resultText.contains("Better")) {
					opponentScore++;
					lblOpponentScore.setText(String.valueOf(opponentScore));
				}
			}
		});
		btnScissors.setBounds(298, 101, 89, 23);
		contentPane.add(btnScissors);
/*
 * 		Create various labels and configure them
 */
		JLabel lblChoose = new JLabel("Choose your weapon!");
		lblChoose.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblChoose.setBounds(113, 34, 210, 45);
		contentPane.add(lblChoose);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblResult.setBounds(50, 169, 61, 14);
		contentPane.add(lblResult);
		resultBox.setHorizontalAlignment(SwingConstants.CENTER);
		
		resultBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		resultBox.setBounds(101, 165, 286, 25);
		contentPane.add(resultBox);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPlayer.setBounds(123, 201, 61, 23);
		contentPane.add(lblPlayer);
		
		JLabel lblOpponent = new JLabel("Opponent:");
		lblOpponent.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblOpponent.setBounds(227, 201, 89, 23);
		contentPane.add(lblOpponent);
		
		lblPlayerScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerScore.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPlayerScore.setBounds(173, 201, 43, 23);
		contentPane.add(lblPlayerScore);
		
		lblOpponentScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponentScore.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblOpponentScore.setBounds(305, 201, 43, 23);
		contentPane.add(lblOpponentScore);
		
		JLabel lblOppDraws = new JLabel("Opponent Draws:");
		lblOppDraws.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblOppDraws.setBounds(50, 144, 124, 23);
		contentPane.add(lblOppDraws);
		lblOppSelection.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblOppSelection.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblOppSelection.setBounds(173, 146, 150, 23);
		contentPane.add(lblOppSelection);
	}
}
