import java.io.*;
import java.net.*;
class MyServer {
    public static void main(String[] args) {
        while (true) {
            try {
                ServerSocket ss = new ServerSocket(6666);
                Socket s = ss.accept();//establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                String str = (String) dis.readUTF();
                int i = Integer.parseInt(str);
                str = "";
                for (int n = 1; n <= i; n++) {
                    for (int nn = 0; nn < n; nn++)
                        str = str + "* ";
                    str = str + "\n";
                }
                System.out.println("Server processing done for input " + i);
                dout.writeUTF(str);
                ss.close();
                s.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
