import java.util.Comparator;

class LowEmployeeComparator implements Comparator<Employee> {//от меньшего к большему
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getMonthSalary() > o2.getMonthSalary()){
            return 1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()){
            return -1;
        }
        return 0;
    }
}
class TopEmployeeComparator implements Comparator<Employee>{//от большего к меньшему
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getMonthSalary() > o2.getMonthSalary()){
            return -1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()){
            return 1;
        }
        return 0;
    }
}
