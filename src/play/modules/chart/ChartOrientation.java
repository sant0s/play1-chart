package play.modules.chart;

import org.jfree.chart.plot.PlotOrientation;

/**
 * Chart orientation.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public enum ChartOrientation {

    /**
     * Horizontal orientation.
     */
    HORIZONTAL(PlotOrientation.HORIZONTAL),

    /**
     * Vertical orientation.
     */
    VERTICAL(PlotOrientation.VERTICAL);

    PlotOrientation value;

    private ChartOrientation(PlotOrientation value) {
	this.value = value;
    }

}