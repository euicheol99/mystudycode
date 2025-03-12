package com.kh.boot.RESTController;

import com.kh.boot.domain.vo.Reply;
import com.kh.boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class APIBoardController {

    private final BoardService boardService;

    @PostMapping("/reply")
    public String insertReply(Reply r){
        return boardService.insertReply(r) > 0 ? "sucess" : "fail";
    }

    @GetMapping("/rlist.bo")
    public ArrayList<Reply> getReplyList(int bno){
        return boardService.getReplyList(bno);
    }
}
