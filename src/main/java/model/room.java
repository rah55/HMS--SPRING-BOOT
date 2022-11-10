//HERE WE DEFINE THE VARIABLE NAME OF THE TABLE
package model;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data			//THIS IS USED FOR LOMBOK
@NoArgsConstructor
@AllArgsConstructor
@Entity        // THIS ANNOTATION IS USED FOR CREATING A TABLE FOR USER
public class room {

	@Id //THIS ANNOTATION IS USED FOR CREATING A TABLE
	private int roomId;
	private String roomName;
	private String roomType;
}
