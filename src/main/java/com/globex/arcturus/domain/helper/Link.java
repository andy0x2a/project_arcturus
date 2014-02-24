package com.globex.arcturus.domain.helper;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/24/14
 */
public class Link implements Serializable{

    private String url;
    private String href;
    private String rel;
    private String type;

    public Link() {}

    public Link(String url, String href, String rel, String type) {
        this.url = url;
        this.href = href;
        this.rel = rel;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public Link setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getHref() {
        return href;
    }

    public Link setHref(String href) {
        this.href = href;
        return this;
    }

    public String getRel() {
        return rel;
    }

    public Link setRel(String rel) {
        this.rel = rel;
        return this;
    }

    public String getType() {
        return type;
    }

    public Link setType(String type) {
        this.type = type;
        return this;
    }
}
