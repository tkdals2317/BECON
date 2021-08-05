package com.ssafy.api.request;

import com.ssafy.db.entity.ConcertThumbnail;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ConcertThumbnailPostReq {
    private Long id;
    private String originName;
    private String name;
    private String path;

    public ConcertThumbnail toEntity() {
    	ConcertThumbnail build = ConcertThumbnail.builder()
                .originName(originName)
                .name(name)
                .path(path)
                .build();
        return build;
    }

    @Builder
    public ConcertThumbnailPostReq(String originName, String name, String path) {
        this.originName = originName;
        this.name = name;
        this.path = path;
    }
}
