package com.erhan.controller;

import com.erhan.dao.ProjeDao;
import com.erhan.model.DersPuan;
import com.erhan.model.Kullanici;
import com.erhan.model.Okulders;
import com.erhan.model.Puan;
import com.erhan.model.Sinavpuan;
import com.erhan.util.Mesajlar;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
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

    private List<Okulders> dersList;
    private List<Puan> puanList;
    private List<String> columns;
    private Map<String, BigDecimal> data;

    public String giris() {
        String result = null;
        try {

            Kullanici kullanici = projeDao.getirKullaniciIdyeGore(1);
            Kullanici kullanici1 = projeDao.getirKullaniciArabaListesi(1);
            System.out.println(kullanici.getAdi());
            loggedIn = true;

            dersList = projeDao.getirDersListesi(1);
            List<Puan> puanListesi = projeDao.getirPuanListesi(1);

            columns = new ArrayList<>();

            if (puanListesi != null && !puanListesi.isEmpty()) {
                columns = puanListesi.stream().map(p -> p.getSinavadi())
                        .distinct().sorted()
                        .collect(Collectors.toList());

                if (dersList != null && !dersList.isEmpty()) {
                    for (Okulders ders : dersList) {
                        ders.setSinavPuanData(new LinkedHashMap<String, BigDecimal>());

                        List<Puan> pList = puanListesi.stream()
                                .filter(p -> Objects.equals(p.getDersid(), ders.getDersid()))
                                .collect(Collectors.toList());
                        ders.setDersSinavPuanListesi(pList);

                        for (Puan puan : pList) {
                            ders.getSinavPuanData().put(puan.getSinavadi(), puan.getPuan());
                        }
                    }
                }

            }

//            puanList = projeDao.getirPuanListesi(1);
//
//            data = new LinkedHashMap<>();
//
//            columns = puanList.stream().map(e -> e.getSINAVADI())
//                    .distinct().sorted()
//                    .collect(Collectors.toList());
//
//            for (Puan puan : puanList) {
////                columns.add(puan.getSINAVADI());                
//                data.put(puan.getSINAVADI(), new BigDecimal(BigInteger.ONE));
//                puan.setData(data);
//            }
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

    public void kaydetPuan() {
        try {
            
            List<Sinavpuan> sinavpuanList=new ArrayList<>();

            for (Okulders ders : dersList) {

                for (Map.Entry<String, BigDecimal> entry : ders.getSinavPuanData().entrySet()) {
                    String key = entry.getKey();
                    if (!String.valueOf(entry.getValue()).equals("")) {
                        BigDecimal value =new BigDecimal(String.valueOf(entry.getValue()));
                        System.out.println(key+" - "+ value);
                        
                        Puan puan=ders.getDersSinavPuanListesi().stream()
                                .filter(p -> Objects.equals(p.getSinavadi(), key))
                                .findAny()
                                .orElse(null);
                        
                        Sinavpuan sinavpuan=new Sinavpuan();
                        sinavpuan.setDers(ders.getDersadi());
                        sinavpuan.setPuan(value);
                        sinavpuan.setOkulsinavid(puan.getOkulsinavid());
                        sinavpuan.setSinavpuanid(puan.getSinavpuanid());                        
                        sinavpuanList.add(sinavpuan);
                    }                 
                }
            }
            
            if (!sinavpuanList.isEmpty()) {
                projeDao.kaydetVeyaGuncelleSinavPuanList(sinavpuanList);
            }

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

    public ProjeDao getProjeDao() {
        return projeDao;
    }

    public void setProjeDao(ProjeDao projeDao) {
        this.projeDao = projeDao;
    }

    public List<Puan> getPuanList() {
        return puanList;
    }

    public void setPuanList(List<Puan> puanList) {
        this.puanList = puanList;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public Map<String, BigDecimal> getData() {
        return data;
    }

    public void setData(Map<String, BigDecimal> data) {
        this.data = data;
    }

    public List<Okulders> getDersList() {
        return dersList;
    }

    public void setDersList(List<Okulders> dersList) {
        this.dersList = dersList;
    }

}
