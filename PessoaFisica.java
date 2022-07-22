package calculodetaxas;

public class PessoaFisica extends Pessoa {
	
	private Double gastosComSaude;
	
	PessoaFisica() {
		
	}
	

	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}


	public Double getGastosComSaude() {
		return gastosComSaude;
	}


	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}


	@Override
	public double imposto() {
		double taxa;
		if (getRendaAnual() < 20000.00) {
			taxa = getRendaAnual()*0.15;
		}
		else {
			taxa = getRendaAnual()*0.25;
		}
		if(getGastosComSaude() > 0.0) {
			taxa = ((getRendaAnual()*0.25)-(getGastosComSaude() * 0.5));
		}
		
		return taxa;
	}


	@Override
	public String toString() {
		return getNome() + ": $ " + String.format("%.2f", imposto());
	}
	
	
	
	
}
