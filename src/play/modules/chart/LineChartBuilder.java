package play.modules.chart;

import java.util.Map;

/**
 * Line chart builder.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class LineChartBuilder extends AbstractChartBuilder {

    // mandatory
    final Map<Comparable, Map<Comparable, Number>> dataset;

    // optional
    String xLabel;
    String yLabel;
    ChartOrientation orientation = ChartOrientation.VERTICAL;

    LineChartBuilder(Map<Comparable, Map<Comparable, Number>> dataset) {
	this.dataset = dataset;
    }

    @Override
    public LineChartBuilder title(String title) {
	this.title = title;
	return this;
    }

    @Override
    public LineChartBuilder titleFontSize(int titleFontSize) {
	this.titleFontSize = titleFontSize;
	return this;
    }

    @Override
    public LineChartBuilder legend(boolean legend) {
	this.legend = legend;
	return this;
    }

    @Override
    public LineChartBuilder width(int width) {
	this.width = width;
	return this;
    }

    @Override
    public LineChartBuilder height(int height) {
	this.height = height;
	return this;
    }

    /**
     * Configure the X axis label.
     * 
     * @param xLabel X axis label
     * @return The chart builder itself
     */
    public LineChartBuilder xLabel(String xLabel) {
	this.xLabel = xLabel;
	return this;
    }

    /**
     * Configure the Y axis label.
     * 
     * @param yLabel Y axis label
     * @return The chart builder itself
     */
    public LineChartBuilder yLabel(String yLabel) {
	this.yLabel = yLabel;
	return this;
    }

    /**
     * Configure the chart orientation.
     * 
     * @param orientation Chart orientation
     * @return The chart builder itself
     */
    public LineChartBuilder orientation(ChartOrientation orientation) {
	this.orientation = orientation;
	return this;
    }

    @Override
    public Chart build() {
	return new LineChart(this);
    }

}