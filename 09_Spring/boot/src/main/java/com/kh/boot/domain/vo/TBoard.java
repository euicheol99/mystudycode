package com.kh.boot.domain.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class TBoard {
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private int count;
    private String createDate;
    private String status;
    private String originName;
    private String changeName;
}
