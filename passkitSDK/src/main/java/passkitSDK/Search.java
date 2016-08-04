package passkitSDK;

import java.util.*;

class Operation {
	public Object gt = null;
	public Object gte = null;
	public Object lt = null;
	public Object lte = null;
	public Object eq = null;
	public Boolean exists = null;
}

class PassFilter {
	public String id = null;
	public String templateName = null;
	public String campaignName = null;

	public Boolean isVoided = null;
	public Boolean isRedeemed = null;
	public Boolean isInvalid = null;

	public Operation userDefinedId = null;
	public Operation expiryDate = null;
	public Operation updatedAt = null;
	public Operation createdAt = null;
	public Operation firstUnregisteredAt = null;
	public Operation lastUnregisteredAt = null;
	public Operation firstRegisteredAt = null;
	public Operation lastRegisteredAt = null;
	public Operation lastRedeemAt = null;
	public Operation recoveryEmail = null;
	public Operation passbookDevices = null;
	public Operation androidPayDevices = null;

	public HashMap <String, Operation> dynamicData = null;
}

public class Search {
	public Integer size = null;
	public Integer from = null;
	public PassFilter passFilter = null;

	public Search () {

	}

}