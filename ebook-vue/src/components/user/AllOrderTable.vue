<template>
  <div class="allordertable">
    <Card>
      <label>All Orders</label>
      <Row>
        <Col span="12"> 开始时间:
          <DatePicker type="date" v-model="startTime" @on-change="changa" placeholder="请选择开始时间"></DatePicker>
        </Col>
        <Col span="12"> 结束时间:
          <DatePicker type="date" v-model="endTime" @on-change="changa" placeholder="请选择结束时间"></DatePicker>
        </Col>
      </Row>
      <br/>
      <Table border :columns="columns" :data="filterdata"></Table>
    </Card>
  </div>
</template>

<script>
  import {getCookie} from '../../util/util'

  export default {
    name: "AllOrderTable",
    data: function () {
      return {
        startTime: "",
        endTime: "",
        columns: [
          {
            title:"OrderID",
            key:"orderid",
            sortable: true
          },
          {
            title: 'Book',
            key: 'booktitle',
            sortable: true
          },
          {
            title: 'BuyNum',
            key: 'booknum',
            sortable: true
          },
          {
            title:"Unit Price",
            key:"bookfee",
            sortable: true
          },
          {
            title: 'Time',
            key: 'createtime',
            sortable: true
          }
        ],
        data: []
      }
    },
    computed: {
      filterdata: {
        get: function () {
          let starttime = this.startTime;
          let endtime = this.endTime;
          let ret;
          if (starttime || endtime) {
            ret = this.data.filter(function (item) {
              return Object.keys(item).some(function () {
                // console.log(new Date(item["createtime"]).getTime());
                return (new Date(item["createtime"]).getTime() >= new Date(starttime).getTime()) && (new Date(item["createtime"]).getTime() <= new Date(endtime).getTime()) ;
              })
            })
          } else {
            ret = this.data;
          }
          return ret;
        }
      }
    },
    methods: {
      changa() {
        // console.log(new Date(this.startTime).getTime());
        // console.log(this.endTime);
      },
      getAllOrders() {
        this.$http({
          method: 'GET',
          url: 'http://localhost:8080/api/getAllOrders?username=' + getCookie('name'),
          emulateJSON: true
        }).then(
          function (response) {
            let info = response.data;
            console.log(info);
            for (let i in info) {
              let item = {
                orderid: info[i].orderid,
                booktitle: info[i].booktitle,
                booknum: info[i].booknum,
                bookfee:info[i].bookfee,
                createtime: info[i].updatetime
              };
              this.data.push(item);
            }
          }, function (error) {
            console.log(error);
          })
      },
      show(index) {
        this.$Modal.info({
          title: 'User Info',
          content: `Name：${this.data[index].name}<br>Age：${this.data[index].age}<br>Address：${this.data[index].address}`
        })
      },
      // onStartTimeChange:function(startTime) {
      //   this.endTimeOption = {
      //     disabledDate(endTime) {
      //       return endTime < new Date(startTime) || endTime > Date.now()
      //     }
      //   }
      // },
      // onEndTimeChange:function(endTime) {
      //   this.startTimeOption = {
      //     disabledDate(startTime) {
      //       return startTime > new Date(endTime) || startTime > Date.now()
      //     }
      //   }
      // }
    },
    created() {
      this.getAllOrders();
    },
    mounted() {
      this.startTime = '';
      this.endTime = '';
      // this.onStartTimeChange(this.startTime);
      // this.onEndTimeChange(this.endTime);
    },
  }
</script>

<style scoped>

</style>
