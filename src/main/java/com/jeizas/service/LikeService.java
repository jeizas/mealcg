package com.jeizas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeizas.dao.LikeDao;
import com.jeizas.entity.Like;
import com.jeizas.utils.BaseService;
import com.jeizas.utils.Constants;
import com.jeizas.utils.ErrorCodes;

@Service("likeService")
public class LikeService extends BaseService<Like>{
	
	@Autowired
	public void setDao(LikeDao likeDao) {
		super.setDao(likeDao);
	}
	public LikeDao getDao() {
		return (LikeDao)super.getDao();
	}

	public Integer likeIt(Integer usrId, Integer foodId){
		Integer errorCode = ErrorCodes.SUCCESS;
		if(usrId != null && usrId >0 && foodId != null && foodId >0 ){
			Like like = new Like(usrId, foodId);
			getDao().save(like);
		} else{
			errorCode = ErrorCodes.INVALID_PARAM;
		}
		return errorCode;
	}
	
	public Integer likenot(Integer usrId, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		if(usrId != null && usrId >0 && id != null && id >0 ){
			Like like = getDao().findRecordByProperty("id", id);
			like.setDeleted(Constants.DELETED_YES);
			getDao().update(like);
		} else{
			errorCode = ErrorCodes.INVALID_PARAM;
		}
		return errorCode;
	}
}