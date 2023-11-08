package com.development.Entities;

import com.development.Enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;

public class Worker {
    private String name;
    private WorkerLevel leve;
    private double baseSalary;
    private ArrayList<HourContract> contracts = new ArrayList<>();
    private Department department;

    public Worker(String name, WorkerLevel leve, double baseSalary, Department department) {
        this.name = name;
        this.leve = leve;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLeve() {
        return leve;
    }

    public void setLeve(WorkerLevel leve) {
        this.leve = leve;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public ArrayList<HourContract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<HourContract> contracts) {
        this.contracts = contracts;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    //implementar dados aqui
    public double income(Integer year, Integer month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts){
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month){
                sum += c.totalValue();
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", leve=" + leve +
                ", baseSalary=" + baseSalary +
                ", contracts=" + contracts +
                ", department=" + department +
                '}';
    }
}
