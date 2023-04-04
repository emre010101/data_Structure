package carRecords;
/*
 * @Emre Kavak
 * 09/02/2023
 * */

public class CarDetails {
	//Declare Variables
	String registration, owner, problem, number;
	Double fee;
	Boolean status;

	
	public CarDetails(String registration, String owner, String problem, Double fee, String number, Boolean status) {
		//super();
		this.registration = registration;
		this.owner = owner;
		this.problem = problem;
		this.fee = fee;
		this.number = number;
		this.status = status;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CarDetails [registration=" + registration + ", owner=" + owner + ", problem=" + problem + ", fee=" + fee
				+ ", number=" + number + ", status=" + status + "]";
	}
	
}
