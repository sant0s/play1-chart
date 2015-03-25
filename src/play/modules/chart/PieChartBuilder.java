package play.modules.chart;

import java.util.Map;

/**
 * Pie chart builder.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class PieChartBuilder extends AbstractChartBuilder {

    // mandatory
    final Map<Comparable, Number> dataset;

    PieChartBuilder(Map<Comparable, Number> dataset) {
	this.dataset = dataset;
    }

    @Override
    public PieChartBuilder title(String title) {
	this.title = title;
	return this;
    }

    @Override
    public PieChartBuilder titleFontSize(int titleFontSize) {
	this.titleFontSize = titleFontSize;
	return this;
    }

    @Override
    public PieChartBuilder legend(boolean legend) {
	this.legend = legend;
	return this;
    }

    @Override
    public PieChartBuilder width(int width) {
	this.width = width;
	return this;
    }

    @Override
    public PieChartBuilder height(int height) {
	this.height = height;
	return this;
    }

    @Override
    public Chart build() {
	return new PieChart(this);
    }

}