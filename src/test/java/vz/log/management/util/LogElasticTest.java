package vz.log.management.util;

import org.elasticsearch.common.joda.time.DateTime;
import org.elasticsearch.common.joda.time.DateTimeZone;
import org.elasticsearch.common.joda.time.LocalDate;
import org.elasticsearch.common.joda.time.LocalDateTime;
import org.elasticsearch.common.joda.time.LocalTime;
import org.elasticsearch.common.joda.time.format.DateTimeFormat;
import org.elasticsearch.common.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class LogElasticTest {
	@Test
    public void testTime() {
        DateTimeFormatter dateFormat = DateTimeFormat
                .forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");

        LocalTime localTime = new LocalTime();
        LocalDate localDate = new LocalDate();
        DateTime dateTime = new DateTime();
        LocalDateTime localDateTime = new LocalDateTime();
        DateTimeZone dateTimeZone = DateTimeZone.getDefault();
        

        System.out
                .println("dateFormatr : " + dateFormat.print(localDateTime));
        System.out.println("LocalTime : " + localTime.toString());
        System.out.println("localDate : " + localDate.toString());
        System.out.println("dateTime : " + dateTime.toString());
        System.out.println("localDateTime : " + localDateTime.toString());
        System.out.println("DateTimeZone : " + dateTimeZone.toString());        
    }	
}
