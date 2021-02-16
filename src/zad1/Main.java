/**
 *
 *  @author Koszykowski Krzysztof PD2198
 *
 */

package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		String fname = System.getProperty("user.home") + "/iter.txt";
		Scanner scan = null;

		try
		{
			scan = new Scanner(new File(fname));
		} catch (FileNotFoundException exc)
		{
			System.out.println("***");
			System.exit(0);
		}

		int start = 0, stop = 0, suma = 0, podSuma = 0;
		int licznik = 0;

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
			case 1:
				start = Integer.valueOf(zmienna);
				// System.out.println(zmienna);
				break;
			case 2:
				// System.out.println(zmienna);
				stop = Integer.valueOf(zmienna);
				;
				break;
			case 3:
				// System.out.println(zmienna);
				suma = Integer.valueOf(zmienna);
				;
				break;

			default:
				System.out.println("***");
				System.exit(0);
			}

		}

		for (int i = start; i <= stop; i++)
		{
			if (podSuma <= suma)
			{
				podSuma = podSuma + i;
			}

		}
		if (licznik >= 3)
		{
			System.out.println(podSuma);
		} else
			System.out.println("***");
	}
}
