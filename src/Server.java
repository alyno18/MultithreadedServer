import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
	ServerSocket ss;
    Socket so;
    DataOutputStream out;
    DataInputStream in;
    
    public Server(int porta){
        try{
            ss = new ServerSocket(porta);
            System.out.println();
            Countdown cd = new Countdown(5);
    		cd.start();
            ss.setSoTimeout(5000);
        }
        catch(SocketTimeoutException e) {
        	e.printStackTrace();
        }
        catch(BindException e) {
			System.err.println("porta occupata");
			e.printStackTrace();
		}
        catch (IOException ex){
        	ex.printStackTrace();
        }
        
    }
    public void inAscolto(){
        try{
	        so = ss.accept();
	        System.out.println("connessione stabilita");
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