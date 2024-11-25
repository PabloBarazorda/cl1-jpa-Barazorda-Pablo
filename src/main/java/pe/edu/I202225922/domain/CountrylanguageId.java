package pe.edu.I202225922.domain;

import java.io.Serializable;
import java.util.Objects;

public class CountrylanguageId implements Serializable {

    private String countryCode;
    private String language;

    // Getters, Setters, equals(), and hashCode() methods

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountrylanguageId that = (CountrylanguageId) o;
        return Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language);
    }

}
