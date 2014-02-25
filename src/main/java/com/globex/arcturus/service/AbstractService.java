package com.globex.arcturus.service;

import com.globex.arcturus.domain.helper.Link;
import com.globex.arcturus.domain.helper.Linkable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/25/14
 */
public abstract class AbstractService {


    @Autowired
    private ServletContext context;

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public void addSelf(Linkable entity) {
        Link selfLink = new Link();
        selfLink.setUrl(getSelfURL(entity));
        selfLink.setRel("self");
        entity.setSelf(selfLink);
    }

    public abstract String getSelfURL(Linkable entity);
}
