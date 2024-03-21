package sec1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientBack extends Thread {
	private String NickName, IPAddress;
	private int Port;
	private Socket socket;
	private String Message;
	private DataInputStream in;
	private DataOutputStream out;
	private ChatClientGUI chatgui;
	List<String> NickNameList = new ArrayList<String>(); // 유저목록을 저장합니다.

	public void getUserInfo(String NickName, String IPAddress, int Port) {
		this.NickName = NickName;
		this.IPAddress = IPAddress;
		this.Port = Port;
	}

	public void setGui(ChatClientGUI chatgui) {
		this.chatgui = chatgui;
	}

	@Override
	public void run() {
		try {
			socket = new Socket(IPAddress, Port);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			out.writeUTF(NickName);
//			NickNameList.add(NickName);//*
//			chatgui.AppendUserList(NickNameList); //*
			
			while (in != null) { 
				Message = in.readUTF();
				if (Message.contains("+++닉네임의시작+++")) { 
					chatgui.UserList.setText(null);
					NickNameList.add(Message.substring(12));
					chatgui.AppendUserList(NickNameList);
				} else if (Message.contains("님이 입장하셨습니다.\n")) {
					NickNameList.clear();
					chatgui.UserList.setText(null);
					System.out.println(Message);
					NickNameList.add(Message.substring(0, Message.trim().length()-11)); //****
					chatgui.AppendUserList(NickNameList); //*
					chatgui.AppendMessage(Message);
				} else if (Message.contains("님이 퇴장하셨습니다.\n")) {
					NickNameList.clear();
					chatgui.UserList.setText(null);
					chatgui.AppendMessage(Message);
				} else {
					chatgui.AppendMessage(Message);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Transmit(String Message) {
		try {
			out.writeUTF(Message);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}