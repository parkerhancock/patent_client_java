package patent;

import org.json.JSONObject;

import java.util.Iterator;

public interface Manager<Record> extends Iterator<Record> {
    int length();
    Record get(String field, String query);
    Record get(String query);
    Manager filter(String field, String query);
    Manager filter(String query);
}
