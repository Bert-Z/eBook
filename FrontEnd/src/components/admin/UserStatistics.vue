<template>
  <div id="user statistics">
    <h5>User Statistics</h5>
    <Row style="text-align:left">
      <Col span="8"> 开始时间:
        <DatePicker type="date"  @on-change="changa" v-model="startTime" placeholder="请选择开始时间"></DatePicker>
      </Col>
      <Col span="8"> 结束时间:
        <DatePicker type="date"  @on-change="changa" v-model="endTime" placeholder="请选择结束时间"></DatePicker>
      </Col>
      <Col span="8"> 用户:
        <Select v-model="this.userorder" placeholder="Select the user" @on-change="changa">
            <Option v-for="item in users" :value="item.name">{{item.name}}</Option>
        </Select>
      </Col>
    </Row>
    <GChart
      type="ColumnChart"
      :data="filterData"
      :options="chartOptions"
    />
  </div>
</template>

<script>
  import {GChart} from "vue-google-charts";

  export default {
    name: "UserStatistics",
    components: {
      GChart
    },
    data() {
      return {
        startTime: "",
        endTime: "",
        users:[],
        userorder:"",
        // Array will be automatically processed with visualization.arrayToDataTable function
        chartData: [
          ["Year", "Sales", "Expenses", "Profit"],
          ["2014", 1000, 400, 200],
          ["2015", 1170, 460, 250],
          ["2016", 660, 1120, 300],
          ["2017", 1030, 540, 350]
        ],
        chartOptions: {
          chart: {
            title: "Company Performance",
            subtitle: "Sales, Expenses, and Profit: 2014-2017"
          }
        }
      };
    },
    methods: {
      changa(){
          console.log(this.userorder);
          // let starttime = this.startTime;
          // let endtime = this.endTime;
          // let orders=this.orders;

          // let ret;
          // if (starttime || endtime) {
          //   ret = orders.filter(function (item) {
          //     return Object.keys(item).some(function () {
          //       // console.log(new Date(item["createtime"]).getTime());
          //       return (new Date(item["createtime"]).getTime() >= new Date(starttime).getTime()) && (new Date(item["createtime"]).getTime() <= new Date(endtime).getTime()) ;
          //     })
          //   })
          // } else {
          //   ret = orders;
          // }

          // this.chartData=[];

          // var asd=new Array();
          // var sdf=new Array();
          // asd.push("year");
          // sdf.push(2019);
          // for(let i=0;i<ret.length;i++){
          //   asd.push(ret[i].booktitle);
          //   sdf.push(ret[i].booknum);
          // }
      },
      getAllUsers: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/admin/getAllUsers",
          emulateJSON: true
        }).then(
          function (response) {
            // console.log(response.data[1].booktitle);
            this.users=response.data;
            // console.log(this.users);
            
          }, function (error) {
            console.log(error);
          }
        )
      },
    },
    mounted() {
      this.getAllUsers();
      this.startTime = '';
      this.endTime = '';
    },
    computed: {
      filterData: {
        get:function() {
          
          let starttime = this.startTime;
          let endtime = this.endTime;
        //   let orders=this.user.userorders;
        //   let orders=[];

        //   let ret;
        //   if (starttime || endtime) {
        //     ret = orders.filter(function (item) {
        //       return Object.keys(item).some(function () {
        //         // console.log(new Date(item["createtime"]).getTime());
        //         return (new Date(item["createtime"]).getTime() >= new Date(starttime).getTime()) && (new Date(item["createtime"]).getTime() <= new Date(endtime).getTime()) ;
        //       })
        //     })
        //   } else {
        //     ret = orders;
        //   }

        //   this.chartData=[];

        //   var asd=new Array();
        //   var sdf=new Array();
        //   asd.push("begin-end");
        //   asd.push("Total Payment")
        //   sdf.push(starttime.toString()+'-'+endtime.toString());
        //   let totalfee=0;
        //   for(let i=0;i<ret.length;i++){
        //     totalfee+=ret[i].booknum*ret[i].bookfee;
        //   }
        //   sdf.push(bookfee);

          let hello=new Array();
        //   hello.push(asd);
        //   hello.push(sdf);
        
          return hello;

          // return items1;
        }
      }
    }
  }
</script>

<style scoped>

</style>
