package site.metacoding.red.domain.boards;

import java.util.List;

import site.metacoding.red.domain.boards.orm.BoardsOrm;
import site.metacoding.red.web.dto.request.boards.WriteDto;

public interface BoardsDao {
	public BoardsOrm findByIdOrm(Integer id); 
	public void insert(WriteDto writeDto);
	public Boards findById(Integer id);
	public List<Boards> findAll();
	public void update(Boards boards);
	public void delete(Integer id);
}
