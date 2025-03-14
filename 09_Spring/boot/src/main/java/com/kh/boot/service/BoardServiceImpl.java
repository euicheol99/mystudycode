package com.kh.boot.service;

import com.kh.boot.domain.vo.*;
import com.kh.boot.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public int selectBoardCount() {
        return boardMapper.selectBoardCount();
    }

    @Override
    public ArrayList<Board> selectBoardList(PageInfo pi) {
        int offset = (pi.getCurrentPage() -1)* pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());

        return boardMapper.selectBoardList(rowBounds);
    }

    @Override
    public int insertBoard(Board board) {
        return boardMapper.insertBoard(board);
    }

    @Override
    public Board selectBoard(int boardNo) {
        return boardMapper.selectBoard(boardNo);
    }

    @Override
    public int increaseCount(int boardNo) {
        return boardMapper.increaseCount(boardNo);
    }

    @Override
    public int insertReply(Reply reply) {
        return boardMapper.insertReply(reply);
    }

    @Override
    public ArrayList<Reply> getReplyList(int bno) {
        return boardMapper.getReplyList(bno);
    }

    //댓글 갯수 가져오기
    @Override
    public int getReplyCount(int bno) {
        return boardMapper.getReplyCount(bno);
    }

    //게시글 조회수 탑5
    @Override
    public ArrayList<Board> getTopList() {
        return boardMapper.getTopList();
    }

    @Override
    public int updateBoard(Board b) {
        return boardMapper.updateBoard(b);
    }

    @Override
    public int selecthumbnailCount() {
        return boardMapper.selecthumbnailCount();
    }

    @Override
    public ArrayList<TBoard> selectTBoardList(PageInfo pi) {
        int offset = (pi.getCurrentPage() -1)* pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());

        return boardMapper.selectTBoardList(rowBounds);
    }

    @Override
    public int insertTBoard(TBoard board) {
        return boardMapper.insertTBoard(board);
    }

    @Override
    public int insertAttachment(ArrayList<Attachment> atlist) {
        return boardMapper.insertAttachment(atlist);
    }


}
