package problemRancaVerzija1;

import java.util.Scanner;

// primer sa vezbi:
// 12 5 9 7 4 10 3				(12 kapacitet, 5 predmeta sa tezinama 9, 7, 4, 10, 3

public class RanacMain
{

	// PROBLEM RANCA - najjednostavnija verzija
		// K - kapacitet ranca
		// niz predmeta sa datim tezinama
		// predmet se moze uzeti 1 ili 0 puta
		// cilj je uzeti odredjen broj predmeta tako da je suma njihovih tezina jednaka kapacitetu ranca K
		
	public static void main(String[] args)
	{
		int kapacitetRanca, brojPredmeta;
		Scanner sc = new Scanner(System.in);
		
		// UNOS
		System.out.println("Unesite kapacitet ranca:");
		kapacitetRanca = sc.nextInt();
		System.out.println("Unesite broj predmeta:");
		brojPredmeta = sc.nextInt();
		
		Predmet[] predmeti = new Predmet[brojPredmeta];
		System.out.println("Unesite predmete:");
		for (int i = 0; i < predmeti.length; i++) 
		{
			predmeti[i] = new Predmet(sc.nextInt());
		}
		sc.close();
		
		// Kreiranje matrice
		Polje [][]a = new Polje[brojPredmeta + 1][kapacitetRanca + 1];
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[i].length; j++) 
			{
				a[i][j] = new Polje();
			}
			System.out.println();
		}
		if(ZamolioBihTeDaMiNapunisRanac(a, predmeti))
			System.out.println("Postoji resenje");
		else
			System.out.println("Ne postoji resenje");
		
		rekonstruisiResenje(a, predmeti);
		prikaziMatricu(a);
	}
	
	
	/**
	 * Metod ispisuje na standardni izlaz predmete koje treba uzeti kako bi se resio zadati problem ranca. 
	 * Neophodno je pre toga pozvati metod ZamolioBihTeDaMiNapunisRanac kako bi se dobilo validno resenje.
	 * @param a Matrica polja klase Polje
	 * @param predmeti Niz predmeta sa datim tezinama
	 */
	private static void rekonstruisiResenje(Polje[][] a, Predmet[] predmeti)
	{
		int j = a[a.length - 1].length - 1;
		if(!a[a.length - 1][j].jelPostojiResenje())
		{
			System.out.println("Ne postoji resenje.");
			return;
		}
		for(int i = a.length - 1; i >= 0 && j > 0; i--)							// neophodan uslov j > 0 kako ne bi predmeti[i-1] indeksirali -1 na kraju
		{
			if(a[i][j].jelUzetPredmet())
			{
				System.out.println("predmet " + i + " tezina: " + predmeti[i-1].getTezina());
				j = j - predmeti[i-1].getTezina();
			}
		}
	}
	
	/**
	 * Resava zadati problem ranca koristeci paradigmu dinamickog programiranja
	 * @param a Matrica polja klase Polje
	 * @param predmeti Niz predmeta sa datim tezinama
	 * @return true ako postoji resenje, false ako ne postoji
	 */
	private static boolean ZamolioBihTeDaMiNapunisRanac(Polje [][]a, Predmet[] predmeti)
	{
		int n, m;
		n = a.length;
		m = a[0].length;
		
		// inicijalno popunjavamo spec. slucaj da je kapacitet 0, tada uvek postoji resenje
		a[0][0].postaviStatusPredmeta(true);
		a[0][0].postaviStatusResenja(true);
		for (int i = 1; i < a.length; i++)
		{	
			a[i][0].postaviStatusResenja(true);
		}
		
		// NOTE i-ta vrsta odgovara predmetu predmeti[i - 1] 
		for (int i = 1; i < a.length; i++)
		{
			int tezinaTekucegPredmeta = predmeti[i-1].getTezina();
			for (int j = 1; j < a[i].length; j++)
			{
				int kapacitet = j;
				
				if(a[i-1][j].jelPostojiResenje())
				{
					a[i][j].postaviStatusResenja(true);
				}
				
				if(tezinaTekucegPredmeta <= kapacitet)
				{
					if(a[i-1][kapacitet - tezinaTekucegPredmeta].jelPostojiResenje())
					{
						a[i][j].postaviStatusPredmeta(true);
						a[i][j].postaviStatusResenja(true);
					}
					else if(kapacitet - tezinaTekucegPredmeta == 0)
					{
						a[i][j].postaviStatusPredmeta(true);
						a[i][j].postaviStatusResenja(true);
					}
				}
			}
		}
		
		// proverimo da li postoji resenje
		if(a[n-1][m-1].jelPostojiResenje())
			return true;
		else
			return false;
	}
	
	/**
	 * Vrsi prikaz matrice
	 * @param a Matrica polja koju je potrebno prikazati na standardni ulaz
	 */
	private static void prikaziMatricu(Polje[][] a)
	{
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[i].length; j++) 
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
