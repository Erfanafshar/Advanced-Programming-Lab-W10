import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {



    public static void main(String[] args) throws IOException, IOException {

        Socket socket = new Socket("127.0.0.1", 5000);
        System.out.println("Connected to server.");

        byte[] buffer = new byte[2048];

        Client client = new Client();

        //InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        //int read = in.read(buffer);
        out.write(scanner.nextLine().getBytes());

        //System.out.println(new String(buffer, 0, read));


        InputStream in = socket.getInputStream();
        int read = in.read(buffer);
        System.out.println(new String(buffer, 0, read));

        while (true) {
            out = socket.getOutputStream();
            //Scanner scanner = new Scanner(System.in);
            //int read = in.read(buffer);
            out.write(scanner.nextLine().getBytes());

            in = socket.getInputStream();
            read = in.read(buffer);

            System.out.println(new String(buffer, 0, read));

        }


    }



}
