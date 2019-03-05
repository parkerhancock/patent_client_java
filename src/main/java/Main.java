import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Main {
    public static void main(String [] args) {
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://httpbin.org/post")
                    .queryString("name", "Mark")
                    .field("last", "Polo")
                    .asJson();
            System.out.println(response.getBody());
        } catch (java.lang.Exception e) {
            System.out.println("Error!");
        }
    }
}
