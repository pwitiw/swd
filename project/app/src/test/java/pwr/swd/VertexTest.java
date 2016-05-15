import pwr.swd.algorithm.graph.GraphNode;
import pwr.swd.algorithm.graph.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class VertexTest {
    private Vertex[] v;

    @Before
    public void setUp() {
        GraphNode n0 = new GraphNode("Loc0", 101L);
        GraphNode n1 = new GraphNode("Loc1", 100L);
        GraphNode n2 = new GraphNode("Loc2", 120L);
        GraphNode n3 = new GraphNode("Loc3", 130L);

        Vertex v0 = new Vertex(n0);
        Vertex v1 = new Vertex(n1);
        Vertex v2 = new Vertex(n2);
        Vertex v3 = new Vertex(n3);

        v = new Vertex[]{v0, v1, v2, v3};
    }

    @Test
    public void vertexCreation() {
        GraphNode graphNode = new GraphNode("dummy", 123L);

        Vertex v = new Vertex(graphNode);
        assertEquals("dummy", v.toString());
    }

    @Test
    public void vertexMapCreation() {
        v[0].addDestination(v[1], 1L);
        v[1].addDestination(v[2], 2L);
        v[2].addDestination(v[0], 3L);

        assertEquals(v[0].getDistanceTo(v[1]), new Long(1));
        assertEquals(v[2].getDistanceTo(v[0]), new Long(3));
    }
}