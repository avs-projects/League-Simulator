package data.basketteam;

/**
 * The TeamStadium class provide information about the team stadium.
 * The stadium has a seating capacity with a fixed price.
 */

public class TeamStadium {
	
	private Integer id;
	private String name;
	private Integer capacity;
	private Integer seatPrice;
	
	public TeamStadium() {
		
	}

	public TeamStadium (Integer id, String name,Integer capacity, Integer seatPrice) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.seatPrice = seatPrice;
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(Integer seatPrice) {
		this.seatPrice = seatPrice;
	}	
}

