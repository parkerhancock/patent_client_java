package patent;

import org.json.JSONObject;

import java.time.LocalDateTime;

public class PtabDocument {
    public static PtabDocumentManager objects = new PtabDocumentManager();

    public String trialNumber;
    public int sizeInBytes;
    public String filingParty;
    public LocalDateTime filingDateTime;
    public LocalDateTime lastModifiedDateTime;
    public String documentNumber;
    public String title;
    public String mediaType;
    public int id;
    public String type;
    public String download_url;


    public PtabDocument(JSONObject data) {
        trialNumber = data.getString("trialNumber");
        sizeInBytes = data.getInt("sizeInBytes");
        filingParty = data.getString("filingParty");
        filingDateTime = LocalDateTime.parse(data.getString("filingDatetime"));
        lastModifiedDateTime = LocalDateTime.parse(data.getString("lastModifiedDatetime"));
        title = data.getString("title");
    }

}
