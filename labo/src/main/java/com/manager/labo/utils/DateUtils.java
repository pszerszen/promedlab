package com.manager.labo.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtils {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private DateUtils(){}
    
    public static Date toDate(String date){
        final LocalDate localDate = LocalDate.parse(date, DATE_FORMAT);
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static Date toDateTime(String dateTime){
        final LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DATE_TIME_FORMAT);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static String fromDate(Date date){
        final LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.format(DATE_FORMAT);
    }
    
    public static String fromDateTime(Date dateTime){
        final LocalDateTime localDateTime = Instant.ofEpochMilli(dateTime.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(DATE_TIME_FORMAT);
    }
}
