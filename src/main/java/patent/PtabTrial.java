package patent;

import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PtabTrial {
    /* Example Object
      "trialNumber": "IPR2016-00831",
      "applicationNumber": "09026118",
      "patentNumber": "6162705",
      "petitionerPartyName": "Commissariat a l’Energie Atomique et aux Energies Alternatives",
      "patentOwnerName": "Silicon Genesis Corporation",
      "inventorName": "FRANCOIS HENLEY",
      "prosecutionStatus": "Terminated-Settled",
      "filingDate": "2016-04-01",
      "accordedFilingDate": "2016-04-01",
      "institutionDecisionDate": "2016-09-28",
      "lastModifiedDatetime": "2017-07-06T16:06:59",
     */

    public static final PtabTrialManager objects = new PtabTrialManager();

    public final String trialNumber;
    public final String applicationNumber;
    public final String patentNumber;
    public final String petitionerPartyName;
    public final String patentOwnerName;
    public final String inventorName;
    public final String prosecutionStatus;
    public final LocalDate filingDate;
    public final LocalDate accordedFilingDate;
    public final LocalDate institutionDecisionDate;
    public final LocalDateTime lastModifiedDatetime;
    public final JSONObject data;


    public PtabTrial(JSONObject json_data) {
        data = json_data;
        trialNumber = json_data.getString("trialNumber");
        applicationNumber = data.getString("applicationNumber");
        patentNumber = data.getString("patentNumber");
        petitionerPartyName = data.getString("petitionerPartyName");
        patentOwnerName = data.getString("patentOwnerName");
        inventorName = data.getString("inventorName");
        prosecutionStatus = data.getString("prosecutionStatus");
        filingDate = LocalDate.parse(data.getString("filingDate"));
        accordedFilingDate = LocalDate.parse(data.getString("accordedFilingDate"));
        institutionDecisionDate= LocalDate.parse(data.getString("institutionDecisionDate"));
        lastModifiedDatetime = LocalDateTime.parse(data.getString("lastModifiedDatetime"));
    }


    public PtabDocumentManager getDocuments() throws Exception {
        return PtabDocument.objects.filter(this.trialNumber);
    }
}
