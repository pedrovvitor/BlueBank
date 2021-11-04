package com.bluebank.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cliente")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private String cpf;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private String tipoCliente;
	private String email;
	private String telefone;
	private Double rendaMensal;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<Conta> contas;

	public Set<Conta> getContas() {
		if (contas == null) {
			return new HashSet<>();
		}
		return contas;
	}
}
