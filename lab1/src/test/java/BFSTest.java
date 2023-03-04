import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.company.lab1.util.BreadCrumbs;
import test.company.lab1.util.BreadthFirstSearch;

import java.util.Arrays;

public class BFSTest {

    BreadthFirstSearch g;

    @BeforeAll
    static void start() {
        System.out.println("BFS test's started!");
    }

    @Nested
    class TestGraphOne {
        @BeforeEach
        @DisplayName("Первый граф. Малый несвязный")
        public void init() {
            g = new BreadthFirstSearch(8,new BreadCrumbs());
            g.addEdge(0, 1);
            g.addEdge(1, 0);
            g.addEdge(0, 2);
            g.addEdge(2, 0);
            g.addEdge(1, 2);
            g.addEdge(2, 1);
            g.addEdge(4, 7);
            g.addEdge(7, 4);
            g.addEdge(5, 7);
            g.addEdge(7, 5);
        }

        @Test
        @DisplayName("Тест для проверки правильности начальной инициализации списка рёбер, массива предков и массива посещённых вершин")
        public void firstGraphInitTestMethod() {
            Assertions.assertArrayEquals(g.getAdj()[0].toArray(), new Integer[]{1, 2}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[1].toArray(), new Integer[]{0, 2}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[2].toArray(), new Integer[]{0, 1}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[3].toArray(), new Integer[]{}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[4].toArray(), new Integer[]{7}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[5].toArray(), new Integer[]{7}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[6].toArray(), new Integer[]{}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[7].toArray(), new Integer[]{4, 5}, "adjacency list is incorrect");

            int[] parentInitial = new int[8];
            Arrays.fill(parentInitial, -1);


            Assertions.assertArrayEquals(g.getParent(), parentInitial, "parents initial state is incorrect");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[8], "visited initial state is incorrect");
        }

        @ParameterizedTest
        @ValueSource(ints = {0})
        @DisplayName("Тест прохода графа в ширину")
        public void firstGraphTraverseTestMethod1(int startVertex) {

            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{-1, 0, 0, -1, -1, -1, -1, -1}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{true, true, true, false, false, false, false, false}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add0poll0add1add2poll1poll2","Incorrect queue working process");


        }

        @ParameterizedTest
        @ValueSource(ints = {3})
        @DisplayName("Тест прохода графа в ширину")
        public void firstGraphTraverseTestMethod2(int startVertex) {

            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{-1, -1, -1, -1, -1, -1, -1, -1}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{false, false, false, true, false, false, false, false}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add3poll3","Incorrect queue working process");



        }

        @ParameterizedTest
        @ValueSource(ints = {5})
        @DisplayName("Тест прохода графа в ширину")
        public void firstGraphTraverseTestMethod3(int startVertex) {

            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{-1, -1, -1, -1, 7, -1, -1, 5}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{false, false, false, false, true, true, false, true}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add5poll5add7poll7add4poll4","Incorrect queue working process");


        }

    }

    @Nested
    class TestGraphTwo {
        @BeforeEach
        @DisplayName("Второй граф. Большой связный")
        public void init() {
            g = new BreadthFirstSearch(18,new BreadCrumbs());
            g.addEdge(0, 1);
            g.addEdge(1, 0);
            g.addEdge(0, 7);
            g.addEdge(7, 0);
            g.addEdge(0, 14);
            g.addEdge(14, 0);
            g.addEdge(0, 2);
            g.addEdge(2, 0);
            g.addEdge(1, 4);
            g.addEdge(4, 1);
            g.addEdge(1, 5);
            g.addEdge(5, 1);
            g.addEdge(2, 5);
            g.addEdge(5, 2);
            g.addEdge(2, 3);
            g.addEdge(3, 2);
            g.addEdge(3, 10);
            g.addEdge(10, 3);
            g.addEdge(4, 7);
            g.addEdge(7, 4);
            g.addEdge(4, 8);
            g.addEdge(8, 4);
            g.addEdge(5, 6);
            g.addEdge(6, 5);
            g.addEdge(5, 8);
            g.addEdge(8, 5);
            g.addEdge(5, 9);
            g.addEdge(9, 5);
            g.addEdge(6, 9);
            g.addEdge(9, 6);
            g.addEdge(6, 10);
            g.addEdge(10, 6);
            g.addEdge(7, 8);
            g.addEdge(8, 7);
            g.addEdge(8, 9);
            g.addEdge(9, 8);
            g.addEdge(8, 11);
            g.addEdge(11, 8);
            g.addEdge(8, 12);
            g.addEdge(12, 8);
            g.addEdge(9, 12);
            g.addEdge(12, 9);
            g.addEdge(9, 13);
            g.addEdge(13, 9);
            g.addEdge(10, 13);
            g.addEdge(13, 10);
            g.addEdge(11, 12);
            g.addEdge(12, 11);
            g.addEdge(11, 15);
            g.addEdge(15, 11);
            g.addEdge(12, 13);
            g.addEdge(13, 12);
            g.addEdge(13, 17);
            g.addEdge(17, 13);
            g.addEdge(14, 15);
            g.addEdge(15, 14);
            g.addEdge(15, 16);
            g.addEdge(16, 15);
            g.addEdge(15, 17);
            g.addEdge(17, 15);
            g.addEdge(16, 17);
            g.addEdge(17, 16);

        }


        @Test
        @DisplayName("Тест для проверки правильности начальной инициализации списка рёбер, массива предков и массива посещённых вершин")
        public void secondGraphInitTestMethod() {

            Assertions.assertArrayEquals(g.getAdj()[0].toArray(), new Integer[]{1, 7, 14, 2}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[1].toArray(), new Integer[]{0, 4, 5}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[2].toArray(), new Integer[]{0, 5, 3}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[3].toArray(), new Integer[]{2, 10}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[4].toArray(), new Integer[]{1, 7, 8}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[5].toArray(), new Integer[]{1, 2, 6, 8, 9}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[6].toArray(), new Integer[]{5, 9, 10}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[7].toArray(), new Integer[]{0, 4, 8}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[8].toArray(), new Integer[]{4, 5, 7, 9, 11, 12}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[9].toArray(), new Integer[]{5, 6, 8, 12, 13}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[10].toArray(), new Integer[]{3, 6, 13}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[11].toArray(), new Integer[]{8, 12, 15}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[12].toArray(), new Integer[]{8, 9, 11, 13}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[13].toArray(), new Integer[]{9, 10, 12, 17}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[14].toArray(), new Integer[]{0, 15}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[15].toArray(), new Integer[]{11, 14, 16, 17}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[16].toArray(), new Integer[]{15, 17}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[17].toArray(), new Integer[]{13, 15, 16}, "adjacency list is incorrect");


            int[] parentInitial = new int[18];
            Arrays.fill(parentInitial, -1);


            Assertions.assertArrayEquals(g.getParent(), parentInitial, "parents initial state is incorrect");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[18], "visited initial state is incorrect");


        }

        @ParameterizedTest
        @ValueSource(ints = {2})
        @DisplayName("Тест прохода графа в ширину")
        public void secondGraphTraverseTestMethod1(int startVertex) {
            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{2, 0, -1, 2, 1, 2, 5, 0, 5, 5, 3, 8, 8, 9, 0, 14, 15, 15}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add2poll2add0add5add3poll0add1add7add14poll5add6add8add9poll3add10poll1add4poll7poll14add15poll6poll8add11add12poll9add13poll10poll4poll15add16add17poll11poll12poll13poll16poll17","Incorrect queue working process");


        }


        @ParameterizedTest
        @ValueSource(ints = {7})
        @DisplayName("Тест прохода графа в ширину")
        public void secondGraphTraverseTestMethod2(int startVertex) {
            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{7, 0, 0, 2, 7, 8, 5, -1, 7, 8, 3, 8, 8, 9, 0, 14, 15, 15}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add7poll7add0add4add8poll0add1add14add2poll4poll8add5add9add11add12poll1poll14add15poll2add3poll5add6poll9add13poll11poll12poll15add16add17poll3add10poll6poll13poll16poll17poll10","Incorrect queue working process");


        }


        @ParameterizedTest
        @ValueSource(ints = {17})
        @DisplayName("Тест прохода графа в ширину")
        public void secondGraphTraverseTestMethod3(int startVertex) {
            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{14, 5, 5, 10, 8, 9, 9, 8, 9, 13, 13, 15, 13, 17, 15, 17, 17, -1}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add17poll17add13add15add16poll13add9add10add12poll15add11add14poll16poll9add5add6add8poll10add3poll12poll11poll14add0poll5add1add2poll6poll8add4add7poll3poll0poll1poll2poll4poll7","Incorrect queue working process");

        }
    }


    @Nested
    class TestGraphThree {
        @BeforeEach
        @DisplayName("Второй граф. Малый связный")
        public void init() {
            g = new BreadthFirstSearch(8,new BreadCrumbs());
            g.addEdge(0, 1);
            g.addEdge(1, 0);
            g.addEdge(0, 3);
            g.addEdge(3, 0);
            g.addEdge(0, 4);
            g.addEdge(4, 0);
            g.addEdge(1, 5);
            g.addEdge(5, 1);
            g.addEdge(2, 4);
            g.addEdge(4, 2);
            g.addEdge(2, 5);
            g.addEdge(5, 2);
            g.addEdge(3, 5);
            g.addEdge(5, 3);
            g.addEdge(3, 7);
            g.addEdge(7, 3);
            g.addEdge(4, 6);
            g.addEdge(6, 4);
        }

        @Test
        @DisplayName("Тест для проверки правильности начальной инициализации списка рёбер, массива предков и массива посещённых вершин")
        public void thirdGraphInitTestMethod() {

            Assertions.assertArrayEquals(g.getAdj()[0].toArray(), new Integer[]{1, 3, 4}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[1].toArray(), new Integer[]{0, 5}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[2].toArray(), new Integer[]{4, 5}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[3].toArray(), new Integer[]{0, 5, 7}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[4].toArray(), new Integer[]{0, 2, 6}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[5].toArray(), new Integer[]{1, 2, 3}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[6].toArray(), new Integer[]{4}, "adjacency list is incorrect");
            Assertions.assertArrayEquals(g.getAdj()[7].toArray(), new Integer[]{3}, "adjacency list is incorrect");


            int[] parentInitial = new int[8];
            Arrays.fill(parentInitial, -1);


            Assertions.assertArrayEquals(g.getParent(), parentInitial, "parents initial state is incorrect");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[8], "visited initial state is incorrect");
        }

        @ParameterizedTest
        @ValueSource(ints = {1})
        @DisplayName("Тест прохода графа в ширину")
        public void thirdGraphTraverseTestMethod1(int startVertex) {

            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{1, -1, 5, 0, 0, 1, 4, 3}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{true, true, true, true, true, true, true, true}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add1poll1add0add5poll0add3add4poll5add2poll3add7poll4add6poll2poll7poll6","Incorrect queue working process");

        }

        @ParameterizedTest
        @ValueSource(ints = {4})
        @DisplayName("Тест прохода графа в ширину")
        public void thirdGraphTraverseTestMethod2(int startVertex) {

            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{4, 0, 4, 0, -1, 2, 4, 3}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{true, true, true, true, true, true, true, true}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add4poll4add0add2add6poll0add1add3poll2add5poll6poll1poll3add7poll5poll7","Incorrect queue working process");

        }

        @ParameterizedTest
        @ValueSource(ints = {7})
        @DisplayName("Тест прохода графа в ширину")
        public void thirdGraphTraverseTestMethod3(int startVertex) {

            System.out.println("Start vertex = " + startVertex);
            g.BFS(startVertex);
            Assertions.assertArrayEquals(g.getParent(), new int[]{3, 0, 5, 7, 0, 3, 4, -1}, "parents don't match with correct parents");
            Assertions.assertArrayEquals(g.getVisited(), new boolean[]{true, true, true, true, true, true, true, true}, "visited don't match with correct visited");
            Assertions.assertEquals(g.getBreadCrumbs().getTrace(),"add7poll7add3poll3add0add5poll0add1add4poll5add2poll1poll4add6poll2poll6","Incorrect queue working process");

        }


    }


}
