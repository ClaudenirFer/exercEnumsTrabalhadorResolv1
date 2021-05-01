package entities;
import entities.enums.NivelTrabalhador;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;


public class Trabalhador {
	private String nome;
	private NivelTrabalhador level;
	private Double salarioBase;
	
	/* Associações:  */
	
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();
	
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelTrabalhador level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;	
		this.departamento = departamento;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getLevel() {
		return level;
	}

	public void setLevel(NivelTrabalhador level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<HoraContrato> getContratos() {
		return contratos;
	}
	
	
	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}

	
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
			for (HoraContrato c : contratos) {			
			cal.setTime(c.getData());			
			int c_Ano = cal.get(Calendar.YEAR);
			int c_Mes = 1 + cal.get(Calendar.MONTH);			
			if (ano == c_Ano && mes == c_Mes) {
				soma += c.valorTotal();
			}
		}
		
		return soma;
	}
	
}
