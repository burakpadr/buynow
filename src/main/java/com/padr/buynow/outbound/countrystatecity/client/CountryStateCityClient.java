package com.padr.buynow.outbound.countrystatecity.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.padr.buynow.outbound.countrystatecity.configuration.FeignClientConfiguration;
import com.padr.buynow.outbound.countrystatecity.model.CityResponse;
import com.padr.buynow.outbound.countrystatecity.model.CountryResponse;
import com.padr.buynow.outbound.countrystatecity.model.StateResponse;

@FeignClient(value = "countryStateCity", url = "https://api.countrystatecity.in/v1", configuration = FeignClientConfiguration.class)
public interface CountryStateCityClient {

    @GetMapping("/countries")
    public List<CountryResponse> getCountries();

    @GetMapping("/countries/{countryIso}/states")
    public List<StateResponse> getStatesByCountryIso(@PathVariable String countryIso);

    @GetMapping("/countries/{countryIso}/states/{stateIso}/cities")
    public List<CityResponse> getCitiesByCountryIsoAndStateIso(@PathVariable String countryIso, @PathVariable String stateIso);
}
