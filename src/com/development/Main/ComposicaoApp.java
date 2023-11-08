package com.development.Main;

import com.development.Entities.Department;
import com.development.Entities.HourContract;
import com.development.Entities.Worker;
import com.development.Enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ComposicaoApp {
    public static void main(String... args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String name = sc.nextLine();

        Department dp = new Department(name);

        System.out.print("Name worker: ");
        String nameWorker = sc.nextLine();

        System.out.print("Level: ");
        String levelWorker = sc.nextLine().toUpperCase();
        WorkerLevel wkl = WorkerLevel.valueOf(levelWorker);

        System.out.print("Base salary U$: ");
        double salary = sc.nextDouble();

        Worker worker = new Worker(nameWorker, wkl, salary, dp);

        System.out.print("How many contracts to this worker? ");
        int contracts = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < contracts; i++){
            System.out.print("Enter contract " + (i+1) + " data: ");
            System.out.print("Date (DD/MM/yyyy): ");
            Date date = sdf.parse(sc.next());

            System.out.print("Value per hour U$: ");
            double value = sc.nextDouble();

            System.out.print("Duartion (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(date, value, hours);
            worker.addContract(contract);
        }

        sc.nextLine();
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthDate = sc.nextLine();

        int month = Integer.parseInt(monthDate.substring(0, 2));
        int year = Integer.parseInt(monthDate.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthDate + ": " + worker.income(year, month));

        System.out.println(monthDate);
        sc.close();
    }
}
