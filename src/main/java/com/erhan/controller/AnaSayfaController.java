package com.erhan.controller;

import com.erhan.dao.ProjeDao;
import com.erhan.util.Mesajlar;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author erhan
 *
 */
@Named
@ViewScoped
public class AnaSayfaController implements Serializable {

   @Inject
   private ProjeDao projeDao;

    @PostConstruct
    public void init() {
        try {
                         
           
        } catch (Exception e) {
            Mesajlar.hataVer("Ana sayfa getirilirken hata oluştu.");
        }
    }  

}
