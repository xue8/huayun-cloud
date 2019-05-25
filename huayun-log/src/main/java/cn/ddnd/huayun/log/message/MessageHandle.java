package cn.ddnd.huayun.log.message;

import java.util.Map;

public interface MessageHandle {
    Map handle(String msg, String typeName);
}
