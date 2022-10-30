package model.PartidaPackage;

import java.util.ArrayList;
import java.util.List;

public class Partida { 
	private String codigo;
	private String data;
	private String horario;
	private String local;
	private String selecao1;
	private String selecao2;
	private List<List<String>> golsSelecao1;
	private List<List<String>> golsSelecao2;
	private List<List<String>> cartoesVermelhosSelecao1;
	private List<List<String>> cartoesVermelhosSelecao2;
	private List<List<String>> cartoesAmarelosSelecao1;
	private List<List<String>> cartoesAmarelosSelecao2;
	private boolean situacao;
	
	public boolean isSituacao() {
		return situacao;
	}


	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}


	public List<List<String>> getGolsSelecao1() {
		return golsSelecao1;
	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}


	public void setGolsSelecao1(List<String> golsSelecao1) {
		this.golsSelecao1.add(golsSelecao1);
	}

	public List<List<String>> getGolsSelecao2() {
		return golsSelecao2;
	}

	public void setGolsSelecao2(List<String>  golsSelecao2) {
		this.golsSelecao2.add(golsSelecao2);
	}

	
	public List<List<String>> getCartoesVermelhosSelecao1() {
		return cartoesVermelhosSelecao1;
	}

	public void setCartoesVermelhosSelecao1(List<String> cartoesVermelhosSelecao1) {
		this.cartoesVermelhosSelecao1.add(cartoesVermelhosSelecao1);
	}

	public List<List<String>> getCartoesVermelhosSelecao2() {
		return cartoesVermelhosSelecao2;
	}

	public void setCartoesVermelhosSelecao2(List<String>  cartoesVermelhosSelecao2) {
		this.cartoesVermelhosSelecao2.add(cartoesVermelhosSelecao2);
	}

	public List<List<String>> getCartoesAmarelosSelecao1() {
		return cartoesAmarelosSelecao1;
	}

	public void setCartoesAmarelosSelecao1(List<String> cartoesAmarelosSelecao1) {
		this.cartoesAmarelosSelecao1.add(cartoesAmarelosSelecao1);
	}

	public List<List<String>> getCartoesAmarelosSelecao2() {
		return cartoesAmarelosSelecao2;
	}

	public void setCartoesAmarelosSelecao2(List<String> cartoesAmarelosSelecao2) {
		this.cartoesAmarelosSelecao2.add(cartoesAmarelosSelecao2);
	}
	
	public String getSelecao1() {
		return selecao1;
	}
	public void setSelecao1(String selecao1) {
		this.selecao1 = selecao1;
	}
	public String getSelecao2() {
		return selecao2;
	}
	public void setSelecao2(String selecao2) {
		this.selecao2 = selecao2;
	}

	
	
	public Partida(String selecao1,String selecao2) {
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		this.situacao = false;
		this.cartoesVermelhosSelecao1 = new ArrayList<List<String>>();
		this.cartoesVermelhosSelecao2 = new ArrayList<List<String>>();
		this.cartoesAmarelosSelecao1 = new ArrayList<List<String>>();
		this.cartoesAmarelosSelecao2 = new ArrayList<List<String>>();
		this.golsSelecao2 = new ArrayList<List<String>>();
		this.golsSelecao1 = new ArrayList<List<String>>();
		this.data = "00/00/00";
		
	}


	
}
