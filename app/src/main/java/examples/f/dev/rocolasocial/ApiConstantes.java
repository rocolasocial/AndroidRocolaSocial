package examples.f.dev.rocolasocial;

/**
 * Created by Salvador on 07/08/2015.
 */
public class ApiConstantes {

    public static final String URL_BASE = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_KEY = "api_key";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";

    public static final String VALUE_TOP_TRACKS = "chart.gettoptracks";
    public static final String VALUE_JSON = "json";

    //@GET("http://ws.audioscrobbler.com/?method=chart.gettoptracks&api_key=123ae7ccee87798c55c82b64c792a083&format=json")
    public static  final String URL_TOP_TRACKS = PATH_VERSION + "?" + PARAM_METHOD + "=" + VALUE_TOP_TRACKS
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON;


}
