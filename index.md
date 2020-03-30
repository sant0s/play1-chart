Chart
=====

The Chart module allows easy generation of chart images. The following
chart types are supported:

-   Bar
-   Line
-   Pie
-   Ring

The image format is PNG.

This module makes use of the JFreeChart library.

Quick example
-------------

### Controller

    Map<Comparable, Number> dataset = ArrayUtils.toMap(new Object[][] {
            {"Slice 1", 51}, {"Slice 2", 49}});
    Chart pieChart = ChartBuilderFactory.newPieChartBuilder(dataset).build();
    render(pieChart);

### View

    #{chart.img chart: pieChart /}

Sample application
------------------

A sample application can be found in the `samples-and-tests` directory.
It provides documentation and examples of all supported charts.

Introduction
------------

For HTML views, an image can be represented as an `img` tag where its
`src` attribute is either:

1.  A Base64-encoded image:
    -   `<img src="data:image/png;base64,<base64> <attrs> />`
        -   `<base64>` is a Base64-encoded image
        -   `<attrs>` is a list of additional attributes
2.  An image URL:
    -   `<img src="<url>" <attrs> />`
        -   `<url>` is the URL of an image
        -   `<attrs>` is a list of `img` attributes besides `src`

The Chart module supports both scenarios i.e. chart images can be
generated in either Base64-encoded or raw forms.

Usage
-----

### Chart as `img` with `src` set to a Base64-encoded image

In this scenario, a controller creates (or obtains) a `Chart` instance
and passes it to a view which renders it through a fast tag.

#### Creating a `Chart` instance in the controller

A `Chart` can be created using the following idiom (example for a pie
chart):

    Map<Comparable, Number> dataset = ArrayUtils.toMap(new Object[][] {
            {"Asia", 29.5D}, {"Africa", 20.4D}, {"North America", 16.5D},
            {"South America", 12D}, {"Antarctica", 9.2D}, {"Europe", 6.8D},
            {"Australia", 5.9D}});
    PieChartBuilder builder = ChartBuilderFactory.newPieChartBuilder(dataset);
    builder.title("Pie").legend(true).width(700).height(500);
    Chart pieChart = builder.build();
    render(pieChart);

The steps are:

1.  Initialise the chart dataset. Different chart types require
    different dataset types. In this example, the pie chart requires a
    map of key-value pairs, each to be rendered as its slices.
2.  Get a builder for the chart type.
3.  Optionally, configure the builder. In this example, the chart title,
    legend visibility and image dimensions are set.
4.  Build the chart.
5.  Pass the chart to the view.

#### Rendering the `Chart` instance in the view

A `Chart` can be rendered in a view via:

    #{chart.img chart: pieChart /}

The `chart.img` fast tag generates the chart image and generates an
`img` tag with the following attributes:

-   `src` set to the Base64-encoded representation of the chart image
-   `width` set to the chart image width
-   `height` set to the chart image height

Attributes `width` and `height` provide rendering hints to the user
agent.

Additional attributes may be supplied via:

    #{chart.img chart: pieChart, title: "The pie" /}

These attributes are copied verbatim to the HTML `img` tag. In this
example,\
`img` will include attributes `src`, `width`, `height` and `title`.

### Chart as `img` with `src` set to a URL

In this scenario, a controller creates (or obtains) a `Chart` instance,
generates its image and returns it in its raw form i.e. as PNG bytes.

#### Creating a `Chart` instance in the controller

The steps are similar to the previous scenario, except for the render
part:

    import static play.modules.chart.ChartResult.renderChart;
    Map<Comparable, Number> dataset = ArrayUtils.toMap(new Object[][] {
            {"Asia", 29.5D}, {"Africa", 20.4D}, {"North America", 16.5D},
            {"South America", 12D}, {"Antarctica", 9.2D}, {"Europe", 6.8D},
            {"Australia", 5.9D}});
    PieChartBuilder builder = ChartBuilderFactory.newPieChartBuilder(dataset);
    builder.title("Pie").legend(true).width(700).height(500);
    Chart pieChart = builder.build();
    renderChart(pieChart);

`renderChart` will generate the chart image and return it as PNG bytes.

#### Rendering the `Chart` instance in the view

Assuming that the code above belongs to an action method named
`chart()`, the view can render the chart image via:

    <img src="{@chart()}" />

Additional information
----------------------

The examples herein illustrate the idiom to obtain a `Chart` instance
and render its image using Base64-encoded and raw forms.

`ChartBuilderFactory` is the entry point for chart generation. This
factory provides methods for obtaining configurable builders of all
supported chart types.

Additional information on supported chart types and builder
configuration options can be found in the sample application.
