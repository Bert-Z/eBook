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
    <Button type="primary" @click="newbook">Add Book</Button>
    <Page :total="dataCount" :page-size="pageSize" show-total @on-change="changepage"></Page>
    
  </div>
</template>

<script>
  let Data = {
    "histories": []
  };

  export default {
    name: "BookManagement",
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
            title: '书名',
            key: 'booktitle',
            sortable: true
          },
          {
            title: '类型',
            key: 'type',
            sortable: true
          },
          {
            title: '现价',
            key: 'bookfee',
            sortable: true
          },
          {
            title: '折扣',
            key: 'discount',
            sortable: true
          },
          {
            title: '库存',
            key: 'number',
            sortable: true
          },
          {
            title: '上架日期',
            field: 'createtime',
            sortable: true
          },
          {
            title: '更新日期',
            key: 'updatetime',
            sortable: true
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
                }, 'view'),
                h('Button', {
                  props: {
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.modifydetail(params.index)
                    }
                  }
                }, 'modify'),
                h('Button', {
                  props: {
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.remove(params.index)
                    }
                  }
                }, 'Delete')
              ]);
            }
          }
        ],
        rows: []
      }
    },
    methods: {
      newbook(){
        this.$router.push({name:'editbook'});
      },
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
      modifydetail:function(index) {
        
        this.$router.push({name:'editbook',query:{id:this.rows[index].id}});
      },
      changepage(index) {
        var _start = (index - 1) * this.pageSize;
        var _end = index * this.pageSize;
        this.rows = this.ajaxHistoryData.slice(_start, _end);
      },
      getAllBooks: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/admin/getAllBooks",
          emulateJSON: true
        }).then(
          function (response) {
            // console.log(response.data[1].booktitle);
            Data.histories=response.data;
            // console.log(c);
            this.handleListApproveHistory(Data.histories);
          }, function (error) {
            console.log(error);
          }
        )
      },
      remove(index) {
        // console.log(this.rows[index].id);
        // console.log(this.rows[index].booktitle);
        var bookid=this.rows[index].id;
        // console.log(selrows);
        let data={'bookid':bookid};
        this.$http.post("http://localhost:8080/admin/deleteBook",data,{emulateJSON: true}
        ).then(function(res){
          this.$Message.success('Success!');
          this.getAllBooks();
          // console.log(res);

        },function(error){
          this.$Message.error('Delete Fail!');
          console.log(error);
        })
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
      this.getAllBooks();
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
