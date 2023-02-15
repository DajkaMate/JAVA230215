/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm.nobeldijak;

public class nobeldijak_adatok {
    private int evszam;
    private String tipus;
    private String knev;
    private String vnev;                                                                                           
    public nobeldijak_adatok(int evszam, String tipus, String knev, String vnev){
        this.evszam = evszam;
        this.tipus = tipus;
        this.knev = knev;
        this.vnev = vnev;
    }
    
    public int getevszam() {
        return evszam;
    }

    public String gettipus() {
        return tipus;
    }

    public String getknev() {
        return knev;
    }

    public String getvnev() {
        return vnev;
    }
}
