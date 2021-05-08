package Clients;

public class legalEntity extends Client {

    public legalEntity() {
        setCommissionPercent(1);
    }

    @Override
    public boolean getMoney(double amount) {
        if (getBalance() - amount * (100 + getCommissionPercent()) / 100 >= 0 && amount > 0) {
            setBalance(getBalance() - amount * (100 + getCommissionPercent()) / 100);
            System.out.println("Снято: " + amount + " RUB" +
                             "\nКомиссия: " + amount * (getCommissionPercent() / 100) + " RUB");
            return true;
        }
        else {
            System.out.println("Ошибка операции");
            return false;
        }
    }

    @Override
    public void info() {
        System.out.println("Условия для юридических лиц:" +
                         "\n\tПополнение счета: без комиссии" +
                         "\n\tСнятие со счета: комиссия " + getCommissionPercent() + " %" +
                         "\n\tБаланс: " + getBalance() + " RUB");
    }
}
