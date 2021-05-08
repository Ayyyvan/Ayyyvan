package Accounts;

import Accounts.BankAccount;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DepositCard extends BankAccount
{

    Date date = new Date();
    Calendar calendar = new GregorianCalendar();

    public DepositCard()
    {

    }

    @Override
    public void addMoney(int amount) {
        super.addMoney(amount);
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
    }

    @Override
    public void getMoney(int moneyToGet) {
        if (date.after(calendar.getTime())) {
            super.getMoney(moneyToGet);
        }
        else {
            System.out.println("Вы не можете еще снимать деньги");
        }
    }
}
