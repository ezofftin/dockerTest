package com.mbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.domain.BoardDTO;
import com.mbc.domain.PageDTO;
import com.mbc.mapper.BoardMapper;

//@Service
public class BoardServiceImpl_old implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(BoardDTO dto) {
		mapper.insert(dto);
		
	}

	@Override
//	public List<BoardDTO> getList() {
	public List<BoardDTO> getList(PageDTO pDto) {
		
		int totalCnt = mapper.totalCnt();
		
		// setValue호출시 startIndex 셋팅됨 		
		pDto.setValue(totalCnt, pDto.getCntPerPage());
		
		
//		List<BoardDTO> list = mapper.getList();
//		return list;
		
		return mapper.getList(pDto);
	}

	@Override
	public BoardDTO view(int bid, String mode) {
		
		if(mode.equals("v")) {
			// 조회수 추가
			mapper.hitAdd(bid);
		}
		
		return mapper.view(bid);
	}

	@Override
	public void modify(BoardDTO dto) {		
		mapper.update(dto);
	}

	@Override
	public void remove(int bid) {
		mapper.delete(bid);
		
	}
	
}
