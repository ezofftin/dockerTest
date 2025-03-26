package com.mbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.domain.BoardDTO;
import com.mbc.domain.PageDTO;
import com.mbc.mapper.BoardMapper;

@Service
public class BoardServiceImpl {

    @Autowired
    private BoardMapper mapper;

    // 게시글 등록
    public void register(BoardDTO dto) {
        mapper.insert(dto);
    }

    // 게시글 리스트 가져오기
    public List<BoardDTO> getList(PageDTO pDto) {
        int totalCnt = mapper.totalCnt();
        
        // setValue 호출 시 startIndex 설정
        pDto.setValue(totalCnt, pDto.getCntPerPage());
        
        return mapper.getList(pDto);
    }

    // 게시글 상세보기 (조회수 증가 포함)
    public BoardDTO view(int bid, String mode) {
        if (mode.equals("v")) {
            // 조회수 증가
            mapper.hitAdd(bid);
        }
        return mapper.view(bid);
    }

    // 게시글 수정 (수정 날짜 추가)
    public void modify(BoardDTO dto) {  
        dto.setModify_date(new java.util.Date()); // 현재 시간 설정
        mapper.update(dto);
    }

    // 게시글 삭제
    public void remove(int bid) {
        mapper.delete(bid);
    }

    // 좋아요 증가 기능 추가
    public void addLike(int bid) {
        mapper.likeAdd(bid);
    }
}

