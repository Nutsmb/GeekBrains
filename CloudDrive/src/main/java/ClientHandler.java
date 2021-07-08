import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())
        ) {
            while (true) {
                String command = in.readUTF();
                if (command.equals("upload")) {
                    try {
                        File file = new File("/home/ayrat/Coding/GeekBrains/CloudDrive/src/main/resources/server/" + in.readUTF());
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
                        out.writeUTF("File uploaded successfully!");
                    } catch (Exception e) {
                        out.writeUTF("File uploading crashed!!");
                    }
                }
                if (command.equals("download")) {
                    try {
                        File file = new File("/home/ayrat/Coding/GeekBrains/CloudDrive/src/main/resources/server/" + in.readUTF());
                        long length = file.length();
                        out.writeLong(length);
                        FileInputStream fileBytes = new FileInputStream(file);
                        int read = 0;
                        byte[] buffer = new byte[256];
                        while ((read = fileBytes.read(buffer)) != -1) {
                            out.write(buffer, 0, read);
                        }
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (command.equals("exit")) {
                    System.out.println("Client disconnected correctly");
                    out.writeUTF("Bye-bye, client!");
                    break;
                }
                System.out.println(command);
            }

        } catch (SocketException socketException) {
            System.out.println("Client disconnected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}