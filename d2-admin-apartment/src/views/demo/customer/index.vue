<template>
  <d2-container>
    <el-row>
      <el-col :span='17'>
        <el-form
          ref='user'
          :model='user'
          label-width='100px'
        >
          <el-form-item label='租客姓名'>
            <el-input v-model='user.name'></el-input>
          </el-form-item>
          <el-form-item label='租客手机号'>
            <el-input v-model='user.phone'></el-input>
          </el-form-item>
          <el-form-item label='租房地址'>
            <el-input v-model='user.address'></el-input>
          </el-form-item>
          <el-form-item label='租赁日期'>
            <el-date-picker
              v-model='user.startTime'
              type='date'
              placeholder='选择日期'
            ></el-date-picker>
          </el-form-item>
          <el-form-item label='租期'>
            <el-col :span='12'>
              <el-select
                v-model='user.times'
                placeholder='请选择'
              >
                <el-option
                  v-for='item in 36'
                  :key='item'
                  :label='item'
                  :value='item'
                ></el-option>
              </el-select>
              <span style='margin-left:10px'>月</span>
            </el-col>
          </el-form-item>

          <el-form-item label='最后交租日期'>
            <el-date-picker
              v-model='user.updateTime'
              type='date'
              placeholder='选择日期'
            ></el-date-picker>
          </el-form-item>
          <el-form-item label='交租间隔'>
            <el-col :span='12'>
              <el-select
                v-model='user.speator'
                placeholder='请选择'
              >
                <el-option
                  v-for='item in 36'
                  :key='item'
                  :label='item'
                  :value='item'
                ></el-option>
              </el-select>
              <span style='margin-left:10px'>月</span>
            </el-col>
          </el-form-item>
          <el-form-item label='支付方式'>
            <el-checkbox-group v-model='user.type'>
              <el-checkbox
                label='微信'
                name='type'
              ></el-checkbox>
              <el-checkbox
                label='支付宝'
                name='type'
              ></el-checkbox>
              <el-checkbox
                label='银行卡转账'
                name='type'
              ></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label='备注'>
            <el-input
              type='textarea'
              v-model='user.remark'
              placeholder='可以在此输入备注'
            ></el-input>
          </el-form-item>
          <el-form-item label='在租状态'>
            <el-switch v-model='user.roomStatus'></el-switch>
          </el-form-item>
          <el-form-item>
            <el-button
              type='primary'
              @click='onSubmit'
            >立即创建</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </d2-container>
</template>

<script>
import { CustomerAdd } from '@/api/customer/customer.add'

export default {
  data() {
    return {
      user: {
        name: '张三',
        phone: '17521300175',
        startTime: new Date(),
        times: 12,
        remark: '',
        updateTime: new Date(),
        roomStatus: true,
        speator: 3,
        type: ['微信', '支付宝'],
        address: '上海市青浦区赵巷镇秀沁路238弄'
      },
      options: [
        {
          value: '1',
          label: '一个月'
        },
        {
          value: '2',
          label: '二个月'
        },
        {
          value: '3',
          label: '三个月'
        },
        {
          value: '4',
          label: '四个月'
        },
        {
          value: '选项5',
          label: '北京烤鸭'
        }
      ],
      value: ''
    }
  },
  methods: {
    onSubmit() {
      let params = JSON.parse(JSON.stringify(this.user))
      params.startTime = parseInt(new Date(params.startTime).getTime() / 1000)
      params.updateTime = parseInt(new Date(params.updateTime).getTime() / 1000)
      CustomerAdd(params)
        .then(res => {
          console.log(res)
          // 返回数据
        })
        .catch(err => {
          // 异常情况
          console.log(err)
        })
    }
  }
}
</script>
