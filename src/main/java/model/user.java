//HERE WE DEFINE THE VARIABLE NAME OF THE TABLE
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity        // THIS ANNOTATION IS USED FOR CREATING A TABLE FOR USER
@NoArgsConstructor
@AllArgsConstructor
public class user {

	@Id // this annotation is used to treat user id as primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // THIS ANNOTATION IS USED FOR AUTOINCREMENT THE USERID
	private int userId;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userEmail;
	private String userRole;
	private int userFee;

	@ManyToOne    // THIS ANNOTAION TELL THAT THERE IS MANY TO ONE RELATIONSHIP BETWEEN USER AND THE ROOM
	private room userRoom;
}
