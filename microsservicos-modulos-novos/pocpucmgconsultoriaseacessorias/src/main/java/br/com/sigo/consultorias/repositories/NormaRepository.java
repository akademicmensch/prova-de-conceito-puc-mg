package br.com.sigo.consultorias.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.sigo.consultorias.contracts.NormaContract;
import br.com.sigo.consultorias.contracts.NormaUpdateContract;
import br.com.sigo.consultorias.models.Norma;
import br.com.sigo.consultorias.models.Status;
import br.com.sigo.consultorias.services.StatusService;

@Repository
public class NormaRepository {
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	protected class NormaRowMap implements RowMapper<Norma>{
		public Norma mapRow(ResultSet rs, int rowNum) throws SQLException{
			Norma st = new Norma();
			st.setCategoria(rs.getLong("categoria"));
			st.setId(rs.getLong("id"));
			st.setNome(rs.getString("nome"));
			st.setDescricao(rs.getString("descricao"));
			st.setStatus(rs.getLong("status"));
			st.setProcesso(rs.getString("processo"));
			return st;
		}
	}
	
	
	
	public void desactiveNorma(String id) {
		Status st = statusService.searchInativeStatus();
		String query = "UPDATE norma set status = "+st.getId()+" WHERE id = " + id;
		int update = jdbcTemplate.update(query);
		System.out.println("Resultado: " + update);
	}



	public Norma getNormaById(String id) {
		String query = "SELECT co.* FORM norma co WHERE id = " + id;
		RowMapper<Norma> rowM = new NormaRowMap();
		Norma n = jdbcTemplate.queryForObject(query, rowM);
		return n;
	}



	public List<Norma> getAllNormas() {
		String query = "SELECT co.* FORM norma co";
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public List<Norma> getNormasByCategory(String id) {
		String query = "SELECT co.* FORM norma co WHERE categoria =  " + id;
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public List<Norma> getNormaByConsulting(String id) {
		String query = "SELECT co.* FORM norma co WHERE consultoria =  " + id;
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public List<Norma> getVigencyNormas() {
		String query = "SELECT co.* FORM norma co WHERE status = 1";
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public int updateNorma(String id, NormaUpdateContract c) {
		String query = "UPDATE norma set nome = "+c.getNome()+", descricao = "+c.getDescricao()+", categoria = "+c.getCategoria()+", consultoria = "+c.getConsultoria()+" WHERE id = " + id;
		return jdbcTemplate.update(query);
	}



	public int createNorma(NormaContract c) {
		Long ultimoStatusTabelaNorma = obterUltimoStatusTabelaNorma().getId();
		ultimoStatusTabelaNorma += 1;
		String query = "INSERT into norma (id, descricao, nome, categoria, status, consultoria) VALUES ("+ultimoStatusTabelaNorma+", "+c.getDescricao()+", "+c.getNome()+", "+c.getCategoria()+", 1, "+c.getConsultoria()+")";
		return jdbcTemplate.update(query);
	}
	
	public Norma obterUltimoStatusTabelaNorma() {
		String query = "SELECT co.* FORM norma co order by id desc limit 1";
		RowMapper<Norma> rowM = new NormaRowMap();
		Norma lst = jdbcTemplate.queryForObject(query, rowM);
		return lst;
	}
	

}
