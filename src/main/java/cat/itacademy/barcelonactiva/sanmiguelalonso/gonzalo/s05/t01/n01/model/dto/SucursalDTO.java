package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.CountriesModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SucursalDTO implements Serializable {

    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    private List<CountriesModel> countriesList = new ArrayList<>();

    private final String IN = "UE", OUT = "Fora UE";
    private List<String> countries =
            new ArrayList<>(List.of(
                    "Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic",
                    "Denmark", "Estonia", "Finland", "France", "Germany", "Greece",
                    "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg",
                    "Malta", "Netherlands", "Poland", "Portugal", "Romania", "San Marino",
                    "Slovakia", "Slovenia", "Spain", "Sweden", "Vatican City"));

    public SucursalDTO() {
    }

    /* Getters & Setters */

    public List<CountriesModel> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<CountriesModel> countriesList) {
        this.countriesList = countriesList;
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }


    // Getting results from list of EU countries
    public String getTipusSucursal() {

        for (String country : getPaïsos()) {
            if (this.paisSucursal.equals(country)) {

                return IN;
            }
        }

        return OUT;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    public List<String> getPaïsos() {
        return countries;
    }

    public void setPaïsos(List<String> països) {
        this.countries = països;
    }


}
