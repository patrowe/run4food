package run4food;

import java.util.HashMap;
import java.util.Enumeration;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Shoppingcart {
	private int zaehler = 1;
	private HashMap<Dishes, Integer> order = new HashMap<Dishes, Integer>();

	public void setOrder(Dishes gericht, Integer a) {
		order.put(gericht, a);
	}

	public HashMap<Dishes, Integer> getOrder() {
		return this.order;
	}

	public double calculateBill() {
		if (this.order.size() == 0)
			return 0.0;
		else {
			double wert = 0;

			Set<Dishes> keyset = this.order.keySet();
			Collection<Integer> keyset2 = this.order.values();
			Iterator<Dishes> it = keyset.iterator();
			Iterator<Integer> it2 = keyset2.iterator();

			while (it.hasNext()) {
				// System.out.println(it.next().getName());
				wert += it.next().getPrice() * it2.next();
				// System.out.println(it2.next());

			}
			return wert;

		}

	}

	public int getCalCount() {
		int calCount = 0;

		Set<Dishes> keyset = this.order.keySet();
		Collection<Integer> keyset2 = this.order.values();
		Iterator<Dishes> it = keyset.iterator();
		Iterator<Integer> it2 = keyset2.iterator();

		while (it.hasNext()) {
			calCount += it.next().getCal() * it2.next();

		}
		return calCount;
	}

	public void changeCart(Dishes dish, int anzahl) {
		Set<Dishes> keyset = this.order.keySet();
		Collection<Integer> keyset2 = this.order.values();
		Iterator<Dishes> it = keyset.iterator();
		Iterator<Integer> it2 = keyset2.iterator();

		while (it.hasNext()) {
			if(dish.getName().toString().equals(it.next().getName().toString()))
				if (anzahl == 0) {
					it.remove();
					// it2.remove();
				} else {
					it.remove();
					// it2.remove();
					this.order.put(dish, anzahl);

					// it2.next().intValue()=anzahl;
				}
			} 
		}
	}


