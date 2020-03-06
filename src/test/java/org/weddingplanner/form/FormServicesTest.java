package org.weddingplanner.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.weddingplanner.form.cities.model.CityModel;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.form.provinces.model.ProvinceModel;
import org.weddingplanner.form.weddingservicesfilter.WeddingServicesFilter;
import org.weddingplanner.form.weddingservicesfilter.WeddingServicesWrapper;
import org.weddingplanner.form.weddingvenues.model.WeddingVenueModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;

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

    @Test
    public void getResults() throws Exception {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueName("Parafia Wniebowzięcia Najświętszej Maryi Panny")
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .brideLivingCity("Skorzeszyce")
                .brideLivingProvince("świętokrzyskie")
                .groomLivingCity("Zagnańsk")
                .groomLivingProvince("świętokrzyskie")
                .budget(60000)
                .budgetMargin(10000)
                .guestQuantity(200)
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
        WeddingServicesWrapper wrapper = super.mapFromJson(content, WeddingServicesWrapper.class);
        assertTrue(wrapper.getBeautySalons().size() > 0);
        assertTrue(wrapper.getCarRentings().size() > 0);
        assertTrue(wrapper.getFloristicServices().size() > 0);
        assertTrue(wrapper.getHairDressers().size() > 0);
        assertTrue(wrapper.getMakeUpSalons().size() > 0);
        assertTrue(wrapper.getMusicBands().size() > 0);
        assertTrue(wrapper.getPhotographers().size() > 0);
        assertTrue(wrapper.getWeddingDressStores().size() > 0);
        assertTrue(wrapper.getWeddingSuitesStores().size() > 0);
        assertTrue(wrapper.getWeddingHalls().size() > 0);
        for(WeddingHallListInternalModel hall : wrapper.getWeddingHalls()){
            assertTrue(hall.getMaxGuestsQuantity() >= form.getGuestQuantity());
        }
    }
}
