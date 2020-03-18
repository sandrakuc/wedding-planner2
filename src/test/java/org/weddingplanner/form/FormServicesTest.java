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
import org.weddingplanner.searchservices.DistanceClassification;
import org.weddingplanner.searchservices.PriceClassification;
import org.weddingplanner.searchservices.SatisfactionClassification;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;

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
        for(BeautySalonListInternalModel beautySalon : wrapper.getBeautySalons()){
            assertTrue(beautySalon.getPriceClassification() != null);
            assertTrue(beautySalon.getSatisfactionClassification() != null);
            assertFalse(beautySalon.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && beautySalon.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(CarRentingListInternalModel carRenting : wrapper.getCarRentings()){
            assertTrue(carRenting.getPriceClassification() != null);
            assertTrue(carRenting.getSatisfactionClassification() != null);
            assertFalse(carRenting.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && carRenting.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(FloristicServicesListInternalModel floristicService : wrapper.getFloristicServices()){
            assertTrue(floristicService.getPriceClassification() != null);
            assertTrue(floristicService.getSatisfactionClassification() != null);
            assertFalse(floristicService.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && floristicService.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(HairDresserListInternalModel hairDresser : wrapper.getHairDressers()){
            assertTrue(hairDresser.getPriceClassification() != null);
            assertTrue(hairDresser.getSatisfactionClassification() != null);
            assertFalse(hairDresser.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && hairDresser.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(MakeUpSalonListInternalModel salon : wrapper.getMakeUpSalons()){
            assertTrue(salon.getPriceClassification() != null);
            assertTrue(salon.getSatisfactionClassification() != null);
            assertFalse(salon.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && salon.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(MusicBandListInternalModel band : wrapper.getMusicBands()){
            assertTrue(band.getPriceClassification() != null);
            assertTrue(band.getSatisfactionClassification() != null);
            assertFalse(band.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && band.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(PhotographerListInternalModel photographer : wrapper.getPhotographers()){
            assertTrue(photographer.getPriceClassification() != null);
            assertTrue(photographer.getSatisfactionClassification() != null);
            assertFalse(photographer.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && photographer.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(WeddingDressStoreListInternalModel store : wrapper.getWeddingDressStores()){
            assertTrue(store.getPriceClassification() != null);
            assertTrue(store.getSatisfactionClassification() != null);
            assertFalse(store.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && store.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(WeddingSuitesListInternalModel store : wrapper.getWeddingSuitesStores()){
            assertTrue(store.getPriceClassification() != null);
            assertTrue(store.getSatisfactionClassification() != null);
            assertFalse(store.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && store.getSatisfactionClassification().equals(SatisfactionClassification.BAD));
        }
        for(WeddingHallListInternalModel hall : wrapper.getWeddingHalls()){
            assertTrue(hall.getMaxGuestsQuantity() >= form.getGuestQuantity());
            assertTrue(hall.getDistanceClassification() != null);
            assertTrue(hall.getPriceClassification() != null);
            assertTrue(hall.getSatisfactionClassification() != null);
            assertFalse(hall.getPriceClassification().equals(PriceClassification.EXPENSIVE)
                    && hall.getSatisfactionClassification().equals(SatisfactionClassification.BAD)
                    && hall.getDistanceClassification().equals(DistanceClassification.FAR));
        }
    }
}
