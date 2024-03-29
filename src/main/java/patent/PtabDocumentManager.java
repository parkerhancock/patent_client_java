package patent;


import java.util.HashMap;

public class PtabDocumentManager extends PtabManager implements Manager<PtabDocument> {
    public static String defaultQuery = "trialNumber";
    String docType = "documents";

    public PtabDocumentManager(HashMap<String, String> query_params) {
        params = query_params;
    }

    public PtabDocumentManager() {
        this(new HashMap<String,String>());
    }

    public PtabDocument next() {
        return new PtabDocument(nextJson(docType));
    }

    public boolean hasNext() {
        return position < length();
    }

    public PtabDocumentManager filter(String field, String query) {
        HashMap<String, String> new_params = (HashMap)params.clone();
        new_params.put(field, query);
        return new PtabDocumentManager(new_params);
    }

    public PtabDocument get (String field, String query) {
        PtabDocumentManager new_manager = filter(field, query);
        if (new_manager.length() != 1) {
            throw new IndexOutOfBoundsException(String.format("Found %s Records!", length()));
        }
        return new_manager.next();
    }

    public PtabDocument get (String query) {
        return get(defaultQuery, query);
    }

    public PtabDocumentManager filter(String query) {
        return filter(defaultQuery, query);
    }

    public int length() {
        return super.length(docType);
    }


}

