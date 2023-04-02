package com.example.capstone.service.dataout;

import com.example.capstone.controller.DataItem;
import com.example.capstone.controller.RealtimeData;
import com.example.capstone.entity.LogEntity;
import com.example.capstone.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SunLogService {
    private final LogRepository logRepository;
    //LogDataOutService
    public SunLogService (LogRepository l){this.logRepository = l;}


    public ArrayList<DataItem> LogEntityToRealTimeData(int deviceid){
        ArrayList<LogEntity> a = logRepository.findAllById(deviceid);
        RealtimeData ans = new RealtimeData();


        for(int i=0; i<a.size();i++){
            LogEntity exist = a.get(i);
            DataItem s = new DataItem(exist.getLogTime().getHour(),exist.getSunlight());
            ans.AddData(s);
        }
        return ans.getData();
    }
}
