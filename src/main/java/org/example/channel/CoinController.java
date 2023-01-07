package org.example.channel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.dto.CoinDataRs;
import org.example.enity.Bpi;
import org.example.service.BpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
public class CoinController {
    RestTemplate restTemplate ;
    HttpHeaders headers ;

    String dataSourceURL = "https://api.coindesk.com/v1/bpi/currentprice.json" ;
    @Autowired
    BpiService bpiService ;

    @RequestMapping("/deleteBpi/{code}")
    public String deleteBpiByCode(@PathVariable("code") String code) {
        String rs ;
        try {

            rs = bpiService.deleteBpiByCode(code) == 0 ? "Delete by code called": "Delete fail" ;
        } catch ( Exception e ) {
            rs = e.getMessage() ;
        }
        return rs ;
    }

    @RequestMapping("/")
    public String baseTest() {

        return "baseTest" ;
    }

    @RequestMapping("/getBpi/{code}")
    public Bpi getBpiByCode(@PathVariable("code") String code) {
        String rs ;
        Bpi bpi = bpiService.getBpiByCode(code);


       return bpi ;
    }

    @RequestMapping("/getAllBpi")
    public List<Bpi> getAllBpi() {
        String rs ;
        List<Bpi> bpiList = bpiService.getAllBpi();


        return bpiList ;
    }

    @RequestMapping("/coindata")
    public String insertBpiInit() {

        String rs ;
        CoinDataRs coinDataRs = getCoinData() ;
        try {
            bpiService.insertBpiInit(coinDataRs);
            rs = "insertBpiInit coinData Done" ;

        } catch ( Exception e ) {
            rs = e.getMessage() ;
        }


        return  rs;
    }

    @RequestMapping("/reloadCoindata")
    public String updateCoindata() {

        CoinDataRs coinDataRs = getCoinData() ;
        Date date ;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssX");
        SimpleDateFormat formatterForRs = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            date = formatter.parse(coinDataRs.getTime().getUpdatedISO()) ;
            bpiService.updateBpi(coinDataRs, date);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return "update at : " + formatterForRs.format(date) ;

    }

    private CoinDataRs getCoinData() {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // headers.add("Header", "header1");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(dataSourceURL) ;
        //暫時不用接參數 .queryParam("param1", param1)
        //暫時不用接參數 .queryParam("param2", param2);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        String json = response.getBody();
        CoinDataRs coinDataRs = new Gson().fromJson(json, CoinDataRs.class);
        return coinDataRs ;
    }


}
