package com.zaictronics.GameOfThroneHouses.shared;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlFormatterImpTest {

    @Autowired
    UrlFormatterImp urlFormatterImp;

    @Test
    void testformatUrl_WhenUlrIsProvided_returnId(){
        String url = "https://www.anapioficeandfire.com/api/houses/1";
        String expectedId = "1";
        String actualId = urlFormatterImp.formatUrl(url);

        Assertions.assertEquals(expectedId, actualId, "Extracted Is not correct");

    }

    @Test
    void testformatUrl_WhenUlrIsNotProvided_ThrowException(){
        String url = "https://www.anapioficeandfire.com/api/houses";
        String expected = "No url id found";

       Exception exception =  Assertions.assertThrows(RuntimeException.class,()->{
            urlFormatterImp.formatUrl(url);
        });


        Assertions.assertEquals(expected, exception.getMessage());
    }

}