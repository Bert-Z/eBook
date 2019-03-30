<template>
  <div id="checkout" class="layout">
    <Layout>
      <Header>
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <IndexNav style="z-index:2;position: relative;margin-top: -4px;margin-bottom: 10px;"></IndexNav>
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
