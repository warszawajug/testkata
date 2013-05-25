package pl.org.kata.test.fest.sample.card.generator;

import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RandomCardDeckGeneratorTest {

	private RandomCardDeckGenerator objectUnderTest;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new RandomCardDeckGenerator(new AllCardsGenerator());
	}

	@Test
	public void shouldContainAllCards(){
		//given

		//when

		//then
	}

}
