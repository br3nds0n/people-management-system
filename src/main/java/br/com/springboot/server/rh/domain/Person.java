package br.com.springboot.server.rh.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Person {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

	@NotBlank(message = "name field cannot be empty")
	@Column(nullable = false)
  private String nome;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dataNascimento;

	@CPF
	@NotBlank(message = "cpf field cannot be empty")
	@Column(nullable = false)
  private String cpf;

	@NotBlank(message = "e-mail field cannot be empty")
	@Email(message = "e-mail provided is invalid")
  private String email;

	@NotBlank(message = "phone field cannot be empty")
	@Column(nullable = false)
  private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

  @Override
	public int hashCode() {
		return Objects.hash(id);
	}

  @Deprecated
	protected Person() {}

  public Person(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}

  @Override
	public String toString() {
		return "Pessoa [nome=" + nome + "]";
	}
}
