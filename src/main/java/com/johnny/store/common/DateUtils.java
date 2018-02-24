package com.johnny.store.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String getCurrentDateTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static String getRecentMonthDateTime(int recentMonth){
        GregorianCalendar gc=new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        gc.add(2,-recentMonth);

        return simpleDateFormat.format(gc.getTime());
    }
}
