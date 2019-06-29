<template>
  <div class="adminindex">
    <Row>
      <Col offset="1" span="22">
        <Card style="padding-top: 20px">
          <!--<h3 class="box-title m-b-0">Welcome</h3>-->
          <!--<Divider></Divider>-->
          <Tabs value="authorization">
            <TabPane label="权限管理" name="authorization">
              标签一的内容
              <authorization></authorization>
            </TabPane>
            <TabPane label="书籍管理" name="BookManagement">
              标签二的内容
              <book-management></book-management>
            </TabPane>
            <TabPane label="订单管理" name="OrderManagement">
              标签三的内容
              <order-management></order-management>
            </TabPane>
            <TabPane label="统计" name="Statistics">
              标签三的内容
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
