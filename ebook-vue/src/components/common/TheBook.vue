<template>
<div class="white-box">
  <Row :gutter="16">
    <Col span="7">
      <Card>
        <div style="text-align:center">
          <img src="../../assets/images/books/book2.jpg">
        </div>
      </Card>
    </Col>
    <Col span="17">
      <br/>
      <h4 class="box-title m-t-40"><strong>Book description</strong></h4>
      <p>Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. but the majority have suffered alteration in some form, by injected humour</p>
      <br/>
      <h3>
        $153
        <small style="color: #19be6b">(36% off)</small>
      </h3>
      <br/>
      <Button shape="circle"><Icon type="ios-cart" size="24" /></Button>
      <Button shape="circle" type="error">Buy Now</Button>
      <p/>
      <br/>
      <!--<h3 class="box-title m-t-40">Key Highlights</h3>-->
      <!--<b-list-group>-->
        <!--<b-list-group-item>Cras justo odio</b-list-group-item>-->
        <!--<b-list-group-item>Dapibus ac facilisis in</b-list-group-item>-->
        <!--<b-list-group-item>Morbi leo risus</b-list-group-item>-->
        <!--<b-list-group-item>Porta ac consectetur ac</b-list-group-item>-->
        <!--<b-list-group-item>Vestibulum at eros</b-list-group-item>-->
      <!--</b-list-group>-->
    </Col>
  </Row>
  <br>
  <Row>
    <Col span="24">
      <h3 class="box-title m-t-40"><strong>General Info</strong></h3>
      <!--<Table size="small" :items="items"></Table>-->
      <b-table :items="items" />
    </Col>
  </Row>
</div>
</template>

<script>
    export default {
        name: "TheBook",
      data () {
        return {
          items: [
            { Properties: "开本", Detail: "32开"},
            { Properties: "纸张", Detail: "轻型纸"},
            { Properties: "包装", Detail: "平装-胶订" },
            { Properties: "是否套装", Detail: "是" },
            { Properties: "国际标准书号ISBN", Detail: "9787559420602" },
            { Properties: "所属分类", Detail: "图书>小说>历史" }
          ]
        }
      }
    }
</script>

<style>
  h1, h2, h3, h4, h5, h6 {
    color: #313131;
    font-family: Rubik,sans-serif;
    margin: 10px 0;
    font-weight: 300;
  }
</style>

<style scoped>
.white-box{
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
