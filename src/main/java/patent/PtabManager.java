package patent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class PtabManager {
    HashMap<String, String> params;
    HashMap<Integer, JSONObject> pages = new HashMap<Integer, JSONObject>();
    int pageSize = 25;
    int position = 0;
    public static final String baseUrl = "https://ptabdata.uspto.gov/ptab-api/";


    public JSONObject nextJson(String docType) {
        if (position >= length(docType)) {
            throw new NoSuchElementException();
        }
        int page = (int)Math.floor(position / pageSize);
        int offset = position % pageSize;
        position++;
        return getPage(page, docType).getJSONArray("results").getJSONObject(offset);
    }

    private JSONObject getPage(int pageNumber, String docType) {
        if (pages.containsKey(pageNumber)) {
            return pages.get(pageNumber);
        }

        try {
            params.put("offset", Integer.toString(pageNumber * pageSize));
            HttpResponse<JsonNode> response = Unirest.get(baseUrl + docType)
                    .queryString((Map) params)
                    .asJson();
            return response.getBody().getObject();
        } catch (Exception e) {
            System.out.println("An Error Occured!" + e + e.getCause() + e.getStackTrace());
            return null;
        }
    }

    public int length (String docType) {
        return getPage(0, docType).getJSONObject("metadata").getInt("count");
    }
}