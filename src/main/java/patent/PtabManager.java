package patent;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import org.json.JSONArray;

public class PtabManager {
    public static PtabTrial get (String field, String query) { return filter(field, query)[0]; }

    public static PtabTrial get (String query) {
        return get("trialNumber", query);
    }

    public static PtabTrial[] filter (String field, String query) {
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://ptabdata.uspto.gov/ptab-api/trials")
                    .queryString(field, query)
                    .asJson();
            JSONArray data = response.getBody().getObject().getJSONArray("results");
            PtabTrial [] output = new PtabTrial[data.length()];
            for (int i = 0; i < data.length(); i++) {
                output[i] = new PtabTrial(data.getJSONObject(i));
            }
            return output;
        } catch (java.lang.Exception e) {
            System.out.println("Error!");
        }
        return null;
    }


}
