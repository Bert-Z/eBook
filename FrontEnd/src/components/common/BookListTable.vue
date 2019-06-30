<template>
  <div class="Booklist">
    <Row style="margin-bottom: 6px" type="flex" justify="center" align="middle" class="bg-title">
      <Col span="8">
        <h4 class="page-title">Book List</h4>
      </Col>
      <Col offset="8" span="8">
        <div class="input-group">
          <input v-model="searchInput" type="text" class="form-control" placeholder="Search...">
          <b-button-group class="input-group-btn">
            <b-button>
              <Icon @click="mysearch" type="ios-search"/>
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
  let Data = {
    "histories": []
  };

  export default {
    name: "Book",
    data() {
      return {
        searchInput: "",
        ajaxHistoryData: [],
        // 初始化信息总条数
        dataCount: 4,
        // 每页显示多少条
        pageSize: 25,
        columns: [
          {
            title: '书名',
            key: 'booktitle'
          },
          {
            title: '类型',
            key: 'category'
          },
          {
            title: '现价',
            key: 'bookfee'
          },
          {
            title: '折扣',
            key: 'discount',
          },
          {
            title: '库存',
            key: 'number',
          },
          {
            title: '上架日期',
            field: 'createtime',
          },
          {
            title: '更新日期',
            key: 'updatetime',
          },
          {
            title: 'Action',
            key: 'action',
            width: 150,
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.viewdetail(params.index)
                    }
                  }
                }, 'View')
              ]);
            }
          }
        ],
        rows: []
      }
    },
    methods: {
      mysearch() {
        // this.handleListApproveHistory(this.filterData);
      },
      viewdetail:function(index) {
        // this.$Modal.info({
        //   title: 'User Info',
        //   content: `Name：${this.rows[index].name}<br>id：${this.rows[index].id}<br>Address：${this.rows[index].address}`
        // })
        this.$router.push({name:'BookDetails',query:{id:this.rows[index].id}});
      },
      changepage(index) {
        var _start = (index - 1) * this.pageSize;
        var _end = index * this.pageSize;
        this.rows = this.ajaxHistoryData.slice(_start, _end);
      },
      getBookListByCategory: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/ebook/" + this.$route.params.category,
          emulateJSON: true
        }).then(
          function (response) {
            // console.log(response.data[1].booktitle);
            var ret=response.data;
            for(var dataitem in ret){
              ret[dataitem].category=ret[dataitem].category.category1+" > "+ret[dataitem].category.category2;
            }
            Data.histories=ret;
            // console.log(c);
            this.handleListApproveHistory(Data.histories);
          }, function (error) {
            console.log(error);
          }
        )
      },
      remove(index) {
        this.rows.splice(index, 1);
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
    created() {
      this.getBookListByCategory();
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
