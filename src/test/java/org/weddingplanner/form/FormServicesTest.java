package org.weddingplanner.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.weddingplanner.form.cities.model.CityModel;
import org.weddingplanner.form.model.*;
import org.weddingplanner.form.provinces.model.ProvinceModel;
import org.weddingplanner.form.weddingservicesset.WeddingServicesSet;
import org.weddingplanner.form.weddingvenues.model.WeddingVenueModel;

import static org.junit.Assert.*;

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

    @Test
    public void getResults() throws Exception {
        BeautyServicesCriteria beautyServicesCriteria = new BeautyServicesCriteria()
                .builder()
                .priceCriteria(7)
                .noteCriteria(8)
                .build();
        CarRentingServicesCriteria carRentingServicesCriteria = new CarRentingServicesCriteria()
                .builder()
                .priceCriteria(10)
                .noteCriteria(2)
                .build();
        FloristicServicesCriteria floristicServicesCriteria = new FloristicServicesCriteria()
                .builder()
                .priceCriteria(5)
                .noteCriteria(5)
                .build();
        MusicBandCriteria musicBandCriteria = new MusicBandCriteria()
                .builder()
                .priceCriteria(3)
                .noteCriteria(10)
                .build();
        PhotographicAndFilmServicesCriteria photographicAndFilmServicesCriteria = new PhotographicAndFilmServicesCriteria()
                .builder()
                .priceCriteria(5)
                .noteCriteria(9)
                .build();
        WeddingOutfitCriteria weddingOutfitCriteria = new WeddingOutfitCriteria()
                .builder()
                .priceCriteria(10)
                .noteCriteria(6)
                .build();
        WeddingHallCriteria weddingHallCriteria = new WeddingHallCriteria()
                .builder()
                .priceCriteria(7)
                .distanceCriteria(10)
                .noteCriteria(9)
                .build();
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueName("Parafia Wniebowzięcia Najświętszej Maryi Panny")
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Warszawa")
                .weddingVenueProvince("mazowieckie")
                .brideLivingCity("Warszawa")
                .brideLivingProvince("mazowieckie")
                .groomLivingCity("Warszawa")
                .groomLivingProvince("mazowieckie")
                .budget(60000)
                .budgetMargin(10000)
                .guestQuantity(200)
                .beautyServicesCriteria(beautyServicesCriteria)
                .carRentingServicesCriteria(carRentingServicesCriteria)
                .floristicServicesCriteria(floristicServicesCriteria)
                .musicBandCriteria(musicBandCriteria)
                .photographicAndFilmServicesCriteria(photographicAndFilmServicesCriteria)
                .weddingOutfitCriteria(weddingOutfitCriteria)
                .weddingHallCriteria(weddingHallCriteria)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String formJson = mapper.writeValueAsString(form);

        String uri = "/get-results";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .content(formJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        WeddingServicesSet[] weddingServicesSets = super.mapFromJson(content, WeddingServicesSet[].class);
        assertTrue(weddingServicesSets.length > 0);
        for(int i = 0; i < weddingServicesSets.length; i++){
            assertTrue(weddingServicesSets[i].getTotalAmount() <= (form.getBudget() + form.getBudgetMargin()));
            if(i != weddingServicesSets.length - 1) {
                assertTrue(weddingServicesSets[i].getTotalPoints() > weddingServicesSets[i + 1].getTotalPoints());
            }
        }
    }
}
