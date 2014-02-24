package com.globex.arcturus.domain.helper;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/24/14
 */
public abstract class Linkable implements Serializable {


    @Transient
    private List<Link> links = new ArrayList<Link>(2);

    @Transient
    public abstract String getType();

    public List<Link> getLinks() {
        return links;
    }


    public void setLinks(List<Link> links) {
        this.links = links;
    }


    public void addLink(Link link) {
        links.add(link);
    }


}
