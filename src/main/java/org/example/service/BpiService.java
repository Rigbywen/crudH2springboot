package org.example.service;

import org.example.dao.BpiDao;
import org.example.enity.Bpi;
import org.example.dto.CoinDataRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BpiService {

    @Autowired
    BpiDao bpiDao;

    /*
    public int insertNewBpi(String code, String symbol, String rate, String description, double rateFloat ) {
        return bpiDao.insertBpi(code, symbol, rate, description, rateFloat);
    }
    */
    public void insertBpiInit(CoinDataRs coinDataRs) {
        if ( null != coinDataRs.getBpi().getGBP() ) {
            bpiDao.insertBpi( coinDataRs.getBpi().getGBP().getCode(), coinDataRs.getBpi().getGBP().getSymbol(),
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
    }



    public void updateBpi(CoinDataRs coinDataRs, Date date) {
        if ( null != coinDataRs.getBpi().getGBP() ) {
            bpiDao.updateBpiByCode( coinDataRs.getBpi().getGBP().getCode(), coinDataRs.getBpi().getGBP().getSymbol(),
                    coinDataRs.getBpi().getGBP().getRate(), coinDataRs.getBpi().getGBP().getDescription(),
                    coinDataRs.getBpi().getGBP().getRate_float(), date );
        }
        if ( null != coinDataRs.getBpi().getUSD() ) {
            bpiDao.updateBpiByCode( coinDataRs.getBpi().getUSD().getCode(), coinDataRs.getBpi().getUSD().getSymbol(),
                    coinDataRs.getBpi().getUSD().getRate(), coinDataRs.getBpi().getUSD().getDescription(),
                    coinDataRs.getBpi().getUSD().getRate_float(), date );
        }
        if ( null != coinDataRs.getBpi().getEUR() ) {
            bpiDao.updateBpiByCode( coinDataRs.getBpi().getEUR().getCode(), coinDataRs.getBpi().getEUR().getSymbol(),
                    coinDataRs.getBpi().getEUR().getRate(), coinDataRs.getBpi().getEUR().getDescription(),
                    coinDataRs.getBpi().getEUR().getRate_float(), date );
        }
    }


    public  Bpi getBpiByCode(String code) {
        return bpiDao.getBpiByCode(code);
    }
    public  List<Bpi> getAllBpi(){
        return bpiDao.getAllBpi();
    }
    public  int  deleteBpiByCode(String code) {
        return bpiDao.deleteBpiByCode(code);
    }



}
