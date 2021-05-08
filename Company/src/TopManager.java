public class TopManager implements Employee
{
    private int salary;
    private int bonus;
    private Company company;

    public TopManager(int startSalary, Company company){
        this.company = company;
        salary = startSalary;
        bonus = (int)(startSalary * 1.5);
    }

    @Override
    public int getMonthSalary() {
        if (company.getInCome() > 10000000){
            return salary + bonus;
        }
        return salary;
    }
}