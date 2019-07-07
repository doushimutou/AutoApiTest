package com.auth.utils.http;

import io.restassured.response.Response;

import java.util.Map;
import java.util.logging.Handler;

import static io.restassured.RestAssured.given;

/**
 * Description
 * Author ayt  on
 */

public class NewAssured {
    public static Response post(Map params, String url) {
        Response response = given().contentType("application/json").body(params).when().post(url);
        return response;
    }

    public static Response get(Map params, String url) {
        return given().params(params).when().get(url);
    }
}
