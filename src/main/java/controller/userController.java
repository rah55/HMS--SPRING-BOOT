//HERE WE WRITE ALL THE REST APIs
package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.userDTO;
import exception.globalException;
import model.user;
import serviceImpl.userServiceImpl;
import util.JwtUtil;
import model.authRequest;

@RestController // THIS IS FOR CREATING APIs
@RequestMapping("/user")
public class userController {

	@Autowired // DEPENDENCY INJECTION
	private userServiceImpl service;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	JwtUtil jwt;

	@PostMapping("/authentication")
	public String generateToken(@RequestBody authRequest ar) {

		authManager.authenticate(new UsernamePasswordAuthenticationToken(ar.getUserName(), ar.getUserPassword()));
		return jwt.generateToken(ar.getUserName());

	}

	@GetMapping("/get") // THIS IS FOR GETTING THE USER DETAILS FROM DATABASE
	public ResponseEntity<List<user>> getUsers() {
		List<user> userList = service.getUser();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@PostMapping("/add") // THIS IS FOR ADDING THE USER IN THE DATABASE
	public ResponseEntity<user> addUsers(@RequestBody @Valid userDTO u1) {
		return new ResponseEntity<>(service.addUser(u1), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update") // THIS IS FOR UPDATING THE DETAILS IN THE DATABASE
	public ResponseEntity<user> updateUser(@RequestBody @Valid userDTO u1) {
		return new ResponseEntity<>(service.updateUser(u1), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{userid}") // THIS IS FOR DELETE THE USER FROM THE DATABASE
	public ResponseEntity<String> deleteUser(@PathVariable int userid) throws globalException {
		String status = service.deleteUser(userid);
		if (status != null) {
			return new ResponseEntity<>(status, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/phone/{id}/{phone}") // HERE WE UPDATE PHONE NUMBER USING USER ID
	public ResponseEntity<String> updatePhone(@PathVariable int id, @PathVariable String phone) throws globalException {
		return new ResponseEntity<>(service.updatePhone(id, phone), HttpStatus.OK);
	}

	@PutMapping("/allotroom/{userid}/{roomid}") // HERE WE ALLOT THE ROOM TO THE USER
	public ResponseEntity<String> allotRoom(@PathVariable int userid, @PathVariable int roomid) throws globalException {
		return new ResponseEntity<>(service.allotRoom(userid, roomid), HttpStatus.OK);
	}
}
