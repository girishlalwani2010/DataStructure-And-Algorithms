package tree;

import java.util.ArrayList;
import java.util.List;

public class Employee {
		 
        private final int id;
        private final String name;
        private final List<Employee> reports;
 
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<Employee>();
        }
 
        /**
     * @return an integer ID for this employee, guaranteed to be unique.
     */
        public int getId() {
            return id;
        }
 
        /**
     * @return a String name for this employee, NOT guaranteed to be unique.
     */
        public String getName() {
            return name;
        }
 
        /**
     * @return a List of employees which report to this employee.  This list may be empty, but will
     *      never be null.
     */
        public List<Employee> getReports() {
            return reports;
        }
 
        /**
     * Adds the provided employee as a report of this employee. 
     */
    public void addReport(Employee employee) {
        reports.add(employee);
    }
}