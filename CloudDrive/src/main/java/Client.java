import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
/**
 * Client command: upload fileName | download fileName
 *
 * @author Ayrat
 * */
public class Client extends JFrame {

    private String homeDir = "/home/ayrat/Coding/GeekBrains/CloudDrive/src/main/resources/client/";
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public Client() throws HeadlessException, IOException {
        socket = new Socket("localhost", 8188);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        setSize(300, 300);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JButton send = new JButton("SEND");
        JTextField text = new JTextField();
        send.addActionListener(a -> {
            String[] cmd = text.getText().split(" ");
            if (cmd[0].equals("upload")) {
                sendFile(cmd[1]);
            }
            if (cmd[0].equals("download")) {
                try {
                    getFile(cmd[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        panel.add(text);
        panel.add(send);
        add(panel);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                sendMessage("exit");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void getFile(String fileName) throws IOException {
        try {
            out.writeUTF("download");
            out.writeUTF(fileName);
            File file = new File(homeDir + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            long size = in.readLong();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[256];
            for (int i = 0; i < (size + 255) / 256; i++) {
                int read = in.read(buffer);
                fos.write(buffer, 0, read);
            }
            fos.close();
        } catch (Exception e) {
            out.writeUTF("File downloading crashed!!");
        }
    }

    private void sendFile(String fileName) {
        try {
            out.writeUTF("upload");
            out.writeUTF(fileName);
            File file = new File(homeDir + fileName);
            long length = file.length();
            out.writeLong(length);
            FileInputStream fileBytes = new FileInputStream(file);
            int read = 0;
            byte[] buffer = new byte[256];
            while ((read = fileBytes.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            out.flush();
            String status = in.readUTF();
            System.out.println(status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String text) {
        try {
            out.writeUTF(text);
            System.out.println(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}