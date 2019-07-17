package store.zabbix.wheather.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MailBean implements Serializable {
    private  String [] to;
    private  List<String> cc;
    private  String from;
    private  String subject;
    private  StringBuilder content;
    private  List<String> attachmentPath;
    private  String imagePath;
    private  String rscId;
}
