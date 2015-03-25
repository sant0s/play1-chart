package tags;

import groovy.lang.Closure;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import play.exceptions.TagInternalException;
import play.exceptions.TemplateExecutionException;
import play.modules.chart.Chart;
import play.templates.FastTags;
import play.templates.GroovyTemplate.ExecutableTemplate;

/**
 * Chart fast tags.
 * 
 * @author Jose Santos
 * @version 0.1
 * @since 0.1
 */
@FastTags.Namespace("chart")
public class ChartFastTags extends FastTags {

    private static final String HTML_IMG = "<img src=\"data:image/png;base64,%s\" %s/>";
    private static final String[] EXCLUDE_IMG_ATTRS = {"chart", "src", "width", "height"};
    private static final String HTML_IMG_WIDTH_HEIGHT = "width=\"%s\" height=\"%s\"";

    private static final String ARG_CHART = "chart";
    private static final String PNG_ENCODING_FAILED = "Failed to encode chart image as PNG: %s";
    private static final String CHART_MISSING_OR_NULL = String.format(
	    "Mandatory parameter '%s' is either missing or null", ARG_CHART);
    private static final String CHART_TYPE_INVALID = "Value of parameter '" + ARG_CHART + "' must be an instance of %s";

    /**
     * Render chart as an HTML <code>img</code> tag with the following attributes:
     * <ul>
     * <li><code>src</code> set to <code>data:image/png;base64,&lt;base64&gt;</code> where <code>&lt;base64&gt;</code>
     * is the Base64-encoded chart image</li>
     * <li><code>width</code> set to the chart image width</li>
     * <li><code>height</code> set to the chart image height</li>
     * </ul>
     * Any other attribute passed to this tag is copied verbatim to the HTML <code>img</code> tag.
     * 
     * @param args Mandatory <code>chart</code> argument set to a <code>Chart</code> object along with optional HTML the
     *            HTML <code>img</code> tag attributes (e.g. <code>id</code>, <code>class</code>)
     * @param body Body of the tag which should be empty (it is ignored)
     * @param out Output stream
     * @param template Template where this fast tag is called from
     * @param line Line within the template where this fast tag is called from
     */
    public static void _img(Map<?, ?> args, Closure body, PrintWriter out, ExecutableTemplate template, int line) {

	Object argValue = args.get(ARG_CHART);
	if (argValue == null) {
	    throw new TemplateExecutionException(template.template, line, CHART_MISSING_OR_NULL,
		    new TagInternalException(CHART_MISSING_OR_NULL));
	}
	try {
	    Chart chart = (Chart) argValue;
	    out.print(getBase64IMG(args, chart));
	} catch (ClassCastException e) {
	    String message = String.format(CHART_TYPE_INVALID, Chart.class.getName(), argValue.getClass().getName());
	    throw new TemplateExecutionException(template.template, line, message, new TagInternalException(message));
	} catch (IOException e) {
	    String message = String.format(PNG_ENCODING_FAILED, e.getMessage());
	    throw new TemplateExecutionException(template.template, line, message, new TagInternalException(message));
	}

    }

    private static String getBase64IMG(Map<?, ?> args, Chart chart) throws IOException {

	String base64IMG = null;

	// build HTML img attributes width, height and any other passed on to the fast tag except width and height
	// themselves as well as src and chart
	StringBuilder attributes = new StringBuilder(String.format(HTML_IMG_WIDTH_HEIGHT, chart.getWidth(),
		chart.getHeight()));
	attributes.append(FastTags.serialize(args, EXCLUDE_IMG_ATTRS));

	// build the HTML img tag with the Base64-encoded chart image and the attributes
	base64IMG = String.format(HTML_IMG, chart.asBase64(), attributes);

	return base64IMG;

    }

}