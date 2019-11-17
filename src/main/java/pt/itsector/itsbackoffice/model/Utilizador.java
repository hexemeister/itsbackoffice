package pt.itsector.itsbackoffice.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Utilizador implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Integer id;
	
	private String username;
	
	@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String nome;
	
	@CreationTimestamp
	@Column(updatable = false)
	private OffsetDateTime createTimestamp;
	
	@UpdateTimestamp
	private OffsetDateTime updateTimestamp;
}