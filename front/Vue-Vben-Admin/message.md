# Message 消息提示



## 引入  

```typescript
import { useMessage } from '/@/hooks/web/useMessage';
```

## 获取引用  
```typescript
const { createMessage } = useMessage();
```

## 简单使用  
```typescript
createMessage.success('成功提示');
createMessage.warn('warn提示');
createMessage.error('error提示');
createMessage.info('info提示');
```

## 其余参数
```typescript
content: JointContent  // 内容
duration?: ConfigDuration // 时间，输入秒数
onClose?: ConfigOnClose // 应该是关闭的时候执行的函数
```
