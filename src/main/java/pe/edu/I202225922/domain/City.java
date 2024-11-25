package pe.edu.I202225922.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "city")

public class City {

    @Id
    private Double ID;
    private String Name;
    private String CountryCode;
    private String District;
    private Double Population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;

    // Constructores, getters y setters...

    public City() {
    }

    public City(Double ID) {
        this.ID = ID;
    }

    public City(Double ID, String name, String countryCode, String district, Double population) {
        this.ID = ID;
        Name = name;
        CountryCode = countryCode;
        District = district;
        Population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }

    public Double getID() {
        return ID;
    }

    public void setID(Double ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public Double getPopulation() {
        return Population;
    }

    public void setPopulation(Double population) {
        Population = population;
    }
}