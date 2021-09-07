package br.com.fdrtec.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
public class Dica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String descricao;

	private String solucao;

//	private LocalDate registro = LocalDate.now();

//	@ManyToMany(cascade = CascadeType.MERGE)

//	@ManyToMany( cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//	private Set<Peca> pecas = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
//	@JsonManagedReference
	@JoinTable(name = "dica_peca", joinColumns = @JoinColumn(name = "dica_id"), inverseJoinColumns = @JoinColumn(name = "peca_id"))
//	@JsonBackReference("dicas")
//	private Set<Peca> pecas = new HashSet<>();
	private List<Peca> pecas = new ArrayList<>();

}
