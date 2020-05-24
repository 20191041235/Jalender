import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class MemoPart extends JFrame{
	
	JPanel memoPanel;											//memo부분 전체 패널
	JLabel selectedDate = new JLabel("5/24/2020");				//선택된 날짜를 출력할 레이블
	JTextField memoInsArea = new JTextField();					//메모 텍스트입력상자
	Vector<String> MemoDate;						 			//메모 저장구조 벡터
	Vector<String> CalDate = new Vector<String>();				//학사일정 저장구조 벡터
	JList<String> memoShoArea = new JList<String>(MemoDate);	//입력된 텍스트 보여주기 상자
	JList<String> calShoArea = new JList<String>(CalDate);		//학사 일정 보여주기 상자 
	
	JPanel memoSubPanel;									//버튼을 담을 서브 패널
	JButton saveBut = new JButton("Save");					//일정 저장 버튼
	JButton delBut = new JButton("Delete");					//일정 삭제 버튼
	
	public MemoPart() {
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		memoPanel.setLayout(new GridLayout(4,1));				//패널들의 배치관리자 설정 GridLayout
		memoSubPanel.setLayout(new GridLayout(1,2));
		
		memoSubPanel.add(saveBut);								//서브패널에 저장 버튼 추가
		memoSubPanel.add(delBut);								//서브패널에 삭제 버튼 추가
		
		memoPanel.setBorder(BorderFactory.createTitledBorder("Memo"));	//메모패널의 외곽선
		memoPanel.add(selectedDate);							//메모패널에 선택된날짜 레이블 추가
		memoPanel.add(calShoArea);								//메모패널에 학사일정 보여주기 추가
		memoPanel.add(new JScrollPane(memoShoArea));			//메모페널에 스크롤가능한 메모 보여주기 추가
		memoPanel.add(memoSubPanel);							//메모패널에 버튼들이 포함된 서브패널 추가
		
		c.add(memoPanel,"East");
		
		class Listener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == saveBut) {					//저장버튼의 리스너
					if(saveBut.getText().equals("Save")) {		//저장버튼인지 판단
						MemoDate = new Vector<String>();		
						MemoDate.add(memoInsArea.getText());	//텍스트필드의 텍스트를 가져와 벡터에 추가
						memoInsArea.setText("");
						memoShoArea.setListData(MemoDate);		//벡터를 리스트로 바꾸어 memoShoArea에 추가
					}
				}
				else if(e.getSource() == delBut) {				//삭제버튼의 리스너
					if(delBut.getText().equals("Delete")) {
						String rmText = memoInsArea.getText();	//텍스트필드의 텍스트를 가져옴
						for(int i = 0 ; i < MemoDate.size(); i++) {
							if(MemoDate.get(i) == rmText) {		//가져온 텍스트와 해당 벡터요소가 같으면 제거
								MemoDate.remove(i);
							}
						}
					}
				}
			}
		}
		
		setSize(1000,1000);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MemoPart();
	}

}