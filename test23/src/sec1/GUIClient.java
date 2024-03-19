package sec1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class LoginGUI extends JFrame implements ActionListener, KeyListener {
	JPanel client_log = new JPanel();
	
	JLabel user_label = new JLabel("유저 입력");
	JTextField user_input = new JTextField(20);
	JLabel port_label = new JLabel("포트 입력");
	JTextField port_input = new JTextField(20);
	JLabel ip_label = new JLabel("주소 입력");
	JTextField ip_input = new JTextField(20);
	JButton client_btn = new JButton("접속");
	//300*60
	
	public LoginGUI() {
		setTitle("로그인 화면");
		setLocationRelativeTo(null); //auto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼 활성화
		setSize(300, 250);
		setVisible(true);
		setResizable(false); //창 크기 조절 가능 여부
		
		
		
		client_btn.addActionListener(this);
		user_input.addKeyListener(this);
		port_input.addKeyListener(this);
		ip_input.addKeyListener(this);
		
		client_log.add(user_label);	
		client_log.add(user_input);	
		client_log.add(port_label);	
		client_log.add(port_input);	
		client_log.add(ip_label);	
		client_log.add(ip_input);	
		client_log.add(client_btn);	
		add(client_log);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

public class GUIClient {

	public static void main(String[] args) {
		new LoginGUI();

	}

}
