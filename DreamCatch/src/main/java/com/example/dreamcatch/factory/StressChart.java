package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class StressChart implements Chart{

    Date selectedDates;
    int recordedData;

    @Override
    public List<Results> generate(DreamService service, int userId){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        Date searchDate = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dateString = formatter.format(searchDate) ;

        System.out.println(dateString);
        List<Dream> dreams = service.findDreamsByDateAfterAndUser_id(searchDate,userId);
        List<Results> results = new ArrayList<>();
        for(Dream d: dreams)
        {
            String dateStr = formatter.format(d.getDate());
            Results result = new Results(d.getStress_level(),dateStr);
            results.add(result);
        }

        return results;
    }
}
