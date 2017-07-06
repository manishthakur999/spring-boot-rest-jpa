package com.talent.exchange.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tex_investor")
public class MoUserInvestorVideoAssociation extends MoBase {

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private MoUser userInvestor;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private MoEventContent video;
	
	@Column(name = "funds_Invested")
	private double fundsInvested;
	
	public MoUser getUserInvestor() {
		return userInvestor;
	}
	public void setUserInvestor(MoUser userInvestor) {
		this.userInvestor = userInvestor;
	}
	public MoEventContent getVideo() {
		return video;
	}
	public void setVideo(MoEventContent video) {
		this.video = video;
	}
	public double getInvestmentFunds() {
		return fundsInvested;
	}
	public void setInvestmentFunds(double fundsInvested) {
		this.fundsInvested = fundsInvested;
	}
}
