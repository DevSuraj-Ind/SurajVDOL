package pojos;

public class AddPayload {
	private String deviceSerialNo;
	private int deviceType;
	private String publicKey = "-----BEGIN PUBLIC KEY-----\r\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEtwADUKo8jGz48q+hfqXwugWkoGNd\r\nbkOpD3TGW5tqRIyo6XAPetbOQ/b/cf/96AGehX+2QWsItukdmWsaDno7Mg==\r\n-----END PUBLIC KEY-----";
	private String publicKeyType;

	public String getDeviceSerialNo() {
		return deviceSerialNo;
	}

	public void setDeviceSerialNo(String deviceSerialNo) {
		this.deviceSerialNo = deviceSerialNo;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPublicKeyType() {
		return publicKeyType;
	}

	public void setPublicKeyType(String publicKeyType) {
		this.publicKeyType = publicKeyType;
	}

}
