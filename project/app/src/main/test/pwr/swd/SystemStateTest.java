import pwr.swd.algorithm.graph.GraphNode;
import pwr.swd.algorithm.SystemState;
import pwr.swd.algorithm.graph.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mi on 2016-05-15.
 */
public class SystemStateTest {
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
    public void systemStateUpdate() {
        v[0].addDestination(v[1], 0L);
        v[0].addDestination(v[2], 2L);
        v[1].addDestination(v[0], 1L);
        v[2].addDestination(v[0], 3L);
        v[2].addDestination(v[1], 4L);

        List<Vertex> list = new ArrayList<Vertex>();
        Collections.addAll(list, v[0], v[1], v[2]);

        SystemState systemState = new SystemState(v[0], list);

        assertEquals(list, systemState.getLocationsLeft());
        assertEquals((Long)0L, systemState.getTotalDistance());
        assertEquals(v[0], systemState.getCurrentVertex());
        assertEquals((Long)Long.MAX_VALUE, systemState.getTimeMagrin());

        SystemState newState = systemState.generateNewState(v[2]);

        assertEquals(Arrays.asList(v[0], v[1]), newState.getLocationsLeft());
        assertEquals((Long)2L, newState.getTotalDistance());
        assertEquals(v[2], newState.getCurrentVertex());
        assertEquals((Long)120L, newState.getTimeMagrin());
    }

    @Test
    public void resultDisplay() {
        v[0].addDestination(v[2], 2L);
        v[2].addDestination(v[1], 2L);
        v[1].addDestination(v[0], 2L);

        List<Vertex> list = new ArrayList<Vertex>();
        Collections.addAll(list, v[0], v[1], v[2]);

        SystemState systemState = new SystemState(v[0], list);

        systemState = systemState.generateNewState(v[2]);
        systemState = systemState.generateNewState(v[1]);
        systemState = systemState.generateNewState(v[0]);

        assertEquals(Arrays.asList(v[0], v[1], v[2], v[0]), systemState.getVisitedLocations());
    }
}
