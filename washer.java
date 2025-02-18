package toESSI;

import java.io.*;

public class washer {
	
	private int aktina_megalh, aktina_mikrh, paxos;
	String filename;
	FileWriter fstream;
	BufferedWriter out;
	
	washer(int big_diam, int small_diam, int z) {
		aktina_megalh = big_diam*5;
		aktina_mikrh = small_diam*5;
		paxos = z*10;
	}//washer()
	
	public void designwasher() {		
		//Onoma arxeiou
		filename = paxos/10 + "mm_d" + aktina_megalh/5 + "-d" + aktina_mikrh/5;
		
		int leadin = paxos+20;
		int leadout = paxos+10;
		
		//Dhmiourgia arxeiou
		try {
			fstream = new FileWriter(filename + ".ess");
			out = new BufferedWriter(fstream);
			
			//Eswterikos kyklos
			//leadin
			out.write("5\n");
			out.write("+" + (aktina_megalh-leadin) + "+" + (aktina_megalh-aktina_mikrh+leadin));
			out.newLine();
			out.write("6\n");
			out.write("29\n");
			out.write("7\n");
			out.write("+" + leadin + "-" + leadin + "+" + leadin + "++");
			out.newLine();
			//sxedio
			out.write("+" + aktina_mikrh + "+" + aktina_mikrh + "++" + aktina_mikrh + "+");
			out.newLine();
			out.write("-" + aktina_mikrh + "+" + aktina_mikrh + "-" + aktina_mikrh + "++");
			out.newLine();
			out.write("-" + aktina_mikrh + "-" + aktina_mikrh + "+-" + aktina_mikrh + "+");
			out.newLine();
			out.write("+" + aktina_mikrh + "-" + aktina_mikrh + "+" + aktina_mikrh + "++");
			out.newLine();
			//leadout
			out.write("+" + leadout + "+" + leadout + "++" + leadout + "+");
			out.newLine();
			out.write("8\n");
			out.write("38\n");
			
			//Ekswterikos kyklos
			//leadin
			out.write("5\n");
			out.write("-" + (leadin+leadout) + "+" + (aktina_megalh+aktina_mikrh+leadin-leadout));
			out.newLine();
			out.write("6\n");
			out.write("29\n");
			out.write("7\n");
			out.write("+" + leadin + "-" + leadin + "+" + leadin + "++");
			out.newLine();
			//sxedio
			out.write("+" + aktina_megalh + "-" + aktina_megalh + "+-" + aktina_megalh + "-");
			out.newLine();
			out.write("-" + aktina_megalh + "-" + aktina_megalh + "-" + aktina_megalh + "+-");
			out.newLine();
			out.write("-" + aktina_megalh + "+" + aktina_megalh + "++" + aktina_megalh + "-");
			out.newLine();
			out.write("+" + aktina_megalh + "+" + aktina_megalh + "+" + aktina_megalh + "+-");
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
	}//designwasher()

}//washer
