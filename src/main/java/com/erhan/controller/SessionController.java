package com.erhan.controller;

import com.erhan.dao.ProjeDao;
import com.erhan.model.Kullanici;
import com.erhan.util.Mesajlar;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    private boolean devemEtKontrol;

    public String giris() {
        String result = null;
        try {

            Kullanici kullanici = projeDao.getirKullaniciTCyeGore("26281460234");
            System.out.println(kullanici.getAdi());
            loggedIn=true;

            if (devemEtKontrol) {
                devemEtKontrol = false;
                return FacesContext.getCurrentInstance().getViewRoot().getViewId();
            } else {
                result = NavigationController.toAnasayfa();
            }

        } catch (Exception e) {
            Mesajlar.hataVer("Giriş işleminde hata oluştu.");
        }
        return result;
    }

    public String cikis() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            System.gc();
            return NavigationController.toIndex();
        } catch (Exception e) {
            Mesajlar.hataVer("Çıkış işleminde hata oluştu.");
            return null;
        }
    }

    public void devamEt() {
        try {
            devemEtKontrol = true;
            giris();
        } catch (Exception e) {
            Mesajlar.hataVer("Oturuma devam etme işleminde hata oluştu");
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isDevemEtKontrol() {
        return devemEtKontrol;
    }

    public void setDevemEtKontrol(boolean devemEtKontrol) {
        this.devemEtKontrol = devemEtKontrol;
    }

}
