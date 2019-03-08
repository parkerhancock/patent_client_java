package patent;

import org.json.JSONObject;

import java.time.LocalDateTime;

public class PtabDocument {
    /* Example
      "trialNumber": "IPR2016-00831",
      "sizeInBytes": 3226184,
      "filingParty": "petitioner",
      "filingDatetime": "2016-04-01T15:59:39",
      "lastModifiedDatetime": "2016-04-06T13:50:24",
      "documentNumber": "1009",
      "title": "U.S. Provisional Application No. 60/046,276",
      "mediaType": "application/pdf",
      "id": 230910,
      "type": "exhibit",

     */
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


    public PtabDocument(JSONObject data) {
        trialNumber = data.getString("trialNumber");
        sizeInBytes = data.getInt("sizeInBytes");
        filingParty = data.getString("filingParty");
        filingDateTime = LocalDateTime.parse(data.getString("filingDatetime"));
        lastModifiedDateTime = LocalDateTime.parse(data.getString("lastModifiedDatetime"));
        documentNumber = data.getString("documentNumber");
        title = data.getString("title");
        mediaType = data.getString("mediaType");
        id = data.getInt("id");
        type = data.getString("type");
    }
}
