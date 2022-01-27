package api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import responses.PredictAgeResponse;

public class AgeAPI {


    private Response response;

    @Step("Predict age from name {0}")
    public void fetchAgeFromName(String name) {
        String BASE_URL = "https://api.agify.io?name={name}";
        response = SerenityRest.given()
                .pathParam("name", name)
                .get(BASE_URL);
    }

    @Step("Retrieve http status code")
    public int getStatusCode() {
        return response.then().extract().statusCode();
    }

    @Step("Retrieve response body")
    public PredictAgeResponse getBody(){
        return  response.getBody().as( PredictAgeResponse.class);
    }

}
