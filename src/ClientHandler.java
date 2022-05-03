import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private final Socket clientSocket;
    
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    public void run(){
        DataOutputStream out;
        DataInputStream in;
        Socket so = null;
        try{
            out = new DataOutputStream(so.getOutputStream());
    	out.writeUTF(messaggio);
            
            in = new DataInputStream(so.getInputStream());
            String msg = in.readUTF();

            String line;
            while((line = in.readLine()) != null){
                System.out.printf(
                    " Sent from the client: %s\n",
                    line);
                out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(out != null){
                    out.close();
                }
                if(in != null){
                    in.close();
                    clientSocket.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}