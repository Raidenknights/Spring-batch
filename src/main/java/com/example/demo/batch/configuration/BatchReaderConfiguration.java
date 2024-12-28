package com.example.demo.batch.configuration;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.batch.entity.BatchUserEntity;

@Configuration
public class BatchReaderConfiguration {

	@Bean
	JdbcCursorItemReader<BatchUserEntity> userItemReader(DataSource dataSource) {

		return new JdbcCursorItemReaderBuilder<BatchUserEntity>().dataSource(dataSource)
				.sql("Select id, name, email, age FROM batchusers").rowMapper((rs, rowNum) -> new BatchUserEntity(rs.getInt("id"),
						rs.getString("name"), rs.getString("email"), rs.getInt("age")))
				.name("batchUserItemReader").build();

	}
	
}
