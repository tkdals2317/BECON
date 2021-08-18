package com.ssafy.api.response;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Concert;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@ApiModel("ConcertConfirmRequest")
public class ConcertWeeklyRes extends BaseResponseBody{
	@ApiModelProperty(name="주간 공연")
	Map<String, List<ConcertShowRes>> map;

	public static ConcertWeeklyRes of(List<Concert> list) {
		ConcertWeeklyRes res=new ConcertWeeklyRes();
		Map<String, List<ConcertShowRes>> map = new HashMap<String, List<ConcertShowRes>>();
		map.put("Mon", new ArrayList<>());
		map.put("Tue", new ArrayList<>());
		map.put("Wed", new ArrayList<>());
		map.put("Thu", new ArrayList<>());
		map.put("Fri", new ArrayList<>());
		map.put("Sat", new ArrayList<>());
		map.put("Sun", new ArrayList<>());
		
		for (Concert concert : list) {
			LocalDate date = LocalDate.parse(concert.getStartTime().split(" ")[0]);
			DayOfWeek dayOfWeek = date.getDayOfWeek();
			String key = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
			
			List<ConcertShowRes> concerts = map.get(key);
			concerts.add(ConcertShowRes.of(concert));
			map.put(key, concerts);
		}
		
		res.setMap(map);
		return res;
	}
}

