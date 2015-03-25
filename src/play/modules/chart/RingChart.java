package play.modules.chart;

import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Ring chart.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
final class RingChart extends AbstractChart {

    // mandatory
    private final Map<Comparable, Number> dataset;

    RingChart(RingChartBuilder builder) {
	super(builder.title, builder.titleFontSize, builder.legend, builder.width, builder.height);
	this.dataset = builder.dataset;
    }

    @Override
    JFreeChart createChart() {
	PieDataset dataset = new DefaultPieDataset(Datasets.asKeyedValues(this.dataset));
	return ChartFactory.createRingChart(title, dataset, legend, false, false);
    }

}