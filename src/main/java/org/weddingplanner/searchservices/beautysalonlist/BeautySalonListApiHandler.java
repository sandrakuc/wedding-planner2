package org.weddingplanner.searchservices.beautysalonlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.beautysalonlist.external.BeautySalonListExternalModel;
import org.weddingplanner.searchservices.beautysalonlist.external.BeautySalonListResultsResponse;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.HairDresserListUtils;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListExternalModel;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class BeautySalonListApiHandler {
    public String getEndpoint(String provinceName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=gabinet+kosmetyczny+" + provinceName + "&key=" + BeautySalonListUtils.getApiKey();
        return endpoint;
    }

    private BeautySalonListResultsResponse[] sendRequest(String provinceName) throws IOException {
        URL url = new URL(getEndpoint(provinceName));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        StringBuilder content;
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        content = new StringBuilder();
        while ((line = in.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        BeautySalonListExternalModel response = objectMapper.readValue(content.toString(), BeautySalonListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<BeautySalonListInternalModel> getBeautySalonList(InputDataForm inputDataForm, CompanyDao companyDao) throws IOException, SQLException {
        BeautySalonListResultsResponse[] externalModels = sendRequest(inputDataForm.getBrideLivingProvince());
        List<BeautySalonListInternalModel> internalModels = BeautySalonListExternalToInternalModelConverter.convertList(externalModels, companyDao, inputDataForm.getBrideLivingCity());
        return internalModels;
    }
}
