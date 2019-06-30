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
      <Col span="8">
        <Select v-model="userindex" placeholder="Select the user" @on-change="changa">
            <Option v-for="(item,index) in users" :key="index" :value="index">{{item.name}}</Option>
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
        userindex:null,
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
          // console.log(this.userindex);
          // console.log(this.users[this.userindex]);
          
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
          let orders=[];
          if(this.userindex!==null){
            orders=this.users[this.userindex].userorders;
          }
          
        //   let orders=[];

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

          // console.log(typeof(ret));

          let axio_display=new Array();
          let axio_data=new Array();
          axio_display.push("begin-end");
          axio_display.push("Total Payment");
          axio_data.push(starttime.toString()+'-'+endtime.toString());
          let totalfee=0;
          
          // if(ret[1]!==undefined){
          //   console.log(JSON.parse(JSON.stringify(ret[1])).booknum);
          // }

          for(let i=0;i<ret.length;i++){
            if(ret[i]!==undefined){
              totalfee+=JSON.parse(JSON.stringify(ret[i])).booknum*JSON.parse(JSON.stringify(ret[i])).bookfee;
            }
          }
          axio_data.push(totalfee);
          

        //   var asd=new Array();
        //   var sdf=new Array();
        //   asd.push("begin-end");
        //   asd.push("Total Payment")
        //   sdf.push(starttime.toString()+'-'+endtime.toString());
        //   let totalfee=0;
          // for(let i=0;i<ret.length;i++){
          //   totalfee+=ret[i].booknum*ret[i].bookfee;
          // }
        //   sdf.push(bookfee);

          let hello=new Array();
          hello.push(axio_display);
          hello.push(axio_data);
        
          return hello;

          // return items1;
        }
      }
    }
  }
</script>

<style scoped>

</style>
