import java.util.*;
import java.io.*;
import java.net.*;
public class Client 
{
	public static void main(String[] args) throws Exception
	{
		Socket clientsocket=new Socket("192.168.139.75",2000);
		System.out.println("\nClient Here");
		System.out.println("____________");
		
		//keyboard input
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));

		//input stream
		BufferedReader br=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
		//output stream
		PrintStream ps=new PrintStream(clientsocket.getOutputStream());
		
		//Give inputs and recieve reversed outputs
		String msg;
		System.out.println();
		do
		{
			System.out.println("Provide Input:");
			msg=input.readLine();	//got input
			
			ps.println(msg);	//send input
			
			System.out.println("\nWaiting for Server Response...");
			
			msg=br.readLine();
			System.out.println("Reversed output:"+msg+"\n");
		}while(!msg.equals("dne"));
		
		System.out.println("\nClosing Client Socket");
		clientsocket.close();
		
		//closing streams
		input.close();
		br.close();
		ps.close();
	}
}
