package cn.ddnd.huayun.web;

import cn.ddnd.huayun.web.service.CheckIdentityService;
import cn.ddnd.huayun.web.service.CloudManageService;
import cn.ddnd.huayun.web.service.CloudService;
import cn.ddnd.huayun.web.service.impl.CloudManageServiceImpl;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDubbo
public class HuayunWebApplicationTests {

    @Autowired
    CloudService cloudService;
    @Autowired
    CloudManageService cloudManage;
    @Autowired
    CheckIdentityService checkIdentityService;
    @Autowired
    CloudManageService cloudManageService;
    @Autowired
    CloudManageServiceImpl service;

    @Test
    public void contextLoads() {
        String str = "{\n" +
                "    \"taskId\": \"7z36r20190528102001640\",\n" +
                "    \"action\": \"DescribeInstances\",\n" +
                "    \"totalCount\": 1,\n" +
                "    \"instanceSet\": [\n" +
                "        {\n" +
                "            \"Task\": \"NONE\",\n" +
                "            \"DueTime\": \"2019-07-09T20:29:34 +0800\",\n" +
                "            \"Memory\": 1,\n" +
                "            \"ShutdownTime\": null,\n" +
                "            \"FirewallId\": \"f-6w6rj2mfk434m\",\n" +
                "            \"OsVersion\": \"6.9\",\n" +
                "            \"Cpu\": 1,\n" +
                "            \"InstanceSeries\": \"SERIES_STANDARD\",\n" +
                "            \"BindStatus\": \"UNBIND\",\n" +
                "            \"Name\": \"cec1904093tcY\",\n" +
                "            \"Locked\": false,\n" +
                "            \"InterfaceSet\": [\n" +
                "                {\n" +
                "                    \"Status\": \"ON_LINE\",\n" +
                "                    \"NetworkName\": \"DEFAULT\",\n" +
                "                    \"Type\": \"DEFAULT\",\n" +
                "                    \"Uuid\": \"b857ffb7-60a5-4147-97af-e8b52203fc2a\",\n" +
                "                    \"InstanceId\": \"i-zz6rj39kty724\",\n" +
                "                    \"Bandwidth\": 500,\n" +
                "                    \"IpAddress\": \"10.10.10.4\",\n" +
                "                    \"Id\": \"p-lw6rj39ktg141\",\n" +
                "                    \"SubnetId\": \"s-ky6rj39ktj722\",\n" +
                "                    \"EipType\": null,\n" +
                "                    \"NetworkId\": \"n-nx6rj39kt9115\",\n" +
                "                    \"MacAddress\": \"fa:16:3e:fe:34:e1\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"SeriesName\": \"普通型\",\n" +
                "            \"ImageId\": \"t-nn6ri9hamk85n\",\n" +
                "            \"InitPassword\": \"yyER3nRsRL\",\n" +
                "            \"VolumeSet\": [\n" +
                "                {\n" +
                "                    \"Type\": \"sata-vm\",\n" +
                "                    \"Uuid\": \"4846705b-2e8b-444c-a2c9-1dc3b318786f\",\n" +
                "                    \"DueTime\": \"2019-07-09T20:29:34 +0800\",\n" +
                "                    \"CloseTime\": null,\n" +
                "                    \"Size\": 40,\n" +
                "                    \"CreateTime\": \"2019-04-09T20:29:34 +0800\",\n" +
                "                    \"ProductStatus\": \"NORMAL\",\n" +
                "                    \"Index\": 0,\n" +
                "                    \"Id\": \"v-v36rj39kty95i\",\n" +
                "                    \"ProductModelId\": 116,\n" +
                "                    \"PayType\": \"PREPAID\",\n" +
                "                    \"Name\": \"cec1904093tcYsys\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Type\": \"sata-vm\",\n" +
                "                    \"Uuid\": \"8eec2d27-e56d-4e39-98d0-abd3c4b87fe0\",\n" +
                "                    \"DueTime\": \"2019-07-09T20:30:41 +0800\",\n" +
                "                    \"CloseTime\": \"2019-07-09T21:30:41 +0800\",\n" +
                "                    \"Size\": 10,\n" +
                "                    \"CreateTime\": \"2019-04-09T20:30:41 +0800\",\n" +
                "                    \"ProductStatus\": \"NORMAL\",\n" +
                "                    \"Index\": 1,\n" +
                "                    \"Id\": \"v-tn6rj39ku5543\",\n" +
                "                    \"ProductModelId\": 116,\n" +
                "                    \"PayType\": \"PREPAID\",\n" +
                "                    \"Name\": \"cec1904093tcYdata1\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"HostName\": \"jsha-nova02\",\n" +
                "            \"Password\": \"yyER3nRsRL\",\n" +
                "            \"Status\": \"STOP\",\n" +
                "            \"IdLong\": \"i-zz6rj39kty724-d0e22836-f30b-4414-b7e5-e3d125787825\",\n" +
                "            \"KeyPairName\": null,\n" +
                "            \"KeyPair\": null,\n" +
                "            \"CreateTime\": \"2019-04-09T20:29:34 +0800\",\n" +
                "            \"OsName\": \"CentOS6.9\",\n" +
                "            \"OsBit\": \"32\",\n" +
                "            \"ProductType\": \"1核1G_SERIES_STANDARD\",\n" +
                "            \"ProductStatus\": \"NORMAL\",\n" +
                "            \"Host\": \"jsha-nova02\",\n" +
                "            \"PayType\": \"PREPAID\",\n" +
                "            \"ImageName\": \"CentOS\",\n" +
                "            \"Uuid\": \"d0e22836-f30b-4414-b7e5-e3d125787825\",\n" +
                "            \"CloseTime\": \"2019-07-09T21:29:34 +0800\",\n" +
                "            \"UserId\": \"18362985\",\n" +
                "            \"Id\": \"i-zz6rj39kty724\",\n" +
                "            \"ProductModelId\": \"122\",\n" +
                "            \"Internet\": [\n" +
                "                {\n" +
                "                    \"DueTime\": \"2019-07-09T20:29:26 +0800\",\n" +
                "                    \"MasterIpId\": null,\n" +
                "                    \"ProductType\": \"ChinaTelecom\",\n" +
                "                    \"ProductStatus\": \"NORMAL\",\n" +
                "                    \"BandwidthInfo\": {\n" +
                "                        \"DueTime\": 1562675366000,\n" +
                "                        \"ChangedTime\": null,\n" +
                "                        \"IsCommonBandwidth\": 0,\n" +
                "                        \"AutoRenew\": null,\n" +
                "                        \"CreateTime\": 1539769310000,\n" +
                "                        \"ProductType\": \"ChinaTelecom\",\n" +
                "                        \"ProductStatus\": \"NORMAL\",\n" +
                "                        \"PayType\": \"PREPAID\",\n" +
                "                        \"IpGroupId\": null,\n" +
                "                        \"Name\": null,\n" +
                "                        \"CloseTime\": 1562678966000,\n" +
                "                        \"UserId\": \"18362985\",\n" +
                "                        \"Bandwidth\": 2,\n" +
                "                        \"UpdateTime\": 1554812992000,\n" +
                "                        \"Id\": \"b-zb6rj39ktq15b\",\n" +
                "                        \"ProductModelId\": 413\n" +
                "                    },\n" +
                "                    \"PayType\": \"PREPAID\",\n" +
                "                    \"Type\": \"MASTER\",\n" +
                "                    \"AllocateTime\": \"2019-04-09T20:29:26 +0800\",\n" +
                "                    \"CloseTime\": \"2019-07-09T21:29:26 +0800\",\n" +
                "                    \"Bandwidth\": 2,\n" +
                "                    \"IpAddress\": \"103.36.192.209\",\n" +
                "                    \"Id\": \"eip-zb6rj39ktq15b\",\n" +
                "                    \"ProductModelId\": \"413\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"instanceSnapshotId\": null,\n" +
                "    \"instanceSnapshotSet\": null,\n" +
                "    \"firewallId\": null,\n" +
                "    \"instanceVncUrl\": null,\n" +
                "    \"imageSet\": null,\n" +
                "    \"imageId\": null\n" +
                "}";
        Map map = (Map) JSON.parse(str);


        checkIdentityService.check("36c34ff3094b4dec9786dcc35d1f0d41", "b87e24ad3b00420fadec14a9260ca94e");
//        service.queryCloud("36c34ff3094b4dec9786dcc35d1f0d41", "b87e24ad3b00420fadec14a9260ca94e", "cn-huaian");

        //        cloudManage.queryCloud();
    }


}
