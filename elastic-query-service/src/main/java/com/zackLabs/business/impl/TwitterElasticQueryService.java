package com.zackLabs.business.impl;


import com.zackLabs.business.ElasticQueryService;
import com.zackLabs.elastic.query.client.service.ElasticQueryClient;
import com.zackLabs.elasticmodel.index.impl.TwitterIndexModel;
import com.zackLabs.model.ElasticQueryServiceResponseModel;
import com.zackLabs.model.assembler.ElasticQueryServiceResponseModelAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitterElasticQueryService implements ElasticQueryService {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterElasticQueryService.class);

    private final ElasticQueryServiceResponseModelAssembler elasticQueryServiceResponseModelAssembler;

    private final ElasticQueryClient<TwitterIndexModel> elasticQueryClient;

    public TwitterElasticQueryService(ElasticQueryServiceResponseModelAssembler assembler,
                                      ElasticQueryClient<TwitterIndexModel> queryClient) {
        this.elasticQueryServiceResponseModelAssembler = assembler;
        this.elasticQueryClient = queryClient;
    }

    @Override
    public ElasticQueryServiceResponseModel getDocumentById(String id) {
        LOG.info("Querying elasticsearch by id {}", id);
        return elasticQueryServiceResponseModelAssembler.toModel(elasticQueryClient.getIndexModelById(id));
    }

    @Override
    public List<ElasticQueryServiceResponseModel> getDocumentByText(String text) {
        LOG.info("Querying elasticsearch by text {}", text);
        return elasticQueryServiceResponseModelAssembler.toModels(elasticQueryClient.getIndexModelByText(text));
    }

    @Override
    public List<ElasticQueryServiceResponseModel> getAllDocuments() {
        LOG.info("Querying all documents in elasticsearch");
        return elasticQueryServiceResponseModelAssembler.toModels(elasticQueryClient.getAllIndexModels());
    }
}
