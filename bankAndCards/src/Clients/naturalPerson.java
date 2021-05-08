package Clients;

public class naturalPerson extends Client{
    @Override
    public void info() {
        System.out.println("Условия для физических лиц: " +
                         "\n\tПополнение счета: без комиссии" +
                         "\n\tСнятие со счета: без комиссии " +
                         "\n\tБаланс: " + getBalance() + " RUB");
    }
}
