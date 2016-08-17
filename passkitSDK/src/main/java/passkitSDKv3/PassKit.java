package passkitSDKv3;

import java.util.*;
import java.io.File;
import java.security.MessageDigest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;

/* For JWT Authentication */
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

/* For Mashape */
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.HttpResponse;

/* For the SSL */
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

/* Fot ObjectMapper */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("serial")
class InvalidInputException extends Exception {
    InvalidInputException(String s) {
        super(s);
    }
}

@SuppressWarnings("serial")
class ServerSideException extends Exception {
    ServerSideException(String s) {
        super(s);
    }
}

public class PassKit {
	
    private String apiKey;
    private String apiSecret;

    private String apiPassUrl = "https://api-pass.passkit.net";
    private String apiSearchUrl = "https://search.passkit.net";
    private String apiPassVersion = "v3";
    private String apiSearchVersion = "v1";

    public PassKit () {
    }

    public PassKit (String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    private JSONArray doQuery (String apiMode, String path, String requestType) throws InvalidInputException, ServerSideException {
        // Concatenate the full endpoint.
        String url = null;
        if (apiMode == "PASS") { url = this.apiPassUrl + "/" + this.apiPassVersion + "/" + path; }
        else if (apiMode == "SEARCH") { url = this.apiSearchUrl + "/" + this.apiSearchVersion + "/" + path; }
        else { return null; }

        // Build up connection and do the request
        try {
            // Initialize HttpClient - override SSL for basic Unirest client
            SSLContext context;
            try {
                context = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() { public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException { return true; } }).build();
            }
            catch (Exception e) {
                throw new IllegalStateException("An error occurs while setting up SSL.", e);
            }

            // Setup the connection
            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(context);
            HttpClientBuilder clientBuilder = HttpClients.custom().setSSLSocketFactory(factory);

            // Override default HTTP client
            Unirest.setHttpClient(clientBuilder.build());

            // Generate JWT for authentication
            String jwt = this.createJWT(requestType, url, null);

            // Set request headers.
            // Note that for the Authorization, the format is: "PKAuth + space + JWT"
            Map <String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "PKAuth " + jwt);

            // Set empty response object
            HttpResponse<JsonNode> jsonResponse = null;

            // Check for request type, and do request accordingly
            if (requestType == "GET") {
                jsonResponse = Unirest.get(url)
                        .headers(headers)
                        .asJson();
            }
            else if (requestType == "PUT") {
                jsonResponse = Unirest.put(url)
                        .headers(headers)
                        .asJson();
            }

            if ((400 <= jsonResponse.getStatus()) && (jsonResponse.getStatus() < 500)) {
                throw new InvalidInputException("[ "+jsonResponse.getStatus()+": "+jsonResponse.getBody().toString().substring(9).replace('}','\u0000')+" ]");
            }

            if ((500 <= jsonResponse.getStatus()) && (jsonResponse.getStatus() < 600)) {
                throw new ServerSideException("[ "+jsonResponse.getStatus()+": "+jsonResponse.getBody().toString().substring(9).replace('}','\u0000')+" ]");
            }

            JSONArray object = jsonResponse.getBody().getArray();
            return object;
        }
        catch (InvalidInputException e) {
            throw e;
        }
        catch (ServerSideException e) {
            throw e;
        }
        catch (Exception e) {
            // Throw exception with details in case of any error.
        	System.out.println("ERROR"+e);
            throw new IllegalStateException("\nAn error occured while doing the API request.", e);
        }
    }

    private JSONArray doQuery (String apiMode, String path, JSONObject data, String requestType) throws InvalidInputException, ServerSideException {
        // Concatenate the full endpoint.
        String url = null;
        if (apiMode == "PASS") { url = this.apiPassUrl + "/" + this.apiPassVersion + "/" + path; }
        else if (apiMode == "SEARCH") { url = this.apiSearchUrl + "/" + this.apiSearchVersion + "/" + path; }
        else { return null; }

        // Build up connection and do the request
        try {
            // Initialize HttpClient - override SSL for basic Unirest client
            SSLContext context;
            try {
                context = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                    //@Override
                    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        return true;
                    }
                }).build();
            }
            catch (Exception e) {
                throw new IllegalStateException("An error occurs while setting up SSL.", e);
            }

            // Setup the connection
            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(context);
            HttpClientBuilder clientBuilder = HttpClients.custom().setSSLSocketFactory(factory);

            // Override default HTTP client
            Unirest.setHttpClient(clientBuilder.build());

            // Generate JWT for authentication
            String jwt = this.createJWT(requestType, url, data.toString());

            // Set request headers.
            // Note that for the Authorization, the format is: "PKAuth + space + JWT"
            Map <String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "PKAuth " + jwt);
            headers.put("Content-Type", "application/json");

            // Set empty response object
            HttpResponse<JsonNode> jsonResponse = null;

            // Check for request type, and do request accordingly
            if(requestType == "POST") {
                jsonResponse = Unirest.post(url)
                        .headers(headers)
                        .body(data.toString())
                        .asJson();
            }
            else if (requestType == "PUT"){
                jsonResponse = Unirest.put(url)
                        .headers(headers)
                        .body(data.toString())
                        .asJson();
            }

            if ((400 <= jsonResponse.getStatus()) && (jsonResponse.getStatus() < 500)) {
                throw new InvalidInputException("[ "+jsonResponse.getStatus()+": "+jsonResponse.getBody().toString().substring(9).replace('}','\u0000')+" ]");
            }

            if ((500 <= jsonResponse.getStatus()) && (jsonResponse.getStatus() < 600)) {
                throw new ServerSideException("[ "+jsonResponse.getStatus()+": "+jsonResponse.getBody().toString().substring(9).replace('}','\u0000')+" ]");
            }

            // Get the JSON object
            JSONArray object = jsonResponse.getBody().getArray();

            // return object
            return object;
        }
        catch (InvalidInputException e) {
            throw e;
        }
        catch (ServerSideException e) {
            throw e;
        }
        catch (Exception e) {
            // Throw exception with details in case of any error.
            throw new IllegalStateException("\nAn error occured while doing the API request.", e);
        }
    }

    private JSONArray doQuery (String apiMode, String path, Object[] data, String requestType) throws InvalidInputException, ServerSideException {
        // Concatenate the full endpoint.
        String url = null;
        if (apiMode == "PASS") { url = this.apiPassUrl + "/" + this.apiPassVersion + "/" + path; }
        else if (apiMode == "SEARCH") { url = this.apiSearchUrl + "/" + this.apiSearchVersion + "/" + path; }
        else { return null; }

        // Build up connection and do the request
        try {
            // Initialize HttpClient - override SSL for basic Unirest client
            SSLContext context;
            try {
                context = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                    //@Override
                    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        return true;
                    }
                }).build();
            }
            catch (Exception e) {
                throw new IllegalStateException("An error occurs while setting up SSL.", e);
            }

            // Setup the connection
            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(context);
            HttpClientBuilder clientBuilder = HttpClients.custom().setSSLSocketFactory(factory);

            // Override default HTTP client
            Unirest.setHttpClient(clientBuilder.build());

            // Generate JWT for authentication
            String jwt = this.createJWT(requestType, url, Arrays.toString(data));

            // Set request headers.
            // Note that for the Authorization, the format is: "PKAuth + space + JWT"
            Map <String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "PKAuth " + jwt);
            headers.put("Content-Type", "application/json");

            // Set empty response object
            HttpResponse<JsonNode> jsonResponse = null;

            // Check for request type, and do request accordingly
            if(requestType == "POST") {
                jsonResponse = Unirest.post(url)
                        .headers(headers)
                        .body(Arrays.toString(data))
                        .asJson();
            }
            else if (requestType == "PUT" ) {
                jsonResponse = Unirest.put(url)
                        .headers(headers)
                        .body(Arrays.toString(data))
                        .asJson();
            }

            if ((400 <= jsonResponse.getStatus()) && (jsonResponse.getStatus() < 500)) {
                throw new InvalidInputException("[ "+jsonResponse.getStatus()+": "+jsonResponse.getBody().toString().substring(9).replace('}','\u0000')+" ]");
            }

            if ((500 <= jsonResponse.getStatus()) && (jsonResponse.getStatus() < 600)) {
                throw new ServerSideException("[ "+jsonResponse.getStatus()+": "+jsonResponse.getBody().toString().substring(9).replace('}','\u0000')+" ]");
            }

            // Get the JSON object
            JSONArray object = jsonResponse.getBody().getArray();

            // return object
            return object;
        }
        catch (InvalidInputException e) {
            throw e;
        }
        catch (ServerSideException e) {
            throw e;
        }
        catch (Exception e) {
            // Throw exception with details in case of any error.
            throw new IllegalStateException("\nAn error occured while doing the API request.", e);
        }
    }

    private String createJWT (String method, String url, String inputPayload) {
        try
        {
            // The JWT signature algorithm we will be using to sign the token (HMAC using SHA-256)
            SignatureAlgorithm sa = SignatureAlgorithm.HS256;
            
            // Add our claims
            Map <String, Object> cm = new HashMap<String, Object>();
            cm.put("key", this.apiKey);
            cm.put("iat", System.currentTimeMillis()/1000);
            cm.put("exp", System.currentTimeMillis()/1000 + 60);
            cm.put("method", method);
            cm.put("url", url);
            if (inputPayload != null) {
            	// Payload encryption with SHA-256
	            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	            messageDigest.update(inputPayload.getBytes());
	            byte[] messageDigestBytes = messageDigest.digest();

	            // Convert messageDigestBytes of type byte[] to inputPayloadHexString of type StringBuffer
	            StringBuffer inputPayloadHexString = new StringBuffer();
	            for (int i=0;i<messageDigestBytes.length;i++) {
	                inputPayloadHexString.append(Integer.toString((messageDigestBytes[i] & 0xff) + 0x100, 16).substring(1));
	            }

	            cm.put("signature", inputPayloadHexString.toString());
            }

            // set the claims
            String jwt = Jwts.builder().setHeaderParam("typ", "JWT")
                    .setClaims(cm).signWith(sa, TextCodec.BASE64.encode(this.apiSecret)).compact();

            return jwt;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public String createCampaign (Campaign inputCampaign) {
        try {
            JSONObject inputJSONObject = CampaignToJSONObject(inputCampaign);
            JSONArray output = doQuery("PASS", "campaigns", inputJSONObject, "POST");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Campaign retrieveCampaign (String campaignName) {
        try {
            JSONArray output = doQuery("PASS", "campaigns/" + campaignName, "GET");
            return JSONArrayToCampaign(output);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Campaign[] retrieveAllCampaign () {
        try {
            JSONArray output = doQuery("PASS", "campaigns", "GET");
            return JSONArrayToCampaignArray(output);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String updateCampaign (String campaignName, Campaign inputCampaign) {
        try {
            JSONObject inputJSONObject = CampaignToJSONObject(inputCampaign);
            JSONArray output = doQuery("PASS", "campaigns/"+campaignName, inputJSONObject, "PUT");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public String createTemplate (Template inputTemplate) {
        try {
            JSONObject inputJSONObject = TemplateToJSONObject(inputTemplate);
            JSONArray output = doQuery("PASS", "templates", inputJSONObject,  "POST");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Deprecated 
    public String createTemplate (Template inputTemplate, HashMap <String, Object> inputImages) {
        /* try {
            JSONObject inputJSONObject = TemplateToJSONObject(inputTemplate);
            JSONArray output = doQuery("PASS", "templates", inputJSONObject, inputImages, "POST");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        } */
        return null;
    }

    public Template retrieveTemplate (String templateName) {
        try {
            JSONArray output = doQuery("PASS", "templates/" + templateName, "GET");
            return JSONArrayToTemplate(output);

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Template[] retrieveAllTemplate (String campaignName) {
        try {
            JSONArray output = doQuery("PASS", "campaigns/" + campaignName +"/templates", "GET");
            return JSONArrayToTemplateArray(output);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String updateTemplate (String templateName, Template inputTemplate) {
        try {
            JSONObject inputJSONObject = TemplateToJSONObject(inputTemplate);
            JSONArray output = doQuery("PASS", "templates/"+templateName, inputJSONObject, "PUT");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Deprecated
    public String updateTemplate (String templateName, Template inputTemplate, HashMap <String, Object> inputImages) {
        /*try {
            JSONObject inputJSONObject = TemplateToJSONObject(inputTemplate);
            JSONArray output = doQuery("PASS", "templates/"+templateName, inputJSONObject, inputImages, "PUT");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }*/
        return null;
    }

    public String pushUpdate (String templateName) {
        try {
            JSONArray output = doQuery("PASS", "templates/"+templateName+"/push","PUT");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String createPass (Pass inputPass) {
        try {
            JSONObject inputJSONObject = PassToJSONObject(inputPass);
            JSONArray output = doQuery("PASS", "passes", inputJSONObject, "POST");
            return output.getJSONObject(0).getString("id");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Pass retrievePass (String passId) {
        try {
            JSONArray output = doQuery("PASS", "passes/" + passId, "GET");
            return JSONArrayToPass(output);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Pass retrievePass (String userDefinedId, String campaignName) {
        try {
            JSONArray output = doQuery("PASS", "passes?userDefinedId="+userDefinedId+"&campaignName"+campaignName, "GET");
            return JSONArrayToPass(output);

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String updatePass (String passId, Pass inputPass) {
        try {
            JSONObject inputJSONObject = PassToJSONObject(inputPass);
            JSONArray output = doQuery("PASS", "passes/"+passId, inputJSONObject, "PUT");
            return output.getJSONObject(0).getString("id");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String updatePass (String userDefinedId, String campaignName, Pass inputPass) {
        try {
            JSONObject inputJSONObject = PassToJSONObject(inputPass);
            JSONArray output = doQuery("PASS", "passes?userDefinedId="+userDefinedId+"&campaignName"+campaignName, inputJSONObject, "PUT");
            return output.getJSONObject(0).getString("id");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String redeemPass (String passId) {
        try {
            JSONArray output = doQuery("PASS", "passes/"+passId+"/redeem", "PUT");
            return output.getJSONObject(0).getString("id");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String[] createPassBatch (Pass[] inputPasses) {
        try {
            JSONObject inputJSONObject = PassArrayToJSONObject(inputPasses);
            JSONArray outputJSONArray = doQuery("PASS", "passesBatch", inputJSONObject, "POST");
            int numberOfPasses = outputJSONArray.getJSONObject(0).getJSONArray("id").length();
            String[] output = new String[numberOfPasses];
            for (int i = 0; i < numberOfPasses; i++) {
                output[i]=outputJSONArray.getJSONObject(0).getJSONArray("id").getString(i);
            }
            return output;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String[] updatePassBatch (Pass[] inputPasses) {
         try {
        	int numberOfPasses = inputPasses.length;
            Object[] inputArray = new Object[numberOfPasses];
            for (int i = 0; i < numberOfPasses; i++) {
            	inputArray[i] = PassToJSONObject(inputPasses[i]);
            }
            JSONArray outputJSONArray = doQuery("PASS", "passesBatch", inputArray, "PUT");
            String[] output = new String[numberOfPasses];
            for (int i = 0; i < numberOfPasses; i++) {
                output[i]=outputJSONArray.getJSONObject(0).getJSONArray("id").getString(i);
            }
            return output;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Pass[] retrievePassBatch (String[] passNames) {
        try {
            String inputString = "";
            int numberOfPasses = passNames.length;
            for (int i = 0; i < numberOfPasses; i++) {
                inputString = inputString + passNames[i] + ",";
            }
            inputString = inputString.substring(0,inputString.length()-1);
            JSONArray outputJSONArray = doQuery("PASS", "passesBatch?id="+inputString, "GET");
            return JSONArrayToPassArray(outputJSONArray);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public SearchResult search (Search inputSearch) {
        try {
            JSONObject inputJSONObject =  SearchToJSONObject(inputSearch);
            JSONArray outputJSONArray = doQuery("SEARCH","passes", inputJSONObject, "POST");
            SearchResult output = new SearchResult(outputJSONArray.getJSONObject(0));
            return output;
        } catch (Exception e) {System.out.println(e);}
        return null;
    }
    
    public String uploadImageByURL (String inputURL) {
        try {
            JSONArray output = doQuery("PASS", "images", new JSONObject().put("url", inputURL), "POST");
            return output.getJSONObject(0).getString("path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public String uploadImageByBase64 (String inputBase64) {
        try {
            JSONArray output = doQuery("PASS", "images", new JSONObject().put("base64String", inputBase64), "POST");
            return output.getJSONObject(0).getString("path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String uploadImageByFile (File inputImageFile, String inputFileExtension) {
        try {
        	String inputBase64 = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(inputImageFile));
            JSONArray output = doQuery("PASS", "images", new JSONObject().put("base64String", inputBase64), "POST");
            return output.getJSONObject(0).getString("path");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Deprecated
    public String uploadImage (Object inputObject) {
    	/* try {
            HashMap <String, Object> temp = new HashMap <String,Object>();
            temp.put("image",inputImage);
            JSONArray output = doQuery("PASS", "images", new JSONObject(), temp, "POST");
            return output.getJSONObject(0).getString("path");
        } catch (Exception e) {
            System.out.println(e);
        } */
    	return null;
    }
    
    public RecoveryEmail resendRecoveryEmail (RecoveryEmail inputRecoveryEmail) {
        try {
            Object[] inputObject = {RecoveryEmailToJSONObject(inputRecoveryEmail)};
            JSONArray outputJSONArray = doQuery("PASS", "recoveryEmails/resend", inputObject, "PUT");
            return JSONArrayToRecoveryEmail(outputJSONArray);
        } catch (Exception e) {System.out.println(e);}
        return null;
    }

    public RecoveryEmail[] resendRecoveryEmail (RecoveryEmail[] inputRecoveryEmail) {
        try {
            int count = inputRecoveryEmail.length;
            Object[] inputObject = new Object[count];
            for (int i = 0; i<count; i++) {
                inputObject[i] = RecoveryEmailToJSONObject(inputRecoveryEmail[i]);
            }
            JSONArray outputJSONArray = doQuery("PASS", "recoveryEmails/resend", inputObject, "PUT");
            return JSONArrayToRecoveryEmailArray(outputJSONArray);
        } catch (Exception e) {System.out.println(e);}
        return null;
    }

    private Campaign JSONArrayToCampaign (JSONArray inputJSONArray) {
        
        return new Campaign(inputJSONArray.getJSONObject(0));
    }

    private Campaign[] JSONArrayToCampaignArray (JSONArray inputJSONArray) {
        int inputJSONArraySize = inputJSONArray.length();
        Campaign[] campaignArray = new Campaign[inputJSONArraySize];
        for (int i=0; i<inputJSONArraySize; i++) {
            JSONObject temp = inputJSONArray.getJSONObject(i);
            campaignArray[i] = new Campaign(temp);
        }
        return campaignArray;
    }

    private Template JSONArrayToTemplate (JSONArray inputJSONArray) {
        
        return new Template(inputJSONArray.getJSONObject(0));
    }

    private Template[] JSONArrayToTemplateArray (JSONArray inputJSONArray) {
        int inputJSONArraySize = inputJSONArray.length();
        Template[] templateArray = new Template[inputJSONArraySize];
        for (int i=0; i<inputJSONArraySize; i++) {
            JSONObject temp = inputJSONArray.getJSONObject(i);
            templateArray[i] = new Template(temp);
        }
        return templateArray;
    }

    private Pass JSONArrayToPass (JSONArray inputJSONArray) {
        
        return new Pass(inputJSONArray.getJSONObject(0));
    }

    private Pass[] JSONArrayToPassArray (JSONArray inputJSONArray) {
        int inputJSONArraySize = inputJSONArray.length();
        Pass[] PassArray = new Pass[inputJSONArraySize];
        for (int i=0; i<inputJSONArraySize; i++) {
            JSONObject temp = inputJSONArray.getJSONObject(i);
            PassArray[i] = new Pass(temp);
        }
        return PassArray;
    }

    private RecoveryEmail JSONArrayToRecoveryEmail (JSONArray inputJSONArray) {
        
        return new RecoveryEmail(inputJSONArray.getJSONObject(0));
    }

    private RecoveryEmail[] JSONArrayToRecoveryEmailArray (JSONArray inputJSONArray) {
        int inputJSONArraySize = inputJSONArray.length();
        RecoveryEmail[] RecoveryEmailArray = new RecoveryEmail[inputJSONArraySize];
        for (int i=0; i<inputJSONArraySize; i++) {
            JSONObject temp = inputJSONArray.getJSONObject(i);
            RecoveryEmailArray[i] = new RecoveryEmail(temp);
        }
        return RecoveryEmailArray;
    }

    public JSONObject CampaignToJSONObject (Campaign inputCampaign) {
        try { 
            String outputJSONObjectInString = ((new ObjectMapper()).setSerializationInclusion(JsonInclude.Include.NON_NULL)).writeValueAsString(inputCampaign);
            JSONObject outputJSONObject = new JSONObject(outputJSONObjectInString);
            return outputJSONObject;
        } catch (Exception e) { System.out.println(e); }
        return null;
    }

    public JSONObject TemplateToJSONObject (Template inputTemplate) {
        try { 
            String outputJSONObjectInString = ((new ObjectMapper()).setSerializationInclusion(JsonInclude.Include.NON_NULL)).writeValueAsString(inputTemplate);
            JSONObject outputJSONObject = new JSONObject(outputJSONObjectInString);
            return outputJSONObject;
        } catch (Exception e) { System.out.println(e); }
        return null;
    }

    public JSONObject PassToJSONObject (Pass inputPass) {
        try { 
            String outputJSONObjectInString = ((new ObjectMapper()).setSerializationInclusion(JsonInclude.Include.NON_NULL)).writeValueAsString(inputPass);
            JSONObject outputJSONObject = new JSONObject(outputJSONObjectInString);
            return outputJSONObject;
        } catch (Exception e) { System.out.println(e); }
        return null;
    }

    public JSONObject PassArrayToJSONObject (Pass[] inputPasses) {
        try {
            JSONArray output = new JSONArray();
            int numberOfPasses = inputPasses.length;
            for (int i = 0; i < numberOfPasses; i++) {
                output.put(PassToJSONObject(inputPasses[i]));
            }
            return (new JSONObject()).put("passes",output);
        } catch (Exception e) {System.out.println(e);}
        return null;
    }

    public JSONObject RecoveryEmailToJSONObject (RecoveryEmail inputRecoveryEmail) {
        try { 
            String outputJSONObjectInString = ((new ObjectMapper()).setSerializationInclusion(JsonInclude.Include.NON_NULL)).writeValueAsString(inputRecoveryEmail);
            JSONObject outputJSONObject = new JSONObject(outputJSONObjectInString);
            return outputJSONObject;
        } catch (Exception e) { System.out.println(e); }
        return null;
    }

    public JSONObject SearchToJSONObject (Search inputSearch) {
        try { 
            String outputJSONObjectInString = ((new ObjectMapper()).setSerializationInclusion(JsonInclude.Include.NON_NULL)).writeValueAsString(inputSearch);
            JSONObject outputJSONObject = new JSONObject(outputJSONObjectInString);
            return outputJSONObject;
        } catch (Exception e) { System.out.println(e); }
        return null;
    }

}