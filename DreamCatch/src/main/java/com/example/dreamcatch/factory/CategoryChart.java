package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;
import com.example.dreamcatch.strategy.ChartStrategy;

import java.text.ParseException;
import java.util.*;


public class CategoryChart implements Chart{

    private ChartStrategy strategy;

    public ChartStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ChartStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<Results> generate(DreamService service) throws ParseException {


//        Date date = new Date();
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.toString());
//        cal.setTime(date);
//        cal.add(Calendar.DATE, -7);
//        Date searchDate = cal.getTime();
//        System.out.println(searchDate.toString());
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//        String dateString = formatter.format(searchDate) ;
//        System.out.println(dateString);
//        List<Dream> dreams = service.findDreamsByDateAfterAndUser_id(searchDate,id);
        List<Dream> dreams = strategy.getData(service);
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
        System.out.println(results);

        return results;
    }

}
