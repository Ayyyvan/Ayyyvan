package Accounts;

import Accounts.BankAccount;

public class CardAccount extends BankAccount
{
    public CardAccount() {
        commissionPercent = 1;
    }

    @Override
    public void getMoney(int amount) {

        if (getBalance() - amount - getCommission(amount) >= 0)
        {
            super.getMoney(amount + getCommission(amount));
            System.out.println("\tСнято без комиссии: " + amount + " RUB\n" +
                               "\tКомиссия: " + getCommission(amount) + " RUB");
        }
        else {
            System.out.println("Вы не можете снять данную сумму денег");
        }

    }
}

