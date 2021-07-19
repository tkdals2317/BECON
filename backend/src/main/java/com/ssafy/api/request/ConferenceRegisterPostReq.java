package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ConferenceRegisterPostRequest")
public class ConferenceRegisterPostReq {
	@ApiModelProperty(name="소유자 ID", example="1")
	int owner_id;
	@ApiModelProperty(name="화상회의 Catrgory", example="1")
    int conference_category;
	@ApiModelProperty(name="화상회의 Start Time", example="2021-07-16 11:00")
    String call_start_time;
	@ApiModelProperty(name="화상회의 End Time", example="2021-07-16 12:00")
    String call_end_time;
	@ApiModelProperty(name="화상회의 Thumbnail Url", example="")
    String thumbnail_url;
	@ApiModelProperty(name="화상회의 Title", example="17일 스크럼 회의")
    String title;
	@ApiModelProperty(name="화상회의 Description", example="얼른 드러옹세요")
    String description;
	@ApiModelProperty(name="화상회의 Is Active", example="true")
    boolean is_active;
}
