package site.metacoding.red.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.web.dto.request.boards.UpdateDto;
import site.metacoding.red.web.dto.request.boards.WriteDto;
import site.metacoding.red.web.dto.response.RespDto;

@RequiredArgsConstructor
@RestController
public class BoardsController {
	
	private final BoardsDao boardsDao;


	@PostMapping("/boards")
	public RespDto<?> insert(WriteDto writeDto){ // x-www 머시기 (key=value&key=value)
		boardsDao.insert(writeDto);
		return new RespDto<>(1, "글쓰기성공", null);
	}
	
	@GetMapping("/boards")
	public RespDto<?> getAll(){
		return new RespDto<>(1, "글전체조회성공", boardsDao.findAll());
	}
	
	@GetMapping("/boards/{id}")
	public RespDto<?> getOne(@PathVariable Integer id){
		return new RespDto<>(1, "글조회성공", boardsDao.findByIdtoDetail(id));
	}
	
	@DeleteMapping("/boards/{id}")
	public RespDto<?> delete(@PathVariable Integer id){
		boardsDao.delete(id);
		return new RespDto<>(1, "글삭제성공", null);
	}
	
	@PutMapping("/boards/{id}")
	public RespDto<?> update(@PathVariable Integer id, UpdateDto updateDto){
		// 영속화
		Boards boards = boardsDao.findById(id);
		
		// 변경
		boards.글전체수정(updateDto);
		
		// update 실행
		boardsDao.update(boards);
		
		return new RespDto<>(1, "글수정성공", null);
	}
	
	
}
