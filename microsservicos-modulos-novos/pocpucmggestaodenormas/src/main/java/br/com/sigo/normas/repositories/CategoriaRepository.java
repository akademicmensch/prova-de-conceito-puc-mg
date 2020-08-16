package br.com.sigo.normas.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.sigo.normas.models.Categoria;
import br.com.sigo.normas.models.Status;
import br.com.sigo.normas.repositories.StatusRepository.StatusRowMap;

@Repository
public class CategoriaRepository {
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	protected class CategoriaRowMap implements RowMapper<Categoria>{
		public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException{
			Categoria st = new Categoria();
			st.setId(rs.getLong("id"));
			st.setDescricao(rs.getString("descricao"));
			return st;
		}
	}
	
	public Categoria obterCategoriaPorId(Long categoria) {
		Categoria retorno = new Categoria();
		String initialSelect = "select co.* FROM categoria co where co.id = " +categoria;
		RowMapper<Categoria> rowM = new CategoriaRowMap();
		try {
			retorno = jdbcTemplate.queryForObject(initialSelect, rowM);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public List<Categoria> obterCategorias() {
		List<Categoria> retorno = new ArrayList<>();
		String initialSelect = "select co.* FROM categoria co";
		RowMapper<Categoria> rowM = new CategoriaRowMap();
		try {
			retorno = jdbcTemplate.query(initialSelect, rowM);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
