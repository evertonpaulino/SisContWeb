package br.com.paulino.siscontweb.model.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plano_conta")
public class PlanoDeConta implements Comparable<PlanoDeConta>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plc_codg_reduzido;
	private String plc_conta_contabil;
	private String plc_descricao;
	private String plc_tipo_conta;
	private String plc_conta_pai;

	public Integer getPlc_codg_reduzido() {
		return plc_codg_reduzido;
	}

	public void setPlc_codg_reduzido(Integer plc_codg_reduzido) {
		this.plc_codg_reduzido = plc_codg_reduzido;
	}

	public String getPlc_conta_contabil() {
		return plc_conta_contabil;
	}

	public void setPlc_conta_contabil(String plc_conta_contabil) {
		this.plc_conta_contabil = plc_conta_contabil;
	}

	public String getPlc_descricao() {
		return plc_descricao;
	}

	public void setPlc_descricao(String plc_descricao) {
		this.plc_descricao = plc_descricao;
	}

	public String getPlc_tipo_conta() {
		return plc_tipo_conta;
	}

	public void setPlc_tipo_conta(String plc_tipo_conta) {
		this.plc_tipo_conta = plc_tipo_conta;
	}

	public String getPlc_conta_pai() {
		return plc_conta_pai;
	}

	public void setPlc_conta_pai(String plc_conta_pai) {
		this.plc_conta_pai = plc_conta_pai;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PlanoDeConta){
			PlanoDeConta conta = (PlanoDeConta) obj;
			return conta.getPlc_codg_reduzido() == getPlc_codg_reduzido();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getPlc_codg_reduzido();
	}

	@Override
	public int compareTo(PlanoDeConta outraConta) {
		if(this.plc_codg_reduzido < outraConta.plc_codg_reduzido)
			return -1;
		
		if(this.plc_codg_reduzido > outraConta.plc_codg_reduzido)
			return 1;
		
		return 0;
	}
	
}
