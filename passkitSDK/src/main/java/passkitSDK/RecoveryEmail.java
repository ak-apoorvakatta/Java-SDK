package passkitSDK;

import org.json.JSONObject;

public class RecoveryEmail {
	public String passId = null;
	public String newRecoveryEmail = null;
	public Boolean success = null;
	public String error = null;


	public RecoveryEmail () {

	}

	public RecoveryEmail (JSONObject inputJSONObject) {
		try { this.passId = inputJSONObject.getString("passId"); } catch (Exception e) {}
		try { this.newRecoveryEmail = inputJSONObject.getString("recoveryEmail"); } catch (Exception e) {}
		try { this.success = inputJSONObject.getBoolean("success"); } catch (Exception e) {}
		try { this.error = inputJSONObject.getString("error"); } catch (Exception e) {}
	}
}