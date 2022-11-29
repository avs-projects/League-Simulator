package data.basketteam;

public class TeamCoach {
	
	private Integer salary;
	private Integer stat;
	
	public TeamCoach() {
		salary = 0;
		stat = 0;
	}
	
	public TeamCoach (Integer salary, Integer stat) {
		this.salary = salary;
		this.stat = stat;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

}
