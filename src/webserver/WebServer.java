package webserver;

import java.io.*;
import java.net.*;

/**
 *
 * @author Thao
 */
public class WebServer 
{

    ServerSocket serverSocket;
    
    public static void main(String[] args) throws Exception 
    {
        readConfig();
        //new WebServer().runServer();
        
    }
        
    private static void readConfig() throws Exception
    {
        FileInputStream finput = new FileInputStream ("C:\\Users\\Thao\\Documents\\NetBeansProjects\\WebServer\\src\\webserver\\http.conf");
        int ch;
        while((ch=finput.read())!=-1)
        {
            System.out.print((char)ch); //testing
        }
    }
    
    public void runServer() throws Exception 
    {
        serverSocket = new ServerSocket(25);
        
        //for accepting requests
        acceptRequests();
        
    }
    
    private void acceptRequests() throws Exception
    {
        while(true)
        {
            //connection to client is in the form of socket which contain the stream for i/o
            Socket s = serverSocket.accept();
            Connection c = new Connection(s);
            
            //c is the thread, start the thread
            c.start(); //run the method automatically
            
        }
    }
}
