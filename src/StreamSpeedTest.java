import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class StreamSpeedTest {

	static final int NUM_OBJECTS = 1000000;
	static final int NUM_RUNS = 4;

	Set<MyObj> objectSet = new HashSet<MyObj>();

	public static void main(String[] args) {
		StreamSpeedTest ssTest = new StreamSpeedTest();
		ssTest.populateObjSet();

		for (int r = 0; r < NUM_RUNS; r++) {
			System.out.println();
			System.out.println("========== Run " + (r + 1) + ": ==========");
			System.out.println();

			ssTest.testLoop();
			ssTest.testStream();
			ssTest.testParallelStream();
			ssTest.testComparator();
		}

		System.out.println();
		System.out.println("Finshed.");
	}

	void populateObjSet() {
		System.out.println("Creating objects...");
		long then = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			objectSet.add(new MyObj(i));
		}
		long now = System.currentTimeMillis();
		System.out.println("Created " + NUM_OBJECTS + " objects in " + (now - then) + " miliseconds.");
	}

	void testLoop() {
		long then = System.currentTimeMillis();
		MyObj maxObj = null;
		double highestVal = 0.0;
		for (MyObj o : objectSet) {
			double val = o.getVal();
			if (val > highestVal) {
				highestVal = val;
				maxObj = o;
			}
		}
		long now = System.currentTimeMillis();
		System.out.println("[Loop]\t\t\t" + (now - then) + " ms.");
	}

	void testStream() {
		long then = System.currentTimeMillis();
		MyObj maxObj = objectSet.stream().reduce((o1, o2) -> o1.getVal() > o2.getVal() ? o1 : o2).get();
		long now = System.currentTimeMillis();
		System.out.println("[Stream]\t\t" + (now - then) + " ms.");
	}

	void testParallelStream() {
		long then = System.currentTimeMillis();
		MyObj maxObj = objectSet.parallelStream().reduce((o1, o2) -> o1.getVal() > o2.getVal() ? o1 : o2).get();
		long now = System.currentTimeMillis();
		System.out.println("[ParallelStream]\t" + (now - then) + " ms.");
	}

	void testComparator() {
		long then = System.currentTimeMillis();
		MyObj maxObj = Collections.max(objectSet, Comparator.comparing(o -> o.getVal()));
		long now = System.currentTimeMillis();
		System.out.println("[Comparator]\t\t" + (now - then) + " ms.");
	}
}
