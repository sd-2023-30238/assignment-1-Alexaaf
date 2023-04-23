package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;
import com.example.dreamcatch.strategy.ChartStrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DurationChart implements Chart{

    private ChartStrategy strategy;

    @Override
    public ChartStrategy getStrategy() {
        return strategy;
    }

    @Override
    public void setStrategy(ChartStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<Results> generate(DreamService service){


//        Date date = new Date();
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.toString());
//
//        cal.setTime(date);
//
//        cal.add(Calendar.DATE, -7);
//        Date searchDate = cal.getTime();
//        System.out.println(searchDate.toString());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//        String dateString = formatter.format(searchDate) ;
//
//        System.out.println(dateString);
//
//      List<Dream> dreams = service.findDreamsByDateAfterAndUser_id(searchDate,id);
        System.out.println("Aici1");

        List<Dream> dreams = strategy.getData(service);
        System.out.println("Aic2");
        List<Results> results = new ArrayList<>();
        for(Dream d: dreams)
        {
            String dateStr = formatter.format(d.getDate());
            Results result = new Results(d.getDuration(),dateStr);
            results.add(result);
        }

        return results;
    }

}
