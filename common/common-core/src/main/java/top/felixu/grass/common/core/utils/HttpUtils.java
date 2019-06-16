package top.felixu.grass.common.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.felixu.grass.common.core.exception.ErrorCode;
import top.felixu.grass.common.core.exception.GrassException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 请求过程中相关操作工具类
 *
 * @author felixu
 * @date 2019.06.16
 */
public class HttpUtils {

    private static ServletRequestAttributes getRequestAttributes() {
        return Optional.ofNullable((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .orElseThrow(() -> new GrassException(ErrorCode.FAIL, "ServletRequestAttributes Is Null"));
    }

    /**
     * 尝试获取当前请求的HttpServletRequest实例
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getHttpServletRequest() {
        try {
            return getRequestAttributes().getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 创建一个可能为空的Optional对象
     * 即传入对象可能为getHttpServletRequest返回值可能为null
     *
     * @return Optional
     */
    private static Optional<HttpServletRequest> getHttpServletRequestOptional() {
        return Optional.ofNullable(getHttpServletRequest());
    }

    /**
     * 尝试获取当前请求的HttpServletResponse实例
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getHttpServletResponse() {
        try {
            return getRequestAttributes().getResponse();
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 解析请求头为map
     *
     * @param request request
     * @return headers
     */
    public static Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    /**
     * 解析请求头为map
     *
     * @return headers
     */
    public static Map<String, String> getHeaders() {
        return getHttpServletRequestOptional().map(HttpUtils::getHeaders).orElse(new HashMap<>());
    }

    /**
     * 解析参数列表为map
     *
     * @param request request
     * @return params
     */
    public static Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String> param = new LinkedHashMap<>();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] varr = entry.getValue();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < varr.length; i++) {
                String var = varr[i];
                if (i != 0){
                    builder.append(",");
                }
                builder.append(var);
            }
            param.put(key, builder.toString());
        }
        return param;
    }

    /**
     * 解析请求参数列表为map
     *
     * @return params
     */
    public static Map<String, String> getParams() {
        return getHttpServletRequestOptional().map(HttpUtils::getParams).orElse(new HashMap<>());
    }

    /**
     * 获取客户端真实ip
     * @param request request
     * @return ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String s : ips) {
                if (!("unknown".equalsIgnoreCase(s))) {
                    ip = s;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 获取客户端真实ip
     *
     * @return ip
     */
    public static String getIpAddress() {
        return getHttpServletRequestOptional().map(HttpUtils::getIpAddress).orElse("");
    }

    /**
     * web应用绝对路径
     *
     * @param request request
     * @return path
     */
    public static String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

    /**
     * web应用绝对路径
     *
     * @return path
     */
    public static String getBasePath() {
        return getHttpServletRequestOptional().map(HttpUtils::getBasePath).orElse("");
    }
}
