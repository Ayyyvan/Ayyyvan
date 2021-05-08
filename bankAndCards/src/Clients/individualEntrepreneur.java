package Clients;

public class individualEntrepreneur extends Client {

    public individualEntrepreneur(){
        setCommissionPercent(1);
    }

    @Override
    public void info() {
        System.out.println("Условия для индивидуальных предпренимателей:" +
                         "\n\tПополнение счета: < 1000 руб. - комиссия " + getCommissionPercent() + " %" +
                         "\n\t                 >= 1000 руб. - комиссия " + getCommissionPercent()/2 + " %" +
                         "\n\tСнятие со счета: без комиссии" +
                         "\n\tБаланс: " + getBalance());
    }

    @Override
    public boolean addMoney(double amount) {
        double testBalance = getBalance();
        if (amount < 1000 && amount > 0){
            setBalance(getBalance() + amount * (100 - getCommissionPercent())/100);
            System.out.println("Пополнение баланса: " + (getBalance() - testBalance) + " RUB");
            return true;
        }
        if (amount >= 1000 && amount > 0){
            setBalance(getBalance() + amount * (100 - getCommissionPercent()/2)/100);
            System.out.println("Пополнение баланса: " + (getBalance() - testBalance) + " RUB");
            return true;
        }
        else {
            System.out.println("Ошибка операции");
            return false;
        }
    }
}
