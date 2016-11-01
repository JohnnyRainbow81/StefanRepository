package collectionsTest;

import java.time.Instant;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


public class MapTest
{


	public static class birthdayGenerator
	{
		private static Calendar calendar = Calendar.getInstance();
		private birthdayGenerator(){}

		public static Date getBirthday(int day, int month, int year)
		{
			calendar.set(year, month, day);
			Date date = calendar.getTime();
			return date;
		}

	}
	public static class Person
	{
		private int age;
		private String name;
		private Date birthday;
		private int id;

		public Person(int age, String name, Date birthday)
		{
			this.age = age;
			this.name = name;
			this.birthday = birthday;

		}

		public final int getAge()
		{
			return age;
		}



		public final String getName()
		{
			return name;
		}



		public final Date getBirthday()
		{
			return birthday;
		}

		public final int getId()
		{
			return id;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result
					+ ((birthday == null) ? 0 : birthday.hashCode());
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age != other.age)
				return false;
			if (birthday == null)
			{
				if (other.birthday != null)
					return false;
			} else if (!birthday.equals(other.birthday))
				return false;
			if (id != other.id)
				return false;
			if (name == null)
			{
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}


	}

	public static class MyComparator implements Comparator <String>
	{

		@Override
		public int compare(String p1, String p2)
		{
			int ret = p1.compareTo(p2);

			return ret;

			//return 0;
		}

	}
	public static void main(String[] args)
	{
		MyComparator myComp = new MyComparator();
		TreeMap<String, Person> map = new TreeMap <String,Person>(myComp);

		Person stefan = new Person(35, "Stefan", birthdayGenerator.getBirthday(19, 02, 1981));
		Person martin = new Person(34, "Martin", birthdayGenerator.getBirthday(29, 07, 1982));
		Person nelkit = new Person(35, "Nelkit", birthdayGenerator.getBirthday(01, 02, 1981));
		Person seil = new Person(35, "Se-il", birthdayGenerator.getBirthday(27, 04, 1981));

		map.put(stefan.getName(), stefan);
		map.put(martin.getName(), martin);
		map.put(nelkit.getName(), nelkit);
		map.put(seil.getName(), seil);

		System.out.println(map.toString());
		Person pers = (Person) map.get(nelkit.getName());
		System.out.println(pers.getName());
		System.out.println(pers.getName());


	}

}
