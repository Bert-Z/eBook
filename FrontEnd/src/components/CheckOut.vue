<template>
  <div id="checkout" class="layout">
    <Layout>
      <Header style="width: 100%;background: #fff;padding: 0">
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <OrderDetail></OrderDetail>
      </Content>

      <Footer>
        <my-footer></my-footer>
      </Footer>

    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import IndexNav from "./common/IndexNav";
  import MyFooter from "./common/MyFooter";
  import OrderDetail from "./user/OrderDetail";

  export default {
    name: "CheckOut",
    components: {OrderDetail, MyFooter, IndexNav, CommonNav},
    data() {
      return {
        user: true,
      }
    }
  }
</script>

<style scoped>

</style>
