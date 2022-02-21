package com.javaPrograms;

public class javaCollectionPgm {

	public static void main(String[] args) {
		
		/*They ArrayList/LinkedList maintain the elements insertion order which means while displaying ArrayList and LinkedList 
		 * elements the result set would be having the same order in which the elements got inserted into the List
		ArrayList lst = new ArrayList();
		lst.add("A"); // -----> Adds the element to the end of the list
		lst.add("B");
		lst.add("D");
		lst.add("E");
		System.out.println(lst);
		lst.add(2, "C"); //-----> To add element at specific index
		System.out.println(lst);
		
		ArrayList lst1 = new ArrayList();
		lst1.add(10);
		lst1.add(20);
		
		lst.addAll(lst1); // -----> Add complete new list to the existing list
		System.out.println(lst);
		
		System.out.println(lst.get(1)); // -----> To get specific index value
		
		lst.remove(1); // -----> To remove item based on index
		
		lst.remove(Integer.valueOf(10)); // -----> To remove item based on value
		
		System.out.println(lst);
		
		lst.set(1, "F"); // -----> To update existing value on a specific index
		System.out.println(lst);
		
		System.out.println(lst.contains("C")); // -----> Verifies the specified element is present or not
		
		// -----> Ways of iterating the Arraylist
		for (int i = 0; i <=lst.size()-1; i++) {
			System.out.println("Using forloop :"+lst.get(i));
		}
		
		for(Object s : lst){
			System.out.println("Using foreachloop :"+s);
		}
		
		Iterator<Object> it = lst.iterator();
		while(it.hasNext()){
			System.out.println("Using iterator :"+it.next());
		}
		
		lst.clear(); // -----> Used to clear all elements
		System.out.println(lst);
		
		//OutPut :
		[A, B, D, E]
		[A, B, C, D, E]
		[A, B, C, D, E, 10, 20]
		B
		[A, C, D, E, 20]
		[A, F, D, E, 20]
		false
		Using forloop :A
		Using forloop :F
		Using forloop :D
		Using forloop :E
		Using forloop :20
		Using foreachloop :A
		Using foreachloop :F
		Using foreachloop :D
		Using foreachloop :E
		Using foreachloop :20
		Using iterator :A
		Using iterator :F
		Using iterator :D
		Using iterator :E
		Using iterator :20
		[]*/
		
		
		
		/*They ArrayList/LinkedList maintain the elements insertion order which means while displaying ArrayList and LinkedList 
		 elements the result set would be having the same order in which the elements got inserted into the List*/
		/*LinkedList lst = new LinkedList();
		lst.add("A"); // -----> Adds the element to the end of the list
		lst.add("B");
		lst.add("D");
		lst.add("E");
		System.out.println(lst);
		lst.add(2, "C"); //-----> To add element at specific index
		System.out.println(lst);
		
		ArrayList lst1 = new ArrayList();
		lst1.add(10);
		lst1.add(20);
		
		lst.addAll(lst1); // -----> Add complete new list to the existing list
		System.out.println(lst);
		
		System.out.println(lst.get(1)); // -----> To get specific index value
		
		lst.remove(1); // -----> To remove item based on index
		
		lst.remove(Integer.valueOf(10)); // -----> To remove item based on value
		
		System.out.println(lst);
		
		lst.set(1, "F"); // -----> To update existing value on a specific index
		System.out.println(lst);
		
		System.out.println(lst.contains("C")); // -----> Verifies the specified element is present or not
		
		lst.addFirst("G"); // -----> Inbuilt functions
		lst.addLast("H");
		lst.removeFirst();
		lst.removeLast();
		lst.getFirst();
		lst.getLast();
		
		// -----> Ways of iterating the Arraylist
		for (int i = 0; i <=lst.size()-1; i++) {
			System.out.println("Using forloop :"+lst.get(i));
		}
		
		for(Object s : lst){
			System.out.println("Using foreachloop :"+s);
		}
		
		Iterator<Object> it = lst.iterator();
		while(it.hasNext()){
			System.out.println("Using iterator :"+it.next());
		}
		
		lst.clear(); // -----> Used to clear all elements
		System.out.println(lst);
		
		//OutPut :
		[A, B, D, E]
		[A, B, C, D, E]
		[A, B, C, D, E, 10, 20]
		B
		[A, C, D, E, 20]
		[A, F, D, E, 20]
		false
		Using forloop :A
		Using forloop :F
		Using forloop :D
		Using forloop :E
		Using forloop :20
		Using foreachloop :A
		Using foreachloop :F
		Using foreachloop :D
		Using foreachloop :E
		Using foreachloop :20
		Using iterator :A
		Using iterator :F
		Using iterator :D
		Using iterator :E
		Using iterator :20
		[]*/

				
		
		/*//Lastin FirstOut
		Stack st = new Stack();
		st.push("A"); // -----> To add element into the stack
		st.push("B");
		st.push("C");
		st.push("D");
		st.push(10);
		st.push(20);
		
		System.out.println(st);
		System.out.println(st.peek()); // -----> To get top element from the stack
		st.pop(); // -----> To remove top element from the stack
		System.out.println(st);
		System.out.println(st.peek());
		
		//OutPut :
		[A, B, C, D, 10, 20]
		20
		[A, B, C, D, 10]
		10*/
		
		
		/*//FirstIn FirstOut
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(40); // -----> To add element into the priorityqueuee
		pq.add(12);
		pq.add(24);
		pq.add(36);
		
		System.out.println(pq);
		pq.poll(); // -----> To remove first element from the stack
		System.out.println(pq);
		System.out.println(pq.peek()); // -----> To get first element from the stack
		
		//OutPut :
		[12, 36, 24, 40]
		[24, 36, 40]
		24*/
		
		
		
		/* Here order of the element is not maintained
		HashSet st = new HashSet();
		st.add("A"); // -----> Used to add element to set
		st.add("B");
		st.add("C");
		st.add("D");
		st.add("E");
		st.add(10);
		st.add(20);
		
		System.out.println(st);
		
		System.out.println(st.size()); // -----> To get size of the set
		
		System.out.println(st.contains(20)); // -----> To check is element present
		
		System.out.println(st.isEmpty()); // -----> To check set is empty
		
		System.out.println(st.remove("A")); // -----> To remove an element from the set
		
		Iterator it = st.iterator(); // -----> Used to iterate the set
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		st.clear(); // -----> Used to clear all elements from the set
		
		System.out.println(st);
		
		//OutPut :
		[A, B, C, D, 20, E, 10]
		7
		true
		false
		true
		B
		C
		D
		20
		E
		10
		[]*/
		
		
		
		
		/*Here order of the element insertion is maintained
		LinkedHashSet st = new LinkedHashSet();
		st.add("A"); // -----> Used to add element to set
		st.add("B");
		st.add("C");
		st.add("D");
		st.add("E");
		st.add(10);
		st.add(20);
		
		System.out.println(st);
		
		System.out.println(st.size()); // -----> To get size of the set
		
		System.out.println(st.contains(20)); // -----> To check is element present
		
		System.out.println(st.isEmpty()); // -----> To check set is empty
		
		System.out.println(st.remove("A")); // -----> To remove an element from the set
		
		Iterator it = st.iterator(); // -----> Used to iterate the set
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		st.clear(); // -----> Used to clear all elements from the set
		
		System.out.println(st);
		
		//OutPut :
		[A, B, C, D, E, 10, 20]
		7
		true
		false
		true
		B
		C
		D
		E
		10
		20
		[]*/
		
		
		
		
		/*TreeSet does not preserve the insertion order of elements but elements are sorted by keys , the objects that are being inserted into the tree should be homogeneous
		TreeSet<Integer> st = new TreeSet<Integer>();
		st.add(10); // -----> Used to add element to set
		st.add(30);
		st.add(50);
		st.add(20);
		st.add(40);
		
		System.out.println(st);
		
		System.out.println(st.size()); // -----> To get size of the set
		
		System.out.println(st.contains(20)); // -----> To check is element present
		
		System.out.println(st.isEmpty()); // -----> To check set is empty
		
		System.out.println(st.remove(30)); // -----> To remove an element from the set
		
		Iterator it = st.iterator(); // -----> Used to iterate the set
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		st.clear(); // -----> Used to clear all elements from the set
		
		System.out.println(st);
		
		//OutPut :
		[10, 20, 30, 40, 50]
		5
		true
		false
		true
		10
		20
		40
		50
		[]*/
				
				
		
		/*Non sorted one
		HashMap mp = new HashMap();
		mp.put("One", 1);
		mp.put("Two", 2);
		mp.put("Three", 3);
		mp.put("Four", 4);
		mp.put("Five", 5);
		
		System.out.println(mp);
		
		mp.put("Five", 55);
		System.out.println(mp);
		
		System.out.println(mp.containsKey("Three"));
		
		System.out.println(mp.containsValue(3));
		
		System.out.println(mp.isEmpty());

		System.out.println(mp.keySet());
		System.out.println(mp.values());
		
		mp.remove("Four");
		System.out.println(mp);
		
		Set<String> st = mp.keySet();
		for(String s:st){
			System.out.println(s);
		}
		
		mp.clear();
		System.out.println(mp);
		
		//OutPut :
		{Five=5, One=1, Four=4, Two=2, Three=3}
		{Five=55, One=1, Four=4, Two=2, Three=3}
		true
		true
		false
		[Five, One, Four, Two, Three]
		[55, 1, 4, 2, 3]
		{Five=55, One=1, Two=2, Three=3}
		Five
		One
		Two
		Three
		{}*/


		
		/*Sorted one
		TreeMap mp = new TreeMap();
		mp.put("One", 1);
		mp.put("Two", 2);
		mp.put("Three", 3);
		mp.put("Four", 4);
		mp.put("Five", 5);
		
		System.out.println(mp);
		
		mp.put("Five", 55);
		System.out.println(mp);
		
		System.out.println(mp.containsKey("Three"));
		
		System.out.println(mp.containsValue(3));
		
		System.out.println(mp.isEmpty());

		System.out.println(mp.keySet());
		System.out.println(mp.values());
		
		mp.remove("Four");
		System.out.println(mp);
		
		Set<String> st = mp.keySet();
		for(String s:st){
			System.out.println(s);
		}
		
		mp.clear();
		System.out.println(mp);
		
		//OutPut :
		{Five=5, Four=4, One=1, Three=3, Two=2}
		{Five=55, Four=4, One=1, Three=3, Two=2}
		true
		true
		false
		[Five, Four, One, Three, Two]
		[55, 4, 1, 3, 2]
		{Five=55, One=1, Three=3, Two=2}
		Five
		One
		Three
		Two
		{}*/

	}

}
