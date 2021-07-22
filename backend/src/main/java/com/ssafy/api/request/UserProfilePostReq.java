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
    String originName;
    String name;
    String path;

    public UserProfile toEntity() {
    	UserProfile build = UserProfile.builder()
                .originName(originName)
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
