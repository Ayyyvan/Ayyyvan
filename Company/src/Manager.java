public class Manager implements Employee
{
    private int salary;
    private int profit;
    private Company company;

    public Manager(int startSalary, Company company){
        this.company = company;
        profit = (int)(Math.random()*25000) + 115000;
        getCompany().addProfit(getProfit());
        this.salary = startSalary + (5 * getProfit())/100;
    }

    public int getMonthSalary() {
        return salary;
    }
    public Company getCompany() {
        return company;
    }
    public int getProfit() {
        return profit;
    }
}

