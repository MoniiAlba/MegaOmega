/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hca
 */
@XmlRootElement(name = "RecordResponse")
public class RecordResponse {
    private String status;
    private String message;

    public RecordResponse() {
    }

    public RecordResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement
    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
