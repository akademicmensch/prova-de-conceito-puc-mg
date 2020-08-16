package br.com.sigo.consultorias.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.sigo.consultorias.contracts.ContratarContract;
import br.com.sigo.consultorias.models.Consultoria;

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
	
	//Contratar Consultoria
	public int contratarConsultoria(ContratarContract c, Date inicio, Date fim) {
		Long id = obterUltimoIdTabelaConsultoria();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String inicioString = format.format(inicio);
		String fimString = format.format(fim);
		
		String querie = "INSERT INTO consultoria (id, descricao, status, cnpj, iniciocontrato, fimcontrato, processo) "; 
		querie += "VALUES("+id+",'"+c.getDescricao()+"' ,"+1+", '"+c.getCnpj()+"' , '"+inicioString+"' , '"+fimString+"' , '"+c.getProcesso()+"')";
		return jdbcTemplate.update(querie);
	}

	private Long obterUltimoIdTabelaConsultoria() {
		String query = "SELECT co.* FROM consultoria co order by id desc limit 1";
		RowMapper<Consultoria> rowM = new ConsultoriaRowMap();
		Consultoria lst = jdbcTemplate.queryForObject(query, rowM);
		Long i = lst.getId();
		Long retorno = i+1;
		return retorno;
	}

	public List<Consultoria> obterTodasAsConsultorias() {
		String initalSelect = "Select co.* FROM consultoria co";
		RowMapper<Consultoria> rowM = new ConsultoriaRowMap();
		return jdbcTemplate.query(initalSelect, rowM);
	}

	public List<Consultoria> obterConsultoriasPorFiltro(String querie) {
		String initalSelect = "Select co.* FROM consultoria co" + querie;
		RowMapper<Consultoria> rowM = new ConsultoriaRowMap();
		
		return jdbcTemplate.query(initalSelect, rowM);
	}

	public int finalizarContratoConsultoria(String id) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		String qu = format.format(dt);
		String querie = "UPDATE consultoria set status = 2, fimcontrato = '" + qu + "' WHERE id = " + id;
		return jdbcTemplate.update(querie);
	}

	public int prorrogarContratoConsultoria(String id, Date fimContrato) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fimContratoS = format.format(fimContrato);
		String querie = "UPDATE consultoria set fimcontrato = '" + fimContratoS + "' WHERE id = " + id;
		return jdbcTemplate.update(querie);
	}

}
