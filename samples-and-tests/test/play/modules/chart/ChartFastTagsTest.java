package play.modules.chart;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;
import tags.ChartFastTags;

/**
 * Chart renderer test.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
public class ChartFastTagsTest extends UnitTest {

    private Map<Comparable, Map<Comparable, Number>> seriesCategories;
    private Map<Comparable, Number> keysValues;

    @Before
    public void setup() {
	Map<Comparable, Number> categories = new LinkedHashMap();
	categories.put("C1", 1);
	categories.put("C2", 2);
	this.seriesCategories = new LinkedHashMap();
	this.seriesCategories.put("S1", categories);

	this.keysValues = new LinkedHashMap();
	this.keysValues.put("K1", 1);
	this.keysValues.put("K2", 2);
    }

    @Test
    public void _imgDefault() {
	Chart chart = ChartBuilderFactory.newBarChartBuilder(this.seriesCategories).build();
	assertImg(this._img(chart, null), AbstractChart.DEFAULT_WIDTH, AbstractChart.DEFAULT_HEIGHT, "");
    }

    @Test
    public void _imgCustom() {
	int width = 100, height = 100;
	Chart chart = ChartBuilderFactory.newBarChartBuilder(this.seriesCategories).width(width).height(height).build();
	assertImg(this._img(chart, null), width, height, "");
    }

    @Test
    public void _imgDefaultWithAttributes() {
	Chart chart = ChartBuilderFactory.newBarChartBuilder(this.seriesCategories).build();
	Map<String, String> attributes = new HashMap<String, String>();
	attributes.put(" title", "Title");
	assertImg(this._img(chart, attributes), AbstractChart.DEFAULT_WIDTH, AbstractChart.DEFAULT_HEIGHT,
		"title=\"Title\"");
    }

    @Test
    public void _imgCustomWithAttributes() {
	int width = 100, height = 100;
	Chart chart = ChartBuilderFactory.newBarChartBuilder(this.seriesCategories).width(width).height(100).build();
	Map<String, String> attributes = new HashMap<String, String>();
	attributes.put("title", "Title");
	assertImg(this._img(chart, attributes), width, height, "title=\"Title\"");
    }

    private void assertImg(String text, int width, int height, String attributes) {
	String w = String.valueOf(width);
	String h = String.valueOf(height);
	assertTrue(text.matches("<img src=\"data:image/png;base64,[^\"]+\" width=\"" + w + "\" height=\"" + h + "\" ?"
		+ attributes + " ?/>"));
    }

    private String _img(Chart chart, Map<String, String> attributes) {
	Map<String, Object> args = new HashMap();
	args.put("chart", chart);
	if (attributes != null) {
	    args.putAll(attributes);
	}
	StringWriter writer = new StringWriter();
	PrintWriter out = new PrintWriter(writer);
	ChartFastTags._img(args, null, out, null, 0);
	return writer.toString();
    }

}