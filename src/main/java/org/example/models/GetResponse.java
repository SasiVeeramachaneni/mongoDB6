
package org.example.models;

import java.util.List;
import org.bson.Document;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class GetResponse {
    public List<Document> getResults() {
        return results;
    }

    public void setResults(List<Document> results) {
        this.results = results;
    }

    private List<Document> results;

}
