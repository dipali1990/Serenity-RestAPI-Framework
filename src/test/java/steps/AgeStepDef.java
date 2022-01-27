package steps;

import api.AgeAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import responses.PredictAgeResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AgeStepDef {

    @Steps
    AgeAPI ageAPI;

    @When("the user send a GET request to predict the age by name {string}")
    public void the_user_send_a_get_request_to_predict_the_age_by_name(String name) {
        ageAPI.fetchAgeFromName(name);
    }

    @Then("the request should return status code as {int}")
    public void the_request_should_return_status_code_as(Integer statusCode) throws Exception {
        assertEquals(statusCode.intValue(), ageAPI.getStatusCode());
    }

    @And("verify the fields in the GET response")
    public void verify_the_fields_in_the_get_response() {
        PredictAgeResponse response = ageAPI.getBody();
        assertNotNull(response.name);
        assertNotNull(response.age);
        assertNotNull(response.count);
    }

}
