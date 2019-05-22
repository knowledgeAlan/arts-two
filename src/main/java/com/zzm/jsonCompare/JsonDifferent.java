package com.zzm.jsonCompare;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description 对象比较差别
 * @encoding UTF-8
 * @date 2019/5/22
 * @time 23:02
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class JsonDifferent {
    public static void main(String[] args)  throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        User beforeUser = new User();
        beforeUser.setId(1);
        beforeUser.setName("张三");

        User afterUser = new User();
        afterUser.setId(2);
        afterUser.setName("李四");
        JsonNode beforeFinancialNode = objectMapper.readTree(JSON.toJSONString(beforeUser));
        JsonNode afterFinancialNode = objectMapper.readTree(JSON.toJSONString(afterUser));


        JsonNode patchFinancialNode = JsonDiff.asJson(beforeFinancialNode, afterFinancialNode);

        System.out.println(patchFinancialNode);

        for (JsonNode jsonNode :
                patchFinancialNode) {
            JsonNode path = jsonNode.path("path");
            //不通知path
            String finalPath = path.asText().replace("/", "");
            //获取不同值
            String diffValue = jsonNode.findValue("value").asText();

            System.out.println("path:"+finalPath);
            System.out.println("value:"+diffValue);

        }

    }
}
