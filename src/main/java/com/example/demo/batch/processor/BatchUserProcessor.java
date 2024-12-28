package com.example.demo.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.batch.entity.BatchUserEntity;

@Component
public class BatchUserProcessor implements ItemProcessor<BatchUserEntity, BatchUserEntity> {

	@Override
	public BatchUserEntity process(BatchUserEntity item) throws Exception {

		item.setAge(100);
		return item;
	}

}
