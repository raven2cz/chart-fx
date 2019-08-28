/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package de.gsi.chart.renderer.spi.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

/**
 * @author braeun
 */
public class ColorGradient {

    /**
     * Rainbow colors gradient: violet, indigo, blue, green, yellow, orange and red.
     */
    public static final ColorGradient RAINBOW = new ColorGradient("RAINBOW", new Stop(0.0, Color.TRANSPARENT),
            new Stop(Double.MIN_VALUE, Color.VIOLET), new Stop(0.17, Color.INDIGO), new Stop(0.34, Color.BLUE),
            new Stop(0.51, Color.GREEN), new Stop(0.68, Color.YELLOW), new Stop(0.85, Color.ORANGE),
            new Stop(1.0, Color.RED));

    /**
     * colour scheme 'jet'
     */
    public static final ColorGradient JET = new ColorGradient("JET", new Stop(0.0, Color.BLACK),
            new Stop(0.1, Color.web("#00007F")), new Stop(0.2, Color.BLUE), new Stop(0.3, Color.web("#007FFF")),
            new Stop(0.4, Color.CYAN), new Stop(0.5, Color.web("#7FFF7F")), new Stop(0.6, Color.YELLOW),
            new Stop(0.7, Color.web("#FF7F00")), new Stop(0.8, Color.RED), new Stop(0.9, Color.web("#7F0000")));

    /**
     * colour scheme 'topography'
     */
    public static final ColorGradient TOPO = new ColorGradient("TOPO_EXT", new Stop(0.00, Color.TRANSPARENT),
            new Stop(Double.MIN_VALUE, Color.web("#000064")), new Stop(0.09, Color.web("#647ee5")),
            new Stop(0.18, Color.web("#86a4e9")), new Stop(0.27, Color.web("#9fbde6")),
            new Stop(0.36, Color.web("#4d572c")), new Stop(0.45, Color.web("#00C800")),
            new Stop(0.54, Color.web("#c2b96f")), new Stop(0.63, Color.web("#df7c39")),
            new Stop(0.82, Color.web("#7e3410")), new Stop(0.91, Color.web("#C8C8C8")), new Stop(1.00, Color.WHITE));

    /**
     * colour scheme 'extended topography'
     */
    public static final ColorGradient TOPO_EXT = new ColorGradient("TOPO_EXT", new Stop(0.0, Color.TRANSPARENT),
            new Stop(Double.MIN_VALUE, Color.BLUE), new Stop(0.09, Color.rgb(0, 0, 100)),
            new Stop(0.18, Color.rgb(50, 50, 200)), new Stop(0.27, Color.rgb(100, 100, 200)),
            new Stop(0.36, Color.rgb(150, 150, 255)), new Stop(0.45, Color.rgb(50, 150, 50)),
            new Stop(0.55, Color.rgb(100, 200, 100)), new Stop(0.64, Color.rgb(150, 255, 155)),
            new Stop(0.73, Color.web("#D78821")), new Stop(0.82, Color.web("#8E5C16")),
            new Stop(0.91, Color.rgb(200, 200, 200)), new Stop(1.0, Color.WHITE));

    /**
     * White to black gradient.
     */
    public static final ColorGradient WHITE_BLACK = new ColorGradient("WHITE_BLACK", new Stop(0.0, Color.WHITE),
            new Stop(1.0, Color.BLACK));
    /**
     * Black to white gradient.
     */
    public static final ColorGradient BLACK_WHITE = new ColorGradient("BLACK_WHITE", new Stop(0.0, Color.BLACK),
            new Stop(1.0, Color.WHITE));

    /**
     * Black to white thermal-inspired gradient.
     */
    public static final ColorGradient HOT = new ColorGradient("HOT", new Stop(0.0, Color.BLACK),
            new Stop(0.25, Color.DARKRED), new Stop(0.5, Color.RED), new Stop(0.75, Color.ORANGE),
            new Stop(0.9, Color.YELLOW), new Stop(1.0, Color.WHITE));

    /**
     * BLUE -&gt; PURPLE -&gt; RED
     */
    public static final ColorGradient BLUERED = new ColorGradient("BLUE-RED", new Stop(0.0, Color.TRANSPARENT),
            new Stop(Double.MIN_VALUE, Color.DARKBLUE), new Stop(0.25, Color.BLUE),
            new Stop(0.35, Color.BLUE.brighter()), new Stop(0.5, Color.PURPLE.brighter().brighter()),
            new Stop(0.65, Color.RED.brighter()), new Stop(0.75, Color.RED), new Stop(1.0, Color.DARKRED));

    /**
     * pink inspired
     */
    public static final ColorGradient PINK = new ColorGradient("PINK",
            new Stop(0.0, Color.web("#33ccff").darker().darker()), new Stop(0.2, Color.web("#33ccff").darker()),
            new Stop(0.4, Color.web("#33ccff")), new Stop(0.6, Color.web("#ff99cc")),
            new Stop(0.8, Color.web("#ff99cc").brighter()), new Stop(1.0, Color.WHITE));

    /**
     * Red, yellow, white.
     */
    public static final ColorGradient SUNRISE = new ColorGradient("SUNRISE", new Stop(0.0, Color.RED),
            new Stop(0.66, Color.YELLOW), new Stop(1.0, Color.WHITE));

    public static final ColorGradient VIRIDIS = ColorGradient.viridis();

    private final List<Stop> stops;

    private final String name;
    /**
     * Creates a new instance of ColorGradient.**
     *
     * @param stops the gradient's color specification; should contain at least* two stops with offsets between 0.0 and
     *            1.0*
     * @see #getStops()
     */

    public ColorGradient(final List<Stop> stops) {
        this("custom", stops);
    }

    /**
     * Creates a new instance of ColorGradient.
     *
     * @param stops the gradient's color specification; should contain at least two stops with offsets between 0.0 and
     *            1.0
     * @see #getStops()
     */
    public ColorGradient(final Stop... stops) {
        this("custom", stops);
    }

    /**
     * Creates a new instance of ColorGradient.
     *
     * @param name name of gradient
     * @param stops the gradient's color specification; should contain at least two stops with offsets between 0.0 and
     *            1.0
     * @see #getStops()
     */
    public ColorGradient(final String name, final List<Stop> stops) {
        // Use LinearGradient to normalize stops
        this.stops = new LinearGradient(0, 0, 0, 0, false, CycleMethod.NO_CYCLE, stops).getStops(); // NOPMD
        this.name = name;
    }

    /**
     * Creates a new instance of ColorGradient.
     *
     * @param name name of gradient
     * @param stops the gradient's color specification; should contain at least two stops with offsets between 0.0 and
     *            1.0
     * @see #getStops()
     */
    public ColorGradient(final String name, final Stop... stops) {
        // Use LinearGradient to normalize stops
        this.stops = new LinearGradient(0, 0, 0, 0, false, CycleMethod.NO_CYCLE, stops).getStops(); // NOPMD
        this.name = name;
    }

    public static List<ColorGradient> colorGradients() {
        return Arrays.asList(ColorGradient.RAINBOW, ColorGradient.JET, ColorGradient.TOPO, ColorGradient.TOPO_EXT,
                ColorGradient.WHITE_BLACK, ColorGradient.BLACK_WHITE, ColorGradient.HOT, ColorGradient.SUNRISE,
                ColorGradient.VIRIDIS, ColorGradient.BLUERED, ColorGradient.PINK);
    }

    private static final ColorGradient viridis() {
        // From MatPlotLib
        final float[][] vals = new float[][] { { 0.267004f, 0.004874f, 0.329415f }, { 0.268510f, 0.009605f, 0.335427f },
                { 0.269944f, 0.014625f, 0.341379f }, { 0.271305f, 0.019942f, 0.347269f },
                { 0.272594f, 0.025563f, 0.353093f }, { 0.273809f, 0.031497f, 0.358853f },
                { 0.274952f, 0.037752f, 0.364543f }, { 0.276022f, 0.044167f, 0.370164f },
                { 0.277018f, 0.050344f, 0.375715f }, { 0.277941f, 0.056324f, 0.381191f },
                { 0.278791f, 0.062145f, 0.386592f }, { 0.279566f, 0.067836f, 0.391917f },
                { 0.280267f, 0.073417f, 0.397163f }, { 0.280894f, 0.078907f, 0.402329f },
                { 0.281446f, 0.084320f, 0.407414f }, { 0.281924f, 0.089666f, 0.412415f },
                { 0.282327f, 0.094955f, 0.417331f }, { 0.282656f, 0.100196f, 0.422160f },
                { 0.282910f, 0.105393f, 0.426902f }, { 0.283091f, 0.110553f, 0.431554f },
                { 0.283197f, 0.115680f, 0.436115f }, { 0.283229f, 0.120777f, 0.440584f },
                { 0.283187f, 0.125848f, 0.444960f }, { 0.283072f, 0.130895f, 0.449241f },
                { 0.282884f, 0.135920f, 0.453427f }, { 0.282623f, 0.140926f, 0.457517f },
                { 0.282290f, 0.145912f, 0.461510f }, { 0.281887f, 0.150881f, 0.465405f },
                { 0.281412f, 0.155834f, 0.469201f }, { 0.280868f, 0.160771f, 0.472899f },
                { 0.280255f, 0.165693f, 0.476498f }, { 0.279574f, 0.170599f, 0.479997f },
                { 0.278826f, 0.175490f, 0.483397f }, { 0.278012f, 0.180367f, 0.486697f },
                { 0.277134f, 0.185228f, 0.489898f }, { 0.276194f, 0.190074f, 0.493001f },
                { 0.275191f, 0.194905f, 0.496005f }, { 0.274128f, 0.199721f, 0.498911f },
                { 0.273006f, 0.204520f, 0.501721f }, { 0.271828f, 0.209303f, 0.504434f },
                { 0.270595f, 0.214069f, 0.507052f }, { 0.269308f, 0.218818f, 0.509577f },
                { 0.267968f, 0.223549f, 0.512008f }, { 0.266580f, 0.228262f, 0.514349f },
                { 0.265145f, 0.232956f, 0.516599f }, { 0.263663f, 0.237631f, 0.518762f },
                { 0.262138f, 0.242286f, 0.520837f }, { 0.260571f, 0.246922f, 0.522828f },
                { 0.258965f, 0.251537f, 0.524736f }, { 0.257322f, 0.256130f, 0.526563f },
                { 0.255645f, 0.260703f, 0.528312f }, { 0.253935f, 0.265254f, 0.529983f },
                { 0.252194f, 0.269783f, 0.531579f }, { 0.250425f, 0.274290f, 0.533103f },
                { 0.248629f, 0.278775f, 0.534556f }, { 0.246811f, 0.283237f, 0.535941f },
                { 0.244972f, 0.287675f, 0.537260f }, { 0.243113f, 0.292092f, 0.538516f },
                { 0.241237f, 0.296485f, 0.539709f }, { 0.239346f, 0.300855f, 0.540844f },
                { 0.237441f, 0.305202f, 0.541921f }, { 0.235526f, 0.309527f, 0.542944f },
                { 0.233603f, 0.313828f, 0.543914f }, { 0.231674f, 0.318106f, 0.544834f },
                { 0.229739f, 0.322361f, 0.545706f }, { 0.227802f, 0.326594f, 0.546532f },
                { 0.225863f, 0.330805f, 0.547314f }, { 0.223925f, 0.334994f, 0.548053f },
                { 0.221989f, 0.339161f, 0.548752f }, { 0.220057f, 0.343307f, 0.549413f },
                { 0.218130f, 0.347432f, 0.550038f }, { 0.216210f, 0.351535f, 0.550627f },
                { 0.214298f, 0.355619f, 0.551184f }, { 0.212395f, 0.359683f, 0.551710f },
                { 0.210503f, 0.363727f, 0.552206f }, { 0.208623f, 0.367752f, 0.552675f },
                { 0.206756f, 0.371758f, 0.553117f }, { 0.204903f, 0.375746f, 0.553533f },
                { 0.203063f, 0.379716f, 0.553925f }, { 0.201239f, 0.383670f, 0.554294f },
                { 0.199430f, 0.387607f, 0.554642f }, { 0.197636f, 0.391528f, 0.554969f },
                { 0.195860f, 0.395433f, 0.555276f }, { 0.194100f, 0.399323f, 0.555565f },
                { 0.192357f, 0.403199f, 0.555836f }, { 0.190631f, 0.407061f, 0.556089f },
                { 0.188923f, 0.410910f, 0.556326f }, { 0.187231f, 0.414746f, 0.556547f },
                { 0.185556f, 0.418570f, 0.556753f }, { 0.183898f, 0.422383f, 0.556944f },
                { 0.182256f, 0.426184f, 0.557120f }, { 0.180629f, 0.429975f, 0.557282f },
                { 0.179019f, 0.433756f, 0.557430f }, { 0.177423f, 0.437527f, 0.557565f },
                { 0.175841f, 0.441290f, 0.557685f }, { 0.174274f, 0.445044f, 0.557792f },
                { 0.172719f, 0.448791f, 0.557885f }, { 0.171176f, 0.452530f, 0.557965f },
                { 0.169646f, 0.456262f, 0.558030f }, { 0.168126f, 0.459988f, 0.558082f },
                { 0.166617f, 0.463708f, 0.558119f }, { 0.165117f, 0.467423f, 0.558141f },
                { 0.163625f, 0.471133f, 0.558148f }, { 0.162142f, 0.474838f, 0.558140f },
                { 0.160665f, 0.478540f, 0.558115f }, { 0.159194f, 0.482237f, 0.558073f },
                { 0.157729f, 0.485932f, 0.558013f }, { 0.156270f, 0.489624f, 0.557936f },
                { 0.154815f, 0.493313f, 0.557840f }, { 0.153364f, 0.497000f, 0.557724f },
                { 0.151918f, 0.500685f, 0.557587f }, { 0.150476f, 0.504369f, 0.557430f },
                { 0.149039f, 0.508051f, 0.557250f }, { 0.147607f, 0.511733f, 0.557049f },
                { 0.146180f, 0.515413f, 0.556823f }, { 0.144759f, 0.519093f, 0.556572f },
                { 0.143343f, 0.522773f, 0.556295f }, { 0.141935f, 0.526453f, 0.555991f },
                { 0.140536f, 0.530132f, 0.555659f }, { 0.139147f, 0.533812f, 0.555298f },
                { 0.137770f, 0.537492f, 0.554906f }, { 0.136408f, 0.541173f, 0.554483f },
                { 0.135066f, 0.544853f, 0.554029f }, { 0.133743f, 0.548535f, 0.553541f },
                { 0.132444f, 0.552216f, 0.553018f }, { 0.131172f, 0.555899f, 0.552459f },
                { 0.129933f, 0.559582f, 0.551864f }, { 0.128729f, 0.563265f, 0.551229f },
                { 0.127568f, 0.566949f, 0.550556f }, { 0.126453f, 0.570633f, 0.549841f },
                { 0.125394f, 0.574318f, 0.549086f }, { 0.124395f, 0.578002f, 0.548287f },
                { 0.123463f, 0.581687f, 0.547445f }, { 0.122606f, 0.585371f, 0.546557f },
                { 0.121831f, 0.589055f, 0.545623f }, { 0.121148f, 0.592739f, 0.544641f },
                { 0.120565f, 0.596422f, 0.543611f }, { 0.120092f, 0.600104f, 0.542530f },
                { 0.119738f, 0.603785f, 0.541400f }, { 0.119512f, 0.607464f, 0.540218f },
                { 0.119423f, 0.611141f, 0.538982f }, { 0.119483f, 0.614817f, 0.537692f },
                { 0.119699f, 0.618490f, 0.536347f }, { 0.120081f, 0.622161f, 0.534946f },
                { 0.120638f, 0.625828f, 0.533488f }, { 0.121380f, 0.629492f, 0.531973f },
                { 0.122312f, 0.633153f, 0.530398f }, { 0.123444f, 0.636809f, 0.528763f },
                { 0.124780f, 0.640461f, 0.527068f }, { 0.126326f, 0.644107f, 0.525311f },
                { 0.128087f, 0.647749f, 0.523491f }, { 0.130067f, 0.651384f, 0.521608f },
                { 0.132268f, 0.655014f, 0.519661f }, { 0.134692f, 0.658636f, 0.517649f },
                { 0.137339f, 0.662252f, 0.515571f }, { 0.140210f, 0.665859f, 0.513427f },
                { 0.143303f, 0.669459f, 0.511215f }, { 0.146616f, 0.673050f, 0.508936f },
                { 0.150148f, 0.676631f, 0.506589f }, { 0.153894f, 0.680203f, 0.504172f },
                { 0.157851f, 0.683765f, 0.501686f }, { 0.162016f, 0.687316f, 0.499129f },
                { 0.166383f, 0.690856f, 0.496502f }, { 0.170948f, 0.694384f, 0.493803f },
                { 0.175707f, 0.697900f, 0.491033f }, { 0.180653f, 0.701402f, 0.488189f },
                { 0.185783f, 0.704891f, 0.485273f }, { 0.191090f, 0.708366f, 0.482284f },
                { 0.196571f, 0.711827f, 0.479221f }, { 0.202219f, 0.715272f, 0.476084f },
                { 0.208030f, 0.718701f, 0.472873f }, { 0.214000f, 0.722114f, 0.469588f },
                { 0.220124f, 0.725509f, 0.466226f }, { 0.226397f, 0.728888f, 0.462789f },
                { 0.232815f, 0.732247f, 0.459277f }, { 0.239374f, 0.735588f, 0.455688f },
                { 0.246070f, 0.738910f, 0.452024f }, { 0.252899f, 0.742211f, 0.448284f },
                { 0.259857f, 0.745492f, 0.444467f }, { 0.266941f, 0.748751f, 0.440573f },
                { 0.274149f, 0.751988f, 0.436601f }, { 0.281477f, 0.755203f, 0.432552f },
                { 0.288921f, 0.758394f, 0.428426f }, { 0.296479f, 0.761561f, 0.424223f },
                { 0.304148f, 0.764704f, 0.419943f }, { 0.311925f, 0.767822f, 0.415586f },
                { 0.319809f, 0.770914f, 0.411152f }, { 0.327796f, 0.773980f, 0.406640f },
                { 0.335885f, 0.777018f, 0.402049f }, { 0.344074f, 0.780029f, 0.397381f },
                { 0.352360f, 0.783011f, 0.392636f }, { 0.360741f, 0.785964f, 0.387814f },
                { 0.369214f, 0.788888f, 0.382914f }, { 0.377779f, 0.791781f, 0.377939f },
                { 0.386433f, 0.794644f, 0.372886f }, { 0.395174f, 0.797475f, 0.367757f },
                { 0.404001f, 0.800275f, 0.362552f }, { 0.412913f, 0.803041f, 0.357269f },
                { 0.421908f, 0.805774f, 0.351910f }, { 0.430983f, 0.808473f, 0.346476f },
                { 0.440137f, 0.811138f, 0.340967f }, { 0.449368f, 0.813768f, 0.335384f },
                { 0.458674f, 0.816363f, 0.329727f }, { 0.468053f, 0.818921f, 0.323998f },
                { 0.477504f, 0.821444f, 0.318195f }, { 0.487026f, 0.823929f, 0.312321f },
                { 0.496615f, 0.826376f, 0.306377f }, { 0.506271f, 0.828786f, 0.300362f },
                { 0.515992f, 0.831158f, 0.294279f }, { 0.525776f, 0.833491f, 0.288127f },
                { 0.535621f, 0.835785f, 0.281908f }, { 0.545524f, 0.838039f, 0.275626f },
                { 0.555484f, 0.840254f, 0.269281f }, { 0.565498f, 0.842430f, 0.262877f },
                { 0.575563f, 0.844566f, 0.256415f }, { 0.585678f, 0.846661f, 0.249897f },
                { 0.595839f, 0.848717f, 0.243329f }, { 0.606045f, 0.850733f, 0.236712f },
                { 0.616293f, 0.852709f, 0.230052f }, { 0.626579f, 0.854645f, 0.223353f },
                { 0.636902f, 0.856542f, 0.216620f }, { 0.647257f, 0.858400f, 0.209861f },
                { 0.657642f, 0.860219f, 0.203082f }, { 0.668054f, 0.861999f, 0.196293f },
                { 0.678489f, 0.863742f, 0.189503f }, { 0.688944f, 0.865448f, 0.182725f },
                { 0.699415f, 0.867117f, 0.175971f }, { 0.709898f, 0.868751f, 0.169257f },
                { 0.720391f, 0.870350f, 0.162603f }, { 0.730889f, 0.871916f, 0.156029f },
                { 0.741388f, 0.873449f, 0.149561f }, { 0.751884f, 0.874951f, 0.143228f },
                { 0.762373f, 0.876424f, 0.137064f }, { 0.772852f, 0.877868f, 0.131109f },
                { 0.783315f, 0.879285f, 0.125405f }, { 0.793760f, 0.880678f, 0.120005f },
                { 0.804182f, 0.882046f, 0.114965f }, { 0.814576f, 0.883393f, 0.110347f },
                { 0.824940f, 0.884720f, 0.106217f }, { 0.835270f, 0.886029f, 0.102646f },
                { 0.845561f, 0.887322f, 0.099702f }, { 0.855810f, 0.888601f, 0.097452f },
                { 0.866013f, 0.889868f, 0.095953f }, { 0.876168f, 0.891125f, 0.095250f },
                { 0.886271f, 0.892374f, 0.095374f }, { 0.896320f, 0.893616f, 0.096335f },
                { 0.906311f, 0.894855f, 0.098125f }, { 0.916242f, 0.896091f, 0.100717f },
                { 0.926106f, 0.897330f, 0.104071f }, { 0.935904f, 0.898570f, 0.108131f },
                { 0.945636f, 0.899815f, 0.112838f }, { 0.955300f, 0.901065f, 0.118128f },
                { 0.964894f, 0.902323f, 0.123941f }, { 0.974417f, 0.903590f, 0.130215f },
                { 0.983868f, 0.904867f, 0.136897f }, { 0.993248f, 0.906157f, 0.143936f } };
        final int ncolors = vals.length;
        final double delta = 1.0 / (ncolors - 1);
        final ArrayList<Stop> stops = new ArrayList<>();
        for (int i = 0; i < ncolors; i++) {
            stops.add(new Stop(i * delta, Color.color(vals[i][0], vals[i][1], vals[i][2], 1.0)));
        }
        return new ColorGradient("VIRIDIS", stops);
    }

    /**
     * Returns the gradient stops.
     *
     * @return list of stop colours
     * @see LinearGradient#getStops()
     */
    public List<Stop> getStops() {
        return stops;
    }

    @Override
    public String toString() {
        return name;
    }

}
