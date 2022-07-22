package calculodetaxas;

public class PessoaJuridica extends Pessoa {

	private Integer numeroDeFuncionarios;

	public PessoaJuridica() {

	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	
	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double imposto() {
		Double taxa;
		if (numeroDeFuncionarios > 10) {
			taxa = 0.14;
		}
		else {
			taxa = 0.16;
		}
		
		return (getRendaAnual() * taxa); 
	}
	
	
	public String toString() {
		return getNome() + ": $ " + String.format("%.2f", imposto());
	}

}
