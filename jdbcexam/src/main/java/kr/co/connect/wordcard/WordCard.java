/**======================================================================================
 * Project Name : Word Card
 * Published by : YOOK DONGHYUN (aomorikaitou93@gmail.com)
 * ======================================================================================
 * # This word card program provides you to below features
 * - open the word card text file (ver 1.0)
 * - the file should follow the below format (ver 1.0)
 * 	- ex) word1 : description1; word2 : description2; ....
 * - you have 2 times to guess the answer (ver 1.0)
 *	- if you guess correct answer, you got 10 points
 * 	- if you fail to guess or see the answer, you lose 10 points & make correction note
 * ======================================================================================
 * Version Control
 * --------------------------------------------------------------------------------------
 * 2019-06-27 : create Word Card ver 1.0
 * =====================================================================================*/

package kr.co.connect.wordcard;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class WordCard extends JFrame implements ActionListener
{
	private JFrame frmWordCard;
	private JPanel panel;
	private JLabel lblScore;
	private JTextField txtScore;
	private JButton btnUploadFile;
	private JLabel lblQuestion;
	private JTextArea txtQuestion;
	private JScrollPane scrollPane;
	private JButton btnTry;
	private JButton btnSeeAnswer;
	
	private String exam;
	private String[] questions;
	private String[] pair;
	private int qNum = 1; 
	private String answer;
	private int score = 0;
	private final int TRY_MAX = 2;
	private int tryCnt = TRY_MAX;
	private String correction_note = "";
	private int correctionCnt = 0;
	private File file;
	private BruteForce bf;

	/** Launch the application. */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					WordCard window = new WordCard();
					window.frmWordCard.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the application */
	public WordCard() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		frmWordCard = new JFrame();
		frmWordCard.setResizable(false);
		frmWordCard.setTitle("Word Card");
		frmWordCard.setBounds(100, 100, 621, 340);
		frmWordCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frmWordCard.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblScore.setBounds(37, 40, 62, 18);
		panel.add(lblScore);
		
		txtScore = new JTextField();
		txtScore.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblScore.setLabelFor(txtScore);
		txtScore.setBackground(Color.WHITE);
		txtScore.setEditable(false);
		txtScore.setBounds(99, 38, 116, 24);
		panel.add(txtScore);
		txtScore.setColumns(10);
		
		btnUploadFile = new JButton("Upload File");
		btnUploadFile.addActionListener(this);
		btnUploadFile.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnUploadFile.setBounds(411, 34, 151, 31);
		panel.add(btnUploadFile);
		
		lblQuestion = new JLabel("Question #");
		lblQuestion.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblQuestion.setBounds(37, 87, 108, 18);
		panel.add(lblQuestion);
		
		scrollPane = new JScrollPane();
		lblQuestion.setLabelFor(scrollPane);
		scrollPane.setBounds(37, 111, 525, 116);
		panel.add(scrollPane);
		
		txtQuestion = new JTextArea();
		txtQuestion.setEditable(false);
		txtQuestion.setFont(new Font("Nanum Gothic", Font.PLAIN, 16));
		txtQuestion.setLineWrap(true);
		scrollPane.setViewportView(txtQuestion);
		
		btnTry = new JButton("Try");
		btnTry.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnTry.setBounds(153, 239, 108, 31);
		btnTry.addActionListener(this);
		panel.add(btnTry);
		
		btnSeeAnswer = new JButton("See Answer");
		btnSeeAnswer.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnSeeAnswer.setBounds(275, 239, 168, 31);
		btnSeeAnswer.addActionListener(this);
		panel.add(btnSeeAnswer);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		/* Upload File */
		if(e.getSource() == btnUploadFile)
		{
			JFileChooser fc = new JFileChooser(); // can select file from dialog box
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt"); // set file format
	        fc.setFileFilter(filter); // apply file format
			int returnVal = fc.showOpenDialog(WordCard.this); // belong dialog to program
			this.frmWordCard.setTitle(fc.getSelectedFile().getName() + " - Word Card"); // set title
			
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				txtQuestion.setText("");
				File file = fc.getSelectedFile();
				exam = new String("");
				
				try
				{
					BufferedReader reader  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8")); // korean encoding
					
					String line = null;
					while((line = reader.readLine()) != null) // read file and save in the String
						exam += line + "\n";
					reader.close();
					
					questions = exam.split(";");
					try
					{
						lblQuestion.setText("Question " + qNum);
						String[] pair = questions[0].split(" : ");
						txtQuestion.setText(pair[1]);
					}
					catch(ArrayIndexOutOfBoundsException ex)
					{
						System.out.println("The end of exam");
					}
					
					txtScore.setText(Integer.toString(score));
				} 
				catch (IOException e1) 
				{ 
					e1.printStackTrace();
				} 
			}
		}
		
		/* Try */
		if(e.getSource() == btnTry)
		{
			try
			{
				while(tryCnt >= 0)
				{
					pair = questions[qNum - 1].split(" : "); // parse question
					lblQuestion.setText("Question " + qNum); // update question number
					txtQuestion.setText(pair[1]); // update question
					answer = pair[0].substring(1); // set answer
					
					String trial = (String) JOptionPane.showInputDialog(null, "You have " + tryCnt + " chance(s) left.", "Your Answer", 1);
					bf = new BruteForce(answer, trial); // for multiple answer checking
					ArrayList<Integer> arr = bf.patternMatch(answer, trial); 
					
					if(trial != null)
					{
						if(answer.compareTo(trial) == 0 || ((Integer) arr.get(0)).intValue() != -1) // correct answer
						{
							JOptionPane.showMessageDialog(null, "You got the points!", "Correct Answer", JOptionPane.PLAIN_MESSAGE);
							txtScore.setText(Integer.toString(score += 10)); // gain points
							
							qNum++; // go to next question
							if(qNum > questions.length - 1)
								throw new NoMoreQuestionException();
							
							pair = questions[qNum - 1].split(" : "); // parse question
							lblQuestion.setText("Question " + qNum); // update question number
							txtQuestion.setText(pair[1]); // update question
							
							tryCnt = TRY_MAX; // set to default
							break;
						}
						else // wrong answer
						{
							tryCnt--; // decrease left trial count
							if(tryCnt == -1) // if used up all the chances
							{
								JOptionPane.showMessageDialog(null, "The answer was " + answer, "Wrong Answer", JOptionPane.PLAIN_MESSAGE);
								txtScore.setText(Integer.toString(score -= 10)); // lose points
								
								qNum++; // go to next question
								if(qNum > questions.length - 1)
									throw new NoMoreQuestionException();
								
								pair = questions[qNum - 1].split(" : "); // parse question
								lblQuestion.setText("Question " + qNum); // update question number
								txtQuestion.setText(pair[1]); // update question
								
								tryCnt = TRY_MAX; // set to default
								
								/** write correction note */
								correction_note += String.format("%s : %s\n", answer, pair[1]);
								if(correctionCnt == 0)
								{
									JFileChooser fc = new JFileChooser();
									FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt"); // set file format
							        fc.setFileFilter(filter); // apply file format
									int returnVal = fc.showSaveDialog(WordCard.this);
									if(returnVal == JFileChooser.APPROVE_OPTION)
									{
										file = fc.getSelectedFile();
										try 
										{
											BufferedWriter writer = new BufferedWriter(new FileWriter(file));
											writer.append(correction_note);
											writer.flush();
											writer.close();
											
											JOptionPane.showMessageDialog(frmWordCard, "Successfully saved correction note!" , "Notice", JOptionPane.PLAIN_MESSAGE);
										} 
										catch (IOException e1) { e1.printStackTrace(); }
									}
								}
								else
								{
									try 
									{
										BufferedWriter writer = new BufferedWriter(new FileWriter(file));
										writer.append(correction_note);
										writer.flush();
										writer.close();
										
										JOptionPane.showMessageDialog(null, "Successfully saved correction note!" , "Notice", JOptionPane.PLAIN_MESSAGE);
									} 
									catch (IOException e1) { e1.printStackTrace(); }
								}
								correctionCnt++;
								
								break;
							}
						}
					}
					else
						break;
				}
			}
			catch(NoMoreQuestionException ex)
			{
				JOptionPane.showMessageDialog(null, ex.getMessage(), "No more question", JOptionPane.ERROR_MESSAGE);
				frmWordCard.dispose();
			}
		}
		
		/* See Answer */
		if(e.getSource() == btnSeeAnswer)
		{
			try
			{
				pair = questions[qNum - 1].split(" : "); // parse question
				answer = pair[0].substring(1); // set answer
				
				JOptionPane.showMessageDialog(null, "The answer was " + answer, "See Answer", JOptionPane.PLAIN_MESSAGE);
				txtScore.setText(Integer.toString(score -= 10)); // lose points
				
				lblQuestion.setText("Question " + qNum++); // update question number
				if(qNum > questions.length - 1)
					throw new NoMoreQuestionException();
				
				pair = questions[qNum - 1].split(" : "); // get pair for next question
				txtQuestion.setText(pair[1]); // update question
				tryCnt = TRY_MAX; // set to default
				
				/** write correction note */
				correction_note += String.format("%s : %s\n", answer, pair[1]);
				if(correctionCnt == 0)
				{
					JFileChooser fc = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt"); // set file format
			        fc.setFileFilter(filter); // apply file format
					int returnVal = fc.showSaveDialog(WordCard.this);
					if(returnVal == JFileChooser.APPROVE_OPTION)
					{
						file = fc.getSelectedFile();
						try 
						{
							BufferedWriter writer = new BufferedWriter(new FileWriter(file));
							writer.append(correction_note);
							writer.flush();
							writer.close();
							
							JOptionPane.showMessageDialog(frmWordCard, "Successfully saved correction note!" , "Notice", JOptionPane.PLAIN_MESSAGE);
						} 
						catch (IOException e1) { e1.printStackTrace(); }
					}
				}
				else
				{
					try 
					{
						BufferedWriter writer = new BufferedWriter(new FileWriter(file));
						writer.append(correction_note);
						writer.flush();
						writer.close();
						
						JOptionPane.showMessageDialog(frmWordCard, "Successfully saved correction note!" , "Notice", JOptionPane.PLAIN_MESSAGE);
					} 
					catch (IOException e1) { e1.printStackTrace(); }
				}
				correctionCnt++;
			}
			catch(NoMoreQuestionException ex)
			{
				JOptionPane.showMessageDialog(null, ex.getMessage(), "No more question", JOptionPane.ERROR_MESSAGE);
				frmWordCard.dispose();
			}
		}
	}
}
