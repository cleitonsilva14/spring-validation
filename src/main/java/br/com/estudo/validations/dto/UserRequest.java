package br.com.estudo.validations.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	@NotNull(message = "Nome de usuário não pode ser null!")
	private String name;
	
	@Email(message = "Email inválido")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^\\d{8}$", message = "Telefone inválido!")
	private String mobile;
	
	
	private String gender;
	
	@Min(18)
	@Max(60)
	private int age;
	
	@NotBlank
	private String nationality;
	
}
