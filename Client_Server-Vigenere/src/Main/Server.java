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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author n18dc
 */
public class Server {
    
    static int num = 0; 
    static char res = ' ';
    public static void main(String[] args) throws IOException {
       
        ServerSocket server = new ServerSocket(8888); 
        System.out.println("Đang chờ kết nối");
        while (true)
        {
            Socket socket = server.accept(); 
            System.out.println("server đang kết nối client");
            DataInputStream input = new DataInputStream(socket.getInputStream()); 
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String key = handleKey(input.readUTF()); 
            String cipher = input.readUTF(); 
            String message = descryptMessage(cipher,key ); 
            
            output.writeUTF(message+"\n-->với ký tự xuát hiện nhiều nhất: "+letterAppearTheMost(message));
            
            socket.close(); // ngắt kết nối khi hoàn thành 
        }
        
        
//        socket.close();
//        server.close(); 
    }
    
    
    static String descryptMessage(String message, String key)
    {
        int value = 0;
        String res = "";
        int lenght = key.length();
        
        for (int i = 0; i < message.length(); i++)
        {
            if (isCharacter(message.charAt(i)) && message.charAt(i) != ' ')
            {     
                if (message.charAt(i) >= 97 && message.charAt(i) <= 122) value = 0;
                else if (message.charAt(i) >= 65 && message.charAt(i) <= 90) value = 32;
                
                if (message.charAt(i) + value - key.charAt(i%lenght) < 0)
                {
                    res = res + (char)(message.charAt(i) + value - key.charAt(i%lenght) + 26 + 97 - value);
                }
                else
                {
                    res = res + (char)(message.charAt(i) + value - key.charAt(i%lenght) + 97 - value);
                }
            }
            else
            {
                res = res + message.charAt(i);
            }
        }
        return res;
    }
    static String letterAppearTheMost(String str)
    { 
         Map<Character, Integer> letterMap = new HashMap<>();
        int max = 0; 
        for(int i = 0; i<str.length();i++){
            if (str.charAt(i) == ' ') continue;
            if(letterMap.get(str.charAt(i))==null){
                int quantityOfLetter = 1; 
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(i)==str.charAt(j)) quantityOfLetter++; 
                }
                letterMap.put(str.charAt(i), quantityOfLetter);
                if(quantityOfLetter>max) max = quantityOfLetter;
            }
        }
        String result = ""; 
        for(Map.Entry<Character, Integer> entry: letterMap.entrySet()){
                if(entry.getValue().equals(max)){
                    result += entry.getKey()+"("+entry.getValue()+" lần);";
                }
        }
        return result; 
    }
    static String handleKey(String str)
    {
        int value = 0;
        String temp = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != ' ')
            {
                if (str.charAt(i) >= 97 && str.charAt(i) <= 122) value = 0;
                else if (str.charAt(i) >= 65 && str.charAt(i) <=122) value = 32;
                
                temp = temp + (char)(str.charAt(i) + value);
            }
        }
        
        return temp;
    }
    
    static boolean isCharacter(char ch)
    {
        if (ch < 65) return false;
        if (ch > 122) return false;
        if (ch <= 90) return true;
        if (ch >= 97) return true;
        return false;
    }
}
