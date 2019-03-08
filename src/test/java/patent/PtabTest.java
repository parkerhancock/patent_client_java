package patent;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PtabTest {

    @Test
    public void getByTrialNumber () throws Exception {
        /*
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

        PtabTrial trial = PtabTrial.objects.get("IPR2016-00831");
        assertEquals("IPR2016-00831", trial.trialNumber);
        assertEquals("09026118", trial.applicationNumber);
        assertEquals("6162705", trial.patentNumber);
        assertEquals("Commissariat a l’Energie Atomique et aux Energies Alternatives", trial.petitionerPartyName);
        assertEquals(LocalDate.of(2016,4,1), trial.filingDate);
    }

    @Test
    public void filterByTrialNumber () {
        PtabTrialManager trials = PtabTrial.objects.filter("trialNumber", "IPR2016-00833");
        assertEquals(1, trials.length());
        assertEquals("6103599", trials.next().patentNumber);
    }

    @Test
    public void getDocumentsFromTrial () throws Exception {
        PtabTrial trial = PtabTrial.objects.get("IPR2016-00831");
        PtabDocumentManager documents = trial.getDocuments();
        assertEquals(82, documents.length());
    }

    @Test
    public void getDocument() {
        PtabDocument doc = PtabDocument.objects.get("id", "230910");
        assertEquals("IPR2016-00831", doc.trialNumber);
        assertEquals(3226184, doc.sizeInBytes);
        assertEquals("1009", doc.documentNumber);
        assertEquals("U.S. Provisional Application No. 60/046,276", doc.title);
    }

}