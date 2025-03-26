package com.mbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbc.domain.BoardDTO;
import com.mbc.domain.PageDTO;
//import com.mbc.service.BoardService;
import com.mbc.service.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardServiceImpl service;

    // 게시글 등록 페이지 이동
    @GetMapping("/register.do")
    public String register() {
        return "board/register";
    }

    // 게시글 등록 처리
    @PostMapping("/register.do")
    public String register(BoardDTO dto) {
        service.register(dto);
        return "redirect:/board/list.do";
    }

    // 게시글 리스트 (페이징 처리)
    @GetMapping("/list.do")
    public String list(PageDTO pDto, Model model) {
        List<BoardDTO> list = service.getList(pDto);
        model.addAttribute("list", list);
        model.addAttribute("pDto", pDto); // 페이징 정보 추가
        return "board/boardList";
    }

    // 게시글 상세보기 (조회수 증가 포함)
    @GetMapping("/view.do")
    public String view(int bid, PageDTO pDto, Model model) {
        BoardDTO dto = service.view(bid, "v");
        model.addAttribute("dto", dto);
        model.addAttribute("pDto", pDto);
        return "board/view";
    }

    // 수정 페이지 이동
    @GetMapping("/modify.do")
    public String modifyForm(int bid, Model model) {
        BoardDTO dto = service.view(bid, "m");
        model.addAttribute("dto", dto);
        return "board/modify";
    }

    // 게시글 수정 처리 (수정 날짜 반영)
    @PostMapping("/modify.do")
    public String modify(BoardDTO dto) {
        service.modify(dto);
        return "redirect:list.do";
    }

    // 게시글 삭제
    @GetMapping("/remove.do")
    public String remove(int bid) {
        service.remove(bid);
        return "redirect:list.do";
    }

    // 좋아요 증가 기능 추가
    @GetMapping("/like.do")
    public String addLike(int bid, PageDTO pDto) {
        service.addLike(bid);
        return "success";
    }
}
