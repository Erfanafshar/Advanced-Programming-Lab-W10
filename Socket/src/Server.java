import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {



    public static void main(String[] args) throws IOException, InterruptedException {

        Server servers = new Server();
        ServerSocket server = new ServerSocket(5000);
        System.out.print("Server started.\nWaiting for a client ... ");

        Socket client = server.accept();
        System.out.println("client accepted!");

        //Scanner scanner = new Scanner(System.in);

        byte[] buffer = new byte[2048];

        //OutputStream out = client.getOutputStream();
        InputStream in = client.getInputStream();
        int read = in.read(buffer);
        System.out.println(new String(buffer, 0, read));


        //out.write(scanner.nextLine().getBytes());

        Scanner scanner = new Scanner(System.in);
        OutputStream out = client.getOutputStream();
        out.write(scanner.nextLine().getBytes());

        while (true) {
            in = client.getInputStream();
            read = in.read(buffer);
            System.out.println(new String(buffer, 0, read));

            //label1.setText(new String(buffer, 0, read));

            //Scanner scanner = new Scanner(System.in);
            out = client.getOutputStream();
            out.write(scanner.nextLine().getBytes());
        }
    }



}
