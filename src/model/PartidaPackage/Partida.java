package model.PartidaPackage;

import java.util.ArrayList;
import java.util.Map;

import model.SelecaoPackage.Selecao;

public class Partida { 
	private String codigo;
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

	public String getGolsSelecao1() {
		return golsSelecao1;
	}

	public void setGolsSelecao1(String golsSelecao1) {
		this.golsSelecao1 = golsSelecao1;
	}

	public String getGolsSelecao2() {
		return golsSelecao2;
	}

	public void setGolsSelecao2(String golsSelecao2) {
		this.golsSelecao2 = golsSelecao2;
	}

	private String data;
	private String horario;
	private String local;
	private String selecao1;
	private String selecao2;
	private String golsSelecao1;
	private String golsSelecao2;
	
	
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
	}
}
