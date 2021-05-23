package cz.czechitas.java2webapps.ukol7.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Vizitka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String celeJmeno;

    @NotBlank
    @Length(max = 100)
    private String firma;

    @NotBlank
    @Length(max = 100)
    private String ulice;

    @NotBlank
    @Length(max = 100)
    private String obec;

    @NotBlank
    @Length(min = 4, max= 5)  // existuju PSC  4 miestne napriklad v AT
    private String psc;

    @Email
    @Length(max = 100)
    private String email;

    @Length(min = 9, max = 20)
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    @Length(max = 100)
    private String web;


    private String celaAdresa;

    public Vizitka() {
    }

    public Vizitka(Integer id, String celeJmeno,  String firma, String ulice,
                   String obec, String psc,  String email,   String telefon,  String web) {
        this.id = id;
        this.celeJmeno = celeJmeno;
        this.firma = firma;
        this.ulice = ulice;
        this.obec = obec;
        this.psc = psc;
        this.email = email;
        this.telefon = telefon;
        this.web = web;
        this.celaAdresa= ulice+ " " +psc + " "+ obec;
    }

    public String getCelaAdresa() {
         if (celaAdresa != null) {
            return celaAdresa;
        }
        celaAdresa= ulice+ " " +psc + " "+ obec;
       return  celaAdresa;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
