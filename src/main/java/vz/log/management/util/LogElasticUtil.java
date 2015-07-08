package vz.log.management.util;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.elasticsearch.common.joda.time.DateTime;
import org.elasticsearch.common.joda.time.DateTimeZone;
import org.elasticsearch.common.joda.time.format.DateTimeFormat;

import com.joestelmach.natty.Parser;

public class LogElasticUtil {
	
	private final static String formatTime = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ"; //A formatter that combines a full date and time, separated by a T (yyyy-MM-dd’T'HH:mm:ss.SSSZZ).
	
	private static String sourceTimestamp = "";
	
	private static String offsetSourceTimestamp = "";
		
	static String getUTCTime(){
		return (new DateTime()
				.withZone(DateTimeZone.UTC))
					.toString(DateTimeFormat.forPattern(formatTime));
	}
	
	static String getServeTime(){
		return (new DateTime()
				.withZone(DateTimeZone.getDefault()))
					.toString(DateTimeFormat.forPattern(formatTime));
	}	
	
	static String getUTCOffsetTime(String offset){
		return (new DateTime()
		.withZone(DateTimeZone.forOffsetHours(Integer.parseInt(offset))))
			.toString(DateTimeFormat.forPattern(formatTime));
	}
	
	static String obtainSourceTimestamp(Map<Object,Object> logElasticRequest){				
		sourceTimestamp = (logElasticRequest.get("sourceTimestamp")==null)?"":logElasticRequest.get("sourceTimestamp").toString();
		offsetSourceTimestamp = (logElasticRequest.get("offsetSourceTimestamp")==null)?"":logElasticRequest.get("offsetSourceTimestamp").toString();
		
		//if the user define a date timestamp, then, our app should use that
		if (!"".equals(sourceTimestamp)) { 
			//first we need to format the date received
			sourceTimestamp = exchangeDateFormatAtoDateFormatBByNatty(offsetSourceTimestamp);			
		} else {
			if (!"".equals(offsetSourceTimestamp)) {
				sourceTimestamp = getUTCOffsetTime(offsetSourceTimestamp);
			} else {
				//if the user don't specify a time, then, our app should initialize a server default timestamp
				sourceTimestamp = getServeTime();				
			}
		}
		
		return sourceTimestamp;
	}
	
	//[FIXME]: do a check to support multi-environment date log time
	static String exchangeDateFormatAtoDateFormatBByNatty(String sourceTimestamp){		
		return (new SimpleDateFormat(formatTime))
					.format(
							(new Parser())
								.parse(sourceTimestamp)
									.get(0)
										.getDates()
											.get(0)
							);
	}
}
