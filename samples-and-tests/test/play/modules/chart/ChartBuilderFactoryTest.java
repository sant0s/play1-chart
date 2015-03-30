package play.modules.chart;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

/**
 * Chart builder factory test.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class ChartBuilderFactoryTest extends UnitTest {

    private Map<Comparable, Map<Comparable, Number>> seriesCategories;
    private Map<Comparable, Number> keysValues;

    @Before
    public void setUp() {
	Map<Comparable, Number> categories = new LinkedHashMap();
	categories.put("C1", 1);
	categories.put("C2", 2);
	this.seriesCategories = new LinkedHashMap();
	this.seriesCategories.put("S1", categories);

	this.keysValues = new LinkedHashMap();
	this.keysValues.put("K1", 1);
	this.keysValues.put("K2", 2);
    }

    @Test
    public void newBarChartBuilder() {
	assertChart(ChartBuilderFactory.newBarChartBuilder(this.seriesCategories).build());
    }

    @Test
    public void newLineChartBuilder() {
	assertChart(ChartBuilderFactory.newLineChartBuilder(this.seriesCategories).build());
    }

    @Test
    public void newPieChartBuilder() {
	assertChart(ChartBuilderFactory.newPieChartBuilder(this.keysValues).build());
    }

    @Test
    public void newRingChartBuilder() {
	assertChart(ChartBuilderFactory.newRingChartBuilder(this.keysValues).build());
    }

    private void assertChart(Chart chart) {
	assertEquals(chart.getWidth(), AbstractChart.DEFAULT_WIDTH);
	assertEquals(chart.getHeight(), AbstractChart.DEFAULT_HEIGHT);
	assertNotNull(chart.asBase64());
	assertNotNull(chart.asRaw());
    }

}