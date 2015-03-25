package play.modules.chart;

import java.util.Map;

/**
 * Bar chart builder.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class BarChartBuilder extends AbstractChartBuilder {

    // mandatory
    final Map<Comparable, Map<Comparable, Number>> dataset;

    // optional
    String xLabel;
    String yLabel;
    ChartOrientation orientation = ChartOrientation.VERTICAL;

    BarChartBuilder(Map<Comparable, Map<Comparable, Number>> dataset) {
	this.dataset = dataset;
    }

    @Override
    public BarChartBuilder title(String title) {
	this.title = title;
	return this;
    }

    @Override
    public BarChartBuilder titleFontSize(int titleFontSize) {
	this.titleFontSize = titleFontSize;
	return this;
    }

    @Override
    public BarChartBuilder legend(boolean legend) {
	this.legend = legend;
	return this;
    }

    @Override
    public BarChartBuilder width(int width) {
	this.width = width;
	return this;
    }

    @Override
    public BarChartBuilder height(int height) {
	this.height = height;
	return this;
    }

    /**
     * Configure the X axis label.
     * 
     * @param xLabel X axis label
     * @return The chart builder itself
     */
    public BarChartBuilder xLabel(String xLabel) {
	this.xLabel = xLabel;
	return this;
    }

    /**
     * Configure the Y axis label.
     * 
     * @param yLabel Y axis label
     * @return The chart builder itself
     */
    public BarChartBuilder yLabel(String yLabel) {
	this.yLabel = yLabel;
	return this;
    }

    /**
     * Configure the chart orientation.
     * 
     * @param orientation Chart orientation
     * @return The chart builder itself
     */
    public BarChartBuilder orientation(ChartOrientation orientation) {
	this.orientation = orientation;
	return this;
    }

    @Override
    public Chart build() {
	return new BarChart(this);
    }

}