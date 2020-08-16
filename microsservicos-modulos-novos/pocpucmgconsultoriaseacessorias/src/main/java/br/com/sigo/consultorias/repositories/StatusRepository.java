package br.com.sigo.consultorias.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.sigo.consultorias.models.Status;

@Repository
public class StatusRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	protected class StatusRowMap implements RowMapper<Status>{
		public Status mapRow(ResultSet rs, int rowNum) throws SQLException{
			Status st = new Status();
			st.setId(rs.getLong("id"));
			st.setDescricao(rs.getString("descricao"));
			return st;
		}
	}
	
	public List<Status> buscartodasAsOperacoes(){
        String initalSelect = "Select co.* FROM status co";
        RowMapper<Status> rowM = new StatusRowMap();
        List<Status> retorno = new ArrayList<>();
        try {
               retorno = jdbcTemplate.query(initalSelect, rowM);
        }catch(Exception e) {
        	e.printStackTrace();
  }
        return retorno;

  }

	public Status searchInativeStatus() {
		String initialSelect = "SELECT co.* FROM status co where descricao like 'INATIVO'";
		RowMapper<Status> rowM = new StatusRowMap();
		return jdbcTemplate.queryForObject(initialSelect, rowM);
	}

	public Status obterStatusPorId(Long status) {
		String initialSelect = "SELECT co.* FROM status co where id = " + status;
		RowMapper<Status> rowM = new StatusRowMap();
		return jdbcTemplate.queryForObject(initialSelect, rowM);
	}
	
	
}
