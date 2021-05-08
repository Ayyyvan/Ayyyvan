public class Main{
    public static void main(String[] args) {
        Company company = new Company();
        for (int i = 0; i < 180; i++){
            company.hire(new Operator(40000));
        }// нанимаю 180 Операторов
        for (int i = 0; i < 80; i++){
            company.hire(new Manager(50000, company));
        }//нанимаю 80 Менеджеров
        for (int i = 0; i < 10; i++){
            company.hire(new TopManager(50000, company));
        }//нанимаю 10 Топ Менеджеров
        System.out.println("Компания заработала: " + company.getInCome() + " руб.");
        company.printTopSalaryStaff(15);
        System.out.println(company.getList());
        company.printLowestSalaryStaff(30);
        System.out.println(company.getList());
        for (int i = 0; i < 135; i++){
            company.fire(100 + i);
        }
        company.printTopSalaryStaff(15);
        company.printLowestSalaryStaff(30);


    }
}