package com.church.visit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.visit.dao.RecordDao;
import com.church.visit.dao.VisitorDao;
import com.church.visit.model.Record;
import com.church.visit.model.RecordCond;
import com.church.visit.model.RecordModel;

@Service("recordService")
public class RecordService {
	
	@Autowired
	private RecordDao recordDao;
	@Autowired
	private VisitorDao visitorDao;

	public List<RecordModel> queryByCond(RecordCond cond) {
		// TODO Auto-generated method stub
		
		if(cond.getStatus() ==null){
			cond.setStatus(Record.STATUS_ACCEPTED);
		}
		
			return recordDao.queryByCond(cond);
		
	}

	public RecordModel queryModel(Long id) {
		// TODO Auto-generated method stub
		return recordDao.queryModel(id);
	}

	public Integer updateModel(RecordModel recordModel) {
		// TODO Auto-generated method stub
		return recordDao.updateModel(recordModel);
	}

}
