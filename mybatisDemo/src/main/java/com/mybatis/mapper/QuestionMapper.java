package com.mybatis.mapper;

import com.mybatis.pojo.Question;

public interface QuestionMapper {
	Question selectById(Long id);
}
