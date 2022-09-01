package site.metacoding.red.domain.boards;

import java.sql.Timestamp;

import lombok.Getter;

@Getter
public class Boards {
	private Integer id;
	private String title;
	private String content;
	private Integer usersId;
	private Timestamp createdAt;
}
