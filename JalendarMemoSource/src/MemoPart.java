import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class MemoPart extends JFrame{
	
	JPanel memoPanel;											//memo�κ� ��ü �г�
	JLabel selectedDate = new JLabel("5/24/2020");				//���õ� ��¥�� ����� ���̺�
	JTextField memoInsArea = new JTextField();					//�޸� �ؽ�Ʈ�Է»���
	Vector<String> MemoDate;						 			//�޸� ���屸�� ����
	Vector<String> CalDate = new Vector<String>();				//�л����� ���屸�� ����
	JList<String> memoShoArea = new JList<String>(MemoDate);	//�Էµ� �ؽ�Ʈ �����ֱ� ����
	JList<String> calShoArea = new JList<String>(CalDate);		//�л� ���� �����ֱ� ���� 
	
	JPanel memoSubPanel;									//��ư�� ���� ���� �г�
	JButton saveBut = new JButton("Save");					//���� ���� ��ư
	JButton delBut = new JButton("Delete");					//���� ���� ��ư
	
	public MemoPart() {
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		memoPanel.setLayout(new GridLayout(4,1));				//�гε��� ��ġ������ ���� GridLayout
		memoSubPanel.setLayout(new GridLayout(1,2));
		
		memoSubPanel.add(saveBut);								//�����гο� ���� ��ư �߰�
		memoSubPanel.add(delBut);								//�����гο� ���� ��ư �߰�
		
		memoPanel.setBorder(BorderFactory.createTitledBorder("Memo"));	//�޸��г��� �ܰ���
		memoPanel.add(selectedDate);							//�޸��гο� ���õȳ�¥ ���̺� �߰�
		memoPanel.add(calShoArea);								//�޸��гο� �л����� �����ֱ� �߰�
		memoPanel.add(new JScrollPane(memoShoArea));			//�޸���ο� ��ũ�Ѱ����� �޸� �����ֱ� �߰�
		memoPanel.add(memoSubPanel);							//�޸��гο� ��ư���� ���Ե� �����г� �߰�
		
		c.add(memoPanel,"East");
		
		class Listener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == saveBut) {					//�����ư�� ������
					if(saveBut.getText().equals("Save")) {		//�����ư���� �Ǵ�
						MemoDate = new Vector<String>();		
						MemoDate.add(memoInsArea.getText());	//�ؽ�Ʈ�ʵ��� �ؽ�Ʈ�� ������ ���Ϳ� �߰�
						memoInsArea.setText("");
						memoShoArea.setListData(MemoDate);		//���͸� ����Ʈ�� �ٲپ� memoShoArea�� �߰�
					}
				}
				else if(e.getSource() == delBut) {				//������ư�� ������
					if(delBut.getText().equals("Delete")) {
						String rmText = memoInsArea.getText();	//�ؽ�Ʈ�ʵ��� �ؽ�Ʈ�� ������
						for(int i = 0 ; i < MemoDate.size(); i++) {
							if(MemoDate.get(i) == rmText) {		//������ �ؽ�Ʈ�� �ش� ���Ϳ�Ұ� ������ ����
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