<template>
  <div class="Orderlist">
    <Row style="margin-bottom: 6px" type="flex" justify="center" align="middle" class="bg-title">
      <Col span="8">
        <h4 class="page-title">Order List</h4>
      </Col>
      <Col offset="8" span="8">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search...">
          <b-button-group class="input-group-btn">
            <b-button>
              <Icon type="ios-search"/>
            </b-button>
          </b-button-group>
        </div>
      </Col>
    </Row>
    <!--<Divider style="margin: 0;"></Divider>-->
    <!--<br></br>-->
    <Table :columns="columns" :data="filterData"></Table>
    <Page :total="dataCount" :page-size="pageSize" show-total @on-change="changepage"></Page>
  </div>
</template>

<script>
  import BButtonGroup from "bootstrap-vue/src/components/button-group/button-group";

  let Data = {
    "histories": []
  };

  export default {
    name: "OrderManagement",
    components: {BButtonGroup},

    data() {
      return {
        searchInput: "",
        ajaxHistoryData: [],
        // 初始化信息总条数
        dataCount: 4,
        // 每页显示多少条
        pageSize: 10,
        columns: [
          {
            title: 'Id',
            key: 'id',
            sortable: true
          },
          {
            title: 'OrderId',
            key: 'orderid',
            sortable: true
          },
          {
            title: '书名',
            key: 'booktitle',
            sortable: true
          },
          {
            title: '现价',
            key: 'bookfee',
            sortable: true
          },
          {
            title: '用户',
            key: 'user',
            sortable: true
          }
        ],
        rows: []
      }
    },
    methods: {
      mysearch() {
        // this.handleListApproveHistory(this.filterData);
      },
      changepage(index) {
        var _start = (index - 1) * this.pageSize;
        var _end = index * this.pageSize;
        this.rows = this.ajaxHistoryData.slice(_start, _end);
      },
      getAllOrders: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/admin/getAllOrders",
          emulateJSON: true
        }).then(
          function (response) {
            // console.log(response.data[1].booktitle);
            this.rows=[];
            Data.histories=response.data;
            for(let i=0;i<Data.histories.length;i++){
              Data.histories[i].user=response.data[i].user.name;
              // console.log(response.data[i].user.name);
            }
            // console.log(c);
            this.handleListApproveHistory(Data.histories);
          }, function (error) {
            console.log(error);
          }
        )
      },
      handleListApproveHistory: function (Input) {
        // 保存取到的所有数据
        this.ajaxHistoryData = Input;
        this.dataCount = Input.length;
        // 初始化显示，小于每页显示条数，全显，大于每页显示条数，取前每页条数显示
        if (Input.length < this.pageSize) {
          this.rows = this.ajaxHistoryData;
        } else {
          this.rows = this.ajaxHistoryData.slice(0, this.pageSize);
        }
      },
    },
    mounted() {
      this.getAllOrders();
    },
    computed: {
      filterData: {
        get:function() {
          let searchInput = this.searchInput && this.searchInput.toLowerCase();
          let rows = this.rows;
          let items1;
          if (searchInput) {
            items1 = rows.filter(function (item) {
              return Object.keys(item).some(function (key) {
                return String(item[key]).toLowerCase().match(searchInput)
              })
            })
          } else {
            items1 = this.rows;
          }
          return items1;
        }
      }
    }
  }
</script>

<style scoped>

</style>
