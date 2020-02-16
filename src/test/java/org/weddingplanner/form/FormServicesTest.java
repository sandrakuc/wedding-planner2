package org.weddingplanner.form;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.weddingplanner.form.cities.model.CityModel;
import org.weddingplanner.form.provinces.model.ProvinceModel;
import org.weddingplanner.form.weddingvenues.model.WeddingVenueModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormServicesTest extends AbstractTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getProvincesList() throws Exception {
        String uri = "/provinces";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ProvinceModel[] provinceList = super.mapFromJson(content, ProvinceModel[].class);
        assertTrue(provinceList.length > 0);
    }

    @Test
    public void getCitiesList() throws Exception {
        String uri = "/cities";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CityModel[] cityList = super.mapFromJson(content, CityModel[].class);
        assertTrue(cityList.length > 0);
    }

    @Test
    public void getWeddingVenuesList() throws Exception {
        String uri = "/wedding-venues";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        WeddingVenueModel[] weddingVenueList = super.mapFromJson(content, WeddingVenueModel[].class);
        assertTrue(weddingVenueList.length > 0);
        assertTrue(weddingVenueList[0].getName().contains("Parafia") || weddingVenueList[0].getName().contains("Urząd Stanu Cywilnego"));
        assertTrue(weddingVenueList[weddingVenueList.length - 1].getName().contains("Parafia") || weddingVenueList[weddingVenueList.length - 1].getName().contains("Urząd Stanu Cywilnego"));
    }
}
