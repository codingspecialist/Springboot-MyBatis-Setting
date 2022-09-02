package site.metacoding.red.domain.boards.orm;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.red.domain.users.Users;

@AllArgsConstructor
@NoArgsConstructor
@Setter 
@Getter
public class BoardsOrm {
	private Integer id;
	private String title;
	private String content;
	private Users users;
	private Timestamp createdAt;
}
