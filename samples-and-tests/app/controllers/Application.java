package controllers;

import static play.modules.chart.ChartResult.renderChart;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import play.modules.chart.BarChartBuilder;
import play.modules.chart.Chart;
import play.modules.chart.ChartBuilderFactory;
import play.modules.chart.ChartOrientation;
import play.modules.chart.LineChartBuilder;
import play.modules.chart.PieChartBuilder;
import play.modules.chart.RingChartBuilder;
import play.mvc.Controller;

/**
 * Chart module demo application.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class Application extends Controller {

    /**
     * Series (recipes) and categories (ingredients) dataset.
     */
    private static final Map<Comparable, Map<Comparable, Number>> SERIES_CATEGORIES_VALUES;

    /**
     * Keys (continents) and values (area) dataset.
     */
    private static final Map<Comparable, Number> KEYS_VALUES = ArrayUtils.toMap(new Object[][] { {"Asia", 29.5D},
	    {"Africa", 20.4D}, {"North America", 16.5D}, {"South America", 12D}, {"Antarctica", 9.2D},
	    {"Europe", 6.8D}, {"Australia", 5.9D}});

    static {
	Map<Comparable, Number> applePie = ArrayUtils.toMap(new Object[][] { {"Allspice", 0}, {"Apple", 70},
		{"Cinnamon", 5}, {"Flour", 15}, {"Pumpkin", 0}, {"Sugar", 10}});
	Map<Comparable, Number> pumpkinPie = ArrayUtils.toMap(new Object[][] { {"Allspice", 5}, {"Apple", 0},
		{"Cinnamon", 0}, {"Flour", 15}, {"Pumpkin", 65}, {"Sugar", 15}});
	SERIES_CATEGORIES_VALUES = new LinkedHashMap();
	SERIES_CATEGORIES_VALUES.put("Apple Pie", applePie);
	SERIES_CATEGORIES_VALUES.put("Pumpkin Pie", pumpkinPie);

    }

    public static void index() {

	// BAR CHARTS

	// bar chart with a dataset of series of categories and values
	BarChartBuilder barChart1Builder = ChartBuilderFactory.newBarChartBuilder(SERIES_CATEGORIES_VALUES);
	Chart barChart1 = barChart1Builder.build();

	// same dataset as previous one but customised
	BarChartBuilder barChart2Builder = ChartBuilderFactory.newBarChartBuilder(SERIES_CATEGORIES_VALUES);
	barChart2Builder.title("Chart 2").titleFontSize(20).legend(true).width(700).height(500).xLabel("Ingredients")
		.yLabel("Quantity").orientation(ChartOrientation.HORIZONTAL);
	Chart barChart2 = barChart2Builder.build();

	// LINE CHARTS

	// line chart with a dataset of series of categories and values
	LineChartBuilder lineChart1Builder = ChartBuilderFactory.newLineChartBuilder(SERIES_CATEGORIES_VALUES);
	Chart lineChart1 = lineChart1Builder.build();

	// same dataset as previous one but customised
	LineChartBuilder lineChart2Builder = ChartBuilderFactory.newLineChartBuilder(SERIES_CATEGORIES_VALUES);
	lineChart2Builder.title("Chart 2").titleFontSize(20).legend(true).width(700).height(500).xLabel("Ingredients")
		.yLabel("Quantity").orientation(ChartOrientation.HORIZONTAL);
	Chart lineChart2 = lineChart2Builder.build();

	// PIE CHARTS

	// dataset of categories and values
	PieChartBuilder pieChart1Builder = ChartBuilderFactory.newPieChartBuilder(KEYS_VALUES);
	Chart pieChart1 = pieChart1Builder.build();

	// same as previous one but customised
	PieChartBuilder pieChart2Builder = ChartBuilderFactory.newPieChartBuilder(KEYS_VALUES);
	pieChart2Builder.title("Pie 2").titleFontSize(20).legend(true).width(700).height(500);
	Chart pieChart2 = pieChart2Builder.build();

	// RING CHARTS

	// dataset of categories and values
	RingChartBuilder ringChart1Builder = ChartBuilderFactory.newRingChartBuilder(KEYS_VALUES);
	Chart ringChart1 = ringChart1Builder.build();

	// same as previous one but customised
	RingChartBuilder ringChart2Builder = ChartBuilderFactory.newRingChartBuilder(KEYS_VALUES);
	ringChart2Builder.title("Ring 2").titleFontSize(20).legend(true).width(700).height(500);
	Chart ringChart2 = ringChart2Builder.build();

	render(barChart1, barChart2, lineChart1, lineChart2, pieChart1, pieChart2, ringChart1, ringChart2);

    }

    public static void chart() {

	// bar chart with a dataset of series of categories and values
	BarChartBuilder builder = ChartBuilderFactory.newBarChartBuilder(SERIES_CATEGORIES_VALUES);
	Chart chart = builder.build();

	renderChart(chart);

    }

}
