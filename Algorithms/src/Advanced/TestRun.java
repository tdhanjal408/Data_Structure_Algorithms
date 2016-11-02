package Advanced;

public class TestRun {
	public static void main(String arg[]) {
		QueueOps<Integer> testQueue = new QueueOps<Integer>(3);
		System.out.println(testQueue.deQueue());
		testQueue.enQueue(1);
		testQueue.enQueue(2);
		testQueue.enQueue(3);
		testQueue.enQueue(4);
		System.out.println(testQueue.deQueue().toString());
		testQueue.enQueue(4);
		System.out.println(testQueue.deQueue());
		testQueue.enQueue(5);
		testQueue.enQueue(6);
		System.out.println("--------------");
		StackOps<Integer> testStack = new StackOps<Integer>(3);
		System.out.println(testStack.getSize());
		testStack.push(12);
		testStack.push(33);
		testStack.push(25);
		testStack.push(90);
		testStack.push(91);
		System.out.println(testStack.getSize());
		System.out.println(testStack.pop());
		System.out.println(testStack.pop());
		testStack.push(91);
		System.out.println(testStack.pop());
		System.out.println("--------------");
		HashArray<Integer> array = new HashArray<Integer>(); 
		array.insert(34);
		array.insert(23);
		array.insert(90);
		System.out.println(array.getRandom());
		System.out.println(array.getRandom());
		array.remove(23);
		System.out.println(array.search(23));
		
	}
}
