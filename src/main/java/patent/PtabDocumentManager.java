package patent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;

public class PtabDocumentManager {

    public static PtabDocument[] filter (String field, String query) throws Exception {
        HttpResponse<JsonNode> response = Unirest.get("https://ptabdata.uspto.gov/ptab-api/documents")
                .queryString(field, query)
                .asJson();
        JSONArray data = response.getBody().getObject().getJSONArray("results");
        PtabDocument [] output = new PtabDocument[data.length()];
        for (int i = 0; i < data.length(); i++) {
            output[i] = new PtabDocument(data.getJSONObject(i));
        }
        return output;
    }

    public static PtabDocument[] filter (String query) throws Exception {
        return filter("trialNumber", query);
    }

}
