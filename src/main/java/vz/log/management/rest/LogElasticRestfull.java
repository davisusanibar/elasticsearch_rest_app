package vz.log.management.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vz.log.management.service.LogElasticService;

@RestController
@RequestMapping("/logmanagement")
public class LogElasticRestfull {
	
	@Autowired
	private LogElasticService logElasticService;
	
	private Map<Object, Object> responseSaveLogElastic;
	private List<Map<Object, Object>> listResponseSaveLogElastic;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody Map<Object, Object> saveLogElastic(@RequestBody Map<Object,Object> logElasticRequest){
		System.out.println(logElasticRequest.toString());
		responseSaveLogElastic = new HashMap<Object, Object>();
		try {
			
			logElasticService.saveLogElastic(logElasticRequest);
			
			responseSaveLogElastic.put("responsecode", "200");			
		} catch (Exception e) {
			responseSaveLogElastic.put("responsecode", "500");
			responseSaveLogElastic.put("usermessage", "Error to save log on elasticsearch.");
			responseSaveLogElastic.put("technicalmessage", e.getMessage());
		}
				
		return responseSaveLogElastic;
	}
	
	@RequestMapping(value="/listSave", method=RequestMethod.POST)
	public @ResponseBody List<Map<Object, Object>> listSaveLogElastic(@RequestBody List<Map<Object,Object>> listLogElasticRequest){
		System.out.println(listLogElasticRequest.toString());
		responseSaveLogElastic = new HashMap<Object, Object>();
		listResponseSaveLogElastic = new ArrayList<Map<Object, Object>>();
		try {
			for (Map<Object, Object> map : listLogElasticRequest) {
				responseSaveLogElastic = saveLogElastic(map);
				listResponseSaveLogElastic.add(responseSaveLogElastic);
			}
		} catch (Exception e) {
			responseSaveLogElastic.put("responsecode", "500");
			responseSaveLogElastic.put("usermessage", "Error to save log on elasticsearch.");
			responseSaveLogElastic.put("technicalmessage", e.getMessage());
			listResponseSaveLogElastic.add(responseSaveLogElastic);
		}
				
		return listResponseSaveLogElastic;			
	}
}
