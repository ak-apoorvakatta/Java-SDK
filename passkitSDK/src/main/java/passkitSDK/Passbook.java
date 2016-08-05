package passkitSDK;

public class Passbook {
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