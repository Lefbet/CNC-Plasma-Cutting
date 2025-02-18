package toESSI;

import java.io.*;

public class circle {
	
	private int aktina, paxos;
	String filename;
	FileWriter fstream;
	BufferedWriter out;
	
	circle(int diam, int z) {
		aktina = diam*5;
		paxos = z*10;
	}//circle()
	
	public void designcircle() {		
		//Onoma arxeiou
		filename = paxos/10 + "mm_d" + aktina/5;
		
		int leadin = paxos+20;
		int leadout = paxos+10;
		
		//Dhmiourgia arxeiou
		try {
			fstream = new FileWriter(filename + ".ess");
			out = new BufferedWriter(fstream);
			
			//leadin
			out.write("5\n");
			out.write("+" + (aktina-leadin) + "+" + (2*aktina+leadin));
			out.newLine();
			out.write("6\n");
			out.write("29\n");
			out.write("7\n");
			out.write("+" + leadin + "-" + leadin + "+" + leadin + "++");
			out.newLine();
			//sxedio
			out.write("+" + aktina + "-" + aktina + "+-" + aktina + "-");
			out.newLine();
			out.write("-" + aktina + "-" + aktina + "-" + aktina + "+-");
			out.newLine();
			out.write("-" + aktina + "+" + aktina + "++" + aktina + "-");
			out.newLine();
			out.write("+" + aktina + "+" + aktina + "+" + aktina + "+-");
			out.newLine();
			//leadout
			out.write("+" + leadout + "+" + leadout + "++" + leadout + "+");
			out.newLine();
			out.write("8\n");
			out.write("38\n");
			out.write("5\n");
			out.write("0\n");
			
			out.close();
			
			System.out.println("\nTo arxeio apothikeytike epityxws!");
		} catch (IOException e) {
			System.out.println("\nYphrkse sfalma! To arxeio den apothikeytike.");
		}
	}//designcircle()
	
}//circle
