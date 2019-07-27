package store.zabbix.apartment.task;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.zabbix.apartment.model.MailBean;
import store.zabbix.apartment.service.MailService;
import store.zabbix.apartment.util.HttpClientUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * description: 任务调度
 *
 * @author eyck.cui update: 2019-07-25 00:42
 **/
@Component
public class SendTask {
    private String [] to={"fuancui@gmail.com","zhang7980616@163.com"};

    @Autowired
    private MailService mailService;

    /**
     * 每天早上五点
     */
    // @Scheduled(cron = "${task.cron.weather}")
    public void task() throws IOException {
        MailBean mailBean = new MailBean();
        mailBean.setTo(to);
        mailBean.setSubject("小天气提醒");
        StringBuilder content= new StringBuilder();
        String jingan = HttpClientUtils.doGet("https://www.apiopen.top/weatherApi?city=静安区");
        Map jinganMap = JSON.parseObject(jingan, Map.class);
        Map dataMap = JSON.parseObject(jinganMap.get("data").toString(), Map.class);
        List<Map> jinganList = JSON.parseArray(dataMap.get("forecast").toString(),Map.class);
        content.append(
                "<html>\n"+
                        "<body>\n");
        boolean daisan = false;
        content.append("<table style='border:1px solid #666'>").append("<th><td content>日期</td><td content>最高温</td></th>");
        jinganList.forEach(val -> {
            content.append("<tr><td style='border:1px solid #666'>").append(val.get("date")).append("</td>").append("<td style='border:1px solid #666'>").append(val.get("high"))
                    .append("</td></tr>");
        });
        content.append("</table>");
        if(jinganList.get(0).get("type").toString().contains("雨")){
            content.append("<h4>今天有雨，请带伞</h4>");
        }
        String qingpu = HttpClientUtils.doGet("https://www.apiopen.top/weatherApi?city=青浦区");

        content.append(dataMap.get("ganmao")).append("</body>\n"+
                "</html>\n");
        mailBean.setContent(content);
        mailService.sendHtmlMessage(mailBean);

    }

    // @Scheduled(cron = "${task.cron.tradeData}")
    public void getTradeData() {
        System.out.println(System.currentTimeMillis());
    }
}
