package com.example.steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.junit.runner.RunWith;

public class Steps {
    Response response;
    String baseURL;

    @Before
    public void set_uri() {
        this.baseURL = "https://api.ratesapi.io";
    }

    @Given("api is available")
    public void api_is_available() {
    }

    @When("there is a GET request")
    public void there_is_a_GET_request() {
        response = get(baseURL + "/api/latest");
    }

    @Then("status code is {int}")
    public void status_code_is(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("currency {string} rate is {float}")
    public void currency_rate_is(String currency, Float rate) {
        response.then().body(currency, is(rate));
    }

    @When("there is a GET request for incomplete url")
    public void there_is_a_GET_request_for_incomplete_url() {
        response = get(baseURL + "/api/");
    }

    @When("there is a GET request for exchange rates on {string}")
    public void there_is_a_GET_request_for_exchange_rates_on(String date) {
        response = get(baseURL + "/api/" + date);
    }

    @Then("date is {string}")
    public void date_is(String date) {
        response.then().body("date", is(date));
    }
}