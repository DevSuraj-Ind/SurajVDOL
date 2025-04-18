package pojos;

public class AddResponse {
	
	private String deviceSerialNo;
	private int deviceType;
	private int registrationDate;
	private String publicKey;
	private String errorCode;
	private String errorMessage;
	private String publicKeyType;
	
	
	public String getDeviceSerialNo() {
		return deviceSerialNo;
	}
	public void setDeviceSerialNo(String deviceSerialNo) {
		this.deviceSerialNo = deviceSerialNo;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Integer registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getPublicKeyType() {
		return publicKeyType;
	}
	public void setPublicKeyType(String publicKeyType) {
		this.publicKeyType = publicKeyType;
	}
	
	

}
