//DTO IS USED FOR DATA VALIDATION

package dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.room;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDTO {
	
	@NotNull(message="user id cannot be null")  
	private int userId;
	
	@NotNull(message="username cannot be null")
	private String userName;
	
	@Pattern(regexp="[a-zA-Z0-9@#]{6,15}")  //HERE WE USE REGULAR EXPRESSION FOR PASSWORD
	private String userPassword;
	
	@Pattern(regexp="[0-9]{10}")   //HERE WE USE REGULAR EXPRESSION FOR PHONE NUMBER 
	private String userPhone;
	
	@Email                // THIS NOTATION IS USED FOR EMAIL VALIDATION
	private String userEmail;
	
	@NotNull(message="user id cannot be null")
	private String userRole;
	
	@Min(1000)           // THIS MEANS THAT THE VALUE CANNOT BE LESS THAN 1000
	@Max(6000)			// THIS MEANS THE THE VALUE CANNOT BE MORE THAN 6000
	private int userFee;

	private room userRoom;
}
