package crm.api.RequestParams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorizationBody{

	@JsonProperty("password")
	private String password;

	@JsonProperty("login")
	private String login;

}