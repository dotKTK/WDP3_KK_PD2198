/**
 *
 *  @author Koszykowski Krzysztof PD2198
 *
 */

package zad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		String fname = System.getProperty("user.home") + "/tab.txt";

		Scanner scan = null;
		ArrayList<Integer> tablicaArray = new ArrayList<Integer>();
	

		try
		{
			scan = new Scanner(new File(fname));
		} catch (FileNotFoundException exc)
		{
			System.out.println("***");
			;
			System.exit(0);
		}

		while (scan.hasNext())
		{
			String zmienna = scan.next();

			try
			{
				Integer.valueOf(zmienna);
			} catch (NumberFormatException nfe)
			{
				System.out.println("***");
				System.exit(0);
			}

		
			tablicaArray.add(Integer.valueOf(zmienna));
		
		}
	
		int maks =  tablicaArray.get(0);
		int[] gdzieMaks = new int[10000000];
		int licznikMaks = 0;

		for (int i = 0; i < tablicaArray.size(); i++)
		{
			System.out.print(tablicaArray.get(i) + " ");
			if (tablicaArray.get(i) >= maks)
			{
				maks = tablicaArray.get(i);
			}

		}
		System.out.println("");
		System.out.println(maks);

		for (int i = 0; i < tablicaArray.size(); i++)
		{
			if (tablicaArray.get(i) == maks)
			{
				gdzieMaks[licznikMaks] = i;
				licznikMaks++;
			}
		}

		for (int i = 0; i < licznikMaks; i++)
		{
			System.out.print(gdzieMaks[i] + " ");
		}
	}
}