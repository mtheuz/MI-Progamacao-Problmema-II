package model.PartidaPackage;



public class Partida { 
	private String codigo;
	private String data;
	private String horario;
	private String local;
	private String selecao1;
	private String selecao2;
	private int golsSelecao1;
	private int golsSelecao2;
	private int cartoesVermelhosSelecao1;
	private int cartoesVermelhosSelecao2;
	private int cartoesAmarelosSelecao1;
	private int cartoesAmarelosSelecao2;
	private boolean situacao;
	
	public boolean isSituacao() {
		return situacao;
	}


	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}


	public int getGolsSelecao1() {
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


	public void setGolsSelecao1(int golsSelecao1) {
		this.golsSelecao1 += golsSelecao1;
	}

	public int getGolsSelecao2() {
		return golsSelecao2;
	}

	public void setGolsSelecao2(int golsSelecao2) {
		this.golsSelecao2 += golsSelecao2;
	}

	
	public int getCartoesVermelhosSelecao1() {
		return cartoesVermelhosSelecao1;
	}

	public void setCartoesVermelhosSelecao1(int cartoesVermelhosSelecao1) {
		this.cartoesVermelhosSelecao1 = cartoesVermelhosSelecao1;
	}

	public int getCartoesVermelhosSelecao2() {
		return cartoesVermelhosSelecao2;
	}

	public void setCartoesVermelhosSelecao2(int cartoesVermelhosSelecao2) {
		this.cartoesVermelhosSelecao2 = cartoesVermelhosSelecao2;
	}

	public int getCartoesAmarelosSelecao1() {
		return cartoesAmarelosSelecao1;
	}

	public void setCartoesAmarelosSelecao1(int cartoesAmarelosSelecao1) {
		this.cartoesAmarelosSelecao1 = cartoesAmarelosSelecao1;
	}

	public int getCartoesAmarelosSelecao2() {
		return cartoesAmarelosSelecao2;
	}

	public void setCartoesAmarelosSelecao2(int cartoesAmarelosSelecao2) {
		this.cartoesAmarelosSelecao2 = cartoesAmarelosSelecao2;
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
	}


	
}
