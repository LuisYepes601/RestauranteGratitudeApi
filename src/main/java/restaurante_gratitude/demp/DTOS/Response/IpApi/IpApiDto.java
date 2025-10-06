/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Response.IpApi;

/**
 *
 * @author Usuario
 */
public class IpApiDto {

    private String city;
    private String region;
    private String country_name;
    private String timezone;

    public IpApiDto(String city, String region, String country_name, String timezone) {
        this.city = city;
        this.region = region;
        this.country_name = country_name;
        this.timezone = timezone;
    }

    public IpApiDto() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
