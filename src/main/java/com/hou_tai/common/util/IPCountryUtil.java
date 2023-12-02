package com.hou_tai.common.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: GaoLu
 * @Date: 2023-10-31 15:02
 * @Description: 根据IP获取国家地址
 */
@Slf4j
@Component
public class IPCountryUtil {
    @Value("${lanBo.ipv4.path}")
    private String IP4_PATH;

//    @PostConstruct
//    public void getIp() throws IOException {
//        //读取ip.csv文件，创建 KEY:ip,VALUE:语言ID 缓存
//        init();
//    }
    private static final HashMap<Long, Integer> maxIpMap = new HashMap<>();
    private static final String UNKNOWN = "unknown";
    private static final String LOCAL_IP_PROMPT = "本地循环地址";
    private static final String PRIVATE_IP_PROMPT = "私有地址";

    private static final String[] LOCAL_IPS = {"127.0.0.1", "0.0.0.0", "localhost"};

    private static final String PRIVATE_IP_REGEX = "^(10\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})|(172\\.((1[6-9])|(2\\d)|(3[01]))\\.\\d{1,3}\\.\\d{1,3})|(192\\.168\\.\\d{1,3}\\.\\d{1,3})$";

    private static final Pattern PRIVATE_IP_PATTERN = Pattern.compile(PRIVATE_IP_REGEX);

    private static Long[] maxIps;

    public static void main(String[] args) throws IOException {
//        IPCountryUtil ipCountryUtil=new IPCountryUtil();
//        ipCountryUtil.init();
        String[] ips = {
                "1.21.255.255",
                "112.169.175.14",
                "13.114.244.69", " 192.168.0.117", "LOCALHOST", "192.168.33.174", "10.2.2.2", "172.17.3.3"
        };
        for (String ip : ips) {
            System.out.println(ipToCountry(ip));
        }
    }

    public static Integer ipToCountry(String ip) {
        log.info("===========================访问源ip: " + ip + "=============================");
        if (isLocalIp(ip)) {
            return 1;
        }
        if (isPrivateIp(ip)) {
            return 1;
        }
        long ipNum = ipToNum(ip);
        Long bound = null;
        log.info("===========================ipNum: " + ipNum + "=============================");
        if (maxIps != null && maxIps.length > 0) {
            for (int i = 0; i < maxIps.length; i++) {
                if (maxIps[i] >= ipNum) {
                    bound = maxIps[i];
                    break;
                }
            }
        }
        if (bound == null) {
            return 1;
        }
        return maxIpMap.getOrDefault(bound, 1);
    }

    public static boolean isPrivateIp(String ip) {
        Matcher matcher = PRIVATE_IP_PATTERN.matcher(ip);
        return matcher.find();
    }

    public static boolean isLocalIp(String ip) {
        for (String localIp : LOCAL_IPS) {
            if (localIp.equalsIgnoreCase(ip)) {
                return true;
            }
        }
        return false;
    }

    public static long ipToNum(String ip) {
        String[] parts = ip.split("\\.");
        assert parts.length == 4;
        return (Long.parseLong(parts[0]) << 24) + (Long.parseLong(parts[1]) << 16) + (Long.parseLong(parts[2]) << 8) + Long.parseLong(parts[3]);
    }

    /**
     * 初始化IP缓存
     */
    private void init() throws IOException {
        log.info("进入IP初始化》》》》》》》"+IP4_PATH);
        //Path path = Paths.get("src\\main\\resources\\others\\ip4.csv");
        Path path = Paths.get(IP4_PATH);
        List<String> lines = Files.readAllLines(path);
        LinkedList<Long> maxIpList = new LinkedList<>();
        for (String line : lines) {
            String[] split = line.split(",");
            if (split.length != 3) {
                continue;
            }
            String country = split[0];
//            String start = split[1];//开始ip
            String end = split[2];//结束ip
            long endIp = ipToNum(end);
            maxIpList.add(endIp);
            maxIpMap.put(endIp, map.getOrDefault(country, 1));
        }
        maxIps = new Long[maxIpList.size()];
        maxIpList.toArray(maxIps);
        Arrays.sort(maxIps);
        log.info("IP初始化成功》》》》》》》共{}条记录", maxIps.length);
    }

    private static final HashMap<String, Integer> map = new HashMap<>();

    static {
        map.put("BR", 2);  //巴西（葡萄牙语）
//        map.put("IN", 3);  //印度
        map.put("KR", 6);  //韩国
        map.put("JP", 5);  //日本
        //map.put("ES", "西班牙");
        /*
       map.put("AD","安道尔共和国");
        map.put("AE","阿拉伯联合酋长国");
        map.put("AF","阿富汗");
        map.put("AG","安提瓜和巴布达");
        map.put("AI","安圭拉岛");
        map.put("AL","阿尔巴尼亚");
        map.put("AM","亚美尼亚");
        map.put("AO","安哥拉");
        map.put("AR","阿根廷");
        map.put("AT","奥地利");
        map.put("AU","澳大利亚");
        map.put("AZ","阿塞拜疆");
        map.put("BB","巴巴多斯");
        map.put("BD","孟加拉国");
        map.put("BE","比利时");
        map.put("BF","布基纳法索");
        map.put("BG","保加利亚");
        map.put("BH","巴林");
        map.put("BI","布隆迪");
        map.put("BJ","贝宁");
        map.put("BL","巴勒斯坦");
        map.put("BM","百慕大群岛");
        map.put("BN","文莱");
        map.put("BO","玻利维亚");

        map.put("BS","巴哈马");
        map.put("BW","博茨瓦纳");
        map.put("BY","白俄罗斯");
        map.put("BZ","伯利兹");
        map.put("CA","加拿大");
        map.put("CF","中非共和国");
        map.put("CG","刚果");
        map.put("CH","瑞士");
        map.put("CK","库克群岛");
        map.put("CL","智利");
        map.put("CM","喀麦隆");
        map.put("CN","中国");
        map.put("CO","哥伦比亚");
        map.put("CR","哥斯达黎加");
        map.put("CS","捷克");
        map.put("CU","古巴");
        map.put("CY","塞浦路斯");
        map.put("CZ","捷克");
        map.put("DE","德国");
        map.put("DJ","吉布提");
        map.put("DK","丹麦");
        map.put("DO","多米尼加共和国");
        map.put("DZ","阿尔及利亚");
        map.put("EC","厄瓜多尔");
        map.put("EE","爱沙尼亚");
        map.put("EG","埃及");

        map.put("ET","埃塞俄比亚");
        map.put("FI","芬兰");
        map.put("FJ","斐济");
        map.put("FR","法国");
        map.put("GA","加蓬");
        map.put("GB","英国");
        map.put("GD","格林纳达");
        map.put("GE","格鲁吉亚");
        map.put("GF","法属圭亚那");
        map.put("GH","加纳");
        map.put("GI","直布罗陀");
        map.put("GM","冈比亚");
        map.put("GN","几内亚");
        map.put("GR","希腊");
        map.put("GT","危地马拉");
        map.put("GU","关岛");
        map.put("GY","圭亚那");
        map.put("HK","中国香港特别行政区");
        map.put("HN","洪都拉斯");
        map.put("HT","海地");
        map.put("HU","匈牙利");

        map.put("IE","爱尔兰");
        map.put("IL","以色列");

        map.put("IQ","伊拉克");
        map.put("IR","伊朗");
        map.put("IS","冰岛");
        map.put("IT","意大利");
        map.put("JM","牙买加");
        map.put("JO","约旦");
        map.put("JP","日本");
        map.put("KE","肯尼亚");
        map.put("KG","吉尔吉斯坦");
        map.put("KH","柬埔寨");
        map.put("KP","朝鲜");

        map.put("KT","科特迪瓦共和国");
        map.put("KW","科威特");
        map.put("KZ","哈萨克斯坦");
        map.put("LA","老挝");
        map.put("LB","黎巴嫩");
        map.put("LC","圣卢西亚");
        map.put("LI","列支敦士登");
        map.put("LK","斯里兰卡");
        map.put("LR","利比里亚");
        map.put("LS","莱索托");
        map.put("LT","立陶宛");
        map.put("LU","卢森堡");
        map.put("LV","拉脱维亚");
        map.put("LY","利比亚");
        map.put("MA","摩洛哥");
        map.put("MC","摩纳哥");
        map.put("MD","摩尔多瓦");
        map.put("MG","马达加斯加");
        map.put("ML","马里");
        map.put("MM","缅甸");
        map.put("MN","蒙古");
        map.put("MO","中国澳门特别行政区");
        map.put("MS","蒙特塞拉特岛");
        map.put("MT","马耳他");
        map.put("MU","毛里求斯");
        map.put("MV","马尔代夫");
        map.put("MW","马拉维");
        map.put("MX","墨西哥");
        map.put("MY","马来西亚");
        map.put("MZ","莫桑比克");
        map.put("NA","纳米比亚");
        map.put("NE","尼日尔");
        map.put("NG","尼日利亚");
        map.put("NI","尼加拉瓜");
        map.put("NL","荷兰");
        map.put("NO","挪威");
        map.put("NP","尼泊尔");
        map.put("NR","瑙鲁");
        map.put("NZ","新西兰");
        map.put("OM","阿曼");
        map.put("PA","巴拿马");
        map.put("PE","秘鲁");
        map.put("PF","法属玻利尼西亚");
        map.put("PG","巴布亚新几内亚");
        map.put("PH","菲律宾");
        map.put("PK","巴基斯坦");
        map.put("PL","波兰");
        map.put("PR","波多黎各");
        map.put("PT","葡萄牙");
        map.put("PY","巴拉圭");
        map.put("QA","卡塔尔");
        map.put("RO","罗马尼亚");
        map.put("RU","俄罗斯");
        map.put("SA","沙特阿拉伯");
        map.put("SB","所罗门群岛");
        map.put("SC","塞舌尔");
        map.put("SD","苏丹");
        map.put("SE","瑞典");
        map.put("SG","新加坡");
        map.put("SI","斯洛文尼亚");
        map.put("SK","斯洛伐克");
        map.put("SL","塞拉利昂");
        map.put("SM","圣马力诺");
        map.put("SN","塞内加尔");
        map.put("SO","索马里");
        map.put("SR","苏里南");
        map.put("ST","圣多美和普林西比");
        map.put("SV","萨尔瓦多");
        map.put("SY","叙利亚");
        map.put("SZ","斯威士兰");
        map.put("TD","乍得");
        map.put("TG","多哥");
        map.put("TH","泰国");
        map.put("TJ","塔吉克斯坦");
        map.put("TM","土库曼斯坦");
        map.put("TN","突尼斯");
        map.put("TO","汤加");
        map.put("TR","土耳其");
        map.put("TT","特立尼达和多巴哥");
        map.put("TW","中国台湾省");
        map.put("TZ","坦桑尼亚");
        map.put("UA","乌克兰");
        map.put("UG","乌干达");
        map.put("US","美国");
        map.put("UY","乌拉圭");
        map.put("UZ","乌兹别克斯坦");
        map.put("VC","圣文森特岛");
        map.put("VE","委内瑞拉");
        map.put("VN","越南");
        map.put("YE","也门");
        map.put("YU","南斯拉夫");
        map.put("ZA","南非");
        map.put("ZM","赞比亚");
        map.put("ZR","扎伊尔");
        map.put("ZW","津巴布韦");*/
//        map.put("","阿森松");
//        map.put("","开曼群岛");
//        map.put("","科特迪瓦");
//        map.put("","马里亚那群岛");
//        map.put("","马提尼克");
//        map.put("","荷属安的列斯");
//        map.put("","留尼旺");
//        map.put("","东萨摩亚(美)");
//        map.put("","西萨摩亚");
    }
}
