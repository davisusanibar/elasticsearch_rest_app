package vz.log.management.service;

import java.util.List;
import java.util.Map;

public interface LogElasticService {
	void saveLogElastic(Map<Object,Object> logElasticRequest);
	void listsaveLogElastic(List<Map<Object,Object>> logElasticRequest);
}