package br.com.caelum.argentum.reader;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.caelum.argentum.Candlestick;
import br.com.caelum.argentum.Negocio;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			ArrayList<Negocio> negocios) {

		double maximo = negocios.get(0).getPreco();
		double minimo = negocios.get(0).getPreco();
		double volume = 0.0;

		for (Negocio negocio : negocios) {
			volume += negocio.getVolume();

			if (negocio.getPreco() > maximo) {
				maximo = negocio.getPreco();
			} else if (negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			}
		}

		double abertura = negocios.get(0).getPreco();
		double fechamento = negocios.get(negocios.size() - 1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);

	}

	static int negociosEmOrdemCrescenteDeValor(ArrayList<Negocio> negocios)

	{

		int count = 0;

		for (int outer = 0; outer < negocios.size() - 1; outer++)

		{

			for (int inner = 0; inner < negocios.size() - outer - 1; inner++)

			{

				if (negocios.get(inner).getPreco() > negocios.get(inner + 1)
						.getPreco())

				{

					swapEm(negocios, inner);

					count = count + 1;

				}

			}

		}

		return count;

	}

	static void negociosEmOrdemDecrescenteDeValor(ArrayList<Negocio> negocios)

	{

		for (int outer = 0; outer < negocios.size() - 1; outer++) {

			for (int inner = 0; inner < negocios.size() - outer - 1; inner++)

			{

				if (negocios.get(inner).getPreco() < negocios.get(inner + 1)
						.getPreco())

				{

					swapEm(negocios, inner);
				}

			}

		}
	}

	static void swapEm(ArrayList<Negocio> negocios, int inner)

	{

		Negocio temp = negocios.get(inner);

		negocios.set(inner, negocios.get(inner + 1));

		negocios.set(inner + 1, temp);

	}

}
