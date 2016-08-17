package passkitSDKv3;

import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

/*
class DynamicKeys {
	public String key = null;
	public String type = null;
	public Object defaultValue = null;
	public Boolean isEditable = null;
}

class PassbookImageController {
	public Boolean isDynamic = null;
	public Boolean isEditable = null;
}

class PassbookImages {
	public PassbookImageController background = null;
	public PassbookImageController footer = null;
	public PassbookImageController logo = null;
	public PassbookImageController strip = null;
	public PassbookImageController thumbnail = null;
}

class DynamicImageKeys {
	
	public PassbookImages passbookImages = null;
}

class Color {
	public Integer red = null;
	public Integer blue = null;
	public Integer green = null;
}

class PassbookTemplateFieldFormat {
	public String type = null;
	public String dateFormat = null;
	public String timeFormat = null;
	public Boolean ignoreTimeZone = null;
	public Boolean isRelative = null;
	public String currencyCode = null;
	public String numberFormat = null;
}

class PassbookTemplateField {
	public String itemName = null;
	public String defaultLabel = null;
	public Object defaultValue = null;
	public String attributedValue = null;
	public String changeMsg = null;
	public String textAlign = null;
	public PassbookTemplateFieldFormat format = null;
}

class PassbookTemplateBackFieldDefaultValueFormat {
	public String type = null;
	public String dateFormat = null;
	public String timeFormat = null;
	public Boolean ignoreTimeZone = null;
	public Boolean isRelative = null;
	public String currencyCode = null;
	public String numberFormat = null;
}

class PassbookTemplateBackFieldDefaultValue {
	public String itemName = null;
	public String defaultLabel = null;
	public Object defaultValue = null;
	public String attributedValue = null;
	public String changeMsg = null;
	public PassbookTemplateBackFieldDefaultValueFormat format = null;
}

class PassbookTemplateBackField {
	public String dynamicBackfieldKey;
	public PassbookTemplateBackFieldDefaultValue[] defaultValue = null;
	public Integer[] defaultValueArrayCounter = null;
}

class PassbookTemplateBeacon {
	public Integer major = null;
	public Integer minor = null;
	public String uuid = null;
	public String relevantText = null;
}

class PassbookTemplateLocation {
	public Integer alt = null;
	public Float lat = null;
	public Float lon = null;
	public String relevantText = null;
}

class PassbookTemplateBarcode {
	public String altText = null;
	public String altTextOption = null;
	public String format = null;
	public String message = null;
	public String messageOption = null;
	public String messageEncoding = null;
}

class PassbookTemplateNfc {
	public String message = null;
	public String encryptionPublicKey = null;
}

class Passbook {
	public String type = null;
	public String orgName = null;
	public String desc = null;
	public Integer[] assoStoreId = null;
	public String appLaunchUrl = null;
	public Color bgColor = null;
	public Color labelColor = null;
	public Color fgColor = null;
	public String logoText = null;
	public String transitType = null;
	public String iconFile = null;
	public String logoFile = null;
	public String stripFile = null;
	public String footerFile = null;
	public String thumbFile = null;
	public String bgFile = null;
	public PassbookTemplateField[] header = null;
	public PassbookTemplateField[] primary = null;
	public PassbookTemplateField[] auxiliary = null;
	public PassbookTemplateBackField[] back = null;
	public Integer[] backArrayCounter = null;
	public PassbookTemplateField[] secondary = null;
	public PassbookTemplateBeacon[] beacons = null;
	public PassbookTemplateLocation[] locations = null;
	public Integer maxDist = null;
	public String relevantDate = null;
	public PassbookTemplateBarcode barcode = null;
	public PassbookTemplateNfc nfc = null;
}

class PassbookLang {
	public String iconFile = null;
	public String logoFile = null;
	public String stripFile = null;
	public String footerFile = null;
	public String thumbFile = null;
	public String bgFile = null;
	public Map <String, String> text = null;
}
*/

public class Template {
	public String index = null;
	public String name = null;
	public String campaignName = null;
	public String status = null;
	public String language = null;
	public String startDate = null;
	public String endDate = null;
	public String createdAt = null;
	public String updatedAt = null;
	public Float timezone = null;
	public Integer maxIssue = null;
	public DynamicKeys[] dynamicKeys = null;
	public DynamicImageKeys dynamicImageKeys = null;
	public Passbook passbook = null;
	public Passbook passbookRedeem = null;
	public Map <String, PassbookLang> passbookLang = null;
	public Map <String, PassbookLang> passbookLangRedeem = null;
	public String[] languageList = {"ar", "ca", "zh-Hans", "zh-Hant", "hr", "cs", "da", "nl", "en", "en-GB", "fi", "fr", "de", "el", "he", "hu", "id", "it", "ja", "ko", "ms", "nb", "pl", "pt-BR", "pt", "ro", "ru", "sk", "es", "sv", "th", "tr", "uk", "vi"};
	public Integer issued = null;
	public Integer pushed = null;
	public Integer passbookDevices = null;
	public Integer androidPayDevices = null;
	public Integer alipayDevices = null;

	public Template () {

	}

	public Template (JSONObject inputJSONObject) {
		Integer arrayLength = null;

		try { this.index = inputJSONObject.getString("index"); } catch (Exception e) {}
		try { this.name = inputJSONObject.getString("name"); } catch (Exception e) {}
		try { this.campaignName = inputJSONObject.getString("campaignName"); } catch (Exception e) {}
		try { this.status = inputJSONObject.getString("status"); } catch (Exception e) {}
		try { this.language = inputJSONObject.getString("language"); } catch (Exception e) {}
		try { this.startDate = inputJSONObject.getString("startDate"); } catch (Exception e) {}
		try { this.endDate = inputJSONObject.getString("endDate"); } catch (Exception e) {}
		try { this.createdAt = inputJSONObject.getString("createdAt"); } catch (Exception e) {}
		try { this.updatedAt = inputJSONObject.getString("updatedAt"); } catch (Exception e) {}
		try { this.timezone = Float.valueOf(String.valueOf(inputJSONObject.get("timezone"))); } catch (Exception e) {}
		try { this.maxIssue = inputJSONObject.getInt("maxIssue"); } catch (Exception e) {}
		try { this.issued = inputJSONObject.getInt("issued"); } catch (Exception e) {}
		try { this.pushed = inputJSONObject.getInt("pushed"); } catch (Exception e) {}
		try { this.passbookDevices = inputJSONObject.getInt("passbookDevices"); } catch (Exception e) {}
		try { this.androidPayDevices = inputJSONObject.getInt("androidPayDevices"); } catch (Exception e) {}
		try { this.alipayDevices = inputJSONObject.getInt("alipayDevices"); } catch (Exception e) {}

		// dynamicKeys
		try {
			arrayLength = inputJSONObject.getJSONArray("dynamicKeys").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONArray("dynamicKeys").getJSONObject(i);
				DynamicKeys temp = new DynamicKeys();
				try { temp.key = tempJSONObject.getString("key"); } catch (Exception e) {}
				try { temp.type = tempJSONObject.getString("type"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.isEditable = tempJSONObject.getBoolean("isEditable"); } catch (Exception e) {}
				addDynamicKeys(temp);
			}
		} catch (Exception e) {  }

		// dynamicImageKeys
		this.dynamicImageKeys = new DynamicImageKeys();
		this.dynamicImageKeys.passbookImages = new PassbookImages();
		this.dynamicImageKeys.passbookImages.background = new PassbookImageController();
		try { dynamicImageKeys.passbookImages.background.isDynamic = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("background").getBoolean("isDynamic");} catch (Exception e) {}
		try { dynamicImageKeys.passbookImages.background.isEditable = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("background").getBoolean("isEditable");} catch (Exception e) {}
		this.dynamicImageKeys.passbookImages.footer = new PassbookImageController();
		try { dynamicImageKeys.passbookImages.footer.isDynamic = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("footer").getBoolean("isDynamic");} catch (Exception e) {}
		try { dynamicImageKeys.passbookImages.footer.isEditable = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("footer").getBoolean("isEditable");} catch (Exception e) {}
		this.dynamicImageKeys.passbookImages.logo = new PassbookImageController();
		try { dynamicImageKeys.passbookImages.logo.isDynamic = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("logo").getBoolean("isDynamic");} catch (Exception e) {}
		try { dynamicImageKeys.passbookImages.logo.isEditable = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("logo").getBoolean("isEditable");} catch (Exception e) {}
		this.dynamicImageKeys.passbookImages.strip = new PassbookImageController();
		try { dynamicImageKeys.passbookImages.strip.isDynamic = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("strip").getBoolean("isDynamic");} catch (Exception e) {}
		try { dynamicImageKeys.passbookImages.strip.isEditable = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("strip").getBoolean("isEditable");} catch (Exception e) {}
		this.dynamicImageKeys.passbookImages.thumbnail = new PassbookImageController();
		try { dynamicImageKeys.passbookImages.thumbnail.isDynamic = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("thumbnail").getBoolean("isDynamic");} catch (Exception e) {}
		try { dynamicImageKeys.passbookImages.thumbnail.isEditable = inputJSONObject.getJSONObject("dynamicImageKeys").getJSONObject("passbook").getJSONObject("thumbnail").getBoolean("isEditable");} catch (Exception e) {}

		// passbook
		this.passbook = new Passbook();
		try { this.passbook.type = inputJSONObject.getJSONObject("passbook").getString("type"); } catch (Exception e) {}
		try { this.passbook.orgName = inputJSONObject.getJSONObject("passbook").getString("orgName"); } catch (Exception e) {}
		try { this.passbook.desc = inputJSONObject.getJSONObject("passbook").getString("desc"); } catch (Exception e) {}
		try { this.passbook.appLaunchUrl = inputJSONObject.getJSONObject("passbook").getString("appLaunchUrl"); } catch (Exception e) {}
		try { this.passbook.logoText = inputJSONObject.getJSONObject("passbook").getString("logoText"); } catch (Exception e) {}
		try { this.passbook.transitType = inputJSONObject.getJSONObject("passbook").getString("transitType"); } catch (Exception e) {}
		try { this.passbook.iconFile = inputJSONObject.getJSONObject("passbook").getString("iconFile"); } catch (Exception e) {}
		try { this.passbook.logoFile = inputJSONObject.getJSONObject("passbook").getString("logoFile"); } catch (Exception e) {}
		try { this.passbook.stripFile = inputJSONObject.getJSONObject("passbook").getString("stripFile"); } catch (Exception e) {}
		try { this.passbook.footerFile = inputJSONObject.getJSONObject("passbook").getString("footerFile"); } catch (Exception e) {}
		try { this.passbook.thumbFile = inputJSONObject.getJSONObject("passbook").getString("thumbFile"); } catch (Exception e) {}
		try { this.passbook.bgFile = inputJSONObject.getJSONObject("passbook").getString("bgFile"); } catch (Exception e) {}
		try { this.passbook.relevantDate = inputJSONObject.getJSONObject("passbook").getString("relevantDate"); } catch (Exception e) {}
		try { this.passbook.maxDist = inputJSONObject.getJSONObject("passbook").getInt("maxDist"); } catch (Exception e) {}
		this.passbook.bgColor = new Color();
		try { this.passbook.bgColor.red = inputJSONObject.getJSONObject("passbook").getJSONObject("bgColor").getInt("red"); } catch (Exception e) {}
		try { this.passbook.bgColor.green = inputJSONObject.getJSONObject("passbook").getJSONObject("bgColor").getInt("green"); } catch (Exception e) {}
		try { this.passbook.bgColor.blue = inputJSONObject.getJSONObject("passbook").getJSONObject("bgColor").getInt("blue"); } catch (Exception e) {}
		this.passbook.labelColor = new Color();
		try { this.passbook.labelColor.red = inputJSONObject.getJSONObject("passbook").getJSONObject("labelColor").getInt("red"); } catch (Exception e) {}
		try { this.passbook.labelColor.green = inputJSONObject.getJSONObject("passbook").getJSONObject("labelColor").getInt("green"); } catch (Exception e) {}
		try { this.passbook.labelColor.blue = inputJSONObject.getJSONObject("passbook").getJSONObject("labelColor").getInt("blue"); } catch (Exception e) {}
		this.passbook.fgColor = new Color();
		try { this.passbook.fgColor.red = inputJSONObject.getJSONObject("passbook").getJSONObject("fgColor").getInt("red"); } catch (Exception e) {}
		try { this.passbook.fgColor.green = inputJSONObject.getJSONObject("passbook").getJSONObject("fgColor").getInt("green"); } catch (Exception e) {}
		try { this.passbook.fgColor.blue = inputJSONObject.getJSONObject("passbook").getJSONObject("fgColor").getInt("blue"); } catch (Exception e) {}
		this.passbook.barcode = new PassbookTemplateBarcode();
		try { this.passbook.barcode.altText = inputJSONObject.getJSONObject("passbook").getJSONObject("barcode").getString("altText"); } catch (Exception e) {}
		try { this.passbook.barcode.altTextOption = inputJSONObject.getJSONObject("passbook").getJSONObject("barcode").getString("altTextOption"); } catch (Exception e) {}
		try { this.passbook.barcode.format = inputJSONObject.getJSONObject("passbook").getJSONObject("barcode").getString("format"); } catch (Exception e) {}
		try { this.passbook.barcode.message = inputJSONObject.getJSONObject("passbook").getJSONObject("barcode").getString("message"); } catch (Exception e) {}
		try { this.passbook.barcode.messageOption = inputJSONObject.getJSONObject("passbook").getJSONObject("barcode").getString("messageOption"); } catch (Exception e) {}
		try { this.passbook.barcode.messageEncoding = inputJSONObject.getJSONObject("passbook").getJSONObject("barcode").getString("messageEncoding"); } catch (Exception e) {}
		this.passbook.nfc = new PassbookTemplateNfc();
		try { this.passbook.nfc.message = inputJSONObject.getJSONObject("passbook").getJSONObject("nfc").getString("message"); } catch (Exception e) {}
		try { this.passbook.nfc.encryptionPublicKey = inputJSONObject.getJSONObject("passbook").getJSONObject("nfc").getString("encryptionPublicKey"); } catch (Exception e) {}

		try {
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("assoStoreId").length();
			JSONArray tempArray = inputJSONObject.getJSONObject("passbook").getJSONArray("assoStoreId");
			for (int i = 0; i<arrayLength; i++) {
				Integer temp = tempArray.getInt(i);
				addPassbookAssoStoreId(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("header").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbook").getJSONArray("header").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookTemplateFieldHeader(temp);
			}
		} catch (Exception e) {  }

		try {
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("primary").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbook").getJSONArray("primary").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookTemplateFieldPrimary(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("auxiliary").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbook").getJSONArray("auxiliary").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookTemplateFieldAuxiliary(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("secondary").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbook").getJSONArray("secondary").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookTemplateFieldSecondary(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("back").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbook").getJSONArray("back").getJSONObject(i);
				PassbookTemplateBackField temp = new PassbookTemplateBackField();
				try { temp.dynamicBackfieldKey = tempJSONObject.getString("dynamicBackfieldKey"); } catch (Exception e) {}
				int tempDefaultValueLength = (Integer) tempJSONObject.getJSONArray("defaultValue").length();
				PassbookTemplateBackFieldDefaultValue[] tempDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[tempDefaultValueLength];
				for (int j = 0; j<tempDefaultValueLength; j++) {
					JSONObject tempDefaultValue = tempJSONObject.getJSONArray("defaultValue").getJSONObject(j);
					PassbookTemplateBackFieldDefaultValue defaultValue = new PassbookTemplateBackFieldDefaultValue();
					try { defaultValue.itemName = tempDefaultValue.getString("itemName"); } catch (Exception e) {}
					try { defaultValue.defaultLabel = tempDefaultValue.getString("defaultLabel"); } catch (Exception e) {}
					try { defaultValue.defaultValue = tempDefaultValue.get("defaultValue"); } catch (Exception e) {}
					try { defaultValue.attributedValue = tempDefaultValue.getString("attributedValue"); } catch (Exception e) {}
					try { defaultValue.changeMsg = tempDefaultValue.getString("changeMsg"); } catch (Exception e) {}
					defaultValue.format = new PassbookTemplateBackFieldDefaultValueFormat();
					try { defaultValue.format.type = tempDefaultValue.getJSONObject("format").getString("type"); } catch (Exception e) {}
					try { defaultValue.format.dateFormat = tempDefaultValue.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
					try { defaultValue.format.timeFormat = tempDefaultValue.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
					try { defaultValue.format.ignoreTimeZone = tempDefaultValue.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
					try { defaultValue.format.isRelative = tempDefaultValue.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
					try { defaultValue.format.currencyCode = tempDefaultValue.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
					try { defaultValue.format.numberFormat = tempDefaultValue.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
					tempDefaultValueArray[j] = defaultValue;
				}
				addPassbookTemplateFieldBack(temp, tempDefaultValueArray);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("beacons").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbook").getJSONArray("beacons").getJSONObject(i);
				PassbookTemplateBeacon temp = new PassbookTemplateBeacon();
				try { temp.major = tempJSONObject.getInt("major"); } catch (Exception e) {}
				try { temp.minor = tempJSONObject.getInt("minor"); } catch (Exception e) {}
				try { temp.uuid = tempJSONObject.getString("uuid"); } catch (Exception e) {}
				try { temp.relevantText = tempJSONObject.getString("relevantText"); } catch (Exception e) {}
				addPassbookTemplateBeacon(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbook").getJSONArray("locations").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbook").getJSONArray("locations").getJSONObject(i);
				PassbookTemplateLocation temp = new PassbookTemplateLocation();
				try { temp.alt = tempJSONObject.getInt("alt"); } catch (Exception e) {}
				try { temp.lat = Float.valueOf(String.valueOf(tempJSONObject.getString("lat"))); } catch (Exception e) {}
				try { temp.lon = Float.valueOf(String.valueOf(tempJSONObject.getString("lon"))); } catch (Exception e) {}
				try { temp.relevantText = tempJSONObject.getString("relevantText"); } catch (Exception e) {}
				addPassbookTemplateLocation(temp);
			}
		} catch (Exception e) {  }

		// passbookRedeem
		this.passbookRedeem = new Passbook();
		try { this.passbookRedeem.type = inputJSONObject.getJSONObject("passbookRedeem").getString("type"); } catch (Exception e) {}
		try { this.passbookRedeem.orgName = inputJSONObject.getJSONObject("passbookRedeem").getString("orgName"); } catch (Exception e) {}
		try { this.passbookRedeem.desc = inputJSONObject.getJSONObject("passbookRedeem").getString("desc"); } catch (Exception e) {}
		try { this.passbookRedeem.appLaunchUrl = inputJSONObject.getJSONObject("passbookRedeem").getString("appLaunchUrl"); } catch (Exception e) {}
		try { this.passbookRedeem.logoText = inputJSONObject.getJSONObject("passbookRedeem").getString("logoText"); } catch (Exception e) {}
		try { this.passbookRedeem.transitType = inputJSONObject.getJSONObject("passbookRedeem").getString("transitType"); } catch (Exception e) {}
		try { this.passbookRedeem.iconFile = inputJSONObject.getJSONObject("passbookRedeem").getString("iconFile"); } catch (Exception e) {}
		try { this.passbookRedeem.logoFile = inputJSONObject.getJSONObject("passbookRedeem").getString("logoFile"); } catch (Exception e) {}
		try { this.passbookRedeem.stripFile = inputJSONObject.getJSONObject("passbookRedeem").getString("stripFile"); } catch (Exception e) {}
		try { this.passbookRedeem.footerFile = inputJSONObject.getJSONObject("passbookRedeem").getString("footerFile"); } catch (Exception e) {}
		try { this.passbookRedeem.thumbFile = inputJSONObject.getJSONObject("passbookRedeem").getString("thumbFile"); } catch (Exception e) {}
		try { this.passbookRedeem.bgFile = inputJSONObject.getJSONObject("passbookRedeem").getString("bgFile"); } catch (Exception e) {}
		try { this.passbookRedeem.relevantDate = inputJSONObject.getJSONObject("passbookRedeem").getString("relevantDate"); } catch (Exception e) {}
		try { this.passbookRedeem.maxDist = inputJSONObject.getJSONObject("passbookRedeem").getInt("maxDist"); } catch (Exception e) {}
		this.passbookRedeem.bgColor = new Color();
		try { this.passbookRedeem.bgColor.red = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("bgColor").getInt("red"); } catch (Exception e) {}
		try { this.passbookRedeem.bgColor.green = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("bgColor").getInt("green"); } catch (Exception e) {}
		try { this.passbookRedeem.bgColor.blue = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("bgColor").getInt("blue"); } catch (Exception e) {}
		this.passbookRedeem.labelColor = new Color();
		try { this.passbookRedeem.labelColor.red = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("labelColor").getInt("red"); } catch (Exception e) {}
		try { this.passbookRedeem.labelColor.green = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("labelColor").getInt("green"); } catch (Exception e) {}
		try { this.passbookRedeem.labelColor.blue = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("labelColor").getInt("blue"); } catch (Exception e) {}
		this.passbookRedeem.fgColor = new Color();
		try { this.passbookRedeem.fgColor.red = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("fgColor").getInt("red"); } catch (Exception e) {}
		try { this.passbookRedeem.fgColor.green = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("fgColor").getInt("green"); } catch (Exception e) {}
		try { this.passbookRedeem.fgColor.blue = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("fgColor").getInt("blue"); } catch (Exception e) {}
		this.passbookRedeem.barcode = new PassbookTemplateBarcode();
		try { this.passbookRedeem.barcode.altText = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("barcode").getString("altText"); } catch (Exception e) {}
		try { this.passbookRedeem.barcode.altTextOption = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("barcode").getString("altTextOption"); } catch (Exception e) {}
		try { this.passbookRedeem.barcode.format = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("barcode").getString("format"); } catch (Exception e) {}
		try { this.passbookRedeem.barcode.message = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("barcode").getString("message"); } catch (Exception e) {}
		try { this.passbookRedeem.barcode.messageOption = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("barcode").getString("messageOption"); } catch (Exception e) {}
		try { this.passbookRedeem.barcode.messageEncoding = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("barcode").getString("messageEncoding"); } catch (Exception e) {}
		this.passbookRedeem.nfc = new PassbookTemplateNfc();
		try { this.passbookRedeem.nfc.message = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("nfc").getString("message"); } catch (Exception e) {}
		try { this.passbookRedeem.nfc.encryptionPublicKey = inputJSONObject.getJSONObject("passbookRedeem").getJSONObject("nfc").getString("encryptionPublicKey"); } catch (Exception e) {}

		try {
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("assoStoreId").length();
			JSONArray tempArray = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("assoStoreId");
			for (int i = 0; i<arrayLength; i++) {
				Integer temp = tempArray.getInt(i);
				addPassbookRedeemAssoStoreId(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("header").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("header").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookRedeemTemplateFieldHeader(temp);
			}
		} catch (Exception e) {  }

		try {
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("primary").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("primary").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookRedeemTemplateFieldPrimary(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("auxiliary").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("auxiliary").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookRedeemTemplateFieldAuxiliary(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("secondary").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("secondary").getJSONObject(i);
				PassbookTemplateField temp = new PassbookTemplateField();
				try { temp.itemName = tempJSONObject.getString("itemName"); } catch (Exception e) {}
				try { temp.defaultLabel = tempJSONObject.getString("defaultLabel"); } catch (Exception e) {}
				try { temp.defaultValue = tempJSONObject.get("defaultValue"); } catch (Exception e) {}
				try { temp.attributedValue = tempJSONObject.getString("attributedValue"); } catch (Exception e) {}
				try { temp.changeMsg = tempJSONObject.getString("changeMsg"); } catch (Exception e) {}
				try { temp.textAlign = tempJSONObject.getString("textAlign"); } catch (Exception e) {}
				temp.format = new PassbookTemplateFieldFormat();
				try { temp.format.type = tempJSONObject.getJSONObject("format").getString("type"); } catch (Exception e) {}
				try { temp.format.dateFormat = tempJSONObject.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
				try { temp.format.timeFormat = tempJSONObject.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
				try { temp.format.ignoreTimeZone = tempJSONObject.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
				try { temp.format.isRelative = tempJSONObject.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
				try { temp.format.currencyCode = tempJSONObject.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
				try { temp.format.numberFormat = tempJSONObject.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
				addPassbookRedeemTemplateFieldSecondary(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("back").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("back").getJSONObject(i);
				PassbookTemplateBackField temp = new PassbookTemplateBackField();
				try { temp.dynamicBackfieldKey = tempJSONObject.getString("dynamicBackfieldKey"); } catch (Exception e) {}
				int tempDefaultValueLength = (Integer) tempJSONObject.getJSONArray("defaultValue").length();
				PassbookTemplateBackFieldDefaultValue[] tempDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[tempDefaultValueLength];
				for (int j = 0; j<tempDefaultValueLength; j++) {
					JSONObject tempDefaultValue = tempJSONObject.getJSONArray("defaultValue").getJSONObject(j);
					PassbookTemplateBackFieldDefaultValue defaultValue = new PassbookTemplateBackFieldDefaultValue();
					try { defaultValue.itemName = tempDefaultValue.getString("itemName"); } catch (Exception e) {}
					try { defaultValue.defaultLabel = tempDefaultValue.getString("defaultLabel"); } catch (Exception e) {}
					try { defaultValue.defaultValue = tempDefaultValue.get("defaultValue"); } catch (Exception e) {}
					try { defaultValue.attributedValue = tempDefaultValue.getString("attributedValue"); } catch (Exception e) {}
					try { defaultValue.changeMsg = tempDefaultValue.getString("changeMsg"); } catch (Exception e) {}
					defaultValue.format = new PassbookTemplateBackFieldDefaultValueFormat();
					try { defaultValue.format.type = tempDefaultValue.getJSONObject("format").getString("type"); } catch (Exception e) {}
					try { defaultValue.format.dateFormat = tempDefaultValue.getJSONObject("format").getString("dateFormat"); } catch (Exception e) {}
					try { defaultValue.format.timeFormat = tempDefaultValue.getJSONObject("format").getString("timeFormat"); } catch (Exception e) {}
					try { defaultValue.format.ignoreTimeZone = tempDefaultValue.getJSONObject("format").getBoolean("ignoreTimeZone"); } catch (Exception e) {}
					try { defaultValue.format.isRelative = tempDefaultValue.getJSONObject("format").getBoolean("isRelative"); } catch (Exception e) {}
					try { defaultValue.format.currencyCode = tempDefaultValue.getJSONObject("format").getString("currencyCode"); } catch (Exception e) {}
					try { defaultValue.format.numberFormat = tempDefaultValue.getJSONObject("format").getString("numberFormat"); } catch (Exception e) {}
					tempDefaultValueArray[j] = defaultValue;
				}
				addPassbookRedeemTemplateFieldBack(temp, tempDefaultValueArray);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("beacons").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("beacons").getJSONObject(i);
				PassbookTemplateBeacon temp = new PassbookTemplateBeacon();
				try { temp.major = tempJSONObject.getInt("major"); } catch (Exception e) {}
				try { temp.minor = tempJSONObject.getInt("minor"); } catch (Exception e) {}
				try { temp.uuid = tempJSONObject.getString("uuid"); } catch (Exception e) {}
				try { temp.relevantText = tempJSONObject.getString("relevantText"); } catch (Exception e) {}
				addPassbookRedeemTemplateBeacon(temp);
			}
		} catch (Exception e) {  }

		try { 
			arrayLength = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("locations").length();
			for (int i = 0; i<arrayLength; i++) {
				JSONObject tempJSONObject = inputJSONObject.getJSONObject("passbookRedeem").getJSONArray("locations").getJSONObject(i);
				PassbookTemplateLocation temp = new PassbookTemplateLocation();
				try { temp.alt = tempJSONObject.getInt("alt"); } catch (Exception e) {}
				try { temp.lat = Float.valueOf(String.valueOf(tempJSONObject.getString("lat"))); } catch (Exception e) {}
				try { temp.lon = Float.valueOf(String.valueOf(tempJSONObject.getString("lon"))); } catch (Exception e) {}
				try { temp.relevantText = tempJSONObject.getString("relevantText"); } catch (Exception e) {}
				addPassbookRedeemTemplateLocation(temp);
			}
		} catch (Exception e) {  }

		this.passbookLang = new HashMap <String, PassbookLang>();
		try {
			JSONObject temp = inputJSONObject.getJSONObject("passbookLang");
			arrayLength = languageList.length;
			for (int i = 0; i<arrayLength; i++) {
				try {			
					JSONObject tempJSONObject = temp.getJSONObject(languageList[i]);
					PassbookLang tempPassbookLang = new PassbookLang();
					try { tempPassbookLang.iconFile = tempJSONObject.getString("iconFile"); } catch (Exception e) {}
					try { tempPassbookLang.logoFile = tempJSONObject.getString("logoFile"); } catch (Exception e) {}
					try { tempPassbookLang.stripFile = tempJSONObject.getString("stripFile"); } catch (Exception e) {}
					try { tempPassbookLang.footerFile = tempJSONObject.getString("footerFile"); } catch (Exception e) {}
					try { tempPassbookLang.thumbFile = tempJSONObject.getString("thumbFile"); } catch (Exception e) {}
					try { tempPassbookLang.bgFile = tempJSONObject.getString("bgFile"); } catch (Exception e) {}
					tempPassbookLang.text = new HashMap <String, String>();
					try {
						JSONObject tempTextJSONObject = tempJSONObject.getJSONObject("text");
						JSONArray tempTextJSONArray = tempTextJSONObject.names();
						for ( int j = 0; j<tempTextJSONArray.length(); j++) {
							tempPassbookLang.text.put(tempTextJSONArray.getString(j),tempTextJSONObject.getString(tempTextJSONArray.getString(j)));
						}
					} catch (Exception e) {}
					passbookLang.put(languageList[i],tempPassbookLang);
				} catch (Exception e) {}
			}
		} catch (Exception e) {}

		this.passbookLangRedeem = new HashMap <String, PassbookLang>();
		try {
			JSONObject temp = inputJSONObject.getJSONObject("passbookRedeemLang");
			arrayLength = languageList.length;
			for (int i = 0; i<arrayLength; i++) {
				try {
					JSONObject tempJSONObject = temp.getJSONObject(languageList[i]);
					PassbookLang tempPassbookLangRedeem = new PassbookLang();
					try { tempPassbookLangRedeem.iconFile = tempJSONObject.getString("iconFile"); } catch (Exception e) {}
					try { tempPassbookLangRedeem.logoFile = tempJSONObject.getString("logoFile"); } catch (Exception e) {}
					try { tempPassbookLangRedeem.stripFile = tempJSONObject.getString("stripFile"); } catch (Exception e) {}
					try { tempPassbookLangRedeem.footerFile = tempJSONObject.getString("footerFile"); } catch (Exception e) {}
					try { tempPassbookLangRedeem.thumbFile = tempJSONObject.getString("thumbFile"); } catch (Exception e) {}
					try { tempPassbookLangRedeem.bgFile = tempJSONObject.getString("bgFile"); } catch (Exception e) {}
					tempPassbookLangRedeem.text = new HashMap <String, String>();
					try {
						JSONObject tempTextJSONObject = tempJSONObject.getJSONObject("text");
						JSONArray tempTextJSONArray = tempTextJSONObject.names();
						for ( int j = 0; j<tempTextJSONArray.length(); j++) {
							tempPassbookLangRedeem.text.put(tempTextJSONArray.getString(j),tempTextJSONObject.getString(tempTextJSONArray.getString(j)));
						}
					} catch (Exception e) {}
					passbookLangRedeem.put(languageList[i],tempPassbookLangRedeem);
				} catch (Exception e) {}
			}
		} catch (Exception e) {}
	}


	public void addDynamicKeys (DynamicKeys inputDynamicKeys) {
		if (this.dynamicKeys == null) {
			this.dynamicKeys = new DynamicKeys[]{inputDynamicKeys};
		} else {
			int size = this.dynamicKeys.length;
			DynamicKeys[] newDynamicKeys = new DynamicKeys[size];
			for (int i = 0; i < size; i++) {
				newDynamicKeys[i] = this.dynamicKeys[i];
			}
			this.dynamicKeys = new DynamicKeys[size+1];
			for (int i = 0; i < size; i++) {
				this.dynamicKeys[i] = newDynamicKeys[i];
			}
			this.dynamicKeys[size] = inputDynamicKeys;
		}
	}

	public void addPassbookTemplateFieldHeader (PassbookTemplateField inputPassbookTemplateField) {
		if (this.passbook.header == null) {
			this.passbook.header = new PassbookTemplateField[]{inputPassbookTemplateField};
		} else {
			int size = this.passbook.header.length;
			PassbookTemplateField[] newPassbookTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookTemplateFieldArray[i] = this.passbook.header[i];
			}
			this.passbook.header = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.header[i] = newPassbookTemplateFieldArray[i];
			}
			this.passbook.header[size] = inputPassbookTemplateField;
		}
	}

	public void addPassbookRedeemTemplateFieldHeader (PassbookTemplateField inputPassbookRedeemTemplateField) {
		if (this.passbookRedeem.header == null) {
			this.passbookRedeem.header = new PassbookTemplateField[]{inputPassbookRedeemTemplateField};
		} else {
			int size = this.passbookRedeem.header.length;
			PassbookTemplateField[] newPassbookRedeemTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookRedeemTemplateFieldArray[i] = this.passbookRedeem.header[i];
			}
			this.passbookRedeem.header = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.header[i] = newPassbookRedeemTemplateFieldArray[i];
			}
			this.passbookRedeem.header[size] = inputPassbookRedeemTemplateField;
		}
	}

	public void addPassbookTemplateFieldPrimary (PassbookTemplateField inputPassbookTemplateField) {
		if (this.passbook.primary == null) {
			this.passbook.primary = new PassbookTemplateField[]{inputPassbookTemplateField};
		} else {
			int size = this.passbook.primary.length;
			PassbookTemplateField[] newPassbookTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookTemplateFieldArray[i] = this.passbook.primary[i];
			}
			this.passbook.primary = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.primary[i] = newPassbookTemplateFieldArray[i];
			}
			this.passbook.primary[size] = inputPassbookTemplateField;
		}
	}

	public void addPassbookRedeemTemplateFieldPrimary (PassbookTemplateField inputPassbookRedeemTemplateField) {
		if (this.passbookRedeem.primary == null) {
			this.passbookRedeem.primary = new PassbookTemplateField[]{inputPassbookRedeemTemplateField};
		} else {
			int size = this.passbookRedeem.primary.length;
			PassbookTemplateField[] newPassbookRedeemTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookRedeemTemplateFieldArray[i] = this.passbookRedeem.primary[i];
			}
			this.passbookRedeem.primary = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.primary[i] = newPassbookRedeemTemplateFieldArray[i];
			}
			this.passbookRedeem.primary[size] = inputPassbookRedeemTemplateField;
		}
	}

	public void addPassbookTemplateFieldAuxiliary (PassbookTemplateField inputPassbookTemplateField) {
		if (this.passbook.auxiliary == null) {
			this.passbook.auxiliary = new PassbookTemplateField[]{inputPassbookTemplateField};
		} else {
			int size = this.passbook.auxiliary.length;
			PassbookTemplateField[] newPassbookTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookTemplateFieldArray[i] = this.passbook.auxiliary[i];
			}
			this.passbook.auxiliary = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.auxiliary[i] = newPassbookTemplateFieldArray[i];
			}
			this.passbook.auxiliary[size] = inputPassbookTemplateField;
		}
	}

	public void addPassbookRedeemTemplateFieldAuxiliary (PassbookTemplateField inputPassbookRedeemTemplateField) {
		if (this.passbookRedeem.auxiliary == null) {
			this.passbookRedeem.auxiliary = new PassbookTemplateField[]{inputPassbookRedeemTemplateField};
		} else {
			int size = this.passbookRedeem.auxiliary.length;
			PassbookTemplateField[] newPassbookRedeemTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookRedeemTemplateFieldArray[i] = this.passbookRedeem.auxiliary[i];
			}
			this.passbookRedeem.auxiliary = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.auxiliary[i] = newPassbookRedeemTemplateFieldArray[i];
			}
			this.passbookRedeem.auxiliary[size] = inputPassbookRedeemTemplateField;
		}
	}

	public void addPassbookTemplateFieldBack (PassbookTemplateBackField inputPassbookTemplateBackField) {
		if (this.passbook.back == null) {
			this.passbook.back = new PassbookTemplateBackField[]{inputPassbookTemplateBackField};
		} else {
			int size = this.passbook.back.length;
			PassbookTemplateBackField[] newPassbookTemplateBackFieldArray = new PassbookTemplateBackField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookTemplateBackFieldArray[i] = this.passbook.back[i];
			}
			this.passbook.back = new PassbookTemplateBackField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.back[i] = newPassbookTemplateBackFieldArray[i];
			}
			this.passbook.back[size] = inputPassbookTemplateBackField;
		}
	}

	public void addPassbookRedeemTemplateFieldBack (PassbookTemplateBackField inputPassbookRedeemTemplateBackField) {
		if (this.passbookRedeem.back == null) {
			this.passbookRedeem.back = new PassbookTemplateBackField[]{inputPassbookRedeemTemplateBackField};
		} else {
			int size = this.passbookRedeem.back.length;
			PassbookTemplateBackField[] newPassbookRedeemTemplateBackFieldArray = new PassbookTemplateBackField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookRedeemTemplateBackFieldArray[i] = this.passbookRedeem.back[i];
			}
			this.passbookRedeem.back = new PassbookTemplateBackField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.back[i] = newPassbookRedeemTemplateBackFieldArray[i];
			}
			this.passbookRedeem.back[size] = inputPassbookRedeemTemplateBackField;
		}
	}

	public void addPassbookTemplateFieldBack (PassbookTemplateBackField inputPassbookTemplateBackField, PassbookTemplateBackFieldDefaultValue[] inputPassbookTemplateBackFieldDefaultValue) {
		if (this.passbook.backArrayCounter == null) {
			this.passbook.back = new PassbookTemplateBackField[1];
			this.passbook.back[0] = inputPassbookTemplateBackField;
			for (int n = 0; n < inputPassbookTemplateBackFieldDefaultValue.length; n++) {
				if (this.passbook.back[0].defaultValueArrayCounter == null) {
					this.passbook.back[0].defaultValue = new PassbookTemplateBackFieldDefaultValue[1];
					this.passbook.back[0].defaultValue[0] = inputPassbookTemplateBackFieldDefaultValue[n];
					this.passbook.back[0].defaultValueArrayCounter = new Integer[1];
					this.passbook.back[0].defaultValueArrayCounter[0] = 1;
				} else {
					PassbookTemplateBackFieldDefaultValue[] newPassbookTemplateBackFieldDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[this.passbook.back[0].defaultValueArrayCounter[0]];
					for (int i = 0; i < this.passbook.back[0].defaultValueArrayCounter[0]; i++) {
						newPassbookTemplateBackFieldDefaultValueArray[i] = this.passbook.back[0].defaultValue[i];
					}
					this.passbook.back[0].defaultValue = new PassbookTemplateBackFieldDefaultValue[this.passbook.back[0].defaultValueArrayCounter[0]+1];
					for (int i = 0; i < this.passbook.back[0].defaultValueArrayCounter[0]; i++) {
						this.passbook.back[0].defaultValue[i] = newPassbookTemplateBackFieldDefaultValueArray[i];
					}
					this.passbook.back[0].defaultValue[this.passbook.back[0].defaultValueArrayCounter[0]] = inputPassbookTemplateBackFieldDefaultValue[n];
					this.passbook.back[0].defaultValueArrayCounter[0]++;
				}
			}
			this.passbook.backArrayCounter = new Integer[1];
			this.passbook.backArrayCounter[0] = 1;
		} else {
			PassbookTemplateBackField[] newPassbookTemplateBackFieldArray = new PassbookTemplateBackField[this.passbook.backArrayCounter[0]];	
			for (int i = 0; i < this.passbook.backArrayCounter[0]; i++) {
				newPassbookTemplateBackFieldArray[i] = this.passbook.back[i];
			}
			this.passbook.back = new PassbookTemplateBackField[this.passbook.backArrayCounter[0]+1];
			for (int i = 0; i < this.passbook.backArrayCounter[0]; i++) {
				this.passbook.back[i] = newPassbookTemplateBackFieldArray[i];
			}
			this.passbook.back[this.passbook.backArrayCounter[0]] = inputPassbookTemplateBackField;
			int backIndex = this.passbook.backArrayCounter[0];
			for (int n = 0; n < inputPassbookTemplateBackFieldDefaultValue.length; n++) {
				if (this.passbook.back[backIndex].defaultValueArrayCounter == null) {
					this.passbook.back[backIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[1];
					this.passbook.back[backIndex].defaultValue[0] = inputPassbookTemplateBackFieldDefaultValue[n];
					this.passbook.back[backIndex].defaultValueArrayCounter = new Integer[1];
					this.passbook.back[backIndex].defaultValueArrayCounter[0] = 1;
				} else {
					PassbookTemplateBackFieldDefaultValue[] newPassbookTemplateBackFieldDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[this.passbook.back[backIndex].defaultValueArrayCounter[0]];
					for (int i = 0; i < this.passbook.back[backIndex].defaultValueArrayCounter[0]; i++) {
						newPassbookTemplateBackFieldDefaultValueArray[i] = this.passbook.back[backIndex].defaultValue[i];
					}
					this.passbook.back[backIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[this.passbook.back[0].defaultValueArrayCounter[0]+1];
					for (int i = 0; i < this.passbook.back[backIndex].defaultValueArrayCounter[0]; i++) {
						this.passbook.back[backIndex].defaultValue[i] = newPassbookTemplateBackFieldDefaultValueArray[i];
					}
					this.passbook.back[backIndex].defaultValue[this.passbook.back[backIndex].defaultValueArrayCounter[0]] = inputPassbookTemplateBackFieldDefaultValue[n];
					this.passbook.back[backIndex].defaultValueArrayCounter[0]++;
				}
			}
			this.passbook.backArrayCounter[0]++;
		}
	}

	public void addPassbookRedeemTemplateFieldBack (PassbookTemplateBackField inputPassbookRedeemTemplateBackField, PassbookTemplateBackFieldDefaultValue[] inputPassbookRedeemTemplateBackFieldDefaultValue) {
		if (this.passbookRedeem.backArrayCounter == null) {
			this.passbookRedeem.back = new PassbookTemplateBackField[1];
			this.passbookRedeem.back[0] = inputPassbookRedeemTemplateBackField;
			for (int n = 0; n < inputPassbookRedeemTemplateBackFieldDefaultValue.length; n++) {
				if (this.passbookRedeem.back[0].defaultValueArrayCounter == null) {
					this.passbookRedeem.back[0].defaultValue = new PassbookTemplateBackFieldDefaultValue[1];
					this.passbookRedeem.back[0].defaultValue[0] = inputPassbookRedeemTemplateBackFieldDefaultValue[n];
					this.passbookRedeem.back[0].defaultValueArrayCounter = new Integer[1];
					this.passbookRedeem.back[0].defaultValueArrayCounter[0] = 1;
				} else {
					PassbookTemplateBackFieldDefaultValue[] newPassbookRedeemTemplateBackFieldDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[this.passbookRedeem.back[0].defaultValueArrayCounter[0]];
					for (int i = 0; i < this.passbookRedeem.back[0].defaultValueArrayCounter[0]; i++) {
						newPassbookRedeemTemplateBackFieldDefaultValueArray[i] = this.passbookRedeem.back[0].defaultValue[i];
					}
					this.passbookRedeem.back[0].defaultValue = new PassbookTemplateBackFieldDefaultValue[this.passbookRedeem.back[0].defaultValueArrayCounter[0]+1];
					for (int i = 0; i < this.passbookRedeem.back[0].defaultValueArrayCounter[0]; i++) {
						this.passbookRedeem.back[0].defaultValue[i] = newPassbookRedeemTemplateBackFieldDefaultValueArray[i];
					}
					this.passbookRedeem.back[0].defaultValue[this.passbookRedeem.back[0].defaultValueArrayCounter[0]] = inputPassbookRedeemTemplateBackFieldDefaultValue[n];
					this.passbookRedeem.back[0].defaultValueArrayCounter[0]++;
				}
			}
			this.passbookRedeem.backArrayCounter = new Integer[1];
			this.passbookRedeem.backArrayCounter[0] = 1;
		} else {
			PassbookTemplateBackField[] newPassbookRedeemTemplateBackFieldArray = new PassbookTemplateBackField[this.passbookRedeem.backArrayCounter[0]];	
			for (int i = 0; i < this.passbookRedeem.backArrayCounter[0]; i++) {
				newPassbookRedeemTemplateBackFieldArray[i] = this.passbookRedeem.back[i];
			}
			this.passbookRedeem.back = new PassbookTemplateBackField[this.passbookRedeem.backArrayCounter[0]+1];
			for (int i = 0; i < this.passbookRedeem.backArrayCounter[0]; i++) {
				this.passbookRedeem.back[i] = newPassbookRedeemTemplateBackFieldArray[i];
			}
			this.passbookRedeem.back[this.passbookRedeem.backArrayCounter[0]] = inputPassbookRedeemTemplateBackField;
			int backIndex = this.passbookRedeem.backArrayCounter[0];
			for (int n = 0; n < inputPassbookRedeemTemplateBackFieldDefaultValue.length; n++) {
				if (this.passbookRedeem.back[backIndex].defaultValueArrayCounter == null) {
					this.passbookRedeem.back[backIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[1];
					this.passbookRedeem.back[backIndex].defaultValue[0] = inputPassbookRedeemTemplateBackFieldDefaultValue[n];
					this.passbookRedeem.back[backIndex].defaultValueArrayCounter = new Integer[1];
					this.passbookRedeem.back[backIndex].defaultValueArrayCounter[0] = 1;
				} else {
					PassbookTemplateBackFieldDefaultValue[] newPassbookRedeemTemplateBackFieldDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[this.passbookRedeem.back[backIndex].defaultValueArrayCounter[0]];
					for (int i = 0; i < this.passbookRedeem.back[backIndex].defaultValueArrayCounter[0]; i++) {
						newPassbookRedeemTemplateBackFieldDefaultValueArray[i] = this.passbookRedeem.back[backIndex].defaultValue[i];
					}
					this.passbookRedeem.back[backIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[this.passbookRedeem.back[0].defaultValueArrayCounter[0]+1];
					for (int i = 0; i < this.passbookRedeem.back[backIndex].defaultValueArrayCounter[0]; i++) {
						this.passbookRedeem.back[backIndex].defaultValue[i] = newPassbookRedeemTemplateBackFieldDefaultValueArray[i];
					}
					this.passbookRedeem.back[backIndex].defaultValue[this.passbookRedeem.back[backIndex].defaultValueArrayCounter[0]] = inputPassbookRedeemTemplateBackFieldDefaultValue[n];
					this.passbookRedeem.back[backIndex].defaultValueArrayCounter[0]++;
				}
			}
			this.passbook.backArrayCounter[0]++;
		}
	}

	public void addPassbookTemplateFieldBackDefaultValue (int backArrayIndex, PassbookTemplateBackFieldDefaultValue inputPassbookTemplateBackFieldDefaultValue) {
		if (this.passbook.back[backArrayIndex].defaultValueArrayCounter == null) {
			this.passbook.back[backArrayIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[1];
			this.passbook.back[backArrayIndex].defaultValue[0] = inputPassbookTemplateBackFieldDefaultValue;
			this.passbook.back[backArrayIndex].defaultValueArrayCounter = new Integer[1];
			this.passbook.back[backArrayIndex].defaultValueArrayCounter[0] = 1;
		} else {
			PassbookTemplateBackFieldDefaultValue[] newPassbookTemplateBackFieldDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[this.passbook.back[backArrayIndex].defaultValueArrayCounter[0]];
			for (int i = 0; i < this.passbook.back[backArrayIndex].defaultValueArrayCounter[0]; i++) {
				newPassbookTemplateBackFieldDefaultValueArray[i] = this.passbook.back[backArrayIndex].defaultValue[i];
			}
			this.passbook.back[backArrayIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[this.passbook.back[backArrayIndex].defaultValueArrayCounter[0]+1];
			for (int i = 0; i < this.passbook.back[backArrayIndex].defaultValueArrayCounter[0]; i++) {
				this.passbook.back[backArrayIndex].defaultValue[i] = newPassbookTemplateBackFieldDefaultValueArray[i];
			}
			this.passbook.back[backArrayIndex].defaultValue[this.passbook.back[backArrayIndex].defaultValueArrayCounter[0]] = inputPassbookTemplateBackFieldDefaultValue;
			this.passbook.back[backArrayIndex].defaultValueArrayCounter[0]++;
		}
	}

	public void addPassbookRedeemTemplateFieldBackDefaultValue (int backArrayIndex, PassbookTemplateBackFieldDefaultValue inputPassbookRedeemTemplateBackFieldDefaultValue) {
		if (this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter == null) {
			this.passbookRedeem.back[backArrayIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[1];
			this.passbookRedeem.back[backArrayIndex].defaultValue[0] = inputPassbookRedeemTemplateBackFieldDefaultValue;
			this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter = new Integer[1];
			this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter[0] = 1;
		} else {
			PassbookTemplateBackFieldDefaultValue[] newPassbookRedeemTemplateBackFieldDefaultValueArray = new PassbookTemplateBackFieldDefaultValue[this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter[0]];
			for (int i = 0; i < this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter[0]; i++) {
				newPassbookRedeemTemplateBackFieldDefaultValueArray[i] = this.passbookRedeem.back[backArrayIndex].defaultValue[i];
			}
			this.passbookRedeem.back[backArrayIndex].defaultValue = new PassbookTemplateBackFieldDefaultValue[this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter[0]+1];
			for (int i = 0; i < this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter[0]; i++) {
				this.passbookRedeem.back[backArrayIndex].defaultValue[i] = newPassbookRedeemTemplateBackFieldDefaultValueArray[i];
			}
			this.passbookRedeem.back[backArrayIndex].defaultValue[this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter[0]] = inputPassbookRedeemTemplateBackFieldDefaultValue;
			this.passbookRedeem.back[backArrayIndex].defaultValueArrayCounter[0]++;
		}
	}

	public void addPassbookTemplateFieldSecondary (PassbookTemplateField inputPassbookTemplateField) {
		if (this.passbook.secondary == null) {
			this.passbook.secondary = new PassbookTemplateField[]{inputPassbookTemplateField};
		} else {
			int size = this.passbook.secondary.length;
			PassbookTemplateField[] newPassbookTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookTemplateFieldArray[i] = this.passbook.secondary[i];
			}
			this.passbook.secondary = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.secondary[i] = newPassbookTemplateFieldArray[i];
			}
			this.passbook.secondary[size] = inputPassbookTemplateField;
		}
	}

	public void addPassbookRedeemTemplateFieldSecondary (PassbookTemplateField inputPassbookRedeemTemplateField) {
		if (this.passbookRedeem.secondary == null) {
			this.passbookRedeem.secondary = new PassbookTemplateField[]{inputPassbookRedeemTemplateField};
		} else {
			int size = this.passbookRedeem.secondary.length;
			PassbookTemplateField[] newPassbookRedeemTemplateFieldArray = new PassbookTemplateField[size];	
			for (int i = 0; i < size; i++) {
				newPassbookRedeemTemplateFieldArray[i] = this.passbookRedeem.secondary[i];
			}
			this.passbookRedeem.secondary = new PassbookTemplateField[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.secondary[i] = newPassbookRedeemTemplateFieldArray[i];
			}
			this.passbookRedeem.secondary[size] = inputPassbookRedeemTemplateField;
		}
	}

	public void addPassbookTemplateBeacon (PassbookTemplateBeacon inputPassbookTemplateBeacon) {
		if (this.passbook.beacons == null) {
			this.passbook.beacons = new PassbookTemplateBeacon[]{inputPassbookTemplateBeacon};
		} else {
			int size = this.passbook.beacons.length;
			PassbookTemplateBeacon[] newPassbookTemplateBeacon = new PassbookTemplateBeacon[size];
			for (int i = 0; i < size; i++) {
				newPassbookTemplateBeacon[i] = this.passbook.beacons[i];
			}
			this.passbook.beacons = new PassbookTemplateBeacon[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.beacons[i] = newPassbookTemplateBeacon[i];
			}
			this.passbook.beacons[size] = inputPassbookTemplateBeacon;
		}
	}

	public void addPassbookRedeemTemplateBeacon (PassbookTemplateBeacon inputPassbookRedeemTemplateBeacon) {
		if (this.passbookRedeem.beacons == null) {
			this.passbookRedeem.beacons = new PassbookTemplateBeacon[]{inputPassbookRedeemTemplateBeacon};
		} else {
			int size = this.passbookRedeem.beacons.length;
			PassbookTemplateBeacon[] newPassbookRedeemTemplateBeacon = new PassbookTemplateBeacon[size];
			for (int i = 0; i < size; i++) {
				newPassbookRedeemTemplateBeacon[i] = this.passbookRedeem.beacons[i];
			}
			this.passbookRedeem.beacons = new PassbookTemplateBeacon[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.beacons[i] = newPassbookRedeemTemplateBeacon[i];
			}
			this.passbookRedeem.beacons[size] = inputPassbookRedeemTemplateBeacon;
		}
	}

	public void addPassbookTemplateLocation (PassbookTemplateLocation inputPassbookTemplateLocation) {
		if (this.passbook.locations == null) {
			this.passbook.locations = new PassbookTemplateLocation[]{inputPassbookTemplateLocation};
		} else {
			int size = this.passbook.locations.length;
			PassbookTemplateLocation[] newPassbookTemplateLocation = new PassbookTemplateLocation[size];
			for (int i = 0; i < size; i++) {
				newPassbookTemplateLocation[i] = this.passbook.locations[i];
			}
			this.passbook.locations = new PassbookTemplateLocation[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.locations[i] = newPassbookTemplateLocation[i];
			}
			this.passbook.locations[size] = inputPassbookTemplateLocation;
		}
	}

	public void addPassbookRedeemTemplateLocation (PassbookTemplateLocation inputPassbookRedeemTemplateLocation) {
		if (this.passbookRedeem.locations == null) {
			this.passbookRedeem.locations = new PassbookTemplateLocation[]{inputPassbookRedeemTemplateLocation};
		} else {
			int size = this.passbookRedeem.locations.length;
			PassbookTemplateLocation[] newPassbookRedeemTemplateLocation = new PassbookTemplateLocation[size];
			for (int i = 0; i < size; i++) {
				newPassbookRedeemTemplateLocation[i] = this.passbookRedeem.locations[i];
			}
			this.passbookRedeem.locations = new PassbookTemplateLocation[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.locations[i] = newPassbookRedeemTemplateLocation[i];
			}
			this.passbookRedeem.locations[size] = inputPassbookRedeemTemplateLocation;
		}
	}

	public void addPassbookAssoStoreId (Integer inputInteger) {
		if (this.passbook.assoStoreId == null) {
			this.passbook.assoStoreId = new Integer[]{inputInteger};
		} else {
			int size = this.passbook.assoStoreId.length;
			Integer[] newInteger = new Integer[size];
			for (int i = 0; i < size; i++) {
				newInteger[i] = this.passbook.assoStoreId[i];
			}
			this.passbook.assoStoreId = new Integer[size+1];
			for (int i = 0; i < size; i++) {
				this.passbook.assoStoreId[i] = newInteger[i];
			}
			this.passbook.assoStoreId[size] = inputInteger;
		}
	}

	public void addPassbookRedeemAssoStoreId (Integer inputInteger) {
		if (this.passbookRedeem.assoStoreId == null) {
			this.passbookRedeem.assoStoreId = new Integer[]{inputInteger};
		} else {
			int size = this.passbookRedeem.assoStoreId.length;
			Integer[] newInteger = new Integer[size];
			for (int i = 0; i < size; i++) {
				newInteger[i] = this.passbookRedeem.assoStoreId[i];
			}
			this.passbookRedeem.assoStoreId = new Integer[size+1];
			for (int i = 0; i < size; i++) {
				this.passbookRedeem.assoStoreId[i] = newInteger[i];
			}
			this.passbookRedeem.assoStoreId[size] = inputInteger;
		}
	}

}

// System.out.println("==\n"+Arrays.toString(this.dynamicKeys)+"\n==");