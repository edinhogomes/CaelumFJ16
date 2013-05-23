package br.com.caelum.argentum.reader;

import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.Candlestick;

public class CandlestickTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo(){
		Calendar c = Calendar.getInstance();
		new Candlestick(10, 20, 20, 10, 10000, c);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComDataNula() {
		new Candlestick(10, 5, 15, 3, 20, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComAberturaNegativa(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		new Candlestick(-10, 5, 15, 3, 20, c);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComFechamentoNegativo(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		new Candlestick(10, -5, 15, 3, 20, c);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComMinimoNegativo(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		new Candlestick(10, 5, -15, 3, 20, c);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComMaximoNegativo(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		new Candlestick(10, 5, 15, -3, 20, c);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComVolumeNegativo(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		new Candlestick(10, 5, 15, 3, -20, c);
	}
}
