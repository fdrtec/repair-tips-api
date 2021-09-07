package br.com.fdrtec.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@EqualsAndHashCode
@Entity
@Table(name = "peca")
public class Peca implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(name = "nome_traduzido")
	private String nomeTraduzido;

//	@Column(name = "nome_original")
	private String nomeOriginal;

	private String codigo;

	@ManyToMany(mappedBy = "pecas", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("pecas")
	private List<Dica> dicas = new ArrayList<>();


//	@ManyToMany(mappedBy = "pecas", fetch = FetchType.EAGER)
//    @JsonbTransient
//	private Set<Dica> dicas = new HashSet<>();

//	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SUBSELECT)
//	@JoinTable(
//		name = "CategoriaSegmentoMercado", 
//		schema = "apoio",
//		joinColumns = @JoinColumn(name = "idCategoria"), 
//		inverseJoinColumns = @JoinColumn(name = "idSegmentoMercado"))
//	private List<SegmentoMercado> segmentosMercado;

//	@ManyToMany(mappedBy = "pecas", fetch = FetchType.EAGER)
//	private Set<Dica> dicas = new HashSet<>();
}
