//DTO IS USED FOR DATA VALIDATION

package dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class roomDTO {
	//THIS NOT NULL NOTAION TELLS THAT THE VARIABLE VALUE CANNOT BE NULL
	@NotNull(message="room id cannot be null")
	private int roomId;
	
	@NotNull(message="room name cannot be null")
	private String roomName;
	
	@NotNull(message="room type cannot be null")
	private String roomType;

}
