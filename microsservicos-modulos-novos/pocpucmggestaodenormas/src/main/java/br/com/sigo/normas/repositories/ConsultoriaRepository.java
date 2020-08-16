package br.com.sigo.normas.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.sigo.normas.models.Consultoria;

@Repository
public class ConsultoriaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	protected class ConsultoriaRowMap implements RowMapper<Consultoria>{
		public Consultoria mapRow(ResultSet rs, int rowNum) throws SQLException{
			Consultoria st = new Consultoria();
			st.setId(rs.getLong("id"));
			st.setDescricao(rs.getString("descricao"));
			st.setStatus(rs.getLong("status"));
			st.setCnpj(rs.getString("cnpj"));
			st.setInicioContrato(rs.getDate("iniciocontrato"));
			st.setFimContrato(rs.getDate("fimcontrato"));
			st.setProcesso(rs.getString("processo"));
			return st;
		}
	}

	public Consultoria obterConsultoriaPorId(Long consultoria) {
		String initalSelect = "Select co.* FROM consultoria co WHERE id = " + consultoria;
		RowMapper<Consultoria> rowM = new ConsultoriaRowMap();
		Consultoria retorno = new Consultoria();
		try {
			retorno = jdbcTemplate.queryForObject(initalSelect, rowM);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
