package cn.ddnd.huayun.web.service.impl.monitor;

import cn.ddnd.huayun.web.request.MonitorRequest;
import cn.ddnd.huayun.web.service.CreateCloudMonitorService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreateCloudMonitorServiceImpl implements CreateCloudMonitorService {

    @Autowired
    OkHttpClient okHttpClient;

    @Override
    public boolean createOnlyOnce(MonitorRequest request) throws Exception{
        Request req = new Request.Builder()
                .url(request.getUrl())
                .get()
                .build();

        try {
            Response response = okHttpClient.newCall(req).execute();
            String var1 = response.body().string();
            if (var1.contains("\"found\":true") || var1.contains("\"found\": true"))
                throw new Exception("monitor name is exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, request.getRequest());
        Request request1 = new Request.Builder()
                .put(requestBody)
                .url(request.getUrl())
                .build();
        Response response = okHttpClient.newCall(request1).execute();
        String var2 = response.body().string();
        if (var2.contains("\"created\":true") || var2.contains("\"created\": true"))
            return true;
        return false;
    }

    @Override
    public boolean createAlways(MonitorRequest request) {
        return false;
    }

    @Override
    public boolean createAverage(MonitorRequest request) {
        return false;
    }
}
