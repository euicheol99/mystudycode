package com.kh.boot.controller;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.TBoard;
import com.kh.boot.service.BoardService;
import com.kh.boot.utils.Template;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list.bo")
    public String selectBoardList(@RequestParam(defaultValue = "1") int cpage, Model model) {
        int boardCount = boardService.selectBoardCount();

        PageInfo pi = new PageInfo(boardCount,cpage,10,5);
        ArrayList<Board> list = boardService.selectBoardList(pi);

        model.addAttribute("list",list);
        model.addAttribute("pi",pi);

        return "board/boardListView";
    }

    @GetMapping("enrollForm.bo")
    public String enrollForm(){
        return "board/boardEnrollForm";
    }

    @PostMapping("insert.bo")
    public String insertBoard(@ModelAttribute Board board, MultipartFile upfile, HttpSession session,Model model){
        System.out.println(board);
        System.out.println(upfile);

        if(!upfile.getOriginalFilename().equals("")){
            String changeName = Template.saveFile(upfile,session,"/resources/uploadfile/");

            board.setChangeName("/resources/uploadfile/" + changeName);
            board.setOriginName(upfile.getOriginalFilename());
        }

        int result = boardService.insertBoard(board);

        if(result > 0){
            session.setAttribute("alertMsg","게시글 작성 성공");
            return "redirect:/list.bo";
        } else {
            model.addAttribute("errorMsg","게시글 작성 실패");
            return "common/errorPage";
        }

    }

    @GetMapping("detail.bo")
    public String selectBoardDetail(@RequestParam(value = "bno") int boardNo,Model model){
        int result = boardService.increaseCount(boardNo);

        if(result > 0){
            Board b = boardService.selectBoard(boardNo);
            model.addAttribute("b",b);
            System.out.println(b);
            return "board/boardDetailView";
        } else {
            model.addAttribute("errorMsg","게시글 조회 실패");
            return "common/errorPage";
        }
    }

    @GetMapping("updateForm.bo")
    public String updateBoard(@RequestParam(value = "bno") int boardNo, Model model){
        model.addAttribute("b",boardService.selectBoard(boardNo));
        return "board/boardUpdateForm";
    }

    @PostMapping("update.bo")
    public String updateBoard(@ModelAttribute Board b,HttpSession session,MultipartFile reupfile,Model model ){
        //새로운 첨부파일이 있다면 저장 후 b객체에 파일명 수정
        //b객체 전달받은 값으로 수정

        if(!reupfile.getOriginalFilename().equals("")){
            //기존첨파일 삭제
            if(b.getChangeName() != null && !b.getChangeName().equals("")){
                new File(session.getServletContext().getRealPath(b.getChangeName())).delete();
            }
            String changeName = Template.saveFile(reupfile,session,"/resources/uploadfile/");

            b.setChangeName("/resources/uploadfile/" + changeName);
            b.setOriginName(reupfile.getOriginalFilename());
        }
        int result = boardService.updateBoard(b);

        if(result > 0){
            session.setAttribute("alert","성공적으로 수정되었습니다.");
        } else {
            model.addAttribute("errorMsg","수정에 실패하였습니다.");
        }

        return "redirect:/list.bo";
    }

    @GetMapping("thumbnail.bo")
    public String selectthumbnailList(@RequestParam(defaultValue = "1") int cpage, Model model) {
        int thumbnailCount = boardService.selecthumbnailCount();

        PageInfo pi = new PageInfo(thumbnailCount,cpage,10,6);
        ArrayList<TBoard> list = boardService.selectTBoardList(pi);

        model.addAttribute("list",list);
        model.addAttribute("pi",pi);

        return "board/thumbnailListView";
    }

    @GetMapping("enrollForm.th")
    public String enrollTh(){
        return "board/thumnailEnrollForm";
    }

    @PostMapping("insert.th")
    public String insertTh(TBoard board, @RequestParam("tfile") MultipartFile tfile, @RequestParam("files") MultipartFile[] files, HttpSession session, Model model){
        System.out.println(board);
        System.out.println(tfile);
        System.out.println(files);


        ArrayList<Attachment> atlist = new ArrayList<>();

        if(!tfile.getOriginalFilename().equals("")){
            String changeName = Template.saveFile(tfile,session,"/resources/uploadfile/");

            Attachment tAt = new Attachment();
            tAt.setRefBno(board.getBoardNo());
            tAt.setOriginName(tfile.getOriginalFilename());
            tAt.setFilePath("/resources/uploadfile/"+changeName);
            tAt.setFileLevel(1);

            atlist.add(tAt);

            board.setChangeName("/resources/uploadfile/" + changeName);
            board.setOriginName(tfile.getOriginalFilename());
        }

        for(MultipartFile f : files){
            if(!f.getOriginalFilename().equals("")){
                String changeName = Template.saveFile(f,session,"/resources/uploadfile/");

                Attachment at = new Attachment();
                at.setRefBno(board.getBoardNo());
                at.setOriginName(tfile.getOriginalFilename());
                at.setFilePath("/resources/uploadfile/"+changeName);
                at.setFileLevel(2);

                atlist.add(at);

                board.setChangeName("/resources/uploadfile/" + changeName);
                board.setOriginName(tfile.getOriginalFilename());
            }
        }

        int result1 = boardService.insertTBoard(board);
        int result2 = boardService.insertAttachment(atlist);

        if(result1 * result2 > 0){
            session.setAttribute("alertMsg","게시글 작성 성공");
            return "redirect:/list.bo";
        } else {
            model.addAttribute("errorMsg","게시글 작성 실패");
            return "common/errorPage";
        }
    }
}
