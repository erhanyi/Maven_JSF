package com.erhan.controller;

import com.erhan.dao.ProjeDao;
import com.erhan.model.Kullanici;
import com.erhan.util.MessagesController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author erhan
 */
@Named
@SessionScoped
public class SessionController implements Serializable {
    
    @Inject
    private ProjeDao projeDao;
    
    private boolean loggedIn;
    
    public String giris() {
        String result = null;
        try {
            
            Kullanici kullanici=projeDao.getirKullaniciTCyeGore("26281460234");
            System.out.println(kullanici.getAdi());
            
        } catch (Exception e) {
            MessagesController.hataVer("Kullanıcı kontrol edilirken hata oluştu");
        }
        return result;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
}
