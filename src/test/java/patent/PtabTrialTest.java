package patent;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PtabTrialTest {

    @Test
    public void getByTrialNumber () {
        PtabTrial trial = PtabTrial.objects.get("IPR2016-00831");
        assertEquals(trial.trialNumber, "IPR2016-00831");
        assertEquals(LocalDate.of(2016,4,1), trial.filingDate);
    }

    @Test
    public void filterByTrialNumber () {
        PtabTrial[] trials = PtabTrial.objects.filter("trialNumber", "IPR2016-00833");
        assertEquals(1, trials.length);
        assertEquals("6103599", trials[0].patentNumber);
    }

    @Test
    public void getDocumentsFromTrial () throws Exception {
        PtabTrial trial = PtabTrial.objects.get("IPR2016-00831");
        PtabDocument[] documents = trial.getDocuments();
        assertEquals(25, documents.length);

    }

}