/**
 *
 *  @author Koszykowski Krzysztof PD2198
 *
 */

package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		String fname = System.getProperty("user.home") + "/pakiety.txt";

		Scanner scan = null;

		try
		{
			scan = new Scanner(new File(fname));
		} catch (FileNotFoundException exc)
		{
			System.out.println("***");
			System.exit(0);
		}

		int pierwszyPakiet = 0, pojemnoscDysku = 0, pojemnoscDyskuWBajtach = 0, pojemnoscPakietu = 0;
		int licznik = 0, licznikTablicy = 1;

		while (scan.hasNext())
		{
			licznik++;
			String zmienna = scan.next();

			try
			{
				Integer.valueOf(zmienna);
			} catch (NumberFormatException nfe)
			{
				System.out.println("***");
				System.exit(0);
			}

			switch (licznik)
			{
			case 1: // rozmiar pierwszego pakietu
				pierwszyPakiet = Integer.valueOf(zmienna);
				break;
			case 2: // rozmiar dysku w megabajtach
				pojemnoscDysku = Integer.valueOf(zmienna);
				break;

			default:
				System.out.println("***");
				System.exit(0);
			}
		}
		pojemnoscDyskuWBajtach = pojemnoscDysku * 1024 * 1024;
		int[] tablica = new int[1000000];
		tablica[0] = pierwszyPakiet;

		while (pojemnoscPakietu < pojemnoscDyskuWBajtach)
		{

			if ((licznikTablicy >= 1) && (licznikTablicy < 5))
			{
				pojemnoscPakietu = (tablica[licznikTablicy - 1] * 2);
				tablica[licznikTablicy] = pojemnoscPakietu;
				licznikTablicy++;
				pojemnoscPakietu = (tablica[licznikTablicy - 1] * 2); // oblicz pojemnosc nastepnego pakietu
			}

			if ((licznikTablicy >= 5))
			{
				pojemnoscPakietu = (tablica[licznikTablicy - 1] * 3);
				tablica[licznikTablicy] = pojemnoscPakietu;
				licznikTablicy++;
				pojemnoscPakietu = (tablica[licznikTablicy - 1] * 3); // oblicz pojemnosc nastepnego pakietu
			}

		}

		System.out.println(licznikTablicy);
		int suma = 0;
		for (int i = 0; i < licznikTablicy; i++)
		{
			System.out.println((i + 1) + " " + tablica[i]);
			suma = suma + tablica[i];
		}
		System.out.println(suma);
	}
}
