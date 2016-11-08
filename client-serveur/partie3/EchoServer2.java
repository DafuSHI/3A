import java.io.*;
import java.net.*;
import java.lang.*;

/**
 * This module contains the application logic of an echo server
 * which uses a stream socket for interprocess  communication.
 * A command-line argument is required to specify the server port.
 * @author M. L. Liu
 */
public class EchoServer2 {
   static final String endMessage = ".";
   public static void main(String[] args) {
      String[] data=new String[3]; 
      int serverPort = 8000;    // default port
      String message;

      if (args.length == 1 )
         serverPort = Integer.parseInt(args[0]);       
      try {
         // instantiates a stream socket for accepting
         //   connections
   	   ServerSocket myConnectionSocket = 
            new ServerSocket(serverPort); 
/**/     System.out.println("Daytime server ready.");  
         while (true) {  // forever loop
            // wait to accept a connection 
/**/        System.out.println("Waiting for a connection.");
            MyStreamSocket myDataSocket = new MyStreamSocket
                (myConnectionSocket.accept( ));
/**/        System.out.println("connection accepted");
            boolean done = false;
            while (!done) {
           
               message = myDataSocket.receiveMessage( );
/**/           System.out.println("message received: "+ message);
			   data=message.split(" ");
			   int result=0;
			   System.out.println(data[0]);
			   System.out.println(data[1]);
			   System.out.println(data[2]);
			    try{
			   int a=Integer.parseInt(data[1]);
			   int b=Integer.parseInt(data[2]);

			   
			   		if(data[0].equals("ADD")){
			   		System.out.println("ADD s");
			   		result = a+b;
				    }else if(data[0].equals("MUL")){
				    System.out.println("MUL s");
				    result = a*b;
				    }else if(data[0].equals("SUB")){
				    result = a-b;
				    }else if(data[0].equals("DIV")){
				    result = a/b;
				    }else if(data[0].equals("POW")){
				    double result_m = Math.pow(a, b);
				    result = (int) result_m;
				    }
				  }catch (Exception ex) {
				    System.out.println("Merde!");
				  	myDataSocket.sendMessage("merde!");
		      		ex.printStackTrace( );
		      		
	   			  }
			   
               if ((message.trim()).equals (endMessage)){
                  //Session over; close the data socket.
/**/              System.out.println("Session over.");
                  myDataSocket.close( );
                  done = true;
               } //end if
               else {
                  // Now send the echo to the requestor
                  message=Integer.toString(result); 
                  myDataSocket.sendMessage(message);
               } //end else
		       } //end while !done
         } //end while forever
       } // end try
	    catch (Exception ex) {
          ex.printStackTrace( );
	    }
   } //end main
} // end class
