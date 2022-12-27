package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //1.Extract the limit
    @Test
    public void test1() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2.Extract the total
    @Test
    public void test2() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("-------------------End of test-------------------------");
    }

    //3.Extract the name of 5th store
    @Test
    public void test3() {
        String store = response.extract().path("data.name");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The name of 5th store : " + store);
        System.out.println("-------------------End of test-------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test4() {
        List<String> listOfName = response.extract().path("data.name");

        System.out.println("-------------------StartingTest-------------------------");
        System.out.println("The names of all the store : " + listOfName);
        System.out.println("-------------------End of test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test5() {
        List<Integer> listOfstoreId = response.extract().path("data.id");

        System.out.println("-------------------StartingTest-----------------------");
        System.out.println("The names of all the storeId : " + listOfstoreId);
        System.out.println("--------------------End of test-------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test6() {
        List<Integer> dataList = response.extract().path("data");
        dataList.size();
        System.out.println("-------------------StartingTest-----------------------");
        System.out.println("The list of size of the data : " + dataList.size());
        System.out.println("--------------------End of test-------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test7() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");

        System.out.println("---------------------StartingTest-----------------------");
        System.out.println("The value of the store where store name : " + values);
        System.out.println("----------------------End of test------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test8() {
        List<String> address = response.extract().path("data.address");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The adress of the store where store name : " + address);
        System.out.println("-------------------End of test-------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test9() {
        List<String> store = response.extract().path("data.services");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("All the services of the 8th stores : " + store);
        System.out.println("-------------------End of test-------------------------");
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test10() {
        List<String> name = response.extract().path("data.windowsstore");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The store where services name 'Windows Store' : " + name);
        System.out.println("-------------------End of test-------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test11() {
        List<String> store = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("All the storeId of all the store : " + store);
        System.out.println("-------------------End of test-------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test12() {
        List<String> store = response.extract().path("data.id");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("All the store id : " + store);
        System.out.println("-------------------End of test-------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void test13() {
        List<String> storename = response.extract().path("data.state");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The store names where state 'ND' : " + storename);
        System.out.println("-------------------End of test-------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14() {
        List<String> storename = response.extract().path("data[8].services");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("Total number of services for the store where store name 'Rochester' : " + storename);
        System.out.println("-------------------End of test-------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15() {
        List<String> numOfservices = response.extract().path("data.createdAt");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The createdAt for all services whose name 'Windows Store' : " + numOfservices);
        System.out.println("-------------------End of test-------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16() {
        List<String> name = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The name of all services where store name = 'Fargo' : " + name);
        System.out.println("-------------------End of test-------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void test17() {
        List<String> zip = response.extract().path("data.zip");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The zip of all the store : " + zip);
        System.out.println("-------------------End of test-------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test18() {
        List<String> zip = response.extract().path("data[2].zip");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The zip of store name 'Roseville' : " + zip);
        System.out.println("-------------------End of test-------------------------");
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19() {
        List<String> storeservices = response.extract().path("data[2].services[7].name");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The storeservices details of the service name 'Magnolia Home Theater' : " + storeservices);
        System.out.println("-------------------End of test-------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void test20() {
        List<String> stores = response.extract().path("data.lat");

        System.out.println("------------------StartingTest------------------------");
        System.out.println("The lat of all the stores : " + stores);
        System.out.println("-------------------End of test-------------------------");
    }


}

