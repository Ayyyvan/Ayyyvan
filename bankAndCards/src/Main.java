import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositCard;
import Clients.*;

public class Main
{
    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.addMoney(5000);
//
//        CardAccount cardAccount = new CardAccount();
//        cardAccount.addMoney(2000);
//        DepositCard depositCard = new DepositCard();
//        depositCard.addMoney(10000);
//
//        System.out.println(cardAccount.send(depositCard, 1000) +
//                "\nБаланс отправителя = " + cardAccount.getBalance() +
//                "\nБаланс получателя = " + depositCard.getBalance());
        Client iP1 = new individualEntrepreneur();
        iP1.info();
        Client legalEntity = new legalEntity();
        legalEntity.info();
        legalEntity.addMoney(1000);
        legalEntity.getMoney(500);
        Client naturalPerson = new naturalPerson();
        naturalPerson.info();

    }

}

