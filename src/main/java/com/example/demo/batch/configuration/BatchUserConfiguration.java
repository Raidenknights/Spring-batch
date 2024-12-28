package com.example.demo.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.batch.entity.BatchUserEntity;
import com.example.demo.batch.processor.BatchUserProcessor;

@Configuration
public class BatchUserConfiguration {

	@Bean
	Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			JdbcCursorItemReader<BatchUserEntity> reader, BatchUserProcessor processor,
			JdbcBatchItemWriter<BatchUserEntity> writer) {
		return new StepBuilder("step", jobRepository).<BatchUserEntity, BatchUserEntity>chunk(10, transactionManager)
				.reader(reader).writer(writer).build();
	}

	@Bean
	Job job(JobRepository jobRepository, Step step) {
		return new JobBuilder("importUserJob", jobRepository).start(step).build();
	}

}
