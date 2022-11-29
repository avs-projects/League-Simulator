package data.player;

import java.text.DecimalFormat;

/**
 * The Player class provides information about a Player. 
 */

public class Player implements Comparable<Player>{
	
	private Integer id;
	private String name;
	private Integer age;
	private Integer overallRating;
	private String position;
	private PlayerStatistics playerStatistics;
	private Integer salary;
	private Integer gamesPlayed;
	
	public Player() {
		
	}
	
	public Player(Integer id, String name, Integer age, Integer overallRating, String position,
			PlayerStatistics playerStatistics,Integer salary, Integer gamesPlayed) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.overallRating = overallRating;
		this.position = position;
		this.playerStatistics = playerStatistics;
		this.salary = salary;
		this.gamesPlayed = gamesPlayed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public PlayerStatistics getPlayerStatistics() {
		return playerStatistics;
	}

	public void setPlayerStatistics(PlayerStatistics playerStatistics) {
		this.playerStatistics = playerStatistics;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	public int compareTo(Player emp) {

        return (this.overallRating - emp.overallRating);
	}
	
	public String WriteDouble(double percentage) {
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format(percentage);
		
	}
}
