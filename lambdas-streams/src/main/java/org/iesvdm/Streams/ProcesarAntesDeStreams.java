package org.iesvdm.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProcesarAntesDeStreams {
	public static void main(String[] args) {

		// Se crea una lista de platos (menu) con diferentes propiedades
		List<Dish> menu = Arrays.asList( 
			 new Dish("pork", false, 800, Dish.Type.MEAT),
			 new Dish("beef", false, 700, Dish.Type.MEAT),
			 new Dish("chicken", false, 400, Dish.Type.MEAT),
			 new Dish("french fries", true, 530, Dish.Type.OTHER),
			 new Dish("rice", true, 350, Dish.Type.OTHER),
			 new Dish("season fruit", true, 120, Dish.Type.OTHER),
			 new Dish("pizza", true, 550, Dish.Type.OTHER),
			 new Dish("prawns", false, 300, Dish.Type.FISH),
			 new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		// Se crea una lista vacía para almacenar los platos bajos en calorías (<400)
		List<Dish> lowCaloricDishes = new ArrayList<>();
		
		// Se recorren todos los platos y se añaden a la lista los que tengan menos de 400 calorías
		for (Dish dish : menu) {
			if (dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}
		// Se ordena la lista de platos bajos en calorías por el número de calorías (de menor a mayor)
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			public int compare(Dish dish1, Dish dish2) {
				return Integer.compare(dish1.getCalories(), dish2.getCalories());
			}
		});
		// Se crea una lista para almacenar solo los nombres de los platos bajos en calorías
		List<String> lowCaloricDishesName = new ArrayList<>();
		// Se recorren los platos bajos en calorías y se añaden sus nombres a la lista
		for (Dish dish : lowCaloricDishes) {
			lowCaloricDishesName.add(dish.getName());
		}
	}
	
}
