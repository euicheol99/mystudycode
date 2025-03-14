package com.kh.boot.domain.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Attachment {
    private int fileNo;
    private int refBno;
    private String originName;
    private String filePath;
    private String uploadDate;
    private int fileLevel;
    private String status;
}
