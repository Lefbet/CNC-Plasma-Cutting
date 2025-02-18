package toESSI;

import java.io.*;

public class stair {
	
	private int skalopatia;
	int ypsos, first_extra, last_extra, offset, paxos, leadin, leadout;
	boolean finish_with_height;
	char answer;
	String filename;
	FileWriter fstream;
	BufferedWriter out;
	
	stair(int steps) {
		skalopatia = steps;
	}
	
	public void sameLength() {
		do {
			System.out.print("Teleiwnei me ypsos (y/n)? ");
			answer = Character.toLowerCase(my.readChar());
			if (answer!='y' && answer!='n') System.out.println("Lanthasmenh apanthsh.");
		} while (answer!='y' && answer!='n');
		
		if (answer=='y') finish_with_height = true;
		else finish_with_height = false;
		
		do {
			System.out.print("Ypsos skalopatiwn (mm): ");
			ypsos = my.readInt()*10;
			if (ypsos<=0) System.out.println("Ektos oriwn.");
		} while (ypsos<=0);
		
		System.out.print("Parapanw ypsos prwtou skalopatiou (mm): ");
		first_extra = my.readInt()*10;
		
		if (finish_with_height) {
			System.out.print("Parapanw ypsos teleytaiou skalopatiou (mm): ");
			last_extra = my.readInt()*10;
		}
		
		int mhkos;
		
		do {
			System.out.print("Mhkos skalopatiwn (mm): ");
			mhkos = my.readInt()*10;
			if (mhkos<=0) System.out.println("Ektos oriwn.");
		} while (mhkos<=0);
		
		do {
			System.out.print("Offset (mm): ");
			offset = my.readInt()*10;
			if (offset<=0) System.out.println("Ektos oriwn.");
		} while (offset<=0);
		
		do {
			System.out.print("Paxos (mm): ");
			paxos = my.readInt()*10;
			if (paxos<=0) System.out.println("Ektos oriwn.");
		} while (paxos<=0);
		
		System.out.print("Onoma arxeiou: ");
		filename = my.readStr();
		leadin = paxos+20;
		leadout = paxos+10;
		
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
			for (int i=0; i<skalopatia; i++) {
				if (i==0) out.write("++" + (ypsos+first_extra));
				//else if (i==skalopatia-1) out.write("++" + (ypsos+last_extra));
				else out.write("++" + ypsos);
				out.newLine();
				out.write("+" + mhkos + "+");
				out.newLine();
			}
			
			if (finish_with_height) {
				out.write("++" + (ypsos+last_extra));
				out.newLine();
				out.write("+" + offset + "+");
				out.newLine();
				out.write("+-" + (ypsos+last_extra+offset));
				out.newLine();
				out.write("-" + mhkos + "+");
				out.newLine();
			}
			else {
				out.write("+-" + offset);
				out.newLine();
				out.write("-" + (mhkos-offset) + "+");
				out.newLine();
			}
			
			for (int i=skalopatia-2; i>=0; i--) {
				//if (i==skalopatia-2) out.write("+-" + (ypsos+last_extra));
				//else out.write("+-" + ypsos);
				out.write("+-" + ypsos);
				out.newLine();
				out.write("-" + mhkos + "+");
				out.newLine();
			}
			
			out.write("+-" + (ypsos+first_extra-offset));
			out.newLine();
			out.write("-" + offset + "+");
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
		} catch(IOException e) {
			System.out.println("\nYphrkse sfalma! To arxeio den apothikeytike.");
		}
	}//sameLength()
	
	public void differentLength() {
		do {
			System.out.print("Teleiwnei me ypsos (y/n)? ");
			answer = Character.toLowerCase(my.readChar());
			if (answer!='y' && answer!='n') System.out.println("Lanthasmenh apanthsh.");
		} while (answer!='y' && answer!='n');
		
		if (answer=='y') finish_with_height = true;
		else finish_with_height = false;
		
		do {
			System.out.print("Ypsos skalopatiwn (mm): ");
			ypsos = my.readInt()*10;
			if (ypsos<=0) System.out.println("Ektos oriwn.");
		} while (ypsos<=0);
		
		System.out.print("Parapanw ypsos prwtou skalopatiou (mm): ");
		first_extra = my.readInt()*10;
		
		if (finish_with_height) {
			System.out.print("Parapanw ypsos teleytaiou skalopatiou (mm): ");
			last_extra = my.readInt()*10;
		}
		
		int[] steps = new int[skalopatia];
		
		for (int i=0; i<skalopatia; i++) {
			do {
				System.out.print("Mhkos ");
				System.out.print(i+1 + "ou skalopatiou (mm): ");
				steps[i] = my.readInt()*10;
				if (steps[i]<=0) System.out.println("Ektos oriwn.");
			} while (steps[i]<=0);
		}
		
		do {
			System.out.print("Offset (mm): ");
			offset = my.readInt()*10;
			if (offset<=0) System.out.println("Ektos oriwn.");
		} while (offset<=0);
		
		do {
			System.out.print("Paxos (mm): ");
			paxos = my.readInt()*10;
			if (paxos<=0) System.out.println("Ektos oriwn.");
		} while (paxos<=0);
		
		System.out.print("Onoma arxeiou: ");
		filename = my.readStr();
		leadin = paxos+20;
		leadout = paxos+10;
		
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
			for (int i=0; i<skalopatia; i++) {
				if (i==0) out.write("++" + (ypsos+first_extra));
				//else if (i==skalopatia-1) out.write("++" + (ypsos+last_extra));
				else out.write("++" + ypsos);
				out.newLine();
				out.write("+" + steps[i] + "+");
				out.newLine();
			}
			
			if (finish_with_height) {
				out.write("++" + (ypsos+last_extra));
				out.newLine();
				out.write("+" + offset + "+");
				out.newLine();
				out.write("+-" + (ypsos+last_extra+offset));
				out.newLine();
				out.write("-" + steps[skalopatia-1] + "+");
				out.newLine();
			}
			else {
				out.write("+-" + offset);
				out.newLine();
				out.write("-" + (steps[skalopatia-1]-offset) + "+");
				out.newLine();
			}
			
			for (int i=skalopatia-2; i>=0; i--) {
				//if (i==skalopatia-2) out.write("+-" + (ypsos+last_extra));
				//else out.write("+-" + ypsos);
				out.write("+-" + ypsos);
				out.newLine();
				out.write("-" + steps[i] + "+");
				out.newLine();
			}
			
			out.write("+-" + (ypsos+first_extra-offset));
			out.newLine();
			out.write("-" + offset + "+");
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
		} catch(IOException e) {
			System.out.println("\nYphrkse sfalma! To arxeio den apothikeytike.");
		}
	}//differentLength()
	
}//stair
