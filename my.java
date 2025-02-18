package toESSI;

import java.io.*;

public class my {
	
	public static String readStr() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		String string = " ";
		
		try {
			string = br.readLine();
		} catch(IOException ex) {
			System.out.println("\nYphrkse sfalma! Leptomereies: ");
			ex.printStackTrace();
		}
		
		return string;
	}//readStr()
	
	public static int readInt() {
		try {
			return Integer.parseInt(readStr());
		} catch(Exception ex) {
			System.out.println("Mh apodekto.");
			return 0;
		}
	}//readInt()
	
	public static float readFloat() {
		try {
			return Float.parseFloat(readStr());
		} catch(Exception ex) {
			System.out.println("Mh apodekto.");
			return 0;
		}
	}//readFloat()
	
	public static char readChar() {
		IOException e = new IOException();
		
		try {
			String s = readStr();
			if (s.length()!=1) throw e;
			return s.charAt(0);
		} catch(Exception ex) {
			System.out.println("Mh apodekto.");
			return ' ';
		}
	}//readChar()
	
}//my
