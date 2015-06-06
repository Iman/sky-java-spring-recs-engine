package com.sky.assignment.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "recommendation1")
public class Recommendation implements Serializable {

    @XmlElement
    public final String uuid;

    @XmlElement
    public final Long start;

    @XmlElement
    public final Long end;

    private Recommendation() {
        this(null, null, null);
    }

    public Recommendation(String uuid, Long start, Long end) {
        this.uuid = uuid;
        this.start = start;
        this.end = end;
    }
}
