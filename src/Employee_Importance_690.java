import java.util.*;

public class Employee_Importance_690 {
    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        return getEmployeeImportance(employeeMap, id);
    }

    private int getEmployeeImportance(Map<Integer, Employee> employeeMap, int id) {
        Employee employee = employeeMap.get(id);
        int total = employee.importance;

        if (employee.subordinates != null) {
            for (Integer sub : employee.subordinates) {
                total += getEmployeeImportance(employeeMap, sub);
            }
        }
        return total;
    }

    public int getImportance1(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        Queue<Employee> employeeQueue = new LinkedList<>();
        employeeQueue.offer(employeeMap.get(id));

        int total = 0;

        while(!employeeQueue.isEmpty()) {
            Employee employee = employeeQueue.poll();
            total += employee.importance;
            if (employee.subordinates != null) {
                for (Integer sub : employee.subordinates) {
                    employeeQueue.offer(employeeMap.get(sub));
                }
            }
        }
        return total;
    }

}
