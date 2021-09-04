package br.com.fdrtec.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Peca {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
//	@Column(name = "nome_traduzido")
	private String nomeTraduzido;	
	
//	@Column(name = "nome_original")
	private String nomeOriginal;
	
	private String codigo;
	
//	@ManyToMany(mappedBy = "pecas", fetch = FetchType.EAGER)
	
//	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SUBSELECT)
//	@JoinTable(
//		name = "CategoriaSegmentoMercado", 
//		schema = "apoio",
//		joinColumns = @JoinColumn(name = "idCategoria"), 
//		inverseJoinColumns = @JoinColumn(name = "idSegmentoMercado"))
//	private List<SegmentoMercado> segmentosMercado;
	
//	@ManyToMany(mappedBy = "pecas",cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//	private List<Dica> dicas = new ArrayList<>();
}
