package com.phoenix.demos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket server=new ServerSocket(20000);	
			Socket receiver=server.accept();
			DataInputStream serverIncoming=new DataInputStream(receiver.getInputStream());
			String value=serverIncoming.readUTF();
			System.out.println("The server received: "+value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
