package play.modules.chart;

import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Bar chart.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
final class BarChart extends AbstractChart {

    // mandatory
    private final Map<Comparable, Map<Comparable, Number>> dataset;

    // optional
    private final String xLabel;
    private final String yLabel;
    private final ChartOrientation orientation;

    BarChart(BarChartBuilder builder) {
	super(builder.title, builder.titleFontSize, builder.legend, builder.width, builder.height);
	this.dataset = builder.dataset;
	this.xLabel = builder.xLabel;
	this.yLabel = builder.yLabel;
	this.orientation = builder.orientation;
    }

    @Override
    JFreeChart createChart() {
	DefaultCategoryDataset dataset = Datasets.asCategoryDataset(this.dataset);
	return ChartFactory.createBarChart(this.title, this.xLabel, this.yLabel, dataset, this.orientation.value,
		this.legend, false, false);

    }
}