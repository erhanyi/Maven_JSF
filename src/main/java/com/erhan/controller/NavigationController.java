package com.erhan.controller;

import java.io.Serializable;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author erhan
 */
@Named
@RequestScoped
public class NavigationController implements Serializable {

    public static String toIndex() {
        return "/index.xhtml?faces-redirect=true";
    }

    public static String toAnasayfa() {
        return "/secured/anasayfa.xhtml?faces-redirect=true";
    }
}
