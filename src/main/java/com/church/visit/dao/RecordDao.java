package com.church.visit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.church.visit.model.RecordCond;
import com.church.visit.model.RecordModel;

public interface RecordDao {

	RecordModel queryModel(Long id);

	List<RecordModel> queryByCond(@Param("cond") RecordCond cond);

	Integer updateModel(RecordModel recordModel);

}
