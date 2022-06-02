import org.codehaus.groovy.transform.SourceURIASTTransformation;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class MyClient {
    public static void main(String[] args) {
        while (true) {
            try {
                Socket s = new Socket("localhost", 6666);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                System.out.println("Number of line to be print:");
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                dout.writeUTF(str);
                System.out.println("server says:");
                String str1 = (String) dis.readUTF();
                System.out.println(str1);
                dout.flush();
                dout.close();
                dis.close();
                s.close();
                System.out.println("want to enter more ? y/n");
                String sq=sc.nextLine();
                if (sq.equals("n"))
                    break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    }
