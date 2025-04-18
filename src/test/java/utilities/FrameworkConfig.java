package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:${user.dir}/src/test/resources/Configuration/config.properties"})
public interface FrameworkConfig extends Config {
	
	String browser();
	
	String environment();
	
	
	@Key("${environment}.url")
	String uRL();
	
	@Key("${environment}.APILoginURL")
	String APILoginURL();
	
	@Key("${environment}.APIBaseURL")
	String APIBaseURL();

}
