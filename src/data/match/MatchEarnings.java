package data.match;

public class MatchEarnings {
	
	private Integer ticketSelling;
	private Integer ticketEarnings;
	private Integer viewers;
	
	public MatchEarnings () {
		ticketSelling=0;
		ticketEarnings=0;
		viewers = 0;
	}
	
	public MatchEarnings(Integer ticketSelling, Integer ticketEarnings, Integer viewers) {
		this.ticketSelling = ticketSelling;
		this.ticketEarnings = ticketEarnings;
		this.viewers = viewers;
	}

	public Integer getTicketSelling() {
		return ticketSelling;
	}

	public void setTicketSelling(Integer ticketSelling) {
		this.ticketSelling = ticketSelling;
	}

	public Integer getTicketEarnings() {
		return ticketEarnings;
	}

	public void setTicketEarnings(Integer ticketEarnings) {
		this.ticketEarnings = ticketEarnings;
	}

	public Integer getViewers() {
		return viewers;
	}

	public void setViewers(Integer viewers) {
		this.viewers = viewers;
	}

}
