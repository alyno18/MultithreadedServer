import java.io.IOException;
import java.net.InetAddress;

public class GestioneClient {

	public static void main(String[] args) {
		try{
            Client cli = new Client(InetAddress.getLocalHost(), 2000);
            System.out.println("Client connesso");
            System.out.println("Server: " +cli.leggi());
            Countdown cd = new Countdown(Integer.getInteger(cli.leggi()));
            cd.start();
    }
        catch(IOException e){
            e.printStackTrace();
        }
	}

}