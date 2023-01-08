package org.example.service;

import com.google.gson.Gson;
import org.example.dao.BpiDao;
import org.example.dto.CoinDataRs;
import org.example.enity.Bpi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BpiServiceTest {

    @Autowired
    BpiService bpiService ;


    @MockBean
    BpiDao bpiDao;
    @Test
    public void testInsertAndGetAllBpi () {

        String json = "{\"time\":{\"updated\":\"Jan 8, 2023 06:14:00 UTC\",\"updatedISO\":\"2023-01-08T06:14:00+00:00\",\"updateduk\":\"Jan 8, 2023 at 06:14 GMT\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"chartName\":\"Bitcoin\",\"bpi\":{\"USD\":{\"code\":\"USD\",\"symbol\":\"&#36;\",\"rate\":\"16,938.8905\",\"description\":\"United States Dollar\",\"rate_float\":16938.8905},\"GBP\":{\"code\":\"GBP\",\"symbol\":\"&pound;\",\"rate\":\"14,154.0014\",\"description\":\"British Pound Sterling\",\"rate_float\":14154.0014},\"EUR\":{\"code\":\"EUR\",\"symbol\":\"&euro;\",\"rate\":\"16,500.9524\",\"description\":\"Euro\",\"rate_float\":16500.9524}}}";
        CoinDataRs coinDataRs = new Gson().fromJson(json, CoinDataRs.class);

        // [] 預期資料
        List<Bpi> expectedTodosList = new ArrayList();

        if ( null != coinDataRs.getBpi().getGBP() ) {
            bpiDao.insertBpi(coinDataRs.getBpi().getGBP().getCode(), coinDataRs.getBpi().getGBP().getSymbol(),
                    coinDataRs.getBpi().getGBP().getRate(), coinDataRs.getBpi().getGBP().getDescription(),
                    coinDataRs.getBpi().getGBP().getRate_float(), new Date());
        }
        if ( null != coinDataRs.getBpi().getUSD() ) {
            bpiDao.insertBpi( coinDataRs.getBpi().getUSD().getCode(), coinDataRs.getBpi().getUSD().getSymbol(),
                    coinDataRs.getBpi().getUSD().getRate(), coinDataRs.getBpi().getUSD().getDescription(),
                    coinDataRs.getBpi().getUSD().getRate_float(), new Date() );
        }
        if ( null != coinDataRs.getBpi().getEUR() ) {
            bpiDao.insertBpi( coinDataRs.getBpi().getEUR().getCode(), coinDataRs.getBpi().getEUR().getSymbol(),
                    coinDataRs.getBpi().getEUR().getRate(), coinDataRs.getBpi().getEUR().getDescription(),
                    coinDataRs.getBpi().getEUR().getRate_float(), new Date() );
        }


        List<Bpi> bpiList = bpiService.getAllBpi();
        Mockito.when(bpiDao.getAllBpi()).thenReturn(expectedTodosList);

        //  [Assert] 預期與實際的資料
        assertEquals(expectedTodosList, bpiList);

    }

}