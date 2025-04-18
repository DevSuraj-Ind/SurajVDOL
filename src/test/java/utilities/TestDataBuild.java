package utilities;

import pojos.AddPayload;
import pojos.AuthPayloadPojo;

public class TestDataBuild extends Utils {
	
	public AuthPayloadPojo authPayload= new AuthPayloadPojo();
	public AddPayload addPayload = new AddPayload();
	
	public void authPayloadbuild(String account, String username, String password) {
		authPayload.setAccount(account);
	    authPayload.setUsername(username);
	    authPayload.setpassword(password);
	}
	
	public void addPayloadDataSetup(int devicetype, String publicKeyType, String publicKey) {
		addPayload.setDeviceSerialNo(getRandomDeviceSRno());
		addPayload.setDeviceType(devicetype);
		//addPayload.setPublicKey(publicKey);
		addPayload.setPublicKeyType(publicKeyType);
	}
}




