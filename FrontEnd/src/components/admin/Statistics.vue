<template>
  <div id="statistics">
    <h4 class="page-title">Statistics</h4>
    <br/>
    <h5>Book Statistics</h5>
    <Row style="text-align:left">
      <Col span="12"> 开始时间:
        <DatePicker type="date"  @on-change="changa" v-model="startTime" placeholder="请选择开始时间"></DatePicker>
      </Col>
      <Col span="12"> 结束时间:
        <DatePicker type="date"  @on-change="changa" v-model="endTime" placeholder="请选择结束时间"></DatePicker>
      </Col>
    </Row>
    <GChart
      type="ColumnChart"
      :data="filterData"
      :options="chartOptions"
    />

    <br/>
    <UserStatistics></UserStatistics>
  </div>
</template>

<script>
  import {GChart} from "vue-google-charts";
  import UserStatistics from "./UserStatistics";

  export default {
    name: "Statistics",
    components: {
      GChart,UserStatistics
    },
    data() {
      return {
        startTime: "",
        endTime: "",
        orders:[],
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
          
      },
      getAllOrders: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/admin/getAllOrders",
          emulateJSON: true
        }).then(
          function (response) {
            // console.log(response.data[1].booktitle);
            this.orders=response.data;
            
          }, function (error) {
            console.log(error);
          }
        )
      },
    },
    mounted() {
      this.getAllOrders();
      this.startTime = '';
      this.endTime = '';
    },
    computed: {
      filterData: {
        get:function() {
          
          let starttime = this.startTime;
          let endtime = this.endTime;
          let orders=this.orders;

          let ret;
          if (starttime || endtime) {
            ret = orders.filter(function (item) {
              return Object.keys(item).some(function () {
                // console.log(new Date(item["createtime"]).getTime());
                return (new Date(item["createtime"]).getTime() >= new Date(starttime).getTime()) && (new Date(item["createtime"]).getTime() <= new Date(endtime).getTime()) ;
              })
            })
          } else {
            ret = orders;
          }

          this.chartData=[];

          var asd=new Array();
          var sdf=new Array();
          asd.push("begin-end");
          sdf.push(starttime.toString()+'-'+endtime.toString());
          for(let i=0;i<ret.length;i++){
            asd.push(ret[i].booktitle);
            sdf.push(ret[i].booknum);
          }

          let hello=new Array();
          hello.push(asd);
          hello.push(sdf);
        
          return hello;

          // return items1;
        }
      }
    }
  }
</script>

<style scoped>

</style>
