```js
rules: [
        {
          validator: async (rule, value) => {
            if (value) {
              let phoneReg = new RegExp(
                /^1(3\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\d|9[0-35-9])\d{8}$/
              );
              if (!phoneReg.test(value)) {
                return Promise.reject('手机号不符合格式');
              }
              return Promise.resolve();
            }
          },
        },
      ],
```



