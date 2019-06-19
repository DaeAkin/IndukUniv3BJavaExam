package iducs.springboot.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iducs.springboot.board.domain.Answer;

@Entity
@Table (name="answer")
public class AnswerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_answer_writer")
	private UserEntity writer;
	
	@ManyToOne
	@JoinColumn(name="fk_answer_question")
	private QuestionEntity question;

	@Lob
	private String contents;
	private LocalDateTime createTime;
	
	public Answer buildDomain() {
		Answer answer = new Answer();
		answer.setId(id);
		answer.setWriter(writer.buildDomain());
		answer.setQuestion(question.buildDomain());
		answer.setContents(contents);
		answer.setCreateTime(createTime);
		return answer;
	}
	public void buildEntity(Answer answer) {
		id = answer.getId();

		UserEntity userEntity = new UserEntity();
		userEntity.buildEntity(answer.getWriter());
		writer = userEntity;
		
		QuestionEntity quesitonEntity = new QuestionEntity();
		quesitonEntity.buildEntity(answer.getQuestion());
		question = quesitonEntity;
		
		contents = answer.getContents();
		createTime = answer.getCreateTime();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerEntity other = (AnswerEntity) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
