package com.ssafy.api.request;

import com.ssafy.db.entity.ConcertPoster;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ConcertPosterPostReq {
    private Long id;
    private String originName;
    private String name;
    private String path;

    public ConcertPoster toEntity() {
    	ConcertPoster build = ConcertPoster.builder()
                .originName(originName)
                .name(name)
                .path(path)
                .build();
        return build;
    }

    @Builder
    public ConcertPosterPostReq(String originName, String name, String path) {
        this.originName = originName;
        this.name = name;
        this.path = path;
    }
}
