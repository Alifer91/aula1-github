package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc =new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name:");
		String departmentName =sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName=sc.nextLine();
		System.out.print("Level: ");
		String workerLevel=sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary= sc.nextDouble();
		
		Worker worker=new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary, new Department(departmentName));
		//definindo numero de contratos e criando-os
		System.out.print("How many contracts to this worker? ");
		int n =sc.nextInt();
		
		for (int i=1;i<=n;i++) {
			System.out.println("Enter contract #"+i+" data");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate =sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour =sc.nextDouble();
			System.out.println("Duration (hours)");
			int hours =sc.nextInt();
			HourContract contract=new HourContract(contractDate, valuePerHour, hours);
			//associando o contract ao worker
			worker.addContract(contract);
		}
		/*
		 * Integer.parseInt()-> serve para transformar a string em integer
		 * 
		 * nomeDaVariavel.substring(0,2)  -> significa que a string ser� 
		 * dividida em uma substring e guardada na variavel do comando 
		 * e os numero indicam a posi��o de onde ser� cortada (no caso
		 * da posi��o zero ao 2, se apenas colocar 3 ser�o selecionadas do 3 em diante*/
		System.out.println();
		
		System.out.print("Enter mounth and year to calculate income (MM/YYYY): ");
		String monthAndYear =sc.next();
		
		int month =Integer.parseInt(monthAndYear.substring(0, 2));
		int year =Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for "+monthAndYear+": "+String.format("%.2f",worker.income(year, month)));
		sc.close();

	}

}
