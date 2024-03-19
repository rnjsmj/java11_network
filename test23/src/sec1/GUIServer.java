package sec1;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ManagerLogin extends JFrame implements ActionListener, KeyListener { //GUI 관리자 창
	JPanel port_log = new JPanel();
	JLabel port_label = new JLabel("입력을 허용할 포트번호를 입력하세요.");
	JLabel port_warn = new JLabel("(단, 포트번호는 0~65536)");
	JTextField port_num = new JTextField(20);
	JButton port_btn = new JButton("접속");
	
	ChatServerGUI serverChat;
	
	
	public ManagerLogin() {
		setTitle("GUI 관리자 창");
		setLocationRelativeTo(null); //auto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼 활성화
		setSize(600,400);
		setVisible(true);
		setResizable(false); //창 크기 조절 가능 여부
		
		port_btn.addActionListener(this);
		port_num.addKeyListener(this);
		port_log.add(port_label);	
		port_log.add(port_warn);	
		port_log.add(port_num);	
		port_log.add(port_btn);	
		add(port_log);
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) { //키보드 누른 후 이벤트
	}


	@Override
	public void keyPressed(KeyEvent e) { //키보드 입력 이벤트
		try {
			//키보드 입력 시 검증
			if (e.getKeyCode() == KeyEvent.VK_ENTER) { //Enter 키 입력
				int port = Integer.parseInt(port_num.getText().trim()); //입력된 값은 무조건 String이므로 형변환 필요
				serverChat = new ChatServerGUI(port);
				setVisible(false);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 입력입니다.");
		}
	}


	@Override
	public void keyReleased(KeyEvent e) { //키보드 떼진 후 이벤트
	}


	@Override
	public void actionPerformed(ActionEvent e) { //버튼 클릭 이벤트
		// 접속 버튼 (enter 키 동작과 같음)
		try {			
			int port = Integer.parseInt(port_num.getText().trim()); //입력된 값은 무조건 String이므로 형변환 필요
			if(e.getSource() == port_btn) { //접속 버튼이 클릭 된 경우만
				serverChat = new ChatServerGUI(port);
				setVisible(false);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 입력입니다.");
		}
		
		
	}
	
	
}

class ChatServerGUI extends JFrame implements ActionListener, KeyListener {

	JPanel serverGUI_Panel = new JPanel();
	JLabel serverLabel = new JLabel("메인 서버");
	JLabel userLabel = new JLabel("사용자 목록");
	JTextField chat = new JTextField(45);
	JButton enter = new JButton("전송");
	TextArea serverChatList = new TextArea(30, 50); //(행, 열)
	TextArea userList = new TextArea(30, 12);
	JTextField portLabel = new JTextField(50);
	ServerBack sb = new ServerBack();
	
	public ChatServerGUI(int port) {
		setTitle("메인 서버");
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(750, 620);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			portLabel.setText("서버 IP 주소 : " + InetAddress.getLocalHost().getHostAddress() +", 현재 연결 port : " + port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		serverChatList.setEditable(false);
		userList.setEditable(false);
		chat.addKeyListener(this); //
		enter.addActionListener(this);
		
		serverGUI_Panel.add(serverLabel);
		serverGUI_Panel.add(serverChatList);
		serverGUI_Panel.add(userLabel);
		serverGUI_Panel.add(userList);
		serverGUI_Panel.add(chat);
		serverGUI_Panel.add(enter);
		serverGUI_Panel.add(portLabel);
		add(serverGUI_Panel);
		
		userList.append("Admin\n");
		sb.setGUI(this);
		sb.startServer(port);
		sb.start();
		
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		String message = chat.getText().trim(); //앞 뒤 공백 제거
		if(e.getKeyCode() == KeyEvent.VK_ENTER && message.length() > 0) {
			appendMessage("서버 : " + message + "\n"); //서버에서 작동하는 전송
			sb.transmitAll("서버 : " + message + "\n");
			chat.setText(null); //전송 동작 후 입력창 비우기
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//전송 버튼
		String message = chat.getText().trim(); //앞 뒤 공백 제거
		if(e.getSource() == enter && message.length() > 0) {
			appendMessage("서버 : " + message + "\n"); //서버에서 작동하는 전송
			sb.transmitAll("서버 : " + message + "\n");
			chat.setText(null); //전송 동작 후 입력창 비우기
			
		}
	}
	
	public void appendMessage(String message) { //메시지 추가
		serverChatList.append(message);
	}
	
	public void appendUserList(List<String> nickNameList) { // 사용자 목록에 추가
		String name;
		for(int i=0; i<nickNameList.size(); i++) {
			name = nickNameList.get(i);
			userList.append(name + "\n");
		}
	}
	
}

public class GUIServer {

	public static void main(String[] args) {
		new ManagerLogin();

	}

}
