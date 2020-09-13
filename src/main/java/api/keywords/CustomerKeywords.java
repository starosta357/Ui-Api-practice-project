package api.keywords;

import api.model.Customer;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CustomerKeywords implements IKeyword {

    public static final String BASE_URI = "https://reqres.in/api";
    public static final String USERS_PATH = BASE_URI + "/users";

    public static final String GET_SINGLE_USER_PATH = USERS_PATH + "/{userNumber}";
    public static final String UPDATE_USER_PATH = USERS_PATH + "/{userNumber}";
    public static final String DELETE_USER_PATH = USERS_PATH + "/{userNumber}";
    public static final String CREATE_USER_PATH = USERS_PATH;

    @Step
    public Response getCustomer(int userNumber) {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        Response response = given()
                .basePath(BASE_URI)
                .when()
                .get(GET_SINGLE_USER_PATH, userNumber);
        response.then().statusCode(HttpStatus.SC_OK);
        return response;
    }

    @Step
    public Response postCustomer(Customer customer) {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        Map<String, String> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", customer.getName());
        jsonAsMap.put("job", customer.getJob());

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .basePath(BASE_URI)
                .with().body(jsonAsMap)
                .post(CREATE_USER_PATH);
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
        return response;
    }

    @Step
    public Response patchCustomer(Customer customer, int userNumber) {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        Map<String, String> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", customer.getName());
        jsonAsMap.put("job", customer.getJob());

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .basePath(BASE_URI)
                .with().body(jsonAsMap)
                .patch(UPDATE_USER_PATH, userNumber);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        return response;
    }

    @Step
    public void deleteCustomer(int userNumber) {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        Response response = given()
                .basePath(BASE_URI)
                .delete(DELETE_USER_PATH, userNumber);
        response.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
