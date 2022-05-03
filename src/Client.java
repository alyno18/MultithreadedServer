import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	Socket so;
	DataOutputStream out;
	DataInputStream in;
	
    public Client(InetAddress ip, int porta){
        try{
        	so = new Socket(ip, porta);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void scrivi(String messaggio){
        try {
        	out = new DataOutputStream(so.getOutputStream());
        	out.writeUTF(messaggio);
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
        
    }
    public String leggi(){
    	String msg = "";
        try{
        	in = new DataInputStream(so.getInputStream());
        	msg = in.readUTF();
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
        return msg;
    }
}