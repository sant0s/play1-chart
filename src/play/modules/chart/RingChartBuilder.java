package play.modules.chart;

import java.util.Map;

/**
 * Ring chart builder.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class RingChartBuilder extends AbstractChartBuilder {

    // mandatory
    final Map<Comparable, Number> dataset;

    RingChartBuilder(Map<Comparable, Number> dataset) {
	this.dataset = dataset;
    }

    @Override
    public RingChartBuilder title(String title) {
	this.title = title;
	return this;
    }

    @Override
    public RingChartBuilder titleFontSize(int titleFontSize) {
	this.titleFontSize = titleFontSize;
	return this;
    }

    @Override
    public RingChartBuilder legend(boolean legend) {
	this.legend = legend;
	return this;
    }

    @Override
    public RingChartBuilder width(int width) {
	this.width = width;
	return this;
    }

    @Override
    public RingChartBuilder height(int height) {
	this.height = height;
	return this;
    }

    @Override
    public Chart build() {
	return new RingChart(this);
    }

}