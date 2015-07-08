package vz.log.management.util;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogElasticUtilTest {
	
	@Before
	public void before() throws Exception {
	}
	
	@Test
	public void testGetUTCTime() throws Exception {
		System.out.println("LogElasticUtil.getUTCTime(): "+LogElasticUtil.getUTCTime());
		assertNotNull(LogElasticUtil.getUTCTime());
	}
	
	@Test
	public void testGetServeTime() throws Exception {
		System.out.println("LogElasticUtil.getServeTime(): "+LogElasticUtil.getServeTime());
		assertNotNull(LogElasticUtil.getServeTime());
	}
	
	@Test
	public void testGetUTCOffsetTime() throws Exception {
		System.out.println("LogElasticUtil.getUTCOffsetTime(): "+LogElasticUtil.getUTCOffsetTime("-5"));
		assertNotNull(LogElasticUtil.getUTCOffsetTime("-5"));
	}
	
	@Test
	public void testConvertStringToDateTimeByNattyMMDDYYYHHMMSS() throws Exception {
		String time = "June 26th 2015, 17:03:09.842";
		System.out.println("LogElasticUtil.exchangeDateFormatAtoDateFormatBByNattyMMDDYYYHHMMSS(): "+LogElasticUtil.exchangeDateFormatAtoDateFormatBByNatty(time));
		assertNotNull(LogElasticUtil.exchangeDateFormatAtoDateFormatBByNatty("June 26th 2015, 17:03:09.842"));
	}
	
	@Test
	public void testConvertStringToDateTimeByNattyYYYYDDMM() throws Exception {
		String time = "2015-06-26";
		System.out.println("LogElasticUtil.exchangeDateFormatAtoDateFormatByNattyYYYYDDMM(): "+LogElasticUtil.exchangeDateFormatAtoDateFormatBByNatty(time));
		assertNotNull(LogElasticUtil.exchangeDateFormatAtoDateFormatBByNatty("June 26th 2015, 17:03:09.842"));
	}	
	
	@After
	public void after() throws Exception {	
	}
}
