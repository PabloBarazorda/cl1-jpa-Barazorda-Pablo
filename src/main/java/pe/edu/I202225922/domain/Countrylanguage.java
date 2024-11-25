package pe.edu.I202225922.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
@IdClass(CountrylanguageId.class)

public class Countrylanguage {
    @Id
    private String countryCode;
    @Id
    private String language;

    private String isOfficial;
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "countryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;

    public Countrylanguage() {
    }

    public Countrylanguage(String countryCode) {
        this.countryCode = countryCode;
    }

    public Countrylanguage(String countryCode, String language, String isOfficial, Double percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Countrylanguage{" +
                "countryCode='" + countryCode + '\'' +
                ", language='" + language + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
