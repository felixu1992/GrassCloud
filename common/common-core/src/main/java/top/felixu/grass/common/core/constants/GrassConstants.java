package top.felixu.grass.common.core.constants;

/**
 * 用于存储系统全局变量
 *
 * @author felixu
 * @date 2019.06.15
 */
public interface GrassConstants {

    /**
     * 扫描包
     */
    interface BasePackage {
        String NAME = "top.felixu.grass";
    }

    /**
     * 微服务名称
     */
    interface Server {
        String OAUTH = "oauth-server";
        String BASE = "base-server";
        String GATEWAY = "gateway-server";
        String CONFIG = "config-server";
    }
}
