package model.GrupoPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.PartidaPackage.Partida;
import model.PartidaPackage.PartidaDaoImpl;
import model.SelecaoPackage.Selecao;
import model.SelecaoPackage.SelecaoDaoImpl;

public class Grupo {
	Map< String,ArrayList <Selecao> > grupos;
	
	public Map< String,ArrayList <Selecao> > getGrupos() {
		return grupos;
	}
	
	public Grupo()
	{
		this.grupos = new HashMap<String, ArrayList <Selecao>>();
	
		grupos.put("A", new ArrayList<Selecao>());
		grupos.put("B", new ArrayList<Selecao>());
		grupos.put("C", new ArrayList<Selecao>());
		grupos.put("D", new ArrayList<Selecao>());
		grupos.put("E", new ArrayList<Selecao>());
		grupos.put("F", new ArrayList<Selecao>()); 
		grupos.put("G", new ArrayList<Selecao>());
		grupos.put("H", new ArrayList<Selecao>());
	}

	public void cadastrarGrupos() {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl();
		
		for(String grupo: grupos.keySet())
		{
			System.out.println("Cadastro do grupo A: \n");
			System.out.println();
			for(int i=0; i<4; i++)
			{
				System.out.printf("Cadastro da Selecao %d do grupo %s:\n", (i+1), grupo);
				selecao.cadastrarSelecao(grupos.get(grupo));
				
			}
		}
		
		
		
		
		
		
	}
		
	}

