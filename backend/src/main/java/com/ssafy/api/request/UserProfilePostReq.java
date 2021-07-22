package com.ssafy.api.request;

import com.ssafy.db.entity.UserProfile;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserProfilePostReq {
    private Long id;
    private String originName;
    private String name;
    private String path;

    public UserProfile toEntity() {
    	UserProfile build = UserProfile.builder()
                .origin_name(originName)
                .name(name)
                .path(path)
                .build();
        return build;
    }

    @Builder
    public UserProfilePostReq(String originName, String name, String path) {
        this.originName = originName;
        this.name = name;
        this.path = path;
    }
}
