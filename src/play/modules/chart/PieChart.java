package play.modules.chart;

import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Pie chart.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
final class PieChart extends AbstractChart {

    // mandatory
    private final Map<Comparable, Number> dataset;

    PieChart(PieChartBuilder builder) {
	super(builder.title, builder.titleFontSize, builder.legend, builder.width, builder.height);
	this.dataset = builder.dataset;
    }

    @Override
    JFreeChart createChart() {
	PieDataset dataset = new DefaultPieDataset(Datasets.asKeyedValues(this.dataset));
	return ChartFactory.createPieChart(title, dataset, legend, false, false);
    }

}