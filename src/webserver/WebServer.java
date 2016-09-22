package webserver;

import java.io.*;
import java.net.*;

/**
 *
 * @author Thao
 */
public class WebServer {
    ServerSocket serverSocket;
    
    public static void main(String[] args) throws Exception {
//        readConfig();
        new WebServer().runServer();
    }
        
    private static void readConfig() throws Exception{
        BufferedReader br = null;
        String line;
        try{
            br = new BufferedReader (new FileReader("C:\\Users\\Thao\\Documents\\NetBeansProjects\\WebServer\\src\\webserver\\httpd.conf"));
        } 
        catch (FileNotFoundException fnfound){
            System.out.println(fnfound.getMessage() + "The file was not found.");
            System.exit(0);
        }
        
        try{
            while((line = br.readLine()) != null){
                if(!line.startsWith("#")){
                    System.out.println(line);
                }
            }
        }catch(IOException ioex){
            System.out.println(ioex.getMessage() + "Error reading file.");
        } finally{
            System.exit(0);
        }
    }
    
    public void runServer() throws Exception {
        serverSocket = new ServerSocket(80);
        
        //for accepting requests
        acceptRequests();
    }
    
    private void acceptRequests() throws Exception {
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
