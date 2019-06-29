<template>
  <div class="adminindex">
    <Row>
      <Col offset="1" span="22">
        <Card style="padding-top: 20px">
          <!--<h3 class="box-title m-b-0">Welcome</h3>-->
          <!--<Divider></Divider>-->
          <Tabs value="authorization">
            <TabPane label="权限管理" name="authorization">
              <authorization></authorization>
            </TabPane>
            <TabPane label="书籍管理" name="BookManagement">
              <book-management></book-management>
            </TabPane>
            <TabPane label="订单管理" name="OrderManagement">
              <order-management></order-management>
            </TabPane>
            <TabPane label="统计" name="Statistics">
              <statistics></statistics>
            </TabPane>
          </Tabs>
        </Card>
      </Col>
    </Row>
  </div>
</template>

<script>
  import Authorization from "./Authorization";
  import BookManagement from "./BookManagement";
  import OrderManagement from "./OrderManagement";
  import Statistics from "./Statistics";

  export default {
    name: "AdminIndexShow",
    components: {Statistics, OrderManagement, BookManagement, Authorization}
  }
</script>

<style scoped>
  .adminindex {
    margin-top: 50px;
  }
</style>
