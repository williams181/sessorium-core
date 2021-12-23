package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Pais {

	private String paiNome;

	private String paiEmail;

	private String paiTelefone;

	private String paiCpf;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paiDataNascimento;

	private byte[] paiFoto;

	public String getPaiNome() {
		return paiNome;
	}

	public void setPaiNome(String paiNome) {
		this.paiNome = paiNome;
	}

	public String getPaiEmail() {
		return paiEmail;
	}

	public void setPaiEmail(String paiEmail) {
		this.paiEmail = paiEmail;
	}

	public String getPaiTelefone() {
		return paiTelefone;
	}

	public void setPaiTelefone(String paiTelefone) {
		this.paiTelefone = paiTelefone;
	}

	public String getPaiCpf() {
		return paiCpf;
	}

	public void setPaiCpf(String paiCpf) {
		this.paiCpf = paiCpf;
	}

	public LocalDate getPaiDataNascimento() {
		return paiDataNascimento;
	}

	public void setPaiDataNascimento(LocalDate paiDataNascimento) {
		this.paiDataNascimento = paiDataNascimento;
	}

	public byte[] getPaiFoto() {
		return paiFoto;
	}

	public void setPaiFoto(byte[] paiFoto) {
		this.paiFoto = paiFoto;
	}

}
