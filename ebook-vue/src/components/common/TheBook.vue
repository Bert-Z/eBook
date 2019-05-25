<template>
  <div class="white-box">
    <Row :gutter="16">
      <Col span="7">
        <Card>
          <div style="text-align:center">
            <img src="http://localhost:8080/images/books/book2.jpg">
          </div>
        </Card>
      </Col>
      <Col span="17">
        <br/>
        <h4 class="box-title m-t-40"><strong>{{title}}</strong></h4>
        <p>{{description}}</p>
        <br/>
        <h3 style="color: red"><strong>${{bookfee}}</strong>
          <!--<small style="color: #19be6b">(36% off)</small>-->
        </h3>
        <br/>
        <h5 class="box-title m-t-40">库存：{{remain}}</h5>
        <br/>
        <Button shape="circle" @click="modal1 = true">
          <Icon type="ios-cart" size="24"/>
        </Button>
        <Modal v-model="modal1" title="确认加入购物车" @on-ok="cartok" @on-cancel="cartcancel">
          <label>请输入加入购物车图书数量</label>
          <Input type="number" v-model="addnum"></Input>
        </Modal>

        <Button shape="circle" type="error" @click="modal2 = true">Buy Now</Button>
        <Modal v-model="modal2" title="确认购买" @on-ok="ok" @on-cancel="cancel">
          <label>请输入购买图书数量</label>
          <Input type="number" v-model="buynum"></Input>
        </Modal>
        <p/>
        <br/>
      </Col>
    </Row>
    <br>
    <Row>
      <Col span="24">
        <h3 class="box-title m-t-40"><strong>General Info</strong></h3>
        <!--<Table size="small" :items="items"></Table>-->
        <b-table :items="items"/>
      </Col>
    </Row>
  </div>
</template>

<script>
  import {getCookie} from '../../util/util'

  export default {
    name: "TheBook",
    data() {
      return {
        id:null,
        modal1: false,
        modal2: false,
        addnum: 0,
        buynum: 0,
        title: "",
        bookfee: "",
        description: "",
        ctype: "",
        remain: null,
        items: [
          {Properties: "开本", Detail: "32开"},
          {Properties: "纸张", Detail: "轻型纸"},
          {Properties: "包装", Detail: "平装-胶订"},
          {Properties: "是否套装", Detail: "是"},
          {Properties: "国际标准书号ISBN", Detail: "9787559420602"}
        ]
      }
    },
    methods: {
      getInfos: function () {
        this.$http({
          method: 'GET',
          url: 'http://localhost:8080/ebook/bookdetails?id=' + this.$route.query.id,
          emulateJSON: true
        }).then(
          function (response) {
            let info = response.data;
            this.id=info.id;
            this.title = info.booktitle;
            this.bookfee = info.bookfee;
            this.description = info.description;
            this.remain = info.number;
            this.ctype = info.category.category1 + " > " + info.category.category2;
            this.items.push({Properties: "所属分类", Detail: this.ctype});
          }, function (error) {
            console.log(error);
          })
      },
      addcart:function(){
        let data = {"id": this.id, "addnum": this.addnum,"username":getCookie('name')};
        this.$http.post('http://localhost:8080/api/addcart', data, {emulateJSON: true}
        ).then(function (res) {
          if (res.data === 1) {
            this.$Message.info('加购成功');
            this.$router.go(0);
          } else {
            this.$Message.error('失败');
          }
        }, function (error) {
          this.$Message.error('失败!');
          console.log(error);
        })
      },
      buynow: function () {
        let data = {"id": this.id, "buynum": this.buynum,"booktitle":this.title,"bookfee":this.bookfee,"username":getCookie('name')};
        this.$http.post('http://localhost:8080/api/buynow', data, {emulateJSON: true}
        ).then(function (res) {
          if (res.data === 1) {
            this.$Message.info('购买成功');
            this.$router.go(0);
          } else {
            this.$Message.error('失败');
          }
        }, function (error) {
          this.$Message.error('失败!');
          console.log(error);
        })
      },
      ok() {
        if (this.buynum <= 0) {
          this.$Message.error("错误输入");
        } else {
          if (this.remain < this.buynum) {
            this.$Message.error("库存不够");
          } else {
            this.buynow();
          }
        }
      },
      cancel() {
        this.$Message.info('取消购买');
      },
      cartok() {
        if (this.addnum <= 0) {
          this.$Message.error("错误输入");
        } else {
          if (this.remain < this.addnum) {
            this.$Message.error("库存不够");
          } else {
            this.addcart();
          }
        }
      },
      cartcancel() {
        this.$Message.info('取消加购');
      }
    },
    created() {
      this.getInfos();
    }
  }
</script>

<style>
  h1, h2, h3, h4, h5, h6 {
    color: #313131;
    font-family: Rubik, sans-serif;
    margin: 10px 0;
    font-weight: 300;
  }
</style>

<style scoped>
  .white-box {
    background: #ffffff;
    margin-left: 25px;
    margin-right: 25px;
    margin-bottom: 15px;
    padding: 25px;
  }

  .white-box .box-title {
    margin: 0 0 12px;
    font-weight: 500;
    text-transform: uppercase;
    font-size: 16px;
  }
</style>
