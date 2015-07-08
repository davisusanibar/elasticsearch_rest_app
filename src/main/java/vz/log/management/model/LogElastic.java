package vz.log.management.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "#{@indexPrefix}-vzlog-#{@indexSuffix}", type = "vzlog")
@Setting(settingPath="/settings/log-elastic-setting.json")
public class LogElastic {
    @Id
    private String id;
    
	@Field(type=FieldType.Date, store = true)
    private String sourceTimestamp;
	
	private Map<Object, Object> logelastic;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<Object, Object> getLogelastic() {
		return logelastic;
	}

	public void setLogelastic(Map<Object, Object> logelastic) {
		this.logelastic = logelastic;
	}

	public String getSourceTimestamp() {
		return sourceTimestamp;
	}

	public void setSourceTimestamp(String sourceTimestamp) {
		this.sourceTimestamp = sourceTimestamp;
	}
}
