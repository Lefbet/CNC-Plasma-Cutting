package toESSI;

public class design {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char Epilogh, Apanthsh='y';
		
		do {
			//MENU
			for (;;) {
				System.out.println("\n*MENU*");
				System.out.println("Sxediasmos...");
				System.out.println("1.Orthogwniou");
				System.out.println("2.Kyklou");
				System.out.println("3.Rodelas");
				System.out.println("4.Skalas");
				System.out.println("0.Eksodos\n");
				System.out.print("Epilogh: ");
				
				Epilogh = my.readChar();
				if (Epilogh!='0' && Epilogh!='1' && Epilogh!='2' && Epilogh!='3' && Epilogh!='4') {
					System.out.println("Epiloges 0-4.");
					continue;
				}
				else break;
			}
			//MENU
			
			if (Epilogh=='1') {
				//Orthogwnio
				int Vash, Ypsos, Paxos;
				
				do {
					System.out.print("Vash orthogwniou (mm): ");
					Vash = my.readInt();
					if (Vash<=0) System.out.println("Ektos oriwn.");
				} while (Vash<=0);
				do {
					System.out.print("Ypsos orthogwniou (mm): ");
					Ypsos = my.readInt();
					if (Ypsos<=0) System.out.println("Ektos oriwn.");
				} while (Ypsos<=0);
				do {
					System.out.print("Paxos (mm): ");
					Paxos = my.readInt();
					if (Paxos<=0) System.out.println("Ektos oriwn.");
				} while (Paxos<=0);
				
				rectangle myRectangle = new rectangle(Vash, Ypsos, Paxos);
				myRectangle.designrectangle();
				//Orthogwnio
			}
			else if (Epilogh=='2') {
				//Kyklos
				int Diametros, Paxos;
				
				do {
					System.out.print("Diametros kyklou (mm): ");
					Diametros = my.readInt();
					if (Diametros<=0) System.out.println("Ektos oriwn.");
				} while (Diametros<=0);
				do {
					System.out.print("Paxos (mm): ");
					Paxos = my.readInt();
					if (Paxos<=0) System.out.println("Ektos oriwn.");
				} while (Paxos<=0);
				
				circle myCircle = new circle(Diametros, Paxos);
				myCircle.designcircle();
				//Kyklos
			}
			else if (Epilogh=='3') {
				//Rodela
				int Diametros, diametros, Paxos;
				
				do {
					System.out.print("Diametros 1ou kyklou (mm): ");
					Diametros = my.readInt();
					if (Diametros<=0) System.out.println("Ektos oriwn.");
				} while (Diametros<=0);
				do {
					System.out.print("Diametros 2ou kyklou (mm): ");
					diametros = my.readInt();
					if (diametros<=0) System.out.println("Ektos oriwn.");
				} while (diametros<=0);
				do {
					System.out.print("Paxos (mm): ");
					Paxos = my.readInt();
					if (Paxos<=0) System.out.println("Ektos oriwn.");
				} while (Paxos<=0);
				
				int max=Diametros;
				if (diametros>max) {
					max=diametros;
					diametros=Diametros;
					Diametros=max;
				}
				
				washer myWasher = new washer(Diametros, diametros, Paxos);
				myWasher.designwasher();
				//Rodela
			}
			else if (Epilogh=='4') {
				//Skala
				int Skalopatia;
				char epilogh;
				
				for (;;) {
					System.out.println("1.Idio mhkos skalopatiwn");
					System.out.println("2.Diaforetika mhkh skalopatiwn");
					System.out.println("0.Epistrofh\n");
					System.out.print("Epilogh: ");
					
					epilogh = my.readChar();
					if (epilogh!='0' && epilogh!='1' && epilogh!='2') {
						System.out.println("Epiloges 0-2.");
						continue;
					}
					else break;
				}
				
				if (epilogh=='0') continue;
				
				do {
					System.out.print("Arithmos skalopatiwn: ");
					Skalopatia = my.readInt();
				} while (Skalopatia<=0);
				
				stair myStair = new stair(Skalopatia);
				if (epilogh=='1') {
					myStair.sameLength();
				}
				else if (epilogh=='2') {
					myStair.differentLength();
				}
				//Skala
			}
			else {
				//Eksodos
				System.out.println("Eksodos...\n");
				break;
			}
			//Telos epilogwn
			
			do {
				System.out.print("Dhmiourgia neou arxeiou (y/n)? ");
				Apanthsh = Character.toLowerCase(my.readChar());
				if (Apanthsh!='y' && Apanthsh!='n') System.out.println("Lanthasmenh apanthsh.");
				else if (Apanthsh=='n') System.out.println("Eksodos...\n");
			} while (Apanthsh!='y' && Apanthsh!='n');
			
		} while (Apanthsh=='y');
	}//main()

}//design
