package crm.api.RequestParams;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class AddPersonal{

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class AddPersonalOne {

		@JsonProperty("is_mass")
		private boolean isMass;

		@JsonProperty("date_rojd")
		private String dateRojd;

		@JsonProperty("patronymic")
		private String patronymic;

		@JsonProperty("account_json")
		private List<Integer> accountJson;

		@JsonProperty("need_employed")
		private boolean needEmployed;

		@JsonProperty("grajdanstvo_id")
		private int grajdanstvoId;

		@JsonProperty("name_n")
		private String nameN;

		@JsonProperty("surname")
		private String surname;

		@JsonProperty("telefon")
		private String telefon;

		@JsonProperty("in_state")
		private boolean inState;

		@JsonProperty("direction_json")
		private int directionJson;

		@JsonProperty("sex_id")
		private int sexId;

		public boolean isIsMass ( ) {
			return isMass;
		}

		public String getDateRojd ( ) {
			return dateRojd;
		}

		public String getPatronymic ( ) {
			return patronymic;
		}

		public List<Integer> getAccountJson ( ) {
			return accountJson;
		}

		public boolean isNeedEmployed ( ) {
			return needEmployed;
		}

		public int getGrajdanstvoId ( ) {
			return grajdanstvoId;
		}

		public String getNameN ( ) {
			return nameN;
		}

		public String getSurname ( ) {
			return surname;
		}

		public String getTelefon ( ) {
			return telefon;
		}

		public boolean isInState ( ) {
			return inState;
		}

		public int getDirectionJson ( ) {
			return directionJson;
		}
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class AddPersonalTwo {

		private int personalId;
		private int grajdanstvoId;
		private String endPoint;
		private int parentAction;
		private int typeParentAction;
		private Object regionsId;
		private String cityName;
		private List<Integer> objectJson;
		private boolean transfer;
		private String startPoint;
		private List<Integer> directionJson;
		private String regionName;
		private Object objectTransferId;
		private Object cityId;

    }
}