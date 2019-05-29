package cn.ddnd.huayun.web;

import cn.ddnd.huayun.web.pojo.CloudResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
//        String str = "{\"taskId\":\"yrg6r20190527215822441\",\"action\":\"DescribeInstances\",\"totalCount\":1,\"instanceSet\":[{\"Task\":\"NONE\",\"DueTime\":\"2019-07-09T20:29:34 +0800\",\"Memory\":1,\"ShutdownTime\":null,\"FirewallId\":\"f-6w6rj2mfk434m\",\"OsVersion\":\"6.9\",\"Cpu\":1,\"InstanceSeries\":\"SERIES_STANDARD\",\"BindStatus\":\"UNBIND\",\"Name\":\"cec1904093tcY\",\"Locked\":false,\"InterfaceSet\":[{\"Status\":\"ON_LINE\",\"NetworkName\":\"DEFAULT\",\"Type\":\"DEFAULT\",\"Uuid\":\"b857ffb7-60a5-4147-97af-e8b52203fc2a\",\"InstanceId\":\"i-zz6rj39kty724\",\"Bandwidth\":500,\"IpAddress\":\"10.10.10.4\",\"Id\":\"p-lw6rj39ktg141\",\"SubnetId\":\"s-ky6rj39ktj722\",\"EipType\":null,\"NetworkId\":\"n-nx6rj39kt9115\",\"MacAddress\":\"fa:16:3e:fe:34:e1\"}],\"SeriesName\":\"普通型\",\"ImageId\":\"t-nn6ri9hamk85n\",\"InitPassword\":\"yyER3nRsRL\",\"VolumeSet\":[{\"Type\":\"sata-vm\",\"Uuid\":\"4846705b-2e8b-444c-a2c9-1dc3b318786f\",\"DueTime\":\"2019-07-09T20:29:34 +0800\",\"CloseTime\":null,\"Size\":40,\"CreateTime\":\"2019-04-09T20:29:34 +0800\",\"ProductStatus\":\"NORMAL\",\"Index\":0,\"Id\":\"v-v36rj39kty95i\",\"ProductModelId\":116,\"PayType\":\"PREPAID\",\"Name\":\"cec1904093tcYsys\"},{\"Type\":\"sata-vm\",\"Uuid\":\"8eec2d27-e56d-4e39-98d0-abd3c4b87fe0\",\"DueTime\":\"2019-07-09T20:30:41 +0800\",\"CloseTime\":\"2019-07-09T21:30:41 +0800\",\"Size\":10,\"CreateTime\":\"2019-04-09T20:30:41 +0800\",\"ProductStatus\":\"NORMAL\",\"Index\":1,\"Id\":\"v-tn6rj39ku5543\",\"ProductModelId\":116,\"PayType\":\"PREPAID\",\"Name\":\"cec1904093tcYdata1\"}],\"HostName\":\"jsha-nova02\",\"Password\":\"yyER3nRsRL\",\"Status\":\"STOP\",\"IdLong\":\"i-zz6rj39kty724-d0e22836-f30b-4414-b7e5-e3d125787825\",\"KeyPairName\":null,\"KeyPair\":null,\"CreateTime\":\"2019-04-09T20:29:34 +0800\",\"OsName\":\"CentOS6.9\",\"OsBit\":\"32\",\"ProductType\":\"1核1G_SERIES_STANDARD\",\"ProductStatus\":\"NORMAL\",\"Host\":\"jsha-nova02\",\"PayType\":\"PREPAID\",\"ImageName\":\"CentOS\",\"Uuid\":\"d0e22836-f30b-4414-b7e5-e3d125787825\",\"CloseTime\":\"2019-07-09T21:29:34 +0800\",\"UserId\":\"18362985\",\"Id\":\"i-zz6rj39kty724\",\"ProductModelId\":\"122\",\"Internet\":[{\"DueTime\":\"2019-07-09T20:29:26 +0800\",\"MasterIpId\":null,\"ProductType\":\"ChinaTelecom\",\"ProductStatus\":\"NORMAL\",\"BandwidthInfo\":{\"DueTime\":1562675366000,\"ChangedTime\":null,\"IsCommonBandwidth\":0,\"AutoRenew\":null,\"CreateTime\":1539769310000,\"ProductType\":\"ChinaTelecom\",\"ProductStatus\":\"NORMAL\",\"PayType\":\"PREPAID\",\"IpGroupId\":null,\"Name\":null,\"CloseTime\":1562678966000,\"UserId\":\"18362985\",\"Bandwidth\":2,\"UpdateTime\":1554812992000,\"Id\":\"b-zb6rj39ktq15b\",\"ProductModelId\":413},\"PayType\":\"PREPAID\",\"Type\":\"MASTER\",\"AllocateTime\":\"2019-04-09T20:29:26 +0800\",\"CloseTime\":\"2019-07-09T21:29:26 +0800\",\"Bandwidth\":2,\"IpAddress\":\"103.36.192.209\",\"Id\":\"eip-zb6rj39ktq15b\",\"ProductModelId\":\"413\"}]}],\"instanceSnapshotId\":null,\"instanceSnapshotSet\":null,\"firewallId\":null,\"instanceVncUrl\":null,\"imageSet\":null,\"imageId\":null}";
//        String s = str.
    }

}
