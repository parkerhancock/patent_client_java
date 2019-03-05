package patent;
import org.json.JSONObject;
import patent.PtabManager;

import java.time.LocalDate;

public class PtabTrial {
    public static PtabManager objects = new PtabManager();
    public String trialNumber;
    public String patentNumber;
    public LocalDate filingDate;

    public PtabTrial(JSONObject data) throws Exception {
        trialNumber = data.getString("trialNumber");
        patentNumber = data.getString("patentNumber");
        filingDate = LocalDate.parse(data.getString("filingDate"));
    }

    public PtabDocument [] getDocuments() throws Exception {
        return PtabDocument.objects.filter(trialNumber);
    }
}
