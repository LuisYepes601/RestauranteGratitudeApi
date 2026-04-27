/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.ConcumoDeApis.IpApiService;

import org.eclipse.angus.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import restaurante_gratitude.demp.DTOS.Response.IpApi.IpApiDto;

/**
 *
 * @author Usuario
 */
@Service
public class IpApiService {

    @Autowired
    private RestTemplate restTemplate;

    public IpApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public IpApiDto getDatos(String ip) {

        IpApiDto response = restTemplate
                .getForObject("https://ipwho.is/" + ip,
                        IpApiDto.class);

        return response;

    }
}
