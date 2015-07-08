package vz.log.management.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vz.log.management.model.LogElastic;
import vz.log.management.repository.LogElasticRepository;
import vz.log.management.util.LogElasticUtil;

@Service
public class LogElasticServiceImpl implements LogElasticService {

	@Autowired
	private LogElasticRepository repository;
	
	private LogElastic logElastic;
	
	private String sourceTimestamp = "";
		
	@Override
	public void saveLogElastic(Map<Object,Object> logElasticRequest) {		
		sourceTimestamp = (logElasticRequest.get("sourceTimestamp")==null)?logElasticRequest.get("sourceTimestamp").toString():"";
		logElastic = new LogElastic();
		logElastic.setLogelastic(logElasticRequest);
		
		
	}

	@Override
	public void listsaveLogElastic(List<Map<Object, Object>> logElasticRequest) {
		for (Map<Object, Object> map : logElasticRequest) {
			saveLogElastic(map);
		}
	}
}
