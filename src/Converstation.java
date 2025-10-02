import java.io.*;
import java.net.Socket;

public class Converstation extends Thread{
    private Socket socket;
    private int clientNumber;

    Converstation(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);

            String IpAdress = socket.getRemoteSocketAddress().toString();
            System.out.println("Client " + clientNumber + " is connected" + " with ip : " + IpAdress);
            pw.println(String.format("hello you are the client number %d", clientNumber));
            while (true) {
                String request = br.readLine();
                System.out.println("Client with ip : " + IpAdress + " send message : " + request);
                pw.println("longeur est " + request.length());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
