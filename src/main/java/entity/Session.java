package entity;

public class Session {
	
	private String phonenumber;
	private String sid;
	private String AuthToken;
	private String message;
	
	
	public Session(String phonenumber, String sid, String AuthToken, String message) {
		
		this.AuthToken = AuthToken;
		this.phonenumber = phonenumber;
		this.sid = sid;
		this.message = message; 
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getAuthToken() {
		return AuthToken;
	}

	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
