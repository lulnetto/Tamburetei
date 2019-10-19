package problems;


/**
 * Dado dois arrays ordenados em ordem crescente, encontrar a k-esima estatistica de ordem 
 * da uniao ordenada deles. 
 * 
 * Restricoes:
 * - os arrays nao possuem elementos em comum e nem repetidos
 * - k eh um numero compreendido entre 1 e array1.length + array2.length
 * - caso o k-esima estatistica de ordem nao exista, o metodo deve retornar null
 * - voce nao pode usar memoria extra
 * - seu algoritmo deve ter complexidade O(array1.length + array2.length). 
 * - voce nao pode usar nenhum metodo pronto de manipulacao de arrays, exceto length.
 * 
 * @author adalbertocajueiro
 *
 */
public class OrderStatisticsSortedUnion<T extends Comparable<T>> {

	public T statisticsOrder(T[] array1, T[] array2, int k) {
		T order = null;
		if ((array1.length + array2.length) > k)
		{
			int i = 0;
			int j = 0;

			while (i < array1.length && j < array2.length && (i + j) < k)
			{
				if (array1[i].compareTo(array2[j]) < 0)
					{
						order = array1[i];
						i++;
					} else if (array1[i].compareTo(array2[j]) > 0)
					{
						order = array2[j];
						j++;
					}
			}

			while (i < array1.length && (i + j) < k)
			{
				if (array1[i].compareTo(array2[j-1]) > 0)
				{
					order = array1[i];
				}
				i++;
			}

			while (j < array2.length && (i + j) < k)
			{
				if (array2[j].compareTo(array1[i-1]) > 0)
				{
					order = array2[j];
				}
				j++;
			}
		}
		return order;
	}
}
