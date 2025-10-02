import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread {
    private int clientNumber;

    public static void main(String[] args) {
        new ServerMT().start();

    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server started...");
            while (true) {
                Socket s = ss.accept();
                ++clientNumber;
                new Converstation(s,clientNumber).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
