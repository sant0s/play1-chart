package play.modules.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;

import play.exceptions.UnexpectedException;
import play.libs.Codec;

/**
 * Abstract chart.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
abstract class AbstractChart implements Chart {

    static final int DEFAULT_WIDTH = 800;
    static final int DEFAULT_HEIGHT = 400;
    static final int DEFAULT_TITLE_FONT_SIZE = JFreeChart.DEFAULT_TITLE_FONT.getSize();
    static final Color DEFAULT_BACKGROUND_COLOUR = Color.WHITE;
    static final Color DEFAULT_PLOT_BACKGROUND_COLOUR = Color.WHITE;

    private static final String DEFAULT_IMAGE_FORMAT = "png";
    static final String DEFAULT_IMAGE_CONTENT_TYPE = "image/png";

    // optional
    final String title;
    final int titleFontSize;
    final boolean legend;
    final int width;
    final int height;

    AbstractChart(String title, int titleFontSize, boolean legend, int width, int height) {
	this.title = title;
	this.titleFontSize = titleFontSize;
	this.legend = legend;
	this.width = width;
	this.height = height;
    }

    @Override
    public int getWidth() {
	return this.width;
    }

    @Override
    public int getHeight() {
	return this.height;
    }

    @Override
    public String asBase64() {

	JFreeChart chart = this.buildChart();
	BufferedImage image = chart.createBufferedImage(this.width, this.height);
	byte[] pngEncodedImage;
	try {
	    pngEncodedImage = ChartUtilities.encodeAsPNG(image);
	} catch (IOException e) {
	    throw new UnexpectedException(e);
	}

	return Codec.encodeBASE64(pngEncodedImage);

    }

    @Override
    public byte[] asRaw() {

	byte[] rawChart = null;

	JFreeChart chart = this.buildChart();
	RenderedImage image = chart.createBufferedImage(this.width, this.height);
	try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	    ImageIO.write(image, DEFAULT_IMAGE_FORMAT, baos);
	    rawChart = baos.toByteArray();
	} catch (IOException e) {
	    throw new UnexpectedException(e);
	}

	return rawChart;

    }

    JFreeChart buildChart() {
	return this.configure(this.createChart());
    }

    abstract JFreeChart createChart();

    private JFreeChart configure(JFreeChart chart) {

	// set title font size if title exists and its font size is different from the default one
	if (this.title != null && this.titleFontSize != DEFAULT_TITLE_FONT_SIZE) {
	    TextTitle textTitle = chart.getTitle();
	    Font textTitleFont = textTitle.getFont();
	    Font chartTextTitleFont = new Font(textTitleFont.getName(), textTitleFont.getStyle(), this.titleFontSize);
	    textTitle.setFont(chartTextTitleFont);
	}

	// set chart and chart plot background colours
	chart.setBackgroundPaint(DEFAULT_BACKGROUND_COLOUR);
	chart.getPlot().setBackgroundPaint(DEFAULT_PLOT_BACKGROUND_COLOUR);

	return chart;

    }

}
