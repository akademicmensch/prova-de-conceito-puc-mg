package br.com.sigo.normas.repositories;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import br.com.sigo.normas.contracts.NormaContract;
import br.com.sigo.normas.contracts.NormaUpdateContract;
import br.com.sigo.normas.models.Norma;
import br.com.sigo.normas.models.Status;
import br.com.sigo.normas.services.StatusService;

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
			st.setConsultoria(rs.getLong("consultoria"));
			st.setDocumento(rs.getBytes("documento"));
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
		String query = "SELECT co.* FROM norma co WHERE id = " + id;
		RowMapper<Norma> rowM = new NormaRowMap();
		Norma n = jdbcTemplate.queryForObject(query, rowM);
		return n;
	}



	public List<Norma> getAllNormas() {
		String query = "SELECT co.* FROM norma co";
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public List<Norma> getNormasByCategory(String id) {
		String query = "SELECT co.* FROM norma co WHERE categoria =  " + id;
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public List<Norma> getNormaByConsulting(String id) {
		String query = "SELECT co.* FROM norma co WHERE consultoria =  " + id;
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public List<Norma> getVigencyNormas() {
		String query = "SELECT co.* FROM norma co WHERE status = 1";
		RowMapper<Norma> rowM = new NormaRowMap();
		List<Norma> lst= jdbcTemplate.query(query, rowM);
		return lst;
	}



	public int updateNorma(String id, NormaUpdateContract c) {
		System.out.println("------------------UPDATE-------------------");
		System.out.println("Id chegando: " + id);
		System.out.println("Contrato chegando: ");
		System.out.println(c.getDescricao() + "   " + c.getNome() + "    " + c.getCategoria() + "    " + c.getConsultoria());
		System.out.println("------------------UPDATE-------------------");
		String query = "UPDATE norma set nome = '"+c.getNome()+"' , descricao = '"+c.getDescricao()+"' , categoria = "+c.getCategoria()+", consultoria = "+c.getConsultoria()+", processo = '"+c.getProcesso()+"' WHERE id = " + id;
		return jdbcTemplate.update(query);
	}



	public int createNorma(NormaContract c) {
		Long ultimoStatusTabelaNorma = obterUltimoStatusTabelaNorma().getId();
		ultimoStatusTabelaNorma += 1;
		String query = "INSERT into norma (id, processo, descricao, nome, categoria, status, consultoria) VALUES ("+ultimoStatusTabelaNorma+", '"+c.getProcesso()+"' , '"+c.getDescricao()+"', '"+c.getNome()+"', "+c.getCategoria()+", 1, "+c.getConsultoria()+")";
		/*String query2 = "INSERT INTO norma (id, descricao, nome, categoria, status, consultoria) VALUES (";
		query2+= ultimoStatusTabelaNorma;
		query2+= ", ";
		query2+= */
		return jdbcTemplate.update(query);
	}
	
	public Norma obterUltimoStatusTabelaNorma() {
		String query = "SELECT co.* FROM norma co order by id desc limit 1";
		RowMapper<Norma> rowM = new NormaRowMap();
		Norma lst = jdbcTemplate.queryForObject(query, rowM);
		return lst;
	}



	public int UpdatePDF(String id, MultipartFile file) throws IOException {
		InputStream inputStream = file.getInputStream();
		byte[] bytes = file.getBytes();
		
		InputStream inpS = new ByteArrayInputStream(bytes);
		
		
		String query = "UPDATE norma set documento = ? where id = ?";
		return jdbcTemplate.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement arg0) throws SQLException {
				arg0.setBinaryStream(1, inpS);
				arg0.setString(2, id);
			}
			
		});
		
		
	}


	
	public String getPDF(String id){
		String selectSQL = "SELECT co.* FROM norma co WHERE co.id = " + id;
		RowMapper<Norma> rowM = new NormaRowMap();
		Norma a = jdbcTemplate.queryForObject(selectSQL, rowM);
		/*
		try (OutputStream out = new FileOutputStream("out.pdf")) {
			   out.write(a.getDocumento());
		}*/
		String retorno = "";
		try {
			retorno = Base64.getEncoder().encodeToString(a.getDocumento());
		}catch(Exception e) {
			
		}
		return retorno;
	}
	

}
