package Accounts;

public class BankAccount
{
    private int balance;
    protected int commissionPercent;
    private int commission;

    public BankAccount() {
        commissionPercent = 0;
    }

    public void getMoney(int amount) {

        if (balance - amount - getCommission(amount) >= 0) {
            balance = balance - amount;
            System.out.println("Снято со счёта: " + amount + " RUB");
        }
        else {
            System.out.println("Вы не можете снять данную сумму денег");
        }
    }

    public void addMoney(int amount) {
        balance = balance + amount;
        System.out.println("Пополнение баланса: +" + amount + " RUB");
    }

    public int getCommission(int moneyForOperation)
    {
        commission = (moneyForOperation * commissionPercent / 100);
        return commission;
    }

    public int getBalance() {
        return balance;
    }

    public void balance() {
        System.out.println("Ваш баланс составляет " + balance + " RUB");
    }

    public boolean send(BankAccount receiver, int amount) {
        int moneyBeforeSending = balance;
        int receiverMoneyBefore = receiver.getBalance();
        if (balance - amount - commission >= 0) {
            getMoney(amount);
            if (balance < moneyBeforeSending) {
                receiver.addMoney(amount);
                return receiverMoneyBefore < receiver.getBalance();
            }
            else return false;
        }
        else {
            return false;
        }
    }
}
