package data.budget;

/**
 * The TVRight class is divided by 5 sub categories.
 */

public class TVRight {
	
	private Integer tvRight;
	private Integer viewers;
	private long equalShare;
	private long facilityFees;
	private long meritPayment;
	
	public TVRight() {
		tvRight = 0;
		viewers = 0;
		equalShare = 0;
		facilityFees = 0;
		meritPayment = 0;
	}
	
	public TVRight(Integer tvRight, Integer viewers, long equalShare, long facilityFees, long meritPayment) {
		this.tvRight = tvRight;
		this.viewers = viewers;
		this.equalShare = equalShare;
		this.facilityFees = facilityFees;
		this.meritPayment = meritPayment;
	}

	public Integer getTvRight() {
		return tvRight;
	}

	public void setTvRight(Integer tvRight) {
		this.tvRight = tvRight;
	}

	public Integer getViewers() {
		return viewers;
	}

	public void setViewers(Integer viewers) {
		this.viewers = viewers;
	}

	public long getEqualShare() {
		return equalShare;
	}

	public void setEqualShare(long equalShare) {
		this.equalShare = equalShare;
	}

	public long getFacilityFees() {
		return facilityFees;
	}

	public void setFacilityFees(long facilityFees) {
		this.facilityFees = facilityFees;
	}

	public long getMeritPayment() {
		return meritPayment;
	}

	public void setMeritPayment(long meritPayment) {
		this.meritPayment = meritPayment;
	}

}
