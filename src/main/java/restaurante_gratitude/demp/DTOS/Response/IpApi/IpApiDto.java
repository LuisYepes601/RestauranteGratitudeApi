/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Response.IpApi;

import restaurante_gratitude.demp.Service.ServiceImplement.ConcumoDeApis.IpApiService.TimezoneDto;



/**
 *
 * @author Usuario
 */
public class IpApiDto {

    private String city;
    private String region;
    private String country;
    private TimezoneDto timezone;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TimezoneDto getTimezone() {
        return timezone;
    }

    public void setTimezone(TimezoneDto timezone) {
        this.timezone = timezone;
    }

    
}
