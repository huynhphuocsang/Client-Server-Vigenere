/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author n18dc
 */
public class Server {
    
    static int num = 0; 
    static char res = ' ';
    public static void main(String[] args) throws IOException {
       
        
        ServerSocket server = new ServerSocket(8888); 
        System.out.println("Đang chờ kết nôi");
        Socket socket = server.accept(); 
        System.out.println("server đang kết nối client");
        DataInputStream input = new DataInputStream(socket.getInputStream()); 
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        
        String key = input.readUTF(); 
        String cipher = input.readUTF(); 
        String message = descryptMessage(cipher,key ); 
        letterAppearTheMost(message);
        output.writeUTF(message+"-với ký tự '"+res+"' xuất hiện nhiều nhất ("+num+" lần)");
        
        socket.close();
        server.close(); 
    }
    
    
    static String descryptMessage(String message, String key)
    {
        String res = "";
        int lenght = key.length();
        
        for (int i = 0; i < message.length(); i++)
        {
            if (message.charAt(i) != ' ')
            {
                if (message.charAt(i) - key.charAt(i%lenght) < 0)
                {
                    res = res + (char)(message.charAt(i) - key.charAt(i%lenght) + 26 + 97);
                }
                else
                {
                    res = res + (char)(message.charAt(i) - key.charAt(i%lenght) + 97);
                }
            }
            else
            {
                res = res + " ";
            }
        }
        return res;
    }
    static void letterAppearTheMost(String str)
    {
        num = 0;
        int[] count = new int[26];
        
        for (int i = 0; i < 26; i++) count[i] = 0;
        
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == ' ') continue;
            if(++count[str.charAt(i) - 97] > num)
            {
                res = str.charAt(i);
                num = count[str.charAt(i) - 97];
            }
        }
    }
}
