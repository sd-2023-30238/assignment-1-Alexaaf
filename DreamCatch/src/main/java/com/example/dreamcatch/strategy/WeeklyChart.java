package com.example.dreamcatch.strategy;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;

import java.util.Date;
import java.util.List;

public class WeeklyChart implements ChartStrategy{

    private Date startDate;
    private Date endDate;
    private int uId;

    public WeeklyChart(Date startDate, Date endDate, int uId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.uId = uId;
    }

    @Override
    public List<Dream> getData(DreamService service) {

        System.out.println(this.startDate);
        System.out.println(this.endDate);

        System.out.println("Wkk");
        return service.findDreamsByDateBetweenAndUid(this.startDate,this.endDate,uId);

    }
}
