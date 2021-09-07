package br.com.fdrtec.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "dica")
public class Dica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String descricao;

	private String solucao;

//	private LocalDate registro = LocalDate.now();

//	@ManyToMany(cascade = CascadeType.MERGE)

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "dica_peca", joinColumns = @JoinColumn(name = "dica_id"), inverseJoinColumns = @JoinColumn(name = "peca_id"))
    @JsonIgnoreProperties("dicas")	
	private List<Peca> pecas = new ArrayList<>();
//	private Set<Peca> pecas = new HashSet<>();

}
