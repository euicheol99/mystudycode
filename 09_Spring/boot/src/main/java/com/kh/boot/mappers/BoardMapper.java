package com.kh.boot.mappers;

import com.kh.boot.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    int selectBoardCount();
    //게시글 목록 조회
    ArrayList<Board> selectBoardList(RowBounds rowBounds);
    //게시글 추가
    int insertBoard(Board board);
    //조회수 증가
    int increaseCount(@Param("bno") int boardNo);
    Board selectBoard(@Param("bno")int boardNo);
    //댓글추가
    int insertReply(Reply reply);

    //댓글 조회
    ArrayList<Reply> getReplyList(int bno);

    //댓글 갯수 조회
    int getReplyCount(int bno);

    //메인페이지의 top5 게시물 조회
    ArrayList<Board> getTopList();

    //보드 업데이트
    int updateBoard(Board b);

    //사진게시글갯수 조회
    int selecthumbnailCount();

    ArrayList<TBoard> selectTBoardList(RowBounds rowBounds);

    int insertTBoard(TBoard board);

    int insertAttachment(ArrayList<Attachment> atlist);
}
