package play.modules.chart;

import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import play.mvc.Http;
import play.test.UnitTest;

/**
 * Chart result test.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class ChartResultTest extends UnitTest {

    private Map<Comparable, Map<Comparable, Number>> seriesCategories;

    @Before
    public void setUp() {
	Map<Comparable, Number> categories = new LinkedHashMap();
	categories.put("C1", 1);
	categories.put("C2", 2);
	this.seriesCategories = new LinkedHashMap();
	this.seriesCategories.put("S1", categories);
    }

    @Test
    public void renderChart() {
	Chart chart = ChartBuilderFactory.newBarChartBuilder(this.seriesCategories).build();
	try {
	    ChartResult.renderChart(chart);
	} catch (ChartResult e) {
	    Http.Response response = new Http.Response();
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    response.out = baos;
	    e.apply(null, response);
	    assertEquals("image/png", response.contentType);
	}
    }

}