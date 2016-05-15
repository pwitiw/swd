import pwr.swd.algorithm.graph.GraphNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mi on 2016-05-15.
 */
public class GraphNodeTest {
    private Long sampleTime = 1234L;
    private String sampleLocation = "Wro,PL";

    @Test
    public void nodeCreation() throws Exception {
        GraphNode graphNode = new GraphNode(sampleLocation, sampleTime);

        assertEquals(sampleLocation, graphNode.toString());
        assertEquals(sampleTime, graphNode.getTimeLimitAsLong());
    }
}
