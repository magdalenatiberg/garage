package service.common.response;

public enum Status {
	OK("OK");
	
	private String status;
	private Status(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
