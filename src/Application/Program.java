package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.println("Enter the path and name of the file to be read: ");
		System.out.println("exemple: C:\\Users\\Gabri\\Desktop\\Source file.txt ");
		System.out.print(": ");
		// C:\\Users\\Gabri\\Desktop\\Curso java\\Modulo 20 Programação funcional e expressões lambda!\\Exercicio\\dados.txt
		//C:\\dados.txt
		String path = sc.nextLine();

		System.out.println("Enter salary: ");
		double salary = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String readLine = br.readLine();

			while (readLine != null) {

				String[] div = readLine.split(",");

				String name = div[0];
				String email = div[1];
				double sal = Double.parseDouble(div[2]);

				list.add(new Employee(name, email, sal));
				
				readLine = br.readLine();

			}

		} catch (IOException c) {
			System.out.println("error: " + c.getMessage());
		}
		
		for(Employee p : list) {
			System.out.println(p);
		}
		
		sc.close();
	}

}
