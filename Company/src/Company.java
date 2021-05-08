import java.util.ArrayList;
import java.util.List;

public class Company
{
    private List<Employee> employeesList = new ArrayList<>();//список сотрудников
    private List<Integer> listOfProfits = new ArrayList<>();//список денег заработанных для компании каждым менеджером


    public void hire(Employee employee){
        employeesList.add(employee);
    }
    public void hireAll(List<Employee> employees){
        employeesList.addAll(employees);
    }
    public void fire(int index){
        if (index < 0){
            employeesList.remove(0);
        }
        employeesList.remove(Math.min(index, employeesList.size() - 1));
    }
    public long getInCome(){
        long inCome = 0;
        for (Integer profit : listOfProfits){
            inCome = inCome + profit;
        }
        return inCome;
    }
    public void addProfit(int profit){
        listOfProfits.add(profit);
    }
    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> topSalaryStaff = employeesList.subList(0,employeesList.size());
        topSalaryStaff.sort(new TopEmployeeComparator());
        if (count >= topSalaryStaff.size()){
            return topSalaryStaff;
        }
        if (count < 0){
            return topSalaryStaff.subList(0,0);
        }
        return topSalaryStaff.subList(0, count);
    }
    public void printTopSalaryStaff(int count){
        List<Employee> topSalaries = this.getTopSalaryStaff(count);
        System.out.println("Топ-" + topSalaries.size() + " зарплат:" );
        for (int i = 0; i < topSalaries.size(); i++){
            System.out.println((i + 1) + ". " + topSalaries.get(i).getClass() + " " + topSalaries.get(i).getMonthSalary() + " руб.");
        }
    }
    public List<Employee> getLowestSalaryStaff(int count){
        List<Employee> lowestSalaryStaff = employeesList.subList(0, employeesList.size());
        lowestSalaryStaff.sort(new LowEmployeeComparator());
        if (count >= lowestSalaryStaff.size()){
            return lowestSalaryStaff;
        }
        if (count < 0){
            return lowestSalaryStaff.subList(0,0);
        }
        return lowestSalaryStaff.subList(0, count);
    }
    public void printLowestSalaryStaff(int count){
        List<Employee> lowestSalaries = this.getLowestSalaryStaff(count);
        System.out.println("Топ-" + lowestSalaries.size() + " низких зарплат:");
        for (int i = 0; i < lowestSalaries.size(); i++){
            System.out.println((i + 1) + ". " + lowestSalaries.get(i).getClass() + " " + lowestSalaries.get(i).getMonthSalary() + " руб.");
        }
    }

    public List<Employee> getList(){
        return employeesList;
    } //возвращает список сотрудников

}