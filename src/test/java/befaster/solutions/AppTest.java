package befaster.solutions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AppTest {
	@Test
	public void checkout_null() {
		assertThat(App.checkout(null), equalTo(-1));
	}
	
	@Test
	public void checkout_empty() {
		assertThat(App.checkout(""), equalTo(0));
	}
	
	@Test
	public void checkout_A() {
		assertThat(App.checkout("A"), equalTo(50));
	}

	@Test
	public void checkout_B() {
		assertThat(App.checkout("B"), equalTo(30));
	}
	
	@Test
	public void checkout_C() {
		assertThat(App.checkout("C"), equalTo(20));
	}
	
	@Test
	public void checkout_D() {
		assertThat(App.checkout("D"), equalTo(15));
	}
	
	@Test
	public void checkout_E() {
		assertThat(App.checkout("E"), equalTo(-1));
	}
	
	@Test
	public void checkout_Ax3() {
		assertThat(App.checkout("AAA"), equalTo(130));
	}
	
	@Test
	public void checkout_Ax4() {
		assertThat(App.checkout("AAAA"), equalTo(180));
	}
	
	@Test
	public void checkout_Ax6() {
		assertThat(App.checkout("AAAAAA"), equalTo(260));
	}
	
	@Test
	public void checkout_Bx2() {
		assertThat(App.checkout("BB"), equalTo(45));
	}
	
	@Test
	public void checkout_Bx3() {
		assertThat(App.checkout("BBB"), equalTo(75));
	}
	
	@Test
	public void checkout_Bx4() {
		assertThat(App.checkout("BBBB"), equalTo(90));
	}
	
	@Test
	public void checkout_Cx2() {
		assertThat(App.checkout("CC"), equalTo(40));
	}
	
	@Test
	public void checkout_Cx3() {
		assertThat(App.checkout("CCC"), equalTo(60));
	}
	
	@Test
	public void checkout_Dx2() {
		assertThat(App.checkout("DD"), equalTo(30));
	}
	
	@Test
	public void checkout_Dx3() {
		assertThat(App.checkout("DDD"), equalTo(45));
	}
	
	@Test
	public void checkout_mix() {
		assertThat(App.checkout("ABABA"), equalTo(175));
	}
}
