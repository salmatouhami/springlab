package hello.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name="departments")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	private long departmentId;
	private String departmentName;
	private BigDecimal managerId;
	private Location location;
	private List<Employee> employees;
	private List<JobHistory> jobHistories;

	public Department() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID")
	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}


	@Column(name="DEPARTMENT_NAME")
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	@Column(name="MANAGER_ID")
	public BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}


	//bi-directional many-to-one association to Location
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOCATION_ID")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="department")
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}


	//bi-directional many-to-one association to JobHistory
	@OneToMany(mappedBy="department")
	public List<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

	public JobHistory addJobHistory(JobHistory jobHistory) {
		getJobHistories().add(jobHistory);
		jobHistory.setDepartment(this);

		return jobHistory;
	}

	public JobHistory removeJobHistory(JobHistory jobHistory) {
		getJobHistories().remove(jobHistory);
		jobHistory.setDepartment(null);

		return jobHistory;
	}

}