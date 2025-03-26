package com.mbc.mapper;

import java.util.List;

import com.mbc.domain.BoardDTO;
import com.mbc.domain.PageDTO;

public interface BoardMapper {
    // 게시글 등록
    void insert(BoardDTO dto);

    // 게시글 리스트
    List<BoardDTO> getList(PageDTO pDto);

    // 글 상세보기
    BoardDTO view(int bid);

    // 글 수정하기
    void update(BoardDTO dto);

    // 글 삭제하기
    void delete(int bid);

    // 조회수 추가하기
    void hitAdd(int bid);

    // 좋아요 추가하기
    void likeAdd(int bid);

    // 전체 게시글 수
    int totalCnt();
}

