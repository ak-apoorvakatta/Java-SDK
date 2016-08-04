package passkitSDK;

import java.util.*;

import javax.net.ssl.SSLContext;

import org.json.JSONArray;
import org.json.JSONObject;

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
    /**
     * PassKit Account API Key.
     */
    private String apiKey;

    /**
     * PassKit Account API Secret.
     */
    private String apiSecret;

    /**
     * URL of the webservices.
     */
    private String apiPassUrl = "https://api-pass.passkit.net";
    private String apiSearchUrl = "https://search.passkit.net";

    /**
     * Core version of the webservices.
     */
    private String apiPassVersion = "v2";
    private String apiSearchVersion = "v1";

    public PassKit () {
    }

    /**
     * Default constructor.
     * @param apiKey API key to use.
     * @param apiSecret API secret to use.
     */
    public PassKit (String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    /**
     * Performs the given query on the PassKit webservice - used for GET and PUT request
     * @param apiMode user choice of the request mode, pass or search
     * @param path endpoint of the method/
     * @param requestType type of HTTP request.
     * @return a JSON representation of the API response.
     */
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
            String jwt = this.createJWT();

            // Set request headers.
            // Note that for the Authorization, the format is: "PKAuth + space + JWT"
            Map <String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "PKAuth " + jwt);
            headers.put("Content-Type", "application/json");

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

    /**
     * Performs the given query on the PassKit webservice - used for PUT and POST request
     * @param apiMode user choice of the request mode, pass or search
     * @param path endpoint of the method/
     * @param data data to be posted.
     * @param requestType type of HTTP request.
     * @return a JSON representation of the API response.
     */
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
            String jwt = this.createJWT();

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

    /**
     * Performs the given query on the PassKit webservice - used for single request
     * @param apiMode user choice of the request mode, pass or search
     * @param path endpoint of the method/
     * @param data data to be posted.
     * @param requestType type of HTTP request.
     * @return a JSON representation of the API response.
     */
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
            String jwt = this.createJWT();

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

    /**
     * Performs the given query on the PassKit webservice - used for PUT and POST request
     * @param apiMode user choice of the request mode, pass or search
     * @param path endpoint of the method/
     * @param data data to be posted.
     * @param requestType type of HTTP request.
     * @return a JSON representation of the API response.
     */
    private JSONArray doQuery (String apiMode, String path, JSONObject data, HashMap <String, Object> images, String requestType) throws InvalidInputException, ServerSideException {
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
            String jwt = this.createJWT();

            // Set request headers.
            // Note that for the Authorization, the format is: "PKAuth + space + JWT"
            Map <String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "PKAuth " + jwt);
            //headers.put("Content-Type", "application/json");
            //headers.put("Content-Type", "multipart/form-data");

            Map <String, Object> fields = new HashMap<String, Object>();
            fields.put("jsonBody",data.toString());
            fields.putAll(images);
        
            // Set empty response object
            HttpResponse<JsonNode> jsonResponse = null;

            // Check for request type, and do request accordingly
            if(requestType == "POST") {
            	jsonResponse = Unirest.post(url)
            		.headers(headers)
            		.fields(fields)
					.asJson();
			}
			else if (requestType == "PUT") {
				jsonResponse = Unirest.put(url)
					.headers(headers)
            		.fields(fields)
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
            //JSONArray object = null;

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
            System.out.println(e);
            throw new IllegalStateException("\nAn error occured while doing the API request.", e);
        }
    }

    /**
     * Generates the JWT for the request.
     *
     * JWT is signed with the api secret, and contains the qid, apiKey and expiry time in the claims section.
     *
     * @return String JWT
     */
    private String createJWT () {
        // The JWT signature algorithm we will be using to sign the token (HMAC using SHA-256)
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;

        // Add our claims
        Map <String, Object> cm = new HashMap<String, Object>();
        cm.put("key", this.apiKey);
        cm.put("exp", System.currentTimeMillis() + 60000); // expiry date 1 minute from now

        // set the claims
        String jwt = Jwts.builder().setHeaderParam("typ", "JWT")
                .setClaims(cm).signWith(sa, TextCodec.BASE64.encode(this.apiSecret)).compact();

        //System.out.println("JWT TOKEN: " + jwt);
        return jwt;
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

    public String createTemplate (Template inputTemplate, HashMap <String, Object> inputImages) {
        try {
            JSONObject inputJSONObject = TemplateToJSONObject(inputTemplate);
            JSONArray output = doQuery("PASS", "templates", inputJSONObject, inputImages, "POST");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public String updateTemplate (String templateName, Template inputTemplate, HashMap <String, Object> inputImages) {
        try {
            JSONObject inputJSONObject = TemplateToJSONObject(inputTemplate);
            JSONArray output = doQuery("PASS", "templates/"+templateName, inputJSONObject, inputImages, "PUT");
            return output.getJSONObject(0).getString("name");
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public String uploadImage (Object inputImage) {
        try {
            HashMap <String, Object> temp = new HashMap <String,Object>();
            temp.put("image",inputImage);
            JSONArray output = doQuery("PASS", "images", new JSONObject(), temp, "POST");
            return output.getJSONObject(0).getString("path");
        } catch (Exception e) {
            System.out.println(e);
        }
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