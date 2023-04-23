package com.example.dreamcatch.controller;

import com.example.dreamcatch.factory.Chart;
import com.example.dreamcatch.factory.ChartGenerator;
import com.example.dreamcatch.factory.Results;
import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;
import com.example.dreamcatch.strategy.MonthlyChart;
import com.example.dreamcatch.strategy.WeeklyChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dream")
@CrossOrigin
public class DreamController {
    @Autowired
    DreamService dreamService;
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    String dateString = formatter.format(currentDate);

    @GetMapping (value = "/all")
    public List<Dream> getDreams()
    {
        return dreamService.findAll();
    }

    @PostMapping(value = "/addDream")
    public String addDream(@RequestBody Dream sleepDescription)
    {
        System.out.println(sleepDescription);
        String[] dreamRaw = sleepDescription.getDreamDescription().split(" ");
        int stress = 0, duration = 0, energy = 0;
        String category = "nothing";
        for(int i = 0; i< dreamRaw.length;i++)
        {
            if(dreamRaw[i].equals("#duration"))
            {
                duration = Integer.valueOf(dreamRaw[i+1]);
            }

            if(dreamRaw[i].equals("#energy"))
            {
                energy = Integer.valueOf(dreamRaw[i+1]);
            }

            if(dreamRaw[i].equals("#stress"))
            {
                stress = Integer.valueOf(dreamRaw[i+1]);
            }
            if(dreamRaw[i].equals("#category"))
            {
                category = dreamRaw[i+1];
            }
        }

        if(energy < 0 || energy > 5 || stress < 0 || stress > 5)
            return "Invalid data";

        System.out.println(duration + "- duration, " + energy + "- energy, " + stress + "- Stress.");
        Dream newDream = new Dream(0L,currentDate,duration,stress,energy,sleepDescription.getUid(),sleepDescription.getDreamDescription(),category);
        dreamService.saveDream(newDream);
        System.out.println(newDream.toString());
        return "New dream recorded";
    }

    @PostMapping(value = "/chart")
    public List<Results> showChart(@RequestBody String type) throws ParseException {
        System.out.println(type);
        int month = -1;
        int userId = 0;
        List<Results> data = new ArrayList<>();
        String[] decomp = type.split(" ");
        System.out.println(type);
        userId = Integer.parseInt(decomp[1]);
        month = Integer.parseInt(decomp[2]);
        String startDateString = decomp[3];
        String endDateString = decomp[4];

        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateString);

        if(userId < 0)
            return data;
        if(month < 0 || month > 12)
            return data;

        ChartGenerator generator = new ChartGenerator();
        Chart chart;
        chart = generator.generateChart(decomp[0]);

        System.out.println("Month: " + month);

        if(month == 0) {
            chart.setStrategy(new WeeklyChart(startDate,endDate,userId));
        }
        else {
            chart.setStrategy(new MonthlyChart(month,userId));
        }

        System.out.println(userId);
        try {
            data = chart.generate(dreamService);
        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

        return data;
    }
}
