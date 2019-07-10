package kr.co.connect.wordcard;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.co.connect.jdbcexam.dto.Role;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class WordCardSetter extends JFrame implements ActionListener
{
	private JFrame frmWordCardSetter;
	private JPanel panel;
	private JButton btnUpload;
	
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
	private CardDao dao = new CardDao();
	private JButton btnInsert;
	private JButton btnShowAll;
	
	// 계속 반복적으로 사용되므로 클래스 멤버로 등록하는게 좋음
	private static String dburl = "jdbc:mysql://localhost:3306/wordcard";
	private static String dbUser = "user"; // "root"
	private static String dbpasswd = "connect123!@#"; // "0227"

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					WordCardSetter window = new WordCardSetter();
					window.frmWordCardSetter.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the application */
	public WordCardSetter() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		frmWordCardSetter = new JFrame();
		frmWordCardSetter.setTitle("Word Card Setter");
		frmWordCardSetter.setBounds(100, 100, 450, 300);
		frmWordCardSetter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frmWordCardSetter.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fc = new JFileChooser(); // can select file from dialog box
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt"); // set file format
		        fc.setFileFilter(filter); // apply file format
				int returnVal = fc.showOpenDialog(WordCardSetter.this); // belong dialog to program
				
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = fc.getSelectedFile();
					exam = new String("");
					
					try
					{
						BufferedReader reader  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8")); // korean encoding
						
						String line = null;
						while((line = reader.readLine()) != null) // read file and save in the String
							exam += line + "\n";
						reader.close();
					} 
					catch (IOException e1) 
					{ 
						e1.printStackTrace();
					} 
				}
			}
		});
		btnUpload.setBounds(27, 111, 105, 27);
		panel.add(btnUpload);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				questions = exam.split(";");
				try
				{
					for(String question : questions)
					{
						String[] pair = question.split(" : ");
						dao.addCard(new Card(pair[0], pair[1]));
						System.out.println(pair[0] + " " + pair[1]);
					}
				}
				catch(ArrayIndexOutOfBoundsException ex)
				{
					System.out.println("The end of exam");
				}
			}
		});
		btnInsert.setBounds(156, 111, 105, 27);
		panel.add(btnInsert);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				List<Card> list = getCards();
				for(Card c : list)
				{
					System.out.println(c.getWord() + " : " + c.getDescription());
				}
			}
		});
		btnShowAll.setBounds(288, 111, 105, 27);
		panel.add(btnShowAll);
	}
	
	public List<Card> getCards() // List로 리턴
	{
		List<Card> list = new ArrayList<Card>();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로드
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		String sql = "SELECT word, description FROM card ORDER BY word DESC";
		// try-with-resource 구문 : 기존의 close를 써 줄 필요없이 자동으로 처리해줌 (finally로 작성했던 부분이 없음)
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); PreparedStatement ps = conn.prepareStatement(sql))
		{
			try(ResultSet rs = ps.executeQuery()) 
			{
				while(rs.next()) // 있으면 true리턴하며 커서 다음 튜플로 이동
				{
					String word = rs.getString(1);
					String description = rs.getString(2); // 꺼내서
					
					Card card = new Card(word, description); // Card 객체를 생성
					list.add(card); // list에 반복할 때마다 Card인스턴스를 생성하여 list에 추가함
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	}
}