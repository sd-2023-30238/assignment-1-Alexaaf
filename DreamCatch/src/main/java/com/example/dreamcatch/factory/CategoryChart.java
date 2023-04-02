package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.SimpleDateFormat;
import java.util.*;


public class CategoryChart implements Chart{

    @Override
    public List<Results> generate(DreamService service, int id){

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        Date searchDate = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dateString = formatter.format(searchDate) ;

        System.out.println(dateString);
        List<Dream> dreams = service.findDreamsByDateAfterAndUser_id(dateString,id);
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(Dream d: dreams)
        {
            int x = 0;
            if(hashMap.get(d.getDreamCategory()) != null)
                x = hashMap.get(d.getDreamCategory());
            x += 1;
            hashMap.put(d.getDreamCategory(),x);
        }
        List<Results> results = new ArrayList<>();

        hashMap.forEach((key,value) -> {
            Results result = new Results(value,key);
            results.add(result);
        });


        return results;
    }

}
