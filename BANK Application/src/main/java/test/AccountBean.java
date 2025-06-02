package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AccountBean implements Serializable
{
	private String accno,ifsc,branch;
	private Double amount;
	public AccountBean() {}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount=amount;
	}	
}