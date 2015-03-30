package play.modules.chart;

import java.io.IOException;

import play.exceptions.UnexpectedException;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.results.Result;

/**
 * Chart result providing method <code>renderChart</code>. This method is meant to be used within controller actions
 * rendering charts.
 *
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class ChartResult extends Result {

    private final Chart chart;

    private ChartResult(Chart chart) {
	this.chart = chart;
    }

    /**
     * Render chart.
     * 
     * @param chart Chart
     */
    public static void renderChart(Chart chart) {
	throw new ChartResult(chart);
    }

    @Override
    public void apply(Request request, Response response) {

	byte[] chart = this.chart.asRaw();
	this.setContentTypeIfNotSet(response, AbstractChart.DEFAULT_IMAGE_CONTENT_TYPE);
	try {
	    response.out.write(chart);
	} catch (IOException e) {
	    throw new UnexpectedException(e);
	}

    }

}