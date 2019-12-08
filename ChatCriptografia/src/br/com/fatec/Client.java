package br.com.fatec;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.*;
import com.google.gson.*;

public class Client extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JTextArea chat;
	private JTextField txtMsg;
	private JButton btnSend;
	private JButton btnQuit;
	private JLabel lblChatHistory;
	private JLabel lblMsg;
	private JLabel lblIP;
	private JLabel lblPort;
	private JLabel lblNickname;
	private JTextField txtIP;
	private JTextField txtPort;
	private JTextField txtNickname;
	private JPanel pnlContent;
	private Socket socket;
	private OutputStream os;
	private BufferedWriter bfw;
	private Writer wrt; 
	
	private String nickname;
	
	Gson gson = new Gson();
	
	public Client() throws IOException {
		JLabel lblMessage = new JLabel("Conectar");
		
		lblIP = new JLabel("IP do Servidor");
		txtIP = new JTextField("127.0.0.1");
		
		lblPort = new JLabel("Porta");
		txtPort = new JTextField("12345");
		
		lblNickname = new JLabel("Nickname");
		txtNickname = new JTextField("User" + System.currentTimeMillis());
		
		Object[] components = {lblMessage, lblIP, txtIP, lblPort, txtPort, lblNickname, txtNickname};  
		JOptionPane.showMessageDialog(null, components);    
		
		chat = new JTextArea(10,20);
		chat.setBackground(new Color(240,240,240));
		chat.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
		chat.setEditable(false);
		chat.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(chat);
		
		txtMsg = new JTextField(20);
		txtMsg.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));                    
		txtMsg.addKeyListener(this);
		
		lblChatHistory = new JLabel("Histórico de mensagens");
		
		lblMsg = new JLabel("Chat");
		
		btnQuit = new JButton("Sair");
		btnQuit.setToolTipText("Sair do Chat");
		btnQuit.addActionListener(this);
		
		btnSend = new JButton("Enviar");
		btnSend.setToolTipText("Enviar Mensagem");
		btnSend.addActionListener(this);
		btnSend.addKeyListener(this);
		
		pnlContent = new JPanel();
		pnlContent.add(lblChatHistory);
		pnlContent.add(scroll);
		pnlContent.add(lblMsg);
		pnlContent.add(txtMsg);
		pnlContent.add(btnQuit);
		pnlContent.add(btnSend);
		pnlContent.setBackground(Color.LIGHT_GRAY);                                 
		
		setTitle(txtNickname.getText());
		setContentPane(pnlContent);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setResizable(false);
		setSize(250,300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				quitChat();
			}
		});
	}
	
	public void connectServer() {
		nickname = txtNickname.getText();
		try {
			socket = new Socket(
				txtIP.getText(),
				Integer.parseInt(txtPort.getText())
			);
			
			os = socket.getOutputStream();
			wrt = new OutputStreamWriter(os);
			bfw = new BufferedWriter(wrt);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String encriptMessage(String msg) {
		StringBuilder msgCipher = new StringBuilder();
		int key = 2, msgLen = msg.length();
		
		for(int i = 0; i < msgLen; i++) {
			int cipherLetter = ((int) msg.charAt(i)) + (key - 1);
			
			while(cipherLetter > 126) cipherLetter -= 94;
			
			msgCipher.append((char) cipherLetter);
		}
		return msgCipher.toString();
	}
	
	public String decriptMessage(String cipher) {
		StringBuilder msgDecipher = new StringBuilder();
		int key = 2, msgLen = cipher.length();
		
		for(int i = 0; i < msgLen; i++) {
			int decipherLetter = ((int) cipher.charAt(i)) - (key - 1);
			
			while(decipherLetter < 32) decipherLetter += 94;
			
			msgDecipher.append((char) decipherLetter);
		}
		return msgDecipher.toString();
	}
	
	public void sendMessage(String msg) throws IOException {
		JsonObject packSend = new JsonObject();
		packSend.addProperty("nickname", nickname);
		packSend.addProperty("msg", encriptMessage(msg));
		chat.append("[" + nickname + "] => " + msg + "\n");
		String str = packSend.toString();
		bfw.write(str + "\n");
		bfw.flush();
		txtMsg.setText("");        
	}
	
	public void listen() {
		try {
			InputStream in = socket.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader bfr = new BufferedReader(inr);
			while(socket.isConnected())
				if(bfr.ready()) {
					JsonObject packReceive = gson.fromJson(bfr.readLine(), JsonObject.class);
					String unickname = packReceive.get("nickname").getAsString();
					String umsg = decriptMessage(packReceive.get("msg").getAsString());
					chat.append("[" + unickname + "] => " + umsg + "\r\n");
				}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO IO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void quitChat() {
		try {
			if(!socket.isClosed()) {
				chat.append("Você saiu do chat\r\n");
				JsonObject packSend = new JsonObject();
				packSend.addProperty("nickname", nickname);
				packSend.addProperty("quit", true);
				
				bfw.write(packSend.toString() + "\n");
				bfw.close();
				wrt.close();
				os.close();
				socket.close();
			} else {
				System.exit(0);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO IO", JOptionPane.ERROR_MESSAGE);
		}
		
		btnSend.setEnabled(false);
		btnQuit.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
	  try {
	     if(evt.getActionCommand().equals(btnSend.getActionCommand()))
	        sendMessage(txtMsg.getText());
	     else 
	    	 if(evt.getActionCommand().equals(btnQuit.getActionCommand()))
	    		 quitChat();
	     } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO IO", JOptionPane.ERROR_MESSAGE);
	     }                       
	}
	
	@Override
	public void keyPressed(KeyEvent evt) {
	   if(evt.getKeyCode() == KeyEvent.VK_ENTER){
	       try {
	          sendMessage(txtMsg.getText());
	       } catch (IOException e) {
	          JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO IO", JOptionPane.ERROR_MESSAGE);
	       }                                                          
	   }                       
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	
	public static void main(String[] args) throws IOException {
		Client client = new Client();
		client.connectServer();
		client.listen();
	}
}