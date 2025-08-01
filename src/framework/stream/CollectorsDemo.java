package framework.stream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

	public static void main(String[] args) {
		// Collectors is a utility class in the java.util.stream package
		// Provides various methods to collect the elements of a stream into different
		// data structures
		// Commonly used methods include toList(), toSet(), toMap(), joining(),
		// groupingBy(), partitioningBy(), counting(), summingInt(), averagingInt(),
		// etc.

		// Example usage of Collectors

		// 1. Collecting to a List
		List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
		List<String> list = fruits.stream().collect(Collectors.toList());
		System.out.println("List: " + list);

		// 2. Collecting to a Set
		Set<Integer> set = Arrays.asList(1, 2, 2, 3, 4, 4, 5).stream().collect(Collectors.toSet());
		System.out.println("Set: " + set);

		// 3. Collecting to a Specified Collection
		ArrayDeque<String> specifiedList = fruits.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
		System.out.println("Specified Collection (ArrayDeque): " + specifiedList);

		// 4. Joining Strings
		// Concatenates the elements of a stream into a single String
		String joined = fruits.stream().map(String::toUpperCase).collect(Collectors.joining(", ", "Fruits: ", "."));
		System.out.println("Joined: " + joined);

		// 5. Summarizing Data
		// Generates statistics such as count, sum, min, average, and max
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		IntSummaryStatistics stats = nums.stream().collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println("Count: " + stats.getCount());
		System.out.println("Sum: " + stats.getSum());
		System.out.println("Min: " + stats.getMin());
		System.out.println("Max: " + stats.getMax());
		System.out.println("Average: " + stats.getAverage());

		// 6. Grouping Elements
		Map<Integer, List<String>> grouped = fruits.stream().collect(Collectors.groupingBy(x -> x.length()));
		System.out.println("Grouping by length: " + grouped);
		Map<Integer, String> groupedAndJoined = fruits.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
		System.out.println("Grouping by length and joining: " + groupedAndJoined);
		TreeMap<Integer, Long> treeMap = fruits.stream()
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
		System.out.println("TreeMap Grouping by length: " + treeMap);

		// 7. Partitioning Elements
		Map<Boolean, List<String>> partitioned = fruits.stream()
				.collect(Collectors.partitioningBy(x -> x.length() > 5));
		System.out.println("Partitioning by length > 5: " + partitioned);

		// 10. Mapping and collecting
		List<String> collect = fruits.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
		System.out.println("Mapping to uppercase: " + collect);

		examples();

	}

	private static void examples() {
		// Example 1: Collecting names by length
		List<String> names = Arrays.asList("Shivani", "Sweety", "Kirti", "Rohee", "Roa", "Romee");
		System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));

		// Example 2 : Counting word occurances
		String sentence = "hello world hello java world";
		String[] split = sentence.split(" ");
		Map<String, Long> collect = Stream.of(split).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(collect);
		
		// Example 3 : Partitioning even and odd numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean,List<Integer>> collect2 = numbers.stream().collect(Collectors.partitioningBy(x->x%2==0));
		System.out.println("Partitioning even and odd numbers: " + collect2);
		
		// Example 4 : Summing values in map
		Map<String, Integer> map = new HashMap<>();
		map.put("Apple", 10);
		map.put("Banana", 20);
		map.put("Cherry", 30);
		
		Integer sum1 = map.values().stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum of values in map using values: " + sum1);
		
		// Example 5 : Creating a map from Stream elements
		Map<String, Integer> mapFromStream = Stream.of("apple", "banana", "cherry")
				.collect(Collectors.toMap(String::toUpperCase, String::length));
		
		// Example 6 : Find Occurance of word using toMap
		Map<String, Long> wordCountMap = Stream.of("apple", "banana", "apple", "orange", "banana", "kiwi")
				.collect(Collectors.toMap(word -> word, word -> 1L, Long::sum));
		System.out.println("Word count map: " + wordCountMap);
		
	}
}
