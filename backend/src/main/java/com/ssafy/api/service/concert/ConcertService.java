package com.ssafy.api.service.concert;

import java.util.Optional;

import com.ssafy.api.request.ConcertRegisterPostReq;
import com.ssafy.db.entity.Concert;
import com.ssafy.db.entity.ConcertCategory;
import com.ssafy.db.entity.ConcertThumbnail;
import com.ssafy.db.entity.User;

public interface ConcertService {

	Concert createUser(ConcertRegisterPostReq registerInfo, ConcertThumbnail fileId, User userId, ConcertCategory categoryId);

}
