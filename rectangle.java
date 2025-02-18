package toESSI;

import java.io.*;

public class rectangle {
	
	private int vash, ypsos, paxos;
	String filename;
	FileWriter fstream;
	BufferedWriter out;
	
	rectangle(int x, int y, int z) {
		vash = x*10;
		ypsos = y*10;
		paxos = z*10;
	}//rectangle()
	
	public void designrectangle() {		
		//Onoma arxeiou
		filename = paxos/10 + "mm_" + vash/10 + "x" + ypsos/10;
		
		int leadin = paxos+20;
		int leadout = paxos+10;
		
		//Dhmiourgia arxeiou
		try {
			fstream = new FileWriter(filename + ".ess");
			out = new BufferedWriter(fstream);
			
			//leadin
			out.write("5\n");
			out.write("+" + leadout + "+");
			out.newLine();
			out.write("6\n");
			out.write("29\n");
			out.write("7\n");
			out.write("++" + leadin);
			out.newLine();
			//sxedio
			out.write("++" + ypsos);
			out.newLine();
			out.write("+" + vash + "+");
			out.newLine();
			out.write("+-" + ypsos);
			out.newLine();
			out.write("-" + vash + "+");
			out.newLine();
			//leadout
			out.write("-" + leadout + "+");
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
	}//designrectangle()
	
}//rectangle
