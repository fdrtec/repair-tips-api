package br.com.fdrtec.api.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="veiculo")
public class Veiculo {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "v_modelo", length = 60, nullable = false)
	private String modelo;
	
	@Column(name = "v_fabricante", length = 60, nullable = false)
	private String fabricante;
	
	@Column(name = "v_ano_fabricacao", length = 4, nullable = false)
	private Integer anoFabricacao;
	
	@Column(name = "v_ano_modelo", length = 4, nullable = false)
	private Integer anoModelo;
	
	@Column(name = "v_valor", precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;

}
 