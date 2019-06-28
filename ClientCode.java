package com.phoenix.demos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner sc=new Scanner(System.in);
			Socket sender=new Socket(InetAddress.getByName("localhost"),20000);
			DataOutputStream clientOutgoing=new DataOutputStream(sender.getOutputStream());
			String dataToSend=sc.nextLine();
			clientOutgoing.writeUTF(dataToSend);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
