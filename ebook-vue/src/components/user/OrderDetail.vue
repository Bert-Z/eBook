<template>
  <div id="orderdetail">
    <Card>
      <div class="obligation" style="text-align: center">
        <h2 style="color: red">Waiting for Payment</h2>
      </div>
      <br/>
      <Divider></Divider>
      <label>Order Summary</label>
      <div class="ordersummary">
        <Table border ref="selection" :columns="columns4" :data="data"></Table>
      </div>
      <Divider></Divider>
      <label>Consignee</label>
      <Table border :columns="consignee" :data="info"></Table>
      <Divider></Divider>
      <div style="text-align: right">
        <label style="color: red">Total Amount:</label>
        <div class="numbers">{{total}}$</div>
      </div>
      <Divider></Divider>
      <Row>
        <Col offset="21" span="3">
          <Button size="large" >Cancel</Button>
          <Button size="large" type="error">PayNow</Button>
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
  import {getCookie} from '../../util/util'

  export default {
    name: "OrderDetail",
    data() {
      return {
        columns4: [
          {
            title: 'Title',
            key: 'booktitle'
          },
          {
            title: 'Unit Price',
            key: 'Bookfee'
          },
          {
            title: 'Remains',
            key: 'num'
          },
          {
            title: 'Numbers',
            key: 'booknum'
          },
          {
            title: 'Action',
            key: 'action',
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
                      this.show(params.index)
                    }
                  }
                }, 'View'),
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
        data: [],
        consignee: [
          {
            title: 'Name',
            key: 'name'
          },
          {
            title: 'Age',
            key: 'age'
          },
          {
            title: 'Address',
            key: 'address'
          }
        ],
        info: [
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
          },
        ],
        total: 0,
      }
    },
    methods: {
      show(index) {
        // this.$Modal.info({
        //   title: 'User Info',
        //   content: `Name：${this.data[index].name}<br>Age：${this.data[index].age}<br>Address：${this.data[index].address}`
        // })
        this.$router.push({name:"BookDetails",query:{id:this.data[index].bookid}});
      },
      remove(index) {
        // this.data.splice(index, 1);
        var deleteitem=this.data[index];
        // console.log(deleteitem);
        var selrows=JSON.stringify(deleteitem);
        console.log(selrows);
        let data={'username':getCookie('name'),'selrows':selrows};
        this.$http.post("http://localhost:8080/api/cartdelete",data,{emulateJSON: true}
        ).then(function(res){
          // console.log(res.data);
          // console.log(this.formCustom.name);
          this.$router.go(0);
          // console.log(res);

        },function(error){
          this.$Message.error('Fail!');
          console.log(error);
        })
      },
      getcarts:function(){
        this.$http({
          method: 'GET',
          url: 'http://localhost:8080/api/getNeedPaymentOrders?username=' + getCookie('name'),
          emulateJSON: true
        }).then(
          function (response) {
            let info = response.data;
            this.checks=true;
            this.total=0;
            for(let i in info){
              let item={
                id:info[i].id,
                bookid:info[i].books[0].id,
                booktitle: info[i].books[0].booktitle,
                num:info[i].books[0].number,
                Bookfee:info[i].books[0].bookfee,
                booknum:info[i].booknum
              };

              this.total=this.total+parseFloat(info[i].booknum)*parseFloat(info[i].books[0].bookfee);

              if(info[i].books[0].number<info[i].booknum){
                this.$Message.error(info[i].books[0].booktitle+" error!");
                this.checks=false;
              }
              this.data.push(item);
            }

            // console.log(this.total);
          }, function (error) {
            console.log(error);
          })
      },
    },
    created(){
      this.getcarts();
    }
  }
</script>


<style scoped>

</style>
