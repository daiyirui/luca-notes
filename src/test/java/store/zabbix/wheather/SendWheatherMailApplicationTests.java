package store.zabbix.wheather;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import store.zabbix.wheather.model.MailBean;
import store.zabbix.wheather.service.MailService;
import store.zabbix.wheather.util.HttpClientUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendWheatherMailApplicationTests {
	private String [] to={"fuancui@gmail.com"};

	@Test
	public void contextLoads() throws IOException {
		System.out.println("执行了");
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

	@Resource
	private MailService mailService;
}
