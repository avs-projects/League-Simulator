package data.budget;

import data.budget.permonth.EarningsPerMonth;

/**
 * This class provides League earnings divided by two sub categories.
 * Ticket sales and TV Right.
 */

public class Earnings {
	
	private TicketSales ticketSales;
	private TVRight tvRight;
	private EarningsPerMonth earningsPerMonth;
	
	public Earnings () {
		ticketSales = new TicketSales();
		tvRight = new TVRight();
		earningsPerMonth = new EarningsPerMonth();
	}
	
	public Earnings(TicketSales ticketSales, TVRight tvRight,
			EarningsPerMonth earningsPerMonth) {
		this.ticketSales = ticketSales;
		this.tvRight = tvRight;
		this.earningsPerMonth = earningsPerMonth;
	}

	public TicketSales getTicketSales() {
		return ticketSales;
	}

	public void setTicketSales(TicketSales ticketSales) {
		this.ticketSales = ticketSales;
	}

	public TVRight getTvRight() {
		return tvRight;
	}

	public void setTvRight(TVRight tvRight) {
		this.tvRight = tvRight;
	}

	public EarningsPerMonth getEarningsPerMonth() {
		return earningsPerMonth;
	}

	public void setEarningsPerMonth(EarningsPerMonth earningsPerMonth) {
		this.earningsPerMonth = earningsPerMonth;
	}

}
