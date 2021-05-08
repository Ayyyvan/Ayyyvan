package Clients;

import java.text.DateFormat;
import java.util.Date;

public abstract class Client
{
    private double balance;
    private double commissionPercent;


    public double getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(double commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean addMoney(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Добавлено: " + amount + " RUB");
            return true;
        }
        else {
            System.out.println("Ошибка операции");
            return false;
        }
    }

    public boolean getMoney(double amount) {
        if (getBalance() - amount >= 0) {
            setBalance (getBalance() - amount);
            System.out.println("Снято: " + amount + " RUB");
            return true;
        }
        else {
            System.out.println("Ошибка операции");
            return false;
        }
    }

    public abstract void info();


}
