package pwr.swd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Patryk on 04.05.2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    //protected Copyright copyright;
    @JsonProperty("statuscode")
    protected Integer statusCode;
    protected String[] messages;

    public Info() {
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

}
