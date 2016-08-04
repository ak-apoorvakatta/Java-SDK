package passkitSDK;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchResult {
	public Integer nextFrom = null;
	public Integer totalCount = null;
	public Pass[] data = null;

	public SearchResult (JSONObject inputJSONObject) {
		try { this.nextFrom = inputJSONObject.getInt("nextFrom"); } catch (Exception e) {}
		try { this.totalCount = inputJSONObject.getInt("totalCount"); } catch (Exception e) {}
		
		try {
			JSONArray passData = inputJSONObject.getJSONArray("data");
			this.data = new Pass[passData.length()];
			int count = data.length;
			for (int i = 0; i < count; i++) {
				this.data[i] = new Pass(passData.getJSONObject(i));
			}
		} catch (Exception e) {}
	}

}