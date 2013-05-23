package br.com.caelum.argentum.reader;

import java.util.ArrayList;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.Assert;

import br.com.caelum.argentum.*;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimplesDeNegocios() {
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5,100, hoje);
		Negocio negocio2 = new Negocio(45.0,100, hoje);
		Negocio negocio3 = new Negocio(39.8,100, hoje);
		Negocio negocio4 = new Negocio(42.3,100, hoje);

		ArrayList<Negocio> negocios = new ArrayList<Negocio>();
		negocios.add(negocio1);
		negocios.add(negocio2);
		negocios.add(negocio3);
		negocios.add(negocio4);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}

	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void semNegociosGeraCandleComZeros(){
		Calendar hoje = Calendar.getInstance();
		
		ArrayList<Negocio> negocios = new ArrayList<Negocio>();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void apenasUmNegocioGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		
		ArrayList<Negocio> negocios = new ArrayList<Negocio>();
		negocios.add(negocio1);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void testaOrdemCrescenteDeNegocios(){
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(10, 100, hoje);
		Negocio negocio2 = new Negocio(20, 100, hoje);
		Negocio negocio3 = new Negocio(20.5, 100, hoje);
		
		ArrayList<Negocio> negocios1 = new ArrayList<Negocio>();
		negocios1.add(negocio1);
		negocios1.add(negocio2);
		negocios1.add(negocio3);
		
		ArrayList<Negocio> negocios2 = new ArrayList<Negocio>();
		negocios2.add(negocio2);
		negocios2.add(negocio3);
		negocios2.add(negocio1);
		
		CandlestickFactory.negociosEmOrdemCrescenteDeValor(negocios2);
		
		Assert.assertEquals(negocios1, negocios2);
	}
	
	@Test
	public void testaOrdemDecrescenteDeNegocios(){
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(20.5, 100, hoje);
		Negocio negocio2 = new Negocio(20, 100, hoje);
		Negocio negocio3 = new Negocio(10, 100, hoje);
		
		ArrayList<Negocio> negocios1 = new ArrayList<Negocio>();
		negocios1.add(negocio1);
		negocios1.add(negocio2);
		negocios1.add(negocio3);
		
		ArrayList<Negocio> negocios2 = new ArrayList<Negocio>();
		negocios2.add(negocio2);
		negocios2.add(negocio3);
		negocios2.add(negocio1);
		
		CandlestickFactory.negociosEmOrdemDecrescenteDeValor(negocios2);
		
		Assert.assertEquals(negocios1, negocios2);
	}
}
