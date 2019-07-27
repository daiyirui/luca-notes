import request from '@/plugin/axios'

export function CustomerAdd(data) {
  return request({
    url: 'customer/add',
    method: 'post',
    data
  })
}
