package pl.org.kata.test.fest.sample.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.org.kata.test.fest.assertions.assertions.clazz.SpringContextAssertions;
import pl.org.kata.test.fest.sample.card.CardDeck;
import pl.org.kata.test.fest.sample.service.ifaces.Game;
import pl.org.kata.test.fest.sample.service.ifaces.WaterProvider;

public class CroupierTest {

	private Croupier objectUnderTest;

	@Mock
	private CardDeck newCardsMock;

	@Mock
	private Game gameMock;

	@Mock
	private WaterProvider waterProvideMock;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new Croupier(waterProvideMock);
	}
	
	@Test
	public void shouldCreateDeckOfCards(){
		//given

		//when
		objectUnderTest.putNewCardDeckIntoTheGame(gameMock);

		//then
		verify(gameMock).setNewCardDeck(any(CardDeck.class));

	}

	@Test
	public void shouldBeValidSpringComponent() {
		SpringContextAssertions.assertThat(objectUnderTest.getClass()).isSpringComponent().hasContextValidAnnotations();
	}

}
