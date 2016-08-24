#PassKit SDK for JAVA

![PassKit Logo](https://passkit.com/images/passkit-logo.png)

##Description

###&nbsp;&nbsp;&nbsp;&nbsp;The PassKit SDK enables user to efficiently connect to the PassKit API. To use this SDK, you will need an account with PassKit.

##0. Prerequisites

###&nbsp;&nbsp;&nbsp;&nbsp; Adding JAR File Library
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To be added

###&nbsp;&nbsp;&nbsp;&nbsp; Import passkitSDK

```java
import passkit;
```

##1. PassKit

###&nbsp;&nbsp;&nbsp;&nbsp;Create PassKit

```java
PassKit pk = new PassKit("apiKey","apiSecret");
```

##2. Campaign

###&nbsp;&nbsp;&nbsp;&nbsp;Create Campaign
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the name of the created campaign as a `String` object.

```java
Campaign c1 = new Campaign();
c1.name = "MyCampaign";
c1.passbookCertId = "MyPassbookCertId";
c1.startDate = "2016-01-01T00:00:00Z";
// refer to `https://dev.passkit.net/#create-a-campaign` for a complete attribute list.
String createdCampaignName = pk.createCampaign(c1);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Retrieve Campaign
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of the retrieved campaign as a `Campaign` object.

```java
Campaign c2 = null;
c2 = pk.retrieveCampaign("nameOfTargetCampaign");
```

###&nbsp;&nbsp;&nbsp;&nbsp;Retrieve All Campaigns
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of all retrieved campaigns as a `Campaign[]` object.

```java
Campaign[] c3 = null;
c3 = pk.retrieveAllCampaign();
```

###&nbsp;&nbsp;&nbsp;&nbsp;Update Campaign
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the name of the updated campaign as a `String` object.

```java
Campaign c4 = new Campaign();
c4.displayName = "MyCampaignDisplayName";
c4.discription = "MyCampaignDescription";
// refer to `https://dev.passkit.net/#update-a-campaign` for a complete attribute list.
String updatedCampaignName = pk.updateCampaign("nameOfTargetCampaign", c4);
```

##3. Template

###&nbsp;&nbsp;&nbsp;&nbsp;Create Template
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the name of the created template as a `String` object.

```java
Template t1 = new Template();
t1.name = "MyTempalate";
t1.campaignName = "MyCampaign";
t1.language = "en";
t1.startDate = "2016-01-01T00:00:00Z";
t1.passbook = new Passbook();
t1.passbook.type = "storeCard";
t1.passbook.desc = "Description of the template";
// refer to `https://dev.passkit.net/#create-a-template` for a complete attribute list.
HashMap <String,Object> imageHolder1 = new HashMap<String, Object>();
imageHolder1.put("passbook-IconFile", new File("iconFile.png"));
String createdTemplateName = pk.createTemplate(t1, imageHolder1);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Retrieve Template
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of the retrieved template as a `Template` object.

```java
Template t2 = null;
t2 = pk.retrieveTemplate("nameOfTargetTemplate");
```

###&nbsp;&nbsp;&nbsp;&nbsp;Retrieve All Templates
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of all retrieved templates as a `Template[]` object.

```java
Template[] t3 = null;
t3 = pk.retrieveAllTemplate("nameOfTargetCampaign");
```

###&nbsp;&nbsp;&nbsp;&nbsp;Update Template
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the name of the updated template as a `String` object.

```java
Template t4 = new Template();
t4.language = "de";
// refer to `https://dev.passkit.net/#update-a-template` for a complete attribute list.
String updatedTemplateName = pk.updateTemplate("nameOfTargetTemplate", t4);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Update Template with images
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the name of the updated template as a `String` object.

```java
Template t5 = new Template();
t5.language = "fr";
// refer to `https://dev.passkit.net/#update-a-template-with-images` for a complete attribute list.
HashMap <String,Object> updateImage = new HashMap<String, Object>();
updateImage.put("passbook-IconFile", new File("path/to/image.png"));
String[] deleteImage = {"passbook-LogoFile"}
String updatedTemplateName = pk.updateTemplate("nameOfTargetTemplate", t5, updateImage, deleteImage);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Push Update
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the name of the pushed updated template as a `String` object.
```java
String pushedUpdatedTemplateName = pk.pushUpdate("nameOfTargetTemplate");
```

##4. Pass

###&nbsp;&nbsp;&nbsp;&nbsp;Create Pass
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the id of the created pass as a `String` object.

```java
Pass p1 = new Pass();
p1.templateName = "MyTemplate";
// refer to `https://dev.passkit.net/#create-a-pass` for a complete attribute list.
String createdPassName = pk.createPass(p1);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Retrieve Pass
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of the retrieved pass as a `Pass` object.

```java
Pass p2 = null;
p2 = pk.retrievePass("idOfTargetPass");
```

###&nbsp;&nbsp;&nbsp;&nbsp;Retrieve Pass with userDefinedId
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of the retrieved pass as a `Pass` object.

```java
Pass p3 = null;
p3 = pk.retrievePass("userDefinedIdOfTargetPass","campaignOfTargetPass");
```

###&nbsp;&nbsp;&nbsp;&nbsp;Update Pass
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the id of the updated pass as a `String` object.

```java
Pass p4 = new Pass();
p4.recoveryEmail = "apoorva@passkit.com";
// refer to `https://dev.passkit.net/#update-a-pass` for a complete attribute list.
String updatedPassId = pk.updatePass("idOfTargetPass", p4);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Update Pass with userDefinedId
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the id of the updated pass as a `String` object.

```java
Pass p5 = new Pass();
p5.recoveryEmail = "apoorva@passkit.com";
// refer to `https://dev.passkit.net/#updating-a-pass-with-a-user-defined-id` for a complete attribute list.
String updatedPassId = pk.updatePass("userDefinedIdOfTargetPass","campaignOfTargetPass", p5);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Redeem Pass
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the id of the redeemed pass as a `String` object.

```java
string redeemedPassId = pk.redeemPass("idOfTargetPass");
```

###&nbsp;&nbsp;&nbsp;&nbsp;Create Pass Batch
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the ids of the created passes as a `String[]` object.

```java
Pass[] p6 = new Pass[2];
p6[0] = new Pass();
p6[0].templateName = "MyTemplate";
p6[1] = new Pass();
p6[1].templateName = "MyTemplate";
// refer to `https://dev.passkit.net/#batch-create-passes` for a complete attribute list.
String[] createdPassIdArray = pk.createPassBatch(p6);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Retrieve Pass Batch
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of the retrieved passes as a `Pass[]` object.

```java
Pass[] p7 = null;
String[] passIdArray = {"passId1","passId2"};
p7 = pk.retrievePassBatch(passIdArray);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Update Pass Batch
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the ids of the updated passes as a `String[]` object.

```java
Pass[] p8 = new Pass[2];
String[] passIdArray = {"passId1","passId2"};
p8[0] = new Pass();
p8[0].id = passIdArray[0];
p8[0].recoveryEmail = "apoorva@passkit.com";
p8[1] = new Pass();
p8[1].id = passIdArray[1];
p8[1].recoveryEmail = "apoorva@passkit.com";
// refer to `https://dev.passkit.net/#batch-update-passes` for a complete attribute list.
String[] updatedPassIdArray = pk.updatePassBatch(p8);
```

##5. Search
###&nbsp;&nbsp;&nbsp;&nbsp;Initiate Pass Search
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the search result of the searched pass as a `SearchResult` object.

```java
Search s = new Search();
s.size = 10;
s.passFilter = new PassFilter();
s.passFilter.isRedeemed = new Operation();
s.passFilter.isRedeemed.eq = false;
// refer to `https://dev.passkit.net/#initiate-search` for a complete attribute list.
SearchResult sr = new SearchResult();
sr = pk.search(s);
```

##6. Images

###&nbsp;&nbsp;&nbsp;&nbsp;Upload Image
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the path of the uploaded image as a `String` object.

```java
String path = null;
path = pk.uploadImage(new File(img.png));
```

##7. Recovery Email

###&nbsp;&nbsp;&nbsp;&nbsp;Resend Single Recovery Email
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of the resent recovery email as a `RecoveryEmail` object.
```java
RecoveryEmail re1 = new RecoveryEmail();
re1.passId = "idOfTargetPass";
re1.newRecoveryEmail = "apoorva@passkit.com";
RecoveryEmail resultRE1 = null;
resultRE1 = pk.resendRecoveryEmail(re1);
```

###&nbsp;&nbsp;&nbsp;&nbsp;Resend Multiple Recovery Email
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns the details of the resent recovery emails as a `RecoveryEmail[]` object.

```java
RecoveryEmail[] re2 = new RecoveryEmail[2];
re2[0] = new RecoveryEmail();
re2[0].passId = "idOfTargetPass";
re2[0].newRecoveryEmail = "apoorva@passkit.com";
re2[1] = new RecoveryEmail();
re2[1].passId = "idOfTargetPass";
RecoveryEmail[] resultRE2 = null;
resultRE2 = pk.resendRecoveryEmail(re2);
```

##8. Supplementary Functions
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;returns respective class object as `JSONObject` object.

```java
JSONObject output = null;
Campaign campaign = new Campaign();
output = pk.CampaignToJSONObject(campaign); 
Template template = new Template();
output = pk.TemplateToJSONObject(template); 
Pass pass = new Pass();
output = pk.PassToJSONObject(pass); 
Pass[] passArray = new PassArray[];
output = pk.PassArrayToJSONObject(passArray); 
RecoveryEmail recoveryEmail = new RecoveryEmail();
output = pk.RecoveryEmailToJSONObject(recoveryEmail); 
Search search = new Search();
output = pk.SearchToJSONObject(search); 
```
