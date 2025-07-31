package framework.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOps {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);

		// 1. Collect
		list.stream().skip(1).collect(Collectors.toList());
		list.stream().skip(1).toList();

		// 2. forEach
		list.stream().forEach(x -> System.out.println(x));

		// 3. reduce : combines elements to produce a single result
		Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
		System.out.println(reduce.get());
		
		// 4. Count
		
		// 5. anyMatch, allMatch, noneMatch
		boolean b = list.stream().anyMatch(x->x%2==0);
		System.out.println(b);
		boolean b1 = list.stream().allMatch(x->x>0);
		System.out.println(b1);
		boolean b2 = list.stream().noneMatch(x->x<0);
		System.out.println(b2);
		
		// 6. findFirst, findAny
		Optional<Integer> first = list.stream().findFirst();
		System.out.println(first.get());
		
		Optional<Integer> any = list.stream().findAny();
		System.out.println(any.get());
		
		// Examples
		Arrays.asList("Anna", "Bob", "Charlie","", "Eve")
			.stream()
			.filter(s -> s.length() > 0)
			.forEach(s -> System.out.println(s));
		
		// Example : Squaring and sorting numbers
		List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
		numbers.stream().map(x -> x * x).sorted().forEach(x -> System.out.print(x + " "));
	
		System.out.println();
		
		//Example : Summing numbers
		System.out.println(numbers.stream().reduce(Integer::sum));
		
		// Example : Counting occurance of character
		String str = "hello world";
		System.out.println(str.chars().filter(c -> c == 'l').count());

		// Stateful & stateless operations
		// Stateless operations do not depend on the state of the stream
		// Stateful operations may depend on the state of the stream, such as sorting or distinct.
		List<Integer> statefulList = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> statelessList = statefulList.stream()
				.filter(x -> x > 2)
				.collect(Collectors.toList());
		System.out.println("Stateless List: " + statelessList);
		List<Integer> statefulSortedList = statefulList.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Stateful Sorted List: " + statefulSortedList);
		List<Integer> statefulDistinctList = statefulList.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Stateful Distinct List: " + statefulDistinctList);
		
		// Example: Using peek for debugging
		List<Integer> debugList = Arrays.asList(1, 2, 3, 4, 5);
		debugList.stream()
			.peek(x -> System.out.println("Processing: " + x))
			.filter(x -> x % 2 == 0)
			.forEach(x -> System.out.println("Even number: " + x));	
		

	}

}
