<template>
  <d2-container>
    <div>
      <d2-crud
        ref="d2Crud"
        :columns="columns"
        :data="data"
        :loading="loading"
        :pagination="pagination"
        @pagination-current-change="paginationCurrentChange"
      />
    </div>
  </d2-container>
</template>

<script>
// import { BusinessTable1List } from '@api/demo.business.table.1'
export default {
  data() {
    return {
      columns: [
        {
          title: '卡密',
          key: 'key',
          width: 320
        },
        {
          title: '面值',
          key: 'value'
        },
        {
          title: '管理员',
          key: 'admin'
        },
        {
          title: '创建时间',
          key: 'dateTimeCreat'
        },
        {
          title: '使用时间',
          key: 'dateTimeUse'
        }
      ],
      data: [],
      loading: false,
      pagination: {
        currentPage: 1,
        pageSize: 5,
        total: 0
      }
      // BusinessTable1List: {
      //   currentPage: 1,
      //   pageSize: 10,
      //   pageCount: 7,
      //   pageSizes: [10, 20, 30, 40, 50, 100],
      //   list: [
      //     {
      //       key: "Ff912b1b-f42D-fEAf-c885-b52042CBcc69",
      //       value: "100"
      //     }
      //   ],
      //   total: 1
      // }
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    paginationCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.fetchData()
    },
    fetchData() {
      this.loading = true
      // this.BusinessTable1List({
      //   ...this.pagination
      // })
      //   .then(res => {
      //     this.data = res.list
      //     this.pagination.total = res.page.total
      //     this.loading = false
      //   })
      //   .catch(err => {
      //     console.log("err", err)
      //     this.loading = false
      //   })
      this.data = {
        page: {
          total: 1000
        },
        list: {
          key: '@guid',
          value: '222',
          type: '@boolean',
          admin: '@cname',
          adminNote: '@cparagraph(0.5)',
          dateTimeCreat: '@datetime',
          used: '@boolean',
          dateTimeUse: '@datetime'
        }
      }
      this.loading = false
    }
  }
}
</script>
