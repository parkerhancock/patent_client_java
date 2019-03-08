package patent;

import java.util.HashMap;

public class PtabTrialManager extends PtabManager implements Manager<PtabTrial> {
    public static String defaultQuery = "trialNumber";
    String docType = "trials";

    public PtabTrialManager(HashMap<String, String> query_params) {
        params = query_params;
    }

    public PtabTrialManager() {
        this(new HashMap<String,String>());
    }

    public PtabTrial next() {
        return new PtabTrial(nextJson(docType));
    }

    public boolean hasNext() {
        return position < length();
    }

    public PtabTrialManager filter(String field, String query) {
        HashMap<String, String> new_params = (HashMap)params.clone();
        new_params.put(field, query);
        return new PtabTrialManager(new_params);
    }

    public PtabTrial get (String field, String query) {
        PtabTrialManager new_manager = filter(field, query);
        if (new_manager.length() != 1) {
            throw new IndexOutOfBoundsException(String.format("Found %s Records!", length()));
        }
        return new_manager.next();
    }

    public PtabTrial get (String query) {
        return get(defaultQuery, query);
    }

    public PtabTrialManager filter(String query) {
        return filter(defaultQuery, query);
    }

    public int length() {
        return super.length(docType);
    }
}
