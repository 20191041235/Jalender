import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
<<<<<<< HEAD
import java.awt.Font;
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
<<<<<<< HEAD
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class MemoCalendar extends CalendarDataManager{ // CalendarDataManager의 GUI + 메모기능
	Font font = new Font("나눔스퀘어",Font.PLAIN,14);  
=======
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MemoCalendar extends CalendarDataManager{ // CalendarDataManager의 GUI + 메모기능
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
	JFrame mainFrame;
		ImageIcon icon = new ImageIcon ( Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
	
	JPanel calOpPanel;
		JButton todayBut;
		JLabel todayLab;
		JButton lYearBut;
		JButton lMonBut;
		JLabel curMMYYYYLab;
		JButton nMonBut;
		JButton nYearBut;
		ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
	
	JPanel calPanel;
		JButton weekDaysName[];
		JButton dateButs[][] = new JButton[6][7];
		listenForDateButs lForDateButs = new listenForDateButs(); 
<<<<<<< HEAD
=======
	
	JPanel infoPanel;
		JLabel infoClock;
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		
	MemoPart memoPanel; 
		
	JPanel frameBottomPanel;
		JLabel bottomInfo = new JLabel("Welcome to Memo Calendar!");
<<<<<<< HEAD
		
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
	//상수, 메세지
	final String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	final String title = "Jalender";
	final String SaveButMsg1 = "를 MemoData폴더에 저장하였습니다.";
	final String SaveButMsg2 = "메모를 먼저 작성해 주세요.";
	final String SaveButMsg3 = "<html><font color=red>ERROR : 파일 쓰기 실패</html>";
	final String DelButMsg1 = "메모를 삭제하였습니다.";
	final String DelButMsg2 = "작성되지 않았거나 이미 삭제된 memo입니다.";
	final String DelButMsg3 = "<html><font color=red>ERROR : 파일 삭제 실패</html>";

	private Vector<String> memoAreaText = new Vector<String>();
	private CrawlingSchedule crawling = new CrawlingSchedule(calYear);
	private HashMap<Integer, Vector<String>> academySchedule;
	
<<<<<<< HEAD
	private boolean useDB = false;
	private DBManager db = new DBManager();
	
	public MemoCalendar(){ //구성요소 순으로 정렬되어 있음. 각 판넬 사이에 빈줄로 구별
		useDB = db.connectDB();
		
		Font font = new Font("나눔스퀘어",Font.PLAIN,14);
		academySchedule = crawling.getAcademySchedule();
		
=======
	public MemoCalendar(){ //구성요소 순으로 정렬되어 있음. 각 판넬 사이에 빈줄로 구별
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		mainFrame = new JFrame(title);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(700,400);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setIconImage(icon.getImage());
<<<<<<< HEAD
		
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(mainFrame) ;
		}catch(Exception e){
			bottomInfo.setText("ERROR : LookAndFeel setting failed");
		}
		
		calOpPanel = new JPanel();
<<<<<<< HEAD
			todayBut = new RoundedButton("Today");
			todayBut.setFont(font);
			todayBut.setToolTipText("Today");
			todayBut.addActionListener(lForCalOpButtons);
			todayLab = new JLabel(today.get(Calendar.MONTH)+1+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR));
			todayLab.setFont(font);
			lYearBut = new RoundedButton("<<");
			lYearBut.setToolTipText("Previous Year");
			lYearBut.addActionListener(lForCalOpButtons);
			lMonBut = new RoundedButton("<");
			lMonBut.setToolTipText("Previous Month");
			lMonBut.addActionListener(lForCalOpButtons);
			curMMYYYYLab = new JLabel("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear+"</th></tr></table></html>");
			curMMYYYYLab.setFont(font);
			nMonBut = new RoundedButton(">");
			nMonBut.setToolTipText("Next Month");
			nMonBut.addActionListener(lForCalOpButtons);
			nYearBut = new RoundedButton(">>");
=======
			todayBut = new JButton("Today");
			todayBut.setToolTipText("Today");
			todayBut.addActionListener(lForCalOpButtons);
			todayLab = new JLabel(today.get(Calendar.MONTH)+1+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR));
			lYearBut = new JButton("<<");
			lYearBut.setToolTipText("Previous Year");
			lYearBut.addActionListener(lForCalOpButtons);
			lMonBut = new JButton("<");
			lMonBut.setToolTipText("Previous Month");
			lMonBut.addActionListener(lForCalOpButtons);
			curMMYYYYLab = new JLabel("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear+"</th></tr></table></html>");
			nMonBut = new JButton(">");
			nMonBut.setToolTipText("Next Month");
			nMonBut.addActionListener(lForCalOpButtons);
			nYearBut = new JButton(">>");
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
			nYearBut.setToolTipText("Next Year");
			nYearBut.addActionListener(lForCalOpButtons);
			calOpPanel.setLayout(new GridBagLayout());
			GridBagConstraints calOpGC = new GridBagConstraints();
			calOpGC.gridx = 1;
			calOpGC.gridy = 1;
			calOpGC.gridwidth = 2;
			calOpGC.gridheight = 1;
			calOpGC.weightx = 1;
			calOpGC.weighty = 1;
			calOpGC.insets = new Insets(5,5,0,0);
			calOpGC.anchor = GridBagConstraints.WEST;
			calOpGC.fill = GridBagConstraints.NONE;
			calOpPanel.add(todayBut,calOpGC);
			calOpGC.gridwidth = 3;
			calOpGC.gridx = 2;
			calOpGC.gridy = 1;
			calOpPanel.add(todayLab,calOpGC);
			calOpGC.anchor = GridBagConstraints.CENTER;
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 1;
			calOpGC.gridy = 2;
			calOpPanel.add(lYearBut,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 2;
			calOpGC.gridy = 2;
			calOpPanel.add(lMonBut,calOpGC);
			calOpGC.gridwidth = 2;
			calOpGC.gridx = 3;
			calOpGC.gridy = 2;
			calOpPanel.add(curMMYYYYLab,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 5;
			calOpGC.gridy = 2;
			calOpPanel.add(nMonBut,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 6;
			calOpGC.gridy = 2;
			calOpPanel.add(nYearBut,calOpGC);
		
		calPanel = new JPanel();
			weekDaysName = new JButton[7];
			for(int i=0 ; i<CAL_WIDTH ; i++){
				weekDaysName[i]=new JButton(WEEK_DAY_NAME[i]);
<<<<<<< HEAD
				weekDaysName[i].setFont(new Font("나눔스퀘어",Font.PLAIN,12));
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
				weekDaysName[i].setBorderPainted(false);
				weekDaysName[i].setContentAreaFilled(false);
				weekDaysName[i].setForeground(Color.WHITE);
				if(i == 0) weekDaysName[i].setBackground(new Color(200, 50, 50));
				else if (i == 6) weekDaysName[i].setBackground(new Color(50, 100, 200));
				else weekDaysName[i].setBackground(new Color(150, 150, 150));
				weekDaysName[i].setOpaque(true);
				weekDaysName[i].setFocusPainted(false);
				calPanel.add(weekDaysName[i]);
			}
			for(int i=0 ; i<CAL_HEIGHT ; i++){
				for(int j=0 ; j<CAL_WIDTH ; j++){
					dateButs[i][j]=new JButton();
<<<<<<< HEAD
					dateButs[i][j].setFont(font);
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
					dateButs[i][j].setBorderPainted(false);
					dateButs[i][j].setContentAreaFilled(false);
					dateButs[i][j].setBackground(Color.WHITE);
					dateButs[i][j].setOpaque(true);
					dateButs[i][j].addActionListener(lForDateButs);
					calPanel.add(dateButs[i][j]);
				}
			}
			calPanel.setLayout(new GridLayout(0,7,2,2));
			calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
			showCal(); // 달력을 표시
						
<<<<<<< HEAD
		memoPanel = new MemoPart(today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DAY_OF_MONTH));				
		memoPanel.setSelectedDate("<Html><font size=3>"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR)+"&nbsp;(Today)</html>");
=======
		infoPanel = new JPanel();
			infoPanel.setLayout(new BorderLayout());
			infoClock = new JLabel("", SwingConstants.RIGHT);
			infoClock.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			infoPanel.add(infoClock, BorderLayout.NORTH);
			
		memoPanel = new MemoPart(today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DAY_OF_MONTH));				
		memoPanel.setSelectedDate("<Html><font size=3>"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR)+"&nbsp;(Today)</html>");
		
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		JPanel frameSubPanelWest = new JPanel();
		Dimension calOpPanelSize = calOpPanel.getPreferredSize();
		calOpPanelSize.height = 90;
		calOpPanel.setPreferredSize(calOpPanelSize);
		frameSubPanelWest.setLayout(new BorderLayout());
		frameSubPanelWest.add(calOpPanel,BorderLayout.NORTH);
		frameSubPanelWest.add(calPanel,BorderLayout.CENTER);

		Dimension frameSubPanelWestSize = frameSubPanelWest.getPreferredSize();
<<<<<<< HEAD
		frameSubPanelWestSize.width = 430;
=======
		frameSubPanelWestSize.width = 410;
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		frameSubPanelWest.setPreferredSize(frameSubPanelWestSize);
		
		JPanel frameSubPanelEast = memoPanel;
		readMemo();
		
		frameBottomPanel = new JPanel();
<<<<<<< HEAD
		bottomInfo.setFont(font);
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		frameBottomPanel.add(bottomInfo);
		
		//frame에 전부 배치
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(frameSubPanelWest, BorderLayout.WEST);
		mainFrame.add(frameSubPanelEast, BorderLayout.CENTER);
		mainFrame.add(frameBottomPanel, BorderLayout.SOUTH);
		mainFrame.setVisible(true);

		focusToday(); //현재 날짜에 focus를 줌 (mainFrame.setVisible(true) 이후에 배치해야함)
		
		//Thread 작동(시계, bottomMsg 일정시간후 삭제)
		ThreadConrol threadCnl = new ThreadConrol();
		threadCnl.start();	
	}
	
	private void focusToday(){
		if(today.get(Calendar.DAY_OF_WEEK) == 1)
			dateButs[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
		else
			dateButs[today.get(Calendar.WEEK_OF_MONTH)-1][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
		
		curMMYYYYLab.setText("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear+"</th></tr></table></html>");
<<<<<<< HEAD
		curMMYYYYLab.setFont(font);
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		showCal();
	}
	
	private void showCal(){
<<<<<<< HEAD
		String tmpDate = "";
		for(int i=0;i<CAL_HEIGHT;i++){
			for(int j=0;j<CAL_WIDTH;j++){
				String fontColor="black";
				if(j == 0) fontColor="red";
				else if(j == 6) fontColor="blue";

				tmpDate = calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDates[i][j]<10?"0":"")+calDates[i][j];
				if(academySchedule.get(Integer.parseInt(tmpDate)) != null) fontColor = "green";
				
				if(useDB) {
					if(db.isAvailable(tmpDate)) 
						dateButs[i][j].setText("<html><b><font color="+fontColor+">"+calDates[i][j]+"</font></b></html>");
					else 
						dateButs[i][j].setText("<html><font color="+fontColor+">"+calDates[i][j]+"</font></html>");
				} else {
					File f =new File("MemoData/"+tmpDate+".txt");
					if(f.exists()) 
						dateButs[i][j].setText("<html><b><font color="+fontColor+">"+calDates[i][j]+"</font></b></html>");
					else 
						dateButs[i][j].setText("<html><font color="+fontColor+">"+calDates[i][j]+"</font></html>");
				}
				JLabel todayMark = new JLabel("<html><font color=red>*</html>");
=======
		for(int i=0;i<CAL_HEIGHT;i++){
			for(int j=0;j<CAL_WIDTH;j++){
				String fontColor="black";
				if(j==0) fontColor="red";
				else if(j==6) fontColor="blue";
				
				File f =new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDates[i][j]<10?"0":"")+calDates[i][j]+".txt");
				if(f.exists()) dateButs[i][j].setText("<html><b><font color="+fontColor+">"+calDates[i][j]+"</font></b></html>");
				else dateButs[i][j].setText("<html><font color="+fontColor+">"+calDates[i][j]+"</font></html>");

				JLabel todayMark = new JLabel("<html><font color=green>*</html>");
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
				dateButs[i][j].removeAll();
				if(calMonth == today.get(Calendar.MONTH) &&
					calYear == today.get(Calendar.YEAR) &&
					calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)) {
					dateButs[i][j].add(todayMark);
					dateButs[i][j].setToolTipText("Today");
				}
<<<<<<< HEAD

=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
				
				if(calDates[i][j] == 0) dateButs[i][j].setVisible(false);
				else dateButs[i][j].setVisible(true);
			}
		}
	}
	
	private class ListenForCalOpButtons implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton target = (JButton)e.getSource();
			String behavior = target.getText();
			int presentYear = today.get(Calendar.YEAR);
			switch(behavior) {
<<<<<<< HEAD
			case "Today":
=======
			case "today":
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
				if(calYear != presentYear) {
					crawling = new CrawlingSchedule(today.get(Calendar.YEAR));
					academySchedule = crawling.getAcademySchedule();
				}
				setToday();
				lForDateButs.actionPerformed(e);
				focusToday();
				return;
			case "<<":
				moveMonth(-12);
				break;
			case "<":
				moveMonth(-1);
				break;
			case ">":
				moveMonth(1);
				break;
			case ">>":
				moveMonth(12);
				break;	
			default:
				return;
			}
			
<<<<<<< HEAD
			if(calYear > presentYear - 5 && calYear <= presentYear) {
=======
			if(calYear > presentYear - 5 && calYear < presentYear) {
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
				crawling = new CrawlingSchedule(calYear);
				academySchedule = crawling.getAcademySchedule();
			}
			
<<<<<<< HEAD
			for(int i = 0; i < CAL_HEIGHT; i++)
				for(int j = 0; j < CAL_WIDTH; j++)
					dateButs[i][j].setBackground(Color.WHITE);	
			
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
			curMMYYYYLab.setText("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "
								+calYear+"</th></tr></table></html>");
			readMemo();
			showCal();
		}
	}
	
	private class listenForDateButs implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int k = 0, l = 0;
			for(int i = 0; i < CAL_HEIGHT; i++){
				for(int j = 0; j < CAL_WIDTH; j++){
					if(e.getSource() == dateButs[i][j]){ 
						k = i;
						l = j;
<<<<<<< HEAD
						dateButs[i][j].setBackground(Color.YELLOW);
					}
					else
						dateButs[i][j].setBackground(Color.WHITE);
=======
					}
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
				}
			}
	
			if(!(k ==0 && l == 0)) calDayOfMon = calDates[k][l]; //today버튼을 눌렀을때도 이 actionPerformed함수가 실행되기 때문에 넣은 부분

			cal = new GregorianCalendar(calYear, calMonth, calDayOfMon);
			
			String dDayString = new String();
<<<<<<< HEAD
			String fcolor = new String();
			JLabel dDayLabel = new JLabel(dDayString);
			int dDay=((int)((cal.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24));
			if(dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR)) 
						 && (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
						 && (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH))) {
				dDayString = "Today";
				dDayLabel.setText(dDayString);
				fcolor = "black";
			}
			else if(dDay >= 0) {
				dDayString = "D-" + (dDay + 1);
				dDayLabel.setText(dDayString);
				fcolor = "blue";
			}
			else if(dDay < 0) {
				dDayString = "D+" + (dDay * (-1));
				dDayLabel.setText(dDayString);
				fcolor = "red";
			}
			
			memoPanel.setSelectedDate("<Html><font size=3>"+(calMonth+1)+"/"+calDayOfMon+"/"+calYear+"&nbsp;("+"<font color="+fcolor+">"+dDayLabel.getText()+"</font color>"+")</html>");
=======
			int dDay=((int)((cal.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24));
			if(dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR)) 
						 && (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
						 && (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH))) dDayString = "Today"; 
			else if(dDay >= 0) dDayString = "D-" + (dDay + 1);
			else if(dDay < 0) dDayString = "D+" + (dDay * (-1));
			
			memoPanel.setSelectedDate("<Html><font size=3>"+(calMonth+1)+"/"+calDayOfMon+"/"+calYear+"&nbsp;("+dDayString+")</html>");
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
			memoPanel.setAcademySchedule(calYear, calMonth + 1, calDayOfMon); 
			readMemo();
		}
	}
	
	private void readMemo(){
<<<<<<< HEAD
		if(useDB) {
			String tmpDate = calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon;
			memoAreaText = db.getData(tmpDate);
			if(memoAreaText == null)	memoPanel.setUserMemo(null);
			else	memoPanel.setUserMemo(memoAreaText);
		} else {
			try{
				File f = new File("MemoData/"+ calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
				if(f.exists()){
					BufferedReader in = new BufferedReader(new FileReader("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt"));
					System.out.println("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
					memoAreaText = new Vector<String>();
					while(true){
						String tmpString = in.readLine();
						if(tmpString == null) break;
						memoAreaText.add(tmpString);
					}
					memoPanel.setUserMemo(memoAreaText);
					in.close();	
				}
				else memoPanel.setUserMemo(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void modifyMemo(String delMemo)
	{
		String tmpDate = calYear+((calMonth+1)<10?"0":"") + (calMonth+1) + (calDayOfMon<10?"0":"") + calDayOfMon;
		
		if(useDB) {
			delMemo = "'" + delMemo + "'";
			db.removeData(tmpDate, delMemo);
			bottomInfo.setText(delMemo + DelButMsg1);
		} else {
			try {
				if(memoAreaText.isEmpty()) {
					File f = new File("MemoData/"+ tmpDate +".txt");
					f.delete();
				} else {
					BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/" + tmpDate + ".txt"));
					String outString = "";
					
					Iterator<String> modify = memoAreaText.iterator();
					String tmpMemo = "";
					while(modify.hasNext()) {
						tmpMemo = modify.next();
						if (tmpMemo.equals(delMemo))
							continue;
						outString += tmpMemo + "\n";
					}
					
					if(outString.equals("")) {
						File f = new File("MemoData/"+ tmpDate +".txt");
						f.delete();
					} else {
						out.write(outString);
						out.close();
					}
					
					bottomInfo.setText(delMemo + DelButMsg1);
				}
			} catch (IOException e1) {
				bottomInfo.setText(DelButMsg3);
			}
		}

		readMemo();
		showCal(); 
	}
	
	private void writeMemo(String saveMemo)
	{
		String tmpDate = calYear+((calMonth+1)<10?"0":"") + (calMonth+1) + (calDayOfMon<10?"0":"") + calDayOfMon;
		if (useDB) {
			saveMemo = "'" + saveMemo + "'";
			db.insertData(tmpDate, saveMemo);
			bottomInfo.setText(saveMemo + SaveButMsg1);
		} else {
			saveMemo += '\n';
			try {
				File f = new File("MemoData");
				if(!f.isDirectory()) f.mkdir();
				
				if(saveMemo.length() > 0){
					BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/" + tmpDate + ".txt", true));
					PrintWriter pw = new PrintWriter(out, true);
					
					pw.append(saveMemo);  
					pw.close();
					
					bottomInfo.setText(saveMemo + SaveButMsg1);
				} else 
					bottomInfo.setText(SaveButMsg2);
			} catch (IOException e1) {
				bottomInfo.setText(SaveButMsg3);
			}
		}

		readMemo();
		showCal(); 
=======
		try{
			File f = new File("MemoData/"+ calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
			if(f.exists()){
				BufferedReader in = new BufferedReader(new FileReader("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt"));
				System.out.println("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
				memoAreaText = new Vector<String>();
				while(true){
					String tmpString = in.readLine();
					if(tmpString == null) break;
					memoAreaText.add(tmpString);
					System.out.println(memoAreaText);
				}
				memoPanel.setUserMemo(memoAreaText);
				in.close();	
			}
			else memoPanel.setUserMemo(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void modifyMemo()
	{
		try {
			if(memoAreaText.isEmpty()) {
				File f = new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")
						+ (calMonth+1) + (calDayOfMon<10?"0":"") + calDayOfMon+".txt");
				f.delete();
			} else {
				BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/"+calYear+((calMonth+1)<10?"0":"")
						+ (calMonth+1) + (calDayOfMon<10?"0":"") + calDayOfMon+".txt"));
				String outString = "";
				
				Iterator<String> modify = memoAreaText.iterator();
				while(modify.hasNext())
					outString += modify.next() + "\n";
				
				out.write(outString);
				out.close();
				
				bottomInfo.setText(calYear + ((calMonth + 1) < 10 ? "0" : "") 
						+ (calMonth + 1) + (calDayOfMon < 10 ? "0" : "") + calDayOfMon + ".txt" + DelButMsg1);
			}
			readMemo();
			showCal(); 
		} catch (IOException e1) {
			bottomInfo.setText(DelButMsg3);
		}
	}
	
	private void writeMemo(String memo)
	{
		try {
			File f = new File("MemoData");
			if(!f.isDirectory()) f.mkdir();
			
			if(memo.length() > 0){
				BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/"+calYear+((calMonth+1)<10?"0":"")
						+ (calMonth+1) + (calDayOfMon<10?"0":"") + calDayOfMon+".txt", true));
				PrintWriter pw = new PrintWriter(out, true);
				
				pw.append(memo);  
				pw.close();
				
				bottomInfo.setText(calYear + ((calMonth + 1) < 10 ? "0" : "") 
						+ (calMonth + 1) + (calDayOfMon < 10 ? "0" : "") + calDayOfMon + ".txt" + SaveButMsg1);
				readMemo();
				showCal();
			} else 
				bottomInfo.setText(SaveButMsg2);
		} catch (IOException e1) {
			bottomInfo.setText(SaveButMsg3);
		}
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
	}
	
	private class ThreadConrol extends Thread{
		public void run(){
			boolean msgCntFlag = false;
			int num = 0;
			String curStr = new String();
			while(true){
				try{
					today = Calendar.getInstance();
					String amPm = (today.get(Calendar.AM_PM)==0?"AM":"PM");
					String hour;
							if(today.get(Calendar.HOUR) == 0) hour = "12"; 
							else if(today.get(Calendar.HOUR) == 12) hour = " 0";
							else hour = (today.get(Calendar.HOUR)<10?" ":"")+today.get(Calendar.HOUR);
					String min = (today.get(Calendar.MINUTE)<10?"0":"")+today.get(Calendar.MINUTE);
					String sec = (today.get(Calendar.SECOND)<10?"0":"")+today.get(Calendar.SECOND);
<<<<<<< HEAD
					//infoClock.setText(amPm+" "+hour+":"+min+":"+sec);
=======
					infoClock.setText(amPm+" "+hour+":"+min+":"+sec);
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea

					sleep(1000);
					String infoStr = bottomInfo.getText();
					
					if(infoStr != " " && (msgCntFlag == false || curStr != infoStr)){
						num = 5;
						msgCntFlag = true;
						curStr = infoStr;
					}
					else if(infoStr != " " && msgCntFlag == true){
						if(num > 0) num--;
						else{
							msgCntFlag = false;
							bottomInfo.setText(" ");
						}
					}		
				}
				catch(InterruptedException e){
					System.out.println("Thread:Error");
				}
			}
		}
	}
	
	class MemoPart extends JPanel {
<<<<<<< HEAD
		private Font font = new Font("나눔스퀘어",Font.PLAIN,14);
		private JLabel selectedDate = new JLabel();
		private JTextField memoInsArea = new JTextField();					//메모 텍스트입력상자
		private Vector<String> CalDate;								//학사일정 저장구조 벡터
=======
		private JLabel selectedDate = new JLabel();
		private JTextField memoInsArea = new JTextField();					//메모 텍스트입력상자
		private Vector<String> CalDate;				//학사일정 저장구조 벡터
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		private JList<String> memoShoArea = new JList<String>();	//입력된 텍스트 보여주기 상자
		private JList<String> calShoArea = new JList<String>();		//학사 일정 보여주기 상자 
		
		private JPanel memoSubPanel = new JPanel();									//버튼을 담을 서브 패널
		private JButton saveBut = new JButton("Save");					//일정 저장 버튼
		private JButton delBut = new JButton("Delete");					//일정 삭제 버튼
<<<<<<< HEAD
		private String strMemo = new String("Memo");
		
		public MemoPart(int year, int month, int day) {
=======
		public MemoPart(int year, int month, int day) {
			academySchedule = crawling.getAcademySchedule();
			
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
			setAcademySchedule(year, month, day);
			setLayout(new GridLayout(5, 1));				//패널들의 배치관리자 설정 GridLayout
			memoSubPanel.setLayout(new GridLayout(1, 2));
		
<<<<<<< HEAD
			saveBut.setFont(font);
			delBut.setFont(font);
			
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
			memoSubPanel.add(saveBut);								//서브패널에 저장 버튼 추가
			memoSubPanel.add(delBut);								//서브패널에 삭제 버튼 추가
			
			Listener l = new Listener();
			saveBut.addActionListener(l);
<<<<<<< HEAD
			saveBut.setEnabled(false);
			delBut.addActionListener(l);
			delBut.setEnabled(false);
			
			memoInsArea.getDocument().addDocumentListener(new DocumentListener() {
				  public void changedUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void removeUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void insertUpdate(DocumentEvent e) {
				    warn();
				  }

				  public void warn() {
						String tempString = memoInsArea.getText();
						
						if(tempString.equals(null) || tempString.equals(""))
							saveBut.setEnabled(false);
						else
							saveBut.setEnabled(true);
				  }
				});
			
			memoShoArea.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					JList list = (JList)e.getSource();
					int selected = list.getSelectedIndex();
					
					if (selected != -1)
						delBut.setEnabled(true);
					else 
						delBut.setEnabled(false);
				}
			});
			
			setBorder(BorderFactory.createTitledBorder(strMemo));	//메모패널의 외곽선
=======
			delBut.addActionListener(l);
			
			setBorder(BorderFactory.createTitledBorder("Memo"));	//메모패널의 외곽선
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
			calShoArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			
			add(selectedDate);							//메모패널에 선택된날짜 레이블 추가
			add(calShoArea);								//메모패널에 학사일정 보여주기 추가
			add(new JScrollPane(memoShoArea));			//메모페널에 스크롤가능한 메모 보여주기 추가
			add(memoInsArea);
			add(memoSubPanel);							//메모패널에 버튼들이 포함된 서브패널 추가
			
			memoInsArea.grabFocus();
<<<<<<< HEAD
			memoInsArea.setFont(font);
			memoInsArea.requestFocus(true);
=======
			memoInsArea.requestFocus(true);
			setSize(1000, 1000);
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
			setVisible(true);
		}
		
		public void setAcademySchedule(int year, int month, int day) {
			int date = year * 10000 + month * 100 + day;
			CalDate = academySchedule.get(date);
			if(CalDate == null) CalDate = new Vector<String>();
			calShoArea.setListData(CalDate);
<<<<<<< HEAD
			calShoArea.setFont(font);
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		}
		
		public void setSelectedDate(String arg) {
			selectedDate.setText(arg);
<<<<<<< HEAD
			selectedDate.setFont(new Font("나눔스퀘어",Font.PLAIN,22));
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		}
		
		public void setUserMemo(Vector<String> arg) {
			if (arg == null) arg = new Vector<String>();
			memoShoArea.setListData(arg);
<<<<<<< HEAD
			memoShoArea.setFont(font);
=======
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
		}
		
		class Listener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton target = (JButton)e.getSource();
				if(target.equals(saveBut)) {					//저장버튼의 리스너
<<<<<<< HEAD
					String saveMSG = memoInsArea.getText();
					writeMemo(saveMSG);
=======
					writeMemo(memoInsArea.getText() + "\n");
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
					memoInsArea.setText("");
				} else if(target.equals(delBut)) {				//삭제버튼의 리스너
					int selected = memoShoArea.getSelectedIndex();
					if (selected != -1) {
<<<<<<< HEAD
						String delMSG = memoAreaText.get(selected);
						memoAreaText.remove(selected);
						modifyMemo(delMSG);
					} else {
						bottomInfo.setText(DelButMsg2);
						bottomInfo.setFont(font);
					}
						
=======
						memoAreaText.remove(selected);
						modifyMemo();
					} else
						bottomInfo.setText(DelButMsg2);
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
				}
			}
		}
	}
<<<<<<< HEAD
	
	@Override
		protected void finalize() throws Throwable {
			db.unconnectDB();
			super.finalize();
		}
}
=======
}
	
>>>>>>> 1f8ed8c5d60281b43344d33e7cf2542a8ff739ea
