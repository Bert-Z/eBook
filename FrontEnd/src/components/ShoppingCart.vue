<template>
  <div id="shoppingcart" class="layout">
    <Layout>
      <Header style="width: 100%;background: #fff;padding: 0">
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <shopping-cart-orders></shopping-cart-orders>
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
  import ShoppingCartOrders from "./user/ShoppingCartOrders";

  export default {
    name: "ShoppingCart",
    components: {ShoppingCartOrders, MyFooter, IndexNav, CommonNav},
    data: function () {
      return {
        user: true,

    }
    }
  }
</script>

<style scoped>

</style>
