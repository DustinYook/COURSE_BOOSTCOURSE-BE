package kr.or.connect.guestbook.dao;

import org.springframework.stereotype.Repository;
import kr.or.connect.guestbook.dto.Log;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@Repository
public class LogDao 
{
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    public LogDao(DataSource dataSource) 
    {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("log")
                .usingGeneratedKeyColumns("id"); // ID가 자동으로 입력되게 하는 설정
    }

	public Long insert(Log log) 
	{
		SqlParameterSource params = new BeanPropertySqlParameterSource(log);
		return insertAction.executeAndReturnKey(params).longValue();
		// executeAndReturnKey(params) : INSERT를 실행하고 자동 생성된 ID 값을 리턴
	}
}