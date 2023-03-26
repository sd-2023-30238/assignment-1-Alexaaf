package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.repository.DreamRepository;
import com.example.dreamcatch.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class DurationChart implements Chart{
    @Override
    public List<Integer> generate(DreamService service){

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        Date searchDate = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dateString = formatter.format(searchDate) ;

        List<Integer> data = new ArrayList<>();
        System.out.println(dateString);
        List<Dream> dreams = service.findDreamsByDateAfter(dateString);

        for(int i = 0; i < dreams.size();i++)
        {
            data.add(dreams.get(i).getDuration());
        }
        //System.out.println(data);
        //System.out.println(dreams);

        return data;
}
}
