package webserver;

import java.io.*;
import java.net.*;
/**
 *
 * @author Thao
 */
//handles all the connection that contains requests
public class Connection extends Thread
{
    Socket s;
    
    //sending the output to client
    PrintWriter pw;
    
    //getting the input from client
    BufferedReader br;
    
    public Connection(Socket s) throws Exception
    {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pw = new PrintWriter(s.getOutputStream());
    }
    
    //read the request and give the response
    @Override
    public void run()
    {
        try {
            //get the request string and give this string to Request class
            String reqString = "";

            //from br we have to read our request
            while (br.ready()) {
                reqString += (char) br.read();
            }

            System.out.println(reqString); // for display
            Request req = new Request(reqString);

            // pass req obj to repsonse class for getting the response
            Response res = new Response(req);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
