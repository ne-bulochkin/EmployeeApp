package pro.sky;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EmployeeBook {
    private static final int DEFAULT_ENTITIES = 3;

    private Employee[] employees = new Employee[DEFAULT_ENTITIES];

    public void addEmployee(Employee employee){
        for(int i = 0; i < employees.length; i++){
            // проверяем не был ли ранее такой сотрудник добавлен
            for(Employee new_employee : employees){
                if(employee.equals(new_employee)){
                    throw new IllegalArgumentException("Такой сотрудник уже зарегестрирован в системе!");
                }
            }

            //теперь ищем пусток
            if(employees[i] == null){
                employees[i] = employee;
                break;
            } else if (i==employees.length-1){
                // если добавляем сотрудника, но в массиве нема места, то создаем новый с увеличенным размером на +5
                Employee[] new_employees = new Employee[employees.length+5];
                for(int j = 0; j < employees.length; j++){
                    new_employees[j]=employees[j];
                }
                employees = new_employees;
                employees[i+1]=employee;
                break;
            }
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Employee[] getEmployeesByDepartment(String department) {
        Employee[] new_employees = new Employee[employees.length];
        for(int j = 0; j < employees.length; j++){
            if(employees[j]!=null){
                if(employees[j].getDepartment().equals(department)){
                    new_employees[j]=employees[j];
                } else {
                    new_employees[j]=null;
                }
            }
        }
        return new_employees;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for(Employee employee: employees){
            if(employee!=null){
                data.append(employee).append("\n");
            }
        }
        return data.toString();
    }

    public int getMonthlyCost(Employee[] employees){
        int sum = 0;
        for(Employee employee : employees){
            if(employee!=null){
                sum+=employee.getSalary();
            }
        }
        return sum;
    }
    public double getAverageSalary(Employee[] employees){
        int sum = 0;
        int count = 0;
        for(Employee employee : employees){
            if(employee!=null){
                count+=1;
                sum+=employee.getSalary();
            }
        }
        return (double) sum/count;
    }

    public Employee getEmployeeWithMinimalSalary(Employee[] employees){
        Employee employeeWithMinSalary = null;
        boolean isInit = false;
        for(Employee employee : employees){
            if(employee!=null){
                if(!isInit){
                    employeeWithMinSalary = employee;
                    isInit = true;
                } else {
                    if(employee.getSalary()<employeeWithMinSalary.getSalary()){
                        employeeWithMinSalary = employee;
                    }
                }
            }
        }
        return employeeWithMinSalary;
    }

    public Employee getEmployeeWithMaximalSalary(Employee[] employees){
        Employee employeeWithMaxSalary = null;
        boolean isInit = false;
        for(Employee employee : employees){
            if(employee!=null){
                if(!isInit){
                    employeeWithMaxSalary = employee;
                    isInit = true;
                } else {
                    if(employee.getSalary()>employeeWithMaxSalary.getSalary()){
                        employeeWithMaxSalary = employee;
                    }
                }
            }
        }
        return employeeWithMaxSalary;
    }

    public void printAllNames(Employee[] employees){
        for(Employee employee : employees){
            if (employee !=null) System.out.println(employee.toStringLastFirstMiddleNames());
        }
    }

    public void indexAllSalaries(int percent,Employee[] employees){
        for(Employee employee : employees){
            if (employee !=null) employee.setSalary(employee.getSalary()+employee.getSalary()*percent/100);
        }
    }

    public void printEmployeesWithSalaryLessThenValue(int value){
        for(Employee employee: employees){
            if(employee!=null){
                if (employee.getSalary()<value) System.out.println(employee.toString());
            }
        }
    }

    public void printEmployeesWithSalaryMoreThenValue(int value){
        for(Employee employee: employees){
            if(employee!=null){
                if (employee.getSalary()>=value) System.out.println(employee.toString());
            }
        }
    }


    public void deleteEmployeeById(int id){
        if(id < 0 || id > employees.length-1){
            throw new IllegalArgumentException("Не найден сотрудник с указанным id");
        } else {
            employees[id] = null;
        }
    }

    public void deleteEmployeeByName(String lastName,String firstName, String middleName){
        for(int i = 0; i< employees.length; i++){
            if(employees[i]!=null
                    && employees[i].getLastName().equals(lastName)
                    && employees[i].getMiddleName().equals(middleName)
                    && employees[i].getFirstName().equals(firstName)
            ){
                employees[i] = null;
            }
        }
    }

    public Employee getEmployeeByName(String lastName,String firstName, String middleName){
        for (Employee employee : employees) {
            if (employee != null
                    && employee.getLastName().equals(lastName)
                    && employee.getMiddleName().equals(middleName)
                    && employee.getFirstName().equals(firstName)
            ) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Сотрудник по указанным ФИО не найден!");
    }

    public void printListByDepartment(){
        //ищем департаменты которые вообще возможны
        Set<String> departments = new HashSet<>();
        for(Employee employee : employees){
            if(employee!=null){
                departments.add(employee.getDepartment());
            }
        }

        for(String department: departments){
            System.out.println(department+":");

            for(Employee employee : employees){
                if(employee!=null){
                    if (employee.getDepartment().equals(department)){
                        System.out.println(employee.toStringLastFirstMiddleNames());
                    }
                }
            }
        }
    }


}
