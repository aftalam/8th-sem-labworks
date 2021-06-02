import java.io.*;
import java.net.*;
import java.util.*;

//Client class
class Client {
	
	//driver code
	public static void main(String[] args)
	{
		
		//establish a connection by providing host and port number
		try (Socket socket = new Socket("localhost", 1234)) {
			
			//writing to server
			PrintWriter out = new PrintWriter(
				socket.getOutputStream(), true);

			//reading from server
			BufferedReader in
				= new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			//object of scanner class
			Scanner sc = new Scanner(System.in);
			String line = null;

			while (!"exit".equalsIgnoreCase(line)) {
				
				//reading from user
				System.out.println("\nEnter Numbers: ");
				String a1,a2;
				a1=sc.nextLine();
				a2=sc.nextLine();
				System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");	
				String ch;
				System.out.println("\nEnter Choice: ");
				ch=sc.nextLine();

				line=ch+' '+a1+' '+a2;

				//sending the user input to server
				out.println(line);
				out.flush();

				//displaying server reply
				System.out.println("Server replied Result is: "
								+ in.readLine());
			}
			
			//closing the scanner object
			sc.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
