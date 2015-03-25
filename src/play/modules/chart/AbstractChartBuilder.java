package play.modules.chart;

/**
 * Abstract chart builder.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
abstract class AbstractChartBuilder {

    String title;
    int titleFontSize = AbstractChart.DEFAULT_TITLE_FONT_SIZE;
    boolean legend;
    int width = AbstractChart.DEFAULT_WIDTH;
    int height = AbstractChart.DEFAULT_HEIGHT;

    /**
     * Configure the title of the chart.
     * 
     * @param title Chart title
     * @return The chart builder itself
     */
    abstract AbstractChartBuilder title(String title);

    /**
     * Configure the font size of the title of the chart.
     * 
     * @param titleFontSize Chart title font size
     * @return The chart builder itself
     */
    abstract AbstractChartBuilder titleFontSize(int titleFontSize);

    /**
     * Configure the legend of the chart.
     * 
     * @param legend Chart legend
     * @return The chart builder itself
     */
    abstract AbstractChartBuilder legend(boolean legend);

    /**
     * Configure the width of the chart.
     * 
     * @param width Chart width
     * @return The chart builder itself
     */
    abstract AbstractChartBuilder width(int width);

    /**
     * Configure the height of the chart.
     * 
     * @param height Chart height
     * @return The chart builder itself
     */
    abstract AbstractChartBuilder height(int height);

    /**
     * Build chart based on configured settings.
     * 
     * @return Chart
     */
    abstract Chart build();

}