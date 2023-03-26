package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EnergyChart implements Chart{
    @Override
    public List<Integer> generate(DreamService service) {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dateString = formatter.format(currentDate);
        List<Integer> data = new ArrayList<>();
        List<Dream> dreams = service.findDreamsByDateAfter("20/03/2023");
        for(int i = 0; i < dreams.size();i++)
        {
            data.add(dreams.get(i).getEnergy_level() * 20);
        }
        System.out.println(data);
        System.out.println(dreams);

        return data;
    }
}
