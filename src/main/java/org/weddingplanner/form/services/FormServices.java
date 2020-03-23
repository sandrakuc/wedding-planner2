package org.weddingplanner.form.services;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.weddingplanner.form.cities.City;
import org.weddingplanner.form.cities.CityDao;
import org.weddingplanner.form.cities.model.CityEntityToCityModelConverter;
import org.weddingplanner.form.cities.model.CityModel;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.form.provinces.Province;
import org.weddingplanner.form.provinces.ProvinceDao;
import org.weddingplanner.form.provinces.model.ProvinceEntityToProvinceModelConverter;
import org.weddingplanner.form.provinces.model.ProvinceModel;
import org.weddingplanner.form.weddingservicesfilter.WeddingServicesFilter;
import org.weddingplanner.form.weddingservicesfilter.WeddingServicesWrapper;
import org.weddingplanner.form.weddingservicesset.WeddingServicesSet;
import org.weddingplanner.form.weddingservicesset.WeddingServicesSetSelector;
import org.weddingplanner.form.weddingvenues.Church;
import org.weddingplanner.form.weddingvenues.ChurchDao;
import org.weddingplanner.form.weddingvenues.RegistryOffice;
import org.weddingplanner.form.weddingvenues.RegistryOfficeDao;
import org.weddingplanner.form.weddingvenues.model.ChurchEntityToWeddingVenueModelConverter;
import org.weddingplanner.form.weddingvenues.model.RegistryOfficeEntityToWeddingVenueModelConverter;
import org.weddingplanner.form.weddingvenues.model.WeddingVenueModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormServices {

    @Autowired
    ProvinceDao provinceDao;

    @Autowired
    CityDao cityDao;

    @Autowired
    ChurchDao churchDao;

    @Autowired
    RegistryOfficeDao registryOfficeDao;

    private List<ProvinceModel> getProvinceModels(List<Province> provinces){
        ProvinceEntityToProvinceModelConverter converter = new ProvinceEntityToProvinceModelConverter();
        return converter.convertList(provinces);
    }

    private List<CityModel> getCityModels(List<City> cities){
        CityEntityToCityModelConverter converter = new CityEntityToCityModelConverter();
        return converter.convertList(cities);
    }

    private List<WeddingVenueModel> getChurchWeddingVenueModels(List<Church> churches){
        ChurchEntityToWeddingVenueModelConverter converter = new ChurchEntityToWeddingVenueModelConverter();
        return converter.convertList(churches);
    }

    private List<WeddingVenueModel> getRegistryOfficeVenueModels(List<RegistryOffice> registryOffices){
        RegistryOfficeEntityToWeddingVenueModelConverter converter = new RegistryOfficeEntityToWeddingVenueModelConverter();
        return converter.convert(registryOffices);
    }

    @GetMapping(path = "/provinces", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProvinceModel> getWeddingProvincesList() throws SQLException {
        List<Province> provinces = provinceDao.getProvinceList();
        List<ProvinceModel> provinceModels = getProvinceModels(provinces);
        return provinceModels;
    }

    @GetMapping(path = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityModel> getWeddingCitiesList() throws SQLException{
        List<City> cities = cityDao.getCitiesList();
        List<CityModel> cityModels = getCityModels(cities);
        return cityModels;
    }

    @GetMapping(path = "/wedding-venues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeddingVenueModel> getWeddingVenuesList() throws SQLException{
        List<WeddingVenueModel> weddingVenueModels = new ArrayList<>();
        List<Church> churches = churchDao.getChurchesList();
        List<WeddingVenueModel> churchVenueModels = getChurchWeddingVenueModels(churches);
        List<RegistryOffice> registryOffices = registryOfficeDao.getRegistryOffices();
        List<WeddingVenueModel> registryOfficeVenueModels = getRegistryOfficeVenueModels(registryOffices);
        if(churchVenueModels != null && !churchVenueModels.isEmpty()){
            weddingVenueModels.addAll(churchVenueModels);
        }
        if(registryOfficeVenueModels != null && !registryOffices.isEmpty()){
            weddingVenueModels.addAll(registryOfficeVenueModels);
        }
        return weddingVenueModels;
    }

    @PostMapping(path = "/get-results", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeddingServicesSet> getResults(@RequestBody InputDataForm inputDataForm) throws IOException {
        List<WeddingServicesSet> weddingServicesSets = WeddingServicesSetSelector.createServicesSetByDesertIslandRule(inputDataForm);
        return weddingServicesSets;
    }
}
