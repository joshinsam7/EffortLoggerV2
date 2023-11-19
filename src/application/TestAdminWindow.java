package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdminWindow {
	AdminDatabase adminDatabase;	
	UserDatabase userDatabase;	
	File adminD;
	File userD;
	
	@BeforeEach
	void setUp() throws Exception {
		adminDatabase = new AdminDatabase();
		userDatabase = new UserDatabase();
		adminD = new File("AdminDatabase.txt");
		userD = new File("UserDatabase.txt");
	}
	
	//AdminDatabaseLoginTest
	//CorrectPassword
	@Test
	void testLoginWithJoshinsId() {
		String userName = "joshinsam";
		String password = "playstation5"; 
		assertTrue(adminDatabase.checkAdminAuthentication(userName, password, adminD), "The password is: playstation5");
	}
	
	//IncorrectPassword
	@Test
	void testLoginWithJoshinsIdAndNoPassword() {
		String userName = "joshinsam";
		String password = ""; 
		assertFalse(adminDatabase.checkAdminAuthentication(userName, password, adminD), "The password is: playstation5");
	}
	
	//UserDatabaseLoginTest
	//CorrectPassword
	@Test
	void testLoginWithDansId() {
		String userName = "DanTien";
		String password = "TrialConfirm"; 
		assertTrue(userDatabase.checkUserAuthentication(userName, password, userD), "The password is: TrialConfirm");
	}

	//IncorrectPassword
	@Test
	void testLoginWithDansIdAndNoPassword() {
		String userName = "DanTien";
		String password = ""; 
		assertFalse(userDatabase.checkUserAuthentication(userName, password, userD), "The password is: TrialConfirm");
	}
		
	//Username already exists in admin database
	@Test
	void testCheckUsernameExist() {
		String username = "joshinsam";		
		assertTrue(adminDatabase.checkUsernameExist(username, userD));
	}
	
	
	//Username does not exist in admin database
	@Test
	void testCheckUsernameNotExist() {
		String username = "tdang17";		
		assertFalse(adminDatabase.checkUsernameExist(username, userD));
	}
	
	
	
	

}
