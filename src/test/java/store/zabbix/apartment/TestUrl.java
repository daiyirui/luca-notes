package store.zabbix.apartment;

import store.zabbix.apartment.util.HttpClientUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.*;

public class TestUrl {
    public static void main(String[] args) throws IOException {
        final Base64.Encoder encoder = Base64.getEncoder();
        int i = 20;
        while (i > 0) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    int qq = 10000 + j;
                    String text = "{\"u\":\"" + qq + "\",\"p\":\"nmsl+nmsl\"}";
                    byte[] textByte = text.getBytes(StandardCharsets.UTF_8);
                    String encodedText = encoder.encodeToString(textByte);
                    System.out.println("token=" + encodedText);
                    try {
                        System.out.println(HttpClientUtils.doGet("http://j07w.cn/user.php?token=" + encodedText));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            i--;
        }
    }

}

