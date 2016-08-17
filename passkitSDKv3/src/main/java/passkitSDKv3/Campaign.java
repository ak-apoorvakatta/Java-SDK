package passkitSDKv3;

import org.json.JSONObject;

public class Campaign {
    public String index = null;
    public String name = null;
    public String passbookCertId = null;
    public String googleSerciveAccount = null;
    public String googleIssuerId = null;
    public String status = null;
    public String displayName = null;
    public String description = null;
    public String startDate = null;
    public String endDate = null;
    public String createdAt = null;
    public String updatedAt = null;
    //public LandingDataJson landingdata = null;
    //public String landingTemplate = null;
    //public WhiteLabelItems whiteLable = null;
    //public CallbackURL callbackUrl = null;
    public Integer maxIssue = null;
    public Integer issued = null;

    public Campaign () {
        
    }

    public Campaign (JSONObject inputJSONObject) {
        try{ this.index = (String) inputJSONObject.get("index"); } catch (Exception e) {}
        try{ this.name = (String) inputJSONObject.get("name"); } catch (Exception e) {}
        try{ this.passbookCertId = (String) inputJSONObject.get("passbookCertId"); } catch (Exception e) {}
        try{ this.googleSerciveAccount = (String) inputJSONObject.get("googleSerciveAccount"); } catch (Exception e) {}
        try{ this.googleIssuerId = (String) inputJSONObject.get("googleIssuerId"); } catch (Exception e) {}
        try{ this.status = (String) inputJSONObject.get("status"); } catch (Exception e) {}
        try{ this.displayName = (String) inputJSONObject.get("displayName"); } catch (Exception e) {}
        try{ this.description = (String) inputJSONObject.get("description"); } catch (Exception e) {}
        try{ this.startDate = (String) inputJSONObject.get("startDate"); } catch (Exception e) {}
        try{ this.endDate = (String) inputJSONObject.get("endDate"); } catch (Exception e) {}
        try{ this.createdAt = (String) inputJSONObject.get("createdAt"); } catch (Exception e) {}
        try{ this.updatedAt = (String) inputJSONObject.get("updatedAt"); } catch (Exception e) {}
        try{ this.maxIssue = (Integer) inputJSONObject.get("maxIssue"); } catch (Exception e) {}
        try{ this.issued = (Integer) inputJSONObject.get("issued"); } catch (Exception e) {}
    }

    public void printData() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("-- Campaign Details -----------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Index:\t\t\t\t"+index);
        System.out.println("Name:\t\t\t\t"+name);
        System.out.println("Passbook Certificate Id:\t"+passbookCertId);
        System.out.println("Status:\t\t\t\t"+status);
        System.out.println("Display Name:\t\t\t"+displayName);
        System.out.println("Description:\t\t\t"+description);
        System.out.println("Start Date:\t\t\t"+startDate);
        System.out.println("End Date:\t\t\t"+endDate);
        System.out.println("Created At:\t\t\t"+createdAt);
        System.out.println("Updated At:\t\t\t"+updatedAt);
        System.out.println("Maximum Issue:\t\t\t"+maxIssue);
        System.out.println("Issued:\t\t\t\t"+issued);
        System.out.println("-------------------------------------------------------------------------------");
    }

}
