package passkitSDKv3;

import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

/*
class DynamicData {
	public HashMap<String, Object> dynamicDataContent = null;
}

class PassImages {
	public String background = null;
	public String footer = null;
	public String icon = null;
	public String logo = null;
	public String strip = null;
	public String thumbnail = null;
}

class DynamicImages {
	public PassImages passbook = null;
}
}

class DynamicBackfields {
	public String label = null;
	public String value = null;
}

class PassPassbook {
	public String groupId = null;
	public String bgColor = null;
	public String labelColor = null;
	public String fgColor = null;
}*/

public class Pass {
	public String id = null;
	public String templateName = null;
	public String campaignName = null;
	public String userDefinedId = null;
	public String recoveryEmail = null;
	public String expiryDate = null;
	public String updatedAt = null;
	public String createdAt = null;
	public String firstUnregisteredAt = null;
	public String lastUnregisteredAt = null;
	public String firstRegisteredAt = null;
	public String lastRegisteredAt = null;
	public String lastRedeemAt = null;
	public Boolean isVoided = null;
	public Boolean isRedeemed = null;
	public Boolean isInvalid = null;
	public Integer passbookDevices = null;
	public Integer androidPayDevices = null;

	public HashMap <String, Object> dynamicData = null;
	public DynamicImages dynamicImages = null;
	public HashMap <String, DynamicBackfields[]> dynamicBackfields = null;
	public PassPassbook passbook = null;

	public Pass () {

	}

	public Pass (JSONObject inputJSONObject) {
		int counter;
		try { this.id = inputJSONObject.getString("id"); } catch (Exception e) {}
		try { this.templateName = inputJSONObject.getString("templateName"); } catch (Exception e) {}
		try { this.campaignName = inputJSONObject.getString("campaignName"); } catch (Exception e) {}
		try { this.userDefinedId = inputJSONObject.getString("userDefinedId"); } catch (Exception e) {}
		try { this.recoveryEmail = inputJSONObject.getString("recoveryEmail"); } catch (Exception e) {}
		try { this.expiryDate = inputJSONObject.getString("expiryDate"); } catch (Exception e) {}
		try { this.updatedAt = inputJSONObject.getString("updatedAt"); } catch (Exception e) {}
		try { this.createdAt = inputJSONObject.getString("createdAt"); } catch (Exception e) {}
		try { this.firstUnregisteredAt = inputJSONObject.getString("firstUnregisteredAt"); } catch (Exception e) {}
		try { this.lastUnregisteredAt = inputJSONObject.getString("lastUnregisteredAt"); } catch (Exception e) {}
		try { this.firstRegisteredAt = inputJSONObject.getString("firstRegisteredAt"); } catch (Exception e) {}
		try { this.lastRegisteredAt = inputJSONObject.getString("lastRegisteredAt"); } catch (Exception e) {}
		try { this.lastRedeemAt = inputJSONObject.getString("lastRedeemAt"); } catch (Exception e) {}
		try { this.isVoided = inputJSONObject.getBoolean("isVoided"); } catch (Exception e) {}
		try { this.isRedeemed = inputJSONObject.getBoolean("isRedeemed"); } catch (Exception e) {}
		try { this.isInvalid = inputJSONObject.getBoolean("isInvalid"); } catch (Exception e) {}
		try { this.passbookDevices = inputJSONObject.getInt("passbookDevices"); } catch (Exception e) {}
		try { this.androidPayDevices = inputJSONObject.getInt("androidPayDevices"); } catch (Exception e) {}
		this.dynamicData = new HashMap <String,Object>();
		try {
			JSONObject tempJSONObject = inputJSONObject.getJSONObject("dynamicData");
			JSONArray dyanmicDataKeys = tempJSONObject.names();
			counter = dyanmicDataKeys.length();
			for (int i = 0; i < counter; i++) {
				this.dynamicData.put(dyanmicDataKeys.getString(i),tempJSONObject.get(dyanmicDataKeys.getString(i)));
			}
		} catch (Exception e) {}
		this.dynamicImages = new DynamicImages();
		this.dynamicImages.passbook = new PassImages();
		try { this.dynamicImages.passbook.background = inputJSONObject.getJSONObject("dynamicImages").getJSONObject("passbook").getString("background"); } catch (Exception e) {}
		try { this.dynamicImages.passbook.footer = inputJSONObject.getJSONObject("dynamicImages").getJSONObject("passbook").getString("footer"); } catch (Exception e) {}
		try { this.dynamicImages.passbook.icon = inputJSONObject.getJSONObject("dynamicImages").getJSONObject("passbook").getString("icon"); } catch (Exception e) {}
		try { this.dynamicImages.passbook.logo = inputJSONObject.getJSONObject("dynamicImages").getJSONObject("passbook").getString("logo"); } catch (Exception e) {}
		try { this.dynamicImages.passbook.strip = inputJSONObject.getJSONObject("dynamicImages").getJSONObject("passbook").getString("strip"); } catch (Exception e) {}
		try { this.dynamicImages.passbook.thumbnail = inputJSONObject.getJSONObject("dynamicImages").getJSONObject("passbook").getString("thumbnail"); } catch (Exception e) {}
		this.passbook = new PassPassbook();
		try { this.passbook.groupId = inputJSONObject.getJSONObject("passbook").getString("groupId"); } catch (Exception e) {}
		try { this.passbook.bgColor = inputJSONObject.getJSONObject("passbook").getString("bgColor"); } catch (Exception e) {}
		try { this.passbook.labelColor = inputJSONObject.getJSONObject("passbook").getString("labelColor"); } catch (Exception e) {}
		try { this.passbook.fgColor = inputJSONObject.getJSONObject("passbook").getString("fgColor"); } catch (Exception e) {}
		this.dynamicBackfields = new HashMap <String,DynamicBackfields[]>();
		try {
			JSONObject tempJSONObject = inputJSONObject.getJSONObject("dynamicBackfields");
			JSONArray dynamicBackfieldsKeys = tempJSONObject.names();
			counter = dynamicBackfieldsKeys.length();
			JSONArray array = null;
			DynamicBackfields[] tempDynamicBackfields = null;
			for (int i = 0; i < counter; i++) {
				array = tempJSONObject.getJSONArray(dynamicBackfieldsKeys.getString(i));
				tempDynamicBackfields = new DynamicBackfields[array.length()];
				DynamicBackfields tempDynamicBackfieldsData = null;
				for (int j = 0; j < array.length(); j++) {
					JSONObject temp = array.getJSONObject(j);
					tempDynamicBackfieldsData = new DynamicBackfields();
					try { tempDynamicBackfieldsData.label = temp.getString("label"); } catch (Exception e) {}
					try { tempDynamicBackfieldsData.value = temp.getString("value"); } catch (Exception e) {}
					tempDynamicBackfields[j] = tempDynamicBackfieldsData;
				}
				this.dynamicBackfields.put(dynamicBackfieldsKeys.getString(i),tempDynamicBackfields);
			}
		} catch (Exception e) {}
	}
}