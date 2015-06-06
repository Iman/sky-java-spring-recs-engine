package com.sky.assignment.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class Recommendations implements Serializable {

    public final List<Recommendation> recommendations;

    private Recommendations() {
        this(null);
    }

    public Recommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
