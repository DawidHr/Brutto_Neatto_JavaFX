package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainControllerTest {

	String[] correctlist = { "1", "12", "11 ", "155" };
	String[] wronglist = { "x", "", "23xc ", "test" };

	@Test
	void isNumberOKTestOK() {
		MainController main = new MainController();
		for (String test : correctlist) {
			boolean isOk = main.isNumberOK(test);
			assertEquals(true, isOk);
		}
	}

	@Test
	void isNumberOKTestWrong() {
		MainController main = new MainController();
		for (String test : wronglist) {
			boolean isOk = main.isNumberOK(test);
			assertEquals(false, isOk);
		}
	}

}
