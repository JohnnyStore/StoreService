package com.johnny.store.vo;

import java.util.List;

public class DailySnapUpListVO {
    private List<DailySnapUpVO> dailySnapUpOfYesterday;
    private List<DailySnapUpVO> dailySnapUpOfToday;
    private List<DailySnapUpVO> dailySnapUpOfTomorrow;
    private List<DailySnapUpVO> dailySnapUpOfAfterTomorrow;

    public List<DailySnapUpVO> getDailySnapUpOfYesterday() {
        return dailySnapUpOfYesterday;
    }

    public void setDailySnapUpOfYesterday(List<DailySnapUpVO> dailySnapUpOfYesterday) {
        this.dailySnapUpOfYesterday = dailySnapUpOfYesterday;
    }

    public List<DailySnapUpVO> getDailySnapUpOfToday() {
        return dailySnapUpOfToday;
    }

    public void setDailySnapUpOfToday(List<DailySnapUpVO> dailySnapUpOfToday) {
        this.dailySnapUpOfToday = dailySnapUpOfToday;
    }

    public List<DailySnapUpVO> getDailySnapUpOfTomorrow() {
        return dailySnapUpOfTomorrow;
    }

    public void setDailySnapUpOfTomorrow(List<DailySnapUpVO> dailySnapUpOfTomorrow) {
        this.dailySnapUpOfTomorrow = dailySnapUpOfTomorrow;
    }

    public List<DailySnapUpVO> getDailySnapUpOfAfterTomorrow() {
        return dailySnapUpOfAfterTomorrow;
    }

    public void setDailySnapUpOfAfterTomorrow(List<DailySnapUpVO> dailySnapUpOfAfterTomorrow) {
        this.dailySnapUpOfAfterTomorrow = dailySnapUpOfAfterTomorrow;
    }
}
