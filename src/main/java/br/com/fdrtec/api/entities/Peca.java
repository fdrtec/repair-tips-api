package br.com.fdrtec.api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "dicas")
@Entity
@Table(name = "peca")
public class Peca implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_traduzido", length = 60, nullable = false)
	private String nomeTraduzido;

	@Column(name = "nome_original", length = 60, nullable = false)
	private String nomeOriginal;

	@Column(length = 60, nullable = false)
	private String codigo;

	@ManyToMany(mappedBy = "pecas", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("pecas")	
	private Set<Dica> dicas = new HashSet<>();
} 
