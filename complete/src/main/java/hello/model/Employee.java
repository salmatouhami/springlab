package hello.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private long employeeId;
	private String email;
	private String firstName;
	private Date hireDate;
	private String lastName;
	private BigDecimal managerId;
	private String phoneNumber;
	private BigDecimal salary;
	private Department department;
	private Job job;
	private List<JobHistory> jobHistories;

	public Employee() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE")
	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	@Column(name="LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="MANAGER_ID")
	public BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}


	@Column(name="PHONE_NUMBER")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEPARTMENT_ID")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	//bi-directional many-to-one association to Job
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="JOB_ID")
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}


	//bi-directional many-to-one association to JobHistory
	@OneToMany(mappedBy="employee")
	public List<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

	public JobHistory addJobHistory(JobHistory jobHistory) {
		getJobHistories().add(jobHistory);
		jobHistory.setEmployee(this);

		return jobHistory;
	}

	public JobHistory removeJobHistory(JobHistory jobHistory) {
		getJobHistories().remove(jobHistory);
		jobHistory.setEmployee(null);

		return jobHistory;
	}

}