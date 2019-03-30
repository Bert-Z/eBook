<template>
  <div id="shoppingcart" class="layout">
    <Layout>
      <Header>
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <IndexNav style="z-index:2;position: relative;margin-top: -4px;margin-bottom: 10px;"></IndexNav>
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
