package pro.sky;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Андрей","Булочкин","Иванович","1",12000000);
        Employee employee2 = new Employee("Олег","Иванов","Сергеевич","2",32293);
        Employee employee3 = new Employee("Сергей","Брынза","Каликович","2",1200);
        Employee employee4 = new Employee("Тимофей","Монга","Бродскович","4",999);
        Employee employee5 = new Employee("Иосиф","Покойный","Могилович","12",931333);

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee(employee1);
        employeeBook.addEmployee(employee2);
        employeeBook.addEmployee(employee3);
        employeeBook.addEmployee(employee4);
        employeeBook.addEmployee(employee5);

        // вывод всякого на экран
        System.out.println("Сумма затрат на зарплаты в месяц: "+employeeBook.getMonthlyCost(employeeBook.getEmployees()));
        System.out.println("Сотрудник с минимальной зарплатой: "+employeeBook.getEmployeeWithMinimalSalary(employeeBook.getEmployees()));
        System.out.println("Сотрудник с максимальной зарплатой: "+employeeBook.getEmployeeWithMaximalSalary(employeeBook.getEmployees()));
        System.out.println("Среднее значение зарплат: "+ employeeBook.getAverageSalary(employeeBook.getEmployees()));
        System.out.println("Список всех сотрудников: ");employeeBook.printAllNames(employeeBook.getEmployees());
        // индексация зарплат
        employeeBook.indexAllSalaries(50,employeeBook.getEmployees());
        employeeBook.printAllNames(employeeBook.getEmployees());

        // выполняем всякое по номеру отдела
        String department = "2";
        System.out.println("Сумма затрат на зарплаты в месяц по отделу "+department+": "+employeeBook.getMonthlyCost(employeeBook.getEmployeesByDepartment(department)));
        System.out.println("Сотрудник с минимальной зарплатой по отделу "+department+": "+employeeBook.getEmployeeWithMinimalSalary(employeeBook.getEmployeesByDepartment(department)));
        System.out.println("Сотрудник с максимальной зарплатой по отделу "+department+": "+employeeBook.getEmployeeWithMaximalSalary(employeeBook.getEmployeesByDepartment(department)));
        System.out.println("Среднее значение зарплат по отделу "+department+": "+ employeeBook.getAverageSalary(employeeBook.getEmployeesByDepartment(department)));
        System.out.println("Список всех сотрудников по отделу "+department+": ");
        employeeBook.printAllNames(employeeBook.getEmployeesByDepartment(department));
        // индексация зарплат
        employeeBook.indexAllSalaries(50,employeeBook.getEmployeesByDepartment(department));

        //получаем сотрудников с зарплатной меньше указанной
        int salaryTopLimit = 5000;
        System.out.println("Список сотрудников с зарплатной меньше "+salaryTopLimit+" : ");
        employeeBook.printEmployeesWithSalaryLessThenValue(salaryTopLimit);

        int salaryBottomLimit = 8000;
        System.out.println("Список сотрудников с зарплатной больше или равной "+salaryBottomLimit+" : ");
        employeeBook.printEmployeesWithSalaryMoreThenValue(salaryBottomLimit);


        employeeBook.deleteEmployeeByName("Иванов","Олег","Сергеевич");
        //изменить зарплату
        employeeBook.getEmployeeByName("Булочкин","Андрей","Иванович")
                .setSalary(100000000);
        //изменить отдел
        employeeBook.getEmployeeByName("Булочкин","Андрей","Иванович")
                .setDepartment("2");

        // список сотрудников по отделам
        System.out.println("Список сотрудников, сгруппированных по отделам:");
        employeeBook.printListByDepartment();

    }
}
