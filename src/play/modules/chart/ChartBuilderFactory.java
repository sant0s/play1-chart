package play.modules.chart;

import java.util.Map;

/**
 * Chart builder factory.
 * 
 * @author Jose Santos
 */
public class ChartBuilderFactory {

    private ChartBuilderFactory() {
    }

    /**
     * Create a bar chart builder.
     * 
     * @param dataset
     *            The dataset of the chart as a map of series and maps of categories and values
     * @return Bar chart builder
     */
    public static BarChartBuilder newBarChartBuilder(Map<Comparable, Map<Comparable, Number>> dataset) {
	return new BarChartBuilder(dataset);
    }

    /**
     * Create a line chart builder.
     * 
     * @param dataset
     *            The dataset of the chart as a map of series and maps of categories and values
     * @return Line chart builder
     */
    public static LineChartBuilder newLineChartBuilder(Map<Comparable, Map<Comparable, Number>> dataset) {
	return new LineChartBuilder(dataset);
    }

    /**
     * Create a pie chart builder.
     * 
     * @param dataset
     *            The dataset of the chart as a map of keys and values
     * @return Pie chart builder
     */
    public static PieChartBuilder newPieChartBuilder(Map<Comparable, Number> dataset) {
	return new PieChartBuilder(dataset);
    }

    /**
     * Create a ring chart builder.
     * 
     * @param dataset
     *            The dataset of the chart as a map of keys and values
     * @return Ring chart builder
     */
    public static RingChartBuilder newRingChartBuilder(Map<Comparable, Number> dataset) {
	return new RingChartBuilder(dataset);
    }

}