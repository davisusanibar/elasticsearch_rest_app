package vz.log.management.repository;

import java.io.Serializable;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import vz.log.management.model.LogElastic;

public interface LogElasticRepository extends ElasticsearchRepository<LogElastic, Serializable> {

}
