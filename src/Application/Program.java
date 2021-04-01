package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.println("Enter the path and name of the file to be read: ");
		System.out.println("exemple: C:\\Users\\Gabri\\Desktop\\Source file.txt ");
		System.out.print(": ");
		
		String path = sc.nextLine();

		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		
		System.out.print("Enter the initial of the name that will be summed: ");
		char letra = sc.next().toUpperCase().charAt(0);
			
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

		List<String> newList = list.stream()
				.filter(x -> x.getSal() > salary)
				.map(x -> x.getEmail())
				.sorted()
				.collect(Collectors.toList());

		System.out.println("Email of people whose salary is more than " + salary + ": ");
		newList.forEach(n -> System.out.println(n));
		
		
		double sum = list.stream()
				.filter(x -> x.getName().toUpperCase().charAt(0) == letra)
				.map(x -> x.getSal())
				.reduce(0.0, (x, y) -> x + y);
		
		System.out.println("Sum of salary of people whose name starts with '" + letra + "': " + sum);

		sc.close();
	}

}
