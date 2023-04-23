package com.example.dreamcatch.strategy;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MonthlyChart implements ChartStrategy{

    private int month;
    private int uId;

    public MonthlyChart(int month, int uId) {
        this.month = month;
        this.uId = uId;
    }

    @Override
    public List<Dream> getData(DreamService service) {
        Date startDate;
        Date endDate;
        String startDateString = "";
        String endDateString = "";
        if(month < 10) {
            startDateString = "01/0" + month + "/2023";
            endDateString = "31/0" + month + "/2023";
        }
        else{
            startDateString = "01/" + month + "/2023";
            endDateString = "31/0" + month + "/2023";
        }

        try {
            startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
            endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return service.findDreamsByDateBetweenAndUid(startDate,endDate,uId);
    }
}
