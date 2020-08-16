package br.com.sap.processos.industriais.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Detail;
import io.spring.guides.gs_producing_web_service.Process;


@Component
public class ProcessRepository {
	private static final Map<String, Process> processes = new HashMap<>();

	@PostConstruct
	public void initData() {
		alimentacaoInicialDeProcessos(processes);
	}

	public io.spring.guides.gs_producing_web_service.Process findProcess(String name) {
		Assert.notNull(name, "The process's name must not be null");
		return processes.get(name);
	}

	public List<Process> findAllProcessess() {
		List<Process> retorno = new ArrayList<>();

		for(Map.Entry<String, Process> entry : processes.entrySet()) {
			Process value = entry.getValue();
			retorno.add(value);
		}
		return retorno;
	}
	
	private void alimentacaoInicialDeProcessos(Map<String, Process> processes2) {
		//Verificacao das linhas de producao
		Process verificaLinhasDeProducao = new Process();
		verificaLinhasDeProducao.setId("1");
		verificaLinhasDeProducao.setName("Verificacao de linha de producao");
		verificaLinhasDeProducao.setPeopleEnvolved(0);
		verificaLinhasDeProducao.setEnterpriseCategory("");
		verificaLinhasDeProducao.setSite("");
		Detail detailVerificaLinhasDeProducao = new Detail();
		detailVerificaLinhasDeProducao.setStep1("Etapa 1: Verificao do status de funcionamento das maquinas de preparacao de materia-prima");
		detailVerificaLinhasDeProducao.setStep2("Etapa 2: Verificao do status de funcionamento das maquinas envolvidas no processo de fiacao");
		detailVerificaLinhasDeProducao.setStep3("Etapa 3: Verificao do status de funcionamento das maquinas envolvidas no processo de Tecelagem e Tricolagem");
		detailVerificaLinhasDeProducao.setStep4("Etapa 4: Verificao do status de funcionamento das maquinas envolvidas no processo de preparacao de tingimento");
		detailVerificaLinhasDeProducao.setStep5("Etapa 5: Verificao do status de funcionamento das maquinas envolvidas no processo de tingimento");
		detailVerificaLinhasDeProducao.setStep6("Etapa 6: Verificao do status de funcionamento das maquinas envolvidas no processo de estamparia");
		detailVerificaLinhasDeProducao.setStep7("Etapa 7: Verificao do status de funcionamento das maquinas envolvidas no processo de acabamentos quimicos");
		detailVerificaLinhasDeProducao.setStep8("Etapa 8: Verificao do status de funcionamento das maquinas envolvidas no processo de acabamentos mecanicos");
		detailVerificaLinhasDeProducao.setStep9("Etapa 9: Verificao do status de funcionamento das maquinas envolvidas no processo de confeccao");
		detailVerificaLinhasDeProducao.setStep10("Etapa 10: Correcoes em maquinas defeituosas");
		verificaLinhasDeProducao.setDetail(detailVerificaLinhasDeProducao);
		processes.put(verificaLinhasDeProducao.getName(), verificaLinhasDeProducao);
		
		//Preparacao da Materia Prima
		Process preparacaoDaMateriaPrima = new Process();
		preparacaoDaMateriaPrima.setId("2");
		preparacaoDaMateriaPrima.setName("Preparacao da Materia Prima");
		preparacaoDaMateriaPrima.setPeopleEnvolved(39);
		preparacaoDaMateriaPrima.setEnterpriseCategory("");
		preparacaoDaMateriaPrima.setSite("");
		Detail detailPreparacaoDaMateriaPrima = new Detail();
		detailPreparacaoDaMateriaPrima.setStep1("Etapa 1: Producao de fibras sinteticas");
		detailPreparacaoDaMateriaPrima.setStep2("Etapa 2: Producao de fibras semi-sinteticas");
		detailPreparacaoDaMateriaPrima.setStep3("Etapa 3: Producao de fibras naturais");
		detailPreparacaoDaMateriaPrima.setStep4("Etapa 4: Penteado de fibras sinteticas e semi-sinteticas");
		detailPreparacaoDaMateriaPrima.setStep5("Etapa 5: Penteado de fibras naturais");
		detailPreparacaoDaMateriaPrima.setStep7("Etapa 7: Cadado de fibras sinteticas e semi-sinteticas");
		detailPreparacaoDaMateriaPrima.setStep8("Etapa 8: Cadado de fibras naturais");
		detailPreparacaoDaMateriaPrima.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas");
		detailPreparacaoDaMateriaPrima.setStep10("Etapa 10: Finalizacao do processo de preparacao de materia prima");
		preparacaoDaMateriaPrima.setDetail(detailPreparacaoDaMateriaPrima);
		processes.put(preparacaoDaMateriaPrima.getName(), preparacaoDaMateriaPrima);
		
		//Fiação – produção de fio;
		Process fiacao = new Process();
		fiacao.setName("Fiacao");
		fiacao.setId("3");
		fiacao.setPeopleEnvolved(11);
		fiacao.setEnterpriseCategory("");
		fiacao.setSite("");
		Detail detailFiacao = new Detail();
		detailFiacao.setStep1("Etapa 1: Verificacao de estados e quantidade de materiais disponiveis para processo de fiacao");
		detailFiacao.setStep2("Etapa 2: Calculo de materiais para distribuicao em maquinas");
		detailFiacao.setStep3("Etapa 3: Calculo de materiais e maquinas disponiveis para divisao em lote");
		detailFiacao.setStep4("Etapa 4: Processo de fiacao utilizando lote de fibras sinteticas");
		detailFiacao.setStep5("Etapa 5: Processo de fiacao utilizando lote de fibras semi-sinteticas");
		detailFiacao.setStep6("Etapa 6: Processo de fiacao utilizando lote de fibras naturais");
		detailFiacao.setStep7("Etapa 7: Acabamento de fiacao de fibras sinteticas e semi-sinteticas");
		detailFiacao.setStep8("Etapa 8: Acabamento de fiacao de fibras naturais");
		detailFiacao.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas");
		detailFiacao.setStep10("Etapa 10: Finalizacao do processo de fiacao");
		fiacao.setDetail(detailFiacao);
		processes.put(fiacao.getName(), fiacao);
		
		//Tecelagem ou tricotagem – produção de fio;
		Process tecelagemTricolagem = new Process();
		tecelagemTricolagem.setName("Tecelagem e Tricolagem");
		tecelagemTricolagem.setId("4");
		tecelagemTricolagem.setPeopleEnvolved(27);
		tecelagemTricolagem.setSite("");
		tecelagemTricolagem.setEnterpriseCategory("");
		Detail detailTecelagemTricolagem = new Detail();
		detailTecelagemTricolagem.setStep1("Etapa 1: Calculo de materiais para distribuicao em maquinas");
		detailTecelagemTricolagem.setStep2("Etapa 2: Calculo de materiais e maquinas disponiveis para divisao em lote");
		detailTecelagemTricolagem.setStep3("Etapa 3: Processo de tecelagem de padrao tela");
		detailTecelagemTricolagem.setStep4("Etapa 4: Processo de tecelagem de padrao sarja");
		detailTecelagemTricolagem.setStep5("Etapa 5: Processo de tecelagem de padrao jacquard");
		detailTecelagemTricolagem.setStep6("Etapa 6: Processo de abertura da cala");
		detailTecelagemTricolagem.setStep7("Etapa 7: Processo de insercao da trama");
		detailTecelagemTricolagem.setStep8("Etapa 8: Processo de batida de pente");
		detailTecelagemTricolagem.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas: ");
		detailTecelagemTricolagem.setStep10("Etapa 10: Finalizacao do processo de tecelagem e tricolagem");
		tecelagemTricolagem.setDetail(detailTecelagemTricolagem);
		processes.put(tecelagemTricolagem.getName(), tecelagemTricolagem);
		
		//Preparação para o tingimento – produção de rama, penteado, fio, tecido ou malha ou produto pronto a tingir;
		Process preparacaoParaTingimento = new Process();
		preparacaoParaTingimento.setName("Preparacao para o tingimento");
		preparacaoParaTingimento.setId("5");
		preparacaoParaTingimento.setPeopleEnvolved(8);
		preparacaoParaTingimento.setSite("");
		preparacaoParaTingimento.setEnterpriseCategory("");
		Detail detailPreparacaoParaTingimento = new Detail();
		detailPreparacaoParaTingimento.setStep1("Etapa 1: Calculo de materiais e volume de tinta disponivel");
		detailPreparacaoParaTingimento.setStep2("Etapa 2: Calculo e volume de pecas destinadas ao tingimento");
		detailPreparacaoParaTingimento.setStep3("Etapa 3: Processo de mistura para coloracoes utilizadas em lotes do tipo sintetico");
		detailPreparacaoParaTingimento.setStep4("Etapa 4: Processo de mistura para coloracoes utilizadas em lotes do tipo semi sintetico");
		detailPreparacaoParaTingimento.setStep5("Etapa 5: Processo de mistura para coloracoes utilizadas em lotes do tipo natural");
		detailPreparacaoParaTingimento.setStep6("Etapa 6: Processo de mistura para coloracoes utilizadas em lotes do tipo especial");
		detailPreparacaoParaTingimento.setStep7("Etapa 7: Processo de limpeza de maquinas pos mistura");
		detailPreparacaoParaTingimento.setStep8("Etapa 8: Checagem de tinturas restantes e envios de pedidos para reposicao");
		detailPreparacaoParaTingimento.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas: ");
		detailPreparacaoParaTingimento.setStep10("Etapa 10: Finalizacao do processo de preparacao para tingimento");
		preparacaoParaTingimento.setDetail(detailPreparacaoParaTingimento);
		processes.put(preparacaoParaTingimento.getName(), preparacaoParaTingimento);
		
		//Tingimento – produção de rama, penteado, fio, tecido, malha ou produto acabado tingido;
		Process tingimento = new Process();
		tingimento.setName("Tingimento");
		tingimento.setId("6");
		tingimento.setEnterpriseCategory("");
		tingimento.setPeopleEnvolved(7);
		tingimento.setSite("");
		Detail detailTingimento = new Detail();
		detailTingimento.setStep1("Etapa 1: Checagem de tinturas disponiveis");
		detailTingimento.setStep2("Etapa 2: Calculo de tinturas para distribuicao em maquinas");
		detailTingimento.setStep3("Etapa 3: Calculo de tinturas e maquinas disponiveis para divisao em lote");
		detailTingimento.setStep4("Etapa 4: Processo de tingimento para pecas sinteticas");
		detailTingimento.setStep5("Etapa 5: Processo de tingimento para pecas semi sinteticas");
		detailTingimento.setStep6("Etapa 6: Processo de tingimento para pecas naturais");
		detailTingimento.setStep7("Etapa 7: Processo de tingimento para pecas especiais");
		detailTingimento.setStep8("Etapa 8: Checagem de tinturas restantes e envios de pedidos para reposicao");
		detailTingimento.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas");
		detailTingimento.setStep10("Etapa 10: Finalizacao do processo de tingimento");
		tingimento.setDetail(detailTingimento);
		processes.put(tingimento.getName(), tingimento);
		
		//Estamparia – produção de tecido ou malha estampado;
		Process estamparia = new Process();
		estamparia.setName("Estamparia");
		estamparia.setId("7");
		estamparia.setPeopleEnvolved(5);
		estamparia.setSite("");
		estamparia.setEnterpriseCategory("");
		Detail detailEstamparia = new Detail();
		detailEstamparia.setStep1("Etapa 1: Checagem da temperatura das prensas");
		detailEstamparia.setStep2("Etapa 2: Manutencao da temperatura das prensas");
		detailEstamparia.setStep3("Etapa 3: Estampagem de tecidos rusticos");
		detailEstamparia.setStep4("Etapa 4: Estampagem de tecidos regulares");
		detailEstamparia.setStep5("Etapa 5: Estampagem de tecidos finos");
		detailEstamparia.setStep6("Etapa 6: Estampagem de tecidos exoticos");
		detailEstamparia.setStep7("Etapa 7: Verificacao da temperatura das prensas");
		detailEstamparia.setStep8("Etapa 8: Manutencao da temperatura das prenas");
		detailEstamparia.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas");
		detailEstamparia.setStep10("Etapa 10: Finalizacao do processo de estamparia");
		estamparia.setDetail(detailEstamparia);
		processes.put(estamparia.getName(), estamparia);
		
		//Acabamentos químicos – produção de tecido ou malhas com características específicas;
		Process acabamentosQuimicos = new Process();
		acabamentosQuimicos.setName("Acabamentos Quimicos");
		acabamentosQuimicos.setId("8");
		acabamentosQuimicos.setPeopleEnvolved(2);
		acabamentosQuimicos.setEnterpriseCategory("");
		acabamentosQuimicos.setSite("");
		Detail detailAcabamentosQuimicos = new Detail();
		detailAcabamentosQuimicos.setStep1("Etapa 1: Checagem de substancias disponiveis");
		detailAcabamentosQuimicos.setStep2("Etapa 2: Calculo de substancias para distribuicao em maquinas");
		detailAcabamentosQuimicos.setStep3("Etapa 3: Calculo de substancias, pecas e maquinas disponiveis para divisao em lote");
		detailAcabamentosQuimicos.setStep4("Etapa 4: Mistura de substancias necessarias por lote");
		detailAcabamentosQuimicos.setStep5("Etapa 5: Composicao de acabamentos quimicos para lote de pecas sinteticas");
		detailAcabamentosQuimicos.setStep6("Etapa 6: Composicao de acabamentos quimicos para lote de pecas semi sinteticas");
		detailAcabamentosQuimicos.setStep7("Etapa 7: Composicao de acabamentos quimicos para lote de pecas naturais");
		detailAcabamentosQuimicos.setStep8("Etapa 8: Composicao de acabamentos quimicos para lote de pecas especiais");
		detailAcabamentosQuimicos.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas");
		detailAcabamentosQuimicos.setStep10("Etapa 10: Finalizacao do processo de acabamentos quimicos");
		acabamentosQuimicos.setDetail(detailAcabamentosQuimicos);
		processes.put(acabamentosQuimicos.getName(), acabamentosQuimicos);
		
		//Acabamentos mecânicos – produção de tecido com características específicas;
		Process acabamentosMecanicos = new Process();
		acabamentosMecanicos.setName("Acabamentos Mecanicos");
		acabamentosMecanicos.setId("9");
		acabamentosMecanicos.setPeopleEnvolved(5);
		acabamentosMecanicos.setSite("");
		acabamentosMecanicos.setEnterpriseCategory("");
		Detail detailAcabamentosMecanicos = new Detail();
		detailAcabamentosMecanicos.setStep1("Etapa 1: Checagem de acessorios mecanicos disponiveis");
		detailAcabamentosMecanicos.setStep2("Etapa 2: Calculo de materiais para distribuicao em maquinas");
		detailAcabamentosMecanicos.setStep3("Etapa 3: Calculo de materiais e maquinas disponiveis para divisao em lote");
		detailAcabamentosMecanicos.setStep4("Etapa 4: Composicao de acessorios mecanicos ao lote de pecas sinteticas");
		detailAcabamentosMecanicos.setStep5("Etapa 5: Composicao de acessorios mecanicos ao lote de pecas semi sinteticas");
		detailAcabamentosMecanicos.setStep6("Etapa 6: Composicao de acessorios mecanicos ao lote de pecas naturais");
		detailAcabamentosMecanicos.setStep7("Etapa 7: Composicao de acessorios mecanicos ao lote de pecas especiais");
		detailAcabamentosMecanicos.setStep8("Etapa 8: Checagem de acessorios mecanicos restantes e envios de pedidos para reposicao");
		detailAcabamentosMecanicos.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas");
		detailAcabamentosMecanicos.setStep10("Etapa 10: Finalizacao do processo de acabamentos mecanicos");
		acabamentosMecanicos.setDetail(detailAcabamentosMecanicos);
		processes.put(acabamentosMecanicos.getName(), acabamentosMecanicos);
		
		//Confecção – produção de têxteis lar, têxteis técnicos, vestuários.*/
		Process confeccao = new Process();
		confeccao.setName("Confeccao");
		confeccao.setEnterpriseCategory("");
		confeccao.setId("10");
		confeccao.setSite("");
		confeccao.setPeopleEnvolved(32);
		Detail detailConfeccaco = new Detail();
		detailConfeccaco.setStep1("Etapa 1: Processo de confecao de pecas de oxford");
		detailConfeccaco.setStep2("Etapa 2: Processo de confecao de pecas de elastano");
		detailConfeccaco.setStep3("Etapa 3: Processo de confecao de pecas de microfibra");
		detailConfeccaco.setStep4("Etapa 4: Processo de confecao de pecas de feltro");
		detailConfeccaco.setStep5("Etapa 5: Processo de confecao de pecas de tricoline");
		detailConfeccaco.setStep6("Etapa 6: Processo de confecao de pecas de algodao cru");
		detailConfeccaco.setStep7("Etapa 7: Processo de confecao de pecas de algodao");
		detailConfeccaco.setStep8("Etapa 8: Processo de confecao de pecas de linho");
		detailConfeccaco.setStep9("Etapa 9: Pre checagem das fases e estados de maquinas");
		detailConfeccaco.setStep10("Etapa 10: Finalizacao do processo de confecao");
		confeccao.setDetail(detailConfeccaco);
		processes.put(confeccao.getName(), confeccao);

	}

}
