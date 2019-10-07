package protocol;
import java.io.*;

import java.net.*;

import java.util.Scanner;

public class simplex_protocol_sender

{

public static void main(String args[]) throws Exception

{

	simplex_protocol_sender sws = new simplex_protocol_sender();

sws.run();

}

public void run() throws Exception

{

Scanner sc=new Scanner(System.in);

System.out.println("Enter no of frames to be sent:");

int n=sc.nextInt();

Socket myskt=new Socket("localhost",9999);

PrintStream myps=new PrintStream(myskt.getOutputStream());

for(int i=0;i<=n;)

{

if(i==n)

{

myps.println("exit");

break;

}

System.out.println("Frame no "+i+" is sent");

myps.println(i);

BufferedReader bf=new BufferedReader(new InputStreamReader(myskt.getInputStream()));
String ack=bf.readLine();
if(ack!=null)
{
	System.out.println("Frame "+i+" is Successfully receive");
	i++;
	Thread.sleep(4000);
}
else
{
  myps.println(i);
}

}
}

}