package com.example.demo.batch.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.batch.entity.BatchUserEntity;

@Configuration
public class BatchUserWriter {

	@Bean
	JdbcBatchItemWriter<BatchUserEntity> userItemWriter(DataSource dataSource) {

		return new JdbcBatchItemWriterBuilder<BatchUserEntity>().dataSource(dataSource)
				.sql("INSERT INTO processed_users (name, email) VALUES (:name, :email)").beanMapped().build();

	}

}
