package test;

public class TransferMoneyBean 
{
	
		  private String senderaccount,senderIfsc,senderBranch,receiveraccount,receiverIfsc,receiverBranch;
		  private double amount;
		  public TransferMoneyBean() {}
		public String getSenderaccount() 
		{
			return senderaccount;
		}
		public void setSenderaccount(String senderaccount) 
		{
			this.senderaccount = senderaccount;
		}
		public String getSenderIfsc() 
		{
			return senderIfsc;
		}
		public void setSenderIfsc(String senderIfsc)
		{
			this.senderIfsc = senderIfsc;
		}
		public String getSenderBranch()
		{
			return senderBranch;
		}
		public void setSenderBranch(String senderBranch) 
		{
			this.senderBranch = senderBranch;
		}
		public String getReceiveraccount() 
		{
			return receiveraccount;
		}
		public void setReceiveraccount(String receiveraccount) 
		{
			this.receiverBranch = receiverBranch;
		}
		public double getAmount() 
		{
			return amount;
		}
		public void setAmount(double amount) 
		{
			this.amount =amount;
		}
	}