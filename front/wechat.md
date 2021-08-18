```
WeChatWin.dll+1DDF534 // 昵称
WeChatWin.dll+1DDF568 // 手机号
WeChatWin.dll+1DDF698 // 微信号
WeChatWin.dll+1DDF988 // 机型
```
WeChatWin.dll+1DDF7FC

WeChat.exe 只执行一些简单的操作，如检查更新、校验 WeChatWin.dll，主要逻辑代码都在 WeChatWin.dll 中。

WeChatWin.dll 包含 WeChatPC 的绝大部分主题代码，一些重要的函数使用了 VMP 进行混淆 (较低版本中混淆了更多代码)

WeChatResource.dll 保存了 WeChat 的所有资源文件：图片、音效、XML 等，并使用了某种未知的方式进行压缩



板 U 套 i5 9400F + B360M 1300

显卡 1660 大将 1400

电源+机箱 350

M2 固态 240

蓝盘 200

风扇 120

内存条 500

 



7204F568-70270000

7204F699

<?xml version="1.0" encoding="utf-8"?>
<CheatTable>
  <CheatEntries>
    <CheatEntry>
      <ID>0</ID>
      <Description>"No description"</Description>
      <LastState RealAddress="7204F534"/>
      <VariableType>String</VariableType>
      <Length>9</Length>
      <Unicode>0</Unicode>
      <CodePage>0</CodePage>
      <ZeroTerminate>1</ZeroTerminate>

      <Address>WeChatWin.dll+1DDF534</Address>
​    </CheatEntry>
  </CheatEntries>
</CheatTable>



## **HOOK微信好友群列表.md**

https://github.com/nick-zheng/WX_PC_HOOK/blob/master/14%E3%80%81HOOK%E5%BE%AE%E4%BF%A1%E5%A5%BD%E5%8F%8B%E7%BE%A4%E5%88%97%E8%A1%A8.md

利用数据结构知识撸一下微信好友列表

https://bbs.pediy.com/thread-252649.htm

