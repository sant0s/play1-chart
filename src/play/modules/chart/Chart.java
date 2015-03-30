package play.modules.chart;

/**
 * Chart.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public interface Chart {

    /**
     * Get the width of chart image.
     * 
     * @return Chart image width
     */
    public int getWidth();

    /**
     * Get the height of the chart image.
     * 
     * @return Chart image height
     */
    public int getHeight();

    /**
     * Get the Base64 representation of the chart image.
     * 
     * @return Chart Base64-encoded image
     */
    public String asBase64();

    /**
     * Get the raw representation of the chart image.
     * 
     * @return Chart raw image
     */
    public byte[] asRaw();

}