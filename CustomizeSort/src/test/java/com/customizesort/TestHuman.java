package com.customizesort;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestHuman {

	@Test
	public void testSortedByName() {

		List<Human> actual = unsortedList();
		List<Human> expected = sortedByNameList();

		Collections.sort(actual);

		/*
		 * Human[] array1 = actual.toArray(new Human[actual.size()]); Human[] array2 =
		 * expected.toArray(new Human[expected.size()]);
		 * assertArrayEquals(array2,array1);
		 */
		/*
		 * for (int i = 0; i < actual.size(); i++) { //
		 * System.out.println(actual.get(i)+" "+ expected.get(i));
		 * System.out.println(actual.get(i).getName() + " " + actual.get(i).getAge() +
		 * " " + actual.get(i).getIncome() + " " + actual.get(i).getDob());
		 * System.out.println(expected.get(i).getName() + " " + expected.get(i).getAge()
		 * + " " + expected.get(i).getIncome() + " " + expected.get(i).getDob()); //
		 * assertEquals(expected.get(i),actual.get(i));
		 * 
		 * }
		 */

		assertEquals(expected, actual);

	}

	@Test
	public void testSortedByAge() {
		List<Human> actual = unsortedList();
		List<Human> expected = sortedByAgeList();

		Collections.sort(actual, new Comparator<Human>() {

			public int compare(Human o1, Human o2) {
				return o1.getAge() - o2.getAge();
			}

		});

		assertEquals(expected, actual);

	}

	@Test
	public void testSortedByIncome() {

		List<Human> actual = unsortedList();
		List<Human> expected = sortedByIncomeList();

		Collections.sort(actual, new Comparator<Human>() {

			public int compare(Human o1, Human o2) {

				if ((Math.abs(o1.getIncome() - o2.getIncome())) < 0.000001) {
					return 0;
				}

				else if (o1.getIncome() - o2.getIncome() > 0)
					return 1;
				else
					return -1;
			}

		});

		assertEquals(expected, actual);
	}

	@Test
	public void testSortedByDob() {

		List<Human> actual = unsortedList();
		List<Human> expected = sortedByDobList();

		Collections.sort(actual, new Comparator<Human>() {

			public int compare(Human o1, Human o2) {
				if (o1.getDob().isEqual(o2.getDob())) {
					return 0;
				} else if (o1.getDob().isAfter(o2.getDob())) {
					return -1;
				} else
					return 1;

			}

		});

		assertEquals(expected, actual);
	}

	private List<Human> unsortedList() {

		List<Human> list = new ArrayList<Human>();
		list.add(new Human("Arju", 25, 8000F, LocalDate.of(1994, Month.APRIL, 5)));
		list.add(new Human("Kowshik", 22, 7500F, LocalDate.of(1997, Month.NOVEMBER, 22)));
		list.add(new Human("Mishkat", 24, 5600F, LocalDate.of(1995, Month.JULY, 12)));
		list.add(new Human("Jahid", 28, 9500F, LocalDate.of(1991, Month.OCTOBER, 18)));
		return list;
	}

	private List<Human> sortedByNameList() {

		List<Human> list = new ArrayList<Human>();
		list.add(new Human("Arju", 25, 8000, LocalDate.of(1994, Month.APRIL, 5)));
		list.add(new Human("Jahid", 28, 9500F, LocalDate.of(1991, Month.OCTOBER, 18)));
		list.add(new Human("Kowshik", 22, 7500, LocalDate.of(1997, Month.NOVEMBER, 22)));
		list.add(new Human("Mishkat", 24, 5600, LocalDate.of(1995, Month.JULY, 12)));
		return list;

	}

	private List<Human> sortedByAgeList() {

		List<Human> list = new ArrayList<Human>();
		list.add(new Human("Kowshik", 22, 7500, LocalDate.of(1997, Month.NOVEMBER, 22)));
		list.add(new Human("Mishkat", 24, 5600, LocalDate.of(1995, Month.JULY, 12)));
		list.add(new Human("Arju", 25, 8000, LocalDate.of(1994, Month.APRIL, 5)));
		list.add(new Human("Jahid", 28, 9500, LocalDate.of(1991, Month.OCTOBER, 18)));
		return list;

	}

	private List<Human> sortedByIncomeList() {

		List<Human> list = new ArrayList<Human>();

		list.add(new Human("Mishkat", 24, 5600, LocalDate.of(1995, Month.JULY, 12)));
		list.add(new Human("Kowshik", 22, 7500, LocalDate.of(1997, Month.NOVEMBER, 22)));
		list.add(new Human("Arju", 25, 8000, LocalDate.of(1994, Month.APRIL, 5)));
		list.add(new Human("Jahid", 28, 9500, LocalDate.of(1991, Month.OCTOBER, 18)));
		return list;

	}

	private List<Human> sortedByDobList() {

		List<Human> list = new ArrayList<Human>();
		list.add(new Human("Kowshik", 22, 7500, LocalDate.of(1997, Month.NOVEMBER, 22)));
		list.add(new Human("Mishkat", 24, 5600, LocalDate.of(1995, Month.JULY, 12)));
		list.add(new Human("Arju", 25, 8000, LocalDate.of(1994, Month.APRIL, 5)));
		list.add(new Human("Jahid", 28, 9500, LocalDate.of(1991, Month.OCTOBER, 18)));
		return list;

	}

}
