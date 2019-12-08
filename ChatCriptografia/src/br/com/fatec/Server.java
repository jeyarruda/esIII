package br.com.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.google.gson.*;

/**
 * 
 * @author Eduardo
 * ==== Modo de uso ====
 * 1. Execute uma vez o Server
 * 2. Execute quantas vezes desejar o Client
 */
public class Server extends Thread {
	private static ServerSocket server;
	private static ArrayList<BufferedWriter> clients  = new ArrayList<BufferedWriter>();;
	private Socket connection;
	private InputStreamReader isr;
	private BufferedReader buffRead;
	private InputStream is;
	Gson gson = new Gson();
	
	public Server(Socket socket) {
		this.connection = socket;
		try {
			is = this.connection.getInputStream();
			isr = new InputStreamReader(is);
			buffRead = new BufferedReader(isr);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO IOException", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void run() {
		String strPack = "";
		try {
			OutputStream os = this.connection.getOutputStream();
			Writer writer = new OutputStreamWriter(os);
			BufferedWriter buffWrite = new BufferedWriter(writer);
			clients.add(buffWrite);
			
			while(strPack != null) {
				strPack = buffRead.readLine();
				if(strPack != null) {
					strPack = strPack.replace("\n", "");
					
					JsonObject packReceive = gson.fromJson(strPack, JsonObject.class);
					String nickname = packReceive.get("nickname").getAsString();
					
					if(packReceive.has("quit")) {
						System.out.println("[PROMPT] => " + nickname + " saiu do chat");
					} else {
						String msg = packReceive.get("msg").getAsString();
						System.out.println(nickname + " => " + msg);
						sendToAll(buffWrite, strPack);
					}
				}
				strPack = "";
			}
		} catch(IOException eio) {
			JOptionPane.showMessageDialog(null, eio.getMessage(), "ERRO IO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void sendToAll(BufferedWriter bw, String pack) {
		BufferedWriter bws;
		try {
			for(BufferedWriter bufw : clients) {
				bws = (BufferedWriter) bufw;
				if(!(bw == bws)) {
					bufw.write(pack + "\n");
					bufw.flush();
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO sendToAll IOException", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		try {
		    JLabel lblPort = new JLabel("Porta do Servidor");
		    JTextField txtPort = new JTextField("12345");
		    Object[] components = {lblPort, txtPort};  
		    JOptionPane.showMessageDialog(null, components);
		    
		    server = new ServerSocket(Integer.parseInt(txtPort.getText()));
		    JOptionPane.showMessageDialog(null,	"Servidor ativo na porta: " + txtPort.getText());
		    
		    while(true) {
		       System.out.println("[PROMPT] => Aguardando novas conexões");
		       Socket conn = server.accept();
		       System.out.println("[PROMPT] => Novo cliente conectado");
		       Thread t = new Server(conn);
		       t.start();   
		    }
		  } catch (Exception e) {
			  JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		  }                
	}
}