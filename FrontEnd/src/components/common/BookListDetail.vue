<template>
  <div class="Booklist">
    <Row style="margin-bottom: 6px" type="flex" justify="center" align="middle" class="bg-title">
      <Col span="24">
        <h4 class="page-title">Book List</h4>
      </Col>
      <!--<Col offset="8" span="8">-->
        <!--<div class="input-group">-->
          <!--<input type="text" class="form-control" placeholder="Search...">-->
          <!--<b-button-group class="input-group-btn">-->
            <!--<b-button>-->
              <!--<Icon type="ios-search"/>-->
            <!--</b-button>-->
          <!--</b-button-group>-->
        <!--</div>-->
      <!--</Col>-->
    </Row>
    <Divider style="margin: 0;"></Divider>
    <br/>
    <mdb-datatable
      :data="data"
      striped
      bordered
      arrows
    >

    </mdb-datatable>
  </div>
</template>

<script>
  import { mdbDatatable } from 'mdbvue';
  export default {
    name: 'DatatablePage',
    components: {
      mdbDatatable
    },
    methods: {
      seetype: function () {
        console.log(this.$route.params.category);
      },
      getBookListByCategory: function () {
        this.$http({
          method: "GET",
          url: "http://localhost:8080/ebook/"+this.$route.params.category,
          emulateJSON: true
        }).then(
          function (response) {
            console.log(response.data[1].booktitle);
            // console.log(this.data.rows);
            var c=0;
            for(var item in response.data){
              var i={
                "booktitle":response.data[item].booktitle,
                "type":response.data[item].type,
                "bookfee":response.data[item].bookfee,
                "discount":response.data[item].discount,
                "number":response.data[item].number,
                "createtime":response.data[item].createtime,
                "updatetime":response.data[item].updatetime,
              }

              this.data.rows.push(i);
            }
            // console.log(c);
          }, function (error) {
            console.log(error);
          }
        )
      }
    },
    data() {
      return {
        data: {
          columns: [
            {
              label: '书名',
              field: 'booktitle',
              sort: 'asc'
            },
            {
              label: '类型',
              field: 'type',
              sort: 'asc'
            },
            {
              label: '现价',
              field: 'bookfee',
              sort: 'asc'
            },
            {
              label: '折扣',
              field: 'discount',
              sort: 'asc'
            },
            {
              label: '库存',
              field: 'number',
              sort: 'asc'
            },
            {
              label: '上架日期',
              field: 'createtime',
              sort: 'asc'
            },
            {
              label: '更新日期',
              field: 'updatetime',
              sort: 'asc'
            }
          ],
          rows: []
        }
      }
    },
    created() {
      this.getBookListByCategory();
    },
  }
</script>

<style scoped>
  .bg-title h4 {
    text-transform: uppercase;
    font-size: 14px;
    font-weight: 500;
    margin-top: 6px;
  }

  .bg-title {
    overflow: hidden;
    padding: 15px 10px 9px;
    margin-bottom: 25px;

  }
</style>
