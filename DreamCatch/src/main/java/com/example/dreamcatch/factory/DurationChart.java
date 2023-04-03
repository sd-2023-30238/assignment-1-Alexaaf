package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DurationChart implements Chart{

    @Override
    public List<Results> generate(DreamService service, int id){

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toString());
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        Date searchDate = cal.getTime();
        System.out.println(searchDate.toString());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dateString = formatter.format(searchDate) ;

        System.out.println(dateString);
        List<Dream> dreams = service.findDreamsByDateAfterAndUser_id(searchDate,id);
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
