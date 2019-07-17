package store.zabbix.wheather.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import store.zabbix.wheather.model.MailBean;
import store.zabbix.wheather.service.MailService;
import store.zabbix.wheather.util.HttpClientUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class SendController {


}
