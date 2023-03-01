import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.company.lab1.util.BreadthFirstSearch;
import test.company.lab1.util.Functions;


public class BFSTest {

    BreadthFirstSearch g;


    @BeforeAll
    static void start(){
        System.out.println("BFS test's started!");
    }


    @Nested
    class TestNestOne{
        @BeforeEach
        public void init() {
            System.out.println("BFS with first graph");
            g = new BreadthFirstSearch(8);
            g.addEdge(0, 3);
            g.addEdge(3, 0);
            g.addEdge(1, 2);
            g.addEdge(2, 1);
            g.addEdge(1, 5);
            g.addEdge(5, 1);
            g.addEdge(1, 6);
            g.addEdge(6, 1);
            g.addEdge(2, 4);
            g.addEdge(4, 2);
            g.addEdge(4, 7);
            g.addEdge(7, 4);
        }

        @ParameterizedTest
        @ValueSource(ints = {2})
        public void firstTestMethod1(int startVertex) {

            System.out.println("Start vertex = "+startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(),new int[]{-1, 2, -1, -1, 2, 1, 1, 4},"parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(),new boolean[]{false, true, true, false, true, true, true, true},"visited don't match with correct visited");

        }

        @Test
        public void firstTestMethod2(int startVertex) {
            System.out.println("This is method 2 in first graph");
        }
    }

    @Nested
    class TestNestTwo{
        @BeforeEach
        public void init() {
            System.out.println("BFS with second graph");
            g = new BreadthFirstSearch(8);
            g.addEdge(0, 3);
            g.addEdge(3, 0);
            g.addEdge(1, 2);
            g.addEdge(2, 1);
            g.addEdge(1, 5);
            g.addEdge(5, 1);
            g.addEdge(2, 6);
            g.addEdge(6, 2);
            g.addEdge(5, 6);
            g.addEdge(6, 5);
            g.addEdge(4, 7);
            g.addEdge(7, 4);
        }

        @Test
        public void secondTestMethod1(int startVertex) {
            System.out.println("This is method 1 in second graph");
        }

        @Test
        public void secondTestMethod2(int startVertex) {
            System.out.println("This is method 2 in second graph");
        }
    }
}
